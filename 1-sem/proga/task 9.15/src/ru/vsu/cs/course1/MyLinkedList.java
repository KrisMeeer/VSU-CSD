package ru.vsu.cs.course1;
import java.util.ArrayList;
public class MyLinkedList<Integer> {
    private class ListNode {
        private Integer value; //значение
        private ListNode next = null;
        private ListNode prev = null;
        public ListNode (Integer value){
            this.value = value;
        }
}
    private int size = 0;
    private ListNode head = null;
    private ListNode tail = null;
    private void addTailNode(Integer value) {
        ListNode listNode = new ListNode(value);
        listNode.next = null;
        if (tail == null) {
            head = listNode;
            tail = head;
        } else {
            tail.next = listNode;
            listNode.prev = tail;
            tail = listNode;
        }
    }

    public boolean add(Integer t) {
        addTailNode(t);
        size++;
        return true;
    }

    public void getList(ArrayList<Integer> list){
        for (Integer i:list ){
            add(i);
        }
    }

    public ArrayList<Integer> getIntegerList() {
        ArrayList<Integer> res = new ArrayList<>();
        ListNode cur = head;
        for (int i = 0; i < size; i++) {
            res.add(cur.value);
            cur = cur.next;
        }
        return res;
    }
    public Integer circle(int N, int k){
        ListNode current = head;
        ListNode previous = tail;
        int count = 1;

        while (size > 1) {
            for (int i = 1; i < k; i++) {
                current = current.next;
                if (current == null) {
                    current = head;
                }
            }

            ListNode nextNode = current.next;
            if (current == head) {
                head = nextNode;
            } else {
                previous.next = nextNode;
            }

            current = nextNode;

            size--;
            count++;

            if (count == N) {
                break;
            }
        }

        return current.value;
    }
}