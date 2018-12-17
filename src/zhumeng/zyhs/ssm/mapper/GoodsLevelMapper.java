package zhumeng.zyhs.ssm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import zhumeng.zyhs.ssm.pojo.GoodsLevel;

@Repository
public interface GoodsLevelMapper {
    
	List<GoodsLevel> selectAll();
	
	List<GoodsLevel> selectPage(Integer page);
	
	GoodsLevel selectByPrimaryKeySelective(Integer id);

	int updateByPrimaryKeySelective(GoodsLevel record);
	
	int insertSelective(GoodsLevel record);
	
	int deleteByPrimaryKeySelective(Integer id);
}
