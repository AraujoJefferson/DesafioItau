package desafio.itau.sistema.dominio.modelo;

import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    public static final long MAIOR_IDADE = 18L;

    public static boolean contemSimbolos(String nome) {
        String padrao = "[a-zA-Z\\s\\u00C0-\\u00FF]+";
        Pattern pattern = Pattern.compile(padrao);
        Matcher matcher = pattern.matcher(nome);

        return !matcher.matches();
    }

    public static boolean complementoInvalido(String nome) {
        String padrao = "[0-9a-zA-Z\\s\\u00C0-\\u00FF]+";
        Pattern pattern = Pattern.compile(padrao);
        Matcher matcher = pattern.matcher(nome);

        return !matcher.matches();
    }

    public static boolean emailInvalido(String email) {
        String padrao = "[a-zA-Z0-9._%+-]+@(gmail|hotmail|outlook|yahoo)\\.(com|br|net)";
        Pattern pattern = Pattern.compile(padrao);
        Matcher matcher = pattern.matcher(email);

        return !matcher.matches();
    }

    public static boolean verificarMaiorIdade(LocalDate dataNascimento) {
        LocalDate maioridade = LocalDate.now();
        maioridade = maioridade.minusYears(MAIOR_IDADE);

        return dataNascimento.isAfter(maioridade);
    }

    public static boolean cepInvalido(String cep) {
        String padrao = "[0-9]{5}-[0-9]{3}";
        Pattern pattern = Pattern.compile(padrao);
        Matcher matcher = pattern.matcher(cep);

        return !matcher.matches();
    }
}
