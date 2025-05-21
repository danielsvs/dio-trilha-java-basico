package edu.desafioBanco.contas;

import edu.desafioBanco.banco.Cliente;
import edu.desafioBanco.utils.TipoConta;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super.tipoConta = TipoConta.POUPANCA;
        super.cliente = cliente;
    }
}
