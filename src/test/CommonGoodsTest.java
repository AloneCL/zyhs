package test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zhumeng.zyhs.ssm.pojo.CommonGoods;
import zhumeng.zyhs.ssm.pojo.Goods;
import zhumeng.zyhs.web.service.CommonGoodsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-mvc.xml"})
public class CommonGoodsTest {
	
	@Autowired
	private CommonGoodsService CommonService;
   
	@Test
    public void serch(){
		CommonGoods h; 
		Goods h3;
		CommonGoods h1 = new CommonGoods();
		h1.setId(1);
		List<CommonGoods> h2 = CommonService.getALL();
				//.getByLevel(1);
        for (CommonGoods missingTools : h2) {
			System.out.println(missingTools);
		}
        h = CommonService.getInfo(h1);
        h3 = CommonService.getInfo(h1);
        System.out.println(h.getGoodsType());  
        h.setGoodsLevelId(3);
        CommonService.update(h);
        //System.out.println(h3.getClass().getSimpleName());
       /* h.setGoodsType("废钢板");
        h.setGoodNum(13.0);
        h.setGoodsLevelId(3);
        h.setGoodsPrice(99.0);
        h.setImageUrl("nosldfg");
        h.setIntroduce("jlasdjlfkad");
        h.setPayType(3);
        CommonService.update(h);*/
       // CommonService.updateByBelongs(h);
       // hotService.update(h);
    }
	
}
