package com.ntou.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

/**
 * Logical Expressions Coverage 測試
 * 目標：測試邏輯表達式的各種覆蓋率
 * 
 * 測試策略：
 * 1) Predicate Coverage - 整個條件判斷式的 True False 都要測試過
 * 2) Clause Coverage - 每個子條件的 True False 都要測試過
 * 3) Combinatorial Coverage - 每個子條件 True False 的全部排列組合都要測試過
 */
public class LogicalExpressionsCoverageTest {
    
    private NumberProcessor processor;
    
    @BeforeEach
    void setUp() {
        processor = new NumberProcessor();
    }
    
    /**
     * 測試 complexBooleanLogic 方法的 Logical Expressions Coverage
     * 
     * 邏輯表達式：if ((a && b) || (c && d))
     * 子條件：a, b, c, d
     * 
     * Predicate Coverage 目標：
     * - 整個條件為 true 的情況
     * - 整個條件為 false 的情況
     */
    @Test
    void testComplexBooleanLogic_PredicateCoverage() {
        // Test Case 1: 整個條件為 true
        // 1) Input values: a=true, b=true, c=false, d=false
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Predicate coverage - 整個條件 ((a && b) || (c && d)) 為 true
        assertThat(processor.complexBooleanLogic(true, true, false, false)).isTrue();
        
        // Test Case 2: 整個條件為 false
        // 1) Input values: a=false, b=false, c=false, d=false
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Predicate coverage - 整個條件 ((a && b) || (c && d)) 為 false
        assertThat(processor.complexBooleanLogic(false, false, false, false)).isFalse();
        
        // Predicate coverage: 100%
    }
    
    /**
     * 測試 complexBooleanLogic 方法的 Clause Coverage
     * 
     * Clause Coverage 目標：每個子條件 (a, b, c, d) 的 True False 都要測試過
     */
    @Test
    void testComplexBooleanLogic_ClauseCoverage() {
        // Test Case 1: a=true, b=true, c=true, d=true
        // 1) Input values: a=true, b=true, c=true, d=true
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Clause coverage - a=true, b=true, c=true, d=true
        assertThat(processor.complexBooleanLogic(true, true, true, true)).isTrue();
        
        // Test Case 2: a=false, b=false, c=false, d=false
        // 1) Input values: a=false, b=false, c=false, d=false
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Clause coverage - a=false, b=false, c=false, d=false
        assertThat(processor.complexBooleanLogic(false, false, false, false)).isFalse();
        
        // Test Case 3: a=true, b=false, c=true, d=false
        // 1) Input values: a=true, b=false, c=true, d=false
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Clause coverage - a=true, b=false, c=true, d=false
        assertThat(processor.complexBooleanLogic(true, false, true, false)).isTrue();
        
        // Test Case 4: a=false, b=true, c=false, d=true
        // 1) Input values: a=false, b=true, c=false, d=true
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Clause coverage - a=false, b=true, c=false, d=true
        assertThat(processor.complexBooleanLogic(false, true, false, true)).isTrue();
        
        // Clause coverage: 100%
        // a: true, false, true, false
        // b: true, false, false, true
        // c: true, false, true, false
        // d: true, false, false, true
    }
    
    /**
     * 測試 complexBooleanLogic 方法的 Combinatorial Coverage
     * 
     * Combinatorial Coverage 目標：每個子條件 True False 的全部排列組合都要測試過
     * 對於 4 個布林變數，總共有 2^4 = 16 種組合
     */
    @Test
    void testComplexBooleanLogic_CombinatorialCoverage() {
        // Test Case 1: TTTT
        // 1) Input values: a=true, b=true, c=true, d=true
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Combinatorial coverage - TTTT
        assertThat(processor.complexBooleanLogic(true, true, true, true)).isTrue();
        
        // Test Case 2: TTTF
        // 1) Input values: a=true, b=true, c=true, d=false
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Combinatorial coverage - TTTF
        assertThat(processor.complexBooleanLogic(true, true, true, false)).isTrue();
        
        // Test Case 3: TTFT
        // 1) Input values: a=true, b=true, c=false, d=true
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Combinatorial coverage - TTFT
        assertThat(processor.complexBooleanLogic(true, true, false, true)).isTrue();
        
        // Test Case 4: TTFF
        // 1) Input values: a=true, b=true, c=false, d=false
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Combinatorial coverage - TTFF
        assertThat(processor.complexBooleanLogic(true, true, false, false)).isTrue();
        
        // Test Case 5: TFTT
        // 1) Input values: a=true, b=false, c=true, d=true
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Combinatorial coverage - TFTT
        assertThat(processor.complexBooleanLogic(true, false, true, true)).isTrue();
        
        // Test Case 6: TFTF
        // 1) Input values: a=true, b=false, c=true, d=false
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Combinatorial coverage - TFTF
        assertThat(processor.complexBooleanLogic(true, false, true, false)).isTrue();
        
        // Test Case 7: TFFT
        // 1) Input values: a=true, b=false, c=false, d=true
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Combinatorial coverage - TFFT
        assertThat(processor.complexBooleanLogic(true, false, false, true)).isTrue();
        
        // Test Case 8: TFFF
        // 1) Input values: a=true, b=false, c=false, d=false
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Combinatorial coverage - TFFF
        assertThat(processor.complexBooleanLogic(true, false, false, false)).isFalse();
        
        // Test Case 9: FTTT
        // 1) Input values: a=false, b=true, c=true, d=true
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Combinatorial coverage - FTTT
        assertThat(processor.complexBooleanLogic(false, true, true, true)).isTrue();
        
        // Test Case 10: FTTF
        // 1) Input values: a=false, b=true, c=true, d=false
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Combinatorial coverage - FTTF
        assertThat(processor.complexBooleanLogic(false, true, true, false)).isTrue();
        
        // Test Case 11: FTFT
        // 1) Input values: a=false, b=true, c=false, d=true
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Combinatorial coverage - FTFT
        assertThat(processor.complexBooleanLogic(false, true, false, true)).isTrue();
        
        // Test Case 12: FTFF
        // 1) Input values: a=false, b=true, c=false, d=false
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Combinatorial coverage - FTFF
        assertThat(processor.complexBooleanLogic(false, true, false, false)).isFalse();
        
        // Test Case 13: FFTT
        // 1) Input values: a=false, b=false, c=true, d=true
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Combinatorial coverage - FFTT
        assertThat(processor.complexBooleanLogic(false, false, true, true)).isTrue();
        
        // Test Case 14: FFTF
        // 1) Input values: a=false, b=false, c=true, d=false
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Combinatorial coverage - FFTF
        assertThat(processor.complexBooleanLogic(false, false, true, false)).isFalse();
        
        // Test Case 15: FFFT
        // 1) Input values: a=false, b=false, c=false, d=true
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Combinatorial coverage - FFFT
        assertThat(processor.complexBooleanLogic(false, false, false, true)).isFalse();
        
        // Test Case 16: FFFF
        // 1) Input values: a=false, b=false, c=false, d=false
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Combinatorial coverage - FFFF
        assertThat(processor.complexBooleanLogic(false, false, false, false)).isFalse();
        
        // Combinatorial coverage: 100%
        // 所有 16 種 True False 組合都已測試過
    }
}