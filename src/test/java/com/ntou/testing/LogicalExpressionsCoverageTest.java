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
    
    private Calculator calculator;
    private NumberProcessor processor;
    
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        processor = new NumberProcessor();
    }
    
    /**
     * 測試 complexLogic 方法的 Logical Expressions Coverage
     * 
     * 邏輯表達式：if (x && y || z)
     * 子條件：x, y, z
     * 
     * Predicate Coverage 目標：
     * - 整個條件為 true 的情況
     * - 整個條件為 false 的情況
     */
    @Test
    void testComplexLogic_PredicateCoverage() {
        // Test Case 1: 整個條件為 true
        // 1) Input values: x=true, y=true, z=false
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Predicate coverage - 整個條件 (x && y || z) 為 true
        assertThat(calculator.complexLogic(true, true, false)).isTrue();
        
        // Test Case 2: 整個條件為 false
        // 1) Input values: x=false, y=false, z=false
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Predicate coverage - 整個條件 (x && y || z) 為 false
        assertThat(calculator.complexLogic(false, false, false)).isFalse();
        
        // Predicate coverage: 100%
    }
    
    /**
     * 測試 complexLogic 方法的 Clause Coverage
     * 
     * Clause Coverage 目標：每個子條件 (x, y, z) 的 True False 都要測試過
     */
    @Test
    void testComplexLogic_ClauseCoverage() {
        // Test Case 1: x=true, y=true, z=true
        // 1) Input values: x=true, y=true, z=true
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Clause coverage - x=true, y=true, z=true
        assertThat(calculator.complexLogic(true, true, true)).isTrue();
        
        // Test Case 2: x=false, y=false, z=false
        // 1) Input values: x=false, y=false, z=false
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Clause coverage - x=false, y=false, z=false
        assertThat(calculator.complexLogic(false, false, false)).isFalse();
        
        // Test Case 3: x=true, y=false, z=true
        // 1) Input values: x=true, y=false, z=true
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Clause coverage - x=true, y=false, z=true
        assertThat(calculator.complexLogic(true, false, true)).isTrue();
        
        // Test Case 4: x=false, y=true, z=false
        // 1) Input values: x=false, y=true, z=false
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Clause coverage - x=false, y=true, z=false
        assertThat(calculator.complexLogic(false, true, false)).isFalse();
        
        // Clause coverage: 100%
        // x: true, false, true, false
        // y: true, false, false, true
        // z: true, false, true, false
    }
    
    /**
     * 測試 complexLogic 方法的 Combinatorial Coverage
     * 
     * Combinatorial Coverage 目標：每個子條件 True False 的全部排列組合都要測試過
     * 對於 3 個子條件，需要測試 2^3 = 8 種組合
     */
    @Test
    void testComplexLogic_CombinatorialCoverage() {
        // Test Case 1: TTT
        // 1) Input values: x=true, y=true, z=true
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Combinatorial coverage - TTT
        assertThat(calculator.complexLogic(true, true, true)).isTrue();
        
        // Test Case 2: TTF
        // 1) Input values: x=true, y=true, z=false
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Combinatorial coverage - TTF
        assertThat(calculator.complexLogic(true, true, false)).isTrue();
        
        // Test Case 3: TFT
        // 1) Input values: x=true, y=false, z=true
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Combinatorial coverage - TFT
        assertThat(calculator.complexLogic(true, false, true)).isTrue();
        
        // Test Case 4: TFF
        // 1) Input values: x=true, y=false, z=false
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Combinatorial coverage - TFF
        assertThat(calculator.complexLogic(true, false, false)).isFalse();
        
        // Test Case 5: FTT
        // 1) Input values: x=false, y=true, z=true
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Combinatorial coverage - FTT
        assertThat(calculator.complexLogic(false, true, true)).isTrue();
        
        // Test Case 6: FTF
        // 1) Input values: x=false, y=true, z=false
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Combinatorial coverage - FTF
        assertThat(calculator.complexLogic(false, true, false)).isFalse();
        
        // Test Case 7: FFT
        // 1) Input values: x=false, y=false, z=true
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Combinatorial coverage - FFT
        assertThat(calculator.complexLogic(false, false, true)).isFalse();
        
        // Test Case 8: FFF
        // 1) Input values: x=false, y=false, z=false
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Combinatorial coverage - FFF
        assertThat(calculator.complexLogic(false, false, false)).isFalse();
        
        // Combinatorial coverage: 100%
    }
    
    /**
     * 測試 complexBooleanLogic 方法的 Logical Expressions Coverage
     * 
     * 邏輯表達式：if ((a && b) || (c && d))
     * 子條件：a, b, c, d
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
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Clause coverage - a=true, b=false, c=true, d=false
        assertThat(processor.complexBooleanLogic(true, false, true, false)).isTrue();
        
        // Test Case 4: a=false, b=true, c=false, d=true
        // 1) Input values: a=false, b=true, c=false, d=true
        // 2) Expected result: false
        // 3) Test program's result: false
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
     * 對於 4 個子條件，需要測試 2^4 = 16 種組合
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
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Combinatorial coverage - TFTF
        assertThat(processor.complexBooleanLogic(true, false, true, false)).isTrue();
        
        // Test Case 7: TFFT
        // 1) Input values: a=true, b=false, c=false, d=true
        // 2) Expected result: false
        // 3) Test program's result: false
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
        // 2) Expected result: false
        // 3) Test program's result: false
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
    }
    
    /**
     * 測試 isValidPassword 方法的 Logical Expressions Coverage
     * 
     * 邏輯表達式：return hasDigit && hasLetter
     * 子條件：hasDigit, hasLetter
     */
    @Test
    void testIsValidPassword_LogicalExpressionsCoverage() {
        // Test Case 1: hasDigit=true, hasLetter=true (TT)
        // 1) Input values: password = "abc123"
        // 2) Expected result: true
        // 3) Test program's result: true
        // 4) Criteria analysis: Logical expressions coverage - hasDigit=true, hasLetter=true
        assertThat(processor.isValidPassword("abc123")).isTrue();
        
        // Test Case 2: hasDigit=true, hasLetter=false (TF)
        // 1) Input values: password = "123456"
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Logical expressions coverage - hasDigit=true, hasLetter=false
        assertThat(processor.isValidPassword("123456")).isFalse();
        
        // Test Case 3: hasDigit=false, hasLetter=true (FT)
        // 1) Input values: password = "abcdef"
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Logical expressions coverage - hasDigit=false, hasLetter=true
        assertThat(processor.isValidPassword("abcdef")).isFalse();
        
        // Test Case 4: hasDigit=false, hasLetter=false (FF)
        // 1) Input values: password = "!@#$%^"
        // 2) Expected result: false
        // 3) Test program's result: false
        // 4) Criteria analysis: Logical expressions coverage - hasDigit=false, hasLetter=false
        assertThat(processor.isValidPassword("!@#$%^")).isFalse();
        
        // Combinatorial coverage: 100%
        // Predicate coverage: 100% (hasDigit && hasLetter 為 true 和 false 都有測試)
        // Clause coverage: 100% (hasDigit 和 hasLetter 的 true/false 都有測試)
    }
}
