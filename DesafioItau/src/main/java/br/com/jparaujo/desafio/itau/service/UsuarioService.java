package br.com.jparaujo.desafio.itau.service;

import br.com.jparaujo.desafio.itau.controller.UsuarioController;
import br.com.jparaujo.desafio.itau.dao.entity.Usuario;
import br.com.jparaujo.desafio.itau.dao.repository.UsuarioRepository;
import br.com.jparaujo.desafio.itau.dto.UsuarioDto;
import br.com.jparaujo.desafio.itau.exception.NegocioException;
import br.com.jparaujo.desafio.itau.mapper.UsuarioMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class UsuarioService {

    private static final Logger LOGGER = LogManager.getLogger(UsuarioController.class);

    @Autowired
    private UsuarioRepository repository;

    public UsuarioDto cadastra(UsuarioDto usuarioDto)  throws NegocioException {
        usuarioDto.validar();
        UsuarioMapper.mapToUsuario(usuarioDto);
        return UsuarioMapper.mapToUsuarioDto(repository.save(UsuarioMapper.mapToUsuario(usuarioDto)));
    }


    public UsuarioDto consulta(Long id)  throws NegocioException {
        if(isNull(id)){
            return null;
        }

        Optional<Usuario> byId = repository.findById(id);
        if(byId.isPresent()){
            return UsuarioMapper.mapToUsuarioDto(byId.get());
        }

        return null;
    }
}
