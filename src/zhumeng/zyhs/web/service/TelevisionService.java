package zhumeng.zyhs.web.service;

import java.util.List;

import zhumeng.zyhs.ssm.pojo.Refrigerator;
import zhumeng.zyhs.ssm.pojo.Television;


public interface TelevisionService {
    List<Television> getALL();
    
    List<Television> getByLevel(Integer level);
	
    Television getInfo(Television vo);
	
	int add(Television vo);
	
	int update(Television vo);
	
	//int updateByBelongs(MissingTools vo);
	
    int delete(Integer id);
	
	int deleteMany(Integer[] id);
}
