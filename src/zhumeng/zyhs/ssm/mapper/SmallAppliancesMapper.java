package zhumeng.zyhs.ssm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import zhumeng.zyhs.ssm.pojo.SmallAppliances;

@Repository
public interface SmallAppliancesMapper {
    List<SmallAppliances> selectAll();
	
	List<SmallAppliances> selectByLevel(Integer level);
    
    int deleteByPrimaryKey(Integer id);

	//int insert(CommonGoods record);

	int insertSelective(SmallAppliances record);

	SmallAppliances selectByPrimaryKey(Integer id);
	
	int updateByPrimaryKeySelective(SmallAppliances record);
	
	//int updateByBelongsKeySelective(CommonGoods record);
	
}
