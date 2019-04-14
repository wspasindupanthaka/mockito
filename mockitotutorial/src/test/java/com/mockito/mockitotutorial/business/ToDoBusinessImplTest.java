package com.mockito.mockitotutorial.business;

import com.mockito.mockitotutorial.data.api.TodoService;
import com.mockito.mockitotutorial.data.api.TodoServiceStub;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ToDoBusinessImplTest {

    @Test
    public void testRetrieveTodosRelatedToSpring_Stub(){
        //In here we are using stub or dummy data source
        TodoService todoServiceStub = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
        List<String> filteredToDos  = todoBusinessImpl.retrieveTodosRelatedToSpring("Pasindu");

        assertEquals(2, filteredToDos.size());
    }

}
