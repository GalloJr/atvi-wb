package com.wb;

import com.wb.io.Entrada;
import com.wb.modelo.*;
import com.wb.negocio.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Listagem listagem;
        Empresa empresa = new Empresa();

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //Mock de Clintes
        Cliente renato = new Cliente("Renato", "Renato", new CPF(LocalDate.parse("01/01/2000", formato), "123"), "Masculino");
        Cliente douglas = new Cliente("Douglas", "Douglas", new CPF(LocalDate.parse("01/01/2000", formato), "234"), "Masculino");
        Cliente valdir = new Cliente("Valdir", "Valdir", new CPF(LocalDate.parse("01/01/2000", formato), "345"), "Masculino");
        Cliente miguel = new Cliente("Miguel", "Miguel", new CPF(LocalDate.parse("01/01/2000", formato), "456"), "Masculino");
        Cliente pietro = new Cliente("Pietro", "Pietro", new CPF(LocalDate.parse("01/01/2000", formato), "567"), "Masculino");
        Cliente larissa = new Cliente("Larissa", "Larissa", new CPF(LocalDate.parse("01/01/2000", formato), "678"), "Feminino");
        Cliente laura = new Cliente("Laura", "Laura", new CPF(LocalDate.parse("01/01/2000", formato), "789"), "Feminino");
        Cliente priscila = new Cliente("Priscila", "Priscila", new CPF(LocalDate.parse("01/01/2000", formato), "890"), "Feminino");
        Cliente isabelle = new Cliente("Isabelle", "Isabelle", new CPF(LocalDate.parse("01/01/2000", formato), "901"), "Feminino");
        Cliente lara = new Cliente("Lara", "Lara", new CPF(LocalDate.parse("01/01/2000", formato), "678"), "Feminino");
        empresa.getClientes().add(renato);
        empresa.getClientes().add(douglas);
        empresa.getClientes().add(valdir);
        empresa.getClientes().add(miguel);
        empresa.getClientes().add(pietro);
        empresa.getClientes().add(larissa);
        empresa.getClientes().add(laura);
        empresa.getClientes().add(priscila);
        empresa.getClientes().add(isabelle);
        empresa.getClientes().add(lara);

        //Mock de Clintes
        Produto shampoo = new Produto("Shampoo", "Tratamento Capilar", 100D, 1);
        Produto condicionador = new Produto("Condicionador", "Tratamento Capilar", 100D, 1);
        Produto rejuvenecedor = new Produto("Creme rejuvenecedor", "Tratamento Capilar", 100D, 1);
        Produto hidratante = new Produto("Hidratante", "Tratamento Pele", 100D, 1);
        Produto esmalte = new Produto("Esmalte", "Tratamento Unhas", 100D, 1);
        Produto removedorCuticula = new Produto("Removedor de cuticula", "Tratamento Unhas", 100D, 1);
        Produto gelCapilar = new Produto("Gel Capilar", "Tratamento Capilar", 100D, 1);
        empresa.getProdutos().add(shampoo);
        empresa.getProdutos().add(condicionador);
        empresa.getProdutos().add(rejuvenecedor);
        empresa.getProdutos().add(hidratante);
        empresa.getProdutos().add(esmalte);
        empresa.getProdutos().add(removedorCuticula);
        empresa.getProdutos().add(gelCapilar);

        //Mock de Servicos
        Servico implanteCapilar = new Servico("Implante Capilar", "Tratamento Capilar", 100D, 1);
        Servico corte = new Servico("Corte de cabelo", "Tratamento Capilar", 100D, 1);
        Servico tingimento = new Servico("Tingimento", "Tratamento Capilar", 100D, 1);
        Servico manicure = new Servico("Manicure", "Tratamento Unhas", 100D, 1);
        Servico pedicure = new Servico("Pedicure", "Tratamento Unhas", 100D, 1);
        Servico hidratacaoPele = new Servico("Hidratacao Pele", "Tratamento Pele", 100D, 1);
        empresa.getServicos().add(implanteCapilar);
        empresa.getServicos().add(corte);
        empresa.getServicos().add(tingimento);
        empresa.getServicos().add(manicure);
        empresa.getServicos().add(pedicure);

        //Mock de vendas
        Venda venda1 = new Venda(LocalDate.parse("01/01/2000", formato), renato, Arrays.asList(shampoo, condicionador, gelCapilar), Arrays.asList(corte));
        Venda venda2 = new Venda(LocalDate.parse("01/01/2000", formato), valdir, Arrays.asList(shampoo, condicionador, gelCapilar), Arrays.asList(corte));
        Venda venda3 = new Venda(LocalDate.parse("01/01/2000", formato), miguel, Arrays.asList(shampoo, condicionador, gelCapilar), Arrays.asList(corte));
        Venda venda4 = new Venda(LocalDate.parse("01/01/2000", formato), douglas, Arrays.asList(shampoo, condicionador, gelCapilar), Arrays.asList(corte));
        Venda venda5 = new Venda(LocalDate.parse("01/01/2000", formato), pietro, Arrays.asList(shampoo, condicionador), Arrays.asList(corte, tingimento));
        Venda venda6 = new Venda(LocalDate.parse("01/01/2000", formato), larissa, Arrays.asList(removedorCuticula, esmalte), Arrays.asList(manicure, pedicure));
        Venda venda7 = new Venda(LocalDate.parse("01/01/2000", formato), laura, Arrays.asList(shampoo, condicionador), Arrays.asList(corte, manicure, pedicure));
        Venda venda8 = new Venda(LocalDate.parse("01/02/2000", formato), priscila, Arrays.asList(shampoo, condicionador), Arrays.asList(corte, manicure, pedicure));
        Venda venda9 = new Venda(LocalDate.parse("01/03/2000", formato), larissa, Arrays.asList(shampoo, condicionador), Arrays.asList(corte, manicure, pedicure));
        empresa.getVendas().add(venda1);
        empresa.getVendas().add(venda2);
        empresa.getVendas().add(venda3);
        empresa.getVendas().add(venda4);
        empresa.getVendas().add(venda5);
        empresa.getVendas().add(venda6);
        empresa.getVendas().add(venda7);
        empresa.getVendas().add(venda8);
        empresa.getVendas().add(venda9);


        empresa.getServicos().add(hidratacaoPele);

        System.out.println("Bem-vindo ao cadastro de clientes do Grupo World Beauty");

        CadastroCliente cadastroCliente = new CadastroCliente(empresa.getClientes());
        CadastroProduto cadastroProduto = new CadastroProduto(empresa.getProdutos());
        CadastroServico cadastroServico = new CadastroServico(empresa.getServicos());

        boolean execucao = true;
        while (execucao) {
            System.out.println("Que tipo de operação você deseja fazer:");
            System.out.println("1 - CRUD cliente");
            System.out.println("2 - CRUD produto");
            System.out.println("3 - CRUD servico");
            System.out.println("4 - Listagens");
            System.out.println("0 - Sair");

            Entrada entrada = new Entrada();
            int operacao = entrada.receberNumeroInteiro();
            int operacaoSecundaria;

            switch (operacao) {
                case 0:
                    execucao = false;
                    System.out.println("Até mais!\n");
                    break;
                case 1:
                    System.out.println("Que tipo de operação você deseja fazer:");
                    System.out.println("1 - Cadastrar cliente");
                    System.out.println("2 - Buscar cliente");
                    System.out.println("3 - Deletar cliente");
                    System.out.println("4 - Listar cliente");

                    operacaoSecundaria = entrada.receberNumeroInteiro();
                    switch (operacaoSecundaria) {
                        case 1:
                            cadastroCliente.cadastrar();
                            break;
                        case 2:
                            cadastroCliente.buscar();
                            break;
                        case 3:
                            cadastroCliente.deletar();
                            break;
                        case 4:
                            cadastroCliente.listar();
                            break;
                        default:
                            System.out.println("Operação não entendida");
                    }
                    break;
                case 2:
                    System.out.println("Que tipo de operação você deseja fazer:");
                    System.out.println("1 - Cadastrar produto");
                    System.out.println("2 - Buscar produto");
                    System.out.println("3 - Deletar produto");
                    System.out.println("4 - Listar produtos");
                    operacaoSecundaria = entrada.receberNumeroInteiro();
                    switch (operacaoSecundaria) {
                        case 1:
                            cadastroProduto.cadastrar();
                            break;
                        case 2:
                            cadastroProduto.buscar();
                            break;
                        case 3:
                            cadastroProduto.deletar();
                            break;
                        case 4:
                            cadastroProduto.listar();
                            break;
                        default:
                            System.out.println("Operação não entendida");
                    }
                    break;
                case 3:
                    System.out.println("Que tipo de operação você deseja fazer:");
                    System.out.println("1 - Cadastrar servico");
                    System.out.println("2 - Buscar servico");
                    System.out.println("3 - Deletar servico");
                    System.out.println("4 - Listar servicos");
                    operacaoSecundaria = entrada.receberNumeroInteiro();
                    switch (operacaoSecundaria) {
                        case 1:
                            cadastroServico.cadastrar();
                            break;
                        case 2:
                            cadastroServico.buscar();
                            break;
                        case 3:
                            cadastroServico.deletar();
                            break;
                        case 4:
                            cadastroServico.listar();
                            break;
                        default:
                            System.out.println("Operação não entendida");
                    }
                    break;
                case 4:
                    System.out.println("Que tipo de operação você deseja fazer:");
                    System.out.println("1 - Listar 10 clientes que mais consumiram em quantidade");
                    System.out.println("2 - Listar clientes por genero");
                    System.out.println("3 - Listar Produtos e Servicos Mais Consumidos");
                    System.out.println("4 - Listar Produtos e Servicos Mais Consumidos Por Genero");
                    System.out.println("5 - Listar 10 clientes que menos consumiram em quantidade");
                    System.out.println("6 - Listar 5 clientes que mais consumiram em valor");

                    operacaoSecundaria = entrada.receberNumeroInteiro();
                    switch (operacaoSecundaria) {
                        case 1:
                            listagem = new ListarTodosClientes(empresa.getClientes(), empresa.getVendas());
                            listagem.listarDezMaioresConsumidores();
                            break;
                        case 2:
                            listagem = new ListarTodosClientes(empresa.getClientes(), empresa.getVendas());
                            listagem.listarPorGenero();
                            break;
                        case 3:
                            listagem = new ListarTodosClientes(empresa.getClientes(), empresa.getVendas());
                            listagem.listarMaisConsumidos();
                            break;
                        case 4:
                            listagem = new ListarTodosClientes(empresa.getClientes(), empresa.getVendas());
                            listagem.listarMaisConsumidosPorGenero();
                            break;
                        case 5:
                            listagem = new ListarTodosClientes(empresa.getClientes(), empresa.getVendas());
                            listagem.listarDezMenoresConsumidores();
                            break;
                        case 6:
                            listagem = new ListarTodosClientes(empresa.getClientes(), empresa.getVendas());
                            listagem.listarCincoMaioresConsumidoresEmValor();
                            break;
                        default:
                            System.out.println("Operação não entendida");
                    }
                    break;
                default:
                    System.out.println("Operação não entendida");
            }
        }
    }
}