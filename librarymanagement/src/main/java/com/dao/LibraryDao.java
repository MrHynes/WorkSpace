package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.entity.Library;

public interface LibraryDao extends JpaRepository<Library, Integer>, JpaSpecificationExecutor<Library> {

}
