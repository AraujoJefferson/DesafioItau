package br.com.jparaujo.desafio.itau.dto;

import javax.validation.constraints.NotNull;

public class HabilidadeDto {

    @NotNull
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
