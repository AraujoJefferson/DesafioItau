package desafio.itau.restapi.run;

import desafio.itau.restapi.dev.Build2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestApiAplication {
    public static void main(String... args) {
        SpringApplication.run(Build2.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(){
        return args -> {
            System.out.println("=======================");
            System.out.println("=========FOI===========");
            System.out.println("=======================");
        };
    }
}
