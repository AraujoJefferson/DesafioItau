package teste.casouso;

import desafio.itau.sistema.casouso.porta.PortaCadastroUsuario;
import desafio.itau.sistema.dominio.modelo.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("Caso de Uso - Serviço de Cadastro de Usuário")
@ContextConfiguration(classes = Build1.class)
@ExtendWith(SpringExtension.class)
public class TesteAdaptadorCadastroUsuario {

    private String nome = "Jefferson Araujo";
    private String email = "araujo.jeffersonp@gmail.com";
    private LocalDate dtNascimento = LocalDate.now().minusYears(18);
    private String nomeLogradouro = "Rua José";
    private String complemento = "lt 00 Qd A";
    private String cep = "12345-090";
    private String nomeBairro = "Jacarépagua";
    private String nomeEstado = "Rio de Janeiro";
    private String nomePais = "Brasil";
    private List<String> habilidade = new ArrayList<>();

    @Autowired
    PortaCadastroUsuario porta;

    public TesteAdaptadorCadastroUsuario(){
        this.habilidade.add("Programação");
        this.habilidade.add("Liderança");
        this.habilidade.add("C#");
        this.habilidade.add("C++");
    }

    // Teste Negativo nome
    @Test
    @DisplayName("cadastra usuario nome nulo")
    void teste1(){
        try{
            porta.cadastraUsuario(null);
            fail("Usuario deve ser inválido");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Usuário é obrigatório.");
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("cadastra usuario nome vazio")
    void teste2(){
        try{
            Usuario usuario = new Usuario(null,null,null, null, null);

            porta.cadastraUsuario(usuario);
            fail("Usuario deve ser inválido");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Nome é obrigatório.");
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("cadastra usuario nome contêm símbolo")
    void teste3(){
        try{
            Usuario usuario = new Usuario(nome + "$",null,null, null, null);

            porta.cadastraUsuario(usuario);
            fail("Usuario deve ser inválido");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Nome contêm símbolos.");
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("cadastra usuario email nulo")
    void teste4(){
        try{
            Usuario usuario = new Usuario(nome,null,null, null, null);

            porta.cadastraUsuario(usuario);
            fail("Usuario deve ser inválido");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "E-mail é obrigatório.");
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("cadastra usuario email vazio")
    void teste5(){
        try{
            Usuario usuario = new Usuario(nome ,"",null, null, null);

            porta.cadastraUsuario(usuario);
            fail("Usuario deve ser inválido");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "E-mail é obrigatório.");
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("cadastra usuario email invalido")
    void teste6(){
        try{
            Usuario usuario = new Usuario(nome ,email + "*",null, null, null);

            porta.cadastraUsuario(usuario);
            fail("Usuario deve ser inválido");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "E-mail é inválido.");
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("cadastra usuario data de nascimento nulo")
    void teste7(){
        try{
            Usuario usuario = new Usuario(nome ,email,null, null, null);

            porta.cadastraUsuario(usuario);
            fail("Usuario deve ser inválido");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Data de nascimento é obrigatório.");
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("cadastra usuario data de nascimento menor idade")
    void teste8(){
        try{
            Usuario usuario = new Usuario(nome ,email,LocalDate.now(), null, null);

            porta.cadastraUsuario(usuario);
            fail("Usuario deve ser inválido");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Não permitido para menores de idade.");
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("cadastra usuario nome logradouro nulo")
    void teste9(){
        try{
            Usuario usuario = new Usuario(nome ,email,dtNascimento, null, null);

            porta.cadastraUsuario(usuario);
            fail("Usuario deve ser inválido");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Endereço é obrigatório.");
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("cadastra usuario nome logradouro vazia")
    void teste10(){
        try{
            Endereco endereco = new Endereco(null, null, null, null, null,null,null);
            Usuario usuario = new Usuario(nome ,email,dtNascimento, endereco, null);

            porta.cadastraUsuario(usuario);
            fail("Usuario deve ser inválido");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Nome Logradouro é obrigatório.");
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("cadastra usuario nome logradouro contêm símbolo")
    void teste11(){
        try{
            Endereco endereco = new Endereco(nomeLogradouro + "$", null, null, null, null, null, null);
            Usuario usuario = new Usuario(nome ,email,dtNascimento, endereco, null);

            porta.cadastraUsuario(usuario);
            fail("Usuario deve ser inválido");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Nome Logradouro contêm símbolos.");
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("cadastra usuario número vazia")
    void teste12(){
        try{
            Endereco endereco = new Endereco(nomeLogradouro , null, null, null, null, null, null);
            Usuario usuario = new Usuario(nome ,email,dtNascimento, endereco, null);

            porta.cadastraUsuario(usuario);
            fail("Usuario deve ser inválido");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Número é obrigatório.");
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("cadastra usuario número invalido")
    void teste13(){
        try{
            Endereco endereco = new Endereco(nomeLogradouro , -1, null, null, null, null, null);
            Usuario usuario = new Usuario(nome ,email,dtNascimento, endereco, null);

            porta.cadastraUsuario(usuario);
            fail("Usuario deve ser inválido");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Número é inválido.");
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("cadastra usuario complemento nulo")
    void teste14(){
        try{
            Endereco endereco = new Endereco(nomeLogradouro , 0, null, null, null, null, null);
            Usuario usuario = new Usuario(nome ,email,dtNascimento, endereco, null);

            porta.cadastraUsuario(usuario);
            fail("Usuario deve ser inválido");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Complemento é obrigatório.");
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("cadastra usuario complemento vazia")
    void teste15(){
        try{
            Endereco endereco = new Endereco(nomeLogradouro , 0, "", null, null, null, null);
            Usuario usuario = new Usuario(nome ,email,dtNascimento, endereco, null);

            porta.cadastraUsuario(usuario);
            fail("Usuario deve ser inválido");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Complemento é obrigatório.");
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("cadastra usuario complemento contêm símbolo")
    void teste16(){
        try{
            Endereco endereco = new Endereco(nomeLogradouro , 0, complemento + "$", null, null, null, null);
            Usuario usuario = new Usuario(nome ,email,dtNascimento, endereco, null);

            porta.cadastraUsuario(usuario);
            fail("Usuario deve ser inválido");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Complemento contêm símbolos.");
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("cadastra usuario cep nulo")
    void teste17(){
        try{
            Endereco endereco = new Endereco(nomeLogradouro , 0, complemento , null, null, null, null);
            Usuario usuario = new Usuario(nome ,email,dtNascimento, endereco, null);

            porta.cadastraUsuario(usuario);
            fail("Usuario deve ser inválido");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Cep é obrigatório.");
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("cadastra usuario cep vazio")
    void teste18(){
        try{
            Endereco endereco = new Endereco(nomeLogradouro , 0, complemento , "", null, null, null);
            Usuario usuario = new Usuario(nome ,email,dtNascimento, endereco, null);

            porta.cadastraUsuario(usuario);
            fail("Usuario deve ser inválido");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Cep é obrigatório.");
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("cadastra usuario cep inválido")
    void teste19(){
        try{
            Endereco endereco = new Endereco(nomeLogradouro , 0, complemento , cep + "&", null, null, null);
            Usuario usuario = new Usuario(nome ,email,dtNascimento, endereco, null);

            porta.cadastraUsuario(usuario);
            fail("Usuario deve ser inválido");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Cep é inválido.");
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("cadastra usuario bairro nulo")
    void teste20(){
        try{
            Endereco endereco = new Endereco(nomeLogradouro , 0, complemento , cep , null, null, null);
            Usuario usuario = new Usuario(nome ,email,dtNascimento, endereco, null);

            porta.cadastraUsuario(usuario);
            fail("Usuario deve ser inválido");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Bairro é obrigatório.");
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("cadastra usuario bairro vazio")
    void teste21(){
        try{
            Bairro bairro = new Bairro("");
            Endereco endereco = new Endereco(nomeLogradouro , 0, complemento , cep , bairro, null, null);
            Usuario usuario = new Usuario(nome ,email,dtNascimento, endereco, null);

            porta.cadastraUsuario(usuario);
            fail("Usuario deve ser inválido");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Nome bairro é obrigatório.");
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("cadastra usuario bairro contem simbolo")
    void teste22(){
        try{
            Bairro bairro = new Bairro(nomeBairro+"&");
            Endereco endereco = new Endereco(nomeLogradouro , 0, complemento , cep , bairro, null, null);
            Usuario usuario = new Usuario(nome ,email,dtNascimento, endereco, null);

            porta.cadastraUsuario(usuario);
            fail("Usuario deve ser inválido");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Nome bairro contêm símbolos.");
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("cadastra usuario estado nulo")
    void teste23(){
        try{
            Bairro bairro = new Bairro(nomeBairro);
            Endereco endereco = new Endereco(nomeLogradouro , 0, complemento , cep , bairro, null, null);
            Usuario usuario = new Usuario(nome ,email,dtNascimento, endereco, null);

            porta.cadastraUsuario(usuario);
            fail("Usuario deve ser inválido");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "UF é obrigatório.");
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("cadastra usuario estado vazio")
    void teste24(){
        try{
            UF uf = new UF("");
            Bairro bairro = new Bairro(nomeBairro);
            Endereco endereco = new Endereco(nomeLogradouro , 0, complemento , cep , bairro, uf, null);
            Usuario usuario = new Usuario(nome ,email,dtNascimento, endereco, null);

            porta.cadastraUsuario(usuario);
            fail("Usuario deve ser inválido");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Nome estado é obrigatório.");
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("cadastra usuario estado contem simbolo")
    void teste25(){
        try{
            UF uf = new UF(nomeEstado+"&");
            Bairro bairro = new Bairro(nomeBairro);
            Endereco endereco = new Endereco(nomeLogradouro , 0, complemento , cep , bairro, uf, null);
            Usuario usuario = new Usuario(nome ,email,dtNascimento, endereco, null);

            porta.cadastraUsuario(usuario);
            fail("Usuario deve ser inválido");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Nome estado contêm símbolos.");
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("cadastra usuario pais nulo")
    void teste26(){
        try{
            UF uf = new UF(nomeEstado);
            Bairro bairro = new Bairro(nomeBairro);
            Endereco endereco = new Endereco(nomeLogradouro , 0, complemento , cep , bairro, uf, null);
            Usuario usuario = new Usuario(nome ,email,dtNascimento, endereco, null);

            porta.cadastraUsuario(usuario);
            fail("Usuario deve ser inválido");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Pais é obrigatório.");
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("cadastra usuario estado vazio")
    void teste27(){
        try{
            Pais pais = new Pais("");
            UF uf = new UF(nomeEstado);
            Bairro bairro = new Bairro(nomeBairro);
            Endereco endereco = new Endereco(nomeLogradouro , 0, complemento , cep , bairro, uf, pais);
            Usuario usuario = new Usuario(nome ,email,dtNascimento, endereco, null);

            porta.cadastraUsuario(usuario);
            fail("Usuario deve ser inválido");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Nome pais é obrigatório.");
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("cadastra usuario estado contem simbolo")
    void teste28(){
        try{
            Pais pais = new Pais(nomePais+"&");
            UF uf = new UF(nomeEstado);
            Bairro bairro = new Bairro(nomeBairro);
            Endereco endereco = new Endereco(nomeLogradouro , 0, complemento , cep , bairro, uf, pais);
            Usuario usuario = new Usuario(nome ,email,dtNascimento, endereco, null);

            porta.cadastraUsuario(usuario);
            fail("Usuario deve ser inválido");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Nome pais contêm símbolos.");
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("cadastra usuario habilidade contem nulo")
    void teste29(){
        try{
            Pais pais = new Pais(nomePais);
            UF uf = new UF(nomeEstado);
            Bairro bairro = new Bairro(nomeBairro);
            Endereco endereco = new Endereco(nomeLogradouro , 0, complemento , cep , bairro, uf, pais);
            Usuario usuario = new Usuario(nome ,email,dtNascimento, endereco, null);

            porta.cadastraUsuario(usuario);
            fail("Usuario deve ser inválido");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Habilidade é obrigatório.");
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("cadastra usuario habilidade vazia")
    void teste30(){
        try{
            Pais pais = new Pais(nomePais);
            UF uf = new UF(nomeEstado);
            Bairro bairro = new Bairro(nomeBairro);
            Endereco endereco = new Endereco(nomeLogradouro , 0, complemento , cep , bairro, uf, pais);
            Usuario usuario = new Usuario(nome ,email,dtNascimento, endereco, new ArrayList<>());

            porta.cadastraUsuario(usuario);
            fail("Usuario deve ser inválido");
        }catch (NegocioException e){
            assertEquals(e.getMessage(), "Habilidade é obrigatório.");
            System.out.println(e.getMessage());
        }

    }

    @Test
    @DisplayName("cadastra usuario com sucesso")
    void teste31(){
        Long id = null;
        Usuario usuario = null;
        try{
            Pais pais = new Pais(nomePais);
            UF uf = new UF(nomeEstado);
            Bairro bairro = new Bairro(nomeBairro);
            Endereco endereco = new Endereco(nomeLogradouro , 0, complemento , cep , bairro, uf, pais);
            usuario = new Usuario(nome ,email,dtNascimento, endereco, habilidade);

            id = porta.cadastraUsuario(usuario);
        } catch (NegocioException e){
            fail("Não deve gerar erro de cadastro - " + e.getMessage());
        }

        try{
            var usuarioBanco = porta.consulta(id);
            assertEquals(usuario.getNome(),usuarioBanco.getNome(), "Nome usuário Cadastrado com sucesso.");
            assertEquals(usuario.getEmail(),usuarioBanco.getEmail(), "E-mail usuário Cadastrado com sucesso.");
            assertEquals(usuario.getDt_aniversario(),usuarioBanco.getDt_aniversario(), "Data aniversário usuário Cadastrado com sucesso.");
            assertEquals(usuario.getHabilidades(),usuarioBanco.getHabilidades(), "Habilidades usuário Cadastrado com sucesso.");
            assertEquals(usuario,usuarioBanco, "Usuário Cadastrado com sucesso.");

        } catch (NegocioException e){

        }
    }
}
