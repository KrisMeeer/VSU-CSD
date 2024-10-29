package ru.vsu.solution;

import ru.vsu.solution.util.LogicOfArray.*;

import ru.vsu.solution.scroll.MyQueue;
import ru.vsu.solution.scroll.VeryWellQueue;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception { //throws IOException
        FrameMain windowApplication = new FrameMain();
      //  test();
    }

    public static void test() throws Exception {
        boolean rez;
        Queue<Character> queue = new LinkedList<>();
        VeryWellQueue<Character> queue1 = new MyQueue<>();

        // char[] arr = {'a','b', 'b','c','b','b', 'a'};
        char[] arr = {'1','2', '3','4','5','6', '7', '7','6','5','4','3','2','1'};

        queue1 = LogicAboutVeryWellQueue.arrayInQueue(arr);
    //    queue = LogicAboutJava.arrayInQueue(arr);
        while (queue1.size()!=0){
            System.out.print(queue1.poll());
        }
        System.out.println();
        queue1 = LogicAboutVeryWellQueue.arrayInQueue(arr);
     //   System.out.println(queue1);
        //rez = LogicAboutVeryWellQueue.intoMyInterface(queue1);
        //System.out.println(queue);
       rez = LogicAboutVeryWellQueue.intoMyInterfaceCheckPalindrome(queue1);
        System.out.println(rez);
        while (queue1.size()!=0){
            System.out.print(queue1.poll());
        }
        System.out.println();

    }
}