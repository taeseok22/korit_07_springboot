package com.example.todolist.controller;

import com.example.todolist.Service.TodoService;
import com.example.todolist.entity.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todos")
public class TodoController<TodoRequest> {
    private final TodoService todoService;

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.findAllTodos();
    }
    @PostMapping
    public ResponseEntity<Todo> addTodo(@RequestBody TodoRequest request,
                                        @AuthenticationPrincipal UserDetails userDetails) {
        Todo todo = todoService.addTodoForUser(userDetails.getUsername(), request);
        return ResponseEntity.ok(todo);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Todo> updateTodoStatus(@PathVariable Long id) {
        Todo updatedTodo = todoService.updateTodoStatus(id);
        return ResponseEntity.ok(updatedTodo);
    }
    @DeleteMapping("/completed")
    public ResponseEntity<Void> clearCompletedTodos() {
        todoService.clearCompletedTodos();
        return ResponseEntity.noContent().build();
    }

}
