package com.manoelcampos.produtos;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Produto produto = Produto.newBuilder()
                .id(1l)
                .descricao("description")
                .marca("marca")
                .modelo("modelo")
                .dataUltimaAtualizacao(LocalDate.now())
                .categoria("categoria")
                .urlFoto("urlfoto")
                .codigoEan("12313").build();

        System.out.println(produto.toString());
    }
}
