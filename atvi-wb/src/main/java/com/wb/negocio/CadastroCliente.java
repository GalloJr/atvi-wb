package com.wb.negocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.wb.io.Entrada;
import com.wb.modelo.CPF;
import com.wb.modelo.Cliente;

public class CadastroCliente extends Cadastro {
	private List<Cliente> clientes;
	private Entrada entrada;

	public CadastroCliente(List<Cliente> clientes) {
		this.clientes = clientes;
		this.entrada = new Entrada();
	}

	@Override
	public void cadastrar() {
		System.out.println("Cadastro do cliente");
		System.out.println("Por favor informe o nome do cliente:");
		String nome = entrada.receberTexto();
		System.out.println("Por favor informe o nome social do cliente:");
		String nomeSocial = entrada.receberTexto();
		System.out.println("Por favor informe o número do cpf:");
		String valor = entrada.receberTexto();
		System.out.println("Por favor informe o genero do cliente:");
		String genero = entrada.receberTexto();
		System.out.println("Por favor informe a data de emissão do cpf, no padrão dd/mm/yyyy:");
		String data = entrada.receberTexto();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao = LocalDate.parse(data, formato);
		CPF cpf = new CPF(dataEmissao, valor);
		Cliente cliente = new Cliente(nome, nomeSocial, cpf, genero);
		this.clientes.add(cliente);
	}

	public List<Cliente> buscar() {
		System.out.println("Por favor informe o nome do cliente que voce quer buscar:");
		List<Cliente> clientesEncontrados = new ArrayList<>();
		String nome = entrada.receberTexto();
		for(Cliente cliente : this.clientes) {
			if(cliente.getNome().equalsIgnoreCase(nome)){
				System.out.println("Nome: " + cliente.getNome());
				System.out.println("Nome social: " + cliente.getNomeSocial());
				System.out.println("Genero: " + cliente.getGenero());
				System.out.println("CPF: " + cliente.getCpf().getValor());
				System.out.println("--------------------------------------");
				clientesEncontrados.add(cliente);
			}
		}
		return clientesEncontrados;
	}

	@Override
	public void deletar() {
		System.out.println("Início do removedor do cliente");
		System.out.println("Por favor informe o nome do cliente que voce quer remover:");
		List<Cliente> clientesEncontrados = this.buscar();
		for(Cliente cliente : clientesEncontrados) {
			this.clientes.remove(cliente);
		}
	}

	@Override
	public void listar() {
		System.out.println("Lista de todos os clientes:");
		for (Cliente cliente : this.clientes) {
			System.out.println("Nome: " + cliente.getNome());
			System.out.println("Nome social: " + cliente.getNomeSocial());
			System.out.println("CPF: " + cliente.getCpf().getValor());
			System.out.println("--------------------------------------");
		}
	}
}