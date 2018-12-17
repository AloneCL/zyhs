package zhumeng.zyhs.ssm.controller;


import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import zhumeng.zyhs.ssm.converter.DateConverter;
import zhumeng.zyhs.ssm.pojo.HotImage;
import zhumeng.zyhs.ssm.tools.HttpReturn;
import zhumeng.zyhs.web.service.HotImageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/HotImage")
public class HotImageController {
	
	@Autowired
	private  HotImageService hotImageService;
	
	
	@RequestMapping(value="/get",method=RequestMethod.POST)
	public void add(HttpServletResponse response) throws IOException{
        
		System.out.println("dfwefewf");
		HotImage himage = hotImageService.getInfo();
		JSONObject jsonObject = new JSONObject().fromObject(himage);

		HttpReturn.reponseBody(response, jsonObject);
	}
	
	@RequestMapping(value="/inputImage",method=RequestMethod.POST)
	public void inputImage(@RequestParam MultipartFile picture,HttpServletRequest request,HttpServletResponse response) throws IOException{
		Map<String, String> map=new HashMap<String, String>();
		//InputStream inputStream;
		DateConverter date = new DateConverter();
		Random rand = new Random();
		String path1 = System.getProperty("evan.webapp");
		System.out.println(path1);
		String path2 = "../zyhsUpload/img/"+date.convert(new Date());
		String path = path1+path2;
		File file = new File(path);
		if(!file.exists()){
		file.mkdirs();
		}
		//System.out.println(file);
		String img = System.currentTimeMillis()+(int)Math.random()*1000000+".jpg";
		System.out.println(path2+img);
		//inputStream = request.getInputStream();
		//File file
		FileOutputStream output = new FileOutputStream(new File(file,img));
	/*	byte[] bbuf = new byte[1024];
		int hasread;
		while((hasread = inputStream.read(bbuf))>0){
		     output.write(bbuf, 0, hasread);
		}*/
		output.write(picture.getBytes());
		output.close();
		 map.put("path",path2+img);
		 JSONObject jsonObject = new JSONObject().fromObject(map);
	    HttpReturn.reponseBody(response,jsonObject);
	}
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	//MultipartFile就是封装了图片文件
	public void upload(@RequestParam MultipartFile[] picture,HttpServletRequest request,HttpServletResponse response) throws IOException{
		Map<String, String> map=new HashMap<String, String>();
		DateConverter date = new DateConverter();
		String path1 = System.getProperty("evan.webapp");
		System.out.println(path1);
		String path2 = "../zyhsUpload/img/"+date.convert(new Date());
		String path=path1+path2;
		System.out.println(path);
		    //创建文件 
		    File dir=new File(path);
		    if(!dir.exists()){
		        dir.mkdirs();
		    }
			
		    for(int i=0;i<picture.length;i++){
			Random rand = new Random();
		    String img= System.currentTimeMillis()+(int)Math.random()*1000000+".jpg";//zhao.jpg
		    FileOutputStream imgOut=new FileOutputStream(new File(dir,img));//根据 dir 抽象路径名和 img 路径名字符串创建一个新 File 实例。
            // System.out.println(imgOut);		   
		    /* System.out.println(file.getBytes());*/
		    imgOut.write(picture[i].getBytes());//返回一个字节数组文件的内容
		    imgOut.close();
		   
		    map.put("path"+i,path2+"/"+img);
		    }
		    
		    JSONObject jsonObeject = new JSONObject().fromObject(map);
		    HttpReturn.reponseBody(response, jsonObeject);
	}
}
