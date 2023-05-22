package br.com.jparaujo.desafio.itau.controller;

import br.com.jparaujo.desafio.itau.dto.UsuarioDto;
import br.com.jparaujo.desafio.itau.exception.NegocioException;
import br.com.jparaujo.desafio.itau.service.UsuarioService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@Validated
@RequestMapping("usuario")
public class UsuarioController {
    private static final Logger LOGGER = LogManager.getLogger(UsuarioController.class);

    @Autowired
    private UsuarioService service;

    @RequestMapping(method = RequestMethod.POST, path = "/cadastra", consumes =  "application/json")
    public ResponseEntity cadastraUsuario(@Valid @RequestBody UsuarioDto usuario) throws NegocioException {
        return new ResponseEntity(service.cadastra(usuario), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/busca/{id}", consumes =  "application/json")
    public ResponseEntity cadastraUsuario(@PathVariable(name = "id")  @NotNull Long id) throws NegocioException {
        return new ResponseEntity(service.consulta(id), HttpStatus.OK);
    }
}

