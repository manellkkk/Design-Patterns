package Exercicio1.Atividade3;

public class NotaFiscal {
    private double valor;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public NotaFiscal(double valor) {
        if(valor > 10000){
            this.valor *= 0.98;
        } else{
            this.valor *= 0.95;
        }
    }

    /* Qual a vantagem de seguirmos o Tell, Don&#39;t Ask? O que ganhamos com isso? */

    /* O princípio *Tell, Don’t Ask* promove objetos que realizam suas próprias operações em vez de expor dados para 
    serem manipulados externamente. Isso reduz o acoplamento, reforça o encapsulamento e melhora a coesão, facilitando 
    a manutenção e evolução do código. Além disso, torna o sistema mais modular, evita violações da Lei de Demeter e 
    melhora a testabilidade, alinhando o design aos fundamentos da Programação Orientada a Objetos. */
}