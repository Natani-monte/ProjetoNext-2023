package br.edu.cesarschool.next.oo.dao;

import br.edu.cesarschool.next.oo.entidade.Produto;
import br.edu.cesarschool.next.oo.entidade.RegistroIdentificavel;
import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;

public class DAOGenerico {
    CadastroObjetos cadastro = new CadastroObjetos(getClass());

    public DAOGenerico (Class<?> cadastro){
        this.cadastro = new CadastroObjetos();
    }
  public boolean incluir(RegistroIdentificavel reg) {
      RegistroIdentificavel regBusca = this.buscar(prod.getCodigo());
      if (prodBusca != null) {
         return false;
      } else {
         this.cadastro.incluir(prod, prod.getCodigo());
         return true;
      }
   }

   public boolean alterar(RegistroIdentificavel reg) {
      RegistroIdentificavel regBusca = this.buscar(prod.getCodigo());
      if (prodBusca == null) {
         return false;
      } else {
         this.cadastro.alterar(prod, prod.getCodigo());
         return true;
      }
   }

   public Produto buscar(String codigo) {
      return (Produto)this.cadastro.buscar(Produto.class, codigo);
   }

   public Produto[] buscarTodos() {
      Serializable[] rets = this.cadastro.buscarTodos(Produto.class);
      Produto[] prods = new Produto[rets.length];

      for(int i = 0; i < rets.length; ++i) {
         prods[i] = (Produto)rets[i];
      }

      return prods;
   }
/*
  if(conta instanceof ContaPoupanca){
            ContaPoupanca contaP = (ContaPoupanca)conta;

             if(daoContaCorrente.getNumero == null ){
            return " Conta inexistente";
        }
 */
   public Produto excluir(String codigo){
    if ((Produto)this.cadastro.buscar(Produto.class, codigo)){
        Produto[codigo].delete();
    }
   }
}

