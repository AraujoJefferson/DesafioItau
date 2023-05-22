package desafio.itau.sistema.porta;

import desafio.itau.sistema.dominio.modelo.Usuario;

public interface UsuarioRepositorio {
    Long cadastra(Usuario usuario);
    Usuario find(Long id);
}
