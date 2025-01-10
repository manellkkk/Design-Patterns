package Exercicio2.Atividade4;

import java.util.Calendar;

public class Pagamento {
    public String pagador;
    public Cnpj cnpj;
    public double valor;
    public Calendar data;

    public Pagamento(String pagador, Cnpj cnpj, double valor) {
        this.pagador = pagador;
        this.cnpj = cnpj;
        this.valor = valor;
        this.data = Calendar.getInstance();
    }
    
    public String getPagador() {
        return pagador;
    }
    public void setPagador(String pagador) {
        this.pagador = pagador;
    }
    public Cnpj getCnpj() {
        return cnpj;
    }
    public void setCnpj(Cnpj cnpjPagador) {
        this.cnpj = cnpjPagador;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public Calendar getData() {
        return data;
    }
    public void setData(Calendar data) {
        this.data = data;
    }
}