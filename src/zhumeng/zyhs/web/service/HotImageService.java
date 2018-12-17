package zhumeng.zyhs.web.service;

import zhumeng.zyhs.ssm.pojo.HotImage;

public interface HotImageService {

	HotImage getInfo();
	
	int update(HotImage vo);
	
}
