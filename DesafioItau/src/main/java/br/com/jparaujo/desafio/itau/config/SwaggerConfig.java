package br.com.jparaujo.desafio.itau.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static com.google.common.collect.Lists.newArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public static final String MESSAGE_FORBIDDEN = "Acesso Negado";
    public static final String MESSAGE_SERVER_ERRO = "Erro Interno no Servidor";

    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES =
            new HashSet<String>(Arrays.asList("application/json"));

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.jparaujo.desafio.itau.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES)
                .globalResponseMessage(RequestMethod.POST,
                        newArrayList(new ResponseMessageBuilder()
                                        .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                                        .message(MESSAGE_SERVER_ERRO)
                                        .responseModel(new ModelRef("Error"))
                                        .build(),
                                new ResponseMessageBuilder()
                                        .code(HttpStatus.FORBIDDEN.value())
                                        .message(MESSAGE_FORBIDDEN)
                                        .build()));

    }

    @Value("${application.name}")
    private String applicationName;

    @Value("${application.description}")
    private String applicationDescription;

    @Value("${build.version}")
    private String buildVersion;

    private ApiInfo apiInfo() {
        return new ApiInfo(
                applicationName,
                applicationDescription,
                buildVersion,
                null,
                    new Contact("Jefferson Araujo",
                            "https://github.com/AraujoJefferson",
                            "araujo.jeffersonp@gmail.com"),
                null, null, Collections.emptyList());
    }
}
