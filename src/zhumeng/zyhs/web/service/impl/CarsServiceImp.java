package zhumeng.zyhs.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zhumeng.zyhs.ssm.mapper.CarsMapper;
import zhumeng.zyhs.ssm.pojo.Cars;
import zhumeng.zyhs.ssm.pojo.Television;
import zhumeng.zyhs.web.service.CarsService;

@Service
public class CarsServiceImp implements CarsService {
    
	
	@Autowired
	private CarsMapper mapper;
	
	@Override
	public List<Cars> getALL() {
		return mapper.selectAll();
	}

	@Override
	public List<Cars> getByLevel(Integer level) {
		return mapper.selectByLevel(level);
	}

	@Override
	public Cars getInfo(Cars vo) {
		return mapper.selectByPrimaryKey(vo.getId());
	}

	@Override
	public int add(Cars vo) {
		return mapper.insertSelective(vo);
	}

	@Override
	public int update(Cars vo) {
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
