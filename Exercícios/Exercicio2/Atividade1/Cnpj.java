package Exercicio2.Atividade1;

import java.util.InputMismatchException;

public class Cnpj {
    private String cnpj;

    public Cnpj(String cnpj) {
        String cnpjFormatt = "\\d\\d.\\d\\d\\d.\\d\\d\\d/00\\d-\\d\\d";
        if(cnpj.matches(cnpjFormatt)){
            throw new IllegalArgumentException("Formato inválido.\n");
        } else if(isValidoCNPJ(cnpj)){
            throw new IllegalArgumentException("CNPJ inválido.\n");
        }
        this.cnpj = cnpj;
    }

    public Boolean isValidoCNPJ(String cnpj) {
        cnpj = cnpj.replaceAll("[^0-9]", "");
        if (cnpj.length() != 14) {
            return false;
        }
        if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") ||
            cnpj.equals("22222222222222") || cnpj.equals("33333333333333") ||
            cnpj.equals("44444444444444") || cnpj.equals("55555555555555") ||
            cnpj.equals("66666666666666") || cnpj.equals("77777777777777") ||
            cnpj.equals("88888888888888") || cnpj.equals("99999999999999")) {
            return false;
        }
        try {
            int[] multiplicadores1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
            int[] multiplicadores2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
            int soma1 = 0;
            for (int i = 0; i < 12; i++) {
                soma1 += Integer.parseInt(cnpj.charAt(i) + "") * multiplicadores1[i];
            }
            int resto1 = soma1 % 11;
            int digito1 = resto1 < 2 ? 0 : 11 - resto1;

            int soma2 = 0;
            for (int i = 0; i < 13; i++) {
                soma2 += Integer.parseInt(cnpj.charAt(i) + "") * multiplicadores2[i];
            }
            int resto2 = soma2 % 11;
            int digito2 = resto2 < 2 ? 0 : 11 - resto2;
            return cnpj.charAt(12) == (digito1 + "").charAt(0) && cnpj.charAt(13) == (digito2 + "").charAt(0);
        } catch (InputMismatchException e) {
            return false;
        }
    }

    
}