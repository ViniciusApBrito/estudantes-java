package com.example.studentbackend.dtos;

public record StudentResponse(
    long id,
    String name,
    String cpf,
    String email,
    String location,
    String age

) {
}