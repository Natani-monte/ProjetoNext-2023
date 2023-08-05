package br.edu.cesarschool.next.oo.entidade;

import java.io.Serializable;

public class Produto extends RegistroIdentificavel implements Serializable {
   private static final long serialVersionUID = 1L;
   private String codigo;
   private String nome;
   private double preco;

   public Produto() {
   }

   public Produto(String codigo, String nome, double preco) {
      this.codigo = codigo;
      this.nome = nome;
      this.preco = preco;
   }

   public String getNome() {
      return this.nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getCodigo() {
      return this.codigo;
   }

   public double getPreco() {
      return this.preco;
   }

   public void aumentarPreco(double percentual) {
      this.preco *= 1.0 + percentual / 100.0;
   }

   public String toString() {
      return this.nome + " , " + this.codigo + " , " + this.preco;
   }

    public String obterNumero(){
        return "Numero: " + this.numero;
    }
}
