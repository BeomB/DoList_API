package com.example.restapi.entity;

import javafx.beans.binding.BooleanExpression;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="ToDoList")
public class ToDo {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private Date to_date;

    @Column
    private String img;

    @Column
    private Boolean to_check;



    public void patch(ToDo toDo) {
        if (toDo.title!=null)
        {
            this.title = toDo.title;
        }
        if (toDo.content!=null)
        {
            this.content = toDo.content;
        }
        if (toDo.to_date!=null)
        {
            this.to_date = toDo.to_date;
        }
        if (toDo.img!=null)
        {
            this.img = toDo.img;
        }
        if (toDo.to_check!=null)
        {
            this.to_check = toDo.to_check;
        }
    }

}
