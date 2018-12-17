package zhumeng.zyhs.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zhumeng.zyhs.ssm.mapper.SmallAppliancesMapper;
import zhumeng.zyhs.ssm.pojo.SmallAppliances;
import zhumeng.zyhs.web.service.SmallAppliancesService;

@Service
public class SmallAppliancesServiceImp implements SmallAppliancesService{
    
	@Autowired
	private SmallAppliancesMapper mapper;
	
	@Override
	public List<SmallAppliances> getALL() {
		return mapper.selectAll();
	}

	@Override
	public List<SmallAppliances> getByLevel(Integer level) {
		return mapper.selectByLevel(level);
	}

	@Override
	public SmallAppliances getInfo(SmallAppliances vo) {
		return mapper.selectByPrimaryKey(vo.getId());
	}

	@Override
	public int add(SmallAppliances vo) {
		return mapper.insertSelective(vo);
	}

	@Override
	public int update(SmallAppliances vo) {
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
