package ru.vsu.solution.util.LogicOfArray;

import ru.vsu.solution.scroll.MyQueue;
import ru.vsu.solution.scroll.VeryWellQueue;

public class LogicAboutVeryWellQueue {

    private static boolean palindrome;
    private static VeryWellQueue<Character> queue;
    private static int position = 0;

    public static VeryWellQueue<Character> arrayInQueue(char[] array) {
        VeryWellQueue<Character> queue = new MyQueue<>();
        for (int i = 0; i < array.length; i++) {
            queue.offer(array[i]);
        }

        return queue;
    }



    private static void recursive() throws Exception {
        if (queue!=null) {
            char nowNumber = queue.poll();
            queue.offer(nowNumber);
            position++;
            int center = queue.size()/2;
            if (position<=center){
                if (queue.size()%2==0 && position<center|| queue.size()%2==1) {
                    recursive();
                }
                char nextNumber = queue.poll();
                queue.offer(nextNumber);
                if (nextNumber!=nowNumber){
                    palindrome = false;
                }
            }
        }
    }


    public static boolean intoMyInterfaceCheckPalindrome(VeryWellQueue<Character> queueData) throws Exception {
        if (queueData.size()!=0) {
            position = 0;
            palindrome = true;
            queue = queueData;
            recursive();
        }
        return palindrome;
    }
}
