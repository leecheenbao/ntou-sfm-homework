package com.ntou.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 測試案例 4：無效值測試
 * Mutation Testing Coverage 測試類
 */
public class CountPrimesTestCase4Test {

    private final NumberProcessor processor = new NumberProcessor();

    @Test
    @DisplayName("測試案例 4: n = 65536 - 無效值測試")
    void testCountPrimes_TestCase4_Invalid() {
        // Test Case 4: 無效值測試
        // 1) Input values: n = 65536
        // 2) Expected result: 拋出例外顯示, 數值應該介於 0 到 65535 之間
        // 3) Test program's result: 拋出例外顯示, 數值應該介於 0 到 65535 之間
        // 4) Criteria analysis: Mutation testing - 檢測迴圈和條件變異
        assertThatThrownBy(() -> processor.countPrimes(65536))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("數值應該介於 0 到 65535 之間");
    }
}

