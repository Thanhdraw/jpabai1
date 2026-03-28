package com.cybersoft.jbabai1.exception;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class APIResponse<T> {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private T message;
}
