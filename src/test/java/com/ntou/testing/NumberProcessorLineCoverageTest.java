package com.ntou.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

/**
 * NumberProcessor 類別的 Line Coverage 測試
 * 目標：使用最少的測試案例達到 100% Line Coverage
 */
public class NumberProcessorLineCoverageTest {
    
    private NumberProcessor processor;
    
    @BeforeEach
    void setUp() {
        processor = new NumberProcessor();
    }
    
    /**
     * 測試 classifyNumber 方法 - Line Coverage 100%
     * 
     * 程式行數分析：
     * Line 1: public String classifyNumber(int number) {
     * Line 2: if (number < 0) {
     * Line 3: return "NEGATIVE";
     * Line 4: } else if (number == 0) {
     * Line 5: return "ZERO";
     * Line 6: } else if (number <= 10) {
     * Line 7: return "SMALL";
     * Line 8: } else if (number <= 100) {
     * Line 9: return "MEDIUM";
     * Line 10: } else {
     * Line 11: return "LARGE";
     * Line 12: }
     * 
     * 最少測試案例：5個
     */
    @Test
    void testClassifyNumber_LineCoverage100() {
        // Test Case 1: 負數
        // 1) Input values: number = -1
        // 2) Expected result: "NEGATIVE"
        // 3) Test program's result: "NEGATIVE"
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 3
        assertThat(processor.classifyNumber(-1)).isEqualTo("NEGATIVE");
        
        // Test Case 2: 零
        // 1) Input values: number = 0
        // 2) Expected result: "ZERO"
        // 3) Test program's result: "ZERO"
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 4, 5
        assertThat(processor.classifyNumber(0)).isEqualTo("ZERO");
        
        // Test Case 3: 小數
        // 1) Input values: number = 5
        // 2) Expected result: "SMALL"
        // 3) Test program's result: "SMALL"
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 4, 6, 7
        assertThat(processor.classifyNumber(5)).isEqualTo("SMALL");
        
        // Test Case 4: 中等數
        // 1) Input values: number = 50
        // 2) Expected result: "MEDIUM"
        // 3) Test program's result: "MEDIUM"
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 4, 6, 8, 9
        assertThat(processor.classifyNumber(50)).isEqualTo("MEDIUM");
        
        // Test Case 5: 大數
        // 1) Input values: number = 150
        // 2) Expected result: "LARGE"
        // 3) Test program's result: "LARGE"
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 4, 6, 8, 10, 11
        assertThat(processor.classifyNumber(150)).isEqualTo("LARGE");
        
        // Line coverage: 100%
    }
    
    /**
     * 測試 sumArray 方法 - Line Coverage 100%
     * 
     * 程式行數分析：
     * Line 1: public int sumArray(int[] numbers) {
     * Line 2: if (numbers == null || numbers.length == 0) {
     * Line 3: return 0;
     * Line 4: }
     * Line 5: int sum = 0;
     * Line 6: int i = 0;
     * Line 7: while (i < numbers.length) {
     * Line 8: sum += numbers[i];
     * Line 9: i++;
     * Line 10: }
     * Line 11: return sum;
     * 
     * 最少測試案例：2個
     */
    @Test
    void testSumArray_LineCoverage100() {
        // Test Case 1: null 或空陣列
        // 1) Input values: numbers = null
        // 2) Expected result: 0
        // 3) Test program's result: 0
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 3
        assertThat(processor.sumArray(null)).isEqualTo(0);
        
        // Test Case 2: 非空陣列
        // 1) Input values: numbers = [1, 2, 3]
        // 2) Expected result: 6
        // 3) Test program's result: 6
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 4, 5, 6, 7, 8, 9, 10, 11
        assertThat(processor.sumArray(new int[]{1, 2, 3})).isEqualTo(6);
        
        // Line coverage: 100%
    }
    
    /**
     * 測試 findMax 方法 - Line Coverage 100%
     * 
     * 程式行數分析：
     * Line 1: public int findMax(int[] numbers) {
     * Line 2: if (numbers == null || numbers.length == 0) {
     * Line 3: return Integer.MIN_VALUE;
     * Line 4: }
     * Line 5: int max = numbers[0];
     * Line 6: for (int i = 1; i < numbers.length; i++) {
     * Line 7: if (numbers[i] > max) {
     * Line 8: max = numbers[i];
     * Line 9: }
     * Line 10: }
     * Line 11: return max;
     * 
     * 最少測試案例：3個
     */
    @Test
    void testFindMax_LineCoverage100() {
        // Test Case 1: null 或空陣列
        // 1) Input values: numbers = null
        // 2) Expected result: Integer.MIN_VALUE
        // 3) Test program's result: Integer.MIN_VALUE
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 3
        assertThat(processor.findMax(null)).isEqualTo(Integer.MIN_VALUE);
        
        // Test Case 2: 空陣列
        // 1) Input values: numbers = []
        // 2) Expected result: Integer.MIN_VALUE
        // 3) Test program's result: Integer.MIN_VALUE
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 3
        assertThat(processor.findMax(new int[]{})).isEqualTo(Integer.MIN_VALUE);
        
        // Test Case 3: 單元素陣列
        // 1) Input values: numbers = [5]
        // 2) Expected result: 5
        // 3) Test program's result: 5
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 4, 5, 6, 11 (迴圈不執行)
        assertThat(processor.findMax(new int[]{5})).isEqualTo(5);
        
        // Test Case 4: 多元素陣列，有更新最大值
        // 1) Input values: numbers = [1, 5, 3]
        // 2) Expected result: 5
        // 3) Test program's result: 5
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 4, 5, 6, 7, 8, 9, 10, 11
        assertThat(processor.findMax(new int[]{1, 5, 3})).isEqualTo(5);
        
        // Line coverage: 100%
    }
    
    
    /**
     * 測試 complexBooleanLogic 方法 - Line Coverage 100%
     */
    @Test
    void testComplexBooleanLogic_LineCoverage100() {
        // Test Case 1: 滿足第一個條件和第二個條件
        // 1) Input values: a=true, b=true, c=false, d=false
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 3, 4
        assertThat(processor.complexBooleanLogic(true, true, false, false)).isTrue();
        
        // Test Case 2: 滿足第一個條件但不滿足第二個條件
        // 1) Input values: a=false, b=false, c=true, d=true
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 3, 4
        assertThat(processor.complexBooleanLogic(false, false, true, true)).isTrue();
        
        
        // Test Case 3: 不滿足第一個條件但滿足第三個條件
        // 1) Input values: a=true, b=false, c=false, d=false
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 7, 8, 9
        assertThat(processor.complexBooleanLogic(true, false, false, false)).isFalse();
        
        // Test Case 4: 不滿足任何條件
        // 1) Input values: a=false, b=false, c=false, d=false
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 7, 8, 10, 11
        assertThat(processor.complexBooleanLogic(false, false, false, false)).isFalse();
        
        // Line coverage: 100%
    }
    
    /**
     * 測試 countPrimes 方法 - Line Coverage 100%
     * 
     * 程式行數分析：
     * Line 1: public int countPrimes(int n) {
     * Line 2: if (n < 2) {
     * Line 3: return 0;
     * Line 4: }
     * Line 5: int count = 0;
     * Line 6: for (int i = 2; i <= n; i++) {
     * Line 7: boolean isPrime = true;
     * Line 8: for (int j = 2; j * j <= i; j++) {
     * Line 9: if (i % j == 0) {
     * Line 10: isPrime = false;
     * Line 11: break;
     * Line 12: }
     * Line 13: }
     * Line 14: if (isPrime) {
     * Line 15: count++;
     * Line 16: }
     * Line 17: }
     * Line 18: return count;
     * 
     * 最少測試案例：3個
     */
    @Test
    void testCountPrimes_LineCoverage100() {
        // Test Case 1: n < 2
        // 1) Input values: n = 1
        // 2) Expected result: 0
        // 3) Test program's result: 0
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 3
        assertThat(processor.countPrimes(1)).isEqualTo(0);
        
        // Test Case 2: n = 2 (最小質數)
        // 1) Input values: n = 2
        // 2) Expected result: 1
        // 3) Test program's result: 1
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 4, 5, 6, 7, 8, 13, 14, 15, 16, 17, 18
        assertThat(processor.countPrimes(2)).isEqualTo(1);
        
        // Test Case 3: n = 10 (包含非質數)
        // 1) Input values: n = 10
        // 2) Expected result: 4 (2, 3, 5, 7)
        // 3) Test program's result: 4
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18
        assertThat(processor.countPrimes(10)).isEqualTo(4);
        
        // Line coverage: 100%
    }
}
