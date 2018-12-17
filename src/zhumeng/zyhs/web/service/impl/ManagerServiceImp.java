package zhumeng.zyhs.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zhumeng.zyhs.ssm.mapper.ManagerMapper;
import zhumeng.zyhs.ssm.pojo.Manager;
import zhumeng.zyhs.web.service.ManagerService;

@Service
public class ManagerServiceImp implements ManagerService {
	private final ManagerMapper mapper;

	@Autowired
	public ManagerServiceImp(ManagerMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public boolean login(Manager vo) {
		Manager manager = mapper.selectByUserName(vo.getName());
		if (manager == null) return false;
		else if (manager.getPassword().equals(vo.getPassword())) {
			vo.setId(manager.getId());
			return true;
		} else return false;
	}

	@Override
	public int changeSelect(Manager vo) {
		return mapper.updateByPrimaryKeySelective(vo);
	}

}
