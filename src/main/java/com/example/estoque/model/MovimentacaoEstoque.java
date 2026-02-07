package com.example.estoque.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter

public class MovimentacaoEstoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Long codigoDoProduto;

    private String produto;

    @Enumerated(EnumType.STRING)
    private TipoMovimentacaoEstoque tipo;
    private Integer quantidade;

    private LocalDate data;
    private LocalTime hora;


}
