package com.dsalgo;

import java.util.ArrayList;
import java.util.List;

public class MinPriorityQueue {

    private int[] minHeap;
    int minHeapSize;
    private int capacity = 100;

    public MinPriorityQueue() {
        minHeap = new int[capacity];
    }

    public MinPriorityQueue(int capacity) {
        minHeap = new int[capacity];
        this.capacity = capacity;
    }

    public int peek() {
        if (minHeapSize <= 0) {
            throw new IllegalStateException("Empty priority queue");
        }
        return minHeap[0];
    }

    public int poll() {
        if (minHeapSize <= 0) {
            throw new IllegalStateException("Empty priority queue");
        }
        int min = minHeap[0];
        minHeap[0] = minHeap[minHeapSize - 1];
        minHeapSize--;
        minHeapify(0);
        return min;
    }

    public int decreasePriority(int i, int val) {
        if (minHeapSize <= 0) {
            throw new IllegalStateException("Empty priority queue");
        }
        if (minHeap[i] <= val) {
            return minHeap[i];
        }

        minHeap[i] = val;
        while (i >= 0 && val < minHeap[getParent(i)]) {
            swap(i, getParent(i));
            i = getParent(i);
        }
        return val;
    }

    public void offer(int val) {
        if (minHeapSize >= capacity - 1) {
            throw new IllegalStateException("Heap is full");
        }

        minHeapSize++;
        minHeap[minHeapSize - 1] = Integer.MAX_VALUE;
        decreasePriority(minHeapSize - 1, val);
    }

    public void display() {
        for (int i = 0; i < minHeapSize; i++) {
            System.out.print(minHeap[i] + ", ");
        }
    }

    private void minHeapify(int i) {
        if (i < 0) {
            return;
        }

        int l = getLeft(i);
        int r = getRight(i);
        int smallest = i;
        if (l < minHeapSize && minHeap[i] > minHeap[l]) {
            smallest = l;
        }
        if (r < minHeapSize && minHeap[smallest] > minHeap[r]) {
            smallest = r;
        }

        if (smallest != i) {
            swap(smallest, i);
            minHeapify(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = minHeap[i];
        minHeap[i] = minHeap[j];
        minHeap[j] = temp;
    }

    private int getParent(int i) {
        return (i - 1) / 2;
    }

    private int getLeft(int i) {
        return 2*i + 1;
    }

    private int getRight(int i) {
        return 2*i + 2;
    }
}
