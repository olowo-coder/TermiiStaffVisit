package com.example.termiistaffvisitor.service.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.termiistaffvisitor.dto.UserDto;
import com.example.termiistaffvisitor.model.User;
import com.example.termiistaffvisitor.repository.UserRepository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    void testRegister() {
        User user = new User();
        user.setPassword("password");
        user.setUser_id(1L);
        user.setUsername("johnmary");
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByUsername((String) any())).thenReturn(ofResult);
        UserDto userDto = mock(UserDto.class);
        when(userDto.getUsername()).thenReturn("johnmary");
        UserDto actualRegisterResult = this.userServiceImpl.register(userDto);
        assertEquals("Username already registered", actualRegisterResult.getMessage());
        assertNull(actualRegisterResult.getUsername());
        assertNull(actualRegisterResult.getPassword());
        verify(this.userRepository).findByUsername(any());
        verify(userDto).getUsername();
    }

    @Test
    void testRegister2() {
        User user = new User();
        user.setPassword("password");
        user.setUser_id(1L);
        user.setUsername("johnmary");
        when(this.userRepository.save(any())).thenReturn(user);
        when(this.userRepository.findByUsername(any())).thenReturn(Optional.empty());
        UserDto userDto = mock(UserDto.class);
        when(userDto.getPassword()).thenReturn("password");
        when(userDto.getUsername()).thenReturn("johnmary");
        UserDto actualRegisterResult = this.userServiceImpl.register(userDto);
        assertEquals("Registered successfully", actualRegisterResult.getMessage());
        assertNull(actualRegisterResult.getUsername());
        assertNull(actualRegisterResult.getPassword());
        verify(this.userRepository).findByUsername(any());
        verify(this.userRepository).save(any());
        verify(userDto).getPassword();
        verify(userDto, atLeast(1)).getUsername();
    }

    @Test
    void testLogin() {
        User user = new User();
        user.setPassword("password");
        user.setUser_id(1L);
        user.setUsername("johnmary");
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByUsername((String) any())).thenReturn(ofResult);
        UserDto userDto = mock(UserDto.class);
        when(userDto.getPassword()).thenReturn("password");
        when(userDto.getUsername()).thenReturn("johnmary");
        UserDto actualLoginResult = this.userServiceImpl.login(userDto);
        assertEquals("Successfully Login", actualLoginResult.getMessage());
        assertNull(actualLoginResult.getUsername());
        assertNull(actualLoginResult.getPassword());
        verify(this.userRepository).findByUsername((String) any());
        verify(userDto).getPassword();
        verify(userDto).getUsername();
    }

    @Test
    void testLogin2() {
        User user = new User();
        user.setPassword("Successfully Login");
        user.setUser_id(1L);
        user.setUsername("johnmary");
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findByUsername((String) any())).thenReturn(ofResult);
        UserDto userDto = mock(UserDto.class);
        when(userDto.getPassword()).thenReturn("password");
        when(userDto.getUsername()).thenReturn("johnmary");
        UserDto actualLoginResult = this.userServiceImpl.login(userDto);
        assertEquals("Incorrect password", actualLoginResult.getMessage());
        assertNull(actualLoginResult.getUsername());
        assertNull(actualLoginResult.getPassword());
        verify(this.userRepository).findByUsername((String) any());
        verify(userDto).getPassword();
        verify(userDto).getUsername();
    }

    @Test
    void testLogin3() {
        when(this.userRepository.findByUsername((String) any())).thenReturn(Optional.empty());
        UserDto userDto = mock(UserDto.class);
        when(userDto.getPassword()).thenReturn("password");
        when(userDto.getUsername()).thenReturn("johnmary");
        UserDto actualLoginResult = this.userServiceImpl.login(userDto);
        assertEquals("Username not found", actualLoginResult.getMessage());
        assertNull(actualLoginResult.getUsername());
        assertNull(actualLoginResult.getPassword());
        verify(this.userRepository).findByUsername(any());
        verify(userDto).getUsername();
    }
}

