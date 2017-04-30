package com.in28minutes.Resfull;

import com.in28minutes.todo.Todo;
import com.in28minutes.todo.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by gerado on 4/29/2017.
 */

@RestController
public class TodoRestController {

    @Autowired
    TodoService service;

    @RequestMapping(path = "/todos")
    public List<Todo> retriveAllTodos()
    {
        List<Todo> users = service.retrieveTodos("gbelot");
        return users;
    }
}
