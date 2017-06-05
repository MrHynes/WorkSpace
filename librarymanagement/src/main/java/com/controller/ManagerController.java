package com.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Manager;
import com.service.ManagerService;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	@Resource
	private ManagerService managerService;

	@RequestMapping("/login")
	public String managerLogin(Manager manager) {
		boolean result = managerService.managerLogin(manager);
		if (result) {
			return "redirect:/index.jsp";
		} else {
			return "redirect:/login.jsp";
		}
	}
}
