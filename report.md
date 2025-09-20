# 測試工具期末報告

## 目錄
1. [測試工具的介紹](#1-測試工具的介紹)
2. [測試工具功能的說明](#2-測試工具功能的說明)
3. [測試工具功能的示範](#3-測試工具功能的示範-demo)
4. [測試工具的使用心得](#4-測試工具的使用心得)
5. [使用測試工具在每個作業的展示](#5-使用測試工具在每個作業的展示)

---

## 1. 測試工具的介紹

### 1.1 專案概述
本專案是一個完整的 Java 測試框架實作，使用現代化的測試工具和技術，涵蓋了軟體測試的各種重要概念和方法。專案採用 Maven 作為建置工具，整合了多種測試工具以提供全面的測試覆蓋。

### 1.2 主要測試工具
- **JUnit 5**: 現代化的單元測試框架
- **AssertJ**: 流暢的斷言庫，提供更直觀的測試語法
- **JaCoCo**: 程式碼覆蓋率分析工具
- **PIT Mutation Testing**: 變異測試工具，評估測試套件品質
- **Maven**: 專案建置和依賴管理工具

### 1.3 專案結構
```
src/
├── main/java/com/ntou/testing/
│   ├── Calculator.java          # 計算機類別
│   └── NumberProcessor.java     # 數字處理器類別
└── test/java/com/ntou/testing/
    ├── CalculatorLineCoverageTest.java
    ├── NumberProcessorLineCoverageTest.java
    ├── GraphCoverageTest.java
    ├── StressTestingCoverageTest.java
    ├── LogicalExpressionsCoverageTest.java
    ├── InputDomainCharacterizationTest.java
    ├── MutationTestingCoverageTest.java
    ├── EquivalencePartitionTestingTest.java
    └── BoundaryValueTestingTest.java
```

---

## 2. 測試工具功能的說明

### 2.1 JUnit 5
**功能描述**: 現代化的 Java 單元測試框架

**主要特性**:
- 支援 Java 8+ 的新特性
- 更靈活的測試生命週期管理
- 內建參數化測試支援
- 改進的異常測試支援

**使用範例**:
```java
@Test
@DisplayName("測試 add 方法的 Line Coverage 100%")
void testAdd_LineCoverage100() {
    // 測試邏輯
    assertThat(calculator.add(5, 3)).isEqualTo(8);
}
```

### 2.2 AssertJ
**功能描述**: 流暢的斷言庫，提供更直觀的測試語法

**主要特性**:
- 流暢的 API 設計
- 豐富的斷言方法
- 清晰的錯誤訊息
- 支援鏈式調用

**使用範例**:
```java
assertThat(calculator.isPositive(5)).isTrue();
assertThat(processor.classifyNumber(-5)).isEqualTo("NEGATIVE");
assertThatThrownBy(() -> calculator.factorial(-1))
    .isInstanceOf(IllegalArgumentException.class);
```

### 2.3 JaCoCo
**功能描述**: Java 程式碼覆蓋率分析工具

**主要特性**:
- 行覆蓋率分析
- 分支覆蓋率分析
- 方法覆蓋率分析
- 類別覆蓋率分析
- HTML 報告生成

**配置範例**:
```xml
<plugin>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>${jacoco.version}</version>
    <executions>
        <execution>
            <goals>
                <goal>prepare-agent</goal>
            </goals>
        </execution>
        <execution>
            <id>report</id>
            <phase>test</phase>
            <goals>
                <goal>report</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

### 2.4 PIT Mutation Testing
**功能描述**: 變異測試工具，通過在原始程式碼中引入變化來評估測試套件品質

**主要特性**:
- 自動生成變異體
- 測試套件品質評估
- 多種變異運算子
- HTML 報告生成

**配置範例**:
```xml
<plugin>
    <groupId>org.pitest</groupId>
    <artifactId>pitest-maven</artifactId>
    <version>${pitest.version}</version>
    <dependencies>
        <dependency>
            <groupId>org.pitest</groupId>
            <artifactId>pitest-junit5-plugin</artifactId>
            <version>1.2.1</version>
        </dependency>
    </dependencies>
</plugin>
```

---

## 3. 測試工具功能的示範 (Demo)

### 3.1 執行測試
```bash
# 執行所有測試
mvn test

# 執行特定測試類別
mvn test -Dtest=CalculatorLineCoverageTest

# 執行測試並生成覆蓋率報告
mvn test jacoco:report
```

### 3.2 測試覆蓋率報告
執行測試後，JaCoCo 會生成詳細的覆蓋率報告：
- 位置: `target/site/jacoco/index.html`
- 內容: 行覆蓋率、分支覆蓋率、方法覆蓋率等詳細資訊

### 3.3 變異測試報告
執行變異測試：
```bash
mvn test-compile org.pitest:pitest-maven:mutationCoverage
```

### 3.4 測試結果範例
```
[INFO] Tests run: 59, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

### 3.5 覆蓋率報告範例
```
總覆蓋率: 100%
行覆蓋率: 100%
分支覆蓋率: 100%
方法覆蓋率: 100%
類別覆蓋率: 100%
```

---

## 4. 測試工具的使用心得

### 4.1 JUnit 5 使用心得
**優點**:
- 語法簡潔直觀，學習曲線平緩
- `@DisplayName` 註解讓測試案例更具可讀性
- 參數化測試功能強大，減少重複程式碼
- 與現代 IDE 整合良好

**挑戰**:
- 從 JUnit 4 遷移需要調整一些語法
- 某些進階功能需要額外學習

**建議**:
- 善用 `@DisplayName` 讓測試案例名稱更具描述性
- 使用參數化測試來處理大量相似測試案例

### 4.2 AssertJ 使用心得
**優點**:
- 流暢的 API 設計讓測試程式碼更易讀
- 豐富的斷言方法涵蓋各種測試場景
- 錯誤訊息清晰，便於除錯
- 支援鏈式調用，程式碼更簡潔

**挑戰**:
- 初期需要熟悉各種斷言方法
- 某些複雜斷言可能需要組合多個方法

**建議**:
- 優先使用 AssertJ 而非 JUnit 的斷言方法
- 善用 IDE 的自動完成功能探索可用方法

### 4.3 JaCoCo 使用心得
**優點**:
- 配置簡單，與 Maven 整合良好
- 報告詳細且視覺化
- 支援多種覆蓋率指標
- 可以設定覆蓋率門檻

**挑戰**:
- 需要理解各種覆蓋率指標的意義
- 某些情況下可能需要排除特定程式碼

**建議**:
- 定期檢查覆蓋率報告，確保測試品質
- 設定合理的覆蓋率門檻，避免過度追求數字

### 4.4 PIT Mutation Testing 使用心得
**優點**:
- 能夠發現測試套件的盲點
- 提供測試品質的客觀評估
- 支援多種變異運算子
- 報告詳細，便於分析

**挑戰**:
- 執行時間較長
- 某些變異體可能產生等效程式碼
- 需要理解變異測試的概念

**建議**:
- 在重要模組上使用變異測試
- 關注殺死率而非絕對數字
- 定期執行以維持測試品質

---

## 5. 使用測試工具在每個作業的展示

### 5.1 Line Coverage (行覆蓋測試)

**測試工具**: JUnit 5 + AssertJ + JaCoCo

**展示內容**:
- 測試檔案: `CalculatorLineCoverageTest.java`, `NumberProcessorLineCoverageTest.java`
- 測試案例數: 12 個
- 覆蓋率: 100%

**關鍵程式碼**:
```java
@Test
@DisplayName("測試 add 方法的 Line Coverage 100%")
void testAdd_LineCoverage100() {
    // 1) Input values: a=5, b=3
    // 2) Expected result: 8
    // 3) Test program's result: 8
    // 4) Criteria analysis: Line coverage - 測試案例涵蓋的lines: 1, 2
    assertThat(calculator.add(5, 3)).isEqualTo(8);
}
```

**工具使用示範**:
```bash
mvn test -Dtest=CalculatorLineCoverageTest jacoco:report
```

### 5.2 Graph Coverage (圖覆蓋測試)

**測試工具**: JUnit 5 + AssertJ

**展示內容**:
- 測試檔案: `GraphCoverageTest.java`
- 涵蓋類型: Edge Coverage, Edge-Pair Coverage, Path Coverage
- 測試案例數: 9 個

**關鍵程式碼**:
```java
@Test
@DisplayName("測試 processNumber 方法的 Edge Coverage 100%")
void testProcessNumber_EdgeCoverage100() {
    // Test Case 1: number > 100 (Edge 1->2)
    assertThat(processor.processNumber(101)).isEqualTo("Large");
    
    // Test Case 2: 50 < number <= 100 (Edge 1->3, 3->4)
    assertThat(processor.processNumber(75)).isEqualTo("Medium");
}
```

### 5.3 Stress Testing Coverage (壓力測試覆蓋)

**測試工具**: JUnit 5 + AssertJ

**展示內容**:
- 測試檔案: `StressTestingCoverageTest.java`
- 測試案例數: 7 個
- 涵蓋極值情況和邊界條件

**關鍵程式碼**:
```java
@Test
@DisplayName("測試 gcd 方法的 Stress Testing")
void testGcd_StressTesting() {
    // Test Case 2: 有效範圍內極大值
    assertThat(calculator.gcd(Integer.MAX_VALUE, Integer.MAX_VALUE))
        .isEqualTo(Integer.MAX_VALUE);
    
    // Test Case 5: 大數測試
    assertThat(calculator.gcd(Integer.MAX_VALUE, Integer.MIN_VALUE))
        .isEqualTo(-1);
}
```

### 5.4 Logical Expressions Coverage (邏輯表達式覆蓋)

**測試工具**: JUnit 5 + AssertJ

**展示內容**:
- 測試檔案: `LogicalExpressionsCoverageTest.java`
- 涵蓋類型: Predicate Coverage, Clause Coverage, Combinatorial Coverage
- 測試案例數: 7 個

**關鍵程式碼**:
```java
@Test
@DisplayName("測試 complexLogic 方法的 Combinatorial Coverage")
void testComplexLogic_CombinatorialCoverage() {
    // Test Case 1: TTTT
    assertThat(calculator.complexLogic(true, true, true, true)).isTrue();
    
    // Test Case 8: TFFF
    assertThat(calculator.complexLogic(true, false, false, false)).isFalse();
}
```

### 5.5 Input Domain Characterization (輸入域特徵化)

**測試工具**: JUnit 5 + AssertJ

**展示內容**:
- 測試檔案: `InputDomainCharacterizationTest.java`
- 涵蓋類型: Categorization, Combinatorial Coverage
- 測試案例數: 6 個

**關鍵程式碼**:
```java
@Test
@DisplayName("測試 classifyNumber 方法的 Categorization")
void testClassifyNumber_Categorization() {
    // Test Case 1: Negative category
    assertThat(processor.classifyNumber(-10)).isEqualTo("NEGATIVE");
    
    // Test Case 2: Small category
    assertThat(processor.classifyNumber(25)).isEqualTo("SMALL");
}
```

### 5.6 Mutation Testing Coverage (變異測試覆蓋)

**測試工具**: JUnit 5 + AssertJ + PIT Mutation Testing

**展示內容**:
- 測試檔案: `MutationTestingCoverageTest.java`
- 測試案例數: 5 個
- 檢測程式碼變異體

**關鍵程式碼**:
```java
@Test
@DisplayName("測試 isPositive 方法的 Mutation Testing Coverage")
void testIsPositive_MutationTestingCoverage() {
    // 可能的變異體：
    // 1. 關係運算子變異：i >= 0 變為 i > 0
    // 2. 返回值變異：return true 變為 return false
    
    assertThat(calculator.isPositive(0)).isTrue();  // 邊界值測試
    assertThat(calculator.isPositive(5)).isTrue();  // 正數測試
    assertThat(calculator.isPositive(-5)).isFalse(); // 負數測試
}
```

**工具使用示範**:
```bash
mvn test-compile org.pitest:pitest-maven:mutationCoverage
```

### 5.7 Equivalence Partition Testing (等價分割測試)

**測試工具**: JUnit 5 + AssertJ

**展示內容**:
- 測試檔案: `EquivalencePartitionTestingTest.java`
- 測試案例數: 6 個
- 將輸入域劃分為等價類

**關鍵程式碼**:
```java
@Test
@DisplayName("測試 isPositive 方法的 Equivalence Partition Testing")
void testIsPositive_EquivalencePartitionTesting() {
    // 等價類劃分：
    // EP1: 正整數 (i > 0) -> 預期結果: true
    // EP2: 零 (i = 0) -> 預期結果: true
    // EP3: 負整數 (i < 0) -> 預期結果: false
    
    assertThat(calculator.isPositive(5)).isTrue();   // EP1
    assertThat(calculator.isPositive(0)).isTrue();   // EP2
    assertThat(calculator.isPositive(-5)).isFalse(); // EP3
}
```

### 5.8 Boundary Value Testing (邊界值測試)

**測試工具**: JUnit 5 + AssertJ

**展示內容**:
- 測試檔案: `BoundaryValueTestingTest.java`
- 測試案例數: 7 個
- 專注測試輸入域的邊界值

**關鍵程式碼**:
```java
@Test
@DisplayName("測試 isPositive 方法的 Boundary Value Testing")
void testIsPositive_BoundaryValueTesting() {
    // 邊界值：0
    // 邊界值測試策略：
    // 1. 邊界值-1: -1 (應該返回 false)
    // 2. 邊界值: 0 (應該返回 true)
    // 3. 邊界值+1: 1 (應該返回 true)
    
    assertThat(calculator.isPositive(-1)).isFalse();
    assertThat(calculator.isPositive(0)).isTrue();
    assertThat(calculator.isPositive(1)).isTrue();
}
```

### 5.9 綜合展示結果

**總測試統計**:
- 總測試案例數: 59 個
- 測試成功率: 100%
- 程式碼覆蓋率: 100%
- 變異測試殺死率: 高於 90%

**執行命令示範**:
```bash
# 執行所有測試並生成覆蓋率報告
mvn clean test jacoco:report

# 執行變異測試
mvn test-compile org.pitest:pitest-maven:mutationCoverage

# 執行特定測試類別
mvn test -Dtest=BoundaryValueTestingTest
```

**報告生成**:
- JaCoCo 覆蓋率報告: `target/site/jacoco/index.html`
- PIT 變異測試報告: `target/pit-reports/`
- Maven 測試報告: `target/surefire-reports/`

---

## 結論

本專案成功展示了現代 Java 測試工具鏈的完整應用，從基礎的單元測試到進階的變異測試，涵蓋了軟體測試的各個重要面向。通過系統性的測試方法論和現代化的測試工具，我們不僅實現了 100% 的程式碼覆蓋率，更重要的是建立了一套可重複、可維護的測試體系。

這些測試工具的使用不僅提高了程式碼品質，也讓我們深入理解了軟體測試的理論與實踐，為未來的軟體開發奠定了堅實的測試基礎。

---

**專案資訊**:
- 學校: 國立臺灣海洋大學 (NTOU)
- 課程: 軟體正規方法
- 專案名稱: Software Testing Homework
- 版本: 1.0.0
