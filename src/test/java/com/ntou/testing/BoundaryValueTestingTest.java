package com.ntou.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Boundary Value Testing 測試類
 * 
 * 邊界值測試是一種黑盒測試技術，專注於測試輸入域的邊界值。
 * 經驗表明，程式錯誤經常發生在輸入域的邊界處。
 * 
 * 邊界值測試的策略：
 * 1. 對於範圍 [a, b]，測試值：a-1, a, a+1, b-1, b, b+1
 * 2. 對於範圍 (a, b]，測試值：a, a+1, b-1, b, b+1
 * 3. 對於範圍 [a, b)，測試值：a-1, a, a+1, b-1, b
 * 4. 對於範圍 (a, b)，測試值：a, a+1, b-1, b
 * 5. 對於單值邊界，測試：邊界值-1, 邊界值, 邊界值+1
 */
public class BoundaryValueTestingTest {

    private final NumberProcessor processor = new NumberProcessor();

    @Test
    @DisplayName("測試 classifyNumber 方法的 Boundary Value Testing")
    void testClassifyNumber_BoundaryValueTesting() {
        // classifyNumber(int number) 方法
        // 邊界條件：
        // 1. number < 0 -> "NEGATIVE"
        // 2. number == 0 -> "ZERO"
        // 3. 0 < number <= 10 -> "SMALL"
        // 4. 10 < number <= 100 -> "MEDIUM"
        // 5. number > 100 -> "LARGE"
        // 
        // 邊界值：-1, 0, 1, 10, 11, 100, 101
        
        // Test Case 1: 負數邊界值
        // 1) Input values: number = -1 (邊界值-1)
        // 2) Expected result: "NEGATIVE"
        // 3) Test program's result: "NEGATIVE"
        // 4) Criteria analysis: Boundary value testing - 負數邊界值
        assertThat(processor.classifyNumber(-1)).isEqualTo("NEGATIVE");
        
        // Test Case 2: 零邊界值
        // 1) Input values: number = 0 (邊界值)
        // 2) Expected result: "ZERO"
        // 3) Test program's result: "ZERO"
        // 4) Criteria analysis: Boundary value testing - 零邊界值
        assertThat(processor.classifyNumber(0)).isEqualTo("ZERO");
        
        // Test Case 3: 小正數邊界值
        // 1) Input values: number = 1 (邊界值+1)
        // 2) Expected result: "SMALL"
        // 3) Test program's result: "SMALL"
        // 4) Criteria analysis: Boundary value testing - 小正數邊界值
        assertThat(processor.classifyNumber(1)).isEqualTo("SMALL");
        
        // Test Case 4: 小正數上限邊界值
        // 1) Input values: number = 10 (邊界值)
        // 2) Expected result: "SMALL"
        // 3) Test program's result: "SMALL"
        // 4) Criteria analysis: Boundary value testing - 小正數上限邊界值
        assertThat(processor.classifyNumber(10)).isEqualTo("SMALL");
        
        // Test Case 5: 中等正數下限邊界值
        // 1) Input values: number = 11 (邊界值+1)
        // 2) Expected result: "MEDIUM"
        // 3) Test program's result: "MEDIUM"
        // 4) Criteria analysis: Boundary value testing - 中等正數下限邊界值
        assertThat(processor.classifyNumber(11)).isEqualTo("MEDIUM");
        
        // Test Case 6: 中等正數上限邊界值
        // 1) Input values: number = 100 (邊界值)
        // 2) Expected result: "MEDIUM"
        // 3) Test program's result: "MEDIUM"
        // 4) Criteria analysis: Boundary value testing - 中等正數上限邊界值
        assertThat(processor.classifyNumber(100)).isEqualTo("MEDIUM");
        
        // Test Case 7: 大正數邊界值
        // 1) Input values: number = 101 (邊界值+1)
        // 2) Expected result: "LARGE"
        // 3) Test program's result: "LARGE"
        // 4) Criteria analysis: Boundary value testing - 大正數邊界值
        assertThat(processor.classifyNumber(101)).isEqualTo("LARGE");
        
        // Boundary value testing: 100%
        // 所有邊界值都已測試過
    }

}