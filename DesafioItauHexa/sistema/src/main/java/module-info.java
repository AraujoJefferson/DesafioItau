module desafio.itau.desafioitau {

    // usa spring
    requires spring.beans;
    requires spring.context; // CDI
    requires spring.tx; // Transação

    //expor porta de entrada(driver)
    exports desafio.itau.sistema.casouso.porta;
    exports desafio.itau.sistema.casouso.imp;

    // expor sistema negocio
    exports desafio.itau.sistema.dominio.modelo;
    exports desafio.itau.sistema.dominio.servico;

    //expor adaptadores de saída(driven)
    exports desafio.itau.sistema.porta;
    exports desafio.itau.adaptador;

    //executa reflexion
    opens desafio.itau.sistema.casouso.porta;
    opens desafio.itau.sistema.casouso.imp;
    opens desafio.itau.sistema.dominio.servico;
    opens desafio.itau.adaptador;
}