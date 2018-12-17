package zhumeng.zyhs.web.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import zhumeng.zyhs.ssm.pojo.Cars;
import zhumeng.zyhs.ssm.pojo.CommonGoods;
import zhumeng.zyhs.ssm.pojo.GoodsLevel;
import zhumeng.zyhs.web.service.CarsService;
import zhumeng.zyhs.web.service.CommonGoodsService;
import zhumeng.zyhs.web.service.GoodsLevelService;

@Controller
public class CarsSetController {

	@Autowired
	private CarsService service;

	@Autowired
	private GoodsLevelService levelService;

	@RequestMapping("/setCars")
	public String diary(Model model) {
		model.addAttribute("cars", service.getALL());
		model.addAttribute("goodsLevel", levelService.getAll());
		return "/backer/cars.jsp";
	}

	@RequestMapping("/editCars")
	public String edit(Model model, Cars car) {
		Cars cars = service.getInfo(car);
		System.out.println(cars);
		GoodsLevel vo = new GoodsLevel();
		vo.setId(cars.getGoodsLevelId());
		model.addAttribute("catalog", levelService.getInfo(vo));
		model.addAttribute("cars", cars);
		return "/backer/carsSet.jsp";
	}

	@RequestMapping("/modifyCars")
	public String modify(Model model, Cars cars) {
		System.out.println(cars);
		service.update(cars);
		return diary(model);
	}

	@RequestMapping("/submitEditCars")
	public String submitEdit(Model model, Cars cars) {
		service.update(cars);
		return diary(model);
	}

	@RequestMapping("/addCars")
	public String add(Model model, Cars cars) {
		/*
		 * ArrayList<CommonGoods> goodes = (ArrayList<CommonGoods>)
		 * service.getALL(); CommonGoods goods1 = null; Iterator<CommonGoods> it
		 * = goodes.iterator(); while(it.next() != null){ goods1 = (CommonGoods)
		 * it; break; } goods.setGoodsLevelId(goods1.getGoodsLevelId());
		 */
		service.add(cars);
		System.out.println(cars);
		return diary(model);
	}

	@RequestMapping("/deleteCars")
	public String deleteGoods(Model model, Integer[] id) {
		service.deleteMany(id);
		return diary(model);
	}
}
