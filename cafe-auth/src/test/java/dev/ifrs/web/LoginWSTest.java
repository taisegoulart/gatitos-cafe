package dev.ifrs.web;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class LoginWSTest {
 /*   @Test
    @Order(1)
    @DisplayName("Teste de geração de token")
    public void testGenerateToken_ValidCredentials() {
        given()
                .contentType(ContentType.URLENC)
                .formParam("login", "proferodrigo")
                .formParam("senha", "senharodrigo123")
                .when()
                .post("/login")
                .then()
                .statusCode(200)
                .body(not(blankOrNullString()));
    }

    @Test
    @Order(2)
    @DisplayName("Teste de geração de token com credenciais inválidas")
    public void testGenerateToken_InvalidCredentials() {
        given()
                .contentType(ContentType.URLENC)
                .formParam("login", "johndoe")
                .formParam("senha", "wrongpassword")
                .when()
                .post("/login")
                .then()
                .statusCode(500); // Esse teste deve falhar (status 500), pois o usuário não existe no banco de
                                  // dados uma vez que o usuário é adicionado no outro servidor (cafe-gato)
    }*/ 
}
