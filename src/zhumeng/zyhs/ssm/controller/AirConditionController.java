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
import zhumeng.zyhs.ssm.pojo.AirCondition;
import zhumeng.zyhs.ssm.tools.HttpReturn;
import zhumeng.zyhs.web.service.AirConditionService;


@Controller
@RequestMapping("/AirCondition")
public class AirConditionController {
	
	@Autowired
	private AirConditionService airService;
	
	@RequestMapping(value="/getAll",method=RequestMethod.POST)
	public void getAll(HttpServletResponse response) throws IOException{

		List<AirCondition> visions = airService.getALL();
		
		JSONArray jsonArray;
		jsonArray = JSONArray.fromObject(visions);

		HttpReturn.reponseBody(response, jsonArray);
	}
	
	@RequestMapping(value="/getByLevel",method=RequestMethod.POST)
	public void getByLevel(HttpServletResponse response,@RequestBody AirCondition vo){
		List<AirCondition> airConditions = airService.getByLevel(vo.getGoodsLevelId());
		JSONArray jsonArray;
		jsonArray = JSONArray.fromObject(airConditions);
		HttpReturn.reponseBody(response, jsonArray);
	}
	
	
	@RequestMapping(value="/get",method=RequestMethod.POST)
	public void get(HttpServletResponse response, @RequestBody AirCondition vo) throws IOException{

		AirCondition userInfo = null;
		System.out.println(vo.toString());
		userInfo = airService.getInfo(vo);
		//System.out.println(userInfo);
		// ת��ΪJSONObject����
		JSONObject jsonObject = new JSONObject().fromObject(userInfo);
         System.out.println(jsonObject);
		HttpReturn.reponseBody(response, jsonObject);
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void add(HttpServletResponse response, @RequestBody AirCondition vo) throws IOException{

		int hint;
		System.out.println(vo);
		hint = airService.add(vo);

		HttpReturn.reponseBody(response, String.valueOf(hint));
	}
	
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public void update(HttpServletResponse response, @RequestBody AirCondition vo) throws IOException{

		int hint;
		System.out.println(vo.toString());
		hint = airService.update(vo);
		HttpReturn.reponseBody(response, String.valueOf(hint));
	}
	
}
