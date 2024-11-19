package com.lina.airline.controller;


import com.lina.airline.dto.request.UserRegistrationRequest;
import com.lina.airline.exception.IdentifierExistException;
import com.lina.airline.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static com.lina.airline.utils.ErrorDetails.USER_ALREADY_EXISTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class UserControllerTest {

    @InjectMocks
    private UserController userController;  // Class under test

    @Mock
    private UserService userService;  // Mocked dependency

    private UserRegistrationRequest userRegistrationRequest;

    @BeforeEach
    void setUp() {
        // Initialize the mocks
        MockitoAnnotations.openMocks(this);

        // Set up a sample request
        userRegistrationRequest = new UserRegistrationRequest();
        userRegistrationRequest.setEmail("test@example.com");
        userRegistrationRequest.setPassword("password123");
        userRegistrationRequest.setName("John Doe");
    }

    @Test
    void testSaveUser_Success() {
        // Arrange
        UUID userId = UUID.randomUUID();
        when(userService.saveUser(any(UserRegistrationRequest.class))).thenReturn(userId);

        // Act
     //   UUID result = userController.registrationUser(userRegistrationRequest);

        // Assert
      //  assertEquals(userId, result, "The returned userId should match the mocked result.");
    }

    @Test
    void testSaveUser_UserAlreadyExists() {
        // Arrange
        when(userService.saveUser(any(UserRegistrationRequest.class)))
                .thenThrow(new IdentifierExistException(USER_ALREADY_EXISTS));

        // Act & Assert
        IdentifierExistException exception = assertThrows(IdentifierExistException.class, () -> {
            userController.registrationUser(userRegistrationRequest);
        });

        assertEquals(USER_ALREADY_EXISTS.getMessage(), exception.getMessage(), "Exception message should match.");
    }
}
