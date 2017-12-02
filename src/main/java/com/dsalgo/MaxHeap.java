package com.dsalgo;

public class MaxHeap {

    private int[] heap;
    private int heapSize;

    public MaxHeap() {
        heap = new int[0];
        heapSize = heap.length;
    }

    public MaxHeap(int heapSize) {
        heap = new int[heapSize];
        this.heapSize = heapSize;
    }

    public MaxHeap(int[] arr) {
        buildMaxHeap(arr);
    }

    // Get the parent index
    public int getParent(int i) {
        return (i - 1) / 2;
    }

    // Get left child index
    public int getLeft(int i) {
        return 2*i + 1;
    }

    // Get right child index
    public int getRight(int i) {
        return 2*i + 2;
    }

    // Get the size of the max heap
    public int getMaxHeapSize() {
        return heapSize;
    }

    // peek the max element of maxHeap. Do not remove.
    public int peekMax() {
        if (heapSize <= 0) {
            throw new IllegalStateException("Empty Heap");
        }
        return heap[0];
    }

    // Maintain max-heap property. Top to down approach
    public void maxHeapify(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Index out of bound");
        }

        int l = getLeft(i);
        int r = getRight(i);
        int largest = i;
        if (l < heapSize && heap[i] < heap[l]) {
            largest = l;
        }
        if (r < heapSize && heap[largest] < heap[r]) {
            largest = r;
        }

        if (largest != i) {
            swap(largest, i);
            maxHeapify(largest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Poll max from max-heap. Remove the max element
    public int pollMax() {
        if (heapSize <= 0) {
            throw new IllegalStateException("Empty Heap");
        }
        int max = heap[0];
        heap[0] = heap[heapSize - 1];
        heapSize -= 1;
        maxHeapify(0);
        return max;
    }

    // Create max heap
    public void buildMaxHeap(int[] arr) {
        heap = arr;
        heapSize = arr.length;
        for (int i = (heapSize - 1) / 2; i >= 0; i--) {
            maxHeapify(i);
        }
    }
}
