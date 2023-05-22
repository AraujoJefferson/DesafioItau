package br.com.jparaujo.desafio.itau.exception;

public class Erro {

    public static void obrigatorio(String nome) throws NegocioException {
        throw new NegocioException(nome + " é obrigatório.");
    }

    public static void inexistente(String nome) throws NegocioException {
        throw new NegocioException(nome + " é inexistente.");
    }


    public static void contemSimbolo(String nome) throws NegocioException {
        throw new NegocioException(nome + " contêm símbolos.");
    }

    public static void invalido(String nome) throws NegocioException {
        throw new NegocioException(nome + " é inválido.");
    }

    public static void menorIdadeNaoPermitido() throws NegocioException {
        throw new NegocioException("Não permitido para menores de idade.");
    }

}
