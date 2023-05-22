package br.com.jparaujo.desafio.itau.dao.entity;

import br.com.jparaujo.desafio.itau.exception.NegocioException;

import javax.persistence.*;

import static br.com.jparaujo.desafio.itau.exception.Erro.*;
import static br.com.jparaujo.desafio.itau.exception.Util.*;
import static java.util.Objects.isNull;

@Entity
@Table(name = "TB_ENDERECO")
public class Endereco {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_ENDERECO")
    private Long id;

    @Column(name = "TX_LOGRADOURO")
    private String nomeLogradouro;

    @Column(name = "NR_LOGRADOURO")
    private Integer numero;

    @Column(name = "TX_COMPLEMENTO")
    private String complemento;

    @Column(name = "TX_CEP")
    private String cep;

    @Column(name = "TX_BAIRRO")
    private String bairro;

    @Column(name = "TX_ESTADO")
    private String estado;

    @Column(name = "TX_PAIS")
    private String pais;

    public Endereco(){
        this.nomeLogradouro = "não informado";
        this.numero = 0;
        this.complemento = "não informado";
        this.cep = "não informado";
        //this.bairro = new Bairro();
        //this.uf =  new UF();
        //this.pais = new Pais();
    }

    public Endereco(String nomeLogradouro, Integer numero, String complemento, String cep, String bairro, String estado, String pais) {
        this.nomeLogradouro = nomeLogradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.bairro = bairro;
        this.estado = estado;
        this.pais = pais;
    }

    public void validar() throws NegocioException {

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

        if(isNull(bairro)|| bairro.isEmpty()){
            obrigatorio("Bairro");
        }

        if(isNull(estado)|| estado.isEmpty()){
            obrigatorio("Estado");
        }

        if(isNull(pais)|| pais.isEmpty()){
            obrigatorio("Estado");
        }

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", nomeLogradouro='" + nomeLogradouro + '\'' +
                ", numero=" + numero +
                ", complemento='" + complemento + '\'' +
                ", cep='" + cep + '\'' +
                ", bairro='" + bairro + '\'' +
                ", estado='" + estado + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
