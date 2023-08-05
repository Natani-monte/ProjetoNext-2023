// Source code is decompiled from a .class file using FernFlower decompiler.
package br.edu.cesarschool.next.oo.apresentacao;

import br.edu.cesarschool.next.oo.entidade.Produto;
import br.edu.cesarschool.next.oo.negocio.MediatorProduto;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class TelaProduto {
   private static final Scanner ENTRADA;
   private MediatorProduto mediatorProd = new MediatorProduto();

   static {
      ENTRADA = new Scanner(System.in);
   }

   public TelaProduto() {
   }

   public void iniciarTela() {
      int opcao = 0;
      
      do {
         System.out.println("Escolha uma op\ufffd\ufffdo: ");
         System.out.println("1- Incluir produto");
         System.out.println("2- Alterar pre\ufffdo");
         System.out.println("3- Consultar produto");
         System.out.println("4- Gerar relat\ufffdrio geral de produtos");
         System.out.println("5- Sair");
         opcao = ENTRADA.nextInt();
         if (opcao == 1) {
            this.incluir();
         } else if (opcao == 2) {
            this.alterarPreco();
         } else if (opcao == 3) {
            this.consultarProduto();
         } else if (opcao == 4) {
            this.gerarRelatorioGeralProdutos();
         }
      } while(opcao != 5);

   }

   private void incluir() {
      String codigo = null;
      String nome = null;
      double preco = 0.0;
      System.out.println("Digite o c\ufffddigo: ");
      codigo = ENTRADA.next();
      System.out.println("Digite o nome: ");
      nome = ENTRADA.next();
      System.out.println("Digite o pre\ufffdo: ");
      preco = ENTRADA.nextDouble();
      Produto prod = new Produto(codigo, nome, preco);
      String mensagem = this.mediatorProd.incluir(prod);
      if (mensagem == null) {
         System.out.println("Produto inclu\ufffddo com sucesso!");
      } else {
         System.out.println(mensagem);
      }

   }

   private void alterarPreco() {
      String codigo = null;
      double preco = 0.0;
      System.out.println("Digite o c\ufffddigo: ");
      codigo = ENTRADA.next();
      System.out.println("Digite o percentual de aumento: ");
      preco = ENTRADA.nextDouble();
      String mensagem = this.mediatorProd.alterarPreco(preco, codigo);
      if (mensagem == null) {
         System.out.println("Pre\ufffdo alterado com sucesso!");
      } else {
         System.out.println(mensagem);
      }

   }

   private void consultarProduto() {
      String codigo = null;
      System.out.println("Digite o c\ufffddigo: ");
      codigo = ENTRADA.next();
      Produto prod = this.mediatorProd.buscar(codigo);
      if (prod == null) {
         System.out.println("Produto n\ufffdo encontrado!");
      } else {
         System.out.println("Produto encontrado");
         System.out.println("C\ufffddigo: " + prod.getCodigo());
         System.out.println("Nome: " + prod.getNome());
         System.out.println("Pre\ufffdo: " + prod.getPreco());
      }

   }

   private void gerarRelatorioGeralProdutos() {
      List<Produto> produtos = this.mediatorProd.gerarRelatorioGeral();
      Iterator var3 = produtos.iterator();

      while(var3.hasNext()) {
         Produto produto = (Produto)var3.next();
         System.out.println(produto);
      }

   }
}

