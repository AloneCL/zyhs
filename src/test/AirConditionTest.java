package test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zhumeng.zyhs.ssm.pojo.AirCondition;
import zhumeng.zyhs.ssm.pojo.SmallAppliances;
import zhumeng.zyhs.web.service.AirConditionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-mvc.xml"})
public class AirConditionTest {
	
	@Autowired
	private AirConditionService AirService;
   
	@Test
    public void serch(){
		AirCondition h; //
		AirCondition h1 = new AirCondition() ;
		h1.setId(3);
		List<AirCondition> h2 = AirService.getALL();
				//.getByLevel(1);
        for (AirCondition missingTools : h2) {
        	//System.out.println("alskdjf");
			System.out.println(missingTools);
		}
        h = AirService.getInfo(h1);
        System.out.println(h.getMissing().toString());
        System.out.println(h);
     /*   h.setGoodsType("旧美的空调");
        h.setGoodsLevelId(3);
        h.setGoodsPrice(99.0);
        h.setImageUrl("nosldfg");
        h.setIntroduce("jlasdjlfkad");
       // h.setMissing("内部零件");
        AirService.update(h);*/
       // CommonService.updateByBelongs(h);
       // hotService.update(h);
    }
	@Test
	public void update(){
		AirCondition h = new AirCondition(); //
		AirCondition h1 = new AirCondition() ;
		h1.setId(60001);
		h = AirService.getInfo(h1);
		System.out.println(h);
		h.setImageUrl2("asdfasdf");
		AirService.update(h);
	}
}
