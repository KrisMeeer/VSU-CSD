package ru.vsu.solution.util.LogicOfArray;

import java.util.LinkedList;
import java.util.Queue;

public class LogicAboutJava {
    private static boolean palindrome;
    private static Queue<Character> queue;
    private static int position = 0;


    public static Queue<Character> arrayInQueue(char[] array) {
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            queue.offer(array[i]);
        }
        return queue;
    }


    private static void recursive() {
        if (queue != null) {
            char nowNumber = queue.poll();
            queue.add(nowNumber);
            position++;
            int center = queue.size() / 2;
            if (position <= center) {
                if (queue.size() % 2 == 0 && position < center || queue.size() % 2 == 1) {
                    recursive();
                }
                char nextNumber = queue.poll();
                queue.add(nextNumber);
                if (nextNumber != nowNumber) {
                    palindrome = false;
                }
            }
        }
    }


    public static boolean intoJavaInterfaceCheckPalindrome(Queue<Character> queueData) {
        if (!queueData.isEmpty()) {
            position = 0;
            palindrome = true;
            queue = queueData;
            recursive();
        }
        return palindrome;
    }
    /*private static void recursiveFirst() {
        if (queue!=null) {
            position++;
            char nowNumber = queue.poll();
            queue.add(nowNumber);
            int center = queue.size()/2;
            if (position <= center) {
                if ((position < center) || (queue.size() % 2 == 1)) {
                    recursiveFirst();
                }
                char nextNumber = queue.poll();
                queue.add(nextNumber);
                if (nextNumber != nowNumber) {
                    palindrome = false;
                }
            }
        }
    }*/
}
