package Exercicio2.Atividade1;

import java.util.Calendar;
import java.util.HashMap;

public class BalancoEmpresa {

    private HashMap<String, Divida> dividas = new HashMap<String, Divida>();

    public void registraDivida(String credor, Cnpj cnpj, double valor) {
        Divida divida = new Divida(credor, cnpj, valor);
        dividas.put(credor, divida);
    }

    public void pagaDivida(Cnpj cnpjCredor, double valor, String nomePagador, Cnpj cnpjPagador){
        Divida divida = dividas.get(cnpjCredor.getCnpj());

        if (divida != null) {
            Calendar data = Calendar.getInstance();
            divida.registraPagamento(nomePagador, cnpjPagador, valor, data);
            divida.paga(valor);
        }
    }
}