package dev.ifrs.webservices;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

/**
 * Essa classe contém testes para a classe CoffeeWS.
 */

@QuarkusTest
public class CoffeeWSTest {

    @Test
    @Order(1)
    @DisplayName("Teste de adição de café")
    void testAddCoffee() {
        given()
            .contentType(ContentType.URLENC)
            .formParam("name", "Espresso")
            .formParam("description", "Forte e concentrado")
            .formParam("price", 2.5)
        .when()
            .post("/coffees/add")
        .then()
            .statusCode(200)
            .body("name", equalTo("Espresso"))
            .body("description", equalTo("Forte e concentrado"))
            .body("price", equalTo(2.5f));
    }

    @Test
    @Order(2)
    @DisplayName("Teste de listagem de cafés")
    public void testGetAllCoffees() {
        given()
        .when()
            .get("/coffees/list")
        .then()
            .statusCode(200)
            .body("size()", greaterThan(0)); //Assumindo que há ao menos um café no banco de dados
    }

    @Test
    @Order(3)
    @DisplayName("Teste de busca de café")
    public void testFindCoffee() {
        // Assumindo que existe um café com ID 1 no banco de dados
        given()
        .when()
            .get("/coffees/find/1")
        .then()
            .statusCode(200)
            .body("id", equalTo(1));
    }

    @Test
    @Order(4)
    @DisplayName("Teste de atualização de café")
    public void testUpdateCoffee() {
        // Assumindo que existe um café com ID 1 no banco de dados
        given()
            .contentType(ContentType.JSON)
            .body("{\"name\":\"Cappuccino\",\"description\":\"Cafe com espuma de leite cremosa\",\"price\":3.0}")
        .when()
            .put("/coffees/update/1")
        .then()
            .statusCode(200)
            .body("name", equalTo("Cappuccino"))
            .body("description", equalTo("Cafe com espuma de leite cremosa"))
            .body("price", equalTo(3.0f));
    }

    @Test
    @Order(5)
    @DisplayName("Teste de remoção de café")
    public void testDeleteCoffee() {
        // Assumindo que existe um café com ID 1 no banco de dados
        given()
        .when()
            .delete("/coffees/delete/1")
        .then()
            .statusCode(200)
            .body("id", equalTo(1));
    }

}

