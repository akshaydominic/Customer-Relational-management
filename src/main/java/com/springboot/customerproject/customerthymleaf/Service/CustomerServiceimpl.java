package com.springboot.customerproject.customerthymleaf.Service;

import java.util.List;
import java.util.Optional;

import com.springboot.customerproject.customerthymleaf.dao.customerdao;
import com.springboot.customerproject.customerthymleaf.entity.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CustomerServiceimpl implements customerService{

    @Autowired
    private customerdao thecustomerdao;
    @Override
    public List<Customer> get_customers() {
        return thecustomerdao.findAll();
    }
    @Override
    public void save_Customers(Customer thecustomersave) {
        thecustomerdao.save(thecustomersave);
        
    }
    @Override
    public Customer updateByID(int theid) {
        Optional<Customer> thecustomer = thecustomerdao.findById(theid);
        Customer customerobj = null;
        if(thecustomer.isPresent()){
            customerobj=thecustomer.get();
        }
        else{
            throw new RuntimeException("The id is found "+theid);
        }
        return customerobj;
    }
    @Override
    public void deletecustomer(int theid) {
        thecustomerdao.deleteById(theid);
        
    }

    
    
}
