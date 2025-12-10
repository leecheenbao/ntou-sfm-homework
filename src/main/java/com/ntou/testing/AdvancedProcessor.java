package com.ntou.testing;

public class AdvancedProcessor {

    /**
     * Processes an array of integers based on a threshold and specific rules.
     * It calculates the sum of numbers greater than the threshold, with special conditions:
     * - If -1 is encountered, it immediately returns -1.
     * - If any other negative number is encountered, it resets the current sum and count.
     * - It accumulates a maximum of 3 qualifying numbers.
     *
     * @param numbers The input array of integers.
     * @param threshold The threshold value.
     * @return The calculated sum or -1 if the special condition is met.
     */
    public int processArray(int[] numbers, int threshold) {
        int currentSum = 0;
        int countQualified = 0;

        if (numbers == null || numbers.length == 0) {
            return 0; // Handle empty or null array
        }

        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
//            System.out.println("num :"+num);
            if (num == -1) { //num 等於-1 return -1
                return -1; 
            } else if (num < 0) { //num 小於 0 及 不等於 -1 時 reset currentSum
                currentSum = 0;
                countQualified = 0;
            } else if (num > threshold) {  //大於threshold，countQualified 時加總
                if (countQualified < 3) { 
                    currentSum += num;
                    countQualified++;
                } 

            }
        }
//        System.out.println("currentSum :"+currentSum);
        return currentSum;
    }

    public static void main(String[] args) {
        AdvancedProcessor processor = new AdvancedProcessor();

        // Test Case 1: Standard processing
//        int[] arr1 = {1, 2, 10, 3, 20, 4, 30, 5, 40};
//        System.out.println("Array: {1, 2, 10, 3, 20, 4, 30, 5, 40}, Threshold: 5, Expected: 60 (10+20+30), Actual: " + processor.processArray(arr1, 5));

        // Test Case 2: Encounter -1
//        int[] arr2 = {1, 2, 10, -1, 20};
//        System.out.println("Array: {1, 2, 10, -1, 20}, Threshold: 5, Expected: -1, Actual: " + processor.processArray(arr2, 5));
//
//        // Test Case 3: Encounter other negative number, then continue
//        int[] arr3 = {1, 2, 10, -5, 20, 6, 30};
//        System.out.println("Array: {1, 2, 10, -5, 20, 6, 30}, Threshold: 5, Expected: 56 (20+6+30), Actual: " + processor.processArray(arr3, 5));
//
//        // Test Case 4: Not enough qualified numbers
//        int[] arr4 = {1, 2, 3, 4, 5, 6};
//        System.out.println("Array: {1, 2, 3, 4, 5, 6}, Threshold: 5, Expected: 6, Actual: " + processor.processArray(arr4, 5));
//
//        // Test Case 5: All numbers below threshold
//        int[] arr5 = {1, 2, 3, 4, 5};
//        System.out.println("Array: {1, 2, 3, 4, 5}, Threshold: 5, Expected: 0, Actual: " + processor.processArray(arr5, 5));
//
//        // Test Case 6: Empty array
//        int[] arr6 = {};
//        System.out.println("Array: {}, Threshold: 5, Expected: 0, Actual: " + processor.processArray(arr6, 5));
//
//        // Test Case 7: Null array
//        System.out.println("Array: null, Threshold: 5, Expected: 0, Actual: " + processor.processArray(null, 5));
//
//        // Test Case 8: Qualified numbers at the beginning, then reset  x
//        int[] arr8 = {10, 20, -2, 5, 6, 7};
//        System.out.println("Array: {10, 20, -2, 5, 6, 7}, Threshold: 5, Expected: 13 (6+7), Actual: " + processor.processArray(arr8, 5));
//
//        // Test Case 9: More than 3 qualified numbers after reset  
        int[] arr9 = {-2, 10, 20, 30, 40, 50};
        System.out.println("Array: {-2, 10, 20, 30, 40, 50}, Threshold: 5, Expected: 60 (10+20+30), Actual: " + processor.processArray(arr9, 5));

    }
}