package zhumeng.zyhs.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zhumeng.zyhs.ssm.mapper.RefrigeratorMapper;
import zhumeng.zyhs.ssm.pojo.AirCondition;
import zhumeng.zyhs.ssm.pojo.Refrigerator;
import zhumeng.zyhs.web.service.RefrigeratorService;

@Service
public class RefrigeratorServiceImp implements RefrigeratorService {
    
	
	@Autowired
	private RefrigeratorMapper mapper;
	
	@Override
	public List<Refrigerator> getALL() {
		return mapper.selectAll();
	}

	@Override
	public List<Refrigerator> getByLevel(Integer level) {
		return mapper.selectByLevel(level);
	}

	@Override
	public Refrigerator getInfo(Refrigerator vo) {
		return mapper.selectByPrimaryKey(vo.getId());
	}

	@Override
	public int add(Refrigerator vo) {
		return mapper.insertSelective(vo);
	}

	@Override
	public int update(Refrigerator vo) {
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
