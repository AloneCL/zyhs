package zhumeng.zyhs.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zhumeng.zyhs.ssm.mapper.CommonGoodsMapper;
import zhumeng.zyhs.ssm.pojo.CommonGoods;
import zhumeng.zyhs.web.service.CommonGoodsService;

@Service
public class CommonGoodsServiceImp implements CommonGoodsService {
    
	@Autowired
	private CommonGoodsMapper CommonMapper;
	
	@Override
	public List<CommonGoods> getALL() {
		return CommonMapper.selectAll();
	}

	@Override
	public List<CommonGoods> getByLevel(Integer level) {
		return CommonMapper.selectByLevel(level);
	}

	@Override
	public CommonGoods getInfo(CommonGoods vo) {
		return CommonMapper.selectByPrimaryKey(vo.getId());
	}

	@Override
	public int add(CommonGoods vo) {
		return CommonMapper.insertSelective(vo);
	}

	@Override
	public int update(CommonGoods vo) {
		return CommonMapper.updateByPrimaryKeySelective(vo);
	}

	@Override
	public int delete(Integer id) {
		return CommonMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int deleteMany(Integer[] id) {
        for (Integer integer : id) {
			CommonMapper.deleteByPrimaryKey(integer);
		}
		return id.length;
	}

}
