package com.example.estoque.controller;


import com.example.estoque.service.FinanceiroService;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("financial")

public class FinanceiroController {

        private final FinanceiroService service;

        public FinanceiroController(FinanceiroService service){
            this.service=service;

        }


        @GetMapping
        public Double getValorTotal(){
            return service.getValorTotal();
        }

}
