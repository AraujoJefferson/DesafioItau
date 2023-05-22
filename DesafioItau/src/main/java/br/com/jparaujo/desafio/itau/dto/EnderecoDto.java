package br.com.jparaujo.desafio.itau.dto;

import br.com.jparaujo.desafio.itau.exception.NegocioException;

import javax.validation.constraints.NotNull;

import static java.util.Objects.isNull;
import static br.com.jparaujo.desafio.itau.exception.Util.*;
import static br.com.jparaujo.desafio.itau.exception.Erro.*;

public class EnderecoDto {

    @NotNull
    private String logradouro;

    @NotNull
    private Integer numero;

    private String complemento;

    @NotNull
    private String cep;

    @NotNull
    private String bairro;

    @NotNull
    private String estado;

    @NotNull
    private String pais;



    public void validar()  throws NegocioException {

        if (isNull(logradouro) || logradouro.isEmpty()){
            obrigatorio("Nome Logradouro");
        }

        if(contemSimbolos(logradouro)){
            contemSimbolo("Nome Logradouro");
        }

        if (isNull(numero)){
            obrigatorio("Número");
        }

        if (numero < 0){
            invalido("Número");
        }

        if (isNull(complemento) || complemento.isEmpty()){
            obrigatorio("Complemento");
        }

        if(complementoInvalido(complemento)){
            contemSimbolo("Complemento");
        }

        if (isNull(cep) || cep.isEmpty()){
            obrigatorio("Cep");
        }

        if (cepInvalido(cep)){
            invalido("Cep");
        }

        if(isNull(bairro)|| bairro.isEmpty()){
            obrigatorio("Bairro");
        }

        if(isNull(estado)|| estado.isEmpty()){
            obrigatorio("UF");
        }

        if(isNull(pais)|| pais.isEmpty()){
            obrigatorio("Pais");
        }
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
