package com.tw.customRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tw.model.Rent;

public interface ReceiptRepository extends JpaRepository<Rent, Long>  {

}
