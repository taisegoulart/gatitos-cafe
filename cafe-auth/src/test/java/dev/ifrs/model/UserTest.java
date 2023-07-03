package dev.ifrs.model;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;


@QuarkusTest
/**
 * Testes para a classe User, para o serviço de autenticação.
 */
public class UserTest {
 /*   @Test
    @Order(1)
    @DisplayName("Teste de getters e setters")
     void testGettersAndSetters() {
        User user = new User();
        user.setName("Taise Goulart");
        user.setLogin("taisegoulart");
        user.setPassword("senhadataise");
        user.setAdmin(true);

        assertEquals("Taise Goulart", user.getName());
        assertEquals("taisegoulart", user.getLogin());
        assertEquals("senhadataise1", user.getPassword());
        assertEquals(true, user.isAdmin());
    }

    @Test
    @Order(2)
    @DisplayName("Teste de construtor")
     void testEqualsAndHashCode() {
        User user1 = new User("Taise Goulart", "taisegoulart", "senhadataise1", true);
        User user2 = new User("Taise Goulart", "taisegoulart", "senhadataise1", true);
        User user3 = new User("Rodrigo Prestes", "proferodrigo", "rodrigo123", false);

        assertEquals(user1, user2, "Os usuários devem ser iguais");
        assertEquals(user1.hashCode(), user2.hashCode(), "Os códigos hash devem ser iguais");

        assertEquals(user1, user1, "O usuário deve ser igual a ele mesmo");
        assertEquals(user1.hashCode(), user1.hashCode(), "O código hash do usuário deve ser igual ao código hash dele mesmo");

        assertEquals(user2, user1, "Os usuários devem ser iguais");
        assertEquals(user2.hashCode(), user1.hashCode(), "Os códigos hash devem ser iguais");

        assertEquals( false, user1.equals(user3), "Os usuários não devem ser iguais");
        assertEquals( false, user1.hashCode() == user3.hashCode(), "Os códigos hash não devem ser iguais");
    }
*/
}