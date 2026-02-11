package com.example.estoque.repository;

import com.example.estoque.model.Admin;
import com.example.estoque.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    UserDetails findByLogin(String login);

}
