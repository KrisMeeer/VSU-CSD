import java.util.LinkedList;

public class NestedQueue {
    private static LinkedList<LinkedList<Integer>> queue;

    public static LinkedList<LinkedList<Integer>> getQueue() {
        return queue;
    }

    public NestedQueue(int n) {
        queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            LinkedList<Integer> nestedQueue = new LinkedList<>();
            for (int j = 1; j <= i; j++) {
                nestedQueue.add(j);
            }
            queue.add(nestedQueue);
        }
    }
}

