# Desafio Itaú
Criação de uma API Java com Spring para cadastro de usuário com validações.

## Pré-requisitos
- Java 1.8.0_162
- Maven 3.3.9
- Intellij IDEA
- Docker 17.05.0-ce

## Instruções
Para o projeto 'DesafioItau', todos os comandos deverão ser executado via terminal.
Fazer o checkout do projeto via GitHub e na raiz do projeto executar o comando abaixo:

``` mvn clean install ```

Após a execução gerar a imagem docker da aplicação, exemplo comando abaixo:
 
``` docker build -t jeffersonaraujop/ubuntu_java8 . ```

Com o build realizado com sucesso, a aplicação pode ser executada através da linha de comando abaixo via terminal:

``` docker run -it -p 8080:8080 jeffersonaraujo/ubuntu-java8:latest ```

A partir de agora você poderá acessar os serviços pelos endpoints.

## Endpoints
Existe uma documentação dos serviços montada usando swagger que pode ser acessada pelo link, após executar os passos acima, segue abaixo:
> http://localhost:8080/swagger-ui.html

Caso tenha o Postman instalado poderá baixar e importar as chamadas.

Endpoints necessário para consumir os serviços da aplicação:
- Cadastrar usuario
	> **POST** http://localhost:8080/usuario/cadastra
    
    - **REQUEST**
    ```	
        header  {
                    Content-Type:application/json
                }
    ```
    ```
        body    {
                  "dtNascimento": "2005-05-21",
                  "email": "araujo.jeffersonp@gmail.com",
                  "endereco": {
                    "bairro": "Jacarépagua",
                    "cep": "12345-090",
                    "complemento": "lt 00 Qd A",
                    "estado": "Rio de Janeiro",
                    "logradouro": "Rua José",
                    "numero": 0,
                    "pais": "Brasil"
                  },
                  "habilidades": [
                    {
                      "tipo": "Programar"
                    }
                  ],
                  "nome": "Jefferson Araujo"
                }
    
    ```
    
- Buscar Usuario
	> **GET** http://localhost:8080/usuario/busca/{id}

    - **REQUEST**
    ```	
        header  {
                    Content-Type:application/json
                }
    ```
    - **RESPONSE**
       ```
           body    {
                       "id": 1,
                       "nome": "Jefferson Araujo",
                       "email": "araujo.jeffersonp@gmail.com",
                       "dtNascimento": "2005-05-21",
                       "endereco": {
                           "logradouro": "Rua José",
                           "numero": 0,
                           "complemento": "lt 00 Qd A",
                           "cep": "12345-090",
                           "bairro": "Jacarépagua",
                           "estado": "Rio de Janeiro",
                           "pais": "Brasil"
                       },
                       "habilidades": [
                           {
                               "tipo": "Programar"
                           }
                       ]
                   }
       
       ```
       
## Utilizando a Arquitetura Hexagonal 
O projeto está na pasta 'DesafioItauHexa', será possível observar que este projeto foi desenvolvido orientado ao TDD e com foco no requisito de negócio assim sendo um sistema totalmente fechado(caixa preta).  
Este é um sistema que não se importa com qual decisão técnica, infra estrutura ou armazenamento de dados será utilizada ele vai se comportar como um módulo que pode se encaixado e funcionar sem precisar de alterar o seu conteúdo.
