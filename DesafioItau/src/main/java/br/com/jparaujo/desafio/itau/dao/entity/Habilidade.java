package br.com.jparaujo.desafio.itau.dao.entity;

import br.com.jparaujo.desafio.itau.exception.NegocioException;

import javax.persistence.*;

import java.util.List;

import static br.com.jparaujo.desafio.itau.exception.Erro.*;
import static br.com.jparaujo.desafio.itau.exception.Util.*;
import static java.util.Objects.isNull;

@Entity
@Table(name = "TB_HABILIDADE")
public class Habilidade {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_HABILIDADE")
    private Long id;

    @Column(name = "TX_TIPO")
    private String tipo;

    @ManyToMany(mappedBy="habilidade")
    private List<Usuario> usuario;

    public Habilidade() {
        this.tipo = "não informado";

    }

    public Habilidade(String tipo) {
        this.tipo = tipo;
    }

    public void validar() throws NegocioException {
        if (isNull(tipo)|| tipo.isEmpty()){
            obrigatorio("Nome habilidade");
        }

        if(contemSimbolos(tipo)){
            contemSimbolo("Nome habilidade");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<Usuario> usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Habilidade{" +
                " tipo='" + tipo + '\'' +
                '}';
    }
}
