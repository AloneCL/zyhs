package zhumeng.zyhs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import zhumeng.zyhs.ssm.pojo.GoodsLevel;
import zhumeng.zyhs.ssm.pojo.Washing;
import zhumeng.zyhs.web.service.GoodsLevelService;
import zhumeng.zyhs.web.service.WashingService;


@Controller
public class WashingSetController {
   
	@Autowired
	private WashingService service;
	
	@Autowired
	private GoodsLevelService levelService;
	
	@RequestMapping("/setWashing")
	public String diary(Model model){
		model.addAttribute("whs", service.getALL());
		model.addAttribute("goodsLevel",levelService.getAll());
		return "/backer/washing.jsp";
	}
	
	@RequestMapping("/editWashing")
	public String edit(Model model,Washing washing){
		Washing whs = service.getInfo(washing);
		System.out.println(whs);
		GoodsLevel vo = new GoodsLevel();
		vo.setId(whs.getGoodsLevelId());
		model.addAttribute("catalog", levelService.getInfo(vo));
		model.addAttribute("whs", whs);
		return "/backer/washingSet.jsp";
	}
	
	@RequestMapping("/modifyWashing")
	public String modify(Model model,Washing whs){
		System.out.println(whs);
		service.update(whs);
		return diary(model);
	}
	
	@RequestMapping("/submitEditWashing")
	public String submitEdit(Model model,Washing whs){
	    service.update(whs);
		return diary(model);
	}
	
	@RequestMapping("/addWashing")
	public String add(Model model,Washing whs){
		/*ArrayList<CommonGoods> goodes = (ArrayList<CommonGoods>) service.getALL();
		CommonGoods goods1 = null;
		Iterator<CommonGoods> it = goodes.iterator();
		while(it.next() != null){
			goods1 = (CommonGoods) it;
			break;
		}
		goods.setGoodsLevelId(goods1.getGoodsLevelId());*/
		service.add(whs);
		System.out.println(whs);
		return diary(model);
	}
	
	@RequestMapping("/deleteWashing")
	public String deleteGoods(Model model,Integer[] id){
		service.deleteMany(id);
		return diary(model);
	}
}
