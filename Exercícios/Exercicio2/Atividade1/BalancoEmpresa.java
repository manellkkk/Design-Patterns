package Exercicio2.Atividade1;

import java.util.HashMap;

import Exercicio1.Atividade1.Divida;

public class BalancoEmpresa {
    private HashMap<String, Divida> dividas = new HashMap<String, Divida>();
    
    public BalancoEmpresa(){
        Divida divida = new Divida(null, null, 0);
    }
}