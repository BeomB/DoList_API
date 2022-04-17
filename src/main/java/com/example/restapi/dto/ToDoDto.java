package com.example.restapi.dto;


import com.example.restapi.entity.ToDo;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@AllArgsConstructor
@ToString
public class ToDoDto {

    private Long id;

    private String title;

    private String content;

    private Date to_date;

    private String img;

    private Boolean to_check;

    public ToDo toEntity() {
        return new ToDo(id,title,content,to_date,img,to_check);
    }

}
