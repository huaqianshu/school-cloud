package com.user_service.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.school.base.entity.School;

@Transactional
public interface SchoolDao extends JpaRepository<School,Long>{
	School findByName(String name);
	List<School> findAll();
}
