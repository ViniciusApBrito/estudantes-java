package com.example.studentbackend.mappers;

import java.util.List;
import java.util.stream.Collectors;

import com.example.studentbackend.dtos.StudentRequest;
import com.example.studentbackend.dtos.StudentResponse;
import com.example.studentbackend.entities.Student;

public class StudentMapper {
    public static Student toEntity(StudentRequest request) {
        Student student = new Student();
        student.setName(request.name());
        student.setEmail(request.email());
        student.setCpf(request.cpf());
        student.setLocation(request.location());
        student.setAge(request.age());
        return student;
    }

    public static StudentResponse toDTO(Student student) {
        return new StudentResponse(student.getId(), student.getName(), student.getCpf(), student.getEmail(),
                student.getLocation(), student.getAge());

    }

    public static List<StudentResponse> toDTOList(List<Student> students) {
        return students.stream()
                .map(StudentMapper::toDTO)
                .collect(Collectors.toList());
    }

}
