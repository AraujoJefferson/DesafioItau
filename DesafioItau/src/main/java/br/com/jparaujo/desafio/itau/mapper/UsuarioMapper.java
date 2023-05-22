package br.com.jparaujo.desafio.itau.mapper;

import br.com.jparaujo.desafio.itau.dao.entity.Endereco;
import br.com.jparaujo.desafio.itau.dao.entity.Habilidade;
import br.com.jparaujo.desafio.itau.dao.entity.Usuario;
import br.com.jparaujo.desafio.itau.dto.EnderecoDto;
import br.com.jparaujo.desafio.itau.dto.HabilidadeDto;
import br.com.jparaujo.desafio.itau.dto.UsuarioDto;

import java.util.ArrayList;
import java.util.List;

public class UsuarioMapper {

    public static Usuario mapToUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDto.getNome());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setDtNascimento(usuarioDto.getDtNascimento());
        usuario.setEndereco(mapToEndereco(usuarioDto.getEndereco()));
        usuario.setHabilidade(mapToHabilidadeList(usuarioDto.getHabilidades()));
        return usuario;
    }

    public static UsuarioDto mapToUsuarioDto(Usuario usuario) {
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setId(usuario.getId());
        usuarioDto.setNome(usuario.getNome());
        usuarioDto.setEmail(usuario.getEmail());
        usuarioDto.setDtNascimento(usuario.getDtNascimento());
        usuarioDto.setEndereco(mapToEnderecoDto(usuario.getEndereco()));
        usuarioDto.setHabilidades(mapToHabilidadeDtoList(usuario.getHabilidade()));
        return usuarioDto;
    }

    private static EnderecoDto mapToEnderecoDto(Endereco endereco) {
        EnderecoDto enderecoDto = new EnderecoDto();
        enderecoDto.setLogradouro(endereco.getNomeLogradouro());
        enderecoDto.setNumero(endereco.getNumero());
        enderecoDto.setComplemento(endereco.getComplemento());
        enderecoDto.setCep(endereco.getCep());
        enderecoDto.setBairro(endereco.getBairro());
        enderecoDto.setEstado(endereco.getEstado());
        enderecoDto.setPais(endereco.getPais());
        return enderecoDto;
    }

    private static List<HabilidadeDto> mapToHabilidadeDtoList(List<Habilidade> habilidades) {
        List<HabilidadeDto> habilidadeDtos = new ArrayList<>();
        for (Habilidade habilidade : habilidades) {
            habilidadeDtos.add(mapToHabilidadeDto(habilidade));
        }
        return habilidadeDtos;
    }

    private static HabilidadeDto mapToHabilidadeDto(Habilidade habilidade) {
        HabilidadeDto habilidadeDto = new HabilidadeDto();
        habilidadeDto.setTipo(habilidade.getTipo());
        return habilidadeDto;
    }

    private static Endereco mapToEndereco(EnderecoDto enderecoDto) {
        Endereco endereco = new Endereco();
        endereco.setNomeLogradouro(enderecoDto.getLogradouro());
        endereco.setNumero(enderecoDto.getNumero());
        endereco.setComplemento(enderecoDto.getComplemento());
        endereco.setCep(enderecoDto.getCep());
        endereco.setBairro(enderecoDto.getBairro());
        endereco.setEstado(enderecoDto.getEstado());
        endereco.setPais(enderecoDto.getPais());
        return endereco;
    }

    private static List<Habilidade> mapToHabilidadeList(List<HabilidadeDto> habilidadeDtos) {
        List<Habilidade> habilidades = new ArrayList<>();
        for (HabilidadeDto habilidadeDto : habilidadeDtos) {
            habilidades.add(mapToHabilidade(habilidadeDto));
        }
        return habilidades;
    }

    private static Habilidade mapToHabilidade(HabilidadeDto habilidadeDto) {
        Habilidade habilidade = new Habilidade();
        habilidade.setTipo(habilidadeDto.getTipo());
        habilidade.setUsuario(new ArrayList<>()); // Será preenchido posteriormente
        return habilidade;
    }

}
