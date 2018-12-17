package zhumeng.zyhs.web.service;

import java.util.List;

import zhumeng.zyhs.ssm.pojo.AirCondition;
import zhumeng.zyhs.ssm.pojo.SmallAppliances;


public interface AirConditionService {
    List<AirCondition> getALL();
    
    List<AirCondition> getByLevel(Integer level);
	
    AirCondition getInfo(AirCondition vo);
	
	int add(AirCondition vo);
	
	int update(AirCondition vo);
	
	//int updateByBelongs(MissingTools vo);
	
    int delete(Integer id);
	
	int deleteMany(Integer[] id);
}
