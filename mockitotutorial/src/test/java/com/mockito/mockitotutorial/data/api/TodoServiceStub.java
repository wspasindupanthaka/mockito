package com.mockito.mockitotutorial.data.api;

import java.util.Arrays;
import java.util.List;

/*
Stub is nothing; but returns dummy data
 */
public class TodoServiceStub implements TodoService {

    //This Stub method has some problems, when we add a new method to ToDoService; we have to implement that method in this
    //class too. Maintenance is difficult in here.

    public List<String> retrieveTodos(String user) {
        return Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
    }
}
