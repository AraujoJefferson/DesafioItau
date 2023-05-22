module desafio.itau.restapi {
    requires desafio.itau.desafioitau;

    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.beans;
    requires spring.core;
    requires spring.context;
    requires spring.tx;
    requires java.sql;

    requires spring.web;

    opens desafio.itau.restapi.dev;
    opens desafio.itau.restapi.run;
    opens desafio.itau.restapi.endpoint;

    requires desafio.itau.servico;
    requires spring.jdbc;
    requires hsqldb;

}
