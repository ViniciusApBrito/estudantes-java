package com.example.studentbackend.dtos;


import jakarta.validation.constraints.NotBlank;

public record StudentRequest(
    @NotBlank(message = "O Nome não pode ser em branco")
    String name, 
    @NotBlank(message = "O Email não pode ser em branco")
    String email, 
    @NotBlank(message = "O CPF não pode ser em branco")
    String cpf, 
    @NotBlank(message = "A localização não pode ser em branco")
    String location,
    @NotBlank(message = "A idade não pode ser em branco")
    String age

) {

}