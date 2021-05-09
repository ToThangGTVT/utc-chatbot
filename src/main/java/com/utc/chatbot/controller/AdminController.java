package com.utc.chatbot.controller;

import com.utc.chatbot.entity.sys.Admin;
import com.utc.chatbot.service.CoupleService;
import com.utc.chatbot.service.CustomerService;
import com.utc.chatbot.service.ExceptionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    private final CustomerService customerService;
    private final CoupleService coupleService;
    private final ExceptionService exceptionService;

    public AdminController(CustomerService customerService,
                           CoupleService coupleService,
                           ExceptionService exceptionService) {
        this.customerService = customerService;
        this.coupleService = coupleService;
        this.exceptionService = exceptionService;
    }

    @GetMapping("/admin")
    public String showIndex(Model model) {
        model.addAttribute("users", customerService.findAll());
        model.addAttribute("couples", coupleService.findAll());
        model.addAttribute("exceptions", exceptionService.findAll());
        return "index";
    }

    @GetMapping("/login")
    public String showLogin(Model model) {
        model.addAttribute("admin", new Admin());
        return "login";
    }

    @GetMapping("/")
    public String redirect(Model model) {
        return "redirect:admin";
    }

}
