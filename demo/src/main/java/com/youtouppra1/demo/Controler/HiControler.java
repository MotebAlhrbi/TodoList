package com.youtouppra1.demo.Controler;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiControler {


    @GetMapping("/")
    public  String getHi(){

        return "Hi you";


    }
}
