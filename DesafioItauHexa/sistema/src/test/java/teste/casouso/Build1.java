package teste.casouso;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages  = {
        "desafio.itau.sistema",
        "desafio.itau.adaptador"
})
public class Build1 {
    // Build 1: Adaptadora Teste -> Sistema <- Adaptadores Mock
}
