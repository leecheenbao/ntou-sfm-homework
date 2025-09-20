package com.ntou.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

/**
 * Calculator 類別的 Line Coverage 測試
 * 目標：使用最少的測試案例達到 100% Line Coverage
 */
public class CalculatorLineCoverageTest {
    
    private Calculator calculator;
    
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    
    /**
     * 測試 isPositive 方法 - Line Coverage 100%
     * 
     * 程式行數分析：
     * Line 1: boolean isPositive(int i) {
     * Line 2: if (i >= 0) {
     * Line 3: return true;
     * Line 4: } else {
     * Line 5: return false;
     * Line 6: }
     * 
     * 最少測試案例：2個
     * 測試案例1：涵蓋 Lines 1, 2, 3
     * 測試案例2：涵蓋 Lines 1, 2, 4, 5
     */
    @Test
    void testIsPositive_LineCoverage100() {
        // Test Case 1 (測試案例 1)
        // 1) Input values: i = 1
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 3
        assertThat(calculator.isPositive(1)).isTrue();
        
        // Test Case 2 (測試案例 2)
        // 1) Input values: i = -1
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 4, 5
        
        assertThat(calculator.isPositive(-1)).isFalse();
        
        // 總共涵蓋 Lines: 1, 2, 3, 4, 5
        // Line coverage: 100%
    }
    
    /**
     * 測試 factorial 方法 - Line Coverage 100%
     * 
     * 程式行數分析：
     * Line 1: public long factorial(int n) {
     * Line 2: if (n < 0) {
     * Line 3: return -1;
     * Line 4: }
     * Line 5: long result = 1;
     * Line 6: int i = 1;
     * Line 7: while (i <= n) {
     * Line 8: result *= i;
     * Line 9: i++;
     * Line 10: }
     * Line 11: return result;
     * 
     * 最少測試案例：3個
     * 測試案例1：n < 0，涵蓋 Lines 1, 2, 3
     * 測試案例2：n = 0，涵蓋 Lines 1, 2, 4, 5, 6, 7, 10, 11 (迴圈不執行)
     * 測試案例3：n > 0，涵蓋 Lines 1, 2, 4, 5, 6, 7, 8, 9, 10, 11 (迴圈執行)
     */
    @Test
    void testFactorial_LineCoverage100() {
        // Test Case 1 (測試案例 1)
        // 1) Input values: n = -1
        // 2) Expected result: -1
        // 3) Test program's result: -1
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 3
        assertThat(calculator.factorial(-1)).isEqualTo(-1);
        
        // Test Case 2 (測試案例 2)
        // 1) Input values: n = 0
        // 2) Expected result: 1
        // 3) Test program's result: 1
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 4, 5, 6, 7, 10, 11
        assertThat(calculator.factorial(0)).isEqualTo(1);
        
        // Test Case 3 (測試案例 3)
        // 1) Input values: n = 3
        // 2) Expected result: 6
        // 3) Test program's result: 6
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 4, 5, 6, 7, 8, 9, 10, 11
        assertThat(calculator.factorial(3)).isEqualTo(6);
        
        // 總共涵蓋 Lines: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
        // Line coverage: 100%
    }
    
    /**
     * 測試 gcd 方法 - Line Coverage 100%
     * 
     * 程式行數分析：
     * Line 1: public int gcd(int a, int b) {
     * Line 2: if (a < 0) a = -a;
     * Line 3: if (b < 0) b = -b;
     * Line 4: if (a == 0 && b == 0) {
     * Line 5: return -1;
     * Line 6: }
     * Line 7: if (a == 0) return b;
     * Line 8: if (b == 0) return a;
     * Line 9: while (b != 0) {
     * Line 10: int temp = b;
     * Line 11: b = a % b;
     * Line 12: a = temp;
     * Line 13: }
     * Line 14: return a;
     * 
     * 最少測試案例：4個
     */
    @Test
    void testGcd_LineCoverage100() {
        // Test Case 1 (測試案例 1)
        // 1) Input values: a = 0, b = 0
        // 2) Expected result: -1
        // 3) Test program's result: -1
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 3, 4, 5
        assertThat(calculator.gcd(0, 0)).isEqualTo(-1);
        
        // Test Case 2 (測試案例 2)
        // 1) Input values: a = 0, b = 5
        // 2) Expected result: 5
        // 3) Test program's result: 5
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 3, 4, 6, 7
        assertThat(calculator.gcd(0, 5)).isEqualTo(5);
        
        // Test Case 3 (測試案例 3)
        // 1) Input values: a = 5, b = 0
        // 2) Expected result: 5
        // 3) Test program's result: 5
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 3, 4, 6, 7, 8
        assertThat(calculator.gcd(5, 0)).isEqualTo(5);
        
        // Test Case 4 (測試案例 4)
        // 1) Input values: a = 12, b = 8
        // 2) Expected result: 4
        // 3) Test program's result: 4
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14
        assertThat(calculator.gcd(12, 8)).isEqualTo(4);
        
        // 總共涵蓋 Lines: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14
        // Line coverage: 100%
    }
    
    /**
     * 測試 complexLogic 方法 - Line Coverage 100%
     */
    @Test
    void testComplexLogic_LineCoverage100() {
        // Test Case 1: 滿足第一個條件，滿足第二個條件
        // 1) Input values: x = true, y = true, z = false
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 3, 4
        assertThat(calculator.complexLogic(true, true, false)).isTrue();
        
        // Test Case 2: 滿足第一個條件，不滿足第二個條件
        // 1) Input values: x = false, y = false, z = true
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 3, 5, 6
        assertThat(calculator.complexLogic(false, false, true)).isFalse();
        
        // Test Case 3: 不滿足第一個條件
        // 1) Input values: x = false, y = false, z = false
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 7, 8
        assertThat(calculator.complexLogic(false, false, false)).isFalse();
        
        // Line coverage: 100%
    }
    
    /**
     * 測試 processArray 方法 - Line Coverage 100%
     */
    @Test
    void testProcessArray_LineCoverage100() {
        // Test Case 1: null 陣列
        // 1) Input values: numbers = null
        // 2) Expected result: "NULL"
        // 3) Test program's result: "NULL"
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 3
        assertThat(calculator.processArray(null)).isEqualTo("NULL");
        
        // Test Case 2: 空陣列
        // 1) Input values: numbers = []
        // 2) Expected result: "EMPTY"
        // 3) Test program's result: "EMPTY"
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 4, 5
        assertThat(calculator.processArray(new int[0])).isEqualTo("EMPTY");
        
        // Test Case 3: 單元素陣列
        // 1) Input values: numbers = [1]
        // 2) Expected result: "SINGLE"
        // 3) Test program's result: "SINGLE"
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 4, 6, 7
        assertThat(calculator.processArray(new int[]{1})).isEqualTo("SINGLE");
        
        // Test Case 4: 多元素陣列
        // 1) Input values: numbers = [1, 2, 3]
        // 2) Expected result: "MULTIPLE"
        // 3) Test program's result: "MULTIPLE"
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 4, 6, 8
        assertThat(calculator.processArray(new int[]{1, 2, 3})).isEqualTo("MULTIPLE");
        
        // Line coverage: 100%
    }
    
    /**
     * 測試 boundaryTest 方法 - Line Coverage 100%
     */
    @Test
    void testBoundaryTest_LineCoverage100() {
        // Test Case 1: 小於下界
        // 1) Input values: value = 5
        // 2) Expected result: "LOW"
        // 3) Test program's result: "LOW"
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 3
        assertThat(calculator.boundaryTest(5)).isEqualTo("LOW");
        
        // Test Case 2: 下界值
        // 1) Input values: value = 10
        // 2) Expected result: "BOUNDARY_LOW"
        // 3) Test program's result: "BOUNDARY_LOW"
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 4, 5
        assertThat(calculator.boundaryTest(10)).isEqualTo("BOUNDARY_LOW");
        
        // Test Case 3: 中間值
        // 1) Input values: value = 50
        // 2) Expected result: "MIDDLE"
        // 3) Test program's result: "MIDDLE"
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 4, 6, 7
        assertThat(calculator.boundaryTest(50)).isEqualTo("MIDDLE");
        
        // Test Case 4: 上界值
        // 1) Input values: value = 100
        // 2) Expected result: "BOUNDARY_HIGH"
        // 3) Test program's result: "BOUNDARY_HIGH"
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 4, 6, 8, 9
        assertThat(calculator.boundaryTest(100)).isEqualTo("BOUNDARY_HIGH");
        
        // Test Case 5: 大於上界
        // 1) Input values: value = 150
        // 2) Expected result: "HIGH"
        // 3) Test program's result: "HIGH"
        // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2, 4, 6, 8, 10, 11
        assertThat(calculator.boundaryTest(150)).isEqualTo("HIGH");
        
        // Line coverage: 100%
    }
}
