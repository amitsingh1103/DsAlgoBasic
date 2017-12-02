package com.dsalgo;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxHeapTest {

    @Test
    public void buildMaxHeap() {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        MaxHeap maxHeap = new MaxHeap(arr);
        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }

    @Test
    public void pollMax() {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        MaxHeap maxHeap = new MaxHeap(arr);
        System.out.println();
        for (int i : arr) {
            System.out.print(i + ", ");
        }

        System.out.println();
        maxHeap.pollMax();
        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }
}