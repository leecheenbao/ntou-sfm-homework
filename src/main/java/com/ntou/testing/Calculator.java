package com.ntou.testing;

/**
 * 計算機類別 - 包含條件判斷和迴圈的測試程式範例
 * 用於軟體正規方法期末報告項目
 */
public class Calculator {
    
    /**
     * 判斷數字是否為正數
     * @param i 要判斷的整數
     * @return true 如果 i >= 0，否則 false
     */
    public boolean isPositive(int i) { // Line 1
        if (i >= 0) { // Line 2
            return true; // Line 3
        } else { // Line 4
            return false; // Line 5
        }
    }
    
    /**
     * 計算階乘
     * @param n 非負整數
     * @return n 的階乘
     */
    public long factorial(int n) { // Line 1
        if (n < 0) { // Line 2
            return -1; // Line 3 (錯誤值)
        }
        
        long result = 1; // Line 4
        int i = 1; // Line 5
        
        while (i <= n) { // Line 6
            result *= i; // Line 7
            i++; // Line 8
        } // Line 9
        
        return result; // Line 10
    }
    
    /**
     * 計算兩個數的最大公約數
     * @param a 第一個整數
     * @param b 第二個整數
     * @return a 和 b 的最大公約數
     */
    public int gcd(int a, int b) { // Line 1
        if (a < 0) a = -a; // Line 2
        if (b < 0) b = -b; // Line 3
        
        if (a == 0 && b == 0) { // Line 4
            return -1; // Line 5 (錯誤值)
        }
        
        if (a == 0) return b; // Line 6
        if (b == 0) return a; // Line 7
        
        while (b != 0) { // Line 8
            int temp = b; // Line 9
            b = a % b; // Line 10
            a = temp; // Line 11
        } // Line 12
        
        return a; // Line 13
    }
    
    /**
     * 複雜條件判斷函數 - 用於邏輯表達式測試
     * @param x 第一個條件
     * @param y 第二個條件
     * @param z 第三個條件
     * @return 邏輯運算結果
     */
    public boolean complexLogic(boolean x, boolean y, boolean z) { // Line 1
        if (x && y || z) { // Line 2 (複合邏輯條件)
            if (x || y && z) { // Line 3 (另一個複合邏輯條件)
                return true; // Line 4
            } else { // Line 5
                return false; // Line 6
            }
        } else { // Line 7
            return false; // Line 8
        }
    }
    
    /**
     * 陣列處理函數 - 用於輸入域測試
     * @param numbers 整數陣列
     * @return 處理結果
     */
    public String processArray(int[] numbers) { // Line 1
        if (numbers == null) { // Line 2
            return "NULL"; // Line 3
        }
        
        if (numbers.length == 0) { // Line 4
            return "EMPTY"; // Line 5
        }
        
        if (numbers.length == 1) { // Line 6
            return "SINGLE"; // Line 7
        }
        
        return "MULTIPLE"; // Line 8
    }
    
    /**
     * 邊界值測試函數
     * @param value 要測試的值
     * @return 處理結果
     */
    public String boundaryTest(int value) { // Line 1
        if (value < 10) { // Line 2
            return "LOW"; // Line 3
        } else if (value == 10) { // Line 4
            return "BOUNDARY_LOW"; // Line 5
        } else if (value < 100) { // Line 6
            return "MIDDLE"; // Line 7
        } else if (value == 100) { // Line 8
            return "BOUNDARY_HIGH"; // Line 9
        } else { // Line 10
            return "HIGH"; // Line 11
        }
    }
}
