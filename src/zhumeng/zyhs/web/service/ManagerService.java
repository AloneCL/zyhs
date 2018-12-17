package zhumeng.zyhs.web.service;

import zhumeng.zyhs.ssm.pojo.Manager;

public interface ManagerService {
	boolean login(Manager vo);

	int changeSelect(Manager vo);
}
