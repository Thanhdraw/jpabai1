package com.cybersoft.jbabai1.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RegisterCourseRequest {
    private List<Long> courseIds;
}
