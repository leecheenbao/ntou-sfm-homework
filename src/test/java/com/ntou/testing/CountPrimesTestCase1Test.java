package com.ntou.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * 測試案例 1：零測試
 * Mutation Testing Coverage 測試類
 */
public class CountPrimesTestCase1Test {

    private final NumberProcessor processor = new NumberProcessor();

    @Test
    @DisplayName("測試案例 1: n = 0 - 零測試")
    void testCountPrimes_TestCase1_Zero() {
        // Test Case 1: 零測試
        // 1) Input values: n = 0
        // 2) Expected result: 0
        // 3) Test program's result: 0
        // 4) Criteria analysis: Mutation testing - 檢測迴圈和條件變異
        assertThat(processor.countPrimes(0)).isEqualTo(0);
    }
}

