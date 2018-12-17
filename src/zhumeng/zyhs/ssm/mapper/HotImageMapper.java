package zhumeng.zyhs.ssm.mapper;

import org.springframework.stereotype.Repository;

import zhumeng.zyhs.ssm.pojo.HotImage;

@Repository
public interface HotImageMapper {
/*	int deleteByPrimaryKey(Integer userid);;*/

	HotImage select();
	

	int updateByPrimaryKeySelective(HotImage record);

/*	int updateByPrimaryKey(User record);

	User selectByUserName(String username);*/
}