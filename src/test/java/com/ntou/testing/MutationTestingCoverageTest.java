package com.ntou.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Mutation Testing Coverage 測試類別
 * 變異測試 - 評估測試案例的品質
 * 
 * 測試目標：
 * 使用最少個測試案例達到測試目標涵蓋率 100%
 * 最少三個測試案例即可覆蓋所有控制流程：
 * 1. Null
 * 2. [3, 9, 4]
 * 3. [3]
 */
public class MutationTestingCoverageTest {

    private final NumberProcessor processor = new NumberProcessor();

    // ==================== 基本測試案例（覆蓋率測試） ====================

    @Test
    @DisplayName("測試案例 1: 基本測試 - [3, 9, 4]")
    void testFindMax_Basic() {
        // 2-1) Input values (測試時候需要控制資料的值)
        int[] list = new int[]{3, 9, 4};
        
        // 執行程式
        int result = processor.findMax(list);
        
        // 2-2) Expected result (正確的結果)
        int expected = 9;
        
        // 2-3) Test program's result (程式執行後的結果)
        // result = 9
        
        // 2-4) Criteria analysis (測試目標的分析)
        // 覆蓋 if (numbers == null || numbers.length == 0) 的 false 分支，因為輸入為非空陣列。
        // 覆蓋迴圈完整執行（i = 1、i = 2），確保迴圈至少跑一次以上。
        // 覆蓋比較條件 if (numbers[i] > max) 的 true 與 false 兩種結果：
        //   9 > 3 為 true → 更新 max
        //   4 > 9 為 false → 不更新
        // 覆蓋正常回傳路徑，驗證最大值正確計算為 9
        
        System.out.println("\n－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－");
        System.out.println("【 Test Case 1: 基本測試 】");
        System.out.println("　2-1) Input values (測試時候需要控制資料的值) : [3, 9, 4]");
        System.out.println("　2-2) Expected result (正確的結果) : 9");
        System.out.println("　2-3) Test program's result (程式執行後的結果) : " + result);
        System.out.println("　2-4) Criteria analysis (測試目標的分析):");
        System.out.println("   覆蓋 if (numbers == null || numbers.length == 0) 的 false 分支");
        System.out.println("   覆蓋迴圈完整執行（i = 1、i = 2）");
        System.out.println("   覆蓋比較條件 if (numbers[i] > max) 的 true 與 false 兩種結果");
        System.out.println("   覆蓋正常回傳路徑，驗證最大值正確計算為 9");
        
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("測試案例 2: Null 測試")
    void testFindMax_Null() {
        // 2-1) Input values
        int[] list = null;
        
        // 執行程式
        int result = processor.findMax(list);
        
        // 2-2) Expected result
        int expected = Integer.MIN_VALUE;
        
        // 2-3) Test program's result
        // result = Integer.MIN_VALUE
        
        // 2-4) Criteria analysis
        // 覆蓋 if (numbers == null || numbers.length == 0) 的 true 分支（null 情況）
        
        System.out.println("\n－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－");
        System.out.println("【 Test Case 2: Null 測試 】");
        System.out.println("　2-1) Input values (測試時候需要控制資料的值) : null");
        System.out.println("　2-2) Expected result (正確的結果) : " + expected);
        System.out.println("　2-3) Test program's result (程式執行後的結果) : " + result);
        System.out.println("　2-4) Criteria analysis (測試目標的分析):");
        System.out.println("   覆蓋 if (numbers == null || numbers.length == 0) 的 true 分支（null 情況）");
        
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("測試案例 3: 單元素陣列測試 - [3]")
    void testFindMax_SingleElement() {
        // 2-1) Input values
        int[] list = new int[]{3};
        
        // 執行程式
        int result = processor.findMax(list);
        
        // 2-2) Expected result
        int expected = 3;
        
        // 2-3) Test program's result
        // result = 3
        
        // 2-4) Criteria analysis
        // 覆蓋 if (numbers == null || numbers.length == 0) 的 false 分支
        // 覆蓋迴圈不執行的情況（i = 1, 但 numbers.length = 1，所以 i < numbers.length 為 false）
        
        System.out.println("\n－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－");
        System.out.println("【 Test Case 3: 單元素陣列測試 】");
        System.out.println("　2-1) Input values (測試時候需要控制資料的值) : [3]");
        System.out.println("　2-2) Expected result (正確的結果) : " + expected);
        System.out.println("　2-3) Test program's result (程式執行後的結果) : " + result);
        System.out.println("　2-4) Criteria analysis (測試目標的分析):");
        System.out.println("   覆蓋 if (numbers == null || numbers.length == 0) 的 false 分支");
        System.out.println("   覆蓋迴圈不執行的情況（單元素陣列）");
        
        assertThat(result).isEqualTo(expected);
    }

    // ==================== 變異測試案例 ====================

    @Test
    @DisplayName("變異測試案例 1: line7 將 > 改為 <")
    void testMutationTestingCoverage1() {
        // 1) Input values (測試時候需要控制資料的值)
        int[] list = new int[]{3, 9, 4};
        
        // 2) Expected result (正確的結果)
        int expected = 9;
        
        // 3) Test program's result (原本程式執行後的結果)
        int originalResult = processor.findMax(list);
        
        // *4) Criteria analysis (測試目標的分析)
        // *a) 突變的程式(修改的敘述): line7 將 > 改為 <
        // *b) 突變的程式執行後的結果(跟原本程式結果不一樣): 3
        
        int mutationResult = processor.findMaxMutations1(list);
        
        System.out.println("\n－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－");
        System.out.println("【 Mutation Test Case 1 】");
        System.out.println("　1) Input values (測試時候需要控制資料的值) : [3, 9, 4]");
        System.out.println("　2) Expected result (正確的結果) : " + expected);
        System.out.println("　3) Test program's result (原本程式執行後的結果) : " + originalResult);
        System.out.println("　*4) Criteria analysis (測試目標的分析)");
        System.out.println("   *a) 突變的程式(修改的敘述): line7 將 > 改為 <");
        System.out.println("   *b) 突變的程式執行後的結果(跟原本程式結果不一樣): " + mutationResult);
        
        // 驗證原始程式結果正確
        assertThat(originalResult).isEqualTo(expected);
        // 驗證變異程式結果不同（變異被殺死）
        assertThat(mutationResult).isNotEqualTo(expected);
        assertThat(mutationResult).isEqualTo(3);
    }

    @Test
    @DisplayName("變異測試案例 2: line2 將 == 改為 !=")
    void testMutationTestingCoverage2() {
        int[] list = new int[]{3, 9, 4};
        int expected = 9;
        int originalResult = processor.findMax(list);
        
        // *a) 突變的程式(修改的敘述): line2 將 == 改為 !=
        // *b) 突變的程式執行後的結果(跟原本程式結果不一樣): -2147483648
        
        int mutationResult = processor.findMaxMutations2(list);
        
        System.out.println("\n－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－");
        System.out.println("【 Mutation Test Case 2 】");
        System.out.println("　1) Input values (測試時候需要控制資料的值) : [3, 9, 4]");
        System.out.println("　2) Expected result (正確的結果) : " + expected);
        System.out.println("　3) Test program's result (原本程式執行後的結果) : " + originalResult);
        System.out.println("　*4) Criteria analysis (測試目標的分析)");
        System.out.println("   *a) 突變的程式(修改的敘述): line2 將 == 改為 !=");
        System.out.println("   *b) 突變的程式執行後的結果(跟原本程式結果不一樣): " + mutationResult);
        
        assertThat(originalResult).isEqualTo(expected);
        assertThat(mutationResult).isNotEqualTo(expected);
        assertThat(mutationResult).isEqualTo(Integer.MIN_VALUE);
    }

    @Test
    @DisplayName("變異測試案例 3: line6 將 1 改為 4")
    void testMutationTestingCoverage3() {
        int[] list = new int[]{3, 9, 4};
        int expected = 9;
        int originalResult = processor.findMax(list);
        
        // *a) 突變的程式(修改的敘述): line6 將 1 改為 4
        // *b) 突變的程式執行後的結果(跟原本程式結果不一樣): 3
        
        int mutationResult = processor.findMaxMutations3(list);
        
        System.out.println("\n－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－");
        System.out.println("【 Mutation Test Case 3 】");
        System.out.println("　1) Input values (測試時候需要控制資料的值) : [3, 9, 4]");
        System.out.println("　2) Expected result (正確的結果) : " + expected);
        System.out.println("　3) Test program's result (原本程式執行後的結果) : " + originalResult);
        System.out.println("　*4) Criteria analysis (測試目標的分析)");
        System.out.println("   *a) 突變的程式(修改的敘述): line6 將 1 改為 4");
        System.out.println("   *b) 突變的程式執行後的結果(跟原本程式結果不一樣): " + mutationResult);
        
        assertThat(originalResult).isEqualTo(expected);
        assertThat(mutationResult).isNotEqualTo(expected);
        assertThat(mutationResult).isEqualTo(3);
    }

    @Test
    @DisplayName("變異測試案例 4: line8 將 i 改為 0")
    void testMutationTestingCoverage4() {
        int[] list = new int[]{3, 9, 4};
        int expected = 9;
        int originalResult = processor.findMax(list);
        
        // *a) 突變的程式(修改的敘述): line8 將 i 改為 0
        // *b) 突變的程式執行後的結果(跟原本程式結果不一樣): 3
        
        int mutationResult = processor.findMaxMutations4(list);
        
        System.out.println("\n－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－");
        System.out.println("【 Mutation Test Case 4 】");
        System.out.println("　1) Input values (測試時候需要控制資料的值) : [3, 9, 4]");
        System.out.println("　2) Expected result (正確的結果) : " + expected);
        System.out.println("　3) Test program's result (原本程式執行後的結果) : " + originalResult);
        System.out.println("　*4) Criteria analysis (測試目標的分析)");
        System.out.println("   *a) 突變的程式(修改的敘述): line8 將 i 改為 0");
        System.out.println("   *b) 突變的程式執行後的結果(跟原本程式結果不一樣): " + mutationResult);
        
        assertThat(originalResult).isEqualTo(expected);
        assertThat(mutationResult).isNotEqualTo(expected);
        assertThat(mutationResult).isEqualTo(3);
    }

    @Test
    @DisplayName("變異測試案例 5: line11 將 max 改為 1")
    void testMutationTestingCoverage5() {
        int[] list = new int[]{3, 9, 4};
        int expected = 9;
        int originalResult = processor.findMax(list);
        
        // *a) 突變的程式(修改的敘述): line11 將 max 改為 1
        // *b) 突變的程式執行後的結果(跟原本程式結果不一樣): 1
        
        int mutationResult = processor.findMaxMutations5(list);
        
        System.out.println("\n－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－");
        System.out.println("【 Mutation Test Case 5 】");
        System.out.println("　1) Input values (測試時候需要控制資料的值) : [3, 9, 4]");
        System.out.println("　2) Expected result (正確的結果) : " + expected);
        System.out.println("　3) Test program's result (原本程式執行後的結果) : " + originalResult);
        System.out.println("　*4) Criteria analysis (測試目標的分析)");
        System.out.println("   *a) 突變的程式(修改的敘述): line11 將 max 改為 1");
        System.out.println("   *b) 突變的程式執行後的結果(跟原本程式結果不一樣): " + mutationResult);
        
        assertThat(originalResult).isEqualTo(expected);
        assertThat(mutationResult).isNotEqualTo(expected);
        assertThat(mutationResult).isEqualTo(1);
    }
}

