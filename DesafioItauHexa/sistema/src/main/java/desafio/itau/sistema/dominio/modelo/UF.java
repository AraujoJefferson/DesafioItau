package desafio.itau.sistema.dominio.modelo;

import static desafio.itau.sistema.dominio.modelo.Erro.contemSimbolo;
import static desafio.itau.sistema.dominio.modelo.Erro.obrigatorio;
import static desafio.itau.sistema.dominio.modelo.Util.contemSimbolos;
import static java.util.Objects.isNull;

public class UF {

    private String nome;

    public UF() {
        this.nome = "não informado";

    }
    public UF(String nome) {
        this.nome = nome;
    }

    public void validar() {
        if (isNull(nome)|| nome.isEmpty()){
            obrigatorio("Nome estado");
        }

        if(contemSimbolos(nome)){
            contemSimbolo("Nome estado");
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
        return "UF{" +
                " nome='" + nome + '\'' +
                '}';
    }
}
