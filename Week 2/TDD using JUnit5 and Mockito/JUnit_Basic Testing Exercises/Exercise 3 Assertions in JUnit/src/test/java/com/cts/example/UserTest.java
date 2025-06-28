
package com.cts.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    void testUserEquality() {
        User user1 = new User("Alice", 25);
        User user2 = new User("Alice", 25);
        assertEquals(user1, user2, "Users with same name and age should be equal");
    }

    @Test
    void testUserNotNull() {
        User user = new User("Bob", 30);
        assertNotNull(user, "User should not be null");
    }

    @Test
    void testUserName() {
        User user = new User("Charlie", 28);
        assertEquals("Charlie", user.getName(), "User name should be Charlie");
    }

    @Test
    void testUserAge() {
        User user = new User("David", 40);
        assertTrue(user.getAge() > 18, "User should be an adult");
    }

    @Test
    void testUserNameIsNotEmpty() {
        User user = new User("Eve", 35);
        assertFalse(user.getName().isEmpty(), "User name should not be empty");
    }
}
