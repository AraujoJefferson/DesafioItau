package br.com.jparaujo.desafio.itau.dto;

import br.com.jparaujo.desafio.itau.exception.NegocioException;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.isNull;
import static br.com.jparaujo.desafio.itau.exception.Util.*;
import static br.com.jparaujo.desafio.itau.exception.Erro.*;

public class UsuarioDto {

    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private String email;

    @NotNull
    private LocalDate dtNascimento;

    @NotNull
    private EnderecoDto endereco;

    @NotNull
    private List<HabilidadeDto> habilidades;


    public void validar() throws NegocioException {
        //Nome : Não permite símbolos
        if (isNull(nome) || nome.isEmpty()){
            obrigatorio("Nome");
        }

        if(contemSimbolos(nome)){
            contemSimbolo("Nome");
        }
        //email: validar um email valido dos provedores mais conhecidos(gmail, hotmail, outlook, yahoo)
        if (isNull(email) || email.isEmpty()){
            obrigatorio("E-mail");
        }

        if(emailInvalido(email)){
            invalido("E-mail");
        }

        //data de nascimento: data de nascimento para maiores de 18 anos
        if (isNull(dtNascimento)){
            obrigatorio("Data de nascimento");
        }

        if(verificarMaiorIdade(dtNascimento)){
            menorIdadeNaoPermitido();
        }

        //endereço: não permite caracteres especiais
        if (isNull(endereco)){
            obrigatorio("Endereço");
        }

        endereco.validar();

        //habilidades
        if (isNull(habilidades) || habilidades.isEmpty()){
            obrigatorio("Habilidade");
        }

        if(habilidades.stream().map(Objects::isNull).filter( val -> val == Boolean.TRUE).findAny().isPresent()){
            inexistente("Habilidade");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public EnderecoDto getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDto endereco) {
        this.endereco = endereco;
    }

    public List<HabilidadeDto> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<HabilidadeDto> habilidades) {
        this.habilidades = habilidades;
    }
}
