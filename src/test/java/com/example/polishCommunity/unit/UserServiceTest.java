package com.example.polishCommunity.unit;

import com.example.polishCommunity.model.User;
import com.example.polishCommunity.repository.UserRepository;
import com.example.polishCommunity.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterUser_Success() {
        User user = new User("John", "Doe", "john@example.com", "hashed_password", "User");

        when(userRepository.findByEmail(user.getEmail())).thenReturn(null);
        doNothing().when(userRepository).save(any(User.class));

        userService.registerUser(user.getName(), user.getSurname(), user.getEmail(), "raw_password");

        verify(userRepository, times(1)).save(any(User.class));
    }

}
