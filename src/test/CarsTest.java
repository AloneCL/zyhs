package test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.sf.json.JSONArray;
import zhumeng.zyhs.ssm.pojo.Cars;
import zhumeng.zyhs.ssm.pojo.Goods;
import zhumeng.zyhs.web.service.CarsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-mvc.xml"})
public class CarsTest {
	
	@Autowired
	private CarsService CarService;
   
	@Test
    public void serch(){
		Cars h; //
		Cars h1 = new Cars();
		Goods g = null;
		h1.setId(3);
		List<Cars> h2 =/* CarService.getALL();*/
				CarService.getByLevel(2);
        for (Cars missingTools : h2) {
			System.out.println(missingTools);
		}
        g = CarService.getInfo(h1);
        System.out.println(g);
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
	@Test
	public void test(){
		Integer[] id = {1,2,3,4,6,6,23};
		JSONArray jsonArray;
		jsonArray = JSONArray.fromObject(id);
		System.out.println(jsonArray);
	}
}
