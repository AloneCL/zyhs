package zhumeng.zyhs.web.service;

import java.util.List;

import zhumeng.zyhs.ssm.pojo.Washing;


public interface WashingService {
    List<Washing> getALL();
    
    List<Washing> getByLevel(Integer level);
	
    Washing getInfo(Washing vo);
	
	int add(Washing vo);
	
	int update(Washing vo);
	
	//int updateByBelongs(MissingTools vo);
	
    int delete(Integer id);
	
	int deleteMany(Integer[] id);
}
