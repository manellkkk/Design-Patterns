package Exercicio2.Atividade1;

import java.util.ArrayList;
import java.util.Calendar;

public class Divida {
    private String credor;
    private String cnpj;
    private double totalValor;
    private double valorPago;
    private ArrayList<Pagamento> pagamentos = new ArrayList<Pagamento>();

    public Divida(String credor, Cnpj cnpj, double totalValor) {
        this.credor = credor;
        this.cnpj = cnpj.getCnpj();
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

    public void paga(double valor){
        if(valor <= 0){
            throw new IllegalArgumentException("Valor invalido para pagamento");
        }
        if(valor > 100){
            valor -= 8;
        }
        this.valorPago += valor;
    }

    public void registraPagamento(String pagador, Cnpj cnpj, double valor, Calendar data){
        Pagamento pagamento = new Pagamento(pagador, cnpj, valor, data);
        pagamentos.add(pagamento);
    }

    public ArrayList<Pagamento> pagamentosAntesDe(Calendar data) {
        ArrayList<Pagamento> pagamentosFiltrados = new ArrayList<Pagamento>();

        for (Pagamento pagamento : this.pagamentos) {
            if (pagamento.getData().before(data)) {
                pagamentosFiltrados.add(pagamento);
            }
        }
        return pagamentosFiltrados;
    }

    public ArrayList<Pagamento> pagamentosComValorMaiorQue(double valorMinimo) {
        ArrayList<Pagamento> pagamentosFiltrados = new ArrayList<Pagamento>();
        for (Pagamento pagamento : this.pagamentos) {
            if (pagamento.getValor() > valorMinimo) {
                pagamentosFiltrados.add(pagamento);
            }
        }
        return pagamentosFiltrados;
    }
    
    @SuppressWarnings("unlikely-arg-type")
    public ArrayList<Pagamento> pagamentosDo(String cnpjPagador) {
        ArrayList<Pagamento> pagamentosFiltrados = new ArrayList<Pagamento>();
        for (Pagamento pagamento : this.pagamentos) {
            if (pagamento.getCnpj().equals(cnpjPagador)) {
                pagamentosFiltrados.add(pagamento);
            }
        }
        return pagamentosFiltrados;
    }
}