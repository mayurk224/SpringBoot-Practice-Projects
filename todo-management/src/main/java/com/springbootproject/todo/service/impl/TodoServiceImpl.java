package com.springbootproject.todo.service.impl;

import com.springbootproject.todo.dto.TodoDto;
import com.springbootproject.todo.entity.Todo;
import com.springbootproject.todo.repository.TodoRepository;
import com.springbootproject.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;
    @Override
    public TodoDto addTodo(TodoDto todoDto) {

        Todo todo = new Todo();
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());

        Todo saveTodo = todoRepository.save(todo);

        TodoDto savedTodoDto = new TodoDto();
        savedTodoDto.setId(saveTodo.getId());
        savedTodoDto.setTitle(saveTodo.getTitle());
        savedTodoDto.setDescription(saveTodo.getDescription());
        savedTodoDto.setCompleted(saveTodo.isCompleted());

        return savedTodoDto;
    }
}
