package zhumeng.zyhs.web.service;

import java.util.List;
import java.util.Map;

import zhumeng.zyhs.ssm.pojo.User;


public interface UserService {
    List<User> getALL();
    
    List<User> getPage(Integer page);
    
    List<User> getApplicat();
	
    List<User> getByIdentity(Map map);
	
    User getUserInfo(User vo);
	
	int add(User vo);
	
	int alive(User vo);
	
	int login(User vo);
	
	int update(User vo);
	
	int updateByUserTel(User vo);
	
    int delete(Integer id);
	
	int deleteMany(Integer[] id);
}
