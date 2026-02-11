package com.example.estoque.service;


import com.example.estoque.model.Admin;
import com.example.estoque.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    private AdminRepository repository;

    public AdminService(AdminRepository repository){
        this.repository=repository;

    }



    public  Admin createAdmin(Admin admin){
        return repository.save(admin);

    }

}
