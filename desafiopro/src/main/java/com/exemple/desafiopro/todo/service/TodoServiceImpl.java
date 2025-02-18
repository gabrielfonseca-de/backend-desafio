package com.exemple.desafiopro.todo.service;

import com.exemple.desafiopro.todo.dto.TodoRequest;
import com.exemple.desafiopro.todo.dto.TodoResponse;
import com.exemple.desafiopro.todo.model.Todo;
import com.exemple.desafiopro.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;

    @Override
    public TodoResponse createTodo(TodoRequest request) {
        Todo todo = new Todo();
        todo.setTitle(request.getTitle());
        todo.setDescription(request.getDescription());
        Todo savedTodo = todoRepository.save(todo);
        return new TodoResponse(savedTodo.getId(), savedTodo.getTitle(), savedTodo.getDescription());
    }

    @Override
    public List<TodoResponse> getAllTodos() {
        return todoRepository.findAll().stream()
                .map(todo -> new TodoResponse(todo.getId(), todo.getTitle(), todo.getDescription()))
                .collect(Collectors.toList());
    }
}
