package dev.ifrs.webservices;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
/**
 * Essa classe contém testes para a classe CatWS.
 */

@QuarkusTest
public class CatWSTest {
    @Test
    @Order(1)
    @DisplayName("Teste de adição de gato")
    void testAddCat() {
        given()
            .contentType(ContentType.URLENC)
            .formParam("name", "Garfield")
            .formParam("age", 5)
            .formParam("sex", "Macho")
            .formParam("breed", "Persa")
            .formParam("bio", "Ama lasanha e odeia segundas-feiras")
            .formParam("forAdoption", true)
        .when()
            .post("/cats/add")
        .then()
            .statusCode(200)
            .body("name", equalTo("Garfield"))
            .body("age", equalTo(5))
            .body("sex", equalTo("Macho"))
            .body("breed", equalTo("Persa"))
            .body("bio", equalTo("Ama lasanha e odeia segundas-feiras"))
            .body("forAdoption", equalTo(true));
    }

    @Test
    @Order(2)
    @DisplayName("Teste de listagem de gatos")
    void testListAllCats() {
        given()
        .when()
            .get("/cats/list")
        .then()
            .statusCode(200)
            .body("size()", greaterThan(0)); //Assumindo que existe ao menos um gato no banco de dados
    }

    @Test
    @Order(3)
    @DisplayName("Teste de busca de gato")
    void testFindCat() {
        // Assumindo que existe um gato com ID 1 no banco de dados
        given()
        .when()
            .get("/cats/find/1")
        .then()
            .statusCode(200)
            .body("id", equalTo(1));
    }

    @Test
    @Order(4)
    @DisplayName("Teste de edição de gato")
    void testEditCat() {
        //Assumindo que existe um gato com ID 1 no banco de dados
        given()
            .contentType(ContentType.URLENC)
            .formParam("id", 1)
            .formParam("name", "Tom")
            .formParam("age", 3)
            .formParam("sex", "Macho")
            .formParam("breed", "SRD")
            .formParam("bio", "Ainda vai capturar o Jerry")
            .formParam("forAdoption", true)
        .when()
            .put("/cats/edit/1")
        .then()
            .statusCode(200)
            .body("name", equalTo("Tom"))
            .body("age", equalTo(3))
            .body("sex", equalTo("Macho"))
            .body("breed", equalTo("MSDR"))
            .body("bio", equalTo("Ainda vai capturar o Jerry"))
            .body("forAdoption", equalTo(true));
    }

    @Test
    @Order(5)
    @DisplayName("Teste de remoção de gato")
    void testDeleteCat() {
        //Assumindo que existe um gato com ID 1 no banco de dados
        given()
        .when()
            .delete("/cats/delete/1")
        .then()
            .statusCode(200)
            .body("id", equalTo(1));
    }
}
