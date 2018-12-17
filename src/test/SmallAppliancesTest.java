package test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zhumeng.zyhs.ssm.pojo.CommonGoods;
import zhumeng.zyhs.ssm.pojo.SmallAppliances;
import zhumeng.zyhs.web.service.SmallAppliancesService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-mvc.xml"})
public class SmallAppliancesTest {
	
	@Autowired
	private SmallAppliancesService CommonService;
   
	@Test
    public void serch(){
		SmallAppliances h; //
		SmallAppliances h1 = new SmallAppliances() ;
		h1.setId(1);
		List<SmallAppliances> h2 = CommonService.getByLevel(3);				//.getByLevel(3);
        for (SmallAppliances missingTools : h2) {
			System.out.println(missingTools);
		}
      /*  h = CommonService.getInfo(h1);
        h.setGoodsType("废钢板");
        h.setGoodNum(13.0);
        h.setGoodsLevelId(3);
        h.setGoodsPrice(99.0);
        h.setImageUrl("nosldfg");
        h.setIntroduce("jlasdjlfkad");
        h.setCompelet(0);
       // h.setMissing("内部零件");
        CommonService.update(h);*/
       // CommonService.updateByBelongs(h);
       // hotService.update(h);
    }
}
