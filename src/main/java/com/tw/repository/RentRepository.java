package com.tw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tw.model.Rent;

public interface RentRepository extends JpaRepository<Rent, Long> {

}
