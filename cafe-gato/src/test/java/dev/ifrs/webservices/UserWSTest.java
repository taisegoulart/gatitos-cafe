package dev.ifrs.webservices;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

/**
 * Essa classe contém testes para a classe UserWS.
 */
@QuarkusTest
public class UserWSTest {

    @Test
    @Order(1)
    @DisplayName("Teste de adição de usuário")
    void testAddUser() {
        given()
                .contentType(ContentType.URLENC)
                .formParam("name", "Felicia Felix")
                .formParam("email", "feliciafelix@mail.com")
                .formParam("password", "senha123")
                .formParam("phone", "1234567890")
                .formParam("login", "feliciafelix")
                .formParam("isAdmin", false)
                .when()
                .post("/user/add")
                .then()
                .statusCode(200)
                .body("name", equalTo("Felicia Felix"))
                .body("email", equalTo("feliciafelix@mail.com"))
                .body("phone", equalTo("1234567890"))
                .body("login", equalTo("feliciafelix"))
                .body("admin", equalTo(false));
    }

    @Test
    @Order(2)
    @DisplayName("Teste de listar todos os usuários")
    void testListAllUsers() {
        given()
                .when()
                .get("/user/list")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    @Order(3)
    @DisplayName("Teste de busca de usuários por login")
    void testFindUserByLogin() {
        // Assumnindo que há um usuário com o login no banco de dados
        given()
                .contentType(ContentType.URLENC)
                .formParam("login", "sabrinaspellman")
                .when()
                .post("/user/findbylogin")
                .then()
                .statusCode(200)
                .body("login", equalTo("sabrinaspellman"));
    }

    @Test
    @Order(4)
    @DisplayName("Teste de edição de usuários")
    public void testUpdateUser() {
        // Assumindo que existe um usuário com ID 1 no banco de dados
        given()
                .contentType(ContentType.URLENC)
                .formParam("name", "Sabrina Spellman")
                .formParam("email", "sabrinaspellman@mail.com")
                .formParam("phone", "9876543210")
                .formParam("login", "sabrinaspellman")
                .formParam("isAdmin", true)
                .when()
                .put("/user/update/1")
                .then()
                .statusCode(200)
                .body("name", equalTo("Sabrina Spellman"))
                .body("email", equalTo("sabrinaspellman@mail.com"))
                .body("phone", equalTo("9876543210"))
                .body("login", equalTo("sabrinaspellman"))
                .body("admin", equalTo(true));
    }

    @Test
    @Order(5)
    @DisplayName("Teste de busca de usuários")
    void testFindUser() {
        // Assumindo que existe um usuário com ID 1 no banco de dados
        given()
                .when()
                .get("/user/find/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1));
    }

    @Test
    @Order(6)
    @DisplayName("Teste de remoção de usuários")
    void testDeleteUser() {
        // Assumindo que existe um usuário com ID 1 no banco de dados
        given()
                .when()
                .delete("/user/delete/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1));
    }

}
