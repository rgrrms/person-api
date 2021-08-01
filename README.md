# PERSON API

Api simples em JAVA com Spring desenvolvida com os conceitos aprendidos nas aulas da DIO, utilizando:

* Gradle
* Swagger
* Hibernate
* Lombok
* ModelMapper
* Validation
* Mysql
...

Para rodar a aplicação é necessario ter instalado:

* Java 11
* Gradle 7.1.1 ou superior
* Mysql

Para o banco utilizei o MySQL Workbench, instalando no linux com o seguinte comando:

`$ sudo apt install mysql-workbench`

E criando a base e a tabela:

```roomsql
CREATE database digital_innovation_one;

CREATE TABLE person (
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nome VARCHAR(80) NOT NULL,
    idade INTEGER NOT NULL,
    estado CHARACTER(2) NOT NULL
);
```

Então será possível rodar a aplicação no terminal usando o comando:
 
`$ gradle bootRun`

A aplicação vai subir na porta 8080,
Após pode acessar o link abaixo para verificar se a API está Up com o Actuator

[Actuator](http://localhost:8080/person-api/v1/actuator/health) (http://localhost:8080/person-api/v1/actuator/health)

Deve retornar
`{
"status": "UP"
}`

### SWAGGER

Com o swagger temos a documentação dos  endpoints podendo executar no proprio link abaixo

[Swagger](http://localhost:8080/person-api/v1/swagger-ui.html#/DIO) (http://localhost:8080/person-api/v1/swagger-ui.html#/DIO)

![](https://github.com/rgrrms/TrabalhoA5_DSW_Front/raw/master/src/main/java/one/digitalinnovation/personapi/image/swagger.png)

Ou se preferir pode utilizar o [Insomnia](https://insomnia.rest/) ou [Postman](https://www.postman.com/) para testar os enpoints

### ENDPOINTS

1. Buscar todas as pessoas:

`GET http://localhost:8080/person-api/v1/person/`

Retorna:
```json
[
  {
    "id": 1,
    "name": "Nome Sobrenome",
    "age": 20,
    "state": "RS"
  }
]
```

2. Buscar uma pessoa por ID:

`GET http://localhost:8080/person-api/v1/person/1`

Retorna:
```json
{
  "id": 1,
  "name": "Nome Sobrenome",
  "age": 20,
  "state": "RS"
}
```

3. Criar uma pessoa:

`POST http://localhost:8080/person-api/v1/person`

```json
{
  "age": 19,
  "name": "TESTE TESTE",
  "state": "RS"
}
```

Retorna:
```json
{
  "id": 1
}
```

4. Alterar uma pessoa por Id:

`PUT http://localhost:8080/person-api/v1/person/1`

```json
{
  "id": 1,
  "age": 20,
  "name": "Teste Teste",
  "state": "RS"
}
```

Retorna:
```json
{
  "id": 1
}
```

5. Excluir uma pessoa por Id:

`DELETE http://localhost:8080/person-api/v1/person/1`