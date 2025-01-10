package Exercicio2.Atividade4;

public class Cnpj {
    private String cnpj;

    public Cnpj(String cnpj){
        if(isValidoCNPJ(cnpj)){
            this.cnpj = cnpj;
        } else {
            throw new IllegalArgumentException("CNPJ inválido!");
        }
    }

    public String getCnpj(){
        return cnpj;
    }
    public static boolean isValidoCNPJ(String cnpj) {
        // Remove caracteres não numéricos
        cnpj = cnpj.replaceAll("\\D", "");

        // Verifica se o CNPJ possui 14 dígitos
        if (cnpj.length() != 14) {
            return false;
        }

        // Verifica se todos os dígitos são iguais (não é um CNPJ válido)
        if (cnpj.chars().distinct().count() == 1) {
            return false;
        }

        try {
            // Cálculo do primeiro dígito verificador
            int soma = 0;
            int[] peso1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
            for (int i = 0; i < 12; i++) {
                soma += Character.getNumericValue(cnpj.charAt(i)) * peso1[i];
            }
            int resto = soma % 11;
            int digito1 = (resto < 2) ? 0 : 11 - resto;

            // Cálculo do segundo dígito verificador
            soma = 0;
            int[] peso2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
            for (int i = 0; i < 13; i++) {
                soma += Character.getNumericValue(cnpj.charAt(i)) * peso2[i];
            }
            resto = soma % 11;
            int digito2 = (resto < 2) ? 0 : 11 - resto;

            // Verifica os dígitos verificadores
            return digito1 == Character.getNumericValue(cnpj.charAt(12))
                    && digito2 == Character.getNumericValue(cnpj.charAt(13));
        } catch (NumberFormatException e) {
            return false;
        }
    }
}