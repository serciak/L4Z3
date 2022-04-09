package com.company;

public class DrowningStack<T> implements StackInterface<T> {

    private final int defaultSize = 16;
    private int topIndex;
    private int maxSize;
    private OneWayLinkedList<T> list;

    public DrowningStack() {
        maxSize = defaultSize;
        list = new OneWayLinkedList<>();
    }

    public DrowningStack(int maxSize) {
        this.maxSize = maxSize;
        list = new OneWayLinkedList<>();
    }

    @Override
    public String toString() {
        return list.toString();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean isFull() {
        return maxSize == topIndex;
    }

    @Override
    public T pop() throws EmptyStackException {
        if(isEmpty()) throw new EmptyStackException();
        return list.remove(0);
    }

    @Override
    public void push(T elem) throws FullStackException {
        if(isFull())
            list.remove(topIndex-1);
        else
            topIndex++;
        list.add(0, elem);
    }

    @Override
    public T top() throws EmptyStackException {
        if(isEmpty()) throw new EmptyStackException();
        return list.get(0);
    }

    @Override
    public int size() {
        return topIndex;
    }
}
