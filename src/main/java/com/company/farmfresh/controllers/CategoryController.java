package com.company.farmfresh.controllers;

import com.company.farmfresh.model.Category;
import com.company.farmfresh.model.Item;
import com.company.farmfresh.model.User;
import com.company.farmfresh.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/list")
    public String getList(Model model, HttpSession session){
        List<Category> categoryList = categoryService.getCategories();
        model.addAttribute("fruits",categoryList.get(0));
        model.addAttribute("vegetables",categoryList.get(1));
        model.addAttribute("loggedinuser",(User)session.getAttribute("loggedinuser"));
        model.addAttribute("user",(User)session.getAttribute("user"));
        return "category";
    }
}
