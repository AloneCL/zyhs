package zhumeng.zyhs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import zhumeng.zyhs.ssm.pojo.GoodsLevel;
import zhumeng.zyhs.ssm.pojo.SmallAppliances;
import zhumeng.zyhs.web.service.GoodsLevelService;
import zhumeng.zyhs.web.service.SmallAppliancesService;

@Controller
public class SmallAppliancesSetController {
   
	@Autowired
	private SmallAppliancesService service;
	
	@Autowired
	private GoodsLevelService levelService;
	
	@RequestMapping("/setSmallAppliances")
	public String diary(Model model){
		model.addAttribute("smallgoods", service.getALL());
		model.addAttribute("goodsLevel",levelService.getAll());
		return "/backer/smallAppliances.jsp";
	}
	
	@RequestMapping("/editSmallAppliances")
	public String edit(Model model,SmallAppliances smallgood){
		SmallAppliances smallgoods = service.getInfo(smallgood);
		System.out.println(smallgoods);
		GoodsLevel vo = new GoodsLevel();
		vo.setId(smallgoods.getGoodsLevelId());
		model.addAttribute("catalog", levelService.getInfo(vo));
		model.addAttribute("smallgoods", smallgoods);
		return "/backer/smallAppliancesSet.jsp";
	}
	
	@RequestMapping("/modifySmallAppliances")
	public String modify(Model model,SmallAppliances smallgood){
		System.out.println(smallgood);
		service.update(smallgood);
		return diary(model);
	}
	
	@RequestMapping("/submitEditSmallAppliances")
	public String submitEdit(Model model,SmallAppliances smallgood){
	    service.update(smallgood);
		return diary(model);
	}
	
	@RequestMapping("/addSmallAppliances")
	public String add(Model model,SmallAppliances air){
		/*ArrayList<CommonGoods> goodes = (ArrayList<CommonGoods>) service.getALL();
		CommonGoods goods1 = null;
		Iterator<CommonGoods> it = goodes.iterator();
		while(it.next() != null){
			goods1 = (CommonGoods) it;
			break;
		}
		goods.setGoodsLevelId(goods1.getGoodsLevelId());*/
		service.add(air);
		System.out.println(air);
		return diary(model);
	}
	
	@RequestMapping("/deleteSmallAppliances")
	public String deleteGoods(Model model,Integer[] id){
		service.deleteMany(id);
		return diary(model);
	}
}
