package zhumeng.zyhs.ssm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import zhumeng.zyhs.ssm.pojo.AirCondition;
import zhumeng.zyhs.ssm.pojo.Refrigerator;

@Repository
public interface RefrigeratorMapper {
    List<Refrigerator> selectAll();
	
	List<Refrigerator> selectByLevel(Integer level);
    
    int deleteByPrimaryKey(Integer id);

	//int insert(CommonGoods record);

	int insertSelective(Refrigerator record);

	Refrigerator selectByPrimaryKey(Integer id);
	
	int updateByPrimaryKeySelective(Refrigerator record);
	
	//int updateByBelongsKeySelective(CommonGoods record);
	
}
