package zhumeng.zyhs.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import zhumeng.zyhs.ssm.pojo.MissingTools;
import zhumeng.zyhs.web.service.GoodsLevelService;
import zhumeng.zyhs.web.service.MissToolsService;


@Controller
public class GoodsMissingToolsSet {
   
	@Autowired
	private MissToolsService service;
	
	@Autowired
	private GoodsLevelService levelService;
	
	@RequestMapping("/setGoodsMissing")
	public String diary(Model model,Integer level,Integer bl){
		Map paraMap = new HashMap();
		paraMap.put("level", level);
		paraMap.put("belongsId", bl);
		model.addAttribute("mts", service.getGoodsBl(paraMap));
		model.addAttribute("goodsLevel",levelService.getAll());
		return "/backer/goodsMissing.jsp";
	}
	
	@RequestMapping("/submitEditGoodsMissing")
	public String submitEdit(Model model,MissingTools mts){
	    service.update(mts);
		return diary(model,mts.getLevelId(),mts.getBelongsId());
	}

	@RequestMapping("/editGoodsMissing")
	public String edit(Model model,MissingTools MissingTools){
       MissingTools mts = service.getInfo(MissingTools);
		System.out.println(mts);
		model.addAttribute("mts", mts);
		return "/backer/goodsMissingSet.jsp";
	}
	
	
	@RequestMapping("/addGoodsMissing")
	public String add(Model model,MissingTools mts){
		
		service.add(mts);
		System.out.println(mts);
		return diary(model,mts.getLevelId(),mts.getBelongsId());
	}
	
	@RequestMapping("/deleteGoodsMissing")
	public String deleteGoods(Model model,Integer[] id){
		MissingTools m = new MissingTools();
		m.setId(id[0]);
		m = service.getInfo(m);
		service.deleteMany(id);
		return diary(model,m.getLevelId(),m.getBelongsId());
	}
}
