package com.tw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tw.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	

}
