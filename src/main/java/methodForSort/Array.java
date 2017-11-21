package methodForSort;

import sun.rmi.runtime.Log;

public class Array {
    private long[] theArray;
    private int nElems;

    public Array(int max) {
        theArray = new long[max];
        nElems = 0;
    }

    public void insert(long val) {
        theArray[nElems] = val;
        nElems++;
    }

    public int size() {
        return nElems;
    }

    public void display() {
        for (int j = 0; j < nElems; j++)
            System.out.print(theArray[j] + " ");
        System.out.println("");
    }

    /**
     * 冒泡排序 O(n^2)
     */
    public void bubbleSort() {
        int out, in;
        for (out = nElems - 1; out > 1; out--) {
            for (in = 0; in < out; in++)
                if (theArray[in] < theArray[in + 1])
                    swap(in, in + 1);
        }
    }

    /**
     * 选择排序 O(n^2)  交换次数减少 比冒泡排序快
     */
    public void selectionSort() {
        int out, in, min;
        for (out = 0; out < nElems - 1; out++) {
            min = out;
            for (in = out + 1; in < nElems; in++)
                if (theArray[in] < theArray[min])
                    min = in;
            swap(out, min);
        }
    }

    /**
     * 插入排序 对于随机的O(n^2)，对基本有序的O(n)
     */
    public void insertionSort() {
        int in, out;
        for (out = 1; out < nElems; out++) {
            long temp = theArray[out];
            in = out;
            while (in > 0 && theArray[in - 1] >= temp) {
                theArray[in] = theArray[in - 1];
                --in;
            }
            theArray[in] = temp;
        }
    }

    /**
     * 希尔排序 O(N^(3/2)到N^(7/6)之间 ) 比插入排序快 比快速排序慢
     * 将增量应用到插入排序 逐渐减少增量
     */
    public void shellSort() {
        int in, out;
        long temp;
        int h = 1;
        while (h <= nElems / 3)
            h = h * 3 + 1;
        while (h > 0) {
            for (out = h; out < nElems; out++) {
                temp = theArray[out];
                in = out;
                while (in > h - 1 && theArray[in - h] >= temp) {
                    theArray[in] = theArray[in - h];
                    in -= h;
                }
                theArray[in] = temp;
            }
            h = (h - 1) / 3;
        }
    }

    /**
     * 划分O(N)
     */
    public int partitionIt(int left, int right, long pivot) {
        int leftPtr = left - 1;
        int rightPtr = right + 1;
        while (true) {
            while (leftPtr < right && theArray[++leftPtr] < pivot) ;
            while (rightPtr > left && theArray[--rightPtr] > pivot) ;
            if (leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr, rightPtr);
        }
        return leftPtr;
    }

    /**
     * 快速排序O(N*logN)
     */
    public void quickSort() {
        recQuickSort(0, nElems - 1);
    }

    public void recQuickSort(int left, int right) {
        if (right - left <= 0)
            return;
        else {
            long pivot = theArray[right];
            int partition = partitionIt(left, right, pivot);
            recQuickSort(left, partition - 1);
            recQuickSort(partition, right);
        }
    }

    /**
     * 归并排序O(N*logN）
     */
    public void mergeSort() {
        long[] workSpace = new long[nElems];
        recMergeSort(workSpace, 0, nElems - 1);
    }

    private void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound)
            return;
        else {
            int mid = (lowerBound + upperBound) / 2;
            recMergeSort(workSpace, lowerBound, mid);
            recMergeSort(workSpace, mid + 1, upperBound);
            merge(workSpace, lowerBound, mid + 1, upperBound);
//            display();
        }
    }

    private void merge(long[] workSpace, int lowPtr, int highPtr, int upperBound) {
        int j = 0;
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1;
        while (lowPtr <= mid && highPtr <= upperBound)
            if (theArray[lowPtr] < theArray[highPtr])
                workSpace[j++] = theArray[lowPtr++];
            else
                workSpace[j++] = theArray[highPtr++];
        while (lowPtr <= mid)
            workSpace[j++] = theArray[lowPtr++];
        while (highPtr <= upperBound)
            workSpace[j++] = theArray[highPtr++];
        for (j = 0; j < n; j++) {
            theArray[lowerBound + j] = workSpace[j];
        }
    }

    public void swap(int one, int two) {
        long temp = theArray[one];
        theArray[one] = theArray[two];
        theArray[two] = temp;
    }

}