package com.tw.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tw.model.Category;
import com.tw.repository.CategoryRepository;
import com.tw.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public String saveCategory(Category category) {
		categoryRepository.save(category);
		return "saved !";
	}

	@Override
	public String changeStatus(Long id) {
		Category obj = categoryRepository.getById(id);
		categoryRepository.save(obj);
		obj.setStatus(0);
		return "Changed Successfully!";
	}

	@Override
	public List<Category> getCategory() {
		return categoryRepository.findAll();
	}

	@Override
	public String categoryDelete(Long id) {
		categoryRepository.deleteById(id);
		return "Deleted";
	}

	

}
