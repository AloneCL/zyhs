package zhumeng.zyhs.web.service;

import java.util.List;

import zhumeng.zyhs.ssm.pojo.Cars;
import zhumeng.zyhs.ssm.pojo.Goods;


public interface GoodsService {
    List<Goods> getByOrdersId(Integer id);
    
    Goods getInfo(Goods vo);
	
	int add(Goods vo);
	
	int update(Goods vo);
	
	//int updateByBelongs(MissingTools vo);
	
    int delete(Integer id);
	
	int deleteMany(Integer[] id);
}
