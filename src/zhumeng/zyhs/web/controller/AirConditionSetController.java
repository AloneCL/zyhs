package zhumeng.zyhs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import zhumeng.zyhs.ssm.pojo.AirCondition;
import zhumeng.zyhs.ssm.pojo.GoodsLevel;
import zhumeng.zyhs.web.service.AirConditionService;
import zhumeng.zyhs.web.service.GoodsLevelService;

@Controller
public class AirConditionSetController {
   
	@Autowired
	private AirConditionService service;
	
	@Autowired
	private GoodsLevelService levelService;
	
	@RequestMapping("/setAirCondition")
	public String diary(Model model){
		model.addAttribute("airs", service.getALL());
		model.addAttribute("goodsLevel",levelService.getAll());
		return "/backer/airCondition.jsp";
	}
	
	@RequestMapping("/editAirCondition")
	public String edit(Model model,AirCondition air){
       AirCondition airs = service.getInfo(air);
       GoodsLevel vo = new GoodsLevel();
		vo.setId(airs.getGoodsLevelId());
		model.addAttribute("catalog", levelService.getInfo(vo));
		model.addAttribute("airs", airs);
		return "/backer/airConditionSet.jsp";
	}
	
	@RequestMapping("/modifyAirCondition")
	public String modify(Model model,AirCondition air){
		System.out.println(air);
		service.update(air);
		return diary(model);
	}
	
	@RequestMapping("/submitEditAirCondition")
	public String submitEdit(Model model,AirCondition air){
	    service.update(air);
		return diary(model);
	}
	
	@RequestMapping("/addAirCondition")
	public String add(Model model,AirCondition air){
		service.add(air);
		System.out.println(air);
		return diary(model);
	}
	
	@RequestMapping("/deleteAirCondition")
	public String deleteGoods(Model model,Integer[] id){
		service.deleteMany(id);
		return diary(model);
	}
}
