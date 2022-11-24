package com.manoelcampos.produtos;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;

public class Produto {
    private long id;
    private String codigoEan;
    private String descricao;
    private String marca;
    private String modelo;
    private double preco;
    private LocalDate dataCadastro;
    private LocalDate dataUltimaAtualizacao;
    private int estoque;
    private String categoria;
    private String urlFoto;

    private Produto(long id, String codigoEan, String descricao, String marca, String modelo,
                    double preco, LocalDate dataUltimaAtualizacao, int estoque, String categoria, String urlFoto) {
        this.setId(id);
        this.setCodigoEan(codigoEan);
        this.setDescricao(descricao);
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setPreco(preco);
        this.setDataCadastro(LocalDate.now());
        this.setDataUltimaAtualizacao(dataUltimaAtualizacao);
        this.setEstoque(estoque);
        this.setCategoria(categoria);
        this.setUrlFoto(urlFoto);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id é obrigatório.");
        }
        this.id = id;
    }

    public String getCodigoEan() {
        return codigoEan;
    }

    public void setCodigoEan(String codigoEan) {
        if(codigoEan == null) {
            throw new IllegalArgumentException("O codigoean nao pode ser nulo");
        }
        this.codigoEan = codigoEan;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("Descrição é obrigatória.");
        }
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if (marca == null || marca.isEmpty()) {
            throw new IllegalArgumentException("Marca é obrigatória.");
        }
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        if (modelo == null) {
            throw new IllegalArgumentException("Modelo não pode ser nulo.");
        }
        this.modelo = modelo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if(Objects.isNull(preco)) {
            throw new IllegalArgumentException("Preço é obrigatório");
        }

        if(preco < 0) {
            throw new IllegalArgumentException("O preço deve ser maior que zero");
        }
        this.preco = preco;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDate getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(LocalDate dataUltimaAtualizacao) {
        if(dataUltimaAtualizacao.isBefore(dataCadastro)) {
            throw new IllegalArgumentException("A data de atualização não pode ser antes da de cadastro");
        }
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        if (estoque < 0) {
            throw new IllegalArgumentException("O estoque não pode ser negativo");
        }
        this.estoque = estoque;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        if (categoria == null || categoria.isEmpty()) {
            throw new IllegalArgumentException("Categoria é obrigatória.");
        }

        this.categoria = categoria;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        if (urlFoto == null) {
            throw new IllegalArgumentException("URL da foto não pode ser nula.");
        }
        this.urlFoto = urlFoto;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", codigoEan='" + codigoEan + '\'' +
                ", descricao='" + descricao + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", preco=" + preco +
                ", dataCadastro=" + dataCadastro +
                ", dataUltimaAtualizacao=" + dataUltimaAtualizacao +
                ", estoque=" + estoque +
                ", categoria='" + categoria + '\'' +
                ", urlFoto='" + urlFoto + '\'' +
                '}';
    }

    public static Builder newBuilder(){
        return new Builder();
    }

    public static class Builder {
        private long id;
        private String codigoEan;
        private String descricao;
        private String marca;
        private String modelo;
        private double preco;
        private LocalDate dataUltimaAtualizacao;
        private int estoque;
        private String categoria;
        private String urlFoto;

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder codigoEan(String codigoEan) {
            this.codigoEan = codigoEan;
            return this;
        }

        public Builder descricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public Builder marca(String marca) {
            this.marca = marca;
            return this;
        }

        public Builder modelo(String modelo) {
            this.modelo = modelo;
            return this;
        }

        public Builder preco(double preco) {
            this.preco = preco;
            return this;
        }

        public Builder dataUltimaAtualizacao(LocalDate dataUltimaAtualizacao) {
            this.dataUltimaAtualizacao = dataUltimaAtualizacao;
            return this;
        }

        public Builder estoque(int estoque) {
            this.estoque = estoque;
            return this;
        }

        public Builder categoria(String categoria) {
            this.categoria = categoria;
            return this;
        }

        public Builder urlFoto(String urlFoto) {
            this.urlFoto = urlFoto;
            return this;
        }

        public Produto build() {
            return new Produto(id, codigoEan, descricao, marca, modelo, preco, dataUltimaAtualizacao, estoque, categoria, urlFoto);
        }
    }
}
