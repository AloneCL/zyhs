package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zhumeng.zyhs.ssm.pojo.HotImage;
import zhumeng.zyhs.web.service.HotImageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-mvc.xml"})
public class ImageTest {
	
	@Autowired
	private HotImageService hotService;
   
	@Test
    public void serch(){
		HotImage h ;
		h = hotService.getInfo();
        System.out.println(hotService.getInfo());
        h.setImage1URL("123");
        hotService.update(h);
    }
}
