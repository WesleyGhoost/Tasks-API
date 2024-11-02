package com.felix.first_spring.app.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Task {
    
    private Long id;
    private String title;
    private String description;
}
