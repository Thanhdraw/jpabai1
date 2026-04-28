package com.cybersoft.jbabai1.exception;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class APIResponse<T> {

    @Builder.Default
    private LocalDateTime timestamp =  LocalDateTime.now();
    private int status;
    private String error;
    private String message;
    private T data;
}
