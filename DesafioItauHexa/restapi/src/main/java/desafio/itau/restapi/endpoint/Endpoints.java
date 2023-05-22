package desafio.itau.restapi.endpoint;

import desafio.itau.sistema.casouso.porta.PortaCadastroUsuario;
import desafio.itau.sistema.dominio.modelo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("usuario")
public class Endpoints {

    private String nome = "Jefferson Araujo";
    private String email = "araujo.jeffersonp@gmail.com";
    private LocalDate dtNascimento = LocalDate.now().minusYears(18);
    private String nomeLogradouro = "Rua José";
    private String complemento = "lt 00 Qd A";
    private String cep = "12345-090";
    private String nomeBairro = "Jacarépagua";
    private String nomeEstado = "Rio de Janeiro";
    private String nomePais = "Brasil";
    private List<String> habilidade = new ArrayList<String>();

    @Autowired
    public PortaCadastroUsuario porta;

    public Endpoints(){}

    @GetMapping("/busca/{codigo}", consumes = "application/json")
    public @ResponseBody Usuario consulta(@PathVariable Long codigo){
        return porta.consulta(codigo);
    }

    @GetMapping(value = "/cadastra", consumes = "application/json")
    public @ResponseBody Long cadastra(@RequestBody Usuario usuario){
        return porta.cadastraUsuario(usuario);
    }

}
