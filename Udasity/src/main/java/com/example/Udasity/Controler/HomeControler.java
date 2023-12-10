package com.example.Udasity.Controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeControler {


    @RequestMapping(value = "/home")
    public String getHome(Model model){
model.addAttribute("hi" , "hafer");

        return "Home";
    }
}
