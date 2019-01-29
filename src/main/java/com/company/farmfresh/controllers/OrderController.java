package com.company.farmfresh.controllers;

import com.company.farmfresh.model.Order;
import com.company.farmfresh.model.User;
import com.company.farmfresh.service.ItemService;
import com.company.farmfresh.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

import java.time.LocalDate;
import java.util.List;

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
    @RequestMapping(value = "/orders/submit",method = RequestMethod.POST)
    public String submitOrder(Order order, RedirectAttributes attributes, HttpSession session){

        if ((order != null)) {

            User newUser=(User)session.getAttribute("user");

            User existingUser=(User) session.getAttribute("loggedinuser");

            order.setItemList((List)session.getAttribute("kart"));


            order.setDate(LocalDate.now());

            order.setTotalPrice((int)session.getAttribute("price"));

            if ((newUser == null)) {
                order.setUser(existingUser);
            } else {
                order.setUser(newUser);
            }

            orderService.addOrder(order);
            itemService.updateItemQuantity(order.getItemList());
            ((List) session.getAttribute("kart")).clear();
            session.removeAttribute("kart");
            session.removeAttribute("price");


        } else {
            attributes.addFlashAttribute("orderFailedMessage", "Something went wrong");
            return "redirect:kart";
        }
        return "redirect:/";
    }
}
