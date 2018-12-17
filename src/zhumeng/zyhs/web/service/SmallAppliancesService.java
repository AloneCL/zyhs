package zhumeng.zyhs.web.service;

import java.util.List;

import zhumeng.zyhs.ssm.pojo.CommonGoods;
import zhumeng.zyhs.ssm.pojo.SmallAppliances;


public interface SmallAppliancesService {
    List<SmallAppliances> getALL();
    
    List<SmallAppliances> getByLevel(Integer level);
	
    SmallAppliances getInfo(SmallAppliances vo);
	
	int add(SmallAppliances vo);
	
	int update(SmallAppliances vo);
	
	//int updateByBelongs(MissingTools vo);
	
    int delete(Integer id);
	
	int deleteMany(Integer[] id);
}
