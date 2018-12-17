��΢�Ź��ںſ������ĵ����������Ӷ���accessToken�ģ�
	access_token�ǹ��ںŵ�ȫ��Ψһ�ӿڵ���ƾ�ݣ����ںŵ��ø��ӿ�ʱ����ʹ��access_token����������Ҫ�������Ʊ��档access_token�Ĵ洢����Ҫ����512���ַ��ռ䡣
	access_token����Ч��ĿǰΪ2��Сʱ���趨ʱˢ�£��ظ���ȡ�������ϴλ�ȡ��access_tokenʧЧ����Ҫ���ڵ��úܶ�΢�Žӿڵ�ʱ����Ҫʹ�õ�accessToken��Ϊƾ֤��
	����˵���������΢�Ź��ںſ���ʱ������л�ȡ�ģ�

�߼���
	����˵������������Ŀ������ʱ�����accessToken�Ļ�ȡ����ÿ����Сʱ���»�ȡһ���Ա���accessTokenʧЧ����ʹ�õ��Ƕ���һ���̣߳���һ��servlet�н��е��ã�������
	Ŀ������ʱ���������̣߳����߳���ÿ������Сʱ��������һ��΢�ŷ���������accessToken

1������һ��Access_Token��洢accessToken����Ϣ��
	private String access_token;		//��ȡ����access_token
	private int	expires_in;		//��Чʱ�䣨����Сʱ��7200s��

2����дAccessTokenUtil��ȡaccessToken
	/**
	 * ��ȡaccessToken
	 * @param appID		΢�Ź��ں�ƾ֤
	 * @param appScret	΢�Ź��ں�ƾ֤��Կ
	 * @return
	 */
	public static AccessToken getAccessToken(String appID, String appScret) {
		AccessToken token = new AccessToken();
		// ����΢�ŷ�����
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appID + "&secret="
				+ appScret;
		try {
			URL getUrl=new URL(url);
			HttpURLConnection http=(HttpURLConnection)getUrl.openConnection();
			http.setRequestMethod("GET"); 
			http.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);

			http.connect();
			InputStream is = http.getInputStream(); 
			int size = is.available(); 
			byte[] b = new byte[size];
			is.read(b);

			String message = new String(b, "UTF-8");
			
			JSONObject json = JSONObject.fromObject(message);

			token.setAccess_token(json.getString("access_token"));
			token.setExpires_in(new Integer(json.getString("expires_in")));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return token;
	}
	
3������TokenThread�̣߳�����Util��ȡaccessToken������ʱ��Ҫʹ��΢�Ź��ںŵ�ƾ֤����Կ��΢�Ź��ںź�̨���Բ鿴����
	public class TokenThread implements Runnable{

		//΢�Ź��ںŵ�ƾ֤����Կ
		public static final String appID = "wx3e4a89adbc62b1f9";
		public static final String appScret = "1cafcbae8abed2fb0ba31394509c12c9";
		public static AccessToken access_token=null;		
		
		@Override
		public void run() {
			while(true){
				try {
					//���ù������ȡaccess_token(ÿ������ȡ100000�Σ�ÿ�λ�ȡ����Ч��Ϊ7200��)
					access_token=AccessTokenUtil.getAccessToken(appID, appScret);		
					if(null!=access_token){
						System.out.println("accessToken��ȡ�ɹ���"+access_token.getExpires_in());
						//7000��֮�����½��л�ȡ
						Thread.sleep((access_token.getExpires_in()-200)*1000);
					}else{
						//��ȡʧ��ʱ��60��֮�������»�ȡ
						Thread.sleep(60*1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	
}
	
4����дservlet����servlet��ʼ��ʱ�������߳�
	public class GetAccessTokenServlet extends HttpServlet{
		private static final long serialVersionUID = 1L;

		@Override
		public void init() throws ServletException {
			new Thread(new TokenThread()).start();		//������ʱ��ȡaccess_token���߳�
		}
	}

5������Ŀ������ʱ��������servlet��OK��
  	<!-- ����ʱ����servlet��ȡaccessToken -->
  	<servlet>
  		<servlet-name>loadServlet</servlet-name>
 		<servlet-class>msun.wechat.controller.link.GetAccessTokenServlet</servlet-class>
 	 	<load-on-startup>1</load-on-startup>
  	</servlet>





















