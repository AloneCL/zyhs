package zhumeng.zyhs.ssm.mapper;

import org.springframework.stereotype.Repository;

import zhumeng.zyhs.ssm.pojo.Manager;

@Repository
public interface ManagerMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Manager record);

	int insertSelective(Manager record);

	Manager selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Manager record);

	int updateByPrimaryKey(Manager record);

	Manager selectByUserName(String name);
}