package zhumeng.zyhs.ssm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import zhumeng.zyhs.ssm.pojo.Goods;

@Repository
public interface GoodsMapper {
 
   List<Goods> selectByOrdersId(Integer id);
   
   Goods selectByPrimaryKey(Integer id);
   
   int insertSelective(Goods vo);
   
   int deleteByPrimaryKey(Integer id);
   
   int updateSelective(Goods vo);
}
