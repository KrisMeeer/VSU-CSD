package ru.vsu.solution.Logic;

import ru.vsu.solution.scroll.MyQueue;
import ru.vsu.solution.scroll.VeryWellQueue;

public class LogicAboutVeryWellQueue {

    private static int count = 0;
    private static boolean palindrome = true;
    private static int realDifference = 0;

    public static VeryWellQueue<Character> arrayInQueue(char[] array) {
        VeryWellQueue<Character> queue = new MyQueue<>();
        for (int i = 0; i < array.length; i++) {
            queue.offer(array[i]);
        }

        return queue;
    }



    public static boolean intoMyInterfaceCheckPalindrome(VeryWellQueue<Character> queue) throws Exception {
        if (queue.size() != 0) {
            recursive(queue);
            palindrome = true;
        } else palindrome = false;
        return palindrome;
    }

    private static void recursive(VeryWellQueue<Character> queue) throws Exception {
        if (queue!=null) {
            char nowNumber;
            char numberOfEnd;

            nowNumber = queue.poll();
            queue.offer(nowNumber);
            count++;
            realDifference++;
            numberOfEnd = numberOfEnd(count, queue);
            if (count + realDifference > (queue.size() - queue.size() % 2)) {
                nowNumber = '0';
                numberOfEnd = '0';
            }

            if (numberOfEnd != nowNumber) {
                palindrome = false;
            }
            if (count < queue.size()) {
                recursive(queue);
            }
        }
    }



    private static char numberOfEnd(int pos, VeryWellQueue<Character> queue) throws Exception {
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
}
