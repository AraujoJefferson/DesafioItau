/**
 *
 */
module desafio.itau.servico {

    requires desafio.itau.desafioitau;

    requires spring.beans;
    requires spring.context;
    requires spring.tx;
    requires spring.core;
    requires java.sql;
    requires spring.jdbc;
    requires java.persistence;
    requires spring.data.jpa;

    opens desafio.itau.repositorio;
}