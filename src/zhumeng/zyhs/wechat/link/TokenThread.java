package zhumeng.zyhs.wechat.link;



public class TokenThread implements Runnable{

		//微信公众号的凭证和秘钥
		public static final String appID = "wx2b3deb1135697ff7";
		public static final String appScret = "b448a05320c435f9da56f35c29dedb0d";
		public static AccessToken access_token=null;		
		
		public String getToken(){
			access_token=AccessTokenUtil.getAccessToken(appID, appScret);
			return access_token.getAccess_token();
		}
		@Override
		public void run() {
			while(true){
				try {
					//调用工具类获取access_token(每日最多获取2000次，每次获取的有效期为7200秒)
					access_token=AccessTokenUtil.getAccessToken(appID, appScret);		
					if(null!=access_token){
					
						System.out.println("accessToken获取成功："+access_token.getExpires_in());
						System.out.println("accessToken值为："+access_token.getAccess_token());
						//7000秒之后重新进行获取
						Thread.sleep((access_token.getExpires_in()-200)*1000);
					}else{
						//60秒之后尝试重新获取
						Thread.sleep(60*1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	
}
