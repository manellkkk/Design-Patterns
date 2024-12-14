package Exercicio1.Atividade2;

import java.util.ArrayList;

import Exercicio1.Atividade1.Divida;

public class BalancoEmpresa {
    ArrayList<Divida> dividas = new ArrayList<>();

    public ArrayList<Divida> getDividas() {
        return dividas;
    }

    public Boolean criarDivida(String credor, String cnpj, double valorDivida){
        if(credor.isEmpty() || cnpj.isEmpty() || valorDivida <= 0){
            return false;
        }
        Divida divida = new Divida(credor, cnpj, valorDivida);
        dividas.add(divida);
        return true;
    }

    public Boolean pagarDivida(String cnpj, double valorPago){
        if(cnpj.isEmpty() || valorPago <= 0){
            return false;
        }
        int index = -1;
        for(int i = 0; i < dividas.size(); i++){
            Divida divida = dividas.get(i);
            if(cnpj.equals(divida.getCnpj())){
                index = i;
            }
        }
        if(index == -1){
            System.out.println("Não há dívidas cadastradas nesse cnpj.\n");
            return false;
        }
        Divida divida = dividas.get(index);
        if(divida.getValorPago() + valorPago > divida.getTotalValor()){
            System.out.println("Não há como pagar mais do que deve.\n");
            return false;
        }
        divida.paga(valorPago);
        return true;
    }
}