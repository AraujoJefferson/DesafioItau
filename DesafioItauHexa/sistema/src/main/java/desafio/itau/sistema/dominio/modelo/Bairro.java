package desafio.itau.sistema.dominio.modelo;

import static java.util.Objects.isNull;
import static desafio.itau.sistema.dominio.modelo.Erro.*;
import static desafio.itau.sistema.dominio.modelo.Util.*;
public class Bairro {

    private String nome;

    public Bairro() {
        this.nome = "não informado";

    }

    public Bairro( String nome) {
        this.nome = nome;
    }

    public void validar() {

        if (isNull(nome) || nome.isEmpty()){
            obrigatorio("Nome bairro");
        }

        if(contemSimbolos(nome)){
            contemSimbolo("Nome bairro");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Bairro{" +
                " nome='" + nome + '\'' +
                '}';
    }
}
