package br.com.jparaujo.desafio.itau;


import br.com.jparaujo.desafio.itau.dto.HabilidadeDto;
import br.com.jparaujo.desafio.itau.dto.UsuarioDto;
import br.com.jparaujo.desafio.itau.service.UsuarioService;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.NestedServletException;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class TesteCadastroUsuario {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    UsuarioService service;

    @Test(expected = NestedServletException.class)
    public void cadastroUsuarioInvalido() throws Exception {
        // Crie um objeto JSON com os dados do usuário
        JSONObject usuarioJson = new JSONObject();
        usuarioJson.put("dtNascimento", "2023-05-21");
        usuarioJson.put("email", "abc@gmail.com");

        JSONObject enderecoJson = new JSONObject();
        enderecoJson.put("bairro", "jardu-ins");
        enderecoJson.put("cep", "jhkjkhg0-312");
        enderecoJson.put("complemento", "abcsaf4455 sak");
        enderecoJson.put("estado", "rio32");
        enderecoJson.put("logradouro", "estra4da");
        enderecoJson.put("numero", 0);
        enderecoJson.put("pais", "bras1l 1");

        usuarioJson.put("endereco", enderecoJson);

        JSONArray habilidadesJson = new JSONArray();
        JSONObject habilidadeJson = new JSONObject();
        habilidadeJson.put("tipo", "Programar");
        habilidadesJson.add(habilidadeJson);

        usuarioJson.put("habilidades", habilidadesJson);
        usuarioJson.put("nome", "Jeffers1n");

        mockMvc.perform(post("/usuario/cadastra")
                .contentType(MediaType.APPLICATION_JSON)
                .content(usuarioJson.toString()))
                .andExpect(status().is5xxServerError())
                .andExpect(jsonPath("$.mensagem").value("Nome contêm símbolos."));

    }

    @Test
    public void cadastroUsuarioValido() throws Exception {
        // Crie um objeto JSON com os dados do usuário
        JSONObject usuarioJson = new JSONObject();
        usuarioJson.put("dtNascimento", "2003-05-21");
        usuarioJson.put("email", "abc@gmail.com");

        JSONObject enderecoJson = new JSONObject();
        enderecoJson.put("bairro", "jardins");
        enderecoJson.put("cep", "12345-123");
        enderecoJson.put("complemento", "lt 10 QD");
        enderecoJson.put("estado", "Rio de Janeiro");
        enderecoJson.put("logradouro", "Rua Carioca");
        enderecoJson.put("numero", 0);
        enderecoJson.put("pais", "Brasil");

        usuarioJson.put("endereco", enderecoJson);

        JSONArray habilidadesJson = new JSONArray();
        JSONObject habilidadeJson = new JSONObject();
        habilidadeJson.put("tipo", "Programar");
        habilidadesJson.add(habilidadeJson);

        usuarioJson.put("habilidades", habilidadesJson);
        usuarioJson.put("nome", "Jefferson");

        mockMvc.perform(post("/usuario/cadastra")
                .contentType(MediaType.APPLICATION_JSON)
                .content(usuarioJson.toString()))
                .andExpect(status().isCreated());

        UsuarioDto consulta = service.consulta(1L);
        assertEquals("Nome deve ser igual", consulta.getNome(), "Jefferson");
        assertEquals("E-mail deve ser igual", consulta.getEmail(), "abc@gmail.com");
    }

    @Test
    public void consulta() throws Exception {
        // Crie um objeto JSON com os dados do usuário
        JSONObject usuarioJson = new JSONObject();
        usuarioJson.put("dtNascimento", "2003-05-21");
        usuarioJson.put("email", "abc@gmail.com");

        JSONObject enderecoJson = new JSONObject();
        enderecoJson.put("bairro", "jardins");
        enderecoJson.put("cep", "12345-123");
        enderecoJson.put("complemento", "lt 10 QD");
        enderecoJson.put("estado", "Rio de Janeiro");
        enderecoJson.put("logradouro", "Rua Carioca");
        enderecoJson.put("numero", 0);
        enderecoJson.put("pais", "Brasil");

        usuarioJson.put("endereco", enderecoJson);

        JSONArray habilidadesJson = new JSONArray();
        JSONObject habilidadeJson = new JSONObject();
        habilidadeJson.put("tipo", "Programar");
        habilidadesJson.add(habilidadeJson);

        usuarioJson.put("habilidades", habilidadesJson);
        usuarioJson.put("nome", "Jefferson");

        mockMvc.perform(post("/usuario/cadastra")
                .contentType(MediaType.APPLICATION_JSON)
                .content(usuarioJson.toString()))
                .andExpect(status().isCreated());

        mockMvc.perform(get("/usuario/busca/1")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
}
