package com.exemple.desafiopro.messaging.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoMessage {
    private Long id;
    private String title;
    private String description;
}
