package zhumeng.zyhs.ssm.mapper;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import zhumeng.zyhs.ssm.pojo.User;

@Repository
public interface UserMapper {
	
	List<User> selectAll();
	
	List<User> selectByIdentity(Map map);
	
	List<User> selectApplicat();
	
	int deleteByPrimaryKey(Integer id);

	int insert(User record);
	
	List<User> selectPage(Integer page);
	
	User aliveUser(User vo);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer id);
	
	User login(User record);

	int updateByPrimaryKeySelective(User record);
	
	int updateByUserTel(User record);

/*	int updateByPrimaryKey(User record);

	User selectByUserName(String username);*/
}