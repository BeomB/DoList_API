package com.example.restapi.repository;
import com.example.restapi.entity.ToDo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface ToDoRepository extends CrudRepository<ToDo,Long> {



    @Query(value = "select * from to_do_list where to_check = true",nativeQuery = true)
    public List<ToDo> completeList();



}
