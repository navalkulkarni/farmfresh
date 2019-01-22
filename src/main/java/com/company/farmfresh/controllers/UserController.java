package com.company.farmfresh.controllers;

import com.company.farmfresh.model.User;
import com.company.farmfresh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.constraints.Null;
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
        redirectAttributes.addFlashAttribute("signedUp","Signup Successful");
        return "redirect:/";
    }

    @RequestMapping("/login")
    public String loginUser(Map map)
    {
        User u=new User();
        map.put("user",u);
        return "login";
    }

    @RequestMapping(value ="/userlogin",method =RequestMethod.POST)
    public String checkUser(User u,RedirectAttributes redirectAttributes)
    {
        User u1=userService.findByEmail(u.getEmail());
        if(u1!=null)
        {
            redirectAttributes.addFlashAttribute("loggedIn","Login Successful");
            return "redirect:/login";
        }
        return "redirect:/";

    }

    @RequestMapping("/deleteaccount")
    public String deleteAccount(Map map)
    {
        User u=new User();
        map.put("user",u);
        return "deleteuser";
    }
    @RequestMapping(value = "/deleteuseraccount/{email}",method = RequestMethod.POST)
    public String deleteUser(@PathVariable String email, RedirectAttributes redirectAttributes)
    {
        User user=userService.findByEmail(email);
        if(user!=null)
        {
            userService.removeUser(user);
            redirectAttributes.addFlashAttribute("deletion","Account deleted successfully");
            return "redirect:/";
        }
        return "deleteuser";
    }

}
