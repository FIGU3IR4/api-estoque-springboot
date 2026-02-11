package com.example.estoque.service;

import com.example.estoque.excessoes.ProdutoNaoEncotrado;
import com.example.estoque.model.Produto;
import com.example.estoque.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository){
        this.repository=repository;

    }


    public List<Produto> getProdutos(){
        return repository.findAll();
    }

    public Produto createProduto(Produto produto){
        return  repository.save(produto);

    }

    public void deleteProdutoByid(Long id){
        repository.deleteById(id);
    }
    public Produto findByCodigo(Long codigo){
        return repository.findByCodigoProduto(codigo)
                .orElseThrow(() -> new ProdutoNaoEncotrado("Produto nao encontrado"));
    }


    public Double valorTotalProduto(Long codigoProduto){

        Produto produto= repository.findByCodigoProduto(codigoProduto).orElseThrow();



        return  produto.getValor()*produto.getQuantidade();




    }

}
