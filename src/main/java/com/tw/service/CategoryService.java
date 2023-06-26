package com.tw.service;

import com.tw.model.Category;

public interface CategoryService {

	String saveCategory(Category category);
	
	String changeStatus(Long id);
	
}