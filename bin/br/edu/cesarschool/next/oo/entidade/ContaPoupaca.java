public class ContaPoupaca extends ContaCorrente{
    private double percentualBonus;
    public ContaPoupaca(){}
    public ContaPoupaca(String numero,double saldo, String nome, double percentualBonus){
        super(numero,saldo,nome);
        this.percentualBonus = percentualBonus;
    }
    public double getPercentualBonus() {
        return percentualBonus;
    }
    public void setPercentualBonus(double percentualBonus) {
        this.percentualBonus = percentualBonus;
    }
    public void creditar(double valor){
        saldo = saldo + valor *(1 + percentualBonus/ 100);
    }
    @Override
    public String toString(){  
        return "Nome: " + this.nomeCorrentista + "\nNumero: " + this.numero + "\nSaldo: " + this.saldo + "Percentual de Bonus: " + this.percentualBonus;  
    }
    
    @Override
    public String obterNumero(){
        return "Numero: " + this.numero;
    }
}
