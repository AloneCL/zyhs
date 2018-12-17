package test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zhumeng.zyhs.ssm.pojo.AirCondition;
import zhumeng.zyhs.ssm.pojo.Television;
import zhumeng.zyhs.web.service.TelevisionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-mvc.xml"})
public class TelevisionTest {
	
	@Autowired
	private TelevisionService TeService;
   
	@Test
    public void serch(){
		Television h; //
		Television h1 = new Television() ;
		h1.setId(1);
		List<Television> h2 = TeService.getALL();
				//.getByLevel(1);
        for (Television missingTools : h2) {
        //	System.out.println("alskdjf");
			System.out.println(missingTools);
		}
        h = TeService.getInfo(h1);
        System.out.println(h);
     /*   h.setGoodsType("旧美的空调");
        h.setGoodsLevelId(3);
        h.setGoodsPrice(99.0);
        h.setImageUrl("nosldfg");
        h.setIntroduce("jlasdjlfkad");
        h.setMissing("内部零件");
        TeService.update(h);
        TeService.add(h);
        TeService.delete(2);*/
       // CommonService.updateByBelongs(h);
       // hotService.update(h);
    }
	@Test
	public void addmiss(){
		Television h; //
		Television h1 = new Television() ;
		h1.setId(40001);
		h = TeService.getInfo(h1);
		TeService.add(h);
		System.out.println(h.getId());
	}
}
