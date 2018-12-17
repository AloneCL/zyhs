package zhumeng.zyhs.ssm.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import zhumeng.zyhs.ssm.pojo.MissingTools;
import zhumeng.zyhs.ssm.pojo.SmallAppliances;
import zhumeng.zyhs.ssm.pojo.Television;
import zhumeng.zyhs.ssm.tools.HttpReturn;
import zhumeng.zyhs.web.service.MissToolsService;
import zhumeng.zyhs.web.service.TelevisionService;


@Controller
@RequestMapping("/Television")
public class TelevisionController {
	
	@Autowired
	private TelevisionService teService;
	
	@Autowired
	private MissToolsService misService;
	
	@RequestMapping(value="/getAll",method=RequestMethod.POST)
	public void getAll(HttpServletResponse response) throws IOException{

		List<Television> visions = teService.getALL();
		
		JSONArray jsonArray;
		jsonArray = JSONArray.fromObject(visions);

		HttpReturn.reponseBody(response, jsonArray);
	}
	
	@RequestMapping(value="/get",method=RequestMethod.POST)
	public void get(HttpServletResponse response, @RequestBody Television vo) throws IOException{

		Television userInfo = null;
		System.out.println(vo.toString());
		userInfo = teService.getInfo(vo);
		//System.out.println(userInfo);
		// ת��ΪJSONObject����
		JSONObject jsonObject = new JSONObject().fromObject(userInfo);
         System.out.println(jsonObject);
		HttpReturn.reponseBody(response, jsonObject);
	}
	
	@RequestMapping(value="getByLevel",method=RequestMethod.POST)
	public void getByLevel(HttpServletResponse response,@RequestBody Television vo){
		List<Television> televisions = teService.getByLevel(vo.getGoodsLevelId());
		JSONArray jsonArray;
		jsonArray = JSONArray.fromObject(televisions);
		HttpReturn.reponseBody(response, jsonArray);
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void add(HttpServletResponse response, @RequestBody Television vo) throws IOException{

		int hint;
		Double price = vo.getGoodsPrice();
		hint = teService.add(vo);
		int id = vo.getId();
		//System.out.println(id);
		List<MissingTools> miss =  vo.getMissing();
		if(miss!=null){
			for (MissingTools miss1 : miss) {
				System.out.println(miss1);
				price -= miss1.getToolsPrice();
				miss1.setBelongsId(id);
				miss1.setLevelId(vo.getGoodsLevelId());
				misService.add(miss1);
			}
		}
		vo.setGoodsPrice(price);
		teService.update(vo);
		System.out.println(vo);
		

		HttpReturn.reponseBody(response, String.valueOf(hint));
	}
	
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public void update(HttpServletResponse response, @RequestBody Television user) throws IOException{

		int hint;
		System.out.println(user.toString());
		hint = teService.update(user);
		HttpReturn.reponseBody(response, String.valueOf(hint));
	}
	
}
