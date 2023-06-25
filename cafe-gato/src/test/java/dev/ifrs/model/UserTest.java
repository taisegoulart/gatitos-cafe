package dev.ifrs.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {
 @Test
    public void testCreateUser() {
        // Create a new User instance
        User user = new User("John Doe", "johndoe", "john@example.com", "1234567890", "password123", false);

        // Verify the attributes
        Assertions.assertEquals("John Doe", user.getName());
        Assertions.assertEquals("johndoe", user.getLogin());
        Assertions.assertEquals("john@example.com", user.getEmail());
        Assertions.assertEquals("1234567890", user.getPhone());
        Assertions.assertEquals("password123", user.getPassword());
        Assertions.assertFalse(user.isAdmin());
    }

    @Test
    public void testSettersAndGetters() {
        // Create a new User instance
        User user = new User();

        // Set the attributes
        user.setName("Jane Smith");
        user.setLogin("janesmith");
        user.setEmail("jane@example.com");
        user.setPhone("9876543210");
        user.setPassword("password456");
        user.setAdmin(true);

        // Verify the attributes using getters
        Assertions.assertEquals("Jane Smith", user.getName());
        Assertions.assertEquals("janesmith", user.getLogin());
        Assertions.assertEquals("jane@example.com", user.getEmail());
        Assertions.assertEquals("9876543210", user.getPhone());
        Assertions.assertEquals("password456", user.getPassword());
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
