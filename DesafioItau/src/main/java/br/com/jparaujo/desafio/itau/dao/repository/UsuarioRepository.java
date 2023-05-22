package br.com.jparaujo.desafio.itau.dao.repository;

import br.com.jparaujo.desafio.itau.dao.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    @Override
    Optional<Usuario> findById(Long aLong);

    Optional<Usuario> findByNome(String name);

    @Override
    Iterable<Usuario> findAll();
}
