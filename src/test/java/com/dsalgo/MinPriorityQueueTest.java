package com.dsalgo;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinPriorityQueueTest {

    @Test
    public void minPriorityQueueOp() {
        MinPriorityQueue minPriorityQueue = new MinPriorityQueue(10);
        minPriorityQueue.offer(23);
        minPriorityQueue.offer(21);
        minPriorityQueue.offer(2);
        minPriorityQueue.offer(18);
        minPriorityQueue.offer(19);
        minPriorityQueue.offer(15);
        minPriorityQueue.display();
        System.out.println();
        System.out.println(minPriorityQueue.decreasePriority(2, 1));
        System.out.println(minPriorityQueue.decreasePriority(3, -1));
        System.out.println(minPriorityQueue.decreasePriority(3, 100));
        minPriorityQueue.display();
        System.out.println();
        System.out.println(minPriorityQueue.peek());
        System.out.println(minPriorityQueue.poll());
        System.out.println(minPriorityQueue.poll());
        System.out.println(minPriorityQueue.poll());
        System.out.println(minPriorityQueue.poll());
        System.out.println(minPriorityQueue.poll());
        System.out.println(minPriorityQueue.poll());
        System.out.println(minPriorityQueue.poll());
        minPriorityQueue.display();
    }

}