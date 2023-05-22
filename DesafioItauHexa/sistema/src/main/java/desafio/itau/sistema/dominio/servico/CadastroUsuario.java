package desafio.itau.sistema.dominio.servico;

import desafio.itau.sistema.dominio.modelo.Usuario;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;
import static desafio.itau.sistema.dominio.modelo.Erro.*;

@Component
public class CadastroUsuario {

    public void validar(Usuario usuario){

        if(isNull(usuario)){
            obrigatorio("Usuário");
        }

        usuario.validar();
    }
}
