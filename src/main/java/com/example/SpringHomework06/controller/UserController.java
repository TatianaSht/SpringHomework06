package com.example.SpringHomework06.controller;

import com.example.SpringHomework06.dto.UserDto;
import com.example.SpringHomework06.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Tag(name = "User", description = "Контроллер для управления пользователями")
public class UserController {

    private final UserService userService;

    @Operation(summary = "Получение списка всех пользователей")
    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }


    @Operation(summary = "Создание пользователя")
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }


    @Operation(summary = "Поиск пользователя по Id")
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") Long id) {
        UserDto userDtoById;
        try {
            userDtoById = userService.getUserById(id);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new UserDto());
        }
        return new ResponseEntity<>(userDtoById, HttpStatus.OK);
    }


    @Operation(summary = "Обновление данных пользователя")
    @PutMapping
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.updateUser(userDto), HttpStatus.OK);
    }


    @Operation(summary = "Удаление пользователя по Id")
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

}
