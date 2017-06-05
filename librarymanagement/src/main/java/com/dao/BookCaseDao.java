package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.entity.BookCase;

/**
 * 1.JpaRepository接口进行简单的curd操作 2.JpaSpecificationExecutor接口可进行复制的条件查询
 * 
 * @description:TODO
 * @author:Allen Walker
 * @time:2017年5月31日 上午10:07:22
 */
public interface BookCaseDao extends JpaRepository<BookCase, Integer>, JpaSpecificationExecutor<BookCase> {

}
