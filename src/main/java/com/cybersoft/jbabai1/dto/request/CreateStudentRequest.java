package com.cybersoft.jbabai1.dto.request;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStudentRequest {

    @NotBlank(message = "Name is not empty")
    private String name;

    @NotBlank(message = "Email is not Empty")
    @Email(message = "Email is not valid")
    private String email;

    @NotNull(message = "Tuoi khong duoc de trong")
    @Min(message = "18 tuoi tro len ", value = 18)
    @Max(value = 100,message = "Age is not than 100")
    private Integer age;
}
