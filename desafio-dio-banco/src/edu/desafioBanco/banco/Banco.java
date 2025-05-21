package edu.desafioBanco.banco;

import edu.desafioBanco.contas.Conta;
import edu.desafioBanco.contas.ContaCorrente;
import edu.desafioBanco.contas.ContaPoupanca;
import edu.desafioBanco.utils.Sexo;
import edu.desafioBanco.utils.TipoConta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Banco {

    private List<Conta> contas;
    private List<Cliente> clientes;

    public Banco() {
        this.contas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void imprimirContas() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());
        }
    }

    public void criarConta(String name, int cpf, String email, int celular, Sexo sexo, String dataDeNascimento) {
        Cliente novoCliente = new Cliente(name, cpf, email, celular, sexo, dataDeNascimento);
        if (pesquisarCliente(cpf) == null) {
            TipoConta tipoDeContaSelecionado = selecionarTipoDeConta();
            if (tipoDeContaSelecionado == TipoConta.CORRENTE) {
                contas.add(new ContaCorrente(novoCliente));
            } else if (tipoDeContaSelecionado == TipoConta.POUPANCA) {
                contas.add(new ContaPoupanca(novoCliente));
            }

            clientes.add(novoCliente);
            System.out.println("Conta de " + name + " criada com sucesso!");
        } else {
            System.out.println(name + " já possui uma conta.");
        }
    }

    public void excluirConta(int cpf) {
        for (Conta conta : contas) {
            if (conta.exibirCpfCliente() == cpf) {
                Cliente clienteVinculado = conta.getCliente();
                contas.remove(conta);

                if (clienteVinculado != null) {
                    clientes.remove(clienteVinculado);
                    System.out.println("Conta excluída");
                }
            } else {
                System.out.println("Não foi possível excluir conta");
            }
        }
    }

    public void imprimirDadosCliente(int cpf) {
        Cliente clientePesquisado = null;
        clientePesquisado = pesquisarCliente(cpf);
        if (clientePesquisado != null) {
            System.out.println(clientePesquisado.toString());
        } else {
            System.out.println("Cliente não encontrado");
        }
    }

    public void alterarDadosCliente(int cpf) {
        Cliente clientePesquisado = null;
        clientePesquisado = pesquisarCliente(cpf);
        if (clientePesquisado != null) {
            clientePesquisado.alterarDados(clientePesquisado);
        }
    }

    public Conta pesquisarConta(int numeroConta) {
        Conta contaPesquisada = null;
        for (Conta conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                contaPesquisada = conta;
            }
        }
        return contaPesquisada;
    }

    private Cliente pesquisarCliente(int cpf) {
        Cliente clientePesquisado = null;
        for (Cliente cliente : clientes) {
            if (cliente.getCpf() == cpf) {
                clientePesquisado = cliente;
            }
        }
        return clientePesquisado;
    }

    private TipoConta selecionarTipoDeConta() {
        Scanner scanner = new Scanner(System.in);
        TipoConta tipoConta = null;
        String contaSeleciona = "";
        do {
            System.out.println("==== SELECIONE A CONTA ====");
            System.out.println("'CORRENTE' -> CONTA CORRENTE");
            System.out.println("'POUPANCA' -> CONTA POUPANCA");
            contaSeleciona = scanner.next();
            if (contaSeleciona.compareToIgnoreCase(TipoConta.CORRENTE.toString()) == 0) {
                tipoConta = TipoConta.CORRENTE;
            } else if (contaSeleciona.compareToIgnoreCase(TipoConta.POUPANCA.toString()) == 0) {
                tipoConta = TipoConta.POUPANCA;
            } else {
                System.out.println("Opção inválida!");
            }
        } while (tipoConta == null);
        return tipoConta;
    }

}
