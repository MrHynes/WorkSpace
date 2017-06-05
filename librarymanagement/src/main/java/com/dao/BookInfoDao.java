package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.entity.BookInfo;

public interface BookInfoDao extends JpaRepository<BookInfo, Integer>, JpaSpecificationExecutor<BookInfo> {

}
