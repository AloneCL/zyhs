package zhumeng.zyhs.web.service;

import java.util.List;

import zhumeng.zyhs.ssm.pojo.GoodsLevel;

public interface GoodsLevelService {
    List<GoodsLevel> getAll();
    
    List<GoodsLevel> getPage(Integer page);
    
    GoodsLevel getInfo(GoodsLevel vo);
    
    int delete(Integer id);
    
    int deleteMany(Integer[] id);
    
    int update(GoodsLevel vo);
    
    int add(GoodsLevel vo);
}
