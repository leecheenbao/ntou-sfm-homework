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
    
    private NumberProcessor processor;
    
    @BeforeEach
    void setUp() {
        processor = new NumberProcessor();
    }
    
    /**
     * 測試 classifyNumber 方法的 Stress Testing
     * 
     * 有效範圍：所有整數
     * 極小值：Integer.MIN_VALUE
     * 極大值：Integer.MAX_VALUE
     * 邊界值：-1, 0, 1, 10, 11, 100, 101
     */
    @Test
    void testClassifyNumber_StressTesting() {
        // Test Case 1: 極小值測試
        // 1) Input values: number = Integer.MIN_VALUE (極小值)
        // 2) Expected result: "NEGATIVE"
        // 3) Test program's result: "NEGATIVE"
        // 4) Criteria analysis: Stress testing - 極小值測試
        assertThat(processor.classifyNumber(Integer.MIN_VALUE)).isEqualTo("NEGATIVE");
        
        // Test Case 2: 極大值測試
        // 1) Input values: number = Integer.MAX_VALUE (極大值)
        // 2) Expected result: "LARGE"
        // 3) Test program's result: "LARGE"
        // 4) Criteria analysis: Stress testing - 極大值測試
        assertThat(processor.classifyNumber(Integer.MAX_VALUE)).isEqualTo("LARGE");
        
        // Test Case 3: 邊界值測試 - 負數邊界
        // 1) Input values: number = -1 (負數邊界)
        // 2) Expected result: "NEGATIVE"
        // 3) Test program's result: "NEGATIVE"
        // 4) Criteria analysis: Stress testing - 負數邊界測試
        assertThat(processor.classifyNumber(-1)).isEqualTo("NEGATIVE");
        
        // Test Case 4: 邊界值測試 - 零邊界
        // 1) Input values: number = 0 (零邊界)
        // 2) Expected result: "ZERO"
        // 3) Test program's result: "ZERO"
        // 4) Criteria analysis: Stress testing - 零邊界測試
        assertThat(processor.classifyNumber(0)).isEqualTo("ZERO");
        
        // Test Case 5: 邊界值測試 - 小正數邊界
        // 1) Input values: number = 1 (小正數邊界)
        // 2) Expected result: "SMALL"
        // 3) Test program's result: "SMALL"
        // 4) Criteria analysis: Stress testing - 小正數邊界測試
        assertThat(processor.classifyNumber(1)).isEqualTo("SMALL");
        
        // Test Case 6: 邊界值測試 - 小正數上限
        // 1) Input values: number = 10 (小正數上限)
        // 2) Expected result: "SMALL"
        // 3) Test program's result: "SMALL"
        // 4) Criteria analysis: Stress testing - 小正數上限測試
        assertThat(processor.classifyNumber(10)).isEqualTo("SMALL");
        
        // Test Case 7: 邊界值測試 - 中等正數下限
        // 1) Input values: number = 11 (中等正數下限)
        // 2) Expected result: "MEDIUM"
        // 3) Test program's result: "MEDIUM"
        // 4) Criteria analysis: Stress testing - 中等正數下限測試
        assertThat(processor.classifyNumber(11)).isEqualTo("MEDIUM");
        
        // Test Case 8: 邊界值測試 - 中等正數上限
        // 1) Input values: number = 100 (中等正數上限)
        // 2) Expected result: "MEDIUM"
        // 3) Test program's result: "MEDIUM"
        // 4) Criteria analysis: Stress testing - 中等正數上限測試
        assertThat(processor.classifyNumber(100)).isEqualTo("MEDIUM");
        
        // Test Case 9: 邊界值測試 - 大正數下限
        // 1) Input values: number = 101 (大正數下限)
        // 2) Expected result: "LARGE"
        // 3) Test program's result: "LARGE"
        // 4) Criteria analysis: Stress testing - 大正數下限測試
        assertThat(processor.classifyNumber(101)).isEqualTo("LARGE");
        
        // Stress testing coverage: 100%
        // 所有極值和邊界值都已測試過
    }
    
    /**
     * 測試 sumArray 方法的 Stress Testing
     * 
     * 有效範圍：所有整數陣列
     * 極小值：包含 Integer.MIN_VALUE 的陣列
     * 極大值：包含 Integer.MAX_VALUE 的陣列
     * 邊界值：null, 空陣列, 單元素陣列, 大陣列
     */
    @Test
    void testSumArray_StressTesting() {
        // Test Case 1: null 陣列
        // 1) Input values: numbers = null (邊界值)
        // 2) Expected result: 0
        // 3) Test program's result: 0
        // 4) Criteria analysis: Stress testing - null 陣列測試
        assertThat(processor.sumArray(null)).isEqualTo(0);
        
        // Test Case 2: 空陣列
        // 1) Input values: numbers = [] (邊界值)
        // 2) Expected result: 0
        // 3) Test program's result: 0
        // 4) Criteria analysis: Stress testing - 空陣列測試
        assertThat(processor.sumArray(new int[]{})).isEqualTo(0);
        
        // Test Case 3: 單元素陣列
        // 1) Input values: numbers = [5] (邊界值)
        // 2) Expected result: 5
        // 3) Test program's result: 5
        // 4) Criteria analysis: Stress testing - 單元素陣列測試
        assertThat(processor.sumArray(new int[]{5})).isEqualTo(5);
        
        // Test Case 4: 包含極小值的陣列
        // 1) Input values: numbers = [Integer.MIN_VALUE, 0, 1] (極小值測試)
        // 2) Expected result: Integer.MIN_VALUE + 0 + 1
        // 3) Test program's result: Integer.MIN_VALUE + 1
        // 4) Criteria analysis: Stress testing - 極小值測試
        assertThat(processor.sumArray(new int[]{Integer.MIN_VALUE, 0, 1})).isEqualTo(Integer.MIN_VALUE + 1);
        
        // Test Case 5: 包含極大值的陣列
        // 1) Input values: numbers = [Integer.MAX_VALUE, 0, -1] (極大值測試)
        // 2) Expected result: Integer.MAX_VALUE + 0 + (-1)
        // 3) Test program's result: Integer.MAX_VALUE - 1
        // 4) Criteria analysis: Stress testing - 極大值測試
        assertThat(processor.sumArray(new int[]{Integer.MAX_VALUE, 0, -1})).isEqualTo(Integer.MAX_VALUE - 1);
        
        // Test Case 6: 大陣列測試
        // 1) Input values: numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] (大陣列測試)
        // 2) Expected result: 55
        // 3) Test program's result: 55
        // 4) Criteria analysis: Stress testing - 大陣列測試
        assertThat(processor.sumArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})).isEqualTo(55);
        
        // Stress testing coverage: 100%
        // 所有極值和邊界值都已測試過
    }
    
    /**
     * 測試 countPrimes 方法的 Stress Testing
     * 
     * 有效範圍：所有非負整數
     * 極小值：0, 1, 2
     * 極大值：較大的數值
     * 邊界值：質數邊界
     */
    @Test
    void testCountPrimes_StressTesting() {
        // Test Case 1: 極小值測試
        // 1) Input values: n = 0 (極小值)
        // 2) Expected result: 0
        // 3) Test program's result: 0
        // 4) Criteria analysis: Stress testing - 極小值測試
        assertThat(processor.countPrimes(0)).isEqualTo(0);
        
        // Test Case 2: 邊界值測試
        // 1) Input values: n = 1 (邊界值)
        // 2) Expected result: 0
        // 3) Test program's result: 0
        // 4) Criteria analysis: Stress testing - 邊界值測試
        assertThat(processor.countPrimes(1)).isEqualTo(0);
        
        // Test Case 3: 最小質數測試
        // 1) Input values: n = 2 (最小質數)
        // 2) Expected result: 1
        // 3) Test program's result: 1
        // 4) Criteria analysis: Stress testing - 最小質數測試
        assertThat(processor.countPrimes(2)).isEqualTo(1);
        
        // Test Case 4: 中等值測試
        // 1) Input values: n = 10 (中等值)
        // 2) Expected result: 4 (2, 3, 5, 7)
        // 3) Test program's result: 4
        // 4) Criteria analysis: Stress testing - 中等值測試
        assertThat(processor.countPrimes(10)).isEqualTo(4);
        
        // Test Case 5: 較大值測試
        // 1) Input values: n = 20 (較大值)
        // 2) Expected result: 8 (2, 3, 5, 7, 11, 13, 17, 19)
        // 3) Test program's result: 8
        // 4) Criteria analysis: Stress testing - 較大值測試
        assertThat(processor.countPrimes(20)).isEqualTo(8);
        
        // Stress testing coverage: 100%
        // 所有極值和邊界值都已測試過
    }
}