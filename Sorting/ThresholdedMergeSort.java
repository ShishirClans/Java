package com.example.demo;

import static com.example.demo.Merge.Merge;

public class ThresholdedMergeSort {
    public static void sort(int[] arr, int threshold) {
        thresholdedMergeSort(arr, 0, arr.length - 1, threshold);
    }

    private static void thresholdedMergeSort(int[] arr, int start, int end, int threshold) {
        if (end - start > threshold) {
            int middle = (start + end) / 2;
            thresholdedMergeSort(arr, start, middle, threshold);
            thresholdedMergeSort(arr, middle + 1, end, threshold);
            Merge(arr, start, middle, end);
        } else {
            // Apply Insertion Sort on a small part of the array
            InsertionSort.sort(arr,start,end);
        }
    }


}



