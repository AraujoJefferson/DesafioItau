package desafio.itau.adaptador;

import desafio.itau.sistema.dominio.modelo.NegocioException;
import desafio.itau.sistema.dominio.modelo.Usuario;
import desafio.itau.sistema.porta.UsuarioRepositorio;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

@Component
public class AdaptadorUsuarioFakeImp implements UsuarioRepositorio {
    private Map<Long, Usuario> banco = new HashMap<>();

    @Override
    public Long cadastra(Usuario usuario) {
        System.out.println("Fake Banco de dados -> cadastra(usuario)");

        if(!isNull(usuario)){
            Long id = Long.valueOf(banco.size());
            banco.put(id, usuario);
            return id;
        } else {
            throw new NegocioException("Usuário inexistente " + usuario.toString());
        }

    }

    @Override
    public Usuario find(Long id) {
        System.out.println("Fake Banco de dados -> consultar(id)");
        return banco.get(id);
    }
}
