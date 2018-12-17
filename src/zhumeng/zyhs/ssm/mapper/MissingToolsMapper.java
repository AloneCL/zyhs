package zhumeng.zyhs.ssm.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import zhumeng.zyhs.ssm.pojo.MissingTools;
import zhumeng.zyhs.ssm.pojo.User;

@Repository
public interface MissingToolsMapper {
    List<MissingTools> selectAll();  //查询所有缺件   
	
    List<MissingTools> selectPage(Integer page);
    //根据商品id和级别来查询指定商品包含的缺件
    List<MissingTools> selectByBlGoods(Map map);
    
	int deleteByPrimaryKey(Integer id);   //根据主键删除

	int insert(MissingTools record);     //插入

	int insertSelective(MissingTools record);

	MissingTools selectByPrimaryKey(Integer id);    //根据id选中相应缺件
	
	int updateByPrimaryKeySelective(MissingTools record);  //根据主键来修改缺件信息
	
	int updateByBelongsKeySelective(MissingTools record);   //根据目录级别来修改
	
}
