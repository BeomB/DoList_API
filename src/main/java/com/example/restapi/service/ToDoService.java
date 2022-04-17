package com.example.restapi.service;

import com.example.restapi.dto.ToDoDto;
import com.example.restapi.entity.ToDo;
import com.example.restapi.repository.ToDoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ToDoService {

    @Autowired
    ToDoRepository toDoRepository;


    public List<ToDo> getAll() {
        return (List<ToDo>) toDoRepository.findAll();
    }

    public Optional<ToDo> getToDo(Long id) {
        return toDoRepository.findById(id);
    }

    public ToDo create(ToDoDto toDoDto) {
        ToDo createToDo = toDoDto.toEntity();
        log.info(createToDo.toString());
        toDoRepository.save(createToDo);
        return createToDo;
    }

    public ToDo update(Long id, ToDoDto toDoDto)
    {
        ToDo updateTodoTarget = toDoRepository.findById(id).orElse(null);
        ToDo upadteTodo = toDoDto.toEntity();
        updateTodoTarget.patch(upadteTodo);

        ToDo toDo = toDoRepository.save(updateTodoTarget);
        return toDo;


    }



}
