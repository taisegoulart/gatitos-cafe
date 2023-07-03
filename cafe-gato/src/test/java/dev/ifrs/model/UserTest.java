package dev.ifrs.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

/**
 * Testes para a classe User, que representa um usuário.
 */
public class UserTest {
 @Test
 @Order(1)
 @DisplayName("Teste de criação de usuário")
 void testCreateUser() {
        // Instancia um usuário
        User user = new User("Felicia Felix", "feliciafelix", "feliciafelix@email.com", "1234567890", "senha123", false);

        // Verificação dos atributos do usuário
        Assertions.assertEquals("Felicia Felix", user.getName());
        Assertions.assertEquals("feliciafelix", user.getLogin());
        Assertions.assertEquals("feliciafelix@email.com", user.getEmail());
        Assertions.assertEquals("1234567890", user.getPhone());
        Assertions.assertEquals("senha123", user.getPassword());
        Assertions.assertFalse(user.isAdmin());
    }

    @Test
    @Order(2)
    @DisplayName("Teste de getters e setters")
    void testSettersAndGetters() {
        // Instancia um usuário
        User user = new User();

        // Atribui valores aos atributos do usuário
        user.setName("Sabrina Spellman");
        user.setLogin("sabrinaspellman");
        user.setEmail("sabrinaspellman@email.com");
        user.setPhone("9876543210");
        user.setPassword("senha456");
        user.setAdmin(true);

        // Verifica os atributos do usuário
        Assertions.assertEquals("Sabrina Spellman", user.getName());
        Assertions.assertEquals("sabrinaspellman", user.getLogin());
        Assertions.assertEquals("sabrinaspellman@email.com", user.getEmail());
        Assertions.assertEquals("9876543210", user.getPhone());
        Assertions.assertEquals("senha456", user.getPassword());
        Assertions.assertTrue(user.isAdmin());
    }

    @Test
    public void testEqualsAndHashCode() {
        // Create two identical User instances
        User user1 = new User("John Doe", "johndoe", "john@example.com", "1234567890", "password123", false);
        User user2 = new User("John Doe", "johndoe", "john@example.com", "1234567890", "password123", false);

        // Verify the equality using equals method
        Assertions.assertEquals(user1, user2);

        // Verify the equality using hashCode method
        Assertions.assertEquals(user1.hashCode(), user2.hashCode());
    }
}
