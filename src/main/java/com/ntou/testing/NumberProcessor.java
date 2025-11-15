package com.ntou.testing;

/**
 * 數字處理器類別 - 包含多種條件判斷和迴圈的測試程式範例
 * 用於軟體正規方法期末報告項目
 */
public class NumberProcessor {

    /**
     * 判斷數字範圍並分類
     * 
     * @param number 要分類的數字
     * @return 分類結果字串
     */
    public String classifyNumber(int number) { // Line 1
        if (number < 0) { // Line 2
            return "NEGATIVE"; // Line 3
        } else if (number == 0) { // Line 4
            return "ZERO"; // Line 5
        } else if (number <= 10) { // Line 6
            return "SMALL"; // Line 7
        } else if (number <= 100) { // Line 8
            return "MEDIUM"; // Line 9
        } else { // Line 10
            return "LARGE"; // Line 11
        }
    }

    /**
     * 計算陣列中元素的總和
     * 
     * @param numbers 整數陣列
     * @return 總和，如果陣列為空則返回 0
     */
    public int sumArray(int[] numbers) { // Line 1
        if (numbers == null || numbers.length == 0) { // Line 2
            return 0; // Line 3
        }

        int sum = 0; // Line 4
        int i = 0; // Line 5

        while (i < numbers.length) { // Line 6
            sum += numbers[i]; // Line 7
            i++; // Line 8
        } // Line 9

        return sum; // Line 10
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
        for (int i = 1; i < numbers.length; i++) { // Line 5
            if (numbers[i] > max) { // Line 6
                max = numbers[i]; // Line 7
            } // Line 8
        } // Line 9

        return max; // Line 10
    }

    /**
     * 複雜的邏輯判斷函數 - 包含多個子條件
     * 
     * @param a 第一個布林值
     * @param b 第二個布林值
     * @param c 第三個布林值
     * @param d 第四個布林值
     * @return 邏輯運算結果
     */
    public boolean complexBooleanLogic(boolean a, boolean b, boolean c, boolean d) { // Line 1
        if ((a && b) || (c && d)) { // Line 2
            return true; // Line 3 - 簡化邏輯，因為 (a&&b)||(c&&d) 為 true 時，a||b||c||d 必定為 true
        } else { // Line 4
            if (a || b) { // Line 5
                return c || d; // Line 6
            } else { // Line 7
                return false; // Line 8
            }
        }
    }

    /**
     * 計算質數個數
     * 
     * @param n 上限
     * @return 小於等於 n 的質數個數
     */
    public int countPrimes(int n) {
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
    }
}
