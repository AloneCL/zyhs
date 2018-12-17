package zhumeng.zyhs.web.service;

import java.util.List;

import zhumeng.zyhs.ssm.pojo.Cars;


public interface CarsService {
    List<Cars> getALL();
    
    List<Cars> getByLevel(Integer level);
	
    Cars getInfo(Cars vo);
	
	int add(Cars vo);
	
	int update(Cars vo);
	
	//int updateByBelongs(MissingTools vo);
	
    int delete(Integer id);
	
	int deleteMany(Integer[] id);
}
