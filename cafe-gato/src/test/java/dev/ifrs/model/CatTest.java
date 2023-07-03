package dev.ifrs.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

/**
 * Testes para a classe Cat, que representa um gato.
 */
public class CatTest {

    @Test
    @Order(1)
    @DisplayName("Teste de criação de gato")
    public void testCatCreation() {
        // Instancia um gato
        Cat cat = new Cat("Mimi", 2, "Fem", "Mainecoon", "Carinhosa e calma", true);

        // Verificação dos atributos do gato instanciado
        Assertions.assertEquals("Mimi", cat.getName());
        Assertions.assertEquals(2, cat.getAge());
        Assertions.assertEquals("Fem", cat.getSex());
        Assertions.assertEquals("Mainecoon", cat.getBreed());
        Assertions.assertEquals("Carinhosa e calma", cat.getBio());
        Assertions.assertTrue(cat.isForAdoption());
    }

    @Test
    public void testCatSetters() {
        // Instancia um gato
        Cat cat = new Cat();

        // Atribui valores aos atributos do gato
        cat.setName("Mimi");
        cat.setAge(2);
        cat.setSex("Fem");
        cat.setBreed("Mainecoon");
        cat.setBio("Carinhosa e calma");
        cat.setForAdoption(true);

        // Verifica os atributos do gato
        Assertions.assertEquals("Mimi", cat.getName());
        Assertions.assertEquals(2, cat.getAge());
        Assertions.assertEquals("Fem", cat.getSex());
        Assertions.assertEquals("Mainecoon", cat.getBreed());
        Assertions.assertEquals("Carinhosa e calma", cat.getBio());
        Assertions.assertTrue(cat.isForAdoption());
    }
}
