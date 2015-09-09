package pl.pragmatists.stack;

public class Stack {

    private int size;
    private String[] elements;

    public Stack(int capacity) {
        this.elements = new String[capacity];
    }

    public int size() {
        return size;
    }

    public void push(String element) {
        if (isFull()) {
            throw new FullStackException();
        }
        this.elements[size++] = element;
    }

    private boolean isFull() {
        return size == elements.length;
    }

    public String pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements[--size];
    }

    private boolean isEmpty() {
        return size == 0;
    }

}
