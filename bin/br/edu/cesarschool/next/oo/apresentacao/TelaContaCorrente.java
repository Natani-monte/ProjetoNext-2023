package br.edu.cesarschool.next.oo.apresentacao;

import br.edu.cesarschool.next.oo.entidade.ContaCorrente;
import br.edu.cesarschool.next.oo.entidade.ContaPoupanca;
import br.edu.cesarschool.next.oo.negocio.MediatorContaCorrente;

import java.util.List;
import java.util.Scanner;

    public class TelaContaCorrente {
        private static final Scanner ENTRADA = new Scanner(System.in);
        private MediatorContaCorrente mediatorContaCorrente = new MediatorContaCorrente();
    
        public void iniciarTela(){
            
            int opcao = 0;

            do{
    
                System.out.println("Escolha uma opção: ");
                System.out.println("1- Incluir Conta");
                System.out.println("2- Creditar");
                System.out.println("3- Debitar");
                System.out.println("4- Buscar");
                System.out.println("5- Relatorio");
                System.out.println("6- Excluir");
                System.out.println("7- Sair");

                opcao = ENTRADA.nextInt();

                switch (opcao) {
                    case 1:
                        incluir();
                        break;
                
                    case 2:
                        creditar();
                        break;
    
                    case 3:
                        debitar();
                        break;
    
                    case 4:
                        buscar();
                        break;
    
                    case 5:
                        gerarRelatorioGeral();
                        break;

                    case 6:
                        excluir();
                        break;
                        
                    case 7:
                        System.out.println("Saindo do sistema");
                        break;
                }
            }
            while(opcao != 6);
        }
    
        private void incluir(){
            System.out.println("Insira o Numero da Conta: ");
            String numero = ENTRADA.next();
            System.out.println("Insira o Saldo da Conta: ");
            double saldo = ENTRADA.nextDouble();
            System.out.println("Insira o Nome do Usuario: ");
            String nome = ENTRADA.next();
    
            System.out.println("Insira o tipo da conta: 1- Conta Corrente\n 2- Conta Poupança");
            int tipo = ENTRADA.nextInt();
    
            if(tipo == 1){

                ContaCorrente conta = new ContaCorrente(numero, saldo, nome);
                String mensagem = mediatorContaCorrente.incluir(conta);

                if(mensagem == null){
                    System.out.println("Sucesso na inclus\\u00E3o");
                }
                else {
                    System.out.println(mensagem);
                }

            } 
            else {
                System.out.println("Insira o seu Percentual De Bonus");
                double percentualBonus = ENTRADA.nextDouble();
                ContaPoupanca contaP = new ContaPoupanca(numero, saldo, nome, percentualBonus);
                String mensagem = mediatorContaCorrente.incluir(contaP);

                if(mensagem == null){
                    System.out.println("Sucesso na inclus\u00E3o");
                } 
                else {
                    System.out.println(mensagem);
                }
            }
        }
    
        private void creditar(){
    
            System.out.println("Qual o numero da conta?: ");
            String numero = ENTRADA.next();
            System.out.println("Qual o valor a ser creditado?: ");
            double valor = ENTRADA.nextDouble();
    
            String mensagem = mediatorContaCorrente.creditar(valor, numero);
    
            if(mensagem == null){
                System.out.println("sucesso no creditar");
            } else {
                System.out.println(mensagem);
            }
        }
     
        private void debitar(){
    
            System.out.println("Qual o numero da conta?: ");
            String numero = ENTRADA.next();
            System.out.println("Qual o valor a ser debitado?: ");
            double valor = ENTRADA.nextDouble();
    
            String mensagem = mediatorContaCorrente.debitar(valor, numero);
    
            if(mensagem == null){
                System.out.println("Sucesso ao debitar");
            } else {
                System.out.println(mensagem);
            }
        }
    
        private void buscar(){
            System.out.println("Qual o numero da conta?: ");
            String numero = ENTRADA.next();
    
            ContaCorrente conta = mediatorContaCorrente.buscar(numero);
    
            if(conta == null){
                System.out.println("Conta não existente");
            } else {
                System.out.println(conta);
            }
            
        }

        private void gerarRelatorioGeral(){
            List<ContaCorrente> listaConta = mediatorContaCorrente.gerarRelatorioGeral();
            for(ContaCorrente conta: listaConta){
                if(conta instanceof ContaPoupanca){
                    ContaPoupanca contaP = (ContaPoupanca)conta;
                    System.out.println(contaP.toString()); 
                } else {
                    System.out.println(conta.toString());
                } 
            }
        }
    } 