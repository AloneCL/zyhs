package zhumeng.zyhs.web.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zhumeng.zyhs.ssm.mapper.MissingToolsMapper;
import zhumeng.zyhs.ssm.pojo.MissingTools;
import zhumeng.zyhs.web.service.MissToolsService;

@Service
public class MissingToolsServiceImp implements MissToolsService{
    
	@Autowired
	private MissingToolsMapper mapper; 
	
	@Override
	public List<MissingTools> getALL() {
		return mapper.selectAll();
	}

	@Override
	public MissingTools getInfo(MissingTools vo) {
		return mapper.selectByPrimaryKey(vo.getId());
	}

	@Override
	public int add(MissingTools vo) {
		return mapper.insertSelective(vo);
	}

	@Override
	public int update(MissingTools vo) {
		return mapper.updateByPrimaryKeySelective(vo);
	}

	@Override
	public int updateByBelongs(MissingTools vo) {
		return mapper.updateByBelongsKeySelective(vo);
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

	@Override
	public List<MissingTools> getGoodsBl(Map map) {
		return mapper.selectByBlGoods(map);
	}

	@Override
	public List<MissingTools> getPage(Integer page) {
		return mapper.selectPage(page);
	}



}
