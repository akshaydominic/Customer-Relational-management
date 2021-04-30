package com.springboot.customerproject.customerthymleaf.Controller;


import com.springboot.customerproject.customerthymleaf.Service.customerService;
import com.springboot.customerproject.customerthymleaf.entity.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customers")
public class ControllerClass {
    @Autowired 
    private customerService thecustomers;
    @GetMapping("/list")
    public String get_customers(Model theModel){
        theModel.addAttribute("Customers", thecustomers.get_customers());
        return "customers";
    }

    @GetMapping("/addform")
    public String show_addForm(Model theModel){
        Customer thecustomer = new Customer();
        theModel.addAttribute("Customer",thecustomer);
        return "add-form";
    }

    @PostMapping("/save")
    public String save_Customers(@ModelAttribute("Customers") Customer thecustomersave){
        thecustomers.save_Customers(thecustomersave);
        return "redirect:/customers/list";
    }
    @GetMapping("/showFormForUpdate")
    public String update_form(@RequestParam("CustomerId") int theid,Model theModel){
        Customer thecustomerobj=thecustomers.updateByID(theid);
        theModel.addAttribute("Customer", thecustomerobj);
        return "add-form";
    }

    @GetMapping("/delete")
    public String delete_customer(@RequestParam("CustomerId")int theid){
        thecustomers.deletecustomer(theid);
        return "redirect:/customers/list";
    }
    
}
