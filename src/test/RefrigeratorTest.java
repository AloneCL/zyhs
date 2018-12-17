package test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zhumeng.zyhs.ssm.pojo.AirCondition;
import zhumeng.zyhs.ssm.pojo.Refrigerator;
import zhumeng.zyhs.web.service.RefrigeratorService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-mvc.xml"})
public class RefrigeratorTest {
	
	@Autowired
	private RefrigeratorService ReService;
   
	@Test
    public void serch(){
		Refrigerator h; //
		Refrigerator h1 = new Refrigerator() ;
		h1.setId(1);
		List<Refrigerator> h2 = ReService.getByLevel(3);
				//;.getALL()
        for (Refrigerator missingTools : h2) {
        	//System.out.println("alskdjf");
			System.out.println(missingTools);
		}
        h = ReService.getInfo(h1);
        System.out.println(h);
       /* h.setGoodsType("旧美的空调");
        h.setGoodsLevelId(3);
        h.setGoodsPrice(99.0);
        h.setImageUrl("nosldfg");
        h.setIntroduce("jlasdjlfkad");
        //h.setMissing("内部零件");
        ReService.update(h);
        ReService.add(h);*/
       // CommonService.updateByBelongs(h);
       // hotService.update(h);
    }
}
