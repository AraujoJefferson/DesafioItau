package br.com.jparaujo.desafio.itau.dao.entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_USUARIO")
    private Long id;

    @Column(name = "TX_NOME")
    private String nome;

    @Column(name = "TX_EMAIL")
    private String email;

    @Column(name = "DT_NASCIMENTO")
    private LocalDate dtNascimento;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CD_ENDERECO")
    private Endereco endereco;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="usuario_has_habilidades", joinColumns=
            {@JoinColumn(name="CD_USUARIO")}, inverseJoinColumns=
            {@JoinColumn(name="CD_HABILIDADE")})
    private List<Habilidade> habilidade;

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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Habilidade> getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(List<Habilidade> habilidade) {
        this.habilidade = habilidade;
    }
}
