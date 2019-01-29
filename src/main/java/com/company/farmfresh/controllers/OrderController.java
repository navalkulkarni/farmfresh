package com.company.farmfresh.controllers;

import com.company.farmfresh.model.Order;
import com.company.farmfresh.model.User;
import com.company.farmfresh.service.ItemService;
import com.company.farmfresh.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/orders")
    public String getOrdersForUser(Model model, HttpSession session){

        Order order=new Order();
        model.addAttribute("order",order);

        model.addAttribute("loggedinuser",(User)session.getAttribute("loggedinuser"));
        model.addAttribute("user",(User)session.getAttribute("user"));
        return "order";
    }
}
