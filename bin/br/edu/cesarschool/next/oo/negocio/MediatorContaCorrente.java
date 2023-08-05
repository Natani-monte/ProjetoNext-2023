public class MediatorContaCorrente {
    private DAOContaCorrente daoContaCorrente = new DAOContaCorrente();

    public MediatorContaCorrente(){}
    public String incluir(ContaCorrente conta){

        // Teste de validação de número

        if(daoContaCorrente.getNumero == null ){
            return " Conta inexistente";
        }
        else if (daoContaCorrente.getNumero.getNumero().length < 5 || daoContaCorrente.getNumero.getNumero().length > 8){
            return "Quantidade invalida de caracteres";
        }

        // Teste de validação de Saldo

        if (daoContaCorrente.getSaldo < 0){
            return "Saldo invalido";
        }

        // Teste de validação do nome do usuário

        if (daoContaCorrente.getNomeCorrentista ==  null && daoContaCorrente.getNomeCorrentista ==" "){
            return "Insuficiencia de caracteres";
        }
        else if(daoContaCorrente.getNomeCorrentista().length > 60){
            return "Quantidade de caracteres execedida";
        }


        //Válidação de conta poupança

        if(conta instanceof ContaPoupanca){
            ContaPoupanca contaP = (ContaPoupanca)conta;

            if(contaP.getPercentualBonus() < 0){

                return "Percentual de bonus inexistente :(";

            } 
            else {
                boolean retorno = daoContaCorrente.incluir(contaP);

                if(!retorno){
                    return "Conta existente!!";
                }
                else {
                    return null;
                }   
            }
        }
    }

    public String creditar(double valor, String numero){

        if(valor < 0){

            return "valor invalido!!";

        }

        else if(stringNulaOuVazia(numero)){

            return "Insuficiencia de caracteres";

        }

        else {

            ContaCorrente contaBusca = daoContaCorrente.buscar(numero);

            if(contaBusca == null){
                return "Conta inexistente";
            }

            else {
                contaBusca.creditar(valor);
                daoContaCorrente.alterar(contaBusca);
                return null;
            }
        }
    }

    public String debitar(double valor, String numero){

        if(valor < 0){
            return "Valor Invalido!!";
        }
         else if(stringNulaOuVazia(numero)){
            return "Insuficiencia de caracteres";
        } 
        else {

            ContaCorrente contaBusca = daoContaCorrente.buscar(numero);

            if(contaBusca == null){
                return "Conta Inexistente";
            } 
            else {
                if(contaBusca.getSaldo() < valor){
                    return "Saldo insuficiente";
                }
                else {
                    contaBusca.debitar(valor);
                    daoContaCorrente.alterar(contaBusca);
                    return null;
                }              
            }
        }
    }

    public ContaCorrente buscar(String numero){

        if(stringNulaOuVazia(numero)){
            return null;
        } 
        else {
            return daoContaCorrente.buscar(numero);
        }
    }

    public List<ContaCorrente> gerarRelatorioGeral(){

        ContaCorrente[] contas = daoContaCorrente.buscarTodos();
        List<ContaCorrente> listaContas = Arrays.asList(contas);
		Collections.sort(listaContas, new ComparadorContaCorrenteSaldo());

		return listaContas;
    }
}
  
