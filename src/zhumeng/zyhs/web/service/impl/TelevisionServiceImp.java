package zhumeng.zyhs.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zhumeng.zyhs.ssm.mapper.TelevisionMapper;
import zhumeng.zyhs.ssm.pojo.AirCondition;
import zhumeng.zyhs.ssm.pojo.Television;
import zhumeng.zyhs.web.service.TelevisionService;

@Service
public class TelevisionServiceImp implements TelevisionService {
    
	
	@Autowired
	private TelevisionMapper mapper;
	
	@Override
	public List<Television> getALL() {
		return mapper.selectAll();
	}

	@Override
	public List<Television> getByLevel(Integer level) {
		return mapper.selectByLevel(level);
	}

	@Override
	public Television getInfo(Television vo) {
		return mapper.selectByPrimaryKey(vo.getId());
	}

	@Override
	public int add(Television vo) {
		return mapper.insertSelective(vo);
	}

	@Override
	public int update(Television vo) {
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
