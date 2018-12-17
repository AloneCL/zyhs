package zhumeng.zyhs.ssm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import zhumeng.zyhs.ssm.pojo.Cars;


@Repository
public interface CarsMapper {
    List<Cars> selectAll();
	
	List<Cars> selectByLevel(Integer level);
    
    int deleteByPrimaryKey(Integer id);

	//int insert(CommonGoods record);

	int insertSelective(Cars record);

	Cars selectByPrimaryKey(Integer id);
	
	int updateByPrimaryKeySelective(Cars record);
	
	//int updateByBelongsKeySelective(CommonGoods record);
	
}
