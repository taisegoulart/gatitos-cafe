package dev.ifrs.client;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest

/**
 * Essa classe contém testespara a classe UserClient.
 */
public class UserClientTest {
/*
    //Teste para encontrar um usuário pelo login com credenciais válidas.
    @Test
    @Order(1)
    @DisplayName("Teste de findByLogin")
    void testFindByLogin_ValidCredentials() {
        given()
            .contentType(ContentType.URLENC)
            .formParam("login", "taisegoulart")
            .formParam("senha", "senhadataise1")
        .when()
            .post("/user/findbylogin")
        .then()
            .statusCode(500) //Esse teste deve falhar (status 500), pois o usuário não existe no banco de dados uma vez que o usuário é adicionado no outro servidor (cafe-gato)
            .body("login", equalTo("johndoe"));
    }

    //Teste para encontrar um usuário pelo login com credenciais inválidas.
    @Test
    @Order(2)
    @DisplayName("Teste de findByLogin com login inválido")
    void testFindByLogin_InvalidCredentials() {
        given()
            .contentType(ContentType.URLENC)
            .formParam("login", "taisegoulart")
            .formParam("senha", "senhaerrada")
        .when()
            .post("/user/findbylogin")
        .then()
            .statusCode(404);
    }  */

}

