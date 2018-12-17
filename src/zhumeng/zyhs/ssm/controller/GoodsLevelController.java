package zhumeng.zyhs.ssm.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import zhumeng.zyhs.ssm.pojo.GoodsLevel;
import zhumeng.zyhs.ssm.tools.HttpReturn;
import zhumeng.zyhs.web.service.GoodsLevelService;


@Controller
@RequestMapping("/GoodsLevel")
public class GoodsLevelController {
	
	@Autowired
	private  GoodsLevelService goodsLevelImageService;
	
	
	@RequestMapping(value="/get",method=RequestMethod.POST)
	public void add(HttpServletResponse response) throws IOException{
        
		System.out.println("dfwefewf");
		List<GoodsLevel> goodsLevels = goodsLevelImageService.getAll();
        JSONArray jsonArray;
        jsonArray = JSONArray.fromObject(goodsLevels);
		HttpReturn.reponseBody(response, jsonArray);
	}
	
}
