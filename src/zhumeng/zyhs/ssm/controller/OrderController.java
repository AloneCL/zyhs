package zhumeng.zyhs.ssm.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import zhumeng.zyhs.ssm.pojo.Goods;
import zhumeng.zyhs.ssm.pojo.MissingTools;
import zhumeng.zyhs.ssm.pojo.Orders;
import zhumeng.zyhs.ssm.tools.HttpReturn;
import zhumeng.zyhs.web.service.GoodsService;
import zhumeng.zyhs.web.service.OrdersService;


@Controller
@RequestMapping("/Order")
public class OrderController {
	
	@Autowired
	private OrdersService Service;

	@Autowired
	private GoodsService GoodsService;
	
	@RequestMapping(value="/getAll",method=RequestMethod.POST)    //获取所有订单
	public void getAll(HttpServletResponse response) throws IOException{

		List<Orders> orders = Service.getAll();
		
		JSONArray jsonArray;
		jsonArray = JSONArray.fromObject(orders);

		HttpReturn.reponseBody(response, jsonArray);
	}
	
   	
	@RequestMapping(value="/get",method=RequestMethod.POST)          //根据id获取相应订单
	public void get(HttpServletResponse response, @RequestBody Orders vo) throws IOException{

		Orders orderInfo = null;
		System.out.println(vo.toString());
		orderInfo = Service.getInfo(vo);
		System.out.println(orderInfo);
		// ת��ΪJSONObject����
		JSONObject jsonObject = new JSONObject().fromObject(orderInfo);
         System.out.println(jsonObject);
		HttpReturn.reponseBody(response, jsonObject);
	}
	
	@RequestMapping(value="/getByUserId",method=RequestMethod.POST)                   //根据用户的id获取用户的所有订单
	public void getByUserId(HttpServletResponse response, @RequestBody Orders vo) throws IOException{
		 String  datetime;
        List<Orders> orders = Service.getByUserId(vo.getUserId());
        for(int i=0;i<orders.size();i++){
	    	Orders od = orders.get(i);
	    	if(od.getOrderStatus()==4){
	    		orders.remove(od);
	    	}
	    }
		JSONArray jsonArray;
		jsonArray = JSONArray.fromObject(orders);

		HttpReturn.reponseBody(response, jsonArray);
	} 
	
	 //增加订单
	@RequestMapping(value="/add",method=RequestMethod.POST)           
	public void add(HttpServletResponse response, @RequestBody Orders vo) throws IOException{

		int hint;
		Double price = 0.0;
		Goods goods = new Goods();
		System.out.println(vo);
		hint = Service.add(vo);
		List<Goods> goos = new ArrayList<Goods>();
		int id = vo.getId();
		System.out.println("----"+id);
		goos = vo.getGood();
		
		for (Goods goods2 : goos) {
			StringBuffer miss = new StringBuffer("缺件：");
			goods = goods2;
			price += goods2.getGoodsPrice();
			if(goods.getMissing()!=null){
			List<MissingTools> missing = goods.getMissing();
            for (MissingTools missingTools : missing) {
				miss.append(missingTools.getToolsName()+"、");
			}
            miss.replace(miss.length()-1, miss.length(),"");
			}
			goods.setMissingTools(miss.toString());
            goods.setBlOrderId(id);
			GoodsService.add(goods);
			System.out.println(goods2);
		}
		vo.setOrderMoney(price);
	
	    Service.update(vo);

		HttpReturn.reponseBody(response, String.valueOf(hint));
	}
	
	
	//根据订单的状态来选择订单
	@RequestMapping(value="/selectByStatus")      
	public void getSelected(HttpServletResponse response,@RequestBody String num){
		List<Orders> orders = Service.getByStatus(Integer.parseInt(num));
		System.out.println(num);
		JSONArray jsonArray;
		jsonArray = JSONArray.fromObject(orders);
		
		HttpReturn.reponseBody(response, jsonArray);	
	}
	
	
	 // 根据地址选择出所有符合的订单
	@RequestMapping(value="/serchOrder")           
	public void serchOrder(HttpServletResponse response,@RequestBody String address){
	   	List<Orders> orders = Service.getByStatus(0);
	   	List<Orders> serch = new ArrayList();
	    System.out.println(address);
	   	for (Orders orders1 : orders) {
			if(orders1.getAddress().indexOf(address)>=0){
				serch.add(orders1);
			}
		}
	    JSONArray jsonArray;
	    jsonArray = JSONArray.fromObject(serch);
	    HttpReturn.reponseBody(response, jsonArray);
	}
	
	
	//更新订单状态
	@RequestMapping("/updateStatus")
	public void updateStatus(HttpServletResponse response,@RequestBody Orders vo){
		int hint;
		hint = Service.updateStatus(vo);
		HttpReturn.reponseBody(response, String.valueOf(hint));
	}
	//@RequestMapping(value="/add",method = RequestMethod.POST)
	
	
	//更新订单
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public void update(HttpServletResponse response, @RequestBody Orders vo) throws IOException{

		int hint;
		System.out.println(vo.toString());
		hint = Service.update(vo);
		HttpReturn.reponseBody(response, String.valueOf(hint));
	}
	
}
