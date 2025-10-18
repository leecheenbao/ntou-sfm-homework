# 軟體測試作業指南

## 📋 目錄

1. [Line Coverage (行覆蓋率)](#1-line-coverage-行覆蓋率)
2. [Graph Coverage (圖覆蓋率)](#2-graph-coverage-圖覆蓋率)
3. [Stress Testing Coverage (壓力測試)](#3-stress-testing-coverage-壓力測試)
4. [Logical Expressions Coverage (邏輯表達式覆蓋率)](#4-logical-expressions-coverage-邏輯表達式覆蓋率)
5. [Input Domain Characterization (輸入域特徵化)](#5-input-domain-characterization-輸入域特徵化)
6. [Mutation Testing Coverage (變異測試)](#6-mutation-testing-coverage-變異測試)

---

## 1. Line Coverage (行覆蓋率)

### 📅 截止日期
- **碩士**: 10/3
- **碩專**: 10/18

### 🎯 測試目標
使用**最少的測試案例**達到測試目標涵蓋率 **100%**

### 📝 測試案例範例

#### 測試目標：`classifyNumber` 方法

##### 程式碼
```java
public String classifyNumber(int number) { // Line 1
    if (number < 0) { // Line 2
        return "NEGATIVE"; // Line 3
    } else if (number == 0) { // Line 4
        return "ZERO"; // Line 5
    } else if (number <= 10) { // Line 6
        return "SMALL"; // Line 7
    } else if (number <= 100) { // Line 8
        return "MEDIUM"; // Line 9
    } else { // Line 10
        return "LARGE"; // Line 11
    }
}
```

##### 測試場景
- **總共行數**: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11

#### Test Case 1 (測試案例 1) - 負數
1. **Input values** (測試時候需要控制資料的值): `number = -1`
2. **Expected result** (正確的結果): `"NEGATIVE"`
3. **Test program's result** (程式執行後的結果): `"NEGATIVE"`
4. **Criteria analysis** (測試目標的分析):
   - **Line coverage**: 測試案例涵蓋的 lines: `1, 2, 3`

#### Test Case 2 (測試案例 2) - 零
1. **Input values** (測試時候需要控制資料的值): `number = 0`
2. **Expected result** (正確的結果): `"ZERO"`
3. **Test program's result** (程式執行後的結果): `"ZERO"`
4. **Criteria analysis** (測試目標的分析):
   - **Line coverage**: 測試案例涵蓋的 lines: `1, 2, 4, 5`

#### Test Case 3 (測試案例 3) - 小正數
1. **Input values** (測試時候需要控制資料的值): `number = 5`
2. **Expected result** (正確的結果): `"SMALL"`
3. **Test program's result** (程式執行後的結果): `"SMALL"`
4. **Criteria analysis** (測試目標的分析):
   - **Line coverage**: 測試案例涵蓋的 lines: `1, 2, 4, 6, 7`

#### Test Case 4 (測試案例 4) - 中等數
1. **Input values** (測試時候需要控制資料的值): `number = 50`
2. **Expected result** (正確的結果): `"MEDIUM"`
3. **Test program's result** (程式執行後的結果): `"MEDIUM"`
4. **Criteria analysis** (測試目標的分析):
   - **Line coverage**: 測試案例涵蓋的 lines: `1, 2, 4, 6, 8, 9`

#### Test Case 5 (測試案例 5) - 大數
1. **Input values** (測試時候需要控制資料的值): `number = 150`
2. **Expected result** (正確的結果): `"LARGE"`
3. **Test program's result** (程式執行後的結果): `"LARGE"`
4. **Criteria analysis** (測試目標的分析):
   - **Line coverage**: 測試案例涵蓋的 lines: `1, 2, 4, 6, 8, 10, 11`

### ✅ 測試結果
- **最少案例數**: 5 個案例
- **總共涵蓋 Lines**: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
- **Line coverage**: **100%** ✅

---

## 2. Graph Coverage (圖覆蓋率)

> 參考: Testing-Introduction.ppt p.36

### 2.1 Edge Coverage (邊覆蓋率)

#### 📅 截止日期
- **碩士**: 10/17
- **碩專**: 10/18

#### 🎯 測試目標
涵蓋所有的邊 (Edges)

#### 📝 測試案例範例

##### 測試目標：`classifyNumber` 方法

##### 控制流圖分析
- **節點**: 1(開始) → 2(if < 0) → 3(return NEGATIVE) / 4(else if == 0) → 5(return ZERO) / 6(else if <= 10) → 7(return SMALL) / 8(else if <= 100) → 9(return MEDIUM) / 10(else) → 11(return LARGE)
- **總共 Edges**: 12, 23, 24, 35, 46, 67, 68, 79, 710, 811, 1011

##### Test Case 1 (測試案例 1) - 負數路徑
1. **Input values** (測試時候需要控制資料的值): `number = -5`
2. **Expected result** (正確的結果): `"NEGATIVE"`
3. **Test program's result** (程式執行後的結果): `"NEGATIVE"`
4. **Criteria analysis** (測試目標的分析):
   - **Edge coverage**: 測試案例涵蓋的 Edges: `12, 23, 35`

##### Test Case 2 (測試案例 2) - 零路徑
1. **Input values** (測試時候需要控制資料的值): `number = 0`
2. **Expected result** (正確的結果): `"ZERO"`
3. **Test program's result** (程式執行後的結果): `"ZERO"`
4. **Criteria analysis** (測試目標的分析):
   - **Edge coverage**: 測試案例涵蓋的 Edges: `12, 24, 46, 67`

##### Test Case 3 (測試案例 3) - 小正數路徑
1. **Input values** (測試時候需要控制資料的值): `number = 5`
2. **Expected result** (正確的結果): `"SMALL"`
3. **Test program's result** (程式執行後的結果): `"SMALL"`
4. **Criteria analysis** (測試目標的分析):
   - **Edge coverage**: 測試案例涵蓋的 Edges: `12, 24, 46, 68, 79`

##### Test Case 4 (測試案例 4) - 中等正數路徑
1. **Input values** (測試時候需要控制資料的值): `number = 50`
2. **Expected result** (正確的結果): `"MEDIUM"`
3. **Test program's result** (程式執行後的結果): `"MEDIUM"`
4. **Criteria analysis** (測試目標的分析):
   - **Edge coverage**: 測試案例涵蓋的 Edges: `12, 24, 46, 68, 710, 811`

##### Test Case 5 (測試案例 5) - 大正數路徑
1. **Input values** (測試時候需要控制資料的值): `number = 150`
2. **Expected result** (正確的結果): `"LARGE"`
3. **Test program's result** (程式執行後的結果): `"LARGE"`
4. **Criteria analysis** (測試目標的分析):
   - **Edge coverage**: 測試案例涵蓋的 Edges: `12, 24, 46, 68, 710, 1011`

##### ✅ 測試結果
- **最少案例數**: 5 個案例
- **總共涵蓋 Edges**: 12, 23, 24, 35, 46, 67, 68, 79, 710, 811, 1011
- **Edge coverage**: **100%** ✅

---

### 2.2 Edge-Pair Coverage (邊對覆蓋率)

#### 📅 截止日期
- **碩士**: 10/17
- **碩專**: 10/18

#### 🎯 測試目標
涵蓋所有相鄰的邊對 (Edge Pairs)

#### 測試說明
使用與 Edge Coverage 相同的測試案例，但分析重點在於**相鄰的邊對**，如：
- (12, 23), (23, 35)
- (12, 24), (24, 46), (46, 67)
- (12, 24), (24, 46), (46, 68), (68, 79)
- 等等...

---

### 2.3 Path Coverage (路徑覆蓋率)

#### 📅 截止日期
- **碩士**: 10/17
- **碩專**: 11/18

#### 🎯 測試目標
涵蓋所有可能的路徑

#### 測試類型

##### 1. 沒繞過迴圈的測試
針對 `classifyNumber` 方法（無迴圈結構），測試所有從開始到結束的路徑：
- 路徑 1: 負數路徑
- 路徑 2: 零路徑
- 路徑 3: 小正數路徑
- 路徑 4: 中等正數路徑
- 路徑 5: 大正數路徑

##### 2. 有繞過迴圈的測試
針對 `sumArray` 或 `findMax` 方法（包含迴圈），測試：
- 不執行迴圈（空陣列或 null）
- 執行迴圈一次（單元素陣列）
- 執行迴圈多次（多元素陣列）

---

## 3. Stress Testing Coverage (壓力測試)

> 參考: Testing-Introduction.ppt p.50

### 📅 截止日期
- **碩士**: 11/7
- **碩專**: 11/8

### 🎯 測試目標
**極端情況測試** - 測試系統在極端條件下的行為

### 📌 重要原則
**先明確定義出程式所用資料的有效範圍**

### 測試案例類型

#### 1) 數值的測試案例
測試有效範圍內：
- a) **極小值**
- b) **極大值**

##### 範例：`classifyNumber` 方法

###### 有效範圍定義
```
有效範圍: 所有 int 值
極小值: Integer.MIN_VALUE (-2,147,483,648)
極大值: Integer.MAX_VALUE (2,147,483,647)
關鍵邊界值: -1, 0, 1, 10, 11, 100, 101
```

###### Test Case 1 (極小值測試)
1. **Input values**: `number = Integer.MIN_VALUE`
2. **Expected result**: `"NEGATIVE"`
3. **Test program's result**: `"NEGATIVE"`
4. **Criteria analysis**: Stress testing - 測試整數的極小值

###### Test Case 2 (極大值測試)
1. **Input values**: `number = Integer.MAX_VALUE`
2. **Expected result**: `"LARGE"`
3. **Test program's result**: `"LARGE"`
4. **Criteria analysis**: Stress testing - 測試整數的極大值

###### Test Case 3-9 (邊界值測試)
測試關鍵邊界值：-1, 0, 1, 10, 11, 100, 101

---

#### 2) 資料有很多筆的測試案例
**先明確定義有效的筆數**，測試有效範圍內：
- a) **最少筆數**
- b) **最多筆數**

##### 範例：`sumArray` 方法

###### 有效範圍定義
```
有效範圍: int 陣列 (可為 null 或任意長度)
類別:
- null 陣列
- 空陣列 (0 筆)
- 單元素陣列 (1 筆)
- 多元素陣列 (> 1 筆)
極值測試: 包含 Integer.MIN_VALUE 或 Integer.MAX_VALUE
```

###### Test Case 1 (null 陣列)
1. **Input values**: `numbers = null`
2. **Expected result**: `0`
3. **Test program's result**: `0`
4. **Criteria analysis**: Stress testing - null 陣列測試

###### Test Case 2 (空陣列)
1. **Input values**: `numbers = []`
2. **Expected result**: `0`
3. **Test program's result**: `0`
4. **Criteria analysis**: Stress testing - 空陣列測試（最少筆數）

###### Test Case 3 (單元素陣列)
1. **Input values**: `numbers = [5]`
2. **Expected result**: `5`
3. **Test program's result**: `5`
4. **Criteria analysis**: Stress testing - 單元素陣列測試

###### Test Case 4 (包含極小值)
1. **Input values**: `numbers = [Integer.MIN_VALUE, 0, 1]`
2. **Expected result**: `Integer.MIN_VALUE + 1`
3. **Test program's result**: `Integer.MIN_VALUE + 1`
4. **Criteria analysis**: Stress testing - 極小值測試

###### Test Case 5 (包含極大值)
1. **Input values**: `numbers = [Integer.MAX_VALUE, 0, -1]`
2. **Expected result**: `Integer.MAX_VALUE - 1`
3. **Test program's result**: `Integer.MAX_VALUE - 1`
4. **Criteria analysis**: Stress testing - 極大值測試

---

#### 3) 無效值的測試案例
**超過限制、不是有效範圍的資料**

##### 範例：`countPrimes` 方法

###### 有效範圍定義
```
有效範圍: n >= 2 (質數最小值為 2)
邊界值: 0, 1, 2
無效值概念: n < 2
```

###### Test Case 1 (無效值 - 0)
1. **Input values**: `n = 0`
2. **Expected result**: `0`
3. **Test program's result**: `0`
4. **Criteria analysis**: Stress testing - 無效值測試（n < 2）

###### Test Case 2 (無效值 - 1)
1. **Input values**: `n = 1`
2. **Expected result**: `0`
3. **Test program's result**: `0`
4. **Criteria analysis**: Stress testing - 邊界無效值測試

###### Test Case 3 (有效最小值 - 2)
1. **Input values**: `n = 2`
2. **Expected result**: `1`
3. **Test program's result**: `1`
4. **Criteria analysis**: Stress testing - 有效範圍最小值測試

### 📊 測試案例總結表

| 測試類型 | 測試內容 | 專案範例 |
|---------|---------|---------|
| 有效範圍 - 極小值 | 測試最小合法值 | `classifyNumber(Integer.MIN_VALUE)` |
| 有效範圍 - 極大值 | 測試最大合法值 | `classifyNumber(Integer.MAX_VALUE)` |
| 有效範圍 - 邊界值 | 測試關鍵邊界 | `classifyNumber(0)`, `classifyNumber(10)` |
| 資料筆數 - 最少 | 測試最少筆數 | `sumArray([])` |
| 資料筆數 - 最多 | 測試大量資料 | `sumArray([1,2,3,...,100])` |
| 無效值測試 | 測試無效輸入 | `countPrimes(0)`, `sumArray(null)` |

---

## 4. Logical Expressions Coverage (邏輯表達式覆蓋率)

> 參考: Testing-Introduction.ppt p.62

### ⚠️ 前提條件
**條件判斷式至少包含兩個子句 (子條件 clauses)**
- the number of clauses > 1

### 測試目標：`complexBooleanLogic` 方法

#### 程式碼
```java
public boolean complexBooleanLogic(boolean a, boolean b, boolean c, boolean d) {
    if ((a && b) || (c && d)) { // 主要邏輯表達式
        return true;
    } else {
        if (a || b) {
            return c || d;
        } else {
            return false;
        }
    }
}
```

#### 邏輯表達式分析
- **主要條件**: `(a && b) || (c && d)`
- **子條件**: a, b, c, d (共 4 個)
- **組合數**: 2^4 = 16 種

---

### 4.1 Predicate Coverage (述詞覆蓋率)

#### 📅 截止日期
- **碩士**: 11/7
- **碩專**: 11/8

#### 🎯 測試目標
**整個條件判斷式的 True 和 False 都要測試過**

#### Test Case 1 - 整個條件為 True
1. **Input values**: `a=true, b=true, c=false, d=false`
2. **Expected result**: `true`
3. **Test program's result**: `true`
4. **Criteria analysis**: Predicate coverage - 整個條件 `(a && b) || (c && d)` 為 true
   - `(true && true) || (false && false)` = `true || false` = `true`

#### Test Case 2 - 整個條件為 False
1. **Input values**: `a=false, b=false, c=false, d=false`
2. **Expected result**: `false`
3. **Test program's result**: `false`
4. **Criteria analysis**: Predicate coverage - 整個條件 `(a && b) || (c && d)` 為 false
   - `(false && false) || (false && false)` = `false || false` = `false`

#### ✅ 測試結果
- **測試案例數**: 2 個
- **Predicate coverage**: **100%** ✅

---

### 4.2 Clause Coverage (子句覆蓋率)

#### 📅 截止日期
- **碩士**: 11/7
- **碩專**: 11/15

#### 🎯 測試目標
**每個子條件的 True 和 False 都要測試過**

#### 測試案例

| Test Case | a | b | c | d | Result |
|-----------|---|---|---|---|--------|
| TC1       | T | T | T | T | true   |
| TC2       | F | F | F | F | false  |
| TC3       | T | F | T | F | true   |
| TC4       | F | T | F | T | true   |

#### 分析
- **a**: TC1(T), TC2(F), TC3(T), TC4(F) - ✅ 涵蓋 T 和 F
- **b**: TC1(T), TC2(F), TC3(F), TC4(T) - ✅ 涵蓋 T 和 F
- **c**: TC1(T), TC2(F), TC3(T), TC4(F) - ✅ 涵蓋 T 和 F
- **d**: TC1(T), TC2(F), TC3(F), TC4(T) - ✅ 涵蓋 T 和 F

#### ✅ 測試結果
- **測試案例數**: 4 個
- **Clause coverage**: **100%** ✅
- 每個子條件的 T 和 F 都已測試過

---

### 4.3 Combinatorial Coverage (組合覆蓋率)

#### 📅 截止日期
- **碩士**: 11/14
- **碩專**: 11/15

#### 🎯 測試目標
**每個子條件 True/False 的全部排列組合都要測試過**

#### 組合計算
```
子條件數量: 4 (a, b, c, d)
排列組合數: 2^4 = 16 種
```

#### 完整測試案例表

| Test Case | a | b | c | d | (a&&b)\|\|(c&&d) | Result |
|-----------|---|---|---|---|-----------------|--------|
| TC1       | T | T | T | T | true            | true   |
| TC2       | T | T | T | F | true            | true   |
| TC3       | T | T | F | T | true            | true   |
| TC4       | T | T | F | F | true            | true   |
| TC5       | T | F | T | T | true            | true   |
| TC6       | T | F | T | F | false           | true   |
| TC7       | T | F | F | T | false           | true   |
| TC8       | T | F | F | F | false           | false  |
| TC9       | F | T | T | T | true            | true   |
| TC10      | F | T | T | F | false           | true   |
| TC11      | F | T | F | T | false           | true   |
| TC12      | F | T | F | F | false           | false  |
| TC13      | F | F | T | T | true            | true   |
| TC14      | F | F | T | F | false           | false  |
| TC15      | F | F | F | T | false           | false  |
| TC16      | F | F | F | F | false           | false  |

#### Test Case 範例

##### Test Case 1: TTTT
1. **Input values**: `a=true, b=true, c=true, d=true`
2. **Expected result**: `true`
3. **Test program's result**: `true`
4. **Criteria analysis**: Combinatorial coverage - TTTT 組合

##### Test Case 8: TFFF
1. **Input values**: `a=true, b=false, c=false, d=false`
2. **Expected result**: `false`
3. **Test program's result**: `false`
4. **Criteria analysis**: Combinatorial coverage - TFFF 組合

##### Test Case 16: FFFF
1. **Input values**: `a=false, b=false, c=false, d=false`
2. **Expected result**: `false`
3. **Test program's result**: `false`
4. **Criteria analysis**: Combinatorial coverage - FFFF 組合

#### ✅ 測試結果
- **測試案例數**: 16 個 (全部組合)
- **Combinatorial coverage**: **100%** ✅
- 所有 2^4 = 16 種 True/False 組合都已測試過

---

### 📊 覆蓋率類型比較

| 覆蓋率類型 | 測試目標 | 本專案測試案例數 | 一般公式 (n個子條件) |
|-----------|---------|----------------|-------------------|
| Predicate Coverage | 整個條件式的 T/F | 2 個 | 至少 2 個 |
| Clause Coverage | 每個子條件的 T/F | 4 個 | 至少 2 個 |
| Combinatorial Coverage | 所有可能的組合 | 16 個 | 2^n 個 |

---

## 5. Input Domain Characterization (輸入域特徵化)

> 參考: Testing-Introduction.ppt p.65

### 📅 截止日期
- **碩士**: 11/21
- **碩專**: 11/22

### 🎯 測試策略
**先根據資料的特性分成幾個不同的類別**

---

### 5.1 Categorization (分類測試)

#### 🎯 測試目標
**每個類別都要測試過**

#### 範例 1: `classifyNumber` 方法

##### 資料分類
根據數字的範圍分類：

| 類別 | 範圍 | 說明 | 測試案例值 |
|------|------|------|-----------|
| 類別 1 | number < 0 | 負數 | -5 |
| 類別 2 | number == 0 | 零 | 0 |
| 類別 3 | 0 < number ≤ 10 | 小正數 | 5 |
| 類別 4 | 10 < number ≤ 100 | 中等正數 | 50 |
| 類別 5 | number > 100 | 大正數 | 150 |

##### Test Case 範例

###### Test Case 1 - 類別 1 (負數)
1. **Input values**: `number = -5` (代表負數類別)
2. **Expected result**: `"NEGATIVE"`
3. **Test program's result**: `"NEGATIVE"`
4. **Criteria analysis**: Input domain characterization - 負數類別

###### Test Case 2 - 類別 2 (零)
1. **Input values**: `number = 0` (代表零類別)
2. **Expected result**: `"ZERO"`
3. **Test program's result**: `"ZERO"`
4. **Criteria analysis**: Input domain characterization - 零類別

###### Test Case 3-5
類似地測試類別 3、4、5

##### ✅ 測試結果
- **測試案例數**: 5 個 (每個類別 1 個)
- **Categorization**: **100%** ✅

---

#### 範例 2: `sumArray` 方法

##### 資料分類
根據陣列的筆數分類：

| 類別 | 說明 | 測試案例值 |
|------|------|-----------|
| 類別 1 | null 陣列 | null |
| 類別 2 | 空陣列 (0 筆) | [] |
| 類別 3 | 單元素陣列 (1 筆) | [5] |
| 類別 4 | 多元素陣列 (> 1 筆) | [1, 2, 3, 4, 5] |

##### Test Case 範例

###### Test Case 1 - 類別 1 (null 陣列)
1. **Input values**: `numbers = null`
2. **Expected result**: `0`
3. **Test program's result**: `0`
4. **Criteria analysis**: Input domain characterization - null 陣列類別

###### Test Case 2 - 類別 2 (空陣列)
1. **Input values**: `numbers = []`
2. **Expected result**: `0`
3. **Test program's result**: `0`
4. **Criteria analysis**: Input domain characterization - 空陣列類別

###### Test Case 3 - 類別 3 (單元素)
1. **Input values**: `numbers = [5]`
2. **Expected result**: `5`
3. **Test program's result**: `5`
4. **Criteria analysis**: Input domain characterization - 單元素陣列類別

###### Test Case 4 - 類別 4 (多元素)
1. **Input values**: `numbers = [1, 2, 3, 4, 5]`
2. **Expected result**: `15`
3. **Test program's result**: `15`
4. **Criteria analysis**: Input domain characterization - 多元素陣列類別

##### ✅ 測試結果
- **測試案例數**: 4 個 (每個類別 1 個)
- **Categorization**: **100%** ✅

---

### 5.2 Combinatorial (組合測試)

#### 🎯 測試目標
**各種類別的全部排列組合都要測試過**

#### 說明
當有多個參數需要測試時，需要測試所有參數類別的組合。

#### 計算公式
```
組合數 = 參數1的類別數 × 參數2的類別數 × ... × 參數n的類別數
```

#### 範例: 兩個參數的組合
假設有一個方法需要兩個參數：
```
參數 1: 資料筆數 (0筆, 1筆, 多筆) - 3個類別
參數 2: 資料類型 (正數, 負數) - 2個類別

組合數: 3 × 2 = 6
```

| Test Case | 參數 1 (筆數) | 參數 2 (類型) | 測試案例 |
|-----------|--------------|-------------|----------|
| TC1       | 0 筆         | 正數        | [] |
| TC2       | 0 筆         | 負數        | [] |
| TC3       | 1 筆         | 正數        | [5] |
| TC4       | 1 筆         | 負數        | [-5] |
| TC5       | 多筆         | 正數        | [1, 2, 3] |
| TC6       | 多筆         | 負數        | [-1, -2, -3] |

---

### 📊 比較

| 測試方法 | 測試目標 | 測試案例數 | 專案範例 |
|---------|---------|-----------|---------|
| Categorization | 每個類別至少測一次 | = 類別數 | `classifyNumber`: 5 個類別 = 5 個測試 |
| Combinatorial | 所有類別組合 | = 類別數的乘積 | 3個筆數類別 × 2個類型 = 6 個測試 |

### 💡 重點提示

1. **Categorization**: 適用於單一參數的測試
   - 簡單快速
   - 測試案例數量較少
   - 保證每個類別都被測試

2. **Combinatorial**: 適用於多參數的測試
   - 更全面的測試
   - 測試案例數量隨參數增加而快速增長
   - 能發現參數間的交互作用問題

---

## 6. Mutation Testing Coverage (變異測試)

> 參考: Testing-Introduction.ppt p.66

### 📅 截止日期
- **碩士**: 11/28
- **碩專**: 11/29

### 🎯 測試目標
**評估測試案例的品質** - 測試是否能夠偵測到程式碼的變異

### 📝 變異測試步驟

#### 每一次變異 (Mutation):

##### a) 建立變異程式
- **只改原本程式的一個敘述** (只改一個 statement)
- 來得到**一個變異程式** (Mutant)

##### b) 執行測試
- **找出一個合適的測試案例**使得：
  - 原本程式跟變異程式的**執行結果不同**

---

### 📋 變異測試範例

#### 範例 1: `classifyNumber` 方法

##### 原始程式
```java
public String classifyNumber(int number) {
    if (number < 0) {           // Statement 1
        return "NEGATIVE";       // Statement 2
    } else if (number == 0) {   // Statement 3
        return "ZERO";           // Statement 4
    } else if (number <= 10) {  // Statement 5
        return "SMALL";          // Statement 6
    } else if (number <= 100) { // Statement 7
        return "MEDIUM";         // Statement 8
    } else {                     // Statement 9
        return "LARGE";          // Statement 10
    }
}
```

---

##### 變異 1: 改變關係運算子 (Statement 1)
```java
// 原始: if (number < 0)
// 變異: if (number <= 0)  ← 將 < 改為 <=
```

**Test Case 1 (殺死此變異)**:
1. **Input values**: `number = 0`
2. **原始程式結果**: `"ZERO"`
3. **變異程式結果**: `"NEGATIVE"`
4. **分析**: 原始程式與變異程式結果不同 ✅ **變異被殺死**

---

##### 變異 2: 改變常數 (Statement 5)
```java
// 原始: else if (number <= 10)
// 變異: else if (number <= 11)  ← 將 10 改為 11
```

**Test Case 2 (殺死此變異)**:
1. **Input values**: `number = 11`
2. **原始程式結果**: `"MEDIUM"`
3. **變異程式結果**: `"SMALL"`
4. **分析**: 原始程式與變異程式結果不同 ✅ **變異被殺死**

---

##### 變異 3: 改變關係運算子 (Statement 7)
```java
// 原始: else if (number <= 100)
// 變異: else if (number < 100)  ← 將 <= 改為 <
```

**Test Case 3 (殺死此變異)**:
1. **Input values**: `number = 100`
2. **原始程式結果**: `"MEDIUM"`
3. **變異程式結果**: `"LARGE"`
4. **分析**: 原始程式與變異程式結果不同 ✅ **變異被殺死**

---

#### 範例 2: `sumArray` 方法

##### 原始程式
```java
public int sumArray(int[] numbers) {
    if (numbers == null || numbers.length == 0) {  // Statement 1
        return 0;                                    // Statement 2
    }
    
    int sum = 0;          // Statement 3
    int i = 0;            // Statement 4
    
    while (i < numbers.length) {  // Statement 5
        sum += numbers[i];         // Statement 6
        i++;                       // Statement 7
    }
    
    return sum;           // Statement 8
}
```

---

##### 變異 4: 改變算術運算子 (Statement 6)
```java
// 原始: sum += numbers[i];
// 變異: sum -= numbers[i];  ← 將 += 改為 -=
```

**Test Case 4 (殺死此變異)**:
1. **Input values**: `numbers = [1, 2, 3]`
2. **原始程式結果**: `6`
3. **變異程式結果**: `-6`
4. **分析**: 原始程式與變異程式結果不同 ✅ **變異被殺死**

---

##### 變異 5: 改變關係運算子 (Statement 5)
```java
// 原始: while (i < numbers.length)
// 變異: while (i <= numbers.length)  ← 將 < 改為 <=
```

**Test Case 5 (殺死此變異)**:
1. **Input values**: `numbers = [1, 2, 3]`
2. **原始程式結果**: `6`
3. **變異程式結果**: `ArrayIndexOutOfBoundsException`
4. **分析**: 變異程式拋出異常 ✅ **變異被殺死**

---

### 🎯 變異測試的目的

1. **評估測試品質**: 好的測試應該能殺死 (kill) 變異程式
2. **找出測試弱點**: 無法殺死的變異 (survived mutants) 表示測試不足
3. **改進測試案例**: 根據存活的變異來增強測試

### 📊 變異分數 (Mutation Score)

```
變異分數 = 被殺死的變異數 / 總變異數 × 100%

範例:
- 總變異數: 50
- 被殺死的變異數: 45
- 存活的變異數: 5
- 變異分數 = 45 / 50 × 100% = 90%
```

**目標**: 達到高變異分數 (通常 > 80%)

---

### 常見變異類型

| 變異類型 | 說明 | 專案範例 |
|---------|------|---------|
| 算術運算子變異 | 改變 +, -, *, / | `sum += numbers[i]` → `sum -= numbers[i]` |
| 關係運算子變異 | 改變 <, >, ==, != | `number < 0` → `number <= 0` |
| 邏輯運算子變異 | 改變 &&, \|\| | `a && b` → `a \|\| b` |
| 常數變異 | 改變常數值 | `number <= 10` → `number <= 11` |
| 變數變異 | 改變變數名稱 | `sum += numbers[i]` → `sum += numbers[0]` |
| 邊界條件變異 | 改變迴圈或條件邊界 | `i < length` → `i <= length` |

---

### 💡 變異測試最佳實踐

1. **針對每個敘述設計變異**
   - 系統性地對每個 statement 進行變異

2. **一次只變異一個敘述**
   - 保持變異的簡單性和可追蹤性

3. **設計能殺死變異的測試案例**
   - 測試案例應該能夠區分原始程式和變異程式

4. **關注存活的變異**
   - 存活的變異表示測試覆蓋不足
   - 需要增加測試案例來殺死這些變異

5. **使用自動化工具**
   - PIT (本專案使用)
   - 自動生成和執行變異測試

---

### 🔧 使用 PIT 進行變異測試

#### 執行變異測試
```bash
# 執行 PIT 變異測試
mvn org.pitest:pitest-maven:mutationCoverage

# 查看報告
open report/pit/[timestamp]/index.html
```

#### PIT 報告內容
- **Line Coverage**: 程式碼行覆蓋率
- **Mutation Coverage**: 變異覆蓋率
- **Test Strength**: 測試強度 (殺死變異的能力)
- **Survived Mutants**: 存活的變異列表

---

## 📚 附錄: 測試覆蓋率總覽

### 專案測試統計

| 測試類型 | 主要目標 | 難度 | 專案測試案例數 | 說明 |
|---------|---------|------|--------------|------|
| Line Coverage | 涵蓋所有程式碼行 | ⭐ | 5個 | `classifyNumber` 方法 |
| Edge Coverage | 涵蓋所有分支邊 | ⭐⭐ | 5個 | 涵蓋所有控制流邊 |
| Edge-Pair Coverage | 涵蓋所有邊對 | ⭐⭐⭐ | 5個 | 涵蓋所有相鄰邊對 |
| Path Coverage | 涵蓋所有路徑 | ⭐⭐⭐⭐ | 5個 | 5條完整路徑 |
| Stress Testing | 測試極端情況 | ⭐⭐ | 9個 | 極值和邊界值測試 |
| Predicate Coverage | 測試條件式結果 | ⭐⭐ | 2個 | 整個條件的 T/F |
| Clause Coverage | 測試每個子條件 | ⭐⭐⭐ | 4個 | 4個子條件的 T/F |
| Combinatorial Coverage | 測試所有組合 | ⭐⭐⭐⭐ | 16個 | 2^4 = 16 種組合 |
| Input Domain | 測試輸入分類 | ⭐⭐⭐ | 5個 | 5個輸入類別 |
| Mutation Testing | 評估測試品質 | ⭐⭐⭐⭐⭐ | 多個 | 使用 PIT 自動生成 |

### 測試方法對照表

| 測試類型 | 專案中的測試類別 | 測試方法數 |
|---------|----------------|-----------|
| Line Coverage | `NumberProcessorLineCoverageTest` | 5個方法 |
| Graph Coverage | `GraphCoverageTest` | 3個方法 (Edge, Edge-Pair, Path) |
| Stress Testing | `StressTestingCoverageTest` | 3個方法 |
| Logical Expressions | `LogicalExpressionsCoverageTest` | 3個方法 (Predicate, Clause, Combinatorial) |
| Input Domain | `InputDomainCharacterizationTest` | 2個方法 |
| Equivalence Partition | `EquivalencePartitionTestingTest` | 1個方法 |
| Boundary Value | `BoundaryValueTestingTest` | 1個方法 |
| Mutation Testing | `MutationTestingCoverageTest` | 多個方法 |

---

## 💡 重要提醒

### ✅ 測試案例設計原則
1. **最少測試案例**: 使用最少的測試達到 100% 覆蓋率
2. **明確定義**: 清楚定義有效範圍和無效範圍
3. **預期結果**: 每個測試都要有明確的預期結果
4. **可重現性**: 測試結果應該要可以重現

### 📝 測試文件要求
每個測試案例應包含：
1. **Input values** (測試時候需要控制資料的值) - 輸入值
2. **Expected result** (正確的結果) - 預期結果
3. **Test program's result** (程式執行後的結果) - 實際執行結果
4. **Criteria analysis** (測試目標的分析) - 覆蓋率分析

### 🎯 覆蓋率目標
- **目標**: 達到 **100%** 覆蓋率
- **方法**: 使用**最少的測試案例**
- **驗證**: 使用工具 (如 JaCoCo) 驗證覆蓋率
- **專案成果**: 
  - 指令覆蓋率: 100% ✅
  - 分支覆蓋率: 100% ✅
  - 行覆蓋率: 100% ✅
  - 方法覆蓋率: 100% ✅
  - 類別覆蓋率: 100% ✅

---

## 🛠️ 專案工具使用

### Maven 指令
```bash
# 編譯專案
mvn compile

# 執行測試
mvn test

# 生成覆蓋率報告
mvn test jacoco:report

# 執行變異測試
mvn org.pitest:pitest-maven:mutationCoverage

# 清理專案
mvn clean

# 完整測試流程
mvn clean test jacoco:report
```

### 使用測試腳本
```bash
# Linux/macOS
./run-tests.sh all        # 執行所有測試
./run-tests.sh coverage   # 生成覆蓋率報告
./run-tests.sh line       # 執行 Line Coverage 測試
./run-tests.sh graph      # 執行 Graph Coverage 測試
./run-tests.sh help       # 查看幫助信息

# Windows
run-tests.bat all
run-tests.bat coverage
run-tests.bat line
```

### 查看報告
```bash
# JaCoCo 覆蓋率報告
open report/jacoco/index.html

# PIT 變異測試報告
open report/pit/[timestamp]/index.html

# Maven 測試報告
ls report/surefire/
```

---

## 📞 參考資源

### 課程資源
- **課程簡報**: Testing-Introduction.ppt
- **關鍵頁數**:
  - p.36 - Graph Coverage
  - p.50 - Stress Testing
  - p.62 - Logical Expressions
  - p.65 - Input Domain
  - p.66 - Mutation Testing

### 測試工具
- **JUnit 5**: 測試框架 (版本 5.9.2)
- **AssertJ**: 斷言庫 (版本 3.24.2)
- **JaCoCo**: 程式碼覆蓋率工具 (版本 0.8.8)
- **PIT**: 變異測試工具 (版本 1.9.11)
- **Maven Surefire**: 測試執行器 (版本 3.0.0)

### 專案結構
```
homework/
├── src/
│   ├── main/java/com/ntou/testing/
│   │   └── NumberProcessor.java          # 被測試的主程式
│   └── test/java/com/ntou/testing/
│       ├── NumberProcessorLineCoverageTest.java
│       ├── GraphCoverageTest.java
│       ├── StressTestingCoverageTest.java
│       ├── LogicalExpressionsCoverageTest.java
│       ├── InputDomainCharacterizationTest.java
│       ├── EquivalencePartitionTestingTest.java
│       ├── BoundaryValueTestingTest.java
│       └── MutationTestingCoverageTest.java
├── report/
│   ├── jacoco/                          # JaCoCo 覆蓋率報告
│   ├── pit/                             # PIT 變異測試報告
│   └── surefire/                        # Maven 測試報告
├── pom.xml                               # Maven 配置文件
├── run-tests.sh                          # Linux/macOS 測試腳本
└── run-tests.bat                         # Windows 測試腳本
```

---

**最後更新日期**: 2025年10月18日

**專案狀態**: 
- ✅ 所有測試技術已實現
- ✅ 100% 程式碼覆蓋率達成
- ✅ 完整測試文件與報告

