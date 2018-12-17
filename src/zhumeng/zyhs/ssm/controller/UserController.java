package zhumeng.zyhs.ssm.controller;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import zhumeng.zyhs.ssm.pojo.User;
import zhumeng.zyhs.ssm.tools.HttpReturn;
import zhumeng.zyhs.web.service.UserService;


@Controller
@RequestMapping("/User")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/getAll",method=RequestMethod.POST)
	public void getAll(HttpServletResponse response) throws IOException{

		System.out.println("fwefwef");
		List<User> users = userService.getALL();
		
		JSONArray jsonArray;
		jsonArray = JSONArray.fromObject(users);

		HttpReturn.reponseBody(response, jsonArray);
	}
	
	@RequestMapping(value="/get",method=RequestMethod.POST)
	public void getHoPeAct1(HttpServletResponse response, @RequestBody User user) throws IOException{

		User userInfo = null;
		System.out.println(user.toString());
		userInfo = userService.getUserInfo(user);
		//System.out.println(userInfo);
		// ת��ΪJSONObject����
		JSONObject jsonObject = new JSONObject().fromObject(userInfo);
         System.out.println(jsonObject);
		HttpReturn.reponseBody(response, jsonObject);
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void add(HttpServletResponse response, @RequestBody User user) throws IOException{

		int hint;
		System.out.println(user);
		// 注册时判断用户注册手机号是否已存在 已存在则返回0  未注册直接注册成功返回1
		if(userService.alive(user) != 0){
			hint = 0;
		}
		else{
			//user.setIdentity(1);
			if(user.getIdentity()==1){
				user.setIdentity(2);
			}
			hint = userService.add(user);
		}
		HttpReturn.reponseBody(response, String.valueOf(hint));
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public void login(HttpServletResponse response, @RequestBody User user) throws IOException{

		int hint=0;
		//System.out.println(user.toString());
		//System.out.println("---------");
		//判断用户登录的几种状态  -2为账号未注册    返回-1表示用户注册正在审核中  0表示账号密码错误 正确则返回用户id
 		if(userService.alive(user)==0){
		   	hint = -2;                    
		}		
		else {
			hint = userService.login(user);
			User u  = new User();
			u.setId(hint);
			
			if(hint!=0&&userService.getUserInfo(u).getIdentity()==2){
				hint = -1;
			}
			System.out.println(hint+"++++++++++++++");

		}
		
		HttpReturn.reponseBody(response, String.valueOf(hint));
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public void update(HttpServletResponse response, @RequestBody User user) throws IOException{

		int hint;
		System.out.println(user.toString());
		hint = userService.update(user);

		HttpReturn.reponseBody(response, String.valueOf(hint));
	}
	
	@RequestMapping(value="/updateByUserTel",method=RequestMethod.POST)
	public void updateByUserTel(HttpServletResponse response, @RequestBody User user) throws IOException{

		int hint;
		System.out.println(user.toString());
		hint = userService.updateByUserTel(user);

		HttpReturn.reponseBody(response, String.valueOf(hint));
	}
	
}
