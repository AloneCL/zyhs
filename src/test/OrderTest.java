package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zhumeng.zyhs.ssm.pojo.Goods;
import zhumeng.zyhs.ssm.pojo.MissingTools;
import zhumeng.zyhs.ssm.pojo.Orders;
import zhumeng.zyhs.ssm.pojo.Television;
import zhumeng.zyhs.web.service.GoodsService;
import zhumeng.zyhs.web.service.OrdersService;
import zhumeng.zyhs.web.service.TelevisionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-mvc.xml" })
public class OrderTest {

	@Autowired
	private OrdersService service;

	@Autowired
	private TelevisionService teservice;

	@Autowired
	private GoodsService goodservice;

	@SuppressWarnings("null")
	@Test
	public void getAll() {
		List<Orders> or;
		List<Goods> goods = null;
		Orders or1 = new Orders();
		Orders or2 = new Orders();
		Television te = new Television();
		te.setId(40001);
		Goods goos = new Goods();
		te = teservice.getInfo(te);
		System.out.println(te);
		goos.setBlOrderId(te.getBlOrderId());
		// goos.setGoodsId(te.getGoodsId());
		goos.setGoodsLevelId(te.getGoodsLevelId());
		goos.setGoodsPrice(te.getGoodsPrice());
		goos.setGoodsType(te.getGoodsType());
		goos.setIntroduce(te.getIntroduce());
		goos.setImageUrl1(te.getImageUrl1());
		goos.setMissingTools(te.getMissingTools());
		System.out.println(goos);
		// goods.add(goos);
		System.out.println("1111");
		or1.setId(2);
		or = service.getAll();
		/*
		 * for (Orders orders : or) { System.out.println(orders); }
		 */
		// .getByStatus(2);
		or2 = service.getInfo(or1);
		or2.setGood(goods);
		System.out.println(or2);
		service.add(or2);
		// System.out.println(or2.getId());
		goos.setBlOrderId(or2.getId());
		System.out.println(goos);
		goodservice.add(goos);
		// service.update(or2);
	}

	@Test
	public void getInfo() {
		Orders or1 = new Orders();
		Goods goos = new Goods();
		List<Goods> goods = null;
		Orders or2;
		or1.setId(1);
		or2 = service.getInfo(or1);
		System.out.println(or2);
		service.add(or2);
		int id = or2.getId();
		System.out.println("------------" + id);
		goods = or2.getGood();
		for (Goods goods2 : goods) {
			goos = goods2;
			goos.setBlOrderId(id);
			goodservice.add(goos);
			System.out.println(goods2);
		}

	}

	@SuppressWarnings("null")
	@Test
	public void addtest() {
		Orders or1 = new Orders();
		Orders or2 = new Orders();
		Television te = new Television();
		te.setId(40001);
		Goods goos = new Goods();
		goos = teservice.getInfo(te);
		System.out.println(goos);
		List<Goods> goods = new ArrayList<Goods>();
		goods.add(goos);
		or2.setGood(goods);
		System.out.println(or2);
	}
	@Test
	public void getstatus(){
		List<Orders> order = service.getByUserId(1);
				//.getByStatus(2);
	    for (Orders orders : order) {
			System.out.println(orders);
		}
	    
	    System.out.println("未筛选");
	  /*  Iterator<Orders> it = order.iterator();
             	   
	    while(it.hasNext()){
            //list.remove(0);
	    	if(((Orders) it).getUserOrderStatus()==4){
				 it.remove();
			}
			
			//System.out.println(orders);
		}*/
	    for(int i=0;i<order.size();i++){
	    	Orders od = order.get(i);
	    	if(od.getOrderStatus()==4){
	    		order.remove(od);
	    	}
	    }
	    
		System.out.println("筛选完毕");
		for (Orders orders : order) {
			System.out.println(orders);
		}
		System.out.println("ajlskdjfl");
	}
	
	@Test
	public void adds(){
		Orders order;
		Orders order1  = new Orders();
		order1.setId(1);
		order = service.getInfo(order1);
		List<Goods> goos = new ArrayList<Goods>();
		goos = order.getGood();
		for(Goods goods : goos){
			StringBuffer miss = null;
		List<MissingTools> missing = goods.getMissing();
        for (MissingTools missingTools : missing) {
			miss.append(missingTools.getToolsName()+"、");
		  }
		
        miss.replace(miss.length()-1, miss.length(),"");
		goods.setMissingTools(miss.toString());
		}
		/*order = service.getInfo(order1);
		System.out.println(order);
		service.add(order);
		System.out.println(order);*/
	}
	
	@Test
	public void testPage(){
		List<Orders> or = service.selectPage(1);
		//System.out.println();
		System.out.println(or.size());
		for (Orders orders : or) {
			System.out.println(orders);
		}
	}
}
