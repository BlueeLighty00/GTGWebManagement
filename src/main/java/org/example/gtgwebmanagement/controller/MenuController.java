package org.example.gtgwebmanagement.controller;


import org.example.gtgwebmanagement.models.dao.MenuDAOImpl;
import org.example.gtgwebmanagement.models.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MenuController {
    @Autowired
    MenuDAOImpl menuDAO;

    @GetMapping("/menus")
    public String menus(Model model) {
        model.addAttribute("menus", menuDAO.findAll());
        return "menus";
    }

    @GetMapping("/menu/{id}")
    public String getMenuDetails(Model model, @PathVariable Long id) {
        Menu menu = menuDAO.findById(id);
        model.addAttribute("menu", menu);
        return "details_menu";
    }

    @GetMapping("/menu/edit/{id}")
    public String getMenuEdit(Model model, @PathVariable Long id) {
        Menu menu = menuDAO.findById(id);
        model.addAttribute("menu", menu);
        return "edit_menu";
    }

    @GetMapping("/menu/create")
    public String createMenu(Model model) {
        model.addAttribute("menu", new Menu());
        return "create_menu";
    }

    @PostMapping("/menu/create")
    public String newMenu(@ModelAttribute("menu") Menu menu) {

        menuDAO.save(menu);
        return "redirect:/menus";
    }


    @PostMapping("/menu/update/{id}")
    public String updateMenu(@ModelAttribute("menu") Menu menu) {

        menuDAO.update(menu);
        return "redirect:/menus";
    }

    @DeleteMapping("/menu/delete/{id}")
    public String deleteMenu(@PathVariable Long id) {

        menuDAO.delete(id);

        return "redirect:/menus";
    }
}
