package test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zhumeng.zyhs.ssm.pojo.Cars;
import zhumeng.zyhs.ssm.pojo.Goods;
import zhumeng.zyhs.web.service.CarsService;
import zhumeng.zyhs.web.service.GoodsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-mvc.xml"})
public class GoodsTest {
	
	@Autowired
	private GoodsService Service;
   
	@Test
    public void serch(){
		Goods h1 = new Goods();
		Goods g = null;
		h1.setGoodsId(3);
        g = Service.getInfo(h1);
        System.out.println(g);
     /*   g.setPoweratename("meidi");
        g.setPowerate("挂机");
        g.setBrandname("asdg");
        g.setBrand("asdgf");
        g.setName("空调");
        g.setNum(2.0);
        g.setTime("asdgga");
        g.setTotalPrice(66.6);
        Service.update(g);
        System.out.println("修改成功");*/
        //h.set
        /*List<MissingTools> mis = h.getMissing();
        for (MissingTools missingTools : mis) {
			System.out.println(missingTools);
		}
        System.out.println(h);
        h.setGoodsType("超级豪华跑车");
        h.setGoodsLevelId(3);
        h.setGoodsPrice(99.0);
        h.setImageUrl("nosldfg");
        h.setIntroduce("jlasdjlfkad");*/
       // h.setMissing("内部零件");
        //CarService.update(h);
       // CarService.add(h);
    }
}
