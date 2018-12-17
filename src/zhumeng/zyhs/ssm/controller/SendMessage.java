package zhumeng.zyhs.ssm.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.sf.json.JSONObject;
import zhumeng.zyhs.ssm.tools.HttpReturn;

@Controller
@RequestMapping("/SendMessage")
public class SendMessage {
	
	@RequestMapping(value="/sendMessage",method=RequestMethod.POST)
	public void sendMessage(HttpServletResponse response, @RequestBody String phone) throws IOException{
	String yan = SendMessage.createRandomVcode();
	String content = "尊敬的用户，您此次操作的验证码为："+yan; 
	String sign="筑梦工作室";
	
	// 创建StringBuffer对象用来操作字符串
	StringBuffer sb = new StringBuffer("http://sms.1xinxi.cn/asmx/smsservice.aspx?");

	// 向StringBuffer追加用户名
	sb.append("name=15274452830");

	// 向StringBuffer追加密码（登陆网页版，在管理中心--基本资料--接口密码，是28位的）
	sb.append("&pwd=B6BCF24D92C58B479A05BEB6AB70");

	// 向StringBuffer追加手机号码
	sb.append("&mobile="+phone);

	// 向StringBuffer追加消息内容转URL标准码
	sb.append("&content="+URLEncoder.encode(content,"UTF-8"));
	
	//追加发送时间，可为空，为空为及时发送
	sb.append("&stime=");
	
	//加签名
	sb.append("&sign="+URLEncoder.encode(sign,"UTF-8"));
	
	//type为固定值pt  extno为扩展码，必须为数字 可为空
	sb.append("&type=pt&extno=");
	// 创建url对象
	//String temp = new String(sb.toString().getBytes("GBK"),"UTF-8");
	System.out.println("sb:"+sb.toString()); 
	URL url = new URL(sb.toString());

	// 打开url连接
	HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	// 设置url请求方式 ‘get’ 或者 ‘post’
	connection.setRequestMethod("POST");

	// 发送
	InputStream is =url.openStream();

	//转换返回值
	String returnStr = SendMessage.convertStreamToString(is);
	
	// 返回结果为‘0，20140009090990,1，提交成功’ 发送成功   具体见说明文档
	System.out.println(returnStr);
	// 返回发送结果
	System.out.println(yan);
	HttpReturn.reponseBody(response, yan);
     // return yan;
      //JSONObject jsonObject = JSONObject.fromObject(yan);
     
	}
    
	public void addsuccess(String phone,String name) throws IOException{
		String content = "尊敬的"+name+",恭喜您已经成功注册为筑梦资源回收的回收员，祝您在以后的工作中一帆风顺，天天发大财！"; 
		String sign="筑梦资源回收";
		
		// 创建StringBuffer对象用来操作字符串
		StringBuffer sb = new StringBuffer("http://sms.1xinxi.cn/asmx/smsservice.aspx?");

		// 向StringBuffer追加用户名
		sb.append("name=15274452830");

		// 向StringBuffer追加密码（登陆网页版，在管理中心--基本资料--接口密码，是28位的）
		sb.append("&pwd=B6BCF24D92C58B479A05BEB6AB70");

		// 向StringBuffer追加手机号码
		sb.append("&mobile="+phone);

		// 向StringBuffer追加消息内容转URL标准码
		sb.append("&content="+URLEncoder.encode(content,"UTF-8"));
		
		//追加发送时间，可为空，为空为及时发送
		sb.append("&stime=");
		
		//加签名
		sb.append("&sign="+URLEncoder.encode(sign,"UTF-8"));
		
		//type为固定值pt  extno为扩展码，必须为数字 可为空
		sb.append("&type=pt&extno=");
		// 创建url对象
		//String temp = new String(sb.toString().getBytes("GBK"),"UTF-8");
		System.out.println("sb:"+sb.toString()); 
		URL url = new URL(sb.toString());

		// 打开url连接
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// 设置url请求方式 ‘get’ 或者 ‘post’
		connection.setRequestMethod("POST");

		// 发送
		InputStream is =url.openStream();

		//转换返回值
		String returnStr = SendMessage.convertStreamToString(is);
		
		// 返回结果为‘0，20140009090990,1，提交成功’ 发送成功   具体见说明文档
		System.out.println(returnStr);
		// 返回发送结果
		

	}
 public static String createRandomVcode(){  
        //验证码  
        String vcode = "";  
        for (int i = 0; i < 6; i++) {  
            vcode = vcode + (int)(Math.random() * 9);  
        }  
        return vcode;  
    }  
/**
 * 转换返回值类型为UTF-8格式.
 * @param is
 * @return
 */
public static String convertStreamToString(InputStream is) {    
    StringBuilder sb1 = new StringBuilder();    
    byte[] bytes = new byte[4096];  
    int size = 0;  
    
    try {    
    	while ((size = is.read(bytes)) > 0) {  
            String str = new String(bytes, 0, size, "UTF-8");  
            sb1.append(str);  
        }  
    } catch (IOException e) {    
        e.printStackTrace();    
    } finally {    
        try {    
            is.close();    
        } catch (IOException e) {    
           e.printStackTrace();    
        }    
    }    
    return sb1.toString();    
}
}
