package com.example.estoque.controller;


import com.example.estoque.model.Admin;
import com.example.estoque.service.AdminService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")

public class AdminController {

    private final AdminService service;

    public AdminController(AdminService service){
        this.service=service;
    }

    @PostMapping
    public  Admin createAdmin(@RequestBody Admin admin){
        return service.createAdmin(admin);
    }



}
