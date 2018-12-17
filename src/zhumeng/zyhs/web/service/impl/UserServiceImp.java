package zhumeng.zyhs.web.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zhumeng.zyhs.ssm.mapper.UserMapper;
import zhumeng.zyhs.ssm.pojo.User;
import zhumeng.zyhs.web.service.UserService;

@Service
public class UserServiceImp implements UserService {
	private final UserMapper mapper;

	@Autowired
	public UserServiceImp(UserMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<User> getALL() {
		return mapper.selectAll();
	}

	@Override
	public User getUserInfo(User vo) {
		return mapper.selectByPrimaryKey(vo.getId());
	}

	@Override
	public int add(User vo) {
		return mapper.insertSelective(vo);
	}

	@Override
	public int login(User vo) {
		System.out.println(vo.toString());
		User temp = null;
		temp = mapper.login(vo);

		int hint = 0;
		if (temp != null) {
			System.out.println(temp.toString());
			hint = temp.getId();
		}
		return hint;
	}

	@Override
	public int update(User vo) {
		return mapper.updateByPrimaryKeySelective(vo);
	}

	@Override
	public int updateByUserTel(User vo) {
		return mapper.updateByUserTel(vo);
	}

	@Override
	public int delete(Integer id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int deleteMany(Integer[] id) {
		for (int i : id) {
			mapper.deleteByPrimaryKey(i);
		}
		return id.length;
	}

	@Override
	public int alive(User vo) {
		User u = new User();
		u = mapper.aliveUser(vo);
		int hint = 0;
		if(u!=null){
		   	hint = u.getId();
		}
		return hint;
				
	}

	@Override
	public List<User> getPage(Integer page) {
		return mapper.selectPage(page);
	}

	@Override
	public List<User> getByIdentity(Map map) {
		return mapper.selectByIdentity(map);
	}

	@Override
	public List<User> getApplicat() {
		// TODO Auto-generated method stub
		return mapper.selectApplicat();
	}

}
