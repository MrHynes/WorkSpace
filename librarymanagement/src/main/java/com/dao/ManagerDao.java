package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Manager;

public interface ManagerDao extends JpaRepository<Manager, Integer> {
	public Manager findByName(String name);
}
