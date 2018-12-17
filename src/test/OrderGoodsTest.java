package test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zhumeng.zyhs.ssm.pojo.Goods;
import zhumeng.zyhs.web.service.GoodsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-mvc.xml"})
public class OrderGoodsTest {
	
	@Autowired
	private GoodsService service;
   
	@Test
    public void serch(){
		List<Goods> good = service.getByOrdersId(1);
		System.out.println(service);
		for (Goods goods : good) {
			System.out.println(goods);
		}
    }
}
