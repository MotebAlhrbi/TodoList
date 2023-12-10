package com.Muteb.FirstPractes.repostory;


import com.Muteb.FirstPractes.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}