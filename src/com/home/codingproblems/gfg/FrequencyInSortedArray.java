package com.home.codingproblems.gfg;

import com.home.codingproblems.CommonUtils;
import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given a sorted array arr[] and a number x, write a function that counts the occurrences of x in arr[].
 * Expected time complexity is O(Logn).
 * Example -
 * Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 2
 * Output: 4 // x (or 2) occurs 4 times in arr[]
 */
public class FrequencyInSortedArray {

    public static void main(String[] args) {
        String inputString = CommonUtils.readInputAsString(
                "tst/com/home/codingproblems/gfg/FequencyInSortedArrayInput.txt");
        String[] inputList = CommonUtils.splitStringOnNewLine(inputString);
        int sizeOfArray = CommonUtils.parseInt(inputList[0]);
        int elementToBeSearched = CommonUtils.parseInt(inputList[1]);
        int arr[] = CommonUtils.getIntegerArrayFromString(inputList[2]);

        int count = binarySearch(arr, 0, sizeOfArray - 1, elementToBeSearched);
        System.out.println(count);
    }

    private static int binarySearch(int arr[], int low, int high, int elementToBeSearched) {
        if (low == high) {
            if (arr[low] == elementToBeSearched) {
                return 1;
            }
            return 0;
        }
        int mid = (low + high) / 2;
        int count = 0;
        int leftCount = 0;
        int rightCount = 0;
        if (high < low) {
            return 0;
        }
        if (arr[mid] == elementToBeSearched) {
            count++;
            leftCount = binarySearch(arr, low, mid - 1, elementToBeSearched);
            rightCount = binarySearch(arr, mid + 1, high, elementToBeSearched);

        } else if (arr[mid] > elementToBeSearched) {
            leftCount = binarySearch(arr, low, mid - 1, elementToBeSearched);
        } else {
            rightCount = binarySearch(arr, mid + 1, high, elementToBeSearched);
        }
        return count + leftCount + rightCount;
    }
}
