package zhumeng.zyhs.web.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zhumeng.zyhs.ssm.mapper.GoodsMapper;
import zhumeng.zyhs.ssm.pojo.Goods;
import zhumeng.zyhs.web.service.GoodsService;

@Service
public class GoodsServiceImp implements GoodsService {
    
	@Autowired
	private GoodsMapper mapper;
	
	@Override
	public List<Goods> getByOrdersId(Integer id) {
		return mapper.selectByOrdersId(id);
	}

	@Override
	public Goods getInfo(Goods vo) {
		return mapper.selectByPrimaryKey(vo.getGoodsId());
	}

	@Override
	public int add(Goods vo) {
		return mapper.insertSelective(vo);
	}

	@Override
	public int update(Goods vo) {
		return mapper.updateSelective(vo);
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
