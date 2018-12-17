package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zhumeng.zyhs.ssm.controller.SendMessage;
import zhumeng.zyhs.ssm.pojo.User;
import zhumeng.zyhs.web.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-mvc.xml"})
public class Test {
    
	@Autowired
	private UserService userService;
	
	@org.junit.Test
   public void getAll(){
	  List<User> u = new ArrayList<>();
	  u = userService.getALL();
	  for (User user : u) {
		System.out.println(user);
	}
   }
	
	@org.junit.Test
	   public void insert(){
		 User u = new User();
		 u.setAddress("湖南省长沙市");
		 u.setUserName("张三");
		 u.setUserPass("1231234");
		 userService.add(u);
		}
	
	@org.junit.Test
	   public void dele(){
		User u = new User();
		u.setUserTel("15274452320");
		 System.out.println(userService.alive(u));
		}
	
	@org.junit.Test
	   public void update(){
		User u  = new User();
		User u1;
		u.setId(3);
		u1 = userService.getUserInfo(u);
		System.out.println(u1);
		u1.setProvince("hunan");
		u1.setCity("海南");
		userService.update(u1);
		//userService.add(u1);
		System.out.println(u1);
		}
	
	public void add(){
		User u = new User();
		User u1;	
		u.setId(1);
		u1 = userService.getUserInfo(u);
		//u.setUserName("陈磊");
		//u.setUserTel("1527445");
		userService.add(u1);
	}
	
	@org.junit.Test 
	public void testIdentity(){
	    Map map = new HashMap();
	    map.put("page", 1);
	    map.put("identity", 1);
		List<User> u = userService.getByIdentity(map);
		for (User user : u) {
			System.out.println(user);
		}
	}
	@org.junit.Test 
	public void sendTest() throws IOException{
		SendMessage sm = new SendMessage();
		sm.addsuccess("15274455702", "瓜皮伴");
		System.out.println("发送成功");
	}
}
