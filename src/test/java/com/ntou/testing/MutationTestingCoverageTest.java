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

    private final Calculator calculator = new Calculator();
    private final NumberProcessor processor = new NumberProcessor();

    @Test
    @DisplayName("測試 isPositive 方法的 Mutation Testing Coverage")
    void testIsPositive_MutationTestingCoverage() {
        // isPositive(int i) 方法
        // 原始程式碼：if (i >= 0) return true; else return false;
        // 
        // 可能的變異體：
        // 1. 關係運算子變異：i >= 0 變為 i > 0
        // 2. 關係運算子變異：i >= 0 變為 i <= 0
        // 3. 關係運算子變異：i >= 0 變為 i < 0
        // 4. 關係運算子變異：i >= 0 變為 i == 0
        // 5. 返回值變異：return true 變為 return false
        // 6. 返回值變異：return false 變為 return true

        // Test Case 1: 正數
        // 1) Input values: i = 5
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Mutation testing - 檢測關係運算子變異和返回值變異
        assertThat(calculator.isPositive(5)).isTrue();

        // Test Case 2: 負數
        // 1) Input values: i = -5
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Mutation testing - 檢測負數的變異
        assertThat(calculator.isPositive(-5)).isFalse();

        // Test Case 3: 零值
        // 1) Input values: i = 0
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Mutation testing - 檢測零值邊界的變異
        assertThat(calculator.isPositive(0)).isTrue();

        // Test Case 4: 大正數
        // 1) Input values: i = 1000
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Mutation testing - 檢測大數值的變異
        assertThat(calculator.isPositive(1000)).isTrue();
    }

    @Test
    @DisplayName("測試 factorial 方法的 Mutation Testing Coverage")
    void testFactorial_MutationTestingCoverage() {
        // factorial(int n) 方法
        // 原始程式碼包含條件判斷和迴圈
        // 
        // 可能的變異體：
        // 1. 條件邊界變異：if (n < 1) 變為 if (n < 0)
        // 2. 條件邊界變異：if (n == 0 || n == 1) 變為 if (n == 0 && n == 1)
        // 3. 算術運算子變異：result *= i 變為 result += i
        // 4. 算術運算子變異：result *= i 變為 result -= i
        // 5. 算術運算子變異：result *= i 變為 result /= i
        // 6. 關係運算子變異：i <= n 變為 i < n
        // 7. 返回值變異：return 1 變為 return 0

        // Test Case 1: 邊界值 0
        // 1) Input values: n = 0
        // 2) Expected result: 1
        // 3) Test program's result: 1
        // 4) Criteria analysis: Mutation testing - 檢測邊界條件變異
        assertThat(calculator.factorial(0)).isEqualTo(1);

        // Test Case 2: 邊界值 1
        // 1) Input values: n = 1
        // 2) Expected result: 1
        // 3) Test program's result: 1
        // 4) Criteria analysis: Mutation testing - 檢測邊界條件變異
        assertThat(calculator.factorial(1)).isEqualTo(1);

        // Test Case 3: 正常值 5
        // 1) Input values: n = 5
        // 2) Expected result: 120
        // 3) Test program's result: 120
        // 4) Criteria analysis: Mutation testing - 檢測迴圈和算術運算子變異
        assertThat(calculator.factorial(5)).isEqualTo(120);

        // Test Case 4: 較大值 10
        // 1) Input values: n = 10
        // 2) Expected result: 3628800
        // 3) Test program's result: 3628800
        // 4) Criteria analysis: Mutation testing - 檢測複雜迴圈變異
        assertThat(calculator.factorial(10)).isEqualTo(3628800);

        // Test Case 5: 負數 (錯誤情況)
        // 1) Input values: n = -1
        // 2) Expected result: -1 (錯誤值)
        // 3) Test program's result: -1
        // 4) Criteria analysis: Mutation testing - 檢測錯誤處理變異
        assertThat(calculator.factorial(-1)).isEqualTo(-1);
    }

    @Test
    @DisplayName("測試 classifyNumber 方法的 Mutation Testing Coverage")
    void testClassifyNumber_MutationTestingCoverage() {
        // classifyNumber(int number) 方法
        // 原始程式碼包含多個條件判斷
        // 
        // 可能的變異體：
        // 1. 關係運算子變異：number < 0 變為 number <= 0
        // 2. 關係運算子變異：number == 0 變為 number != 0
        // 3. 關係運算子變異：number <= 10 變為 number < 10
        // 4. 關係運算子變異：number <= 100 變為 number < 100
        // 5. 邏輯運算子變異：else if 變為 if
        // 6. 返回值變異：return "NEGATIVE" 變為 return "POSITIVE"
        // 7. 條件邊界變異：邊界值的微小變化

        // Test Case 1: 負數
        // 1) Input values: number = -5
        // 2) Expected result: "NEGATIVE"
        // 3) Test program's result: "NEGATIVE"
        // 4) Criteria analysis: Mutation testing - 檢測關係運算子變異 (number < 0)
        assertThat(processor.classifyNumber(-5)).isEqualTo("NEGATIVE");

        // Test Case 2: 零值
        // 1) Input values: number = 0
        // 2) Expected result: "ZERO"
        // 3) Test program's result: "ZERO"
        // 4) Criteria analysis: Mutation testing - 檢測關係運算子變異 (number == 0)
        assertThat(processor.classifyNumber(0)).isEqualTo("ZERO");

        // Test Case 3: 小數
        // 1) Input values: number = 5
        // 2) Expected result: "SMALL"
        // 3) Test program's result: "SMALL"
        // 4) Criteria analysis: Mutation testing - 檢測關係運算子變異 (number <= 10)
        assertThat(processor.classifyNumber(5)).isEqualTo("SMALL");

        // Test Case 4: 邊界值 10
        // 1) Input values: number = 10
        // 2) Expected result: "SMALL"
        // 3) Test program's result: "SMALL"
        // 4) Criteria analysis: Mutation testing - 檢測邊界條件變異 (10 <= 10 vs 10 < 10)
        assertThat(processor.classifyNumber(10)).isEqualTo("SMALL");

        // Test Case 5: 中等數
        // 1) Input values: number = 50
        // 2) Expected result: "MEDIUM"
        // 3) Test program's result: "MEDIUM"
        // 4) Criteria analysis: Mutation testing - 檢測關係運算子變異 (number <= 100)
        assertThat(processor.classifyNumber(50)).isEqualTo("MEDIUM");

        // Test Case 6: 邊界值 100
        // 1) Input values: number = 100
        // 2) Expected result: "MEDIUM"
        // 3) Test program's result: "MEDIUM"
        // 4) Criteria analysis: Mutation testing - 檢測邊界條件變異 (100 <= 100 vs 100 < 100)
        assertThat(processor.classifyNumber(100)).isEqualTo("MEDIUM");

        // Test Case 7: 大數
        // 1) Input values: number = 150
        // 2) Expected result: "LARGE"
        // 3) Test program's result: "LARGE"
        // 4) Criteria analysis: Mutation testing - 檢測關係運算子變異 (number > 100)
        assertThat(processor.classifyNumber(150)).isEqualTo("LARGE");
    }

    @Test
    @DisplayName("測試 complexLogic 方法的 Mutation Testing Coverage")
    void testComplexLogic_MutationTestingCoverage() {
        // complexLogic(boolean x, boolean y, boolean z) 方法
        // 原始程式碼：return (x && y) || z;
        // 
        // 可能的變異體：
        // 1. 邏輯運算子變異：(x && y) || z 變為 (x && y) && z
        // 2. 邏輯運算子變異：(x && y) || z 變為 (x || y) || z
        // 3. 邏輯運算子變異：(x && y) || z 變為 (x && y) || !z
        // 4. 邏輯運算子變異：(x && y) || z 變為 (!x && y) || z
        // 5. 邏輯運算子變異：(x && y) || z 變為 (x && !y) || z
        // 6. 返回值變異：return true; 或 return false;

        // Test Case 1: 所有參數為 true
        // 1) Input values: x = true, y = true, z = true
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Mutation testing - 檢測邏輯運算子變異
        assertThat(calculator.complexLogic(true, true, true)).isTrue();

        // Test Case 2: 前兩個參數為 true，第三個為 false
        // 1) Input values: x = true, y = true, z = false
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Mutation testing - 檢測 && 運算子的變異
        assertThat(calculator.complexLogic(true, true, false)).isTrue();

        // Test Case 3: 前兩個參數為 false，第三個為 true
        // 1) Input values: x = false, y = false, z = true
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Mutation testing - 檢測 || 運算子的變異
        assertThat(calculator.complexLogic(false, false, true)).isFalse();

        // Test Case 4: 所有參數為 false
        // 1) Input values: x = false, y = false, z = false
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Mutation testing - 檢測邏輯運算子變異
        assertThat(calculator.complexLogic(false, false, false)).isFalse();

        // Test Case 5: 混合情況 1
        // 1) Input values: x = true, y = false, z = false
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Mutation testing - 檢測 && 運算子的變異
        assertThat(calculator.complexLogic(true, false, false)).isFalse();

        // Test Case 6: 混合情況 2
        // 1) Input values: x = false, y = true, z = true
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Mutation testing - 檢測 || 運算子的變異
        assertThat(calculator.complexLogic(false, true, true)).isTrue();
    }

    @Test
    @DisplayName("測試 gcd 方法的 Mutation Testing Coverage")
    void testGcd_MutationTestingCoverage() {
        // gcd(int a, int b) 方法
        // 原始程式碼包含複雜的迴圈和條件判斷
        // 
        // 可能的變異體：
        // 1. 條件邊界變異：a == 0 變為 a <= 0
        // 2. 條件邊界變異：b != 0 變為 b > 0
        // 3. 算術運算子變異：a % b 變為 a / b
        // 4. 算術運算子變異：a % b 變為 a * b
        // 5. 算術運算子變異：a % b 變為 a + b
        // 6. 算術運算子變異：a % b 變為 a - b
        // 7. 方法呼叫變異：Math.abs(a) 變為 Math.abs(b)

        // Test Case 1: 零值情況
        // 1) Input values: a = 0, b = 5
        // 2) Expected result: 5
        // 3) Test program's result: 5
        // 4) Criteria analysis: Mutation testing - 檢測條件邊界變異
        assertThat(calculator.gcd(0, 5)).isEqualTo(5);

        // Test Case 2: 正常情況
        // 1) Input values: a = 12, b = 8
        // 2) Expected result: 4
        // 3) Test program's result: 4
        // 4) Criteria analysis: Mutation testing - 檢測迴圈和算術運算子變異
        assertThat(calculator.gcd(12, 8)).isEqualTo(4);

        // Test Case 3: 負數情況
        // 1) Input values: a = -12, b = -8
        // 2) Expected result: 4
        // 3) Test program's result: 4
        // 4) Criteria analysis: Mutation testing - 檢測 Math.abs 方法呼叫變異
        assertThat(calculator.gcd(-12, -8)).isEqualTo(4);

        // Test Case 4: 相同數字
        // 1) Input values: a = 7, b = 7
        // 2) Expected result: 7
        // 3) Test program's result: 7
        // 4) Criteria analysis: Mutation testing - 檢測迴圈條件變異
        assertThat(calculator.gcd(7, 7)).isEqualTo(7);

        // Test Case 5: 質數情況
        // 1) Input values: a = 17, b = 13
        // 2) Expected result: 1
        // 3) Test program's result: 1
        // 4) Criteria analysis: Mutation testing - 檢測複雜迴圈變異
        assertThat(calculator.gcd(17, 13)).isEqualTo(1);
    }
}
