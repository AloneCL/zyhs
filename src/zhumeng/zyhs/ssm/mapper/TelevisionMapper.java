package zhumeng.zyhs.ssm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import zhumeng.zyhs.ssm.pojo.Refrigerator;
import zhumeng.zyhs.ssm.pojo.Television;

@Repository
public interface TelevisionMapper {
    List<Television> selectAll();
	
	List<Television> selectByLevel(Integer level);
    
    int deleteByPrimaryKey(Integer id);

	//int insert(CommonGoods record);

	int insertSelective(Television record);

	Television selectByPrimaryKey(Integer id);
	
	int updateByPrimaryKeySelective(Television record);
	
	//int updateByBelongsKeySelective(CommonGoods record);
	
}
