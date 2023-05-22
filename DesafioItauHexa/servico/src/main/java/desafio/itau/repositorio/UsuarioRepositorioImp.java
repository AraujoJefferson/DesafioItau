package desafio.itau.repositorio;

import desafio.itau.sistema.dominio.modelo.NegocioException;
import desafio.itau.sistema.dominio.modelo.Usuario;
import desafio.itau.sistema.porta.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;

import static java.util.Objects.isNull;

@Repository
public class UsuarioRepositorioImp implements UsuarioRepositorio {

    private static final String ERRO = "Erro inesperado ao acesso ao banco. Entre em contato com o administrador.";

    private JdbcTemplate jdbc;

    @Autowired
    public UsuarioRepositorioImp(JdbcTemplate jdbc){
        this.jdbc = jdbc;
    }


    @Override
    @Transactional
    public Long cadastra(Usuario usuario) {
        if(isNull(usuario)){
            return null;
        }

        var sql = "INSERT INTO TB_USUARIO (CD_USUARIO, TX_NOME, TX_EMAIL, DT_ANIVERSARIO, CD_ENDERECO) VALUES (?, ?, ?, ?, ?);";
        var pm = new Object[]{1, usuario.getNome(), usuario.getEmail(), usuario.getDt_aniversario(), usuario.getEndereco()};
        try{
           jdbc.update(sql, pm);
        }catch(Exception e){
            e.printStackTrace();
            throw new NegocioException(ERRO);
        }
        return 1L;
    }

    @Override
    public Usuario find(Long id) {
        if(isNull(id)){
            return null;
        }
        new Usuario("Jefferson", "abacaxi", LocalDate.now(), null, null) ;
        var sql = "select * from TB_USUARIO where CD_USUARIO = ?";
        var pm = new Object[]{id};
        RowMapper<Usuario> orm = (rs, nm) ->
                new Usuario(rs.getString(2), rs.getString(3), LocalDate.now(), null, null);
        try{
            var lista = jdbc.query(sql, pm, orm);
            if(lista.isEmpty()){
                return null;
            }
            return lista.get(0);
        }catch(Exception e){
            e.printStackTrace();
            throw new NegocioException(ERRO);
        }
    }
}
