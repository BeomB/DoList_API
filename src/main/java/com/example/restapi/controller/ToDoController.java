package com.example.restapi.controller;

import com.example.restapi.dto.ToDoDto;
import com.example.restapi.entity.ToDo;
import com.example.restapi.service.ToDoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/doapi")
public class ToDoController {

    @Autowired
    ToDoService toDoService;

    @GetMapping("/getall")
    public List<ToDo> getAll()
    {
    return toDoService.getAll();
    }

    @GetMapping("/gettodo/{id}")
    public Optional<ToDo> getToDo(@PathVariable Long id)
    {
        return toDoService.getToDo(id);
    }

    @PostMapping("/create")
    public ResponseEntity<ToDo> createToDo(@RequestBody ToDoDto toDoDto)
    {
        System.out.println(toDoDto.toString()+"!!!!!!!!!!!!!!!!!!!!!!!!!");
        ToDo createToDo = toDoService.create(toDoDto);
        return (createToDo != null) ? ResponseEntity.status(HttpStatus.OK).body(createToDo) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ToDo> update(@PathVariable Long id, @RequestBody  ToDoDto toDoDto)
    {
       ToDo toDo = toDoService.update(id,toDoDto);
        return (toDo != null) ? ResponseEntity.status(HttpStatus.OK).body(toDo) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
        ToDo deleteToDo = toDoService.Delete(id);
        return (deleteToDo != null) ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
