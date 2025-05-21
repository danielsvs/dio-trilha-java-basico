package edu.desafioBanco.contas;

import edu.desafioBanco.banco.Banco;
import edu.desafioBanco.banco.Cliente;
import edu.desafioBanco.utils.TipoConta;

import java.util.Scanner;

public abstract class Conta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL;

    private final int agencia;
    private final int numeroConta;
    protected TipoConta tipoConta;
    protected Cliente cliente;
    private double saldo;

    public Conta() {
        this.agencia = AGENCIA_PADRAO;
        this.numeroConta = SEQUENCIAL++;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int exibirCpfCliente() {
        return cliente.getCpf();
    }

    public double getSaldo() {
        return saldo;
    }

    public void transferencia(double valor) {
        this.saldo += valor;
    }

    @Override
    public String toString() {
        return "Conta { " + agencia + ", " + numeroConta + ", " + saldo + " }";
    }

    public void sacar(double valor){
        if(saldo - valor >= 0) {
            saldo -=valor;
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    public void depositar (double valor) {
        saldo +=valor;
    }

    public void transferir (Banco banco, double valor, int numeroConta) {
        Conta contaDestino = banco.pesquisarConta(numeroConta);
        if (contaDestino != null) {
            sacar(valor);
            contaDestino.transferencia(valor);
        } else {
            System.out.println("Conta inválida ou não encontrada!");
        }
    }

    public void imprimirExtrato () {
        System.out.println("==== EXTRATO CONTA " + tipoConta.toString() + " ====");
        System.out.println("Saldo da conta:" + getSaldo());
    }

    public void imprimirDadosConta () {
        System.out.println("==== DADOS DA CONTA ====");
        System.out.println(toString());
    }

}
