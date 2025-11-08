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
### 測試案例（最小集合達成 100% 覆蓋）
- 案例 1：`n = 1`
  - 2-1) Input values：`n = 1`
  - 2-2) expected result：`0`
  - 2-3) test program's result：`0`
  - 2-4) criteria analysis：覆蓋 `if (n < 2)` true 分支，直接回傳（涵蓋行：1-3）
- 案例 2：`n = 2`
  - 2-1) Input values：`n = 2`
  - 2-2) expected result：`1`
  - 2-3) test program's result：`1`
  - 2-4) criteria analysis：覆蓋 `if` false 分支、外層 `for` 單次迭代、內層 `for` 條件為 false，驗證質數累計與 `if (isPrime)` true（涵蓋行：1-7、13-18）
- 案例 3：`n = 10`
  - 2-1) Input values：`n = 10`
  - 2-2) expected result：`4`（質數為 2、3、5、7）
  - 2-3) test program's result：`4`
  - 2-4) criteria analysis：覆蓋內層 `if (i % j == 0)` true/false 分支、`break` 路徑、`if (isPrime)` true/false，涵蓋所有迴圈路徑（涵蓋行：1-18）

## 測試工具展示
- 測試框架：JUnit 5（Maven Surefire 自動偵測 JUnitPlatformProvider）。
- 相關測試方法：`NumberProcessorLineCoverageTest#testCountPrimes_LineCoverage100` 內含上述三個案例的斷言，逐一比對預期與實際結果。
- 工具比對報告：`report/surefire/com.ntou.testing.NumberProcessorLineCoverageTest.txt` 顯示 `Tests run: 5, Failures: 0`，證明所有斷言通過。
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

