package com.mockito.mockitotutorial;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    public void mockListSize() {
        List listMock = mock(List.class);

        when(listMock.size()).thenReturn(2);

        assertEquals(2,listMock.size());
    }

    @Test
    public void mockListSize_ReturnMultipleValues() {
        List listMock = mock(List.class);

        //First time it returns 2 as size and then it returns 3
        when(listMock.size()).thenReturn(2).thenReturn(3);

        assertEquals(2,listMock.size());
        assertEquals(3,listMock.size());
    }

    @Test
    public void mockListGet() {
        List listMock = mock(List.class);

        when(listMock.get(0)).thenReturn("Pasindu");

        assertEquals("Pasindu",listMock.get(0));

        //When we don't specify the what to do; they return defaults
        assertEquals(null,listMock.get(1));
    }


    @Test
    public void mockListGet_AnyInt() {
        List listMock = mock(List.class);

        when(listMock.get(anyInt())).thenReturn("Pasindu");

        assertEquals("Pasindu",listMock.get(0));
        assertEquals("Pasindu",listMock.get(1));
    }

    //Test FAILS
    @Test
    public void mockListGet_throwException_WithoutExpectedTag() {
        List listMock = mock(List.class);

        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Thrown using Mockito"));

        assertEquals("Pasindu",listMock.get(0));
        assertEquals("Pasindu",listMock.get(1));
    }

    //Test PASSES
    @Test(expected = RuntimeException.class)
    public void mockListGet_throwException_WithExpectedTag() {
        List listMock = mock(List.class);

        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Thrown using Mockito"));

        assertEquals("Pasindu",listMock.get(0));
        assertEquals("Pasindu",listMock.get(1));
    }

}
