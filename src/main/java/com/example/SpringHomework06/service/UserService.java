package com.example.SpringHomework06.service;

import com.example.SpringHomework06.dto.UserDto;
import com.example.SpringHomework06.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserDto> getAllUsers() {
        return userRepository.findAll();
    }


    public UserDto getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(null);
    }


    public UserDto updateUser(UserDto userDto) {
        UserDto userDtoById = getUserById(userDto.getId());
        userDtoById.setName(userDto.getName());
        userDtoById.setAge(userDto.getAge());
        userDtoById.setCity(userDto.getCity());
        userDtoById.setEmail(userDto.getEmail());
        return userRepository.save(userDtoById);
    }


    public UserDto createUser(UserDto userDto) {
        return userRepository.save(userDto);
    }


    public void deleteUser(Long id) {
        UserDto productById = getUserById(id);
        userRepository.delete(productById);
    }
}
