package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.sf.json.JSONObject;
import zhumeng.zyhs.ssm.pojo.MissingTools;
import zhumeng.zyhs.web.service.MissToolsService;
import zhumeng.zyhs.wechat.link.TokenThread;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-mvc.xml"})
public class MissingToolsTest {
	
	@Autowired
	private MissToolsService misService;
   
	@Test
    public void serch(){
		MissingTools h; //
		MissingTools h1 = new MissingTools() ;
		h1.setId(1);
		/*List<MissingTools> h2 = misService.getALL();
        for (MissingTools missingTools : h2) {
			System.out.println(missingTools);
		}*/
        h = misService.getInfo(h1);
        h.setToolsName("木质外壳");
        JSONObject jsonObject = new JSONObject().fromObject(h);
        System.out.println(jsonObject);
        //misService.updateByBelongs(h);
       // hotService.update(h);
    }
	
	@Test
	public void testBlGoods(){
		Map paraMap = new HashMap();
		int level = 10;
		int bl = 60014;
		paraMap.put("level", level);
		paraMap.put("belongsId", bl);
		List<MissingTools> miss = misService.getGoodsBl(paraMap);
		for (MissingTools ms : miss) {
			System.out.println(ms);
		}
	}
	
	@Test
	public void test11(){
		TokenThread th = new TokenThread();
		//th.run();
		System.out.println("123124145");
		System.out.println(th.getToken());
	}
}
