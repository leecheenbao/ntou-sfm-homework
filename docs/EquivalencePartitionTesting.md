# Equivalence Partition Testing (等價類別分割測試)

## 7) Equivalence Partition (Valid/Invalid)

### 測試目標

先根據資料的特性（例如：帳號、密碼）清楚列出有效跟無效的條件。

### 案例說明：學號測試

#### 案例情境：Starting char、Chars、Length

#### 等價類別分析表

| 案例情境 | 有效 | 編號 | 無效 | 編號 |
|---------|------|------|------|------|
| **Starting char** | Starts 1-9 | 1 | Starts other | 2 |
| **Chars** | [A-Z0-9] | 3 | Has others | 4 |
| **Length** | 1-8 chars | 5 | 0 chars | 6 |
| | | | > 8 chars | 7 |

---

## 1) 詳細說明被測試的 function

### 程式碼要求

- ✅ 被測試的程式碼(function)必須至少有 **12 行的指令**：**符合**
  - 被測程式：**71 行**（PHP 版本），**89 行**（Java 版本）
  - 測試程式：**80 行**（PHP 版本），**313 行**（Java 版本）

- ✅ 被測試的程式碼(function)必須要有：
  - **i) if** 條件判斷：**符合**
  - **ii) 迴圈**：**符合**

---

## 被測程式

### PHP 版本

```php
<?php
class StringSpecification
{
    /**
     * 分析輸入字串並回傳符合的條件編號
     * Starting char:
     *      1: Starts 1-9
     *      2: Starts other
     * Chars:
     *      3: [A-Z0-9] 
     *      4: Has others
     * Length:
     *      5: 1-8 chars
     *      6: 0 chars
     *      7: > 8 chars
     */
    public function analyze(string $input): array
    {
        $length = strlen($input);
        $result = [];

        // 處理 Length 編號 6: 0 chars
        if ($length === 0) {
            return [6];
        }

        // 處理 Starting char (編號 1, 2)
        $firstChar = $input[0];

        // 條件: Starts 1-9
        if ($firstChar >= '1' && $firstChar <= '9') {
            $result[] = 1;
        } else {
            // 條件: Starts other
            $result[] = 2;
        }

        // 處理 Chars (編號 3, 4) - 使用迴圈 (Loop)
        $hasOtherChar = false;
        for ($i = 0; $i < $length; $i++) {
            $char = $input[$i];
            // 檢查字元是否為 A-Z 或 0-9
            $isAlpha = ($char >= 'A' && $char <= 'Z');
            $isDigit = ($char >= '0' && $char <= '9');
            if (!$isAlpha && !$isDigit) {
                $hasOtherChar = true;
                break; // 只要發現一個其他字元，即可跳出
            }
        }

        if ($hasOtherChar) {
            $result[] = 4;
        } else {
            $result[] = 3;
        }

        // 處理 Length (編號 5, 7)
        if ($length >= 1 && $length <= 8) {
            $result[] = 5;
        } elseif ($length > 8) {
            $result[] = 7;
        }

        // 排序結果以符合輸出格式 (Start, Char, Length) -> (1/2, 3/4, 5/7)
        sort($result);
        return $result;
    }
}
```

### Java 版本

```java
package com.ntou.testing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 字串規格分析器類別
 * 分析輸入字串並回傳符合的條件編號
 * 
 * Starting char:
 *      1: Starts 1-9
 *      2: Starts other
 * Chars:
 *      3: [A-Z0-9] 
 *      4: Has others
 * Length:
 *      5: 1-8 chars
 *      6: 0 chars
 *      7: > 8 chars
 */
public class StringSpecification {
    
    /**
     * 分析輸入字串並回傳符合的條件編號
     * 
     * @param input 要分析的輸入字串
     * @return 符合的條件編號列表，已排序
     */
    public List<Integer> analyze(String input) {
        int length = input.length();
        List<Integer> result = new ArrayList<>();
        
        // 處理 Length 編號 6: 0 chars
        if (length == 0) {
            result.add(6);
            return result;
        }
        
        // 處理 Starting char (編號 1, 2)
        char firstChar = input.charAt(0);
        
        // 條件: Starts 1-9
        if (firstChar >= '1' && firstChar <= '9') {
            result.add(1);
        } else {
            // 條件: Starts other
            result.add(2);
        }
        
        // 處理 Chars (編號 3, 4) - 使用迴圈 (Loop)
        boolean hasOtherChar = false;
        
        for (int i = 0; i < length; i++) {
            char ch = input.charAt(i);
            
            // 檢查字元是否為 A-Z 或 0-9
            boolean isAlpha = (ch >= 'A' && ch <= 'Z');
            boolean isDigit = (ch >= '0' && ch <= '9');
            
            if (!isAlpha && !isDigit) {
                hasOtherChar = true;
                break; // 只要發現一個其他字元，即可跳出
            }
        }
        
        if (hasOtherChar) {
            result.add(4);
        } else {
            result.add(3);
        }
        
        // 處理 Length (編號 5, 7)
        if (length >= 1 && length <= 8) {
            result.add(5);
        } else if (length > 8) {
            result.add(7);
        }
        
        // 排序結果以符合輸出格式 (Start, Char, Length) -> (1/2, 3/4, 5/7)
        Collections.sort(result);
        
        return result;
    }
}
```

---

## 測試程式

### PHP 版本

```php
<?php
use PHPUnit\Framework\TestCase;
use PHPUnit\Framework\Attributes\DataProvider;

require_once dirname(__DIR__) . '/StringSpecification.php';

class StringSpecificationTest extends TestCase
{
    private StringSpecification $analyzer;

    protected function setUp(): void
    {
        $this->analyzer = new StringSpecification();
    }

    /**
     * @dataProvider stringDataProvider
     */
    public function testAnalyze($input, $expected, $criteriaDesc)
    {
        // 2-1) Input values
        $inputValueDisplay = $input === "" ? '"" (空字串)' : $input;

        // 執行程式
        $actual = $this->analyzer->analyze($input);

        // 為了報告顯示，將陣列轉換為字串
        $expectedStr = "(" . implode(',', $expected) . ")";
        $actualStr = "(" . implode(',', $actual) . ")";
        $matchResult = ($expected === $actual) ? "符合" : "不符合";

        // 2) 輸出詳細測試案例報告
        echo "\n－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－\n";
        echo "【 Test Case Analysis 測試案例分析 】\n";
        echo "　2-1) Input values (測試時候需要控制資料的值) : {$inputValueDisplay}\n";
        echo "　2-2) Expected result (正確的結果) : {$expectedStr}\n";
        echo "　2-3) Test program's result (程式執行後的結果) : {$actualStr}\n";
        echo "　2-4) Criteria analysis (測試目標的分析): {$matchResult}，{$criteriaDesc}\n";

        // 4-2) 使用測試工具的指令來比對
        $this->assertEquals($expected, $actual, "Input: {$inputValueDisplay} 失敗，未達預期結果.");
    }

    public static function stringDataProvider(): array
    {
        return [
            // Test Case 1
            [
                '4144W013',
                [1, 3, 5],
                'Starts 1-9 (1), Chars Valid (3), Length 1-8 (5)'
            ],
            // Test Case 2
            [
                'W144W013',
                [2, 3, 5],
                'Starts other (2), Chars Valid (3), Length 1-8 (5)'
            ],
            // Test Case 3
            [
                '4144#013',
                [1, 4, 5],
                'Starts 1-9 (1), Has others (4), Length 1-8 (5)'
            ],
            // Test Case 4
            [
                '',
                [6],
                'Empty string -> 0 chars (6)'
            ],
            // Test Case 5
            [
                '4144W0134144W013',
                [1, 3, 7],
                'Starts 1-9 (1), Chars Valid (3), Length > 8 (7)'
            ],
        ];
    }
}
```

---

## 2) 每個測試案例(test case)依照下列規定格式撰寫

每個測試案例必須包含以下四個部分：

1. **2-1) Input values** (測試時候需要控制資料的值)
2. **2-2) Expected result** (正確的結果)
3. **2-3) Test program's result** (程式執行後的結果)
4. **2-4) Criteria analysis** (測試目標的分析)

### 範例格式

```
2-1) Input values: 4144W013
2-2) Expected result: (1,3,5)
2-3) Test program's result: (1,3,5)
2-4) Criteria analysis: 符合，Starts 1-9 (1), Chars Valid (3), Length 1-8 (5)
```

---

## 3) 詳細說明作業的測試案例

### 測試策略

使用**最少個測試案例**達到測試目標涵蓋率 **100%** (testing criteria coverage 100%)

- **混合測試** (最佳化)：需要 **3 個** 案例
- **獨立測試** (單一變因)：需要 **5 個** 案例。**本測試採用**

### 測試案例列表

| Test Case | Input | Expected Result | 說明 |
|-----------|-------|----------------|------|
| TC1 | `4144W013` | `(1,3,5)` | Starts 1-9 (1), Chars Valid (3), Length 1-8 (5) |
| TC2 | `W144W013` | `(2,3,5)` | Starts other (2), Chars Valid (3), Length 1-8 (5) |
| TC3 | `4144#013` | `(1,4,5)` | Starts 1-9 (1), Has others (4), Length 1-8 (5) |
| TC4 | `""` (空字串) | `(6)` | Empty string -> 0 chars (6) |
| TC5 | `4144W0134144W013` | `(1,3,7)` | Starts 1-9 (1), Chars Valid (3), Length > 8 (7) |

---

## 4) 使用測試工具在每個作業的展示

### 4-1) 使用測試工具測試每個測試案例

### 4-2) 使用測試工具的指令來比對每個測試案例的正確與否

(比對正確的結果與程式執行後的結果)：顯示工具比對結果的報告

---

## 測試執行結果

### PHP 版本執行結果

```bash
PS C:\xampp\htdocs\student-project> vendor\bin\phpunit --coverage-text

Xdebug: [Step Debug] Time-out connecting to debugging client, waited: 200 ms. Tried: localhost:9003
(through xdebug.client_host/xdebug.client_port).

PHPUnit 11.5.44 by Sebastian Bergmann and contributors.

Runtime: PHP 8.2.12 with Xdebug 3.4.7

Configuration: C:\xampp\htdocs\student-project\phpunit.xml
```

#### Test Case 1

```
－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－
【 Test Case Analysis 測試案例分析 】
　2-1) Input values (測試時候需要控制資料的值) : 4144W013
　2-2) Expected result (正確的結果) : (1,3,5)
　2-3) Test program's result (程式執行後的結果) : (1,3,5)
　2-4) Criteria analysis (測試目標的分析): 符合，Starts 1-9 (1), Chars Valid (3), Length 1-8 (5)
.
```

#### Test Case 2

```
－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－
【 Test Case Analysis 測試案例分析 】
　2-1) Input values (測試時候需要控制資料的值) : W144W013
　2-2) Expected result (正確的結果) : (2,3,5)
　2-3) Test program's result (程式執行後的結果) : (2,3,5)
　2-4) Criteria analysis (測試目標的分析): 符合，Starts other (2), Chars Valid (3), Length 1-8 (5)
.
```

#### Test Case 3

```
－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－
【 Test Case Analysis 測試案例分析 】
　2-1) Input values (測試時候需要控制資料的值) : 4144#013
　2-2) Expected result (正確的結果) : (1,4,5)
　2-3) Test program's result (程式執行後的結果) : (1,4,5)
　2-4) Criteria analysis (測試目標的分析): 符合，Starts 1-9 (1), Has others (4), Length 1-8 (5)
.
```

#### Test Case 4

```
－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－
【 Test Case Analysis 測試案例分析 】
　2-1) Input values (測試時候需要控制資料的值) : "" (空字串)
　2-2) Expected result (正確的結果) : (6)
　2-3) Test program's result (程式執行後的結果) : (6)
　2-4) Criteria analysis (測試目標的分析): 符合，Empty string -> 0 chars (6)
.
```

#### Test Case 5

```
－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－
【 Test Case Analysis 測試案例分析 】
　2-1) Input values (測試時候需要控制資料的值) : 4144W0134144W013
　2-2) Expected result (正確的結果) : (1,3,7)
　2-3) Test program's result (程式執行後的結果) : (1,3,7)
　2-4) Criteria analysis (測試目標的分析): 符合，Starts 1-9 (1), Chars Valid (3), Length > 8 (7)
.
```

### 測試結果摘要

```
Tests: 5, Assertions: 5

Code Coverage Report:
2025-11-23 17:36:09

Summary:
Classes: 100.00% (1/1)
Methods: 100.00% (1/1)
Lines: 100.00% (25/25)

StringSpecification
Methods: 100.00% ( 1/ 1) Lines: 100.00% ( 25/ 25)
```

**✅ 測試通過率：100% (5/5)**
**✅ 程式碼覆蓋率：100%**

---

## Java 版本執行結果

### 執行測試

```bash
mvn test -Dtest=StringSpecificationTest
```

### 測試結果

- **Tests run: 11**
- **Failures: 0**
- **Errors: 0**
- **Skipped: 0**

**✅ 測試通過率：100%**

### 詳細測試報告

所有測試案例都包含完整的報告格式，輸出與 PHP 版本相同的格式：

```
－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－
【 Test Case Analysis 測試案例分析 】
　2-1) Input values (測試時候需要控制資料的值) : [輸入值]
　2-2) Expected result (正確的結果) : [預期結果]
　2-3) Test program's result (程式執行後的結果) : [實際結果]
　2-4) Criteria analysis (測試目標的分析): 符合，[條件說明]
```

---

## 等價類別詳細說明

### Starting char (起始字元)

| 類別 | 條件 | 編號 | 範例 |
|------|------|------|------|
| Valid | Starts 1-9 | 1 | `4144W013`, `123ABC` |
| Invalid | Starts other | 2 | `W144W013`, `ABC123`, `0123` |

### Chars (字元組成)

| 類別 | 條件 | 編號 | 範例 |
|------|------|------|------|
| Valid | 全部為 [A-Z0-9] | 3 | `4144W013`, `ABC123` |
| Invalid | 包含其他字元 | 4 | `4144#013`, `ABC-123` |

### Length (字串長度)

| 類別 | 條件 | 編號 | 範例 |
|------|------|------|------|
| Valid | 1-8 chars | 5 | `4144W013` (8字元) |
| Invalid | 0 chars | 6 | `""` (空字串) |
| Invalid | > 8 chars | 7 | `4144W0134144W013` (16字元) |

---

## 總結

### 測試目標達成

- ✅ 清楚列出有效與無效的條件
- ✅ 使用最少個測試案例達到 100% 覆蓋率
- ✅ 每個測試案例包含完整的格式說明
- ✅ 使用測試工具進行自動化測試
- ✅ 程式碼覆蓋率達到 100%

### 測試案例統計

- **總測試案例數：5 個**
- **測試通過率：100%**
- **程式碼覆蓋率：100%**
- **測試策略：獨立測試（單一變因）**

---

## 參考資料

- 軟體正規方法期末報告項目
- Equivalence Partition Testing 等價類別分割測試
- PHPUnit / JUnit 測試框架

