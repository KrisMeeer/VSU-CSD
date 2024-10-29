package ru.vsu.solution.scroll;

public interface VeryWellQueue<T> {
    void offer(T value);
    T poll() throws Exception;
    T element() throws Exception;
    int size();
    default boolean empty(){
        return size() == 0;
    }


}
