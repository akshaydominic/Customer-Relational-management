package com.springboot.customerproject.customerthymleaf.dao;

import com.springboot.customerproject.customerthymleaf.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface customerdao extends JpaRepository<Customer,Integer>{
    

}


