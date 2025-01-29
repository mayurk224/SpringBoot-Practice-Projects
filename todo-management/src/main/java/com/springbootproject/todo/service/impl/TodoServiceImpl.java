package com.springbootproject.todo.service.impl;

import com.springbootproject.todo.dto.TodoDto;
import com.springbootproject.todo.entity.Todo;
import com.springbootproject.todo.repository.TodoRepository;
import com.springbootproject.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    private ModelMapper modelMapper;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {

        Todo todo = modelMapper.map(todoDto,Todo.class);

        Todo saveTodo = todoRepository.save(todo);

        TodoDto savedTodoDto = modelMapper.map(saveTodo,TodoDto.class);

        return savedTodoDto;
    }
}
