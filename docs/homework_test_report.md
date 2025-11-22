# 作業一測試報告

## 被測試的函式（NumberProcessor.java）
### `countPrimes(int n)`
- 目的：計算小於等於 `n` 的質數個數。
- 特性：含 `if` 邊界判斷與雙層 `for` 迴圈，每層皆有條件分支與 `break`，整體超過 12 行指令。
- 邊界：`n` 小於 2 時直接回傳 0；`n = 2` 內層迴圈不執行；`n` 較大時需涵蓋質數與合數檢查。

```java
// src/main/java/com/ntou/testing/NumberProcessor.java
    public int countPrimes(int n) {
        if (n < 2) {            // 邊界檢查：排除 0、1
            return 0;
        }

        int count = 0;          // 累計質數數量
        for (int i = 2; i <= n; i++) {                // 外層迴圈：遍歷候選數
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {        // 內層迴圈：檢查質數
                if (i % j == 0) {                     // 若可被整除，標記為非質數
                    isPrime = false;
                    break;                            // 提前結束檢查
                }
            }
            if (isPrime) {                            // 確認為質數後累計
                count++;
            }
        }

        return count;            // 回傳最終統計
    }
```

## 測試案例詳解（最小集合達成 100% 覆蓋）
### 測試案例（最小集合達成 100% 覆蓋＋變異測試延伸）

有效範圍為 1 - 65535
- 案例 1：`n = 1`
  - 2-1) Input values：`n = 1`
  - 2-2) expected result：`0`
  - 2-3) test program's result：`0`
  - 2-4) criteria analysis：覆蓋 `if (n < 2)` true 分支，直接回傳（涵蓋行：1-3）
- 案例 2：`n = 65535`
  - 2-1) Input values：`n = 65535`
  - 2-2) expected result：`6542`
  - 2-3) test program's result：`6542`
  - 2-4) criteria analysis：變異測試延伸案例，驗證長迴圈與條件變異是否被殺死，同時檢查大範圍質數計數的正確性（涵蓋行：1-18）
- 案例 3：`n = 0`
  - 2-1) Input values：`n = 0`
  - 2-2) expected result：`0`
  - 2-3) test program's result：`0`
  - 2-4) criteria analysis：變異測試延伸案例，再次確認 `n < 2` 分支對 0 的處理，確保對應變異（將條件修改為 `< 1` 等）會被測試殺死，避免邏輯倒退（涵蓋行：1-3）

## 測試工具展示
- 測試框架：JUnit 5（Maven Surefire 自動偵測 JUnitPlatformProvider）。
- 相關測試方法：
  - `NumberProcessorLineCoverageTest#testCountPrimes_LineCoverage100` 覆蓋案例 1~3。
  - `MutationTestingCoverageTest#testCountPrimes_MutationTestingCoverage` 覆蓋案例 4、案例 5，透過變異測試框架驗證對大型輸入與邊界值的穩定度。
- 工具比對報告：
  - `report/surefire/com.ntou.testing.NumberProcessorLineCoverageTest.txt` 顯示 `Tests run: 5, Failures: 0`，證明最小集合所有斷言通過。
  - `report/surefire/com.ntou.testing.MutationTestingCoverageTest.txt` 顯示 `Tests run: 4, Failures: 0`，證明變異延伸案例與斷言通過。
- 指令：`mvn test`
- 範例執行：
```bash
# Terminal
$ mvn test
[INFO] Running com.ntou.testing.NumberProcessorLineCoverageTest
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

```bash
# Terminal
$ mvn test
[INFO] Scanning for projects...
[INFO] -----------------< com.ntou:software-testing-homework >-----------------
[INFO] Building Software Testing Homework 1.0.0
[INFO] --- surefire:3.0.0:test (default-test) @ software-testing-homework ---
[INFO] Running com.ntou.testing.NumberProcessorLineCoverageTest
[INFO] Tests run: 5, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.003 s
[INFO] Results:
[INFO] Tests run: 22, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

## Line Coverage
- 報告來源：`report/jacoco/index.html` 與 `report/jacoco/com.ntou.testing/NumberProcessor.java.html`
- `countPrimes` 指令、分支、行覆蓋率皆為 100%（指令全綠、分支全綠、行全綠）。
- 未覆蓋行：無；JaCoCo 標示所有行為綠色。


## 5. countPrimes 方法執行流程圖

``` mermaid
flowchart TD
    Start([開始]) -->|1| Input["接收參數 n"]
    Input -->|2| CheckN{"n < 2?"}
    CheckN -->|是| Return0["return 0"]
    CheckN -->|否| Init["count = 0<br/>num = 2"]
    Init -->|5| OuterLoop{"num <= n?"}
    OuterLoop -->|否| ReturnCount["return count"]
    OuterLoop -->|是| CheckPrime["isPrime = true<br/>i = 2"]
    CheckPrime -->|8| InnerLoop{"i * i <= num?"}
    InnerLoop -->|是| CheckDiv{"num % i == 0?"}
    CheckDiv -->|是| SetFalse["isPrime = false<br/>break"]
    CheckDiv -->|否| IncI["i++"]
    IncI -->|迴圈| InnerLoop
    SetFalse -->|13| CheckPrimeResult{"isPrime?"}
    InnerLoop -->|否| CheckPrimeResult
    CheckPrimeResult -->|是| IncCount["count++"]
    CheckPrimeResult -->|否| IncNum["num++"]
    IncCount -->|17| IncNum
    IncNum -->|18| OuterLoop
    Return0 -->|19| End([結束])
    ReturnCount -->|20| End
```

### 路徑說明

  - **1-2**: 開始 → 輸入參數
  - **3**: n \< 2 路徑 (無質數)
  - **4**: n \>= 2 路徑 (進入質數計算)
  - **5**: 初始化後進入外迴圈檢查
  - **6**: 外迴圈結束路徑 (num \> n)
  - **7**: 外迴圈執行路徑 (num \<= n)
  - **8**: 初始化質數檢查後進入內迴圈
  - **9**: 內迴圈執行路徑 (i \* i \<= num)
  - **10**: 發現因數路徑 (num % i == 0) - 不是質數
  - **11**: 未發現因數路徑 (num % i \!= 0) - 繼續檢查
  - **12**: 內迴圈回(繼續檢查下一個除數)
  - **13**: 中斷內迴圈後檢查質數結果
  - **14**: 內迴圈正常結束路徑 (i \* i \> num)
  - **15**: 是質數路徑 (count++)
  - **16**: 不是質數路徑 (直接進入下一個數)
  - **17**: 計數後準備檢查下一個數
  - **18**: 外迴圈回(檢查下一個數是否為質數)
  - **19-20**: 各返回路徑到結束

### 覆蓋率數據

| 覆蓋類型           | 總數 | 最少路徑數 | 覆蓋率  | 覆蓋路徑範例 (Path) |
| :----------------- | :--- | :--------- | :------ | :------------------ |
| **Edge Coverage** | 20   | 5          | 100%    | 1→2→3→19, <br>1→2→4→5→6→20 (n=1), <br>1→2→4→5→7→8→14→16→18→5→6→20 (n=2, 質數), <br>1→2→4→5→7→8→9→10→13→16→18→5→6→20 (n=4, 合數), <br>1→2→4→5→7→8→9→11→12→8→14→16→18→5→6→20 (n=9, 合數，多個除數) |
| **Edge-Pair Coverage** | 20   | 5          | 100%    | 同上 |
| **Path Coverage** | 無限\* | N/A        | N/A     | \*因有嵌套迴圈，總路徑數為無限。此處列出覆蓋所有邊/邊對所需的代表性路徑。 |
