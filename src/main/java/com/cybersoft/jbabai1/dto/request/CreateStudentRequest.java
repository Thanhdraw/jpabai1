package com.cybersoft.jbabai1.dto.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStudentRequest {

    @NotBlank(message = "Ten khong duoc de trong")
    private String name;

    @Email(message = "Email khong dung dinh dang")
    private String email;

    @NotNull(message = "Tuoi khong duoc de trong")
    @Min(message = "18 tuoi tro len ", value = 18)
    private Integer age;
}
