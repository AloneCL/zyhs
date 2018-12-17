package zhumeng.zyhs.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zhumeng.zyhs.ssm.mapper.GoodsLevelMapper;
import zhumeng.zyhs.ssm.pojo.GoodsLevel;
import zhumeng.zyhs.web.service.GoodsLevelService;

@Service
public class GoodsLevelServiceImp implements GoodsLevelService {
    
	@Autowired
	private GoodsLevelMapper goodsMapper;
	
	@Override
	public List<GoodsLevel> getAll() {
		return goodsMapper.selectAll();
	}

	@Override
	public GoodsLevel getInfo(GoodsLevel vo) {
		return goodsMapper.selectByPrimaryKeySelective(vo.getId());
	}

	@Override
	public int delete(Integer id) {
		return goodsMapper.deleteByPrimaryKeySelective(id);
	}

	@Override
	public int deleteMany(Integer[] id) {
		for(Integer i : id){
			goodsMapper.deleteByPrimaryKeySelective(i);
		}
		return id.length;
	}

	@Override
	public int update(GoodsLevel vo) {
		return goodsMapper.updateByPrimaryKeySelective(vo);
	}

	@Override
	public int add(GoodsLevel vo) {
		return goodsMapper.insertSelective(vo);
	}

	@Override
	public List<GoodsLevel> getPage(Integer page) {
		return goodsMapper.selectPage(page);
	}

}
