package br.edu.cesarschool.next.oo.entidade;

import java.io.Serializable;

public class ContaCorrente extends RegistroIdentificavel implements Serializable {
    private String numero;
    private double saldo;
    private String nomeCorrentista;
    private MediadorContaCorrente mediatorContaCorrente;

    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public double getSaldo() {
        return saldo;
    }
    public String getNomeCorrentista() {
        return nomeCorrentista;
    }
    public void setNomeCorrentista(String nomeCorrentista) {
        this.nomeCorrentista = nomeCorrentista;
    }

    public void creditar(double valor){
        saldo += valor;
    }
    public void debitar(double valor){
        saldo -= valor;

    }

    @Override
    public String toString(){  
        return "Nome: " + this.nomeCorrentista + "\nNumero: " + this.numero + "\nSaldo: " + this.saldo;  
    }
    
    @Override
    public String obterNumero(){
        return "Numero: " + this.numero;
    }
}
