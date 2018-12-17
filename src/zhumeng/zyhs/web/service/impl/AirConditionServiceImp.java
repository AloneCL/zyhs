package zhumeng.zyhs.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zhumeng.zyhs.ssm.mapper.AirConditionMapper;
import zhumeng.zyhs.ssm.pojo.AirCondition;
import zhumeng.zyhs.web.service.AirConditionService;

@Service
public class AirConditionServiceImp implements AirConditionService {
    
	
	@Autowired
	private AirConditionMapper mapper;
	
	@Override
	public List<AirCondition> getALL() {
		return mapper.selectAll();
	}

	@Override
	public List<AirCondition> getByLevel(Integer level) {
		return mapper.selectByLevel(level);
	}

	@Override
	public AirCondition getInfo(AirCondition vo) {
		return mapper.selectByPrimaryKey(vo.getId());
	}

	@Override
	public int add(AirCondition vo) {
		return mapper.insertSelective(vo);
	}

	@Override
	public int update(AirCondition vo) {
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
