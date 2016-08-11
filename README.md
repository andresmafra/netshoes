# Netshoes Test

Códigos desenvolvidos para o teste da Netshoes. Os módulos:

  - CepService
  - CrudService
  - JStream

Instruções específicas:
## CepService
Efetuar o build com o Maven (clean install), deployar no servidor de preferência (eg. Tomcat) e após isso executá-lo conforme abaixo:

```sh
curl -H "Accept: application/json" -H "Content-Type: application/json"  -X POST -d '{"id":"06753160"}' http://host:port/cepservice/api/
```

## CrudService
Efetuar o build com o Maven (clean install), deployar no servidor de preferência (eg. Tomcat) e após isso executá-lo conforme exemplos abaixo:

#### Create

```sh
curl -H "Accept: application/json" -H "Content-Type: application/json"  -X POST -d '{"rua":"Rua 2","numero":"02","cep":"06753161","cidade":"Abc","estado":"RJ"}' http://host:port/crudservice/api/
```
#### Update

```sh
curl -H "Accept: application/json" -H "Content-Type: application/json"  -X PUT -d '{"id":"1f743aa3-1df3-4a79-8666-7e820fb4a3c6","rua":"Rua 20","numero":"02","cep":"06753163","bairro":null,"cidade":"aaaaa","estado":"BA","complemento":null}' http://host:port/crudservice/api/
```

#### Get

```sh
curl -H "Accept: application/json" -H "Content-Type: application/json"  -X GET http://host:port/crudservice/api/id
```

#### Delete

```sh
curl -H "Accept: application/json" -H "Content-Type: application/json"  -X DELETE http://host:port/crudservice/api/id
```

## JStream
### Instalação
Para instalar basta executar o comando abaixo com o Maven na pasta do projeto:
```sh
cd project/folder
mvn clean install
```

### Execução

Após o build do Maven, para executar basta executar o comando abaixo na pasta do target gerado:
```sh
java -jar jstream-1.0.0-SNAPSHOT.jar CHAR_SEQUENCE
```
onde CHAR_SEQUENCE será substituído pela lista de chars, exemplo:
```sh
java -jar jstream-1.0.0-SNAPSHOT.jar aaAAbbBB
```


## Misc

Acelerado por:

* [Postman] - Supercharge your API workflow
* [Maven] - Simplify the build processes

License
----
GNU PUBLIC LICENSE

**André Mafra**

[Postman]:https://www.getpostman.com/
[Maven]:https://maven.apache.org/
