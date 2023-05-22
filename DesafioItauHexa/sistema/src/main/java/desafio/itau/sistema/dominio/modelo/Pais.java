package desafio.itau.sistema.dominio.modelo;

import static desafio.itau.sistema.dominio.modelo.Erro.contemSimbolo;
import static desafio.itau.sistema.dominio.modelo.Erro.obrigatorio;
import static desafio.itau.sistema.dominio.modelo.Util.contemSimbolos;
import static java.util.Objects.isNull;

public class Pais {

    private String nome;

    public Pais() {
        this.nome = "não informado";

    }

    public Pais(String nome) {
        this.nome = nome;
    }

    public void validar() {
        if (isNull(nome)|| nome.isEmpty()){
            obrigatorio("Nome pais");
        }

        if(contemSimbolos(nome)){
            contemSimbolo("Nome pais");
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
        return "Pais{" +
                " nome='" + nome + '\'' +
                '}';
    }
}
