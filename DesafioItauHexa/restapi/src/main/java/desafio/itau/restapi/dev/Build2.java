package desafio.itau.restapi.dev;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages  = {
        "desafio.itau.restapi.dev",
        "desafio.itau.restapi.run",
        "desafio.itau.restapi.endpoint",
        //objetos de sistema
        "desafio.itau.sistema",
        //adaptadores falsos
        "desafio.itau.adaptador"})
public class Build2 {
}
