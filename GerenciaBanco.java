package com.mycompany.gerenciabanco;
import java.util.Scanner;

/**
 *
 * @author Erick Souza
 */


public class GerenciaBanco {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ContaBancaria conta = new ContaBancaria();
        String nome, sobrenome, cpf;
        double valor;
        int opcao;

        System.out.println("Bem-Vindo ao Gerenciador Bancario do Erick:");
        System.out.print("Digite o seu nome: ");
        nome = input.nextLine();
        System.out.print("Digite o seu sobrenome: ");
        sobrenome = input.nextLine();
        System.out.print("Digite o seu CPF: ");
        cpf = input.nextLine();
        conta.setNome(nome);
        conta.setSobrenome(sobrenome);
        conta.setCpf(cpf);

        do {
            System.out.println("\nEscolha uma opcao:");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Realizar deposito");
            System.out.println("3 - Realizar saque");
            System.out.println("4 - Encerrar");
            System.out.print("Opcao escolhida: ");
            opcao = input.nextInt();
            
            switch(opcao) {
                case 1:
                    System.out.printf("Saldo atual: R$ %.2f\n", conta.getSaldo());
                    break;
                case 2:
                    System.out.print("Digite o valor do deposito: R$ ");
                    valor = input.nextDouble();
                    conta.depositar(valor);
                    System.out.println("Depósito realizado com sucesso!");
                    break;
                case 3:
                    System.out.print("Digite o valor do saque: R$ ");
                    valor = input.nextDouble();
                    if (conta.saldoSuficiente(valor)) {
                        conta.sacar(valor);
                        System.out.println("Saque realizado com sucesso!");
                    } else {
                        System.out.println("Saldo insuficiente para realizar o saque. Saldo atual: R$ " + conta.getSaldo());
                    }
                    break;
                case 4:
                    System.out.println("Obrigado por utilizar o gerenciador bancario!");
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        } while(opcao != 4);

        input.close();
    }
}

class ContaBancaria {
    private String nome;
    private String sobrenome;
    private String cpf;
    private double saldo;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public boolean saldoSuficiente(double valor) {
        return valor <= saldo;
    }

    public void sacar(double valor) {
        saldo -= valor;
    }
}
