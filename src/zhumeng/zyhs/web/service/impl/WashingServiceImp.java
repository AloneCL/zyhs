package zhumeng.zyhs.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zhumeng.zyhs.ssm.mapper.WashingMapper;
import zhumeng.zyhs.ssm.pojo.Television;
import zhumeng.zyhs.ssm.pojo.Washing;
import zhumeng.zyhs.web.service.WashingService;

@Service
public class WashingServiceImp implements WashingService {
    
	
	@Autowired
	private WashingMapper mapper;
	
	@Override
	public List<Washing> getALL() {
		return mapper.selectAll();
	}

	@Override
	public List<Washing> getByLevel(Integer level) {
		return mapper.selectByLevel(level);
	}

	@Override
	public Washing getInfo(Washing vo) {
		return mapper.selectByPrimaryKey(vo.getId());
	}

	@Override
	public int add(Washing vo) {
		return mapper.insertSelective(vo);
	}

	@Override
	public int update(Washing vo) {
		return mapper.updateByPrimaryKeySelective(vo);
	}

	@Override
	public int delete(Integer id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int deleteMany(Integer[] id) {
        for (Integer integer : id) {
			mapper.deleteByPrimaryKey(integer);
		}
		return id.length;
	}

}
