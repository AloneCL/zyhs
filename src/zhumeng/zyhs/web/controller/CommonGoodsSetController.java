package zhumeng.zyhs.web.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import zhumeng.zyhs.ssm.pojo.CommonGoods;
import zhumeng.zyhs.ssm.pojo.GoodsLevel;
import zhumeng.zyhs.web.service.CommonGoodsService;
import zhumeng.zyhs.web.service.GoodsLevelService;

@Controller
public class CommonGoodsSetController {

	@Autowired
	private CommonGoodsService service;

	@Autowired
	private GoodsLevelService levelService;

	@RequestMapping("/setCommonGoods")
	public String diary(Model model) {
		model.addAttribute("goods", service.getALL());
		model.addAttribute("goodsLevel", levelService.getAll());
		return "/backer/commonGoods.jsp";
	}

	@RequestMapping("/editCommonGoods")
	public String edit(Model model, CommonGoods goods) {
		CommonGoods cgoods = service.getInfo(goods);
		System.out.println(cgoods);
		GoodsLevel vo = new GoodsLevel();
		vo.setId(cgoods.getGoodsLevelId());
		model.addAttribute("catalog", levelService.getInfo(vo));
		model.addAttribute("goods", cgoods);
		return "/backer/commonGoodsSet.jsp";
	}

	@RequestMapping("/modifyCommonGoods")
	public String modify(Model model, CommonGoods goods) {
		System.out.println(goods);
		service.update(goods);
		return diary(model);
	}

	@RequestMapping("/submitEditGoods")
	public String submitEdit(Model model, CommonGoods goods) {
		service.update(goods);
		return diary(model);
	}

	@RequestMapping("/addGoods")
	public String add(Model model, CommonGoods goods) {

		service.add(goods);
		System.out.println(goods);
		return diary(model);
	}

	@RequestMapping("/deleteGoods")
	public String deleteGoods(Model model, Integer[] id) {
		service.deleteMany(id);
		return diary(model);
	}
}
