package zhumeng.zyhs.web.service;

import java.util.List;

import zhumeng.zyhs.ssm.pojo.AirCondition;
import zhumeng.zyhs.ssm.pojo.Refrigerator;


public interface RefrigeratorService {
    List<Refrigerator> getALL();
    
    List<Refrigerator> getByLevel(Integer level);
	
    Refrigerator getInfo(Refrigerator vo);
	
	int add(Refrigerator vo);
	
	int update(Refrigerator vo);
	
	//int updateByBelongs(MissingTools vo);
	
    int delete(Integer id);
	
	int deleteMany(Integer[] id);
}
