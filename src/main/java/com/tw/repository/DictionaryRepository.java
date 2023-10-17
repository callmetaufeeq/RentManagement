package com.tw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tw.model.DictionaryCount;

public interface DictionaryRepository extends JpaRepository<DictionaryCount, Long>{
	
	
	DictionaryCount getByType(String type);

}
