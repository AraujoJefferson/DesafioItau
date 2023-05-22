package desafio.itau.sistema.dominio.modelo;

import static desafio.itau.sistema.dominio.modelo.Erro.contemSimbolo;
import static desafio.itau.sistema.dominio.modelo.Erro.obrigatorio;
import static desafio.itau.sistema.dominio.modelo.Util.contemSimbolos;
import static java.util.Objects.isNull;

public class Habilidade {


    private String tipo;

    public Habilidade() {
        this.tipo = "não informado";

    }

    public Habilidade(String tipo) {
        this.tipo = tipo;
    }

    public void validar() {
        if (isNull(tipo)|| tipo.isEmpty()){
            obrigatorio("Nome habilidade");
        }

        if(contemSimbolos(tipo)){
            contemSimbolo("Nome habilidade");
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Habilidade{" +
                " tipo='" + tipo + '\'' +
                '}';
    }
}
