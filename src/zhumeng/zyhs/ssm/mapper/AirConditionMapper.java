package zhumeng.zyhs.ssm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import zhumeng.zyhs.ssm.pojo.AirCondition;
import zhumeng.zyhs.ssm.pojo.SmallAppliances;

@Repository
public interface AirConditionMapper {
    List<AirCondition> selectAll();
	
	List<AirCondition> selectByLevel(Integer level);
    
    int deleteByPrimaryKey(Integer id);

	//int insert(CommonGoods record);

	int insertSelective(AirCondition record);

	AirCondition selectByPrimaryKey(Integer id);
	
	int updateByPrimaryKeySelective(AirCondition record);
	
	//int updateByBelongsKeySelective(CommonGoods record);
	
}
