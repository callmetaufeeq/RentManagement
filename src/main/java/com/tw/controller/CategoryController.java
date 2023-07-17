package com.tw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tw.model.Category;
import com.tw.service.CategoryService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/save")
	public String category(@RequestBody Category category) {
		String saveCategory = categoryService.saveCategory(category);
		return saveCategory;
	}
	
	@GetMapping("/changeStatus")
	public String changeStatus(@PathParam("id") Long id) {
		return categoryService.changeStatus(id);
	}
	
	@GetMapping("/list")
	public List<Category>getCategory() {
		return categoryService.getCategory();
	}
	
	@GetMapping("/delete")
	public String deleteById(@PathParam("id")Long id) {
		
		return categoryService.categoryDelete(id);
	}
	
}
