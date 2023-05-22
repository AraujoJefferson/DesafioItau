package desafio.itau.sistema.dominio.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;
import static desafio.itau.sistema.dominio.modelo.Erro.*;
import static desafio.itau.sistema.dominio.modelo.Util.*;

public class Usuario {

    private String nome;
    private String email;
    private LocalDate dt_aniversario;
    private Endereco endereco;
    private List<String> habilidades;

    public Usuario() {
        this.nome = "não informado";
        this.email = "não informado";
        this.dt_aniversario = null;
        this.endereco = new Endereco();
        this.habilidades = new ArrayList<>();
    }

    public Usuario(String nome, String email, LocalDate dt_aniversario, Endereco endereco, List<String> habilidades) {
        this.nome = nome;
        this.email = email;
        this.dt_aniversario = dt_aniversario;
        this.endereco = endereco;
        this.habilidades = habilidades;
    }



    public void validar() {
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
        if (isNull(dt_aniversario)){
            obrigatorio("Data de nascimento");
        }

        if(verificarMaiorIdade(dt_aniversario)){
            menorIdadeNaoPermitido();
        }

        //endereço: não permite caracteres especiais
        if (isNull(endereco)){
            obrigatorio("Endereço");
        }

        endereco.validar();

        //habilidade
        if (isNull(habilidades) || habilidades.isEmpty()){
            obrigatorio("Habilidade");
        }
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

    public LocalDate getDt_aniversario() {
        return dt_aniversario;
    }

    public void setDt_aniversario(LocalDate dt_aniversario) {
        this.dt_aniversario = dt_aniversario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                " nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", dt_aniversario=" + dt_aniversario +
                ", endereco=" + endereco +
                ", habilidades=" + habilidades +
                '}';
    }
}

