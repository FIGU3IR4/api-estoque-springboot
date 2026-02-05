package com.example.estoque.model.controller;


import com.example.estoque.model.Produto;
import com.example.estoque.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service){
        this.service=service;

    }


    @GetMapping
    public List<Produto> getProdutos(){
        return  service.getProdutos();
    }


    @PostMapping
    public Produto createProduto(@RequestBody Produto produto){
        return service.createProduto(produto);
    }


    @DeleteMapping("/{id}")
    public void deleteProdutoByid(@PathVariable("id") Long id){
        service.deleteProdutoByid(id);
    }

    @GetMapping("codigo/{codigo}")
    public Produto findByCodigo(@PathVariable("codigo") Long codigo){
        return service.findByCodigo(codigo);
    }
}
