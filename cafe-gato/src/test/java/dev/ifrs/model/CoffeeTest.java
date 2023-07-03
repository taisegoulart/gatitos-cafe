package dev.ifrs.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

/**
 * Testes para a classe Coffee, que representa um café.
 */
public class CoffeeTest {
    @Test
    @Order(1)
    @DisplayName("Teste de criação de café")
    void testCreateCoffee() {
        // Instancia um café
        Coffee coffee = new Coffee("Espresso", "Sabor concentrado e aroma forte", 2.99);

        // Verificação dos atributos
        Assertions.assertEquals("Espresso", coffee.getName());
        Assertions.assertEquals("Sabor concentrado e aroma forte", coffee.getDescription());
        Assertions.assertEquals(2.99, coffee.getPrice(), 0.01);
    }

    @Test
    @Order(2)
    @DisplayName("Teste de criação de café sem parâmetros")
    public void testSettersAndGetters() {
        // Instancia um café
        Coffee coffee = new Coffee();

        // Atribui valores aos atributos
        coffee.setName("Cappuccino");
        coffee.setDescription("Cremoso e com sabor marcante de chocolate");
        coffee.setPrice(3.49);

        // Verificação dos atributos usando getters
        Assertions.assertEquals("Cappuccino", coffee.getName());
        Assertions.assertEquals("Cremoso e com sabor marcante de chocolate", coffee.getDescription());
        Assertions.assertEquals(3.49, coffee.getPrice(), 0.01);
    }

    @Test
    @Order(3)
    @DisplayName("Teste de igualdade entre cafés")
    public void testEqualsAndHashCode() {
        // Criação de dois cafés com os mesmos atributos
        Coffee coffee1 = new Coffee("Latte", "Suave e cremoso", 3.99);
        Coffee coffee2 = new Coffee("Latte", "Suave e cremoso", 3.99);

        // Verifica a igualdade usando o método equals
        Assertions.assertEquals(coffee1, coffee2);

        // Verifica a igualdade usando o método hashCode
        Assertions.assertEquals(coffee1.hashCode(), coffee2.hashCode());
    }
    
}
