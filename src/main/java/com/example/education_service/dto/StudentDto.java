package com.example.education_service.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDto {

    @Id
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "DOB should be in the format YYYY-MM-DD")
    private String dob;

    @NotBlank(message = "Gender is mandatory")
    private String gender;

    @Email(message = "Email should be valid")
    private String email;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number should be 10 digits")
    private String phno;

    @NotBlank(message = "City is mandatory")
    private String city;

    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Date should be in the format YYYY-MM-DD")
    private String enrollmentDate;

    @NotBlank(message = "Course ID is mandatory")
    private String courseId;

    @Pattern(regexp = "^(Active|Graduated)$",message = "Status should be Active or Graduated")
    private String status;

    @Min(value = 0, message = "Marks should not be less than 0")
    @Max(value = 100, message = "Marks should not be more than 100")
    private Integer marks;

    @Pattern(regexp = "^(Yes|No)$",message = "Scholarship status should be Yes or No")
    private String scholarship;

    @NotBlank(message = "Major is mandatory")
    private String major;


}

