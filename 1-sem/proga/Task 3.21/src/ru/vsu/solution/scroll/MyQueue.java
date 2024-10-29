package ru.vsu.solution.scroll;

public class MyQueue<T> implements VeryWellQueue<T> {

    private class MyQueueItem<T> {
        public T value;
        public MyQueueItem<T> next;

        public MyQueueItem(T value, MyQueueItem<T> next) {
            this.value = value;
            this.next = next;
        }

        public MyQueueItem(T value) {
            this(value, null);
        }

    }

    private MyQueueItem<T> head = null;
    private MyQueueItem<T> tail = null;
    private int size = 0;

    @Override
    public void offer(T value) {
        if (tail == null){
            head = tail = new MyQueueItem<>(value, null);
        } else {
            tail.next = new MyQueueItem<>(value, null);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public T poll() throws Exception {
        if (head==null){
            throw new Exception("Queue is empty");
        }
        T value = head.value;
        head = head.next;
        if (head == null){
            tail = null;
        }
        size--;
        return value;
    }

    @Override
    public T element() throws Exception {
        if (head==null){
            throw new Exception("Queue is empty");
        }
        return head.value;
    }

    @Override
    public int size() {
        return size;
    }

}
