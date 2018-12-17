在微信公众号开发者文档中是这样子定义accessToken的：
	access_token是公众号的全局唯一接口调用凭据，公众号调用各接口时都需使用access_token。开发者需要进行妥善保存。access_token的存储至少要保留512个字符空间。
	access_token的有效期目前为2个小时，需定时刷新，重复获取将导致上次获取的access_token失效。主要是在调用很多微信接口的时候需要使用到accessToken作为凭证，
	所以说这个东西是微信公众号开发时必须进行获取的！

逻辑：
	所以说这儿呢最好在项目启动的时候进行accessToken的获取，并每两个小时重新获取一次以避免accessToken失效，我使用的是定义一个线程，在一个servlet中进行调用，并在项
	目启动的时候启动该线程，在线程中每隔两个小时重新请求一个微信服务器更新accessToken

1、定义一个Access_Token类存储accessToken的信息：
	private String access_token;		//获取到的access_token
	private int	expires_in;		//有效时间（两个小时，7200s）

2、编写AccessTokenUtil获取accessToken
	/**
	 * 获取accessToken
	 * @param appID		微信公众号凭证
	 * @param appScret	微信公众号凭证秘钥
	 * @return
	 */
	public static AccessToken getAccessToken(String appID, String appScret) {
		AccessToken token = new AccessToken();
		// 访问微信服务器
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
	
3、定义TokenThread线程，调用Util获取accessToken，请求时需要使用微信公众号的凭证和秘钥（微信公众号后台可以查看）。
	public class TokenThread implements Runnable{

		//微信公众号的凭证和秘钥
		public static final String appID = "wx3e4a89adbc62b1f9";
		public static final String appScret = "1cafcbae8abed2fb0ba31394509c12c9";
		public static AccessToken access_token=null;		
		
		@Override
		public void run() {
			while(true){
				try {
					//调用工具类获取access_token(每日最多获取100000次，每次获取的有效期为7200秒)
					access_token=AccessTokenUtil.getAccessToken(appID, appScret);		
					if(null!=access_token){
						System.out.println("accessToken获取成功："+access_token.getExpires_in());
						//7000秒之后重新进行获取
						Thread.sleep((access_token.getExpires_in()-200)*1000);
					}else{
						//获取失败时，60秒之后尝试重新获取
						Thread.sleep(60*1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	
}
	
4、编写servlet并在servlet初始化时启动该线程
	public class GetAccessTokenServlet extends HttpServlet{
		private static final long serialVersionUID = 1L;

		@Override
		public void init() throws ServletException {
			new Thread(new TokenThread()).start();		//启动定时获取access_token的线程
		}
	}

5、在项目启动的时候启动该servlet，OK！
  	<!-- 启动时加载servlet获取accessToken -->
  	<servlet>
  		<servlet-name>loadServlet</servlet-name>
 		<servlet-class>msun.wechat.controller.link.GetAccessTokenServlet</servlet-class>
 	 	<load-on-startup>1</load-on-startup>
  	</servlet>





















