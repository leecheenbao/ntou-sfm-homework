package com.ntou.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

/**
 * Stress Testing Coverage 測試
 * 目標：測試有效範圍內的極小值、極大值，以及無效值
 * 
 * 測試策略：
 * 1) 有效範圍內極小值
 * 2) 有效範圍內極大值
 * 3) 無效值（超過限制的資料）
 */
public class StressTestingCoverageTest {
    
    private Calculator calculator;
    private NumberProcessor processor;
    
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        processor = new NumberProcessor();
    }
    
    /**
     * 測試 isPositive 方法的 Stress Testing
     * 
     * 有效範圍：所有整數
     * 測試策略：
     * 1) 有效範圍內極小值：Integer.MIN_VALUE
     * 2) 有效範圍內極大值：Integer.MAX_VALUE
     * 3) 無效值：無（所有整數都是有效的）
     */
    @Test
    void testIsPositive_StressTesting() {
        // Test Case 1: 有效範圍內極小值
        // 1) Input values: i = Integer.MIN_VALUE (-2147483648)
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Stress testing - 測試有效範圍內極小值
        assertThat(calculator.isPositive(Integer.MIN_VALUE)).isFalse();
        
        // Test Case 2: 有效範圍內極大值
        // 1) Input values: i = Integer.MAX_VALUE (2147483647)
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Stress testing - 測試有效範圍內極大值
        assertThat(calculator.isPositive(Integer.MAX_VALUE)).isTrue();
        
        // Test Case 3: 邊界值 0
        // 1) Input values: i = 0
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Stress testing - 測試邊界值
        assertThat(calculator.isPositive(0)).isTrue();
        
        // Test Case 4: 邊界值 -1
        // 1) Input values: i = -1
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Stress testing - 測試邊界值
        assertThat(calculator.isPositive(-1)).isFalse();
    }
    
    /**
     * 測試 factorial 方法的 Stress Testing
     * 
     * 有效範圍：非負整數，但由於階乘增長很快，實際有效範圍較小
     * 測試策略：
     * 1) 有效範圍內極小值：0
     * 2) 有效範圍內極大值：20（20! 接近 long 的最大值）
     * 3) 無效值：負數
     */
    @Test
    void testFactorial_StressTesting() {
        // Test Case 1: 有效範圍內極小值
        // 1) Input values: n = 0
        // 2) Expected result: 1
        // 3) Test program's result: 1
        // 4) Criteria analysis: Stress testing - 測試有效範圍內極小值
        assertThat(calculator.factorial(0)).isEqualTo(1);
        
        // Test Case 2: 有效範圍內極大值（較大的值）
        // 1) Input values: n = 20
        // 2) Expected result: 2432902008176640000
        // 3) Test program's result: 2432902008176640000
        // 4) Criteria analysis: Stress testing - 測試有效範圍內極大值
        assertThat(calculator.factorial(20)).isEqualTo(2432902008176640000L);
        
        // Test Case 3: 無效值（負數）
        // 1) Input values: n = -1
        // 2) Expected result: -1
        // 3) Test program's result: -1
        // 4) Criteria analysis: Stress testing - 測試無效值
        assertThat(calculator.factorial(-1)).isEqualTo(-1);
        
        // Test Case 4: 無效值（很大的負數）
        // 1) Input values: n = Integer.MIN_VALUE
        // 2) Expected result: -1
        // 3) Test program's result: -1
        // 4) Criteria analysis: Stress testing - 測試無效值（極小負數）
        assertThat(calculator.factorial(Integer.MIN_VALUE)).isEqualTo(-1);
        
        // Test Case 5: 邊界值 1
        // 1) Input values: n = 1
        // 2) Expected result: 1
        // 3) Test program's result: 1
        // 4) Criteria analysis: Stress testing - 測試邊界值
        assertThat(calculator.factorial(1)).isEqualTo(1);
    }
    
    /**
     * 測試 gcd 方法的 Stress Testing
     * 
     * 有效範圍：所有整數，但特殊情況需要處理
     * 測試策略：
     * 1) 有效範圍內極小值：Integer.MIN_VALUE
     * 2) 有效範圍內極大值：Integer.MAX_VALUE
     * 3) 無效值：兩個都為 0
     */
    @Test
    void testGcd_StressTesting() {
        // Test Case 1: 有效範圍內極小值
        // 1) Input values: a = Integer.MIN_VALUE, b = 1
        // 2) Expected result: 1
        // 3) Test program's result: 1
        // 4) Criteria analysis: Stress testing - 測試有效範圍內極小值
        assertThat(calculator.gcd(Integer.MIN_VALUE, 1)).isEqualTo(1);
        
        // Test Case 2: 有效範圍內極大值
        // 1) Input values: a = Integer.MAX_VALUE, b = 1
        // 2) Expected result: 1
        // 3) Test program's result: 1
        // 4) Criteria analysis: Stress testing - 測試有效範圍內極大值
        assertThat(calculator.gcd(Integer.MAX_VALUE, 1)).isEqualTo(1);
        
        // Test Case 3: 無效值（兩個都為 0）
        // 1) Input values: a = 0, b = 0
        // 2) Expected result: -1
        // 3) Test program's result: -1
        // 4) Criteria analysis: Stress testing - 測試無效值
        assertThat(calculator.gcd(0, 0)).isEqualTo(-1);
        
        // Test Case 4: 邊界值測試
        // 1) Input values: a = 0, b = Integer.MAX_VALUE
        // 2) Expected result: Integer.MAX_VALUE
        // 3) Test program's result: Integer.MAX_VALUE
        // 4) Criteria analysis: Stress testing - 測試邊界值
        assertThat(calculator.gcd(0, Integer.MAX_VALUE)).isEqualTo(Integer.MAX_VALUE);
        
        // Test Case 5: 大數測試
        // 1) Input values: a = Integer.MAX_VALUE, b = Integer.MIN_VALUE
        // 2) Expected result: -1
        // 3) Test program's result: -1
        // 4) Criteria analysis: Stress testing - 測試大數運算（由於 Integer.MIN_VALUE 的絕對值無法表示，返回錯誤值）
        assertThat(calculator.gcd(Integer.MAX_VALUE, Integer.MIN_VALUE)).isEqualTo(-1);
    }
    
    /**
     * 測試 classifyNumber 方法的 Stress Testing
     * 
     * 有效範圍：所有整數
     * 測試策略：
     * 1) 有效範圍內極小值：Integer.MIN_VALUE
     * 2) 有效範圍內極大值：Integer.MAX_VALUE
     * 3) 無效值：無（所有整數都是有效的）
     */
    @Test
    void testClassifyNumber_StressTesting() {
        // Test Case 1: 有效範圍內極小值
        // 1) Input values: number = Integer.MIN_VALUE (-2147483648)
        // 2) Expected result: "NEGATIVE"
        // 3) Test program's result: "NEGATIVE"
        // 4) Criteria analysis: Stress testing - 測試有效範圍內極小值
        assertThat(processor.classifyNumber(Integer.MIN_VALUE)).isEqualTo("NEGATIVE");
        
        // Test Case 2: 有效範圍內極大值
        // 1) Input values: number = Integer.MAX_VALUE (2147483647)
        // 2) Expected result: "LARGE"
        // 3) Test program's result: "LARGE"
        // 4) Criteria analysis: Stress testing - 測試有效範圍內極大值
        assertThat(processor.classifyNumber(Integer.MAX_VALUE)).isEqualTo("LARGE");
        
        // Test Case 3: 邊界值 0
        // 1) Input values: number = 0
        // 2) Expected result: "ZERO"
        // 3) Test program's result: "ZERO"
        // 4) Criteria analysis: Stress testing - 測試邊界值
        assertThat(processor.classifyNumber(0)).isEqualTo("ZERO");
        
        // Test Case 4: 邊界值 10
        // 1) Input values: number = 10
        // 2) Expected result: "SMALL"
        // 3) Test program's result: "SMALL"
        // 4) Criteria analysis: Stress testing - 測試邊界值
        assertThat(processor.classifyNumber(10)).isEqualTo("SMALL");
        
        // Test Case 5: 邊界值 100
        // 1) Input values: number = 100
        // 2) Expected result: "MEDIUM"
        // 3) Test program's result: "MEDIUM"
        // 4) Criteria analysis: Stress testing - 測試邊界值
        assertThat(processor.classifyNumber(100)).isEqualTo("MEDIUM");
    }
    
    /**
     * 測試 sumArray 方法的 Stress Testing
     * 
     * 有效範圍：
     * 1) 陣列長度：0 到 Integer.MAX_VALUE（實際測試時使用較小值）
     * 2) 陣列元素：所有整數
     * 測試策略：
     * 1) 有效範圍內極小值：空陣列
     * 2) 有效範圍內極大值：大陣列
     * 3) 無效值：null
     */
    @Test
    void testSumArray_StressTesting() {
        // Test Case 1: 有效範圍內極小值（空陣列）
        // 1) Input values: numbers = []
        // 2) Expected result: 0
        // 3) Test program's result: 0
        // 4) Criteria analysis: Stress testing - 測試有效範圍內極小值
        assertThat(processor.sumArray(new int[0])).isEqualTo(0);
        
        // Test Case 2: 有效範圍內極大值（大陣列）
        // 1) Input values: numbers = [Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE]
        // 2) Expected result: 2147483646 (由於溢出)
        // 3) Test program's result: 2147483646
        // 4) Criteria analysis: Stress testing - 測試有效範圍內極大值
        assertThat(processor.sumArray(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE}))
                .isEqualTo(2147483646);
        
        // Test Case 3: 無效值（null）
        // 1) Input values: numbers = null
        // 2) Expected result: 0
        // 3) Test program's result: 0
        // 4) Criteria analysis: Stress testing - 測試無效值
        assertThat(processor.sumArray(null)).isEqualTo(0);
        
        // Test Case 4: 單元素陣列
        // 1) Input values: numbers = [Integer.MAX_VALUE]
        // 2) Expected result: Integer.MAX_VALUE
        // 3) Test program's result: Integer.MAX_VALUE
        // 4) Criteria analysis: Stress testing - 測試單元素陣列
        assertThat(processor.sumArray(new int[]{Integer.MAX_VALUE})).isEqualTo(Integer.MAX_VALUE);
    }
    
    /**
     * 測試 isValidPassword 方法的 Stress Testing
     * 
     * 有效範圍：
     * 1) 密碼長度：6 到 Integer.MAX_VALUE（實際測試時使用合理值）
     * 2) 密碼內容：包含字母和數字
     * 測試策略：
     * 1) 有效範圍內極小值：長度 6 的有效密碼
     * 2) 有效範圍內極大值：長度 1000 的有效密碼
     * 3) 無效值：null、太短、只有字母、只有數字
     */
    @Test
    void testIsValidPassword_StressTesting() {
        // Test Case 1: 有效範圍內極小值（長度 6）
        // 1) Input values: password = "abc123"
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Stress testing - 測試有效範圍內極小值
        assertThat(processor.isValidPassword("abc123")).isTrue();
        
        // Test Case 2: 有效範圍內極大值（長度 1000）
        // 1) Input values: password = 長度 1000 的有效密碼
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Stress testing - 測試有效範圍內極大值
        StringBuilder longPassword = new StringBuilder();
        for (int i = 0; i < 500; i++) {
            longPassword.append("a1");
        }
        assertThat(processor.isValidPassword(longPassword.toString())).isTrue();
        
        // Test Case 3: 無效值（null）
        // 1) Input values: password = null
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Stress testing - 測試無效值
        assertThat(processor.isValidPassword(null)).isFalse();
        
        // Test Case 4: 無效值（太短）
        // 1) Input values: password = "abc12"
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Stress testing - 測試無效值（太短）
        assertThat(processor.isValidPassword("abc12")).isFalse();
        
        // Test Case 5: 無效值（只有字母）
        // 1) Input values: password = "abcdefgh"
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Stress testing - 測試無效值（只有字母）
        assertThat(processor.isValidPassword("abcdefgh")).isFalse();
        
        // Test Case 6: 無效值（只有數字）
        // 1) Input values: password = "12345678"
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Stress testing - 測試無效值（只有數字）
        assertThat(processor.isValidPassword("12345678")).isFalse();
    }
    
    /**
     * 測試 countPrimes 方法的 Stress Testing
     * 
     * 有效範圍：非負整數
     * 測試策略：
     * 1) 有效範圍內極小值：0, 1
     * 2) 有效範圍內極大值：1000
     * 3) 無效值：負數
     */
    @Test
    void testCountPrimes_StressTesting() {
        // Test Case 1: 有效範圍內極小值
        // 1) Input values: n = 0
        // 2) Expected result: 0
        // 3) Test program's result: 0
        // 4) Criteria analysis: Stress testing - 測試有效範圍內極小值
        assertThat(processor.countPrimes(0)).isEqualTo(0);
        
        // Test Case 2: 有效範圍內極小值
        // 1) Input values: n = 1
        // 2) Expected result: 0
        // 3) Test program's result: 0
        // 4) Criteria analysis: Stress testing - 測試有效範圍內極小值
        assertThat(processor.countPrimes(1)).isEqualTo(0);
        
        // Test Case 3: 有效範圍內極大值
        // 1) Input values: n = 1000
        // 2) Expected result: 168
        // 3) Test program's result: 168
        // 4) Criteria analysis: Stress testing - 測試有效範圍內極大值
        assertThat(processor.countPrimes(1000)).isEqualTo(168);
        
        // Test Case 4: 邊界值
        // 1) Input values: n = 2
        // 2) Expected result: 1
        // 3) Test program's result: 1
        // 4) Criteria analysis: Stress testing - 測試邊界值
        assertThat(processor.countPrimes(2)).isEqualTo(1);
    }
}
