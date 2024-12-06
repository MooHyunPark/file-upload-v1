package com.metacoding.upload;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Resp<T> {
    private boolean success;
    private String message;
    private T data;
}
