package com.example.estoque.controller;


import com.example.estoque.model.MovimentacaoEstoque;
import com.example.estoque.service.MovimentacaoEstoqueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoEstoqueController {

    private final MovimentacaoEstoqueService service;

    public MovimentacaoEstoqueController(MovimentacaoEstoqueService service){
        this.service=service;

    }
    @GetMapping
    public List<MovimentacaoEstoque> movimentacaoEstoqueList (){
       return service.getMovimentacaoEstoqueList();
    }

    @PostMapping
    public MovimentacaoEstoque createMovimentacao(@RequestBody MovimentacaoEstoque movimentacaoEstoque){
        return service.createMovimentacao(movimentacaoEstoque);
    }

    @GetMapping("/{id}")
    public MovimentacaoEstoque getMovimentacaoById(@PathVariable Long id){
        return service.getMovimentacaoByid(id);
    }


}
