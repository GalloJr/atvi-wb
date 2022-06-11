package com.wb.modelo;

public class Produto {
	public String nome;
	public String genero;
	public double valor;
	public int quantidade;

	public Produto(String nome, String genero, double valor, int quantidade) {
		this.nome = nome;
		this.genero = genero;
		this.valor = valor;
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() { return genero; }

	public void setGenero(String genero) {	this.genero = genero; }

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}