package desafio.itau.sistema.dominio.modelo;

import static java.util.Objects.isNull;
import static desafio.itau.sistema.dominio.modelo.Erro.*;
import static desafio.itau.sistema.dominio.modelo.Util.*;

public class Endereco {
    private String nomeLogradouro;
    private Integer numero;
    private String complemento;
    private String cep;
    private Bairro bairro;
    private UF uf;
    private Pais pais;

    public Endereco(){
        this.nomeLogradouro = "não informado";
        this.numero = 0;
        this.complemento = "não informado";
        this.cep = "não informado";
        this.bairro = new Bairro();
        this.uf =  new UF();
        this.pais = new Pais();
    }

    public Endereco(String nomeLogradouro, Integer numero, String complemento, String cep, Bairro bairro, UF uf, Pais pais) {
        this.nomeLogradouro = nomeLogradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.bairro = bairro;
        this.uf = uf;
        this.pais = pais;
    }

    public void validar() {

        if (isNull(nomeLogradouro) || nomeLogradouro.isEmpty()){
            obrigatorio("Nome Logradouro");
        }

        if(contemSimbolos(nomeLogradouro)){
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

        if(isNull(bairro)){
            obrigatorio("Bairro");
        }

        bairro.validar();

        if(isNull(uf)){
            obrigatorio("UF");
        }

        uf.validar();

        if(isNull(pais)){
            obrigatorio("Pais");
        }

        pais.validar();

    }

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
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

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                " nomeLogradouro='" + nomeLogradouro + '\'' +
                ", numero=" + numero +
                ", complemento='" + complemento + '\'' +
                ", cep=" + cep +
                ", bairro=" + bairro +
                ", uf=" + uf +
                ", pais=" + pais +
                '}';
    }
}
