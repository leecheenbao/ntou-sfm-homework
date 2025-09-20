package com.ntou.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

/**
 * Input Domain Characterization 測試
 * 目標：根據資料的特性分成幾個不同的類別，每個類別都要測試過
 * 
 * 測試策略：
 * 1) Categorization - 每個類別都要測試過
 * 2) Combinatorial - 各種類別的全部排列組合都要測試過
 */
public class InputDomainCharacterizationTest {
    
    private NumberProcessor processor;
    
    @BeforeEach
    void setUp() {
        processor = new NumberProcessor();
    }
    
    /**
     * 測試 classifyNumber 方法的 Input Domain Characterization
     * 
     * 資料分類：
     * 類別1: 負數 (number < 0)
     * 類別2: 零 (number == 0)
     * 類別3: 小正數 (0 < number <= 10)
     * 類別4: 中等正數 (10 < number <= 100)
     * 類別5: 大正數 (number > 100)
     */
    @Test
    void testClassifyNumber_InputDomainCharacterization() {
        // Test Case 1: 類別1 - 負數
        // 1) Input values: number = -5 (代表負數類別)
        // 2) Expected result: "NEGATIVE"
        // 3) Test program's result: "NEGATIVE"
        // 4) Criteria analysis: Input domain characterization - 負數類別
        assertThat(processor.classifyNumber(-5)).isEqualTo("NEGATIVE");
        
        // Test Case 2: 類別2 - 零
        // 1) Input values: number = 0 (代表零類別)
        // 2) Expected result: "ZERO"
        // 3) Test program's result: "ZERO"
        // 4) Criteria analysis: Input domain characterization - 零類別
        assertThat(processor.classifyNumber(0)).isEqualTo("ZERO");
        
        // Test Case 3: 類別3 - 小正數
        // 1) Input values: number = 5 (代表小正數類別)
        // 2) Expected result: "SMALL"
        // 3) Test program's result: "SMALL"
        // 4) Criteria analysis: Input domain characterization - 小正數類別
        assertThat(processor.classifyNumber(5)).isEqualTo("SMALL");
        
        // Test Case 4: 類別4 - 中等正數
        // 1) Input values: number = 50 (代表中等正數類別)
        // 2) Expected result: "MEDIUM"
        // 3) Test program's result: "MEDIUM"
        // 4) Criteria analysis: Input domain characterization - 中等正數類別
        assertThat(processor.classifyNumber(50)).isEqualTo("MEDIUM");
        
        // Test Case 5: 類別5 - 大正數
        // 1) Input values: number = 150 (代表大正數類別)
        // 2) Expected result: "LARGE"
        // 3) Test program's result: "LARGE"
        // 4) Criteria analysis: Input domain characterization - 大正數類別
        assertThat(processor.classifyNumber(150)).isEqualTo("LARGE");
        
        // Input domain characterization: 100%
        // 所有類別都已測試過
    }
    
    /**
     * 測試 sumArray 方法的 Input Domain Characterization
     * 
     * 資料分類：
     * 類別1: null 陣列
     * 類別2: 空陣列 (length = 0)
     * 類別3: 單元素陣列 (length = 1)
     * 類別4: 多元素陣列 (length > 1)
     */
    @Test
    void testSumArray_InputDomainCharacterization() {
        // Test Case 1: 類別1 - null 陣列
        // 1) Input values: numbers = null (代表 null 陣列類別)
        // 2) Expected result: 0
        // 3) Test program's result: 0
        // 4) Criteria analysis: Input domain characterization - null 陣列類別
        assertThat(processor.sumArray(null)).isEqualTo(0);
        
        // Test Case 2: 類別2 - 空陣列
        // 1) Input values: numbers = [] (代表空陣列類別)
        // 2) Expected result: 0
        // 3) Test program's result: 0
        // 4) Criteria analysis: Input domain characterization - 空陣列類別
        assertThat(processor.sumArray(new int[]{})).isEqualTo(0);
        
        // Test Case 3: 類別3 - 單元素陣列
        // 1) Input values: numbers = [5] (代表單元素陣列類別)
        // 2) Expected result: 5
        // 3) Test program's result: 5
        // 4) Criteria analysis: Input domain characterization - 單元素陣列類別
        assertThat(processor.sumArray(new int[]{5})).isEqualTo(5);
        
        // Test Case 4: 類別4 - 多元素陣列
        // 1) Input values: numbers = [1, 2, 3, 4, 5] (代表多元素陣列類別)
        // 2) Expected result: 15
        // 3) Test program's result: 15
        // 4) Criteria analysis: Input domain characterization - 多元素陣列類別
        assertThat(processor.sumArray(new int[]{1, 2, 3, 4, 5})).isEqualTo(15);
        
        // Input domain characterization: 100%
        // 所有類別都已測試過
    }
    
}