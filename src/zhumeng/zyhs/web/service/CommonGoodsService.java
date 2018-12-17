package zhumeng.zyhs.web.service;

import java.util.List;

import zhumeng.zyhs.ssm.pojo.CommonGoods;


public interface CommonGoodsService {
    List<CommonGoods> getALL();
    
    List<CommonGoods> getByLevel(Integer level);
	
    CommonGoods getInfo(CommonGoods vo);
	
	int add(CommonGoods vo);
	
	int update(CommonGoods vo);
	
	//int updateByBelongs(MissingTools vo);
	
    int delete(Integer id);
	
	int deleteMany(Integer[] id);
}
