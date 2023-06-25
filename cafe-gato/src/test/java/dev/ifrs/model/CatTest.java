package dev.ifrs.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CatTest {

    @Test
    public void testCatCreation() {
        // Create a cat
        Cat cat = new Cat("Whiskers", 2, "Female", "Siamese", "Friendly and playful", true);

        // Verify the cat's attributes
        Assertions.assertEquals("Whiskers", cat.getName());
        Assertions.assertEquals(2, cat.getAge());
        Assertions.assertEquals("Female", cat.getSex());
        Assertions.assertEquals("Siamese", cat.getBreed());
        Assertions.assertEquals("Friendly and playful", cat.getBio());
        Assertions.assertTrue(cat.isForAdoption());
    }

    @Test
    public void testCatSetters() {
        // Create a cat
        Cat cat = new Cat();

        // Set the cat's attributes
        cat.setName("Whiskers");
        cat.setAge(2);
        cat.setSex("Female");
        cat.setBreed("Siamese");
        cat.setBio("Friendly and playful");
        cat.setForAdoption(true);

        // Verify the cat's attributes
        Assertions.assertEquals("Whiskers", cat.getName());
        Assertions.assertEquals(2, cat.getAge());
        Assertions.assertEquals("Female", cat.getSex());
        Assertions.assertEquals("Siamese", cat.getBreed());
        Assertions.assertEquals("Friendly and playful", cat.getBio());
        Assertions.assertTrue(cat.isForAdoption());
    }
}
