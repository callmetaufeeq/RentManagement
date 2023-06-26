package com.tw.service;

import java.util.List;

import com.tw.model.Category;

public interface CategoryService {

	String saveCategory(Category category);
	
	String changeStatus(Long id);
	
	List<Category>getCategory();
	
	String categoryDelete(Long id);
	
}