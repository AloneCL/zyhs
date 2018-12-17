package zhumeng.zyhs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import zhumeng.zyhs.ssm.pojo.GoodsLevel;
import zhumeng.zyhs.ssm.pojo.Refrigerator;
import zhumeng.zyhs.web.service.GoodsLevelService;
import zhumeng.zyhs.web.service.RefrigeratorService;


@Controller
public class RefrigeratorSetController {
   
	@Autowired
	private RefrigeratorService service;
	
	@Autowired
	private GoodsLevelService levelService;
	
	@RequestMapping("/setRefrigerator")
	public String diary(Model model){
		model.addAttribute("rgs", service.getALL());
		model.addAttribute("goodsLevel",levelService.getAll());
		return "/backer/refrigerator.jsp";
	}
	
	@RequestMapping("/editRefrigerator")
	public String edit(Model model,Refrigerator refrigerator){
       Refrigerator rgs = service.getInfo(refrigerator);
		System.out.println(rgs);
		GoodsLevel vo = new GoodsLevel();
		vo.setId(rgs.getGoodsLevelId());
		model.addAttribute("catalog", levelService.getInfo(vo));
		model.addAttribute("rgs", rgs);
		return "/backer/refrigeratorSet.jsp";
	}
	
	@RequestMapping("/modifyRefrigerator")
	public String modify(Model model,Refrigerator rgs){
		System.out.println(rgs);
		service.update(rgs);
		return diary(model);
	}
	
	@RequestMapping("/submitEditRefrigerator")
	public String submitEdit(Model model,Refrigerator rgs){
	    service.update(rgs);
		return diary(model);
	}
	
	@RequestMapping("/addRefrigerator")
	public String add(Model model,Refrigerator rgs){
		/*ArrayList<CommonGoods> goodes = (ArrayList<CommonGoods>) service.getALL();
		CommonGoods goods1 = null;
		Iterator<CommonGoods> it = goodes.iterator();
		while(it.next() != null){
			goods1 = (CommonGoods) it;
			break;
		}
		goods.setGoodsLevelId(goods1.getGoodsLevelId());*/
		service.add(rgs);
		System.out.println(rgs);
		return diary(model);
	}
	
	@RequestMapping("/deleteRefrigerator")
	public String deleteGoods(Model model,Integer[] id){
		service.deleteMany(id);
		return diary(model);
	}
}
