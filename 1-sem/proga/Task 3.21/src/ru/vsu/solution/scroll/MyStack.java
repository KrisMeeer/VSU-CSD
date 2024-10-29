package ru.vsu.solution.scroll;

public class MyStack<T> implements Stack<T> {

    private class MyStackItem<T> {
        public T value;
        public MyStackItem<T> next;

        public MyStackItem(T value, MyStackItem<T> next) {
            this.value = value;
            this.next = next;
        }

        public MyStackItem(T value) {
            this(value, null);
        }

    }

    private MyStackItem<T> head = null;
    private int size = 0;

    @Override
    public void push(T value) {
        head = new MyStackItem<>(value, head);
        size++;
    }

    @Override
    public T pop() throws Exception {
        if (head==null){
            throw new Exception("Stack is empty");
        }
        T value = head.value;
        head = head.next;
        size--;
        return value;
    }

    @Override
    public T peek() throws Exception {
        if (head==null){
            throw new Exception("Stack is empty");
        }
        return head.value;
    }

    @Override
    public int size() {
        return size;
    }
}