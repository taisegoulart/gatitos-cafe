package dev.ifrs.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoffeeTest {
    @Test
    public void testCreateCoffee() {
        // Create a new Coffee instance
        Coffee coffee = new Coffee("Espresso", "Bold and rich flavor", 2.99);

        // Verify the attributes
        Assertions.assertEquals("Espresso", coffee.getName());
        Assertions.assertEquals("Bold and rich flavor", coffee.getDescription());
        Assertions.assertEquals(2.99, coffee.getPrice(), 0.01);
    }

    @Test
    public void testSettersAndGetters() {
        // Create a new Coffee instance
        Coffee coffee = new Coffee();

        // Set the attributes
        coffee.setName("Cappuccino");
        coffee.setDescription("Creamy and frothy");
        coffee.setPrice(3.49);

        // Verify the attributes using getters
        Assertions.assertEquals("Cappuccino", coffee.getName());
        Assertions.assertEquals("Creamy and frothy", coffee.getDescription());
        Assertions.assertEquals(3.49, coffee.getPrice(), 0.01);
    }

    @Test
    public void testEqualsAndHashCode() {
        // Create two identical Coffee instances
        Coffee coffee1 = new Coffee("Latte", "Smooth and creamy", 3.99);
        Coffee coffee2 = new Coffee("Latte", "Smooth and creamy", 3.99);

        // Verify the equality using equals method
        Assertions.assertEquals(coffee1, coffee2);

        // Verify the equality using hashCode method
        Assertions.assertEquals(coffee1.hashCode(), coffee2.hashCode());
    }
    
}
