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
import zhumeng.zyhs.ssm.pojo.Cars;
import zhumeng.zyhs.ssm.tools.HttpReturn;
import zhumeng.zyhs.web.service.CarsService;


@Controller
@RequestMapping("/Car")
public class CarsController {
	
	@Autowired
	private CarsService carService;
	
	@RequestMapping(value="/getAll",method=RequestMethod.POST)
	public void getAll(HttpServletResponse response) throws IOException{

		List<Cars> visions = carService.getALL();
		
		JSONArray jsonArray;
		jsonArray = JSONArray.fromObject(visions);

		HttpReturn.reponseBody(response, jsonArray);
	}
	
	@RequestMapping(value="/getByLevel",method=RequestMethod.POST)
	public void getByLevel(HttpServletResponse response,@RequestBody Cars vo){
	    	List<Cars> cars = carService.getByLevel(vo.getGoodsLevelId());
	    	JSONArray jsonArray;
	    	jsonArray = JSONArray.fromObject(cars);
	    	HttpReturn.reponseBody(response, jsonArray);
	}
	
	@RequestMapping(value="/get",method=RequestMethod.POST)
	public void get(HttpServletResponse response, @RequestBody Cars vo) throws IOException{

		Cars carInfo = null;
		System.out.println(vo.toString());
		carInfo = carService.getInfo(vo);
		//System.out.println(userInfo);
		// ת��ΪJSONObject����
		JSONObject jsonObject = new JSONObject().fromObject(carInfo);
         System.out.println(jsonObject);
		HttpReturn.reponseBody(response, jsonObject);
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void add(HttpServletResponse response, @RequestBody Cars vo) throws IOException{

		int hint;
		System.out.println(vo);
		hint = carService.add(vo);

		HttpReturn.reponseBody(response, String.valueOf(hint));
	}
	
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public void update(HttpServletResponse response, @RequestBody Cars vo) throws IOException{

		int hint;
		System.out.println(vo.toString());
		hint = carService.update(vo);
		HttpReturn.reponseBody(response, String.valueOf(hint));
	}
	
}
