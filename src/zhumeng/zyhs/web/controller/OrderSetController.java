package zhumeng.zyhs.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import zhumeng.zyhs.ssm.pojo.Orders;
import zhumeng.zyhs.web.service.GoodsLevelService;
import zhumeng.zyhs.web.service.GoodsService;
import zhumeng.zyhs.web.service.OrdersService;

@Controller
public class OrderSetController {

	@Autowired
	private OrdersService OrderService;

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private GoodsLevelService levelService;

	@RequestMapping("/setOrder")
	public String diary(Model model, Integer page) {
		int sum = OrderService.getAll().size();
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
		model.addAttribute("Order", OrderService.selectPage(page));
		return "/backer/order.jsp";
	}

	@RequestMapping("/modifyOrder")
	public String modify(Model model, Orders vo) {
		OrderService.update(vo);
		return diary(model, 0);
	}

	@RequestMapping("/addOrder")
	public String add(Model model, Orders vo) {
		OrderService.add(vo);
		return diary(model, 0);
	}

	@RequestMapping("/deleteOrder")
	public String deleteOrder(Model model, Integer[] id) {
		OrderService.deleteMany(id);
		return diary(model, 0);
	}

	@RequestMapping("/editOrder")
	public String edit(Model model, Integer id) {
		Orders vo = new Orders();
		vo.setId(id);
		vo = OrderService.getInfo(vo);
		model.addAttribute("Order", vo);
		return "/backer/orderSet.jsp";
	}

	@RequestMapping("/submitEditOrder")
	public String submitEdit(Model model, Orders vo) {
		OrderService.update(vo);
		return edit(model, vo.getId());
	}
}
