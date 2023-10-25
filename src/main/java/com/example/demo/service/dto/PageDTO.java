package com.example.demo.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Collection;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class PageDTO<T> implements Serializable {
    private int totalElement;
    private int pageSize;
    private int totalPages;
    private Collection<T> object;
}
