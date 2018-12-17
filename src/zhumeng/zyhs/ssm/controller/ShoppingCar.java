package zhumeng.zyhs.ssm.controller;

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
@RequestMapping(value="/ShoppingCar")
public class ShoppingCar {
	@Autowired
	private OrdersService Service;

	@Autowired
	private GoodsService GoodsService;
	
	
	//把商品增加到用户车
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void add(HttpServletResponse response,@RequestBody Orders vo){
		int hint = 0;
		Double price = 0.0;
		Goods goods = new Goods();
		System.out.println(vo);
		int id = -1;
		//Orders or = 
		if(Service.serchShoppingCar(vo.getUserId())!=null){
			//hint = 0;
			System.out.println("用户已存在购物车");
		    List<Orders> order = Service.getByUserId(vo.getUserId());
		   // Orders od = new Orders();
		    for (Orders orders : order) {
		    	//System.out.println(orders.getOrderStatus());
				if(orders.getOrderStatus()==4){         //选中用户已有的购物车
					//od = orders;
					System.out.println("已重新赋值");
					id = orders.getId();
					break;
				}
			}
            	    
		}
		else{
		hint = Service.add(vo);
		id = vo.getId();
		}
		List<Goods> goos = new ArrayList<Goods>();
		System.out.println("----"+id);
		goos = vo.getGood();
		
		for (Goods goods2 : goos) {
			StringBuffer miss = new StringBuffer("缺件：");
			goods = goods2;
			price += goods2.getGoodsPrice();
			if(goods.getMissing()!=null){
			List<MissingTools> missing = goods.getMissing();
            for (MissingTools missingTools : missing) {
            	System.out.println(missingTools.getToolsName());
				miss.append(missingTools.getToolsName()+"、");
			}
            miss.replace(miss.length()-1, miss.length(),"");
			}
			goods.setMissingTools(miss.toString());
            goods.setBlOrderId(id);
			GoodsService.add(goods);
			//System.out.println(goods2);
		}
		vo.setOrderMoney(price);
	    vo.setOrderStatus(4);
	    vo.setUserOrderStatus(0);
	    vo.setOrderUserOrderStatus(0);
	    Service.update(vo);
		
		HttpReturn.reponseBody(response, String.valueOf(hint));
	}
	
	
	//根据传入的id删除购物车内的商品
	@RequestMapping(value="/deleteGoods",method=RequestMethod.POST)
	public void deleteGoods(HttpServletResponse response,@RequestBody String id){
	    int hint = 1;
	    JSONArray jsonArray=JSONArray.fromObject(id);
	    System.out.println(id);
	    List<Integer> id1 = (List) JSONArray.toCollection(jsonArray);
 	    int i = 0;
 	    Integer[] id2 = new Integer[id1.size()];
 	   // id2 = (Integer[])id1.toArray();
	    for (Integer integer : id1) {
	       id2[i] = integer;
	       i++;
		   System.out.println(integer);	
		}
	   
	    hint = GoodsService.deleteMany(id2);
	    HttpReturn.reponseBody(response, String.valueOf(hint));
	}
	
	
	//查看购物车 根据用户的id
	@RequestMapping(value="/serchShoppingCar",method=RequestMethod.POST)      
	public void getSelected(HttpServletResponse response,@RequestBody String num){
		Orders orders = Service.serchShoppingCar(Integer.parseInt(num));
		System.out.println(num);
		JSONObject jsonObject = new JSONObject().fromObject(orders);
        System.out.println(jsonObject);
		HttpReturn.reponseBody(response, jsonObject);
	}
	
	@RequestMapping(value="/produceOrder",method=RequestMethod.POST)     //根据购物车中选中的商品生成订单
	public void produceOrder(HttpServletResponse response,@RequestBody Orders vo){
		int hint;
		int id;
		hint  = Service.add(vo);
		id = vo.getId();
		List<Goods> god = vo.getGood();
		System.out.println(vo);
		if(god!=null){
			for (Goods goods : god) {
				goods.setBlOrderId(id);
				System.out.println(goods);
				GoodsService.update(goods);
			}
		}
	HttpReturn.reponseBody(response, String.valueOf(hint));
	}
}
