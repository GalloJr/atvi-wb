package com.wb.negocio;

import java.util.ArrayList;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.Servico;

public class CadastroServico extends Cadastro {
	private List<Servico> servicos;
	private Entrada entrada;

	public CadastroServico(List<Servico> servicos) {
		this.servicos = servicos;
		this.entrada = new Entrada();
	}

	@Override
	public void cadastrar() {
		System.out.println("Cadastro do servi�o");
		System.out.println("Por favor informe o nome do servi�o:");
		String nome = entrada.receberTexto();
		System.out.println("Por favor informe o genero do servi�o:");
		String genero = entrada.receberTexto();
		System.out.println("Por favor informe o valor do servi�o:");
		double valor = entrada.receberNumeroDouble();
		System.out.println("Por favor informe a quantidade do servi�o:");
		int quantidade = entrada.receberNumeroInteiro();

		Servico servico = new Servico(nome, genero, valor, quantidade);

		this.servicos.add(servico);
	}

	public List<Servico> buscar() {
		System.out.println("Por favor informe o nome do servi�o:");
		List<Servico> servicosEncontrados = new ArrayList<>();
		String nome = entrada.receberTexto();
		for(Servico servico : this.servicos) {
			if(servico.getNome().equalsIgnoreCase(nome)){
				System.out.println("Nome: " + servico.getNome());
				System.out.println("Genero: " + servico.getGenero());
				System.out.println("Valor: " + servico.getValor());
				System.out.println("--------------------------------------");
				servicosEncontrados.add(servico);
			}
		}
		return servicosEncontrados;
	}

	@Override
	public void deletar() {
		List<Servico> servicosEncontrados = this.buscar();
		for(Servico servico : servicosEncontrados) {
			this.servicos.remove(servico);
		}
	}

	@Override
	public void listar() {
		System.out.println("Servi�o encontrados:");
		for (Servico servico : this.servicos) {
			System.out.println("Nome: " + servico.getNome());
			System.out.println("Genero: " + servico.getGenero());
			System.out.println("Valor: " + servico.getValor());
			System.out.println("--------------------------------------");
		}
	}
}