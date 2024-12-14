package Exercicio1.Atividade1;

public class Divida {
    private String credor;
    private String cnpj;
    private double totalValor;
    private double valorPago;

    public Divida(String credor, String cnpj, double totalValor) {
        this.credor = credor;
        this.cnpj = cnpj;
        this.totalValor = totalValor;
    }
    
    public String getCredor() {
        return credor;
    }

    public void setCredor(String credor) {
        this.credor = credor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public double getTotalValor() {
        return totalValor;
    }

    public void setTotalValor(double totalValor) {
        this.totalValor = totalValor;
    }

    public double getValorPago() {
        return valorPago;
    }

    public Boolean paga(double valor){
        if(valor <= 0){
            return false;
        }
        this.valorPago += valor;
        return true;
    }
}