package com.company;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class DrowningStackTest {

    DrowningStack<Integer> drowningStack;

    @BeforeEach
    void setUp() {
        drowningStack = new DrowningStack<>(3);
    }

    @Test
    void isEmpty() throws FullStackException {
        assertTrue(drowningStack.isEmpty());
        drowningStack.push(11);
        assertFalse(drowningStack.isEmpty());
    }

    @Test
    void isFull() throws FullStackException {
        assertFalse(drowningStack.isFull());
        drowningStack.push(11);
        drowningStack.push(11);
        drowningStack.push(11);
        assertTrue(drowningStack.isFull());
        drowningStack.push(11);
        assertTrue(drowningStack.isFull());
    }

    @Test
    void pop() throws EmptyStackException {
        assertThrows(EmptyStackException.class, () -> {
            drowningStack.pop();
        });
        drowningStack.push(11);
        drowningStack.push(12);
        drowningStack.push(13);
        assertEquals(13, drowningStack.pop());
        drowningStack.push(13);
        drowningStack.push(14);
        drowningStack.pop();
        drowningStack.pop();
        assertEquals(12, drowningStack.pop());
    }

    @Test
    void push() throws EmptyStackException {
        drowningStack.push(11);
        drowningStack.push(12);
        drowningStack.push(13);
        assertEquals(13, drowningStack.pop());
        drowningStack.push(13);
        drowningStack.push(14);
        drowningStack.pop();
        drowningStack.pop();
        assertEquals(12, drowningStack.pop());
    }

    @Test
    void top() throws EmptyStackException {
        assertThrows(EmptyStackException.class, () -> {
            drowningStack.top();
        });
        drowningStack.push(11);
        drowningStack.push(12);
        drowningStack.push(13);
        assertEquals(13, drowningStack.top());
        drowningStack.push(14);
        drowningStack.push(15);
        drowningStack.pop();
        drowningStack.pop();
        assertEquals(13, drowningStack.top());
    }

    @Test
    void size() {
        assertEquals(0, drowningStack.size());
        drowningStack.push(14);
        drowningStack.push(15);
        assertEquals(2, drowningStack.size());
        drowningStack.push(14);
        drowningStack.push(15);
        drowningStack.push(14);
        drowningStack.push(15);
        assertEquals(3, drowningStack.size());
    }
}