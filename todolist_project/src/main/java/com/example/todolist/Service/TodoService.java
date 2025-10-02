package com.example.todolist.Service;

import com.example.todolist.entity.Todo;
import com.example.todolist.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TodoService {
    private TodoRepository todoRepository;

    public List<Todo> findAllTodos() {
        return todoRepository.findAll();
    }
    public void addTodo(Todo todo) {
        todoRepository.save(todo);
    }
    public Todo updateTodoStatus(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 Todo가 없습니다. id=" + id));
        todo.setCompleted(!todo.isCompleted());
        return todoRepository.save(todo);
    }
    public void clearCompletedTodos() {
        Long UserId = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        todoRepository.deleteAllByUserIdAndIsCompletedTrue(UserId);
    }
    

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
