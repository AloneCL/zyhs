package zhumeng.zyhs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import zhumeng.zyhs.ssm.pojo.MissingTools;
import zhumeng.zyhs.ssm.pojo.MissingTools;
import zhumeng.zyhs.web.service.GoodsLevelService;
import zhumeng.zyhs.web.service.MissToolsService;


@Controller
public class MissToolsSetController {
   
	@Autowired
	private MissToolsService service;
	
	@Autowired
	private GoodsLevelService levelService;
	
	@RequestMapping("/setMissTools")
	public String diary(Model model,Integer page){
		int sum = service.getALL().size();
		int maxpage = (int) Math.ceil((sum * 1.0) / 10);
		if (page == null) {
			page = 0;
		}
		Boolean hasNext = false;
		if (page < maxpage)
			hasNext = true;
		model.addAttribute("sum", sum);
		model.addAttribute("maxpage", maxpage);
		model.addAttribute("hasNext", hasNext);
		if (page > 1)
			page = (page - 1) * 10 - 1;
		else 
			page = 0;
		model.addAttribute("mts", service.getPage(page));
		model.addAttribute("goodsLevel",levelService.getAll());
		return "/backer/missingTools.jsp";
	}
	
	@RequestMapping("/editMissingTools")
	public String edit(Model model,MissingTools MissingTools){
       MissingTools mts = service.getInfo(MissingTools);
		System.out.println(mts);
		model.addAttribute("mts", mts);
		return "/backer/missingToolsSet.jsp";
	}
	
	@RequestMapping("/modifyMissingTools")
	public String modify(Model model,MissingTools mts){
		System.out.println(mts);
		service.update(mts);
		return diary(model,0);
	}
	
	@RequestMapping("/submitEditMissingTools")
	public String submitEdit(Model model,MissingTools mts){
	    service.update(mts);
		return diary(model,0);
	}
	
	@RequestMapping("/addMissingTools")
	public String add(Model model,MissingTools mts){
		service.add(mts);
		System.out.println(mts);
		return diary(model,0);
	}
	
	@RequestMapping("/deleteMissingTools")
	public String deleteGoods(Model model,Integer[] id){
		service.deleteMany(id);
		return diary(model,0);
	}
}
