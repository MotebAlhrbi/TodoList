package com.Muteb.FirstPractes.Controlers;


import com.Muteb.FirstPractes.model.Customer;
import com.Muteb.FirstPractes.service.CustomerService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerControler {



    @Autowired
    CustomerService customerService;







    @GetMapping("/{email}")
    public List<Customer> getsortedbyemail(@PathVariable String email){

       return customerService.getusersorted(email);

    }



    @GetMapping("/page/{offset}/{pagesize}")

    public ResponseEntity getpag(@PathVariable int offset , @PathVariable int pagesize ){

      Page<Customer> customerPage = customerService.getpage(offset , pagesize);


      return new ResponseEntity<>(customerPage , HttpStatus.ACCEPTED);
    }



    @PostMapping(value = "/Create")
    @ResponseBody
    public ResponseEntity CreateCoustmer(@RequestBody Customer customer){

     Customer newCustomer =    customerService.CreateCustomer(customer);


        return new ResponseEntity<>(newCustomer , HttpStatus.CREATED);
    }




    @DeleteMapping("del/{id}")
    public String Del(@PathVariable Long id){

        customerService.del(id);

        return "done"+id;
    }


    @PutMapping("Mod/{id}")
    public String Mod(@RequestBody Customer customer , @PathVariable Long id){


        customerService.mod(id , customer);

        return "mod";
    }

    @GetMapping("/All")
    public Iterable<Customer> getall(){

      return    customerService.getAll();
    }

}
