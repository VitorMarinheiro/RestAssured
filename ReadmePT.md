# RestAssured

Esse projeto utiliza a API pública [The Cat API - Cats as a Service
](https://thecatapi.com/) para demonstrar como pode ser feita a utilização da biblioteca RestAssured em conjunto com outras Tecnologias como Maven, JUnit e AWS.

## Tecnologias
- :hotsprings:	[Java](https://www.java.com/)
- :video_game:	[REST-assured](https://rest-assured.io/)
- :space_invader:	[JUnit](https://junit.org/junit5/)
- :gift:	[Maven](https://maven.apache.org/)
- :lock:	[AWS Parameter Store](https://docs.aws.amazon.com/pt_br/systems-manager/latest/userguide/systems-manager-parameter-store.html)

## Configuração
Para utilização da The Cat API é necessário que tenhamos a chave de api. Precisamos [criar uma conta](https://thecatapi.com/signup), após isso um e-mail será enviado contendo a chave de api.

O projeto está utilizando o serviço AWS Parameter Store para gerenciar de forma segura a nossa chave de api.

 ###### AWS Parameter Store

Caso queira **utilizar o AWS Parameter Store** será necessário apenas configurar sua conta da AWS diretamente na máquina utilizada e criar um Parâmetro do tipo *SecureString* com o nome de *CatAPI_Token* e contendo o valor da sua chave de api da CatAPI.

Se o objetivo for **não fazer uso do AWS Parameter** Store basta acessar o arquivo **_src/main/java/header/HeaderCreator.java_** e seguir as instruções que estão apresentadas.


## Executando os Testes
Para execução de todos os testes contidos dentro do projeto é necessário apenas executar o comando de testes via maven:
```
mvn test
```

Caso o objetivo seja executar apenas alguma classe de testes específica, pode-se utilizar o parâmetro ```-Dtest``` para seleção da classe:
```
mvn test -Dtest=VotesTest
```

## Gerando o Allure Report
Os arquivos necessários para a geração do Allure report estão sendo salvos no caminho **target/allure-results**, essa configuração está definida dentro do arquivo *.properties* do Allure que está localizado em **_src/test/resources/allure.properties_** dentro do projeto.
```
allure.results.directory=target/allure-results
```

Após a execução dos testes automatizados, é preciso apenas executar o comando abaixo para que o report seja criado e aberto automaticamente utilizando o seu navegador padrão:
```
allure serve target/allure-results
```
