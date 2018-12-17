package zhumeng.zyhs.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import zhumeng.zyhs.ssm.pojo.Manager;
import zhumeng.zyhs.web.service.ManagerService;

@Controller
public class ManagerSetController {
	private final ManagerService managerService;

	@Autowired
	public ManagerSetController(ManagerService managerService) {
		this.managerService = managerService;
	}

	@RequestMapping(value = "/login")
	public String skipPacks(Model model, HttpServletRequest request) {
		String error = request.getParameter("error");
		if (error != null) {
			model.addAttribute("error", "账号密码错误");
		}
		return "/backer/login.jsp";
	}

	@RequestMapping(value = "/submitLogin")
	public String submitLogin(Model model, Manager vo, HttpServletRequest request) {
		if (managerService.login(vo)) {
			request.getSession().setAttribute("manager", vo);
			return "redirect:setUser.action?identity=0";
		} else {
			return "redirect:login.action?error=" + 1;
		}
	}
 
	@RequestMapping(value = "/logout")
	public String logout(Model model, HttpServletRequest request) {
		System.out.println(1);
		request.getSession().removeAttribute("manager");
		return "redirect:login.action";
	}

	@RequestMapping(value = "/managerSet")
	public String userSet(Model model, HttpServletRequest request) {
		String error = request.getParameter("error");
		if (error != null) {
			model.addAttribute("error", "账号密码错误");
		}
		return "/backer/managerSet.jsp";
	}

	@RequestMapping(value = "/managerSubmitPass")
	public String ajaxPass(Model model, String pass, String pass1, HttpServletRequest request) {
		Manager manager = (Manager) request.getSession().getAttribute("manager");
		if (pass.equals(manager.getPassword())) {
			manager.setPassword(pass1);
			managerService.changeSelect(manager);
			request.getSession().setAttribute("manager", manager);
			return "redirect:login.action";
		} else {
			return "redirect:managerSet.action?error=" + "1";
		}
	}
}
