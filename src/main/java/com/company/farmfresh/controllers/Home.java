package com.company.farmfresh.controllers;

import com.company.farmfresh.model.Item;
import com.company.farmfresh.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
public class Home {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("listOfItems",itemService.listOfItems());
        return "index";
    }

    @RequestMapping("/newItem")
    public String newItem(Map map){
        Item item=new Item();
        map.put("newItem",item);
        return "newItem";
    }

    @RequestMapping(value = "/addItem",method = RequestMethod.POST)
    public String addItem(Item item, RedirectAttributes redirectAttributes){
        itemService.addItem(item);
        redirectAttributes.addFlashAttribute("addSuccess","Items added successfully");
        return "redirect:/admin";
    }

    @RequestMapping("/admin")
    public String showItemsToAdmin(Map map){
        map.put("listOfItems",itemService.listOfItems());
        return "admin";
    }

    @RequestMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable int id,RedirectAttributes redirectAttributes){

        Item item=itemService.findIteamById(id);
        itemService.deleteItem(item);
        redirectAttributes.addFlashAttribute("deleteSuccess","Deleted item with id"+id);
        return "redirect:/admin";
    }
}
