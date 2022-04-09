package com.company;

public class Main {

    public static void main(String[] args) throws FullStackException, EmptyStackException {
	    DrowningStack<Integer> drowningStack = new DrowningStack<>(4);

        drowningStack.push(1);
        drowningStack.push(2);
        drowningStack.push(3);
        drowningStack.push(4);
        drowningStack.push(5);
        System.out.println(drowningStack);
        drowningStack.push(121313232);
        System.out.println(drowningStack);
    }
}
