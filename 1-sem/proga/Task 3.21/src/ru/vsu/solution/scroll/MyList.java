package ru.vsu.solution.scroll;

import java.util.ArrayList;
import java.util.List;

public class MyList<T> {


    private MyListItem<T> head = null;
    private MyListItem<T> tail = null;
    private int size = 0;

    private void checkEmpty() throws Exception {
        if (isEmpty()) {
            throw new Exception("List is empty");
        }
    }

    private static int myComparator(int a, int b){
        if (a>b){
            return 1;
        }
        return 0;
    }

    public T getFirst() throws Exception {
        checkEmpty();
        return head.value;
    }

    public T getLast() throws Exception {
        checkEmpty();
        return tail.value;
    }

     void addFirst(T value) {
        head = new MyListItem<>(value, head);
        if (tail == null) {
            tail = head;
        }
        size++;
    }
    private void setFirst(T value) {
        head = new MyListItem<>(value, head.next);
    }
    private void setLast(T value) {
        tail = new MyListItem<>(value);
    }

    protected void addLast(T value) {
        if (tail == null) {
            head = tail = new MyListItem<>(value);
        } else {
            tail = tail.next = new MyListItem<>(value);
        }
        size++;
    }

    public T removeFirst() throws Exception {
        checkEmpty();
        T value = getFirst();
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }

    public T removeLast() throws Exception {
        checkEmpty();
        T value = getLast();
        if (size == 1) {
            removeFirst();
        } else {
            tail = getItem(size - 2);
            tail.next = null;
            size--;
        }
        return value;
    }

    public T remove(int index) throws Exception {
        checkEmpty();
        if (index == 0) {
            return removeFirst();
        } else if (index == size) {
            return removeLast();
        } else {
            MyListItem<T> prev = getItem(index - 1);
            T value = prev.next.value;
            prev.next = prev.next.next;
            if (prev.next == null) {
                tail = prev;
            }
            size--;
            return value;
        }

    }



    private MyListItem<T> getItem(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new Exception("Incorrect index");
        }
        MyListItem<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public T get(int index) throws Exception {
        return getItem(index).value;
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void add(int index, T value) throws Exception {
        if (index < -1 || index > size) {
            throw new Exception("Incorrect index");
        }
        if (index == 0) {
            addFirst(value);
        } else if (index == -1) {
            addLast(value);
        } else {
            MyListItem<T> prev = getItem(index - 1);
            prev.next = new MyListItem<>(value, prev.next);
            if (prev.next.next == null) {
                tail = prev.next;
            }
            size++;
        }
    }
    public void set(int index, T value) throws Exception {
        if (index < -1 || index > size) {
            throw new Exception("Incorrect index");
        }
        if (index == 0) {
            setFirst(value);
        } else if (index == -1) {
            setLast(value);
        } else {
            MyListItem<T> prev = getItem(index - 1);
            if (index+1 < size) {
                prev.next = new MyListItem<>(value, getItem(index + 1));
            } else {
                prev.next = new MyListItem<>(value, null);
            }
        }
    }

    public void add(T value) throws Exception {
        if (size == 0) {
            addFirst(value);
        } else {
            MyListItem<T> prev = getItem(size -1);
            prev.next = new MyListItem<>(value, prev.next);
            tail = prev.next;
            size++;
        }
    }


    private class MyListItem<T> {
        public T value;
        public MyListItem<T> next;

        public MyListItem(T value, MyListItem<T> next) {
            this.value = value;
            this.next = next;
        }

        public MyListItem(T value) {
            this(value, null);
        }

    }

    public void sorted(MyList<Integer> list) throws Exception {
        for (int i = 1; i < list.size(); i++) {
            Integer value = list.get(i);
            for (int k = 0; k< list.size(); k++) {
                System.out.print((k > 0 ? ", " : "") + list.get(k));
            }
            System.out.println();
            int j;
            for (j = i - 1; j >= 0 && (myComparator(list.get(j), value)) > 0; j--) {
                list.set(j + 1, list.get(j));     // сдвигаем элемент направо, пока не дошли
            }
            list.set(j + 1, value);
        }
    }
    public int[] convertLinkedListToArray() {
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add((Integer) head.value);
            head = head.next;
        }

        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

}
