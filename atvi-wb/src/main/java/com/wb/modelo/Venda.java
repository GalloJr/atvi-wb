package com.wb.modelo;

import java.time.LocalDate;
import java.util.List;

public class Venda {
    private LocalDate dataEmissao;
    private Cliente cliente;
    private List<Produto> produtos;
    private List<Servico> servicos;

    public Venda(LocalDate dataEmissao, Cliente cliente, List<Produto> produtos, List<Servico> servicos) {
        this.dataEmissao = dataEmissao;
        this.cliente = cliente;
        this.produtos = produtos;
        this.servicos = servicos;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }
}
