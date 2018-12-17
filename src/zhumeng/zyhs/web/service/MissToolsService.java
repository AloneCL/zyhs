package zhumeng.zyhs.web.service;

import java.util.List;
import java.util.Map;

import zhumeng.zyhs.ssm.pojo.MissingTools;
import zhumeng.zyhs.ssm.pojo.User;


public interface MissToolsService {
    List<MissingTools> getALL();
    
    List<MissingTools> getPage(Integer page);
    
    List<MissingTools> getGoodsBl(Map map);
	
	MissingTools getInfo(MissingTools vo);
	
	int add(MissingTools vo);
	
	int update(MissingTools vo);
	
	int updateByBelongs(MissingTools vo);
	
    int delete(Integer id);
	
	int deleteMany(Integer[] id);
}
