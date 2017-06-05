package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ManagerDao;
import com.entity.Manager;
import com.service.ManagerService;

@Service("managerService")
public class ManagerServiceImpl implements ManagerService {
	@Autowired
	private ManagerDao managerDao;

	public boolean managerLogin(Manager manager) {
		Manager mr = managerDao.findByName(manager.getName());
		if (mr == null || !mr.getPWD().equals(manager.getPWD())) {
			return false;
		}
		return true;
	}
}
