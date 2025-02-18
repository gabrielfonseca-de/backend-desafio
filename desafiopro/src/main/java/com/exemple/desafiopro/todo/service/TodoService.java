package com.exemple.desafiopro.todo.service;

import com.exemple.desafiopro.todo.dto.TodoRequest;
import com.exemple.desafiopro.todo.dto.TodoResponse;
import java.util.List;

public interface TodoService {
    TodoResponse createTodo(TodoRequest request);
    List<TodoResponse> getAllTodos();
}