package zhumeng.zyhs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import zhumeng.zyhs.ssm.pojo.GoodsLevel;
import zhumeng.zyhs.ssm.pojo.Television;
import zhumeng.zyhs.web.service.GoodsLevelService;
import zhumeng.zyhs.web.service.TelevisionService;


@Controller
public class TelevisionSetController {
   
	@Autowired
	private TelevisionService service;
	
	@Autowired
	private GoodsLevelService levelService;
	
	@RequestMapping("/setTelevision")
	public String diary(Model model){
		model.addAttribute("tvs", service.getALL());
		model.addAttribute("goodsLevel",levelService.getAll());
		return "/backer/television.jsp";
	}
	
	@RequestMapping("/editTelevision")
	public String edit(Model model,Television Television){
		Television tvs = service.getInfo(Television);
		System.out.println(tvs);
		GoodsLevel vo = new GoodsLevel();
		vo.setId(tvs.getGoodsLevelId());
		model.addAttribute("catalog", levelService.getInfo(vo));
		model.addAttribute("tvs", tvs);
		return "/backer/televisionSet.jsp";
	}
	
	@RequestMapping("/modifyTelevision")
	public String modify(Model model,Television tvs){
		System.out.println(tvs);
		service.update(tvs);
		return diary(model);
	}
	
	@RequestMapping("/submitEditTelevision")
	public String submitEdit(Model model,Television tvs){
	    service.update(tvs);
		return diary(model);
	}
	
	@RequestMapping("/addTelevision")
	public String add(Model model,Television tvs){
		/*ArrayList<CommonGoods> goodes = (ArrayList<CommonGoods>) service.getALL();
		CommonGoods goods1 = null;
		Iterator<CommonGoods> it = goodes.iterator();
		while(it.next() != null){
			goods1 = (CommonGoods) it;
			break;
		}
		goods.setGoodsLevelId(goods1.getGoodsLevelId());*/
		service.add(tvs);
		System.out.println(tvs);
		return diary(model);
	}
	
	@RequestMapping("/deleteTelevision")
	public String deleteGoods(Model model,Integer[] id){
		service.deleteMany(id);
		return diary(model);
	}
}
