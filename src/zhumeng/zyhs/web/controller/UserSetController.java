package zhumeng.zyhs.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import zhumeng.zyhs.ssm.controller.SendMessage;
import zhumeng.zyhs.ssm.pojo.User;
import zhumeng.zyhs.web.service.UserService;

@Controller
public class UserSetController {
    
	@Autowired
	private UserService userService;
	
	@RequestMapping("/setUser")
	public String diary(Model model,Integer page,Integer identity){
		int sum = 0;
		Map map = new HashMap();
		System.out.println("----------");
		  List<User> u1 = new ArrayList<>();
		  u1 = userService.getALL();
		for (User u2 : u1) {
			if(u2.getIdentity()==0)
				sum += 1;
		}
		System.out.println("+++++");
		if(identity==0){
			sum += 0;
		}
		else{
			sum = u1.size()-sum;
		}
			System.out.println(sum);
		int maxpage = (int)Math.ceil((sum*1.0)/10);
		Boolean hasNext = false;
		if(page==null)
			page = 0;
		if(page<maxpage)
			hasNext =true;
		model.addAttribute("sum", sum);
		model.addAttribute("identity", identity);
		model.addAttribute("maxpage", maxpage);
		model.addAttribute("hasNext", hasNext);
		
		if(page>1){
			page = (page-1)*10-1;
		}
		else 
			page = 0;
		map.put("page", page);
		map.put("identity", identity);
		model.addAttribute("users", userService.getByIdentity(map));
		return "/backer/user.jsp";
	}
	
	@RequestMapping("/seeForm")
	public String diaryAdd(Model model){
		if(userService.getApplicat()!=null){
		model.addAttribute("users", userService.getApplicat());
		return "/backer/orderUserAdd.jsp";
		}
		return diary(model,0,1); 
	}
	
	@RequestMapping("/addOrderUser")
	public String addOrder(Model model, User vo) throws IOException{
		System.out.println(vo.toString());
		
		vo = userService.getUserInfo(vo);
		SendMessage sm = new SendMessage();
		vo.setIdentity(1);
		userService.update(vo);
		sm.addsuccess(vo.getUserTel(), vo.getUserName());
		return diaryAdd(model);
	}
	
	@RequestMapping("/modifyUser")
	public String modify(Model model, User vo){
		System.out.println(vo.toString());
		userService.update(vo);
		return diary(model,0,userService.getUserInfo(vo).getIdentity());
	}
	
	@RequestMapping("/addUser")
	public String add(Model model,User vo){
		System.out.println(vo);
		userService.add(vo);
		return diary(model,0,0);
	}
	
	@RequestMapping("/deleteUser")
	public String deleteUser(Model model,Integer[] id){
		User u = new User();
		int i = 0;
		u.setId(id[0]);
		i = userService.getUserInfo(u).getIdentity();
		userService.deleteMany(id);	
		//System.out.println(userService.getUserInfo(u));
		return diary(model,0,i);
	}
	
	@RequestMapping("/editUser")
	public String edit(Model model,User vo){
		User user;
		user = userService.getUserInfo(vo);
		model.addAttribute("user", user);
		return "/backer/userSet.jsp";
	}
	
	@RequestMapping("/submitEditUser")
	public String submitEdit(Model model,User vo){
		userService.update(vo);
		return edit(model,vo);
	}
}
