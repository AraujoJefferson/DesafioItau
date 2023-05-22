package teste.integracao;

import desafio.itau.sistema.dominio.modelo.NegocioException;
import desafio.itau.sistema.dominio.modelo.Usuario;
import desafio.itau.sistema.porta.UsuarioRepositorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Serviço de banco de dados - Usuario")
@ContextConfiguration(classes = Config.class)
@ExtendWith(SpringExtension.class)
public class TesteUsuarioRepositorio {

    @Autowired
    UsuarioRepositorio rep;

    @Test
    @DisplayName("cadastra usuario nulo")
    void teste1(){
        try{
            var conta = rep.cadastra(null);
            assertTrue(conta == null, "Usuario deve ser nula.");
        } catch (NegocioException e){
            fail("Deve carregar um usuario nulo");
        }
    }

    @Test
    @DisplayName("cadastra usuario preenchido")
    void teste2(){
        try{
            Usuario user = new Usuario("Jefferson", "abacaxi", LocalDate.now(), null, null) ;
            rep.cadastra(user);
            Usuario usuario = rep.find(1L);
            System.out.println(usuario);
            assertFalse(usuario == null, "Deve cadastrar usuario.");
            assertEquals(usuario.getNome() ,user.getNome(), "Deve bater o nome.");
            assertEquals(usuario.getEmail() ,user.getEmail(), "Deve bater o e-mail.");
            assertEquals(usuario.getDt_aniversario() ,user.getDt_aniversario(), "Deve bater o aniversario.");
        } catch (NegocioException e){
            fail("Deve cadastrar um usuario preenchido");
        }
    }
}
