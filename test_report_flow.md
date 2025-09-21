# 程式碼執行流程圖

## 1. classifyNumber 方法執行流程圖

```mermaid
flowchart TD
    Start([開始]) --> Input["接收參數 number"]
    Input --> Check1{"number < 0?"}
    Check1 -->|是| Return1["return NEGATIVE"]
    Check1 -->|否| Check2{"number == 0?"}
    Check2 -->|是| Return2["return ZERO"]
    Check2 -->|否| Check3{"number <= 10?"}
    Check3 -->|是| Return3["return SMALL"]
    Check3 -->|否| Check4{"number <= 100?"}
    Check4 -->|是| Return4["return MEDIUM"]
    Check4 -->|否| Return5["return LARGE"]
    Return1 --> End([結束])
    Return2 --> End
    Return3 --> End
    Return4 --> End
    Return5 --> End
```

## 2. sumArray 方法執行流程圖

```mermaid
flowchart TD
    Start([開始]) --> Input["接收參數 numbers[]"]
    Input --> CheckNull{"numbers == null?"}
    CheckNull -->|是| Return0["return 0"]
    CheckNull -->|否| CheckEmpty{"numbers.length == 0?"}
    CheckEmpty -->|是| Return0
    CheckEmpty -->|否| Init["sum = 0<br/>i = 0"]
    Init --> LoopCheck{"i < numbers.length?"}
    LoopCheck -->|是| Add["sum += numbers[i]<br/>i++"]
    Add --> LoopCheck
    LoopCheck -->|否| ReturnSum["return sum"]
    Return0 --> End([結束])
    ReturnSum --> End
```

## 3. findMax 方法執行流程圖

```mermaid
flowchart TD
    Start([開始]) --> Input["接收參數 numbers[]"]
    Input --> CheckNull{"numbers == null 或 numbers.length == 0?"}
    CheckNull -->|是| ReturnMin["return Integer.MIN_VALUE"]
    CheckNull -->|否| Init["max = numbers[0]<br/>i = 1"]
    Init --> LoopCheck{"i < numbers.length?"}
    LoopCheck -->|是| CheckMax{"numbers[i] > max?"}
    CheckMax -->|是| UpdateMax["max = numbers[i]"]
    CheckMax -->|否| IncI["i++"]
    UpdateMax --> IncI
    IncI --> LoopCheck
    LoopCheck -->|否| ReturnMax["return max"]
    ReturnMin --> End([結束])
    ReturnMax --> End
```

## 4. complexBooleanLogic 方法執行流程圖

```mermaid
flowchart TD
    Start([開始]) --> Input["接收參數 a, b, c, d"]
    Input --> Check1{"(a && b) 或 (c && d)?"}
    Check1 -->|true| ReturnTrue["return true"]
    Check1 -->|false| Check2{"a 或 b?"}
    Check2 -->|true| Check3{"c 或 d?"}
    Check2 -->|false| ReturnFalse["return false"]
    Check3 -->|true| ReturnTrue2["return true"]
    Check3 -->|false| ReturnFalse2["return false"]
    ReturnTrue --> End([結束])
    ReturnTrue2 --> End
    ReturnFalse --> End
    ReturnFalse2 --> End
```

## 5. countPrimes 方法執行流程圖

```mermaid
flowchart TD
    Start([開始]) --> Input["接收參數 n"]
    Input --> CheckN{"n < 2?"}
    CheckN -->|是| Return0["return 0"]
    CheckN -->|否| Init["count = 0<br/>num = 2"]
    Init --> OuterLoop{"num <= n?"}
    OuterLoop -->|否| ReturnCount["return count"]
    OuterLoop -->|是| CheckPrime["isPrime = true<br/>i = 2"]
    CheckPrime --> InnerLoop{"i * i <= num?"}
    InnerLoop -->|是| CheckDiv{"num % i == 0?"}
    CheckDiv -->|是| SetFalse["isPrime = false<br/>break"]
    CheckDiv -->|否| IncI["i++"]
    IncI --> InnerLoop
    SetFalse --> CheckPrimeResult{"isPrime?"}
    InnerLoop -->|否| CheckPrimeResult
    CheckPrimeResult -->|是| IncCount["count++"]
    CheckPrimeResult -->|否| IncNum["num++"]
    IncCount --> IncNum
    IncNum --> OuterLoop
    Return0 --> End([結束])
    ReturnCount --> End
```

## 6. 程式碼覆蓋率分析

### 覆蓋率統計

| 方法 | 指令覆蓋率 | 分支覆蓋率 | 行覆蓋率 | 方法覆蓋率 |
|------|------------|------------|----------|------------|
| classifyNumber | 100% | 100% | 100% | 100% |
| sumArray | 100% | 100% | 100% | 100% |
| findMax | 100% | 100% | 100% | 100% |
| complexBooleanLogic | 100% | 100% | 100% | 100% |
| countPrimes | 100% | 100% | 100% | 100% |
| **總計** | **100%** | **100%** | **100%** | **100%** |

## 7. 測試執行流程

```mermaid
flowchart TD
    Start([開始測試]) --> Compile["編譯程式碼"]
    Compile --> RunTests["執行測試案例"]
    RunTests --> Coverage["生成覆蓋率報告"]
    Coverage --> Mutation["執行變異測試"]
    Mutation --> Report["生成測試報告"]
    Report --> End([測試完成])
    
    RunTests --> LineTest["Line Coverage 測試"]
    RunTests --> GraphTest["Graph Coverage 測試"]
    RunTests --> StressTest["Stress Testing 測試"]
    RunTests --> LogicTest["Logical Expressions 測試"]
    RunTests --> InputTest["Input Domain 測試"]
    RunTests --> EquivTest["Equivalence Partition 測試"]
    RunTests --> BoundaryTest["Boundary Value 測試"]
    RunTests --> MutationTest["Mutation Testing 測試"]
```

## 8. 測試案例統計

```mermaid
pie title 測試案例分布 (總計 22 個)
    "Line Coverage" : 5
    "Graph Coverage" : 3
    "Stress Testing" : 3
    "Logical Expressions" : 3
    "Input Domain" : 2
    "Equivalence Partition" : 1
    "Boundary Value" : 1
    "Mutation Testing" : 4
```

---

**說明**: 每個測試案例都遵循特定的測試策略，確保 NumberProcessor 類別的所有方法達到 100% 的覆蓋率。流程圖展示了每個測試類別內部的詳細執行步驟和驗證過程。
