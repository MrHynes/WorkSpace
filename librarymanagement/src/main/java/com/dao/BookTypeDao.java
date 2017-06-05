package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.entity.BookType;

public interface BookTypeDao extends JpaRepository<BookType, Integer>, JpaSpecificationExecutor<BookType> {

}
