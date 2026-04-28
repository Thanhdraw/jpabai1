package com.cybersoft.jbabai1.dto.request;


import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateStudentRequest {

    @NotBlank(message = "Updated name cannot be blank")
    @Size(min = 2,max = 50,message = "Name must be between 2 and 50 characters")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required for update confirmation")
    private String email;

    @NotNull(message = "Age is mandatory")
    @Min(value = 18, message = "Student must be at least 18 years old")
    @Max(value = 100, message = "Age must be realistic (under 100)")

    private Integer age;
}
