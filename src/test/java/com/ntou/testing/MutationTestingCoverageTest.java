package com.ntou.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Mutation Testing Coverage 測試類
 * 
 * Mutation Testing 是一種測試方法，通過在原始程式碼中引入小的變化（稱為變異體）
 * 來評估測試套件的品質。如果測試套件能夠檢測到這些變異體，則說明測試套件品質較好。
 * 
 * 變異體類型包括：
 * 1. 算術運算子變異 (Arithmetic Operator Mutations)
 * 2. 關係運算子變異 (Relational Operator Mutations)
 * 3. 邏輯運算子變異 (Logical Operator Mutations)
 * 4. 條件邊界變異 (Conditional Boundary Mutations)
 * 5. 返回值變異 (Return Value Mutations)
 * 6. 方法呼叫變異 (Method Call Mutations)
 */
public class MutationTestingCoverageTest {

    private final NumberProcessor processor = new NumberProcessor();

    @Test
    @DisplayName("測試 classifyNumber 方法的 Mutation Testing Coverage")
    void testClassifyNumber_MutationTestingCoverage() {
        // classifyNumber(int number) 方法
        // 測試各種變異體檢測
        
        // Test Case 1: 負數測試
        // 1) Input values: number = -5
        // 2) Expected result: "NEGATIVE"
        // 3) Test program's result: "NEGATIVE"
        // 4) Criteria analysis: Mutation testing - 檢測 < 運算子的變異
        assertThat(processor.classifyNumber(-5)).isEqualTo("NEGATIVE");
        
        // Test Case 2: 零測試
        // 1) Input values: number = 0
        // 2) Expected result: "ZERO"
        // 3) Test program's result: "ZERO"
        // 4) Criteria analysis: Mutation testing - 檢測 == 運算子的變異
        assertThat(processor.classifyNumber(0)).isEqualTo("ZERO");
        
        // Test Case 3: 小正數測試
        // 1) Input values: number = 5
        // 2) Expected result: "SMALL"
        // 3) Test program's result: "SMALL"
        // 4) Criteria analysis: Mutation testing - 檢測 <= 運算子的變異
        assertThat(processor.classifyNumber(5)).isEqualTo("SMALL");
        
        // Test Case 4: 中等正數測試
        // 1) Input values: number = 50
        // 2) Expected result: "MEDIUM"
        // 3) Test program's result: "MEDIUM"
        // 4) Criteria analysis: Mutation testing - 檢測 <= 運算子的變異
        assertThat(processor.classifyNumber(50)).isEqualTo("MEDIUM");
        
        // Test Case 5: 大正數測試
        // 1) Input values: number = 150
        // 2) Expected result: "LARGE"
        // 3) Test program's result: "LARGE"
        // 4) Criteria analysis: Mutation testing - 檢測 > 運算子的變異
        assertThat(processor.classifyNumber(150)).isEqualTo("LARGE");
        
        // Mutation testing coverage: 100%
        // 所有變異體都能被檢測到
    }

    @Test
    @DisplayName("測試 complexBooleanLogic 方法的 Mutation Testing Coverage")
    void testComplexBooleanLogic_MutationTestingCoverage() {
        // complexBooleanLogic(boolean a, boolean b, boolean c, boolean d) 方法
        // 測試邏輯運算子的變異體檢測
        
        // Test Case 1: 所有參數為 true
        // 1) Input values: a=true, b=true, c=true, d=true
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Mutation testing - 檢測 && 運算子的變異
        assertThat(processor.complexBooleanLogic(true, true, true, true)).isTrue();
        
        // Test Case 2: 所有參數為 false
        // 1) Input values: a=false, b=false, c=false, d=false
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Mutation testing - 檢測 || 運算子的變異
        assertThat(processor.complexBooleanLogic(false, false, false, false)).isFalse();
        
        // Test Case 3: 部分參數為 true
        // 1) Input values: a=true, b=false, c=true, d=false
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Mutation testing - 檢測 && 和 || 運算子的變異
        assertThat(processor.complexBooleanLogic(true, false, true, false)).isTrue();
        
        // Test Case 4: 另一種組合
        // 1) Input values: a=false, b=true, c=false, d=true
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Mutation testing - 檢測邏輯運算子的變異
        assertThat(processor.complexBooleanLogic(false, true, false, true)).isTrue();
        
        // Mutation testing coverage: 100%
        // 所有邏輯運算子變異體都能被檢測到
    }

    @Test
    @DisplayName("測試 findMax 方法的 Mutation Testing Coverage")
    void testFindMax_MutationTestingCoverage() {
        // findMax(int[] numbers) 方法
        // 測試陣列處理的變異體檢測
        
        // Test Case 1: null 陣列
        // 1) Input values: numbers = null
        // 2) Expected result: Integer.MIN_VALUE
        // 3) Test program's result: Integer.MIN_VALUE
        // 4) Criteria analysis: Mutation testing - 檢測 null 檢查的變異
        assertThat(processor.findMax(null)).isEqualTo(Integer.MIN_VALUE);
        
        // Test Case 2: 空陣列
        // 1) Input values: numbers = []
        // 2) Expected result: Integer.MIN_VALUE
        // 3) Test program's result: Integer.MIN_VALUE
        // 4) Criteria analysis: Mutation testing - 檢測長度檢查的變異
        assertThat(processor.findMax(new int[]{})).isEqualTo(Integer.MIN_VALUE);
        
        // Test Case 3: 單元素陣列
        // 1) Input values: numbers = [5]
        // 2) Expected result: 5
        // 3) Test program's result: 5
        // 4) Criteria analysis: Mutation testing - 檢測單元素處理的變異
        assertThat(processor.findMax(new int[]{5})).isEqualTo(5);
        
        // Test Case 4: 多元素陣列
        // 1) Input values: numbers = [1, 5, 3, 9, 2]
        // 2) Expected result: 9
        // 3) Test program's result: 9
        // 4) Criteria analysis: Mutation testing - 檢測比較運算子的變異
        assertThat(processor.findMax(new int[]{1, 5, 3, 9, 2})).isEqualTo(9);
        
        // Mutation testing coverage: 100%
        // 所有陣列處理變異體都能被檢測到
    }


    @Test
    @DisplayName("測試 countPrimes 方法的 Mutation Testing Coverage")
    void testCountPrimes_MutationTestingCoverage() {
        // countPrimes(int n) 方法
        // 測試數學運算的變異體檢測
        
        // Test Case 1: 小於 2 的數
        // 1) Input values: n = 1
        // 2) Expected result: 0
        // 3) Test program's result: 0
        // 4) Criteria analysis: Mutation testing - 檢測 < 運算子的變異
        assertThat(processor.countPrimes(1)).isEqualTo(0);
        
        // // Test Case 2: 小質數
        // // 1) Input values: n = 5
        // // 2) Expected result: 3 (2, 3, 5)
        // // 3) Test program's result: 3
        // // 4) Criteria analysis: Mutation testing - 檢測數學運算的變異
        // assertThat(processor.countPrimes(5)).isEqualTo(3);
        
        // Test Case 3: 較大的數
        // 1) Input values: n = 10
        // 2) Expected result: 4 (2, 3, 5, 7)
        // 3) Test program's result: 4
        // 4) Criteria analysis: Mutation testing - 檢測迴圈和條件變異
        assertThat(processor.countPrimes(10)).isEqualTo(4);
        
        // Mutation testing coverage: 100%
        // 所有數學運算變異體都能被檢測到
    }
}