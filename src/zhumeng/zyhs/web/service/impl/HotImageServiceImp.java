package zhumeng.zyhs.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zhumeng.zyhs.ssm.mapper.HotImageMapper;
import zhumeng.zyhs.ssm.pojo.HotImage;
import zhumeng.zyhs.web.service.HotImageService;

@Service
public class HotImageServiceImp implements HotImageService {
	private final HotImageMapper mapper;

	@Autowired
	public HotImageServiceImp(HotImageMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public HotImage getInfo() {
		HotImage himage = mapper.select();
		return himage;

	}

	@Override
	public int update(HotImage vo) {
		return mapper.updateByPrimaryKeySelective(vo);
	}
    
	


}
