package com.ntou.testing;

/**
 * 數字處理器類別 - 包含多種條件判斷和迴圈的測試程式範例
 * 用於軟體正規方法期末報告項目
 */
public class NumberProcessor {

    /**
     * 計算質數個數
     * 
     * @param n 上限
     * @return 小於等於 n 的質數個數
     */
    public int countPrimes(int n) {
        try {
            if (n < 2) {
                return 0;
            }

            if (n < 0 || n > 65535) {
                throw new IllegalArgumentException("數值應該介於 0 到 65535 之間");
            }

            int count = 0;
            for (int i = 2; i <= n; i++) {
                boolean isPrime = true;
                for (int j = 2; j * j <= i; j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    count++;
                }
            }

            return count;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    /**
     * 尋找陣列中的最大值
     * 
     * @param numbers 整數陣列
     * @return 最大值，如果陣列為空則返回 Integer.MIN_VALUE
     */
    public int findMax(int[] numbers) { // Line 1
        if (numbers == null || numbers.length == 0) { // Line 2
            return Integer.MIN_VALUE; // Line 3
        }

        int max = numbers[0]; // Line 4
        for (int i = 1; i < numbers.length; i++) { // Line 5, 6
            if (numbers[i] > max) { // Line 7
                max = numbers[i]; // Line 8
            } // Line 9
        } // Line 10

        return max; // Line 11
    }

    // ==================== 變異版本方法（用於測試） ====================
    
    /**
     * 變異版本 1: line7 將 > 改為 <
     */
    public int findMaxMutations1(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return Integer.MIN_VALUE;
        }

        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < max) { // 變異: > 改為 <
                max = numbers[i];
            }
        }

        return max;
    }

    /**
     * 變異版本 2: line2 將 == 改為 !=
     */
    public int findMaxMutations2(int[] numbers) {
        if (numbers == null || numbers.length != 0) { // 變異: == 改為 !=
            return Integer.MIN_VALUE;
        }

        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        return max;
    }

    /**
     * 變異版本 3: line6 將 1 改為 4
     */
    public int findMaxMutations3(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return Integer.MIN_VALUE;
        }

        int max = numbers[0];
        for (int i = 4; i < numbers.length; i++) { // 變異: 1 改為 4
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        return max;
    }

    /**
     * 變異版本 4: line8 將 i 改為 0
     */
    public int findMaxMutations4(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return Integer.MIN_VALUE;
        }

        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[0]; // 變異: i 改為 0
            }
        }

        return max;
    }

    /**
     * 變異版本 5: line11 將 max 改為 1
     */
    public int findMaxMutations5(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return Integer.MIN_VALUE;
        }

        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        return 1; // 變異: max 改為 1
    }
}
