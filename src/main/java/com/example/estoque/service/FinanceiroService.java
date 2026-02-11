package com.example.estoque.service;


import com.example.estoque.model.Produto;
import com.example.estoque.repository.FinanceiroRepository;
import com.example.estoque.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FinanceiroService {

    private FinanceiroRepository repository;
    private ProdutoRepository produtoRepository;


    public FinanceiroService(FinanceiroRepository repository, ProdutoRepository produtoRepository){
        this.repository=repository;
        this.produtoRepository=produtoRepository;


    }

    Produto produto;

    public Double getValorTotal(){
        List<Produto> produtos=produtoRepository.findAll();

        Double total=0.0;

        for(Produto produto : produtos ){
            total += produto.getValor()*produto.getQuantidade();

        }

        return total;

    }



}
