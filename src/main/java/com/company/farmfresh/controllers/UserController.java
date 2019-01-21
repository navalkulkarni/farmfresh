package com.company.farmfresh.controllers;

import com.company.farmfresh.model.User;
import com.company.farmfresh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/signup")
    public String newUser(Map map)
    {
        User u=new User();
        map.put("user",u);
        return "signup";
    }


    @RequestMapping(value = "/adduser",method = RequestMethod.POST)
    public String addUser(User u,RedirectAttributes redirectAttributes)
    {
        userService.addUser(u);
        redirectAttributes.addFlashAttribute("success","Signup Successful");
        return "redirect:/";
    }


}
