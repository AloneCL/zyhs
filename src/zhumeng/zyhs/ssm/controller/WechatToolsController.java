package zhumeng.zyhs.ssm.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.sf.json.JSONObject;
import zhumeng.zyhs.ssm.tools.HttpReturn;
import zhumeng.zyhs.wechat.link.TokenThread;

@Controller
@RequestMapping("/wechat")
public class WechatToolsController {

	@RequestMapping(value = "/getImage", method = RequestMethod.POST)
	public void getImage(HttpServletResponse response) throws Exception {
		TokenThread th = new TokenThread();
		//int hint=0;
 		String rPath = null;               //最终返回的结果  二维码在服务器的路径
		Map<String, Object> map = new HashMap();
		Map<String, String> map1 = new HashMap();
		map.put("path", "pages/StartPage/StartPage");   //代表第几个页面
		map.put("width", 430);                          //二维码宽度
		JSONObject json = JSONObject.fromObject(map);
		String access_token = th.getToken();
		//System.out.println(access_token);
		String url = "https://api.weixin.qq.com/cgi-bin/wxaapp/createwxaqrcode?access_token=" + access_token;
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json");
		StringEntity se = new StringEntity(json.toString());
		se.setContentType("application/json");
		se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "UTF-8"));
		httpPost.setEntity(se);
		// httpClient.execute(httpPost);
		HttpResponse response1 = httpClient.execute(httpPost);
		if (response != null) {
			HttpEntity resEntity = response1.getEntity();
			if (resEntity != null) {
				InputStream instreams = resEntity.getContent();
				String path = System.getProperty("evan.webapp");      //获取项目的根目录的相对路径
				String path1 = "../zyhsUpload/img1/";
				File saveFile = new File(path+path1 + "1" + ".jpg");
				// 判断这个文件（saveFile）是否存在
				if (!saveFile.getParentFile().exists()) {
					// 如果不存在就创建这个文件夹
					saveFile.getParentFile().mkdirs();
				}
				//System.out.println(saveFile.getAbsolutePath());
				 File file=new File(path+path1,"1.jpg");//可以是任何图片格式.jpg,.png等  
			       System.out.println(file.getPath());
				 FileOutputStream fos=new FileOutputStream(file);
			       if(instreams != null){  
			           try {  
			                                   
			               byte[] b = new byte[1024];  
			               int nRead = 0;  
			               while ((nRead = instreams.read(b)) != -1) {  
			                   fos.write(b, 0, nRead);  
			               } 
			               System.out.println("运行成功");
			                                
			           } catch (Exception e) {  
			              // stateInt = 0;  
			               e.printStackTrace();  
			           } finally {  
			                 
			               try {  
			                   fos.flush();  
			                   fos.close();  
			            } catch (IOException e) {  
			                e.printStackTrace();  
			            }   
			           } 
			           rPath = file.getPath();
			       }  
			}
		}
		map1.put("path",rPath);
		
		JSONObject jsonObject = new JSONObject().fromObject(map1);
		HttpReturn.reponseBody(response, jsonObject);
	}
}
