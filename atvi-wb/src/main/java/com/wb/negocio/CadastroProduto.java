package com.wb.negocio;

import com.wb.io.Entrada;
import com.wb.modelo.Produto;

import java.util.ArrayList;
import java.util.List;

public class CadastroProduto extends Cadastro {
	private List<Produto> produtos;
	private Entrada entrada;

	public CadastroProduto(List<Produto> produtos) {
		this.produtos = produtos;
		this.entrada = new Entrada();
	}

	@Override
	public void cadastrar() {
		System.out.println("Cadastro do produto");
		System.out.println("Por favor informe o nome do produto:");
		String nome = entrada.receberTexto();
		System.out.println("Por favor informe o genero do produto:");
		String genero = entrada.receberTexto();
		System.out.println("Por favor informe o valor do produto:");
		double valor = entrada.receberNumeroDouble();
		System.out.println("Por favor informe a quantidade do produto:");
		int quantidade = entrada.receberNumeroInteiro();
		Produto produto = new Produto(nome, genero, valor, quantidade);
		this.produtos.add(produto);
	}

	public List<Produto> buscar() {
		System.out.println("Por favor informe o nome do produto que voce quer buscar:");
		List<Produto> produtosEncontrados = new ArrayList<>();
		String nome = entrada.receberTexto();
		for(Produto produto : this.produtos) {
			if(produto.getNome().equalsIgnoreCase(nome)){
				System.out.println("Nome: " + produto.getNome());
				System.out.println("Genero: " + produto.getGenero());
				System.out.println("Valor: " + produto.getValor());
				System.out.println("--------------------------------------");
				produtosEncontrados.add(produto);
			}
		}
		return produtosEncontrados;
	}

	@Override
	public void deletar() {
		System.out.println("Por favor informe o nome do produto que voce quer remover:");
		List<Produto> produtosEncontrados = this.buscar();
		for(Produto produto : produtosEncontrados) {
			this.produtos.remove(produto);
		}
	}

	@Override
	public void listar() {
		System.out.println("Serviço encontrados:");
		for (Produto produto : this.produtos) {
			System.out.println("Nome: " + produto.getNome());
			System.out.println("Genero: " + produto.getGenero());
			System.out.println("Valor: " + produto.getValor());
			System.out.println("--------------------------------------");
		}
	}
}