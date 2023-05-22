package desafio.itau.sistema.casouso.imp;

import desafio.itau.sistema.casouso.porta.PortaCadastroUsuario;
import desafio.itau.sistema.dominio.modelo.*;
import desafio.itau.sistema.dominio.servico.CadastroUsuario;
import desafio.itau.sistema.porta.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class PortaCadastroUsuarioImp implements PortaCadastroUsuario {

    @Autowired
    private CadastroUsuario cadastro;

    @Autowired
    private UsuarioRepositorio repositorio;

    @Override
    @Transactional
    public Long cadastraUsuario(Usuario usuario){
        cadastro.validar(usuario);

        return repositorio.cadastra(usuario);
    }

    @Override
    public Usuario consulta(Long id){
        return repositorio.find(id);
    }
}
