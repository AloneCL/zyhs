package zhumeng.zyhs.ssm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import zhumeng.zyhs.ssm.pojo.CommonGoods;
import zhumeng.zyhs.ssm.pojo.MissingTools;

@Repository
public interface CommonGoodsMapper {
    List<CommonGoods> selectAll();
	
	List<CommonGoods> selectByLevel(Integer level);
    
    int deleteByPrimaryKey(Integer id);

	//int insert(CommonGoods record);

	int insertSelective(CommonGoods record);

	CommonGoods selectByPrimaryKey(Integer id);
	
	int updateByPrimaryKeySelective(CommonGoods record);
	
	//int updateByBelongsKeySelective(CommonGoods record);
	
}
