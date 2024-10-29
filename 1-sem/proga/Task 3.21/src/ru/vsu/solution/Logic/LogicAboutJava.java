package ru.vsu.solution.Logic;


import java.util.LinkedList;
import java.util.Queue;

public class LogicAboutJava {
    private static boolean palindrome;
    private static Queue<Character> queue;
    private static int position = 0;

    private static int realDifference = 0;
    public static Queue<Character> arrayInQueue(char[] array) {
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            queue.offer(array[i]);
        }
        return queue;
    }

    private static void recursive(Queue<Character> queue) {
        if (queue!=null) {
            char nowNumber;
            char numberOfEnd;

            nowNumber = queue.poll();
            queue.offer(nowNumber);
            position++;
            realDifference++;
            numberOfEnd = numberOfEnd(position, queue);
            if (position + realDifference > (queue.size() - queue.size() % 2)) {
                nowNumber = '0';
                numberOfEnd = '0';
            }

            if (numberOfEnd != nowNumber) {
                palindrome = false;
            }
            if (position < queue.size()) {
                recursive(queue);
            }
        }
    }



    private static char numberOfEnd(int pos, Queue<Character> queue){
        pos = queue.size() - pos - realDifference;
        char last = 0;
        for (int i = 0; i < queue.size(); i++) {
            char a = queue.poll();
            if (pos == i) {
                last = a;
            }
            queue.offer(a);
        }
        return last;
    }


    public static boolean intoJavaInterfaceCheckPalindrome(Queue<Character> queueData) {
        if (!queueData.isEmpty()) {
            position = 0;
            palindrome = true;
            queue = queueData;
            recursive(queueData);
        }
        return palindrome;
    }
}
