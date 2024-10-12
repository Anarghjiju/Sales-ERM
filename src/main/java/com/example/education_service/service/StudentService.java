package com.example.education_service.service;


import com.example.education_service.dto.StudentDto;
import com.example.education_service.entity.StudentEntity;
import com.example.education_service.repository.StudentRepo;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    StudentRepo sr;

    private final JPAStreamer jpaStreamer;

    @Autowired
    public StudentService(final JPAStreamer jpaStreamer) {
        this.jpaStreamer = jpaStreamer;
    }

    public StudentEntity saveStudent(StudentDto studentDTO) {
        StudentEntity student = StudentEntity.builder()
                .name(studentDTO.getName())
                .dob(studentDTO.getDob())
                .gender(studentDTO.getGender())
                .email(studentDTO.getEmail())
                .phno(studentDTO.getPhno())
                .city(studentDTO.getCity())
                .enrollmentDate(studentDTO.getEnrollmentDate())
                .courseId(studentDTO.getCourseId())
                .status(studentDTO.getStatus())
                .marks(studentDTO.getMarks())
                .scholarship(studentDTO.getScholarship())
                .major(studentDTO.getMajor())
                .build();

        return sr.save(student);
    }

    public StudentEntity getAStudent(Long id) {
        return sr.findById(id).orElse(null);
    }

    public List<StudentEntity> getAllStudents() {
        return sr.findAll();
    }

    public Map<String, List<StudentEntity>> groupByGender() {
        return sr.findAll().stream()
                .collect(Collectors.groupingBy(StudentEntity::getGender));
    }

    public Map<String, List<StudentEntity>> groupByScholarshipYesNo() {
        return sr.findAll().stream()
                .collect(Collectors.groupingBy(student -> "Yes".equalsIgnoreCase(student.getScholarship()) ? "Yes" : "No"));
    }

}
