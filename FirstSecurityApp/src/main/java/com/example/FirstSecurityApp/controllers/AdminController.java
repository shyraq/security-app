package com.example.FirstSecurityApp.controllers;

import com.example.FirstSecurityApp.models.Person;
import com.example.FirstSecurityApp.services.AdminService;
import com.example.FirstSecurityApp.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final PersonService personService;
    private final AdminService adminService;

    @Autowired
    public AdminController(PersonService personService, AdminService adminService) {
        this.personService = personService;
        this.adminService = adminService;
    }

    @GetMapping()
    public String adminPage(Model model, @ModelAttribute("person") Person person){
        adminService.onlyAdminHere();
        model.addAttribute("people", personService.findAll());
        return "admin";
    }

    @PatchMapping("/add")
    public String makeAdmin(@ModelAttribute ("person") Person person) {
        person = personService.findById(person.getId());

        adminService.makeAdmin(person);
        return "redirect:/admin";
    }

    @DeleteMapping("/delete")
    public String deleteUser(@ModelAttribute("person") Person person){
        adminService.deleteUser(person);

        return "redirect:/admin";
    }
}

