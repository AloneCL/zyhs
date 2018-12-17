package test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zhumeng.zyhs.ssm.pojo.GoodsLevel;
import zhumeng.zyhs.web.service.GoodsLevelService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-mvc.xml"})
public class GoodsLevelTest {
	
	@Autowired
	private GoodsLevelService goodsService;
   
	@Test
    public void serch(){
		List<GoodsLevel> g;
		g = goodsService.getAll();
		for (GoodsLevel goodsLevel : g) {
			System.out.println(goodsLevel);
		}
		GoodsLevel g1 = new GoodsLevel();
		g1.setId(1);
		System.out.println(goodsService.getInfo(g1));
    }
	
	@Test
	public void update(){
		GoodsLevel g = new GoodsLevel();
		GoodsLevel g1;
		g.setId(1);
	    g1 = goodsService.getInfo(g);
	    System.out.println(g1);
	    goodsService.add(g1);
	    g1.setLevelName("废旧纸板类");
	    goodsService.update(g1);
	}
	
	@Test
	public void delete(){
		goodsService.delete(4);
	}
}
