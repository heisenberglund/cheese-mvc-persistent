package org.launchcode.controllers;

import org.launchcode.models.Category;
import org.launchcode.models.data.CategoryDao;
import org.launchcode.models.data.CheeseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("category")
public class CategoryController {



    @Autowired
    private CheeseDao cheesedao;

    @Autowired
    private CategoryDao categoryDao;

    @RequestMapping(value="")
    public String index(Model model){
        model.addAttribute("categories", categoryDao.findAll());
        model.addAttribute("title", "Cheese Categories");
        return "category/index";
    }
    @RequestMapping(value="/add", method=RequestMethod.GET)
    public String displayCategoryForm(Model model){
        model.addAttribute("title","Add Category");
        model.addAttribute(new Category());
        model.addAttribute("Add Category", new Category());
        return "category/add";
    }
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String addCategoryForm(Model model, @ModelAttribute @Valid Category category, Errors errors){

        if(errors.hasErrors()){
            model.addAttribute("Add Category", new Category());
            return "category/add";}
            {
            categoryDao.save(category);
            return "redirect:";
        }
    }

}
