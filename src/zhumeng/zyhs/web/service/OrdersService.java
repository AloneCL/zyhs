package zhumeng.zyhs.web.service;

import java.util.List;

import zhumeng.zyhs.ssm.pojo.Orders;

public interface OrdersService {
	List<Orders> getAll();
    
	List<Orders> getByUserId(Integer id);
	 
	List<Orders> selectPage(Integer page);
	
	List<Orders> getByStatus(Integer status);

	Orders getInfo(Orders vo);
	
	Orders serchShoppingCar(Integer id);

	int add(Orders vo);

	int update(Orders vo);
	
	int updateStatus(Orders vo);

	int delete(Integer id);

	int deleteMany(Integer[] id);
}
