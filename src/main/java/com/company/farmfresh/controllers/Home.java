package com.company.farmfresh.controllers;

import com.company.farmfresh.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("listOfItems",itemService.listOfItems());
        return "index";
    }
}
