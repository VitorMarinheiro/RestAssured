# RestAssured

- :beginner: If you want to read this article in Portuguese, click [here](ReadmePT.md).

- :us: Caso você queira ler esse artigo em Português, clique [aqui](README.md).

This project uses the public [The Cat API - Cats as a Service
](https://thecatapi.com/) to demonstrate how the RestAssured library can be used together with other Technologies such as Maven, JUnit and AWS.

## Technologies
- :hotsprings:	[Java](https://www.java.com/)
- :video_game:	[REST-assured](https://rest-assured.io/)
- :space_invader:	[JUnit](https://junit.org/junit5/)
- :gift:	[Maven](https://maven.apache.org/)
- :lock:	[AWS Parameter Store](https://docs.aws.amazon.com/pt_br/systems-manager/latest/userguide/systems-manager-parameter-store.html)


## Configuration
To use The Cat API it is necessary that we have the api key. We need to [create an account](https://thecatapi.com/signup) and after that an email will be sent containing the api key.

This project is using the AWS Parameter Store service to securely manage our api key.

 ###### AWS Parameter Store

If you want to **use the AWS Parameter Store** you will only need to configure your AWS account directly on the machine used and create a Parameter of type *SecureString* with the name of *CatAPI_Token* and containing the value of your CatAPI api key .

If the goal is **not to use the AWS Parameter** Store, just access the **_src/main/java/header/HeaderCreator.java_** file and follow the instructions that are presented.

## Running the Tests
To run all the tests contained within the project, it is only necessary to run the maven test command:
```
mvn test
```

If the goal is to run just a specific test class, you can use the ```-Dtest``` parameter to select the class:
```
mvn test -Dtest=VotesTest
```

## Generating the Allure Report
The files needed to generate the Allure report are being saved in the path **target/allure-results**, this setting is defined inside the Allure *.properties* file which is located in **_src/test/resources/allure .properties_** within the project.
```
allure.results.directory=target/allure-results
```

After running the automated tests, you only need to run the command below for the report to be created and opened automatically using your default browser:
```
allure serve target/allure-results
```
