package com.wb.modelo;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	private List<Cliente> clientes;
	private List<Produto> produtos;
	private List<Servico> servicos;
	private List<Venda> vendas;

	public Empresa() {
		this.clientes = new ArrayList<>();
		this.produtos = new ArrayList<>();
		this.servicos = new ArrayList<>();
		this.vendas = new ArrayList<>();
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public List<Servico> getServicos() {
		return servicos;
	}
	public List<Venda> getVendas() {
		return vendas;
	}
}