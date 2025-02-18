package com.exemple.desafiopro.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TodoResponse {
    private Long id;
    private String title;
    private String description;
}
