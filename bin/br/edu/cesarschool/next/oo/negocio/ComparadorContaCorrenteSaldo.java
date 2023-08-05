package br.edu.cesarschool.next.oo.negocio;

import br.edu.cesarschool.next.oo.entidade.Produto;

import java.util.Comparator;

public class ComparadorContaCorrente implements Comparator<ContaCorrente>{
    public ComparadorContaCorrente(){}

    public int compare(ContaCorrente o1, ContaCorrente o2) {
        if (o1.getSaldo > o2.getSaldo){
            return 1;
        }
        else if(o1.getSaldo < o2.getSaldo){
            return -1;
        }
        else {
            return 0;

        }
    }
}