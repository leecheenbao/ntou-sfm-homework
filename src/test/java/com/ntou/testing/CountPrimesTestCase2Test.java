package com.ntou.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * 測試案例 2：小於 2 的數測試
 * Mutation Testing Coverage 測試類
 */
public class CountPrimesTestCase2Test {

    private final NumberProcessor processor = new NumberProcessor();

    @Test
    @DisplayName("測試案例 2: n = 1 - 小於 2 的數")
    void testCountPrimes_TestCase2_One() {
        // Test Case 2: 小於 2 的數
        // 1) Input values: n = 1
        // 2) Expected result: 0
        // 3) Test program's result: 0
        // 4) Criteria analysis: Mutation testing - 檢測 < 運算子的變異
        assertThat(processor.countPrimes(1)).isEqualTo(0);
    }
}

