package com.example.todolist.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoUpdateDto {
    private String content;
    private boolean completed;
}