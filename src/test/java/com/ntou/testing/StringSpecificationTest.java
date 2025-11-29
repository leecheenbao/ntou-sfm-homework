package com.ntou.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * StringSpecification 等價類別分割測試
 * Equivalence Partition Testing - Valid/Invalid
 * 
 * 測試目標：
 * 使用最少個測試案例達到測試目標涵蓋率 100%
 * 
 * 等價類別分析：
 * 
 * 1. Starting char (起始字元):
 *    - Valid: Starts 1-9 (編號 1)
 *    - Invalid: Starts other (編號 2)
 * 
 * 2. Chars (字元組成):
 *    - Valid: 全部為 [A-Z0-9] (編號 3)
 *    - Invalid: 包含其他字元 (編號 4)
 * 
 * 3. Length (字串長度):
 *    - Valid: 1-8 chars (編號 5)
 *    - Invalid: 0 chars (編號 6) 或 > 8 chars (編號 7)
 * 
 * 混合測試 (最佳化)：需要 3 個案例
 * 獨立測試 (單一變因)：需要 5 個案例 - 本測試採用
 */
public class StringSpecificationTest {

    private StringSpecification analyzer;

    @BeforeEach
    void setUp() {
        analyzer = new StringSpecification();
    }

    /**
     * 測試案例資料提供者
     * 每個測試案例包含：
     * - 輸入值
     * - 預期結果
     * - 測試目標分析說明
     */
    static Stream<Arguments> stringDataProvider() {
        return Stream.of(
            // Test Case 1: Valid - Starts 1-9, Chars Valid, Length 1-8
            Arguments.of(
                "4144W013",
                Arrays.asList(1, 3, 5),
                "Starts 1-9 (1), Chars Valid (3), Length 1-8 (5)"
            ),
            
            // Test Case 2: Valid - Starts other, Chars Valid, Length 1-8
            Arguments.of(
                "W144W013",
                Arrays.asList(2, 3, 5),
                "Starts other (2), Chars Valid (3), Length 1-8 (5)"
            ),
            
            // Test Case 3: Invalid - Starts 1-9, Has others, Length 1-8
            Arguments.of(
                "4144#013",
                Arrays.asList(1, 4, 5),
                "Starts 1-9 (1), Has others (4), Length 1-8 (5)"
            ),
            
            // Test Case 4: Invalid - Empty string -> 0 chars
            Arguments.of(
                "",
                Arrays.asList(6),
                "Empty string -> 0 chars (6)"
            ),
            
            // Test Case 5: Invalid - Starts 1-9, Chars Valid, Length > 8
            Arguments.of(
                "4144W0134144W013",
                Arrays.asList(1, 3, 7),
                "Starts 1-9 (1), Chars Valid (3), Length > 8 (7)"
            )
        );
    }

    /**
     * 參數化測試 - 執行所有測試案例
     * 使用最少個測試案例達到測試目標涵蓋率 100%
     */
    @ParameterizedTest(name = "Test Case {index}: {2}")
    @MethodSource("stringDataProvider")
    @DisplayName("等價類別分割測試 - 混合測試（最少案例）")
    void testAnalyze_Parameterized(String input, List<Integer> expected, String criteriaDesc) {
        // 2-1) Input values (測試時候需要控制資料的值)
        String inputValueDisplay = input.isEmpty() ? "\"\" (空字串)" : input;
        
        // 執行程式
        List<Integer> actual = analyzer.analyze(input);
        
        // 為了報告顯示，將列表轉換為字串
        String expectedStr = "(" + String.join(",", expected.stream().map(String::valueOf).toArray(String[]::new)) + ")";
        String actualStr = "(" + String.join(",", actual.stream().map(String::valueOf).toArray(String[]::new)) + ")";
        String matchResult = expected.equals(actual) ? "符合" : "不符合";
        
        // 2) 輸出詳細測試案例報告
        System.out.println("\n－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－");
        System.out.println("【 Test Case Analysis 測試案例分析 】");
        System.out.println("　2-1) Input values (測試時候需要控制資料的值) : " + inputValueDisplay);
        System.out.println("　2-2) Expected result (正確的結果) : " + expectedStr);
        System.out.println("　2-3) Test program's result (程式執行後的結果) : " + actualStr);
        System.out.println("　2-4) Criteria analysis (測試目標的分析): " + matchResult + "，" + criteriaDesc);
        
        // 4-2) 使用測試工具的指令來比對
        assertThat(actual).as("Input: %s 失敗，未達預期結果.", inputValueDisplay)
                         .isEqualTo(expected);
    }
}

