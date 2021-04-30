package com.springboot.customerproject.customerthymleaf.Service;

import com.springboot.customerproject.customerthymleaf.entity.Customer;




import java.util.List;

public interface customerService {
    public List<Customer> get_customers();

    public void save_Customers(Customer thecustomersave);

    public Customer updateByID(int theid);

    public void deletecustomer(int theid);
}
