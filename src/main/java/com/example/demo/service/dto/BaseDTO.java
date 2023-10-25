package com.example.demo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class BaseDTO<T> implements Serializable {
    private String code;
    private String message;
    private T data;
}
