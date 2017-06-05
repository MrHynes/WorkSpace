package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.entity.Publishing;

public interface PublishingDao extends JpaRepository<Publishing, String>, JpaSpecificationExecutor<Publishing> {

}
