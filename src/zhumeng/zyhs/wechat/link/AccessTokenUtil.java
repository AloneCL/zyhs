package zhumeng.zyhs.wechat.link;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.client.methods.HttpPost;

import net.sf.json.JSONObject;

public class AccessTokenUtil {
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
}
