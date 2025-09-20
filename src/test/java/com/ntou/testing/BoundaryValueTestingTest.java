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

    private final Calculator calculator = new Calculator();
    private final NumberProcessor processor = new NumberProcessor();

    @Test
    @DisplayName("測試 isPositive 方法的 Boundary Value Testing")
    void testIsPositive_BoundaryValueTesting() {
        // isPositive(int i) 方法
        // 邊界條件：i >= 0
        // 邊界值：0
        // 
        // 邊界值測試策略：
        // 1. 邊界值-1: -1 (應該返回 false)
        // 2. 邊界值: 0 (應該返回 true)
        // 3. 邊界值+1: 1 (應該返回 true)

        // Test Case 1: 邊界值-1
        // 1) Input values: i = -1 (邊界值 0 的前一個值)
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Boundary value testing - 測試邊界值-1
        assertThat(calculator.isPositive(-1)).isFalse();

        // Test Case 2: 邊界值
        // 1) Input values: i = 0 (邊界值)
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Boundary value testing - 測試邊界值
        assertThat(calculator.isPositive(0)).isTrue();

        // Test Case 3: 邊界值+1
        // 1) Input values: i = 1 (邊界值 0 的下一個值)
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Boundary value testing - 測試邊界值+1
        assertThat(calculator.isPositive(1)).isTrue();
    }

    @Test
    @DisplayName("測試 factorial 方法的 Boundary Value Testing")
    void testFactorial_BoundaryValueTesting() {
        // factorial(int n) 方法
        // 邊界條件：n < 0 (無效), n >= 0 (有效)
        // 邊界值：0, 1
        // 
        // 邊界值測試策略：
        // 1. 負數邊界: -1 (應該返回 -1)
        // 2. 零邊界: 0 (應該返回 1)
        // 3. 小正數: 1 (應該返回 1)
        // 4. 小正數+1: 2 (應該返回 2)

        // Test Case 1: 負數邊界
        // 1) Input values: n = -1 (負數邊界)
        // 2) Expected result: -1 (錯誤值)
        // 3) Test program's result: -1
        // 4) Criteria analysis: Boundary value testing - 測試負數邊界
        assertThat(calculator.factorial(-1)).isEqualTo(-1);

        // Test Case 2: 零邊界
        // 1) Input values: n = 0 (零邊界)
        // 2) Expected result: 1 (0! = 1)
        // 3) Test program's result: 1
        // 4) Criteria analysis: Boundary value testing - 測試零邊界
        assertThat(calculator.factorial(0)).isEqualTo(1);

        // Test Case 3: 小正數
        // 1) Input values: n = 1 (小正數邊界)
        // 2) Expected result: 1 (1! = 1)
        // 3) Test program's result: 1
        // 4) Criteria analysis: Boundary value testing - 測試小正數邊界
        assertThat(calculator.factorial(1)).isEqualTo(1);

        // Test Case 4: 小正數+1
        // 1) Input values: n = 2 (小正數+1)
        // 2) Expected result: 2 (2! = 2)
        // 3) Test program's result: 2
        // 4) Criteria analysis: Boundary value testing - 測試小正數+1
        assertThat(calculator.factorial(2)).isEqualTo(2);
    }

    @Test
    @DisplayName("測試 classifyNumber 方法的 Boundary Value Testing")
    void testClassifyNumber_BoundaryValueTesting() {
        // classifyNumber(int number) 方法
        // 邊界條件：
        //   number < 0 -> "NEGATIVE"
        //   number == 0 -> "ZERO"
        //   0 < number <= 10 -> "SMALL"
        //   10 < number <= 100 -> "MEDIUM"
        //   number > 100 -> "LARGE"
        // 
        // 邊界值：-1, 0, 1, 10, 11, 100, 101
        // 
        // 邊界值測試策略：
        // 1. 負數邊界: -1 (應該返回 "NEGATIVE")
        // 2. 零邊界: 0 (應該返回 "ZERO")
        // 3. 小數邊界: 1 (應該返回 "SMALL")
        // 4. 小數上限: 10 (應該返回 "SMALL")
        // 5. 中數下限: 11 (應該返回 "MEDIUM")
        // 6. 中數上限: 100 (應該返回 "MEDIUM")
        // 7. 大數下限: 101 (應該返回 "LARGE")

        // Test Case 1: 負數邊界
        // 1) Input values: number = -1 (負數邊界)
        // 2) Expected result: "NEGATIVE"
        // 3) Test program's result: "NEGATIVE"
        // 4) Criteria analysis: Boundary value testing - 測試負數邊界
        assertThat(processor.classifyNumber(-1)).isEqualTo("NEGATIVE");

        // Test Case 2: 零邊界
        // 1) Input values: number = 0 (零邊界)
        // 2) Expected result: "ZERO"
        // 3) Test program's result: "ZERO"
        // 4) Criteria analysis: Boundary value testing - 測試零邊界
        assertThat(processor.classifyNumber(0)).isEqualTo("ZERO");

        // Test Case 3: 小數邊界
        // 1) Input values: number = 1 (小數邊界)
        // 2) Expected result: "SMALL"
        // 3) Test program's result: "SMALL"
        // 4) Criteria analysis: Boundary value testing - 測試小數邊界
        assertThat(processor.classifyNumber(1)).isEqualTo("SMALL");

        // Test Case 4: 小數上限
        // 1) Input values: number = 10 (小數上限)
        // 2) Expected result: "SMALL"
        // 3) Test program's result: "SMALL"
        // 4) Criteria analysis: Boundary value testing - 測試小數上限
        assertThat(processor.classifyNumber(10)).isEqualTo("SMALL");

        // Test Case 5: 中數下限
        // 1) Input values: number = 11 (中數下限)
        // 2) Expected result: "MEDIUM"
        // 3) Test program's result: "MEDIUM"
        // 4) Criteria analysis: Boundary value testing - 測試中數下限
        assertThat(processor.classifyNumber(11)).isEqualTo("MEDIUM");

        // Test Case 6: 中數上限
        // 1) Input values: number = 100 (中數上限)
        // 2) Expected result: "MEDIUM"
        // 3) Test program's result: "MEDIUM"
        // 4) Criteria analysis: Boundary value testing - 測試中數上限
        assertThat(processor.classifyNumber(100)).isEqualTo("MEDIUM");

        // Test Case 7: 大數下限
        // 1) Input values: number = 101 (大數下限)
        // 2) Expected result: "LARGE"
        // 3) Test program's result: "LARGE"
        // 4) Criteria analysis: Boundary value testing - 測試大數下限
        assertThat(processor.classifyNumber(101)).isEqualTo("LARGE");
    }

    @Test
    @DisplayName("測試 isValidPassword 方法的 Boundary Value Testing")
    void testIsValidPassword_BoundaryValueTesting() {
        // isValidPassword(String password) 方法
        // 邊界條件：password != null && password.length() >= 6
        // 邊界值：長度 5, 6, 7
        // 
        // 邊界值測試策略：
        // 1. 長度邊界-1: 長度為 5 的字串 (應該返回 false)
        // 2. 長度邊界: 長度為 6 的字串，只有數字 (應該返回 false)
        // 3. 長度邊界: 長度為 6 的字串，只有字母 (應該返回 false)
        // 4. 長度邊界: 長度為 6 的字串，包含數字和字母 (應該返回 true)
        // 5. 長度邊界+1: 長度為 7 的字串，包含數字和字母 (應該返回 true)

        // Test Case 1: 長度邊界-1
        // 1) Input values: password = "12345" (長度為 5)
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Boundary value testing - 測試長度邊界-1
        assertThat(processor.isValidPassword("12345")).isFalse();

        // Test Case 2: 長度邊界 - 只有數字
        // 1) Input values: password = "123456" (長度為 6，只有數字)
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Boundary value testing - 測試長度邊界，只有數字
        assertThat(processor.isValidPassword("123456")).isFalse();

        // Test Case 3: 長度邊界 - 只有字母
        // 1) Input values: password = "abcdef" (長度為 6，只有字母)
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Boundary value testing - 測試長度邊界，只有字母
        assertThat(processor.isValidPassword("abcdef")).isFalse();

        // Test Case 4: 長度邊界 - 有效密碼
        // 1) Input values: password = "abc123" (長度為 6，包含數字和字母)
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Boundary value testing - 測試長度邊界，有效密碼
        assertThat(processor.isValidPassword("abc123")).isTrue();

        // Test Case 5: 長度邊界+1
        // 1) Input values: password = "abc1234" (長度為 7，包含數字和字母)
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Boundary value testing - 測試長度邊界+1
        assertThat(processor.isValidPassword("abc1234")).isTrue();
    }

    @Test
    @DisplayName("測試 countPrimes 方法的 Boundary Value Testing")
    void testCountPrimes_BoundaryValueTesting() {
        // countPrimes(int n) 方法
        // 邊界條件：n < 2 (返回 0), n >= 2 (計算質數)
        // 邊界值：1, 2, 3
        // 
        // 邊界值測試策略：
        // 1. 邊界值-1: n = 1 (應該返回 0)
        // 2. 邊界值: n = 2 (應該返回 1)
        // 3. 邊界值+1: n = 3 (應該返回 2)

        // Test Case 1: 邊界值-1
        // 1) Input values: n = 1 (邊界值 2 的前一個值)
        // 2) Expected result: 0 (沒有質數)
        // 3) Test program's result: 0
        // 4) Criteria analysis: Boundary value testing - 測試邊界值-1
        assertThat(processor.countPrimes(1)).isEqualTo(0);

        // Test Case 2: 邊界值
        // 1) Input values: n = 2 (邊界值，第一個質數)
        // 2) Expected result: 1 (只有質數 2)
        // 3) Test program's result: 1
        // 4) Criteria analysis: Boundary value testing - 測試邊界值
        assertThat(processor.countPrimes(2)).isEqualTo(1);

        // Test Case 3: 邊界值+1
        // 1) Input values: n = 3 (邊界值 2 的下一個值)
        // 2) Expected result: 2 (質數 2, 3)
        // 3) Test program's result: 2
        // 4) Criteria analysis: Boundary value testing - 測試邊界值+1
        assertThat(processor.countPrimes(3)).isEqualTo(2);
    }

    @Test
    @DisplayName("測試 sumArray 方法的 Boundary Value Testing")
    void testSumArray_BoundaryValueTesting() {
        // sumArray(int[] numbers) 方法
        // 邊界條件：陣列長度
        // 邊界值：長度 0, 1, 2
        // 
        // 邊界值測試策略：
        // 1. 長度邊界: 空陣列 (應該返回 0)
        // 2. 長度邊界+1: 單元素陣列 (應該返回該元素值)
        // 3. 長度邊界+2: 雙元素陣列 (應該返回兩元素之和)

        // Test Case 1: 長度邊界
        // 1) Input values: numbers = [] (空陣列)
        // 2) Expected result: 0
        // 3) Test program's result: 0
        // 4) Criteria analysis: Boundary value testing - 測試空陣列邊界
        assertThat(processor.sumArray(new int[0])).isEqualTo(0);

        // Test Case 2: 長度邊界+1
        // 1) Input values: numbers = [5] (單元素陣列)
        // 2) Expected result: 5
        // 3) Test program's result: 5
        // 4) Criteria analysis: Boundary value testing - 測試單元素陣列邊界
        assertThat(processor.sumArray(new int[]{5})).isEqualTo(5);

        // Test Case 3: 長度邊界+2
        // 1) Input values: numbers = [3, 7] (雙元素陣列)
        // 2) Expected result: 10
        // 3) Test program's result: 10
        // 4) Criteria analysis: Boundary value testing - 測試雙元素陣列邊界
        assertThat(processor.sumArray(new int[]{3, 7})).isEqualTo(10);
    }

    @Test
    @DisplayName("測試 boundaryTest 方法的 Boundary Value Testing")
    void testBoundaryTest_BoundaryValueTesting() {
        // boundaryTest(int value) 方法
        // 邊界條件：
        //   value < 10 -> "LOW"
        //   value == 10 -> "BOUNDARY_LOW"
        //   10 < value < 100 -> "MIDDLE"
        //   value == 100 -> "BOUNDARY_HIGH"
        //   value > 100 -> "HIGH"
        // 
        // 邊界值：9, 10, 11, 99, 100, 101
        // 
        // 邊界值測試策略：
        // 1. 低值上限: value = 9 (應該返回 "LOW")
        // 2. 低值邊界: value = 10 (應該返回 "BOUNDARY_LOW")
        // 3. 中值下限: value = 11 (應該返回 "MIDDLE")
        // 4. 中值上限: value = 99 (應該返回 "MIDDLE")
        // 5. 高值邊界: value = 100 (應該返回 "BOUNDARY_HIGH")
        // 6. 高值下限: value = 101 (應該返回 "HIGH")

        // Test Case 1: 低值上限
        // 1) Input values: value = 9 (低值上限)
        // 2) Expected result: "LOW"
        // 3) Test program's result: "LOW"
        // 4) Criteria analysis: Boundary value testing - 測試低值上限
        assertThat(calculator.boundaryTest(9)).isEqualTo("LOW");

        // Test Case 2: 低值邊界
        // 1) Input values: value = 10 (低值邊界)
        // 2) Expected result: "BOUNDARY_LOW"
        // 3) Test program's result: "BOUNDARY_LOW"
        // 4) Criteria analysis: Boundary value testing - 測試低值邊界
        assertThat(calculator.boundaryTest(10)).isEqualTo("BOUNDARY_LOW");

        // Test Case 3: 中值下限
        // 1) Input values: value = 11 (中值下限)
        // 2) Expected result: "MIDDLE"
        // 3) Test program's result: "MIDDLE"
        // 4) Criteria analysis: Boundary value testing - 測試中值下限
        assertThat(calculator.boundaryTest(11)).isEqualTo("MIDDLE");

        // Test Case 4: 中值上限
        // 1) Input values: value = 99 (中值上限)
        // 2) Expected result: "MIDDLE"
        // 3) Test program's result: "MIDDLE"
        // 4) Criteria analysis: Boundary value testing - 測試中值上限
        assertThat(calculator.boundaryTest(99)).isEqualTo("MIDDLE");

        // Test Case 5: 高值邊界
        // 1) Input values: value = 100 (高值邊界)
        // 2) Expected result: "BOUNDARY_HIGH"
        // 3) Test program's result: "BOUNDARY_HIGH"
        // 4) Criteria analysis: Boundary value testing - 測試高值邊界
        assertThat(calculator.boundaryTest(100)).isEqualTo("BOUNDARY_HIGH");

        // Test Case 6: 高值下限
        // 1) Input values: value = 101 (高值下限)
        // 2) Expected result: "HIGH"
        // 3) Test program's result: "HIGH"
        // 4) Criteria analysis: Boundary value testing - 測試高值下限
        assertThat(calculator.boundaryTest(101)).isEqualTo("HIGH");
    }
}

