package zhumeng.zyhs.ssm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import zhumeng.zyhs.ssm.pojo.Washing;

@Repository
public interface WashingMapper {
    List<Washing> selectAll();
	
	List<Washing> selectByLevel(Integer level);
    
    int deleteByPrimaryKey(Integer id);

	//int insert(CommonGoods record);

	int insertSelective(Washing record);

	Washing selectByPrimaryKey(Integer id);
	
	int updateByPrimaryKeySelective(Washing record);
	
	//int updateByBelongsKeySelective(CommonGoods record);
	
}
