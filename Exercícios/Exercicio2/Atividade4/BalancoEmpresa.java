package Exercicio2.Atividade4;

import java.util.HashMap;

public class BalancoEmpresa {

    private HashMap<String, Divida> dividas = new HashMap<String, Divida>();

    public void registraDivida(String credor, Cnpj cnpj, double valor) {
        Divida divida = new Divida(credor, cnpj, valor);
        dividas.put(credor, divida);
    }

    public void pagaDivida(Cnpj cnpjCredor, Pagamento pagamento){
        Divida divida = dividas.get(cnpjCredor.getCnpj());

        if (divida != null) {
            divida.registraPagamento(pagamento);
            divida.paga(pagamento.getValor());
        }
    }
}