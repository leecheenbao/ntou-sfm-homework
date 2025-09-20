package com.ntou.testing;

public class TestMain {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        NumberProcessor processor = new NumberProcessor();
        
        // 測試 gcd
        System.out.println("gcd(Integer.MAX_VALUE, Integer.MIN_VALUE) = " + 
                          calculator.gcd(Integer.MAX_VALUE, Integer.MIN_VALUE));
        
        // 測試 sumArray
        int[] testArray = {Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE};
        int result = processor.sumArray(testArray);
        System.out.println("sumArray([MAX_VALUE, MIN_VALUE, MAX_VALUE]) = " + result);
        
        // 計算期望值
        long expected = (long)Integer.MAX_VALUE + (long)Integer.MIN_VALUE + (long)Integer.MAX_VALUE;
        System.out.println("期望值 = " + expected);
        System.out.println("實際值 = " + result);
    }
}
