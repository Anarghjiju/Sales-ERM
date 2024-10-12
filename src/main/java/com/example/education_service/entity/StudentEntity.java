package com.example.education_service.entity;



import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "student")
@Builder
@Entity
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String dob;
    private String gender;
    private String email;
    private String phno;
    private String city;
    private String enrollmentDate;
    private String courseId;
    private String status;
    private Integer marks;
    private String scholarship;
    private String major;


}
