package com.example.restapi.repository;
import com.example.restapi.entity.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo,Long> {

}
