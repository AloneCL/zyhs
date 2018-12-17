package zhumeng.zyhs.ssm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import zhumeng.zyhs.ssm.pojo.Orders;
import zhumeng.zyhs.ssm.pojo.User;

@Repository
public interface OrderMapper {
    
	List<Orders> selectAll();          //选择所有订单
	
	List<Orders> selectPage(Integer page);      //动态查询
    
	List<Orders> selectByUserId(Integer id);   // 根据用户的id来查看指定用户的订单
	
	List<Orders> getWaitOrder();        //根据地区来获取相应的等待接单的订单
	
	int updateStatus(Orders vo);           //更新订单状态
	
    int deleteByPrimaryKey(Integer id);       // 根据主键来删除订单
    
    int insertSelective(Orders vo);          // 插入订单
    
    Orders selectByPrimaryKey(Integer id);    //根据id选择订单
    
    int updateByPrimaryKeySelective(Orders vo);   //根据订单id来更新订单信息
    
    List<Orders> selectByStatus(Integer num);       //根据订单状态来获取订单
    
    Orders serchShoppingCar(Integer userid);      //根据用户id来查看用户的购物车
}
