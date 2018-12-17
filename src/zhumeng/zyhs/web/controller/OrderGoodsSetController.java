package zhumeng.zyhs.web.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import zhumeng.zyhs.ssm.pojo.Goods;
import zhumeng.zyhs.ssm.pojo.Orders;
import zhumeng.zyhs.web.service.GoodsLevelService;
import zhumeng.zyhs.web.service.GoodsService;
import zhumeng.zyhs.web.service.OrdersService;


@Controller
public class OrderGoodsSetController {
    
	@Autowired
	private OrdersService OrderService;
	
	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private GoodsLevelService levelService;
	
	@RequestMapping("/setGood")
	public String diaryGood(Model model,Integer blOrderId){
		System.out.println("+++++++++"+blOrderId);
		model.addAttribute("blOrderId", blOrderId);
		model.addAttribute("orderGoods", goodsService.getByOrdersId(blOrderId));
		model.addAttribute("goodsLevel", levelService.getAll());
		return "/backer/orderGoods.jsp";
	}
	
	@RequestMapping("/addOrderGoods")
	public String addOrderGood(Model model,Goods good,Integer blOrderId){
		System.out.println("++增加商品+++"+blOrderId);
		Orders od = new Orders();	
		od.setId(blOrderId);
		od = OrderService.getInfo(od);
		double price = od.getOrderMoney();
		price += good.getGoodsPrice();
		goodsService.add(good);
		od.setOrderMoney(price);
		OrderService.update(od);
		return diaryGood(model,blOrderId);
	}
	
	@RequestMapping("/editOrderGoods")
	public String editGood(Model model,Goods vo){
		Goods goods = goodsService.getInfo(vo);
		model.addAttribute("orderGood", goods);
		return "/backer/orderGoodsSet.jsp";
	}
	
	@RequestMapping("/submitEditOrderGoods")
	public String submitEditOrderGoods(Model model,Goods vo,Integer blOrderId){
		goodsService.update(vo);
		double price = 0;
		List<Goods> gd = goodsService.getByOrdersId(blOrderId);
		for (Goods goods : gd) {
			if(goods!=null){
				price += goods.getTotalPrice();
			}
		}
		Orders od = new Orders();
		od = OrderService.getInfo(od);
		od.setOrderMoney(price);
		OrderService.update(od);
		return diaryGood(model,blOrderId);
	}
	
	@RequestMapping("/modifyOrderGoods")
	public void modifyOrderGoods(Model model,Goods vo){
		goodsService.update(vo);
	}
	
	
	@RequestMapping("/deleteOrderGoods")
	public String delete(Model model,Integer[] id,Integer blOrderId){
		System.out.println("----------"+blOrderId);
		goodsService.deleteMany(id);
		return diaryGood(model,blOrderId);
	}
	
}
