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

    private final Calculator calculator = new Calculator();
    private final NumberProcessor processor = new NumberProcessor();

    @Test
    @DisplayName("測試 isPositive 方法的 Equivalence Partition Testing")
    void testIsPositive_EquivalencePartitionTesting() {
        // isPositive(int i) 方法
        // 輸入域：所有整數 (int 範圍)
        // 
        // 等價類劃分：
        // 有效等價類：
        //   EP1: 正整數 (i > 0) -> 預期結果: true
        //   EP2: 零 (i = 0) -> 預期結果: true
        // 無效等價類：
        //   EP3: 負整數 (i < 0) -> 預期結果: false

        // Test Case 1: 有效等價類 EP1 - 正整數
        // 1) Input values: i = 5 (代表正整數等價類)
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Equivalence partition testing - 測試正整數等價類
        assertThat(calculator.isPositive(5)).isTrue();

        // Test Case 2: 有效等價類 EP2 - 零
        // 1) Input values: i = 0 (代表零等價類)
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Equivalence partition testing - 測試零等價類
        assertThat(calculator.isPositive(0)).isTrue();

        // Test Case 3: 無效等價類 EP3 - 負整數
        // 1) Input values: i = -5 (代表負整數等價類)
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Equivalence partition testing - 測試負整數等價類
        assertThat(calculator.isPositive(-5)).isFalse();
    }

    @Test
    @DisplayName("測試 factorial 方法的 Equivalence Partition Testing")
    void testFactorial_EquivalencePartitionTesting() {
        // factorial(int n) 方法
        // 輸入域：所有整數 (int 範圍)
        // 
        // 等價類劃分：
        // 有效等價類：
        //   EP1: 正整數 (n > 0) -> 預期結果: n! (階乘值)
        //   EP2: 零 (n = 0) -> 預期結果: 1
        // 無效等價類：
        //   EP3: 負整數 (n < 0) -> 預期結果: -1 (錯誤值)

        // Test Case 1: 有效等價類 EP1 - 正整數
        // 1) Input values: n = 5 (代表正整數等價類)
        // 2) Expected result: 120 (5! = 120)
        // 3) Test program's result: 120
        // 4) Criteria analysis: Equivalence partition testing - 測試正整數等價類
        assertThat(calculator.factorial(5)).isEqualTo(120);

        // Test Case 2: 有效等價類 EP2 - 零
        // 1) Input values: n = 0 (代表零等價類)
        // 2) Expected result: 1 (0! = 1)
        // 3) Test program's result: 1
        // 4) Criteria analysis: Equivalence partition testing - 測試零等價類
        assertThat(calculator.factorial(0)).isEqualTo(1);

        // Test Case 3: 無效等價類 EP3 - 負整數
        // 1) Input values: n = -3 (代表負整數等價類)
        // 2) Expected result: -1 (錯誤值)
        // 3) Test program's result: -1
        // 4) Criteria analysis: Equivalence partition testing - 測試負整數等價類
        assertThat(calculator.factorial(-3)).isEqualTo(-1);
    }

    @Test
    @DisplayName("測試 classifyNumber 方法的 Equivalence Partition Testing")
    void testClassifyNumber_EquivalencePartitionTesting() {
        // classifyNumber(int number) 方法
        // 輸入域：所有整數 (int 範圍)
        // 
        // 等價類劃分：
        // 有效等價類：
        //   EP1: 負整數 (number < 0) -> 預期結果: "NEGATIVE"
        //   EP2: 零 (number = 0) -> 預期結果: "ZERO"
        //   EP3: 小正整數 (0 < number <= 10) -> 預期結果: "SMALL"
        //   EP4: 中等正整數 (10 < number <= 100) -> 預期結果: "MEDIUM"
        //   EP5: 大正整數 (number > 100) -> 預期結果: "LARGE"

        // Test Case 1: 有效等價類 EP1 - 負整數
        // 1) Input values: number = -10 (代表負整數等價類)
        // 2) Expected result: "NEGATIVE"
        // 3) Test program's result: "NEGATIVE"
        // 4) Criteria analysis: Equivalence partition testing - 測試負整數等價類
        assertThat(processor.classifyNumber(-10)).isEqualTo("NEGATIVE");

        // Test Case 2: 有效等價類 EP2 - 零
        // 1) Input values: number = 0 (代表零等價類)
        // 2) Expected result: "ZERO"
        // 3) Test program's result: "ZERO"
        // 4) Criteria analysis: Equivalence partition testing - 測試零等價類
        assertThat(processor.classifyNumber(0)).isEqualTo("ZERO");

        // Test Case 3: 有效等價類 EP3 - 小正整數
        // 1) Input values: number = 5 (代表小正整數等價類)
        // 2) Expected result: "SMALL"
        // 3) Test program's result: "SMALL"
        // 4) Criteria analysis: Equivalence partition testing - 測試小正整數等價類
        assertThat(processor.classifyNumber(5)).isEqualTo("SMALL");

        // Test Case 4: 有效等價類 EP4 - 中等正整數
        // 1) Input values: number = 50 (代表中等正整數等價類)
        // 2) Expected result: "MEDIUM"
        // 3) Test program's result: "MEDIUM"
        // 4) Criteria analysis: Equivalence partition testing - 測試中等正整數等價類
        assertThat(processor.classifyNumber(50)).isEqualTo("MEDIUM");

        // Test Case 5: 有效等價類 EP5 - 大正整數
        // 1) Input values: number = 150 (代表大正整數等價類)
        // 2) Expected result: "LARGE"
        // 3) Test program's result: "LARGE"
        // 4) Criteria analysis: Equivalence partition testing - 測試大正整數等價類
        assertThat(processor.classifyNumber(150)).isEqualTo("LARGE");
    }

    @Test
    @DisplayName("測試 sumArray 方法的 Equivalence Partition Testing")
    void testSumArray_EquivalencePartitionTesting() {
        // sumArray(int[] numbers) 方法
        // 輸入域：所有整數陣列
        // 
        // 等價類劃分：
        // 有效等價類：
        //   EP1: null 陣列 -> 預期結果: 0
        //   EP2: 空陣列 (長度為 0) -> 預期結果: 0
        //   EP3: 單元素陣列 (長度為 1) -> 預期結果: 該元素值
        //   EP4: 多元素陣列 (長度 > 1) -> 預期結果: 所有元素的和

        // Test Case 1: 有效等價類 EP1 - null 陣列
        // 1) Input values: numbers = null (代表 null 陣列等價類)
        // 2) Expected result: 0
        // 3) Test program's result: 0
        // 4) Criteria analysis: Equivalence partition testing - 測試 null 陣列等價類
        assertThat(processor.sumArray(null)).isEqualTo(0);

        // Test Case 2: 有效等價類 EP2 - 空陣列
        // 1) Input values: numbers = [] (代表空陣列等價類)
        // 2) Expected result: 0
        // 3) Test program's result: 0
        // 4) Criteria analysis: Equivalence partition testing - 測試空陣列等價類
        assertThat(processor.sumArray(new int[0])).isEqualTo(0);

        // Test Case 3: 有效等價類 EP3 - 單元素陣列
        // 1) Input values: numbers = [5] (代表單元素陣列等價類)
        // 2) Expected result: 5
        // 3) Test program's result: 5
        // 4) Criteria analysis: Equivalence partition testing - 測試單元素陣列等價類
        assertThat(processor.sumArray(new int[]{5})).isEqualTo(5);

        // Test Case 4: 有效等價類 EP4 - 多元素陣列
        // 1) Input values: numbers = [1, 2, 3, 4, 5] (代表多元素陣列等價類)
        // 2) Expected result: 15
        // 3) Test program's result: 15
        // 4) Criteria analysis: Equivalence partition testing - 測試多元素陣列等價類
        assertThat(processor.sumArray(new int[]{1, 2, 3, 4, 5})).isEqualTo(15);
    }

    @Test
    @DisplayName("測試 isValidPassword 方法的 Equivalence Partition Testing")
    void testIsValidPassword_EquivalencePartitionTesting() {
        // isValidPassword(String password) 方法
        // 輸入域：所有字串
        // 
        // 等價類劃分：
        // 無效等價類：
        //   EP1: null 字串 -> 預期結果: false
        //   EP2: 空字串 (長度為 0) -> 預期結果: false
        //   EP3: 短字串 (長度 < 6) -> 預期結果: false
        //   EP4: 只有數字的字串 (長度 >= 6，只有數字) -> 預期結果: false
        //   EP5: 只有字母的字串 (長度 >= 6，只有字母) -> 預期結果: false
        // 有效等價類：
        //   EP6: 有效密碼 (長度 >= 6，包含數字和字母) -> 預期結果: true

        // Test Case 1: 無效等價類 EP1 - null 字串
        // 1) Input values: password = null (代表 null 字串等價類)
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Equivalence partition testing - 測試 null 字串等價類
        assertThat(processor.isValidPassword(null)).isFalse();

        // Test Case 2: 無效等價類 EP2 - 空字串
        // 1) Input values: password = "" (代表空字串等價類)
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Equivalence partition testing - 測試空字串等價類
        assertThat(processor.isValidPassword("")).isFalse();

        // Test Case 3: 無效等價類 EP3 - 短字串
        // 1) Input values: password = "12345" (代表短字串等價類)
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Equivalence partition testing - 測試短字串等價類
        assertThat(processor.isValidPassword("12345")).isFalse();

        // Test Case 4: 無效等價類 EP4 - 只有數字的字串
        // 1) Input values: password = "123456" (代表只有數字的字串等價類)
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Equivalence partition testing - 測試只有數字的字串等價類
        assertThat(processor.isValidPassword("123456")).isFalse();

        // Test Case 5: 無效等價類 EP5 - 只有字母的字串
        // 1) Input values: password = "abcdef" (代表只有字母的字串等價類)
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Equivalence partition testing - 測試只有字母的字串等價類
        assertThat(processor.isValidPassword("abcdef")).isFalse();

        // Test Case 6: 有效等價類 EP6 - 有效密碼
        // 1) Input values: password = "abc123" (代表有效密碼等價類)
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Equivalence partition testing - 測試有效密碼等價類
        assertThat(processor.isValidPassword("abc123")).isTrue();
    }

    @Test
    @DisplayName("測試 countPrimes 方法的 Equivalence Partition Testing")
    void testCountPrimes_EquivalencePartitionTesting() {
        // countPrimes(int n) 方法
        // 輸入域：所有整數 (int 範圍)
        // 
        // 等價類劃分：
        // 有效等價類：
        //   EP1: 小於 2 的整數 (n < 2) -> 預期結果: 0 (沒有質數)
        //   EP2: 小質數範圍 (2 <= n <= 10) -> 預期結果: 質數個數
        //   EP3: 中等範圍 (10 < n <= 100) -> 預期結果: 質數個數
        //   EP4: 大範圍 (n > 100) -> 預期結果: 質數個數

        // Test Case 1: 有效等價類 EP1 - 小於 2 的整數
        // 1) Input values: n = 1 (代表小於 2 的整數等價類)
        // 2) Expected result: 0
        // 3) Test program's result: 0
        // 4) Criteria analysis: Equivalence partition testing - 測試小於 2 的整數等價類
        assertThat(processor.countPrimes(1)).isEqualTo(0);

        // Test Case 2: 有效等價類 EP2 - 小質數範圍
        // 1) Input values: n = 10 (代表小質數範圍等價類)
        // 2) Expected result: 4 (2, 3, 5, 7)
        // 3) Test program's result: 4
        // 4) Criteria analysis: Equivalence partition testing - 測試小質數範圍等價類
        assertThat(processor.countPrimes(10)).isEqualTo(4);

        // Test Case 3: 有效等價類 EP3 - 中等範圍
        // 1) Input values: n = 25 (代表中等範圍等價類)
        // 2) Expected result: 9 (2, 3, 5, 7, 11, 13, 17, 19, 23)
        // 3) Test program's result: 9
        // 4) Criteria analysis: Equivalence partition testing - 測試中等範圍等價類
        assertThat(processor.countPrimes(25)).isEqualTo(9);

        // Test Case 4: 有效等價類 EP4 - 大範圍
        // 1) Input values: n = 50 (代表大範圍等價類)
        // 2) Expected result: 15 (2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47)
        // 3) Test program's result: 15
        // 4) Criteria analysis: Equivalence partition testing - 測試大範圍等價類
        assertThat(processor.countPrimes(50)).isEqualTo(15);
    }
}

