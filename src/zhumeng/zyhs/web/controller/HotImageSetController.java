package zhumeng.zyhs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import zhumeng.zyhs.ssm.pojo.HotImage;
import zhumeng.zyhs.web.service.HotImageService;

@Controller
public class HotImageSetController {
   
	@Autowired
	private HotImageService hotImageService;
	
	@RequestMapping(value = "/setHotImage")
	public String diary(Model model){

		model.addAttribute("hotImage", hotImageService.getInfo());
		return "/backer/hotImage.jsp";
	}

	

	@RequestMapping("/modifyHotImage")
	public String modify(Model model, HotImage vo){
		System.out.println(vo.toString());
		hotImageService.update(vo);
		return diary(model);
	}
}
