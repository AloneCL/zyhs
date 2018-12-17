package zhumeng.zyhs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import zhumeng.zyhs.ssm.pojo.GoodsLevel;
import zhumeng.zyhs.ssm.pojo.GoodsLevel;
import zhumeng.zyhs.web.service.GoodsLevelService;
import zhumeng.zyhs.web.service.GoodsLevelService;


@Controller
public class GoodsLevelSetController {
   
	
	@Autowired
	private GoodsLevelService service;
	
	@RequestMapping("/setGoodsLevel")
	public String diary(Model model, Integer page){
		int sum = service.getAll().size();
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
		model.addAttribute("gls",service.getPage(page));
		return "/backer/goodsLevel.jsp";
	}
	
	@RequestMapping("/editGoodsLevel")
	public String edit(Model model,GoodsLevel GoodsLevel){
        GoodsLevel gls = service.getInfo(GoodsLevel);
		System.out.println(gls);
		model.addAttribute("gls", gls);
		return "/backer/goodsLevelSet.jsp";
	}
	
	@RequestMapping("/modifyGoodsLevel")
	public String modify(Model model,GoodsLevel gls){
		System.out.println(gls);
		service.update(gls);
		return diary(model,0);
	}
	
	@RequestMapping("/submitEditGoodsLevel")
	public String submitEdit(Model model,GoodsLevel gls){
	    System.out.println(gls);
		service.update(gls);
		return diary(model,0);
	}
	
	@RequestMapping("/addGoodsLevel")
	public String add(Model model,GoodsLevel gls){
		service.add(gls);
		System.out.println(gls);
		return diary(model,0);
	}
	
	@RequestMapping("/deleteGoodsLevel")
	public String deleteGoods(Model model,Integer[] id){
		service.deleteMany(id);
		return diary(model,0);
	}
}
