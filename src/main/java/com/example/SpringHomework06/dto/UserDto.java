package com.example.SpringHomework06.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
@Schema(description = "Сущность пользователя")
public class UserDto {


    @Schema(description = "Уникальный идентификатор пользователя")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "ФИО пользователя", example = "Иванов Иван Иванович")
    private String name;

    @Schema(description = "Возраст пользователя", example = "25")
    private int age;

    @Schema(description = "Адрес пользователя", example = "Москва")
    private String city;

    @Schema(description = "Email пользователя", example = "ivanov@gmail.com")
    private String email;


}
