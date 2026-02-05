package com.example.estoque.excessoes;

public class ProdutoNaoEncotrado extends RuntimeException {
    public ProdutoNaoEncotrado(String message) {
        super(message);
    }
}
