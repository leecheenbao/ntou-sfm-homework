package com.ntou.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * 測試案例 3：較大的數測試
 * Mutation Testing Coverage 測試類
 */
public class CountPrimesTestCase3Test {

    private final NumberProcessor processor = new NumberProcessor();

    @Test
    @DisplayName("測試案例 3: n = 65535 - 較大的數")
    void testCountPrimes_TestCase3_Large() {
        // Test Case 3: 較大的數
        // 1) Input values: n = 65535
        // 2) Expected result: 6542
        // 3) Test program's result: 6542
        // 4) Criteria analysis: Mutation testing - 檢測迴圈和條件變異
        assertThat(processor.countPrimes(65535)).isEqualTo(6542);
    }
}

