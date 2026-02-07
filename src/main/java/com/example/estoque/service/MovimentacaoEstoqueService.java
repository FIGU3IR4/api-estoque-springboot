package com.example.estoque.service;


import com.example.estoque.model.MovimentacaoEstoque;
import com.example.estoque.model.Produto;
import com.example.estoque.repository.MovimentacaoEstoqueRepository;
import com.example.estoque.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimentacaoEstoqueService {

    private final MovimentacaoEstoqueRepository repository;
    private final ProdutoRepository produtoRepository;


    public MovimentacaoEstoqueService(MovimentacaoEstoqueRepository repository, ProdutoRepository produtoRepository){
        this.repository=repository;

        this.produtoRepository = produtoRepository;
    }

    public List<MovimentacaoEstoque> getMovimentacaoEstoqueList (){
        return repository.findAll();
    }

    public MovimentacaoEstoque createMovimentacao(MovimentacaoEstoque movimentacao){

        Produto produto = produtoRepository
                .findByCodigoProduto(movimentacao.getCodigoDoProduto())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));



        if(movimentacao.getTipo().equals("SAIDA")){
            if (produto.getQuantidade() < movimentacao.getQuantidade()) {
                throw new RuntimeException("Estoque insuficiente");
            }


            produto.setQuantidade(
                    produto.getQuantidade() - movimentacao.getQuantidade()
            );
        }

        produto.setQuantidade(
                produto.getQuantidade() + movimentacao.getQuantidade()
        );

        produtoRepository.save(produto);

        return repository.save(movimentacao);
    }

}
