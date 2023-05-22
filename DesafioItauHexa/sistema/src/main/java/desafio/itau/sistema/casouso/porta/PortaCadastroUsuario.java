package desafio.itau.sistema.casouso.porta;

import desafio.itau.sistema.dominio.modelo.Usuario;

public interface PortaCadastroUsuario {
    Long cadastraUsuario(Usuario usuario);
    Usuario consulta(Long id);
}
