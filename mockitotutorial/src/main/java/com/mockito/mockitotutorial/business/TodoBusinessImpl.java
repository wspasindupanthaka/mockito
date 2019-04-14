package com.mockito.mockitotutorial.business;

import com.mockito.mockitotutorial.data.api.TodoService;

import java.util.ArrayList;
import java.util.List;

public class TodoBusinessImpl {

    private TodoService todoService;

    //Real implementation of TodoService is not available with us
    TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    //We are writing test to test this method
    public List<String> retrieveTodosRelatedToSpring(String user) {
        List<String> filteredTodos = new ArrayList<String>();
        List<String> allTodos = todoService.retrieveTodos(user);
        for (String todo : allTodos) {
            if (todo.contains("Spring")) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

}
