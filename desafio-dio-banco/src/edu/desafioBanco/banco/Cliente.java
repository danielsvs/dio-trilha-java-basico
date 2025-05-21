package edu.desafioBanco.banco;

import edu.desafioBanco.utils.Sexo;

import java.time.LocalDate;
import java.util.Scanner;

public class Cliente {

    private String name;
    private int cpf;
    private String email;
    private int celular;
    private Sexo sexo;
    private String dataDeNascimento;

    public Cliente(String name, int cpf, String email, int celular, Sexo sexo, String dataDeNascimento) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.celular = celular;
        this.sexo = sexo;
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getName() {
        return name;
    }

    public int getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public int getCelular() {
        return celular;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }


    @Override
    public String toString() {
        return "Cliente { " + name + ", " + cpf + ", " + email + ", " + celular + ", " + sexo + ", " + dataDeNascimento + " }";
    }

    public void alterarDados(Cliente cliente) {
        Scanner scanner = new Scanner(System.in);

        boolean dadosAtualizados = false;

        do {
            System.out.println("==== ATUALIZAÇÃO DE CADASTRO ====");
            System.out.println("Selecione qual dado será atualizado");
            System.out.println("1 - NOME");
            System.out.println("2 - EMAIL");
            System.out.println("3 - CELULAR");
            System.out.println("---------------");
            System.out.println("4 - CANCELAR");

            if (!scanner.hasNextInt()) {
                System.out.println("Opção inválida! Digite uma opção válida:");
                scanner.nextLine();
                continue;
            }
            int opcaoSelecionada = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoSelecionada) {
                case 1:
                    System.out.println("Digite o novo nome:");
                    cliente.setName(scanner.nextLine());
                    System.out.println("Nome atualizado com sucesso!");
                    dadosAtualizados = true;
                    break;
                case 2:
                    System.out.println("Digite o novo email:");
                    cliente.setEmail(scanner.next());
                    System.out.println("Email atualizado com sucesso!");
                    dadosAtualizados = true;
                    break;
                case 3:
                    System.out.println("Digite o novo número de celular:");
                    if (scanner.hasNextInt()) {
                        cliente.setCelular(scanner.nextInt());
                        System.out.println("Número de celular atualizado com sucesso!");
                        dadosAtualizados = true;
                        break;
                    } else {
                        System.out.println("Número de telefone inválido! Tente novamente.");
                        break;
                    }
                case 4:
                    System.out.println("Atualização de dados cancelada.");
                    dadosAtualizados = true;
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    scanner.nextLine();
                    break;
            }
        } while (!dadosAtualizados);
    }
}

