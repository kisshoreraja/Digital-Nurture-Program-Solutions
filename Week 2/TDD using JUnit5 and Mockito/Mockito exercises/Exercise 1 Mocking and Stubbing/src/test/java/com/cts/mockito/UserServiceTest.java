package com.cts.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserServiceTest {

    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        userService = new UserService(userRepository);
    }

    @Test
    void testUserFound() {
        // Arrange
        String userId = "u123";
        when(userRepository.findUserById(userId)).thenReturn(Optional.of("Kishore"));

        // Act
        String result = userService.getUserGreeting(userId);

        // Assert
        assertEquals("Hello, Kishore!", result);
    }

    @Test
    void testUserNotFound() {
        // Arrange
        String userId = "u999";
        when(userRepository.findUserById(userId)).thenReturn(Optional.empty());

        // Act
        String result = userService.getUserGreeting(userId);

        // Assert
        assertEquals("User not found", result);
    }
}
