package zhumeng.zyhs.web.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zhumeng.zyhs.ssm.mapper.OrderMapper;
import zhumeng.zyhs.ssm.pojo.Orders;
import zhumeng.zyhs.web.service.OrdersService;

@Service
public class OrsersServiceImp implements OrdersService {
    
	@Autowired
	private OrderMapper mapper;
	
	@Override
	public List<Orders> getAll() {
		return mapper.selectAll();
	}

	@Override
	public List<Orders> getByStatus(Integer status) {
		return mapper.selectByStatus(status);
	}

	@Override
	public Orders getInfo(Orders vo) {
		return mapper.selectByPrimaryKey(vo.getId());
	}

	@Override
	public int add(Orders vo) {
		vo.setOrderIdentifier(UUID.randomUUID().toString());
		//System.out.println(new Date());
		vo.setReleaseTime((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
		vo.setOrderStatus(0);
		return mapper.insertSelective(vo);
	}

	@Override
	public int update(Orders vo) {
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

	@Override
	public List<Orders> getByUserId(Integer id) {
		return mapper.selectByUserId(id);
	}

	@Override
	public int updateStatus(Orders vo) {
		return mapper.updateStatus(vo);
	}

	@Override
	public Orders serchShoppingCar(Integer id) {
		return mapper.serchShoppingCar(id);
	}

	@Override
	public List<Orders> selectPage(Integer page) {
		System.out.println("page="+page);
		return mapper.selectPage(page);
	}

}
