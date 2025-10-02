package com.example.todolist.repository;

import com.example.todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Todo, Long> {

}
