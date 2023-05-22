package desafio.itau.sistema.dominio.modelo;

public class Erro {

    public static void obrigatorio(String nome){
        throw new NegocioException(nome + " é obrigatório.");
    }

    public static void inexistente(String nome){
        throw new NegocioException(nome + " é inexistente.");
    }


    public static void contemSimbolo(String nome){
        throw new NegocioException(nome + " contêm símbolos.");
    }

    public static void invalido(String nome){
        throw new NegocioException(nome + " é inválido.");
    }

    public static void menorIdadeNaoPermitido(){
        throw new NegocioException("Não permitido para menores de idade.");
    }

}
