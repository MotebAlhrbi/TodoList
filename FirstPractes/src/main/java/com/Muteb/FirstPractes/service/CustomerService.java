package com.Muteb.FirstPractes.service;


import com.Muteb.FirstPractes.model.Customer;
import com.Muteb.FirstPractes.repostory.CustomerRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class CustomerService {


    @Autowired
    CustomerRepository customerRepository;


    public Customer CreateCustomer(Customer customer){

        customerRepository.save(customer);

        return customer;
    }


public void del(Long id){

        customerRepository.deleteById(id);
    }



    public void mod(Long id , Customer customer){



       customerRepository.deleteById(id);

       customerRepository.save(customer);


    }
    public Iterable<Customer> getAll(){

        return customerRepository.findAll();
    }



public List<Customer> getusersorted(String email){

        return customerRepository.findAll(Sort.by(email));

}


//    @PostConstruct
//    public void createusers() {
//
//      List<Customer> customers = IntStream.rangeClosed(1, 200).mapToObj(i -> new Customer("user" , "user"+new Random().nextInt(100)+"@gmail" , new Random().nextInt(100))).collect(Collectors.toList());
//
//
//      customerRepository.saveAll(customers);
//    }


public Page<Customer> getpage(int offset , int pagesize){


    Page<Customer> Customer = customerRepository.findAll(PageRequest.of(offset , pagesize));

        return Customer;

}

}
