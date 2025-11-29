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
}
