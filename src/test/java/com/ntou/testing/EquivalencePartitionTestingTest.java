package com.ntou.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Equivalence Partition Testing 測試類
 * 
 * 等價分割測試是一種黑盒測試技術，將輸入域劃分為若干個等價類，
 * 每個等價類代表一組在程式中表現相同的輸入值。
 * 
 * 等價分割測試的步驟：
 * 1. 識別輸入域
 * 2. 劃分等價類（有效等價類和無效等價類）
 * 3. 從每個等價類中選擇一個代表值進行測試
 * 4. 設計測試案例
 */
public class EquivalencePartitionTestingTest {

    private final NumberProcessor processor = new NumberProcessor();

    @Test
    @DisplayName("測試 classifyNumber 方法的 Equivalence Partition Testing")
    void testClassifyNumber_EquivalencePartitionTesting() {
        // classifyNumber(int number) 方法
        // 輸入域：所有整數 (int 範圍)
        // 
        // 等價類劃分：
        // 1. 負數等價類：number < 0
        // 2. 零等價類：number == 0
        // 3. 小正數等價類：0 < number <= 10
        // 4. 中等正數等價類：10 < number <= 100
        // 5. 大正數等價類：number > 100
        
        // Test Case 1: 負數等價類
        // 1) Input values: number = -5 (代表負數等價類)
        // 2) Expected result: "NEGATIVE"
        // 3) Test program's result: "NEGATIVE"
        // 4) Criteria analysis: Equivalence partition testing - 負數等價類
        assertThat(processor.classifyNumber(-5)).isEqualTo("NEGATIVE");
        
        // Test Case 2: 零等價類
        // 1) Input values: number = 0 (代表零等價類)
        // 2) Expected result: "ZERO"
        // 3) Test program's result: "ZERO"
        // 4) Criteria analysis: Equivalence partition testing - 零等價類
        assertThat(processor.classifyNumber(0)).isEqualTo("ZERO");
        
        // Test Case 3: 小正數等價類
        // 1) Input values: number = 5 (代表小正數等價類)
        // 2) Expected result: "SMALL"
        // 3) Test program's result: "SMALL"
        // 4) Criteria analysis: Equivalence partition testing - 小正數等價類
        assertThat(processor.classifyNumber(5)).isEqualTo("SMALL");
        
        // Test Case 4: 中等正數等價類
        // 1) Input values: number = 50 (代表中等正數等價類)
        // 2) Expected result: "MEDIUM"
        // 3) Test program's result: "MEDIUM"
        // 4) Criteria analysis: Equivalence partition testing - 中等正數等價類
        assertThat(processor.classifyNumber(50)).isEqualTo("MEDIUM");
        
        // Test Case 5: 大正數等價類
        // 1) Input values: number = 150 (代表大正數等價類)
        // 2) Expected result: "LARGE"
        // 3) Test program's result: "LARGE"
        // 4) Criteria analysis: Equivalence partition testing - 大正數等價類
        assertThat(processor.classifyNumber(150)).isEqualTo("LARGE");
        
        // Equivalence partition testing: 100%
        // 所有等價類都已測試過
    }

}