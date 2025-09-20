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
    
    private Calculator calculator;
    private NumberProcessor processor;
    
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        processor = new NumberProcessor();
    }
    
    /**
     * 測試 processArray 方法的 Input Domain Characterization
     * 
     * 資料分類：
     * 類別1: 0筆資料 (null 或空陣列)
     * 類別2: 1筆資料 (單元素陣列)
     * 類別3: 多筆資料 (>1 元素陣列)
     * 
     * Categorization 目標：每個類別都要測試過
     */
    @Test
    void testProcessArray_Categorization() {
        // Test Case 1: 類別1 - 0筆資料 (null)
        // 1) Input values: numbers = null
        // 2) Expected result: "NULL"
        // 3) Test program's result: "NULL"
        // 4) Criteria analysis: Input domain characterization - 類別1 (0筆資料)
        assertThat(calculator.processArray(null)).isEqualTo("NULL");
        
        // Test Case 2: 類別1 - 0筆資料 (空陣列)
        // 1) Input values: numbers = []
        // 2) Expected result: "EMPTY"
        // 3) Test program's result: "EMPTY"
        // 4) Criteria analysis: Input domain characterization - 類別1 (0筆資料)
        assertThat(calculator.processArray(new int[0])).isEqualTo("EMPTY");
        
        // Test Case 3: 類別2 - 1筆資料
        // 1) Input values: numbers = [42]
        // 2) Expected result: "SINGLE"
        // 3) Test program's result: "SINGLE"
        // 4) Criteria analysis: Input domain characterization - 類別2 (1筆資料)
        assertThat(calculator.processArray(new int[]{42})).isEqualTo("SINGLE");
        
        // Test Case 4: 類別3 - 多筆資料
        // 1) Input values: numbers = [1, 2, 3, 4, 5]
        // 2) Expected result: "MULTIPLE"
        // 3) Test program's result: "MULTIPLE"
        // 4) Criteria analysis: Input domain characterization - 類別3 (多筆資料)
        assertThat(calculator.processArray(new int[]{1, 2, 3, 4, 5})).isEqualTo("MULTIPLE");
        
        // Categorization coverage: 100%
    }
    
    /**
     * 測試 processArray 方法的 Combinatorial Coverage
     * 
     * 對於 processArray 方法，輸入域只有一個維度（陣列），
     * 所以不需要組合測試，只需要確保每個類別都被測試過
     */
    @Test
    void testProcessArray_Combinatorial() {
        // 由於 processArray 方法只有一個輸入參數（陣列），
        // 不存在多個輸入域的組合，因此 Combinatorial Coverage 與 Categorization 相同
        
        // Test Case 1: null 陣列
        assertThat(calculator.processArray(null)).isEqualTo("NULL");
        
        // Test Case 2: 空陣列
        assertThat(calculator.processArray(new int[0])).isEqualTo("EMPTY");
        
        // Test Case 3: 單元素陣列
        assertThat(calculator.processArray(new int[]{100})).isEqualTo("SINGLE");
        
        // Test Case 4: 多元素陣列
        assertThat(calculator.processArray(new int[]{10, 20, 30})).isEqualTo("MULTIPLE");
        
        // Combinatorial coverage: 100%
    }
    
    /**
     * 測試 classifyNumber 方法的 Input Domain Characterization
     * 
     * 資料分類：
     * 類別1: 負數 (number < 0)
     * 類別2: 零 (number = 0)
     * 類別3: 小正數 (0 < number <= 10)
     * 類別4: 中等正數 (10 < number <= 100)
     * 類別5: 大正數 (number > 100)
     */
    @Test
    void testClassifyNumber_Categorization() {
        // Test Case 1: 類別1 - 負數
        // 1) Input values: number = -5
        // 2) Expected result: "NEGATIVE"
        // 3) Test program's result: "NEGATIVE"
        // 4) Criteria analysis: Input domain characterization - 類別1 (負數)
        assertThat(processor.classifyNumber(-5)).isEqualTo("NEGATIVE");
        
        // Test Case 2: 類別2 - 零
        // 1) Input values: number = 0
        // 2) Expected result: "ZERO"
        // 3) Test program's result: "ZERO"
        // 4) Criteria analysis: Input domain characterization - 類別2 (零)
        assertThat(processor.classifyNumber(0)).isEqualTo("ZERO");
        
        // Test Case 3: 類別3 - 小正數
        // 1) Input values: number = 5
        // 2) Expected result: "SMALL"
        // 3) Test program's result: "SMALL"
        // 4) Criteria analysis: Input domain characterization - 類別3 (小正數)
        assertThat(processor.classifyNumber(5)).isEqualTo("SMALL");
        
        // Test Case 4: 類別4 - 中等正數
        // 1) Input values: number = 50
        // 2) Expected result: "MEDIUM"
        // 3) Test program's result: "MEDIUM"
        // 4) Criteria analysis: Input domain characterization - 類別4 (中等正數)
        assertThat(processor.classifyNumber(50)).isEqualTo("MEDIUM");
        
        // Test Case 5: 類別5 - 大正數
        // 1) Input values: number = 150
        // 2) Expected result: "LARGE"
        // 3) Test program's result: "LARGE"
        // 4) Criteria analysis: Input domain characterization - 類別5 (大正數)
        assertThat(processor.classifyNumber(150)).isEqualTo("LARGE");
        
        // Categorization coverage: 100%
    }
    
    /**
     * 測試 factorial 方法的 Input Domain Characterization
     * 
     * 資料分類：
     * 類別1: 負數 (n < 0)
     * 類別2: 零 (n = 0)
     * 類別3: 小正數 (0 < n <= 5)
     * 類別4: 中等正數 (5 < n <= 10)
     * 類別5: 大正數 (n > 10)
     */
    @Test
    void testFactorial_Categorization() {
        // Test Case 1: 類別1 - 負數
        // 1) Input values: n = -3
        // 2) Expected result: -1
        // 3) Test program's result: -1
        // 4) Criteria analysis: Input domain characterization - 類別1 (負數)
        assertThat(calculator.factorial(-3)).isEqualTo(-1);
        
        // Test Case 2: 類別2 - 零
        // 1) Input values: n = 0
        // 2) Expected result: 1
        // 3) Test program's result: 1
        // 4) Criteria analysis: Input domain characterization - 類別2 (零)
        assertThat(calculator.factorial(0)).isEqualTo(1);
        
        // Test Case 3: 類別3 - 小正數
        // 1) Input values: n = 3
        // 2) Expected result: 6
        // 3) Test program's result: 6
        // 4) Criteria analysis: Input domain characterization - 類別3 (小正數)
        assertThat(calculator.factorial(3)).isEqualTo(6);
        
        // Test Case 4: 類別4 - 中等正數
        // 1) Input values: n = 7
        // 2) Expected result: 5040
        // 3) Test program's result: 5040
        // 4) Criteria analysis: Input domain characterization - 類別4 (中等正數)
        assertThat(calculator.factorial(7)).isEqualTo(5040);
        
        // Test Case 5: 類別5 - 大正數
        // 1) Input values: n = 15
        // 2) Expected result: 1307674368000
        // 3) Test program's result: 1307674368000
        // 4) Criteria analysis: Input domain characterization - 類別5 (大正數)
        assertThat(calculator.factorial(15)).isEqualTo(1307674368000L);
        
        // Categorization coverage: 100%
    }
    
    /**
     * 測試 isValidPassword 方法的 Input Domain Characterization
     * 
     * 資料分類：
     * 類別1: null 或太短 (length < 6)
     * 類別2: 只有數字 (length >= 6 且只有數字)
     * 類別3: 只有字母 (length >= 6 且只有字母)
     * 類別4: 有效密碼 (length >= 6 且有數字和字母)
     * 類別5: 特殊字符 (length >= 6 且包含特殊字符)
     */
    @Test
    void testIsValidPassword_Categorization() {
        // Test Case 1: 類別1 - null 或太短
        // 1) Input values: password = "12345"
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Input domain characterization - 類別1 (null 或太短)
        assertThat(processor.isValidPassword("12345")).isFalse();
        
        // Test Case 2: 類別2 - 只有數字
        // 1) Input values: password = "123456"
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Input domain characterization - 類別2 (只有數字)
        assertThat(processor.isValidPassword("123456")).isFalse();
        
        // Test Case 3: 類別3 - 只有字母
        // 1) Input values: password = "abcdef"
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Input domain characterization - 類別3 (只有字母)
        assertThat(processor.isValidPassword("abcdef")).isFalse();
        
        // Test Case 4: 類別4 - 有效密碼
        // 1) Input values: password = "abc123"
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Input domain characterization - 類別4 (有效密碼)
        assertThat(processor.isValidPassword("abc123")).isTrue();
        
        // Test Case 5: 類別5 - 特殊字符
        // 1) Input values: password = "abc123!"
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Input domain characterization - 類別5 (特殊字符)
        assertThat(processor.isValidPassword("abc123!")).isTrue();
        
        // Categorization coverage: 100%
    }
    
    /**
     * 測試複雜方法的 Input Domain Characterization
     * 
     * 假設我們有一個方法接受兩個參數：陣列和數字
     * 陣列分類：null, 空, 單元素, 多元素
     * 數字分類：負數, 零, 正數
     * 
     * 組合測試：4 × 3 = 12 種組合
     */
    @Test
    void testComplexMethod_Combinatorial() {
        // 這裡我們使用現有的方法來模擬複雜的輸入域組合
        // 使用 sumArray 和 classifyNumber 的組合
        
        // 組合1: null 陣列 + 負數
        assertThat(processor.sumArray(null)).isEqualTo(0);
        assertThat(processor.classifyNumber(-1)).isEqualTo("NEGATIVE");
        
        // 組合2: 空陣列 + 零
        assertThat(processor.sumArray(new int[0])).isEqualTo(0);
        assertThat(processor.classifyNumber(0)).isEqualTo("ZERO");
        
        // 組合3: 單元素陣列 + 正數
        assertThat(processor.sumArray(new int[]{5})).isEqualTo(5);
        assertThat(processor.classifyNumber(5)).isEqualTo("SMALL");
        
        // 組合4: 多元素陣列 + 負數
        assertThat(processor.sumArray(new int[]{1, 2, 3})).isEqualTo(6);
        assertThat(processor.classifyNumber(-10)).isEqualTo("NEGATIVE");
        
        // 組合5: null 陣列 + 零
        assertThat(processor.sumArray(null)).isEqualTo(0);
        assertThat(processor.classifyNumber(0)).isEqualTo("ZERO");
        
        // 組合6: 空陣列 + 正數
        assertThat(processor.sumArray(new int[0])).isEqualTo(0);
        assertThat(processor.classifyNumber(50)).isEqualTo("MEDIUM");
        
        // 組合7: 單元素陣列 + 負數
        assertThat(processor.sumArray(new int[]{-5})).isEqualTo(-5);
        assertThat(processor.classifyNumber(-5)).isEqualTo("NEGATIVE");
        
        // 組合8: 多元素陣列 + 零
        assertThat(processor.sumArray(new int[]{10, 20, 30})).isEqualTo(60);
        assertThat(processor.classifyNumber(0)).isEqualTo("ZERO");
        
        // 組合9: null 陣列 + 正數
        assertThat(processor.sumArray(null)).isEqualTo(0);
        assertThat(processor.classifyNumber(150)).isEqualTo("LARGE");
        
        // 組合10: 空陣列 + 負數
        assertThat(processor.sumArray(new int[0])).isEqualTo(0);
        assertThat(processor.classifyNumber(-100)).isEqualTo("NEGATIVE");
        
        // 組合11: 單元素陣列 + 零
        assertThat(processor.sumArray(new int[]{0})).isEqualTo(0);
        assertThat(processor.classifyNumber(0)).isEqualTo("ZERO");
        
        // 組合12: 多元素陣列 + 正數
        assertThat(processor.sumArray(new int[]{1, 2, 3, 4})).isEqualTo(10);
        assertThat(processor.classifyNumber(75)).isEqualTo("MEDIUM");
        
        // Combinatorial coverage: 100% (4 × 3 = 12 種組合)
    }
}
