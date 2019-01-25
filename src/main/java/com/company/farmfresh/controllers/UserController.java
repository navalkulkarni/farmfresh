package com.company.farmfresh.controllers;

import com.company.farmfresh.model.User;
import com.company.farmfresh.service.UserService;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
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
    public String checkUser(User u,Model model)
    {
        User u1=userService.findByEmail(u.getEmail());
        System.out.println(u1);
        if(u1!=null)
        {
            model.addAttribute("user",u1);
//            redirectAttributes.addFlashAttribute("loggedIn","Login Successful");
            model.addAttribute("loggedIn","Login Successful");
            return "index";
        }
//        model.addAttribute("user",u);
        return "login";

    }

    @RequestMapping(value = "/profile",method = RequestMethod.POST)
    public String userProfile(@RequestParam("email") String mail, Model model)
    {
        //System.out.println(email);
        User u=userService.findByEmail(mail);
        //System.out.println(u);
        model.addAttribute("userdetails",u);
        return "userprofile";
    }

    @RequestMapping(value = "/deleteaccount",method = RequestMethod.POST)
    public String deleteUser(@RequestParam("email") String mail,Model model)
    {
        User user=userService.findByEmail(mail);
        if(user!=null)
        {
            userService.removeUser(user);
            model.addAttribute("deletion","Account deleted successfully");
//            redirectAttributes.addFlashAttribute("deletion","Account deleted successfully");
            return "index";
        }
        return "userprofile";
    }

}
