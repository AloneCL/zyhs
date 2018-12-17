package test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zhumeng.zyhs.ssm.pojo.Television;
import zhumeng.zyhs.ssm.pojo.Washing;
import zhumeng.zyhs.web.service.WashingService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-mvc.xml"})
public class WashingTest {
	
	@Autowired
	private WashingService WaService;
   
	@Test
    public void serch(){
		Washing h; //
		Washing h1 = new Washing() ;
		h1.setId(3);
		List<Washing> h2 = WaService.getALL();
				//.getByLevel(3);
        for (Washing missingTools : h2) {
			System.out.println(missingTools);
		}
        h = WaService.getInfo(h1);
        System.out.println(h);
      /*  h.setGoodsType("洗碗机");
        h.setGoodsLevelId(3);
        h.setGoodsPrice(99.0);
        h.setImageUrl("nosldfg");
        h.setIntroduce("jlasdjlfkad");
        h.setMissing("内部零件");
        WaService.update(h);*/
       // WaService.add(h);
       // WaService.delete(2);
       // CommonService.updateByBelongs(h);
       // hotService.update(h);
    }
}
