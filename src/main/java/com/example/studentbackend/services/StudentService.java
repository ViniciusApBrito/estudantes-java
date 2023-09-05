package com.example.studentbackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentbackend.dtos.StudentRequest;
import com.example.studentbackend.dtos.StudentResponse;
import com.example.studentbackend.entities.Student;
import com.example.studentbackend.mappers.StudentMapper;
import com.example.studentbackend.repositories.StudentRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StudentService {

   @Autowired
   private StudentRepository repository;

   public List<Student> getStudents() {
      return this.repository.findAll();
   }

   public Student getStudent(long id) {
      return this.repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Student not found"));
   }

   public void deleteStudentById(long id) {

      if (this.repository.existsById(id)) {
         this.repository.deleteById(id);
      }

      else {
         throw new EntityNotFoundException("Student not found");

      }

   }

   public StudentResponse save(StudentRequest student) {
      var entity = this.repository.save(StudentMapper.toEntity(student));
      return StudentMapper.toDTO(entity);
   }

   public void update(long id, StudentRequest student) {
      try {
         var updateStudent = this.repository.getReferenceById(id);
         updateStudent.setName(student.name());
         updateStudent.setEmail(student.email());
         updateStudent.setCpf(student.cpf());
         updateStudent.setLocation(student.location());
         updateStudent.setAge(student.age());

         this.repository.save(updateStudent);
      } catch (EntityNotFoundException e) {
         throw new EntityNotFoundException("Student not found");
      }

   }

}