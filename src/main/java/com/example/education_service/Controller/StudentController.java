package com.example.education_service.Controller;


import com.example.education_service.dto.StudentDto;
import com.example.education_service.entity.StudentEntity;
import com.example.education_service.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Validated
public class StudentController {

    @Autowired
    StudentService ss;

    @PostMapping("/save/student")
    public StudentEntity saveStudent(@Valid @RequestBody StudentDto studentDTO) {
        return ss.saveStudent(studentDTO);
    }

    // Endpoint to get a student by ID
    @GetMapping("/student/{id}")
    public StudentEntity getAStudent(@PathVariable Long id) {
        return ss.getAStudent(id);
    }

    // Endpoint to get all students
    @GetMapping("/student")
    public List<StudentEntity> getAllStudents() {
        return ss.getAllStudents();
    }

    // Endpoint to group students by gender
    @GetMapping("/student/gender")
    public Map<String, List<StudentEntity>> groupByGender() {
       return ss.groupByGender();
    }


    @GetMapping("/student/scholarship")
    public Map<String, List<StudentEntity>> groupByMajorAndScholarshipYesNo() {
        return ss.groupByScholarshipYesNo();
    }

}
