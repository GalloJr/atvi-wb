package com.wb.negocio;

import com.wb.io.Entrada;
import com.wb.modelo.Cliente;
import com.wb.modelo.Produto;
import com.wb.modelo.Servico;
import com.wb.modelo.Venda;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class ListarTodosClientes extends Listagem {
    private List<Cliente> clientes;
    private List<Venda> vendas;
    private Entrada entrada = new Entrada();

    public ListarTodosClientes(List<Cliente> clientes, List<Venda> vendas) {
        this.clientes = clientes;
        this.vendas = vendas;
    }

    @Override
    public void listarDezMaioresConsumidores() {
        Map<Cliente, Integer> maioresConsumidores = new HashMap<>();
        for (Cliente cliente : clientes) {
            Integer soma = 0;
            for (Venda venda : vendas) {
                if (venda.getCliente().equals(cliente)) {
                    soma = soma + venda.getProdutos().size();
                    soma = soma + venda.getServicos().size();
                }
            }
            maioresConsumidores.put(cliente, soma);
        }

        maioresConsumidores = maioresConsumidores.entrySet().stream()
                .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println("Lista dos 10 clientes que mais consumiram:");

        Iterator<Cliente> maioresConsumidoresIterator = maioresConsumidores.keySet().iterator();
        for (int i = 0; i < 10 & maioresConsumidoresIterator.hasNext(); i++) {
            Cliente cliente = maioresConsumidoresIterator.next();
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Nome social: " + cliente.getNomeSocial());
            System.out.println("Consumo total: " + maioresConsumidores.get(cliente));
            System.out.println("--------------------------------------");
        }
    }

    @Override
    public void listarPorGenero() {
        System.out.println("Lista de todos os clientes por genero:");
        System.out.println("Por favor informe o genero:");
        String genero = entrada.receberTexto();
        for (Cliente cliente : clientes) {
            if (cliente.getGenero().equalsIgnoreCase(genero)) {
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("Nome social: " + cliente.getNomeSocial());
                System.out.println("Genero: " + cliente.getGenero());
                System.out.println("CPF: " + cliente.getCpf().getValor());
                System.out.println("--------------------------------------");
            }
        }
    }

    @Override
    public void listarMaisConsumidos() {
        Map<String, Integer> maisConsumidos = new HashMap<>();
        for (Venda venda : vendas) {
            for (Produto produto : venda.getProdutos()) {
                if (maisConsumidos.containsKey(produto.getNome())) {
                    maisConsumidos.replace(produto.getNome(), maisConsumidos.get(produto.getNome()) + 1);
                } else {
                    maisConsumidos.put(produto.getNome(), 1);
                }
            }
            for (Servico servico : venda.getServicos()) {
                if (maisConsumidos.containsKey(servico.getNome())) {
                    maisConsumidos.put(servico.getNome(), maisConsumidos.get(servico.getNome()) + 1);
                } else {
                    maisConsumidos.replace(servico.getNome(), 1);
                }
            }
        }

		List list = new ArrayList(maisConsumidos.entrySet());
		Collections.sort(list, (Comparator<Entry<String, Integer>>) (e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        Iterator maisConsumidosIterator = list.iterator();
        System.out.println("Lista dos produtos / serviços mais consumidos:");
        while (maisConsumidosIterator.hasNext()) {
			Map.Entry<String, Integer> objeto = (Entry<String, Integer>) maisConsumidosIterator.next();
            System.out.println("Nome: " + objeto.getKey());
            System.out.println("Vendidos: " + objeto.getValue());

        }
    }

    @Override
    public void listarMaisConsumidosPorGenero() {
        System.out.println("Por favor informe o genero:");
        String genero = entrada.receberTexto();

        TreeMap<String, Integer> maisConsumidos = new TreeMap<>(Collections.reverseOrder());
        for (Venda venda : vendas) {
            for (Produto produto : venda.getProdutos()) {
                if (produto.getGenero().equals(genero)) {
                    if (maisConsumidos.containsKey(produto.getNome())) {
                        maisConsumidos.replace(produto.getNome(), maisConsumidos.get(produto.getNome()) + 1);
                    } else {
                        maisConsumidos.put(produto.getNome(), 1);
                    }
                }
            }
            for (Servico servico : venda.getServicos()) {
                if (servico.getGenero().equals(genero)) {
                    if (maisConsumidos.containsKey(servico.getNome())) {
                        maisConsumidos.replace(servico.getNome(), maisConsumidos.get(servico.getNome()) + 1);
                    } else {
                        maisConsumidos.put(servico.getNome(), 1);
                    }
                }
            }
        }

		List list = new ArrayList(maisConsumidos.entrySet());
		Collections.sort(list, (Comparator<Entry<String, Integer>>) (e1, e2) -> e2.getValue().compareTo(e1.getValue()));

		Iterator maisConsumidosIterator = list.iterator();
		System.out.println("Lista dos produtos / serviços mais consumidos por genero:");
		while (maisConsumidosIterator.hasNext()) {
			Map.Entry<String, Integer> objeto = (Entry<String, Integer>) maisConsumidosIterator.next();
			System.out.println("Nome: " + objeto.getKey());
			System.out.println("Vendidos: " + objeto.getValue());

		}
    }

    @Override
    public void listarDezMenoresConsumidores() {
        Map<Cliente, Integer> maioresConsumidores = new HashMap<>();
        for (Cliente cliente : clientes) {
            Integer soma = 0;
            for (Venda venda : vendas) {
                if (venda.getCliente().equals(cliente)) {
                    soma = soma + venda.getProdutos().size();
                    soma = soma + venda.getServicos().size();
                }
            }
            maioresConsumidores.put(cliente, soma);
        }

        maioresConsumidores = maioresConsumidores.entrySet().stream()
                .sorted(Entry.comparingByValue())
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        System.out.println("Lista dos 10 clientes que menos consumiram:");

        Iterator<Cliente> maioresConsumidoresIterator = maioresConsumidores.keySet().iterator();
        for (int i = 0; i < 10 & maioresConsumidoresIterator.hasNext(); i++) {
            Cliente cliente = maioresConsumidoresIterator.next();
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Nome social: " + cliente.getNomeSocial());
            System.out.println("Consumo total: " + maioresConsumidores.get(cliente));
            System.out.println("--------------------------------------");
        }
    }

    @Override
    public void listarCincoMaioresConsumidoresEmValor() {
        Map<Cliente, Double> maioresConsumidores = new HashMap<>();
        for (Cliente cliente : clientes) {
            double soma = 0;
            for (Venda venda : vendas) {
                if (venda.getCliente().equals(cliente)) {
                    for (Produto produto : venda.getProdutos()) {
                        soma = soma + produto.getValor();
                    }
                    for (Servico servico : venda.getServicos()) {
                        soma = soma + servico.getValor();
                    }
                }
            }
            maioresConsumidores.put(cliente, soma);
        }
        List list = new ArrayList(maioresConsumidores.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Cliente, Double>>() {
            @Override
            public int compare(Map.Entry<Cliente, Double> e1, Map.Entry<Cliente, Double> e2) {
                return e2.getValue().compareTo(e1.getValue());
            }
        });

        System.out.println("Lista dos 5 clientes que mais consumiram:");

        Iterator maioresConsumidoresIterator = list.iterator();
        for (int i = 0; i < 5 & maioresConsumidoresIterator.hasNext(); i++) {
            Entry<Cliente, Double> entrada = (Entry<Cliente, Double>) maioresConsumidoresIterator.next();
            System.out.println("Nome: " + entrada.getKey().getNome());
            System.out.println("Nome social: " + entrada.getKey().getNomeSocial());
            System.out.println("Consumo total: " + entrada.getValue());
            System.out.println("--------------------------------------");
        }

    }


}
