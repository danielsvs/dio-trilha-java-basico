package edu.desafioBanco.contas;

import edu.desafioBanco.banco.Cliente;
import edu.desafioBanco.utils.TipoConta;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {

        super.tipoConta = TipoConta.CORRENTE;
        super.cliente = cliente;
    }

}
