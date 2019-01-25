package com.company.farmfresh.controllers;

import com.company.farmfresh.model.User;
import com.company.farmfresh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
        if (u1!=null)
        {
        if (u1.getPassword().equals(u.getPassword())) {
                model.addAttribute("user", u1);
                model.addAttribute("loggedIn", "Login Successful");
                return "index";
            }
            model.addAttribute("passwordcheck","Invalid Password.Please try again..");
            return "login";
        }
        model.addAttribute("emailcheck","Sorry,we don't recognise this email address");
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
            return "index";
        }
        return "userprofile";
    }
    @RequestMapping(value ="/update")
    public String updateUser(Model model,@RequestParam("email") String mail)
    {
        User u2=userService.findByEmail(mail);
        model.addAttribute("userupdate",u2);
        return "updateuser";

    }
    @RequestMapping(value ="/updateaccount",method =RequestMethod.POST)
    public String updateAccount(User u,Model model){
        User user1=userService.findByEmail(u.getEmail());
        if (user1!=null)
        {
            user1.setName(u.getName());
            user1.setEmail(u.getEmail());
            user1.setPassword(u.getPassword());
            user1.setMobileNumber(u.getMobileNumber());
            user1.setAddress(u.getAddress());
            userService.updateUser(u);
            model.addAttribute("updation","Account updated successfully..");
            return "index";
        }
        return "userprofile";
    }

//    @RequestMapping(value = "/update")
//    public String updatePage(@RequestParam("email") String mail,Model model)
//    {
//        User u=userService.findByEmail(mail);
//        model.addAttribute("userupdate",u);
//        return "updateuser";
//    }
//    @RequestMapping(value = "/updateaccount",method = RequestMethod.POST)
//    public String updateUser(User u,Model model)
//    {
//        User user1=userService.findByEmail(u.getEmail());
//        if (user1!=null)
//        {
//            user1.setName(u.getName());
//            user1.setEmail(u.getEmail());
//            user1.setPassword(u.getPassword());
//            user1.setMobileNumber(u.getMobileNumber());
//            user1.setAddress(u.getAddress());
//            userService.updateUser(user1);
//            model.addAttribute("updation","Account updated successfully");
//            return "index";
//        }
//        return "userprofile";
//    }

}
