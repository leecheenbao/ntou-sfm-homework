package com.ntou.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

/**
 * Graph Coverage 測試
 * 包含 Edge Coverage、Edge-Pair Coverage、Path Coverage
 * 目標：使用最少的測試案例達到 100% Graph Coverage
 */
public class GraphCoverageTest {
    
    private NumberProcessor processor;
    
    @BeforeEach
    void setUp() {
        processor = new NumberProcessor();
    }
    
    /**
     * 測試 classifyNumber 方法的 Edge Coverage
     * 
     * 控制流圖分析：
     * 節點：1(開始) -> 2(if < 0) -> 3(return NEGATIVE) / 4(else if == 0) -> 5(return ZERO) / 6(else if <= 10) -> 7(return SMALL) / 8(else if <= 100) -> 9(return MEDIUM) / 10(else) -> 11(return LARGE) -> 12(結束)
     * 邊：12, 23, 24, 35, 46, 67, 68, 79, 710, 811, 1011, 1112
     * 
     * Edge Coverage 目標：覆蓋所有邊
     */
    @Test
    void testClassifyNumber_EdgeCoverage() {
        // Test Case 1: 負數路徑 (12 -> 23 -> 35)
        // 1) Input values: number = -5
        // 2) Expected result: "NEGATIVE"
        // 3) Test program's result: "NEGATIVE"
        // 4) Criteria analysis: Edge coverage - 覆蓋邊 12, 23, 35
        assertThat(processor.classifyNumber(-5)).isEqualTo("NEGATIVE");
        
        // Test Case 2: 零路徑 (12 -> 24 -> 46 -> 67)
        // 1) Input values: number = 0
        // 2) Expected result: "ZERO"
        // 3) Test program's result: "ZERO"
        // 4) Criteria analysis: Edge coverage - 覆蓋邊 12, 24, 46, 67
        assertThat(processor.classifyNumber(0)).isEqualTo("ZERO");
        
        // Test Case 3: 小正數路徑 (12 -> 24 -> 46 -> 68 -> 79)
        // 1) Input values: number = 5
        // 2) Expected result: "SMALL"
        // 3) Test program's result: "SMALL"
        // 4) Criteria analysis: Edge coverage - 覆蓋邊 12, 24, 46, 68, 79
        assertThat(processor.classifyNumber(5)).isEqualTo("SMALL");
        
        // Test Case 4: 中等正數路徑 (12 -> 24 -> 46 -> 68 -> 710 -> 811)
        // 1) Input values: number = 50
        // 2) Expected result: "MEDIUM"
        // 3) Test program's result: "MEDIUM"
        // 4) Criteria analysis: Edge coverage - 覆蓋邊 12, 24, 46, 68, 710, 811
        assertThat(processor.classifyNumber(50)).isEqualTo("MEDIUM");
        
        // Test Case 5: 大正數路徑 (12 -> 24 -> 46 -> 68 -> 710 -> 1011 -> 1112)
        // 1) Input values: number = 150
        // 2) Expected result: "LARGE"
        // 3) Test program's result: "LARGE"
        // 4) Criteria analysis: Edge coverage - 覆蓋邊 12, 24, 46, 68, 710, 1011, 1112
        assertThat(processor.classifyNumber(150)).isEqualTo("LARGE");
        
        // Edge coverage: 100%
        // 所有邊都已覆蓋
    }
    
    /**
     * 測試 classifyNumber 方法的 Edge-Pair Coverage
     * 
     * Edge-Pair Coverage 目標：覆蓋所有相鄰的邊對
     * 邊對：(12,23), (12,24), (23,35), (24,46), (46,67), (46,68), (67,79), (68,79), (68,710), (79,811), (710,811), (710,1011), (811,1112), (1011,1112)
     */
    @Test
    void testClassifyNumber_EdgePairCoverage() {
        // Test Case 1: 負數路徑 (12,23) -> (23,35)
        // 1) Input values: number = -5
        // 2) Expected result: "NEGATIVE"
        // 3) Test program's result: "NEGATIVE"
        // 4) Criteria analysis: Edge-pair coverage - 覆蓋邊對 (12,23), (23,35)
        assertThat(processor.classifyNumber(-5)).isEqualTo("NEGATIVE");
        
        // Test Case 2: 零路徑 (12,24) -> (24,46) -> (46,67)
        // 1) Input values: number = 0
        // 2) Expected result: "ZERO"
        // 3) Test program's result: "ZERO"
        // 4) Criteria analysis: Edge-pair coverage - 覆蓋邊對 (12,24), (24,46), (46,67)
        assertThat(processor.classifyNumber(0)).isEqualTo("ZERO");
        
        // Test Case 3: 小正數路徑 (12,24) -> (24,46) -> (46,68) -> (68,79)
        // 1) Input values: number = 5
        // 2) Expected result: "SMALL"
        // 3) Test program's result: "SMALL"
        // 4) Criteria analysis: Edge-pair coverage - 覆蓋邊對 (12,24), (24,46), (46,68), (68,79)
        assertThat(processor.classifyNumber(5)).isEqualTo("SMALL");
        
        // Test Case 4: 中等正數路徑 (12,24) -> (24,46) -> (46,68) -> (68,710) -> (710,811)
        // 1) Input values: number = 50
        // 2) Expected result: "MEDIUM"
        // 3) Test program's result: "MEDIUM"
        // 4) Criteria analysis: Edge-pair coverage - 覆蓋邊對 (12,24), (24,46), (46,68), (68,710), (710,811)
        assertThat(processor.classifyNumber(50)).isEqualTo("MEDIUM");
        
        // Test Case 5: 大正數路徑 (12,24) -> (24,46) -> (46,68) -> (68,710) -> (710,1011) -> (1011,1112)
        // 1) Input values: number = 150
        // 2) Expected result: "LARGE"
        // 3) Test program's result: "LARGE"
        // 4) Criteria analysis: Edge-pair coverage - 覆蓋邊對 (12,24), (24,46), (46,68), (68,710), (710,1011), (1011,1112)
        assertThat(processor.classifyNumber(150)).isEqualTo("LARGE");
        
        // Edge-pair coverage: 100%
        // 所有邊對都已覆蓋
    }
    
    /**
     * 測試 classifyNumber 方法的 Path Coverage
     * 
     * Path Coverage 目標：覆蓋所有從開始到結束的路徑
     * 路徑：
     * 1. (1,2,3,5) - 負數路徑
     * 2. (1,2,4,6,7,9) - 零路徑
     * 3. (1,2,4,6,8,7,9) - 小正數路徑
     * 4. (1,2,4,6,8,10,8,11) - 中等正數路徑
     * 5. (1,2,4,6,8,10,11,12) - 大正數路徑
     */
    @Test
    void testClassifyNumber_PathCoverage() {
        // Path 1: 負數路徑 (1,2,3,5)
        // 1) Input values: number = -5
        // 2) Expected result: "NEGATIVE"
        // 3) Test program's result: "NEGATIVE"
        // 4) Criteria analysis: Path coverage - 覆蓋路徑 (1,2,3,5)
        assertThat(processor.classifyNumber(-5)).isEqualTo("NEGATIVE");
        
        // Path 2: 零路徑 (1,2,4,6,7,9)
        // 1) Input values: number = 0
        // 2) Expected result: "ZERO"
        // 3) Test program's result: "ZERO"
        // 4) Criteria analysis: Path coverage - 覆蓋路徑 (1,2,4,6,7,9)
        assertThat(processor.classifyNumber(0)).isEqualTo("ZERO");
        
        // Path 3: 小正數路徑 (1,2,4,6,8,7,9)
        // 1) Input values: number = 5
        // 2) Expected result: "SMALL"
        // 3) Test program's result: "SMALL"
        // 4) Criteria analysis: Path coverage - 覆蓋路徑 (1,2,4,6,8,7,9)
        assertThat(processor.classifyNumber(5)).isEqualTo("SMALL");
        
        // Path 4: 中等正數路徑 (1,2,4,6,8,10,8,11)
        // 1) Input values: number = 50
        // 2) Expected result: "MEDIUM"
        // 3) Test program's result: "MEDIUM"
        // 4) Criteria analysis: Path coverage - 覆蓋路徑 (1,2,4,6,8,10,8,11)
        assertThat(processor.classifyNumber(50)).isEqualTo("MEDIUM");
        
        // Path 5: 大正數路徑 (1,2,4,6,8,10,11,12)
        // 1) Input values: number = 150
        // 2) Expected result: "LARGE"
        // 3) Test program's result: "LARGE"
        // 4) Criteria analysis: Path coverage - 覆蓋路徑 (1,2,4,6,8,10,11,12)
        assertThat(processor.classifyNumber(150)).isEqualTo("LARGE");
        
        // Path coverage: 100%
        // 所有路徑都已覆蓋
    }
}