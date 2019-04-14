package com.mockito.mockitotutorial.business;

import com.mockito.mockitotutorial.data.api.TodoService;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ToDoBusinessImplMockTest {

    /**
     * Mocking is creating object that simulate the behaviour of real objects. Unlike stubs, mocks can be dynamically created
     * from code at runtime. Mocks offer more functionality than stubbing.
     */


    //In the first time when we Mocking, we are not telling it what to do when we call the 'retrieveTodos(user)' method of it;
    //therefore it returns an empty list and test fails.

    @Test
    public void testRetrieveTodosRelatedToSpring_Mock1(){

        TodoService todoServiceMock = mock(TodoService.class);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        List<String> filteredToDos  = todoBusinessImpl.retrieveTodosRelatedToSpring("Pasindu");

        assertEquals(2, filteredToDos.size());
    }

    @Test
    public void testRetrieveTodosRelatedToSpring_Mock2(){

        TodoService todoServiceMock = mock(TodoService.class);

        List<String> toDos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");

        when(todoServiceMock
                .retrieveTodos("Pasindu"))
                .thenReturn(toDos);


        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        List<String> filteredToDos  = todoBusinessImpl.retrieveTodosRelatedToSpring("Pasindu");

        assertEquals(2, filteredToDos.size());
    }

    //If we want to test the same thing with empty list, it is very easy to do. In the stub approach we have to change the
    //ToDoService class
    @Test
    public void testRetrieveTodosRelatedToSpring_Mock2WithEmptyList(){

        TodoService todoServiceMock = mock(TodoService.class);

        List<String> toDos = Arrays.asList();

        when(todoServiceMock
                .retrieveTodos("Pasindu"))
                .thenReturn(toDos);


        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        List<String> filteredToDos  = todoBusinessImpl.retrieveTodosRelatedToSpring("Pasindu");

        assertEquals(0, filteredToDos.size());
    }

}
