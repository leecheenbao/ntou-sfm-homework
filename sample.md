# 測試腳本使用範例

## 🚀 快速開始

### 1. 基本使用

```bash
# 查看幫助信息
./run-tests.sh help

# 執行所有測試和報告
./run-tests.sh all
```

### 2. 常用命令

```bash
# 僅執行測試
./run-tests.sh test

# 執行測試並生成覆蓋率報告
./run-tests.sh coverage

# 執行變異測試
./run-tests.sh mutation
```

### 3. 特定測試類型

```bash
# Line Coverage 測試
./run-tests.sh line

# Graph Coverage 測試
./run-tests.sh graph

# Stress Testing 測試
./run-tests.sh stress

# Logical Expressions 測試
./run-tests.sh logical

# Input Domain 測試
./run-tests.sh input

# Mutation Testing 測試
./run-tests.sh mutation-test

# Equivalence Partition 測試
./run-tests.sh equivalence

# Boundary Value 測試
./run-tests.sh boundary
```

## 📊 測試結果範例

### 成功執行範例

```
========================================
    軟體測試工具執行腳本
    Software Testing Script
========================================

正在執行: 執行所有測試
命令: mvn test

[INFO] Tests run: 59, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS

✓ 執行所有測試 執行成功

測試統計信息:
測試檔案數量:        9
總測試數: 59
失敗測試: 0
錯誤測試: 0
跳過測試: 0
測試狀態: 全部通過 ✓

報告位置:
JaCoCo 覆蓋率報告: target/site/jacoco/index.html
PIT 變異測試報告: target/pit-reports/[timestamp]/index.html
Maven 測試報告: target/surefire-reports/
```

### Line Coverage 測試範例

```
正在執行: 執行 Line Coverage 測試
命令: mvn test -Dtest=*LineCoverageTest

[INFO] Running com.ntou.testing.CalculatorLineCoverageTest
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0
[INFO] Running com.ntou.testing.NumberProcessorLineCoverageTest
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0
[INFO] Results:
[INFO] Tests run: 12, Failures: 0, Errors: 0, Skipped: 0

✓ 執行 Line Coverage 測試 執行成功
```

## 🎯 實際使用場景

### 場景 1: 開發過程中快速測試

```bash
# 開發時快速檢查
./run-tests.sh test

# 檢查特定功能
./run-tests.sh boundary
```

### 場景 2: 提交前完整檢查

```bash
# 完整測試和報告
./run-tests.sh all
```

### 場景 3: 覆蓋率分析

```bash
# 生成覆蓋率報告
./run-tests.sh coverage

# 查看報告
open target/site/jacoco/index.html
```

### 場景 4: 測試品質評估

```bash
# 執行變異測試
./run-tests.sh mutation

# 查看變異測試報告
open target/pit-reports/*/index.html
```

## 🔧 Windows 用戶

Windows 用戶可以使用批次檔：

```cmd
REM 查看幫助
run-tests.bat help

REM 執行所有測試
run-tests.bat all

REM 執行特定測試
run-tests.bat line
```

## 📈 測試統計說明

### 測試數量統計

| 測試類型 | 測試數量 | 說明 |
|----------|----------|------|
| Line Coverage | 12 | 行覆蓋測試 |
| Graph Coverage | 9 | 圖覆蓋測試 |
| Stress Testing | 7 | 壓力測試 |
| Logical Expressions | 7 | 邏輯表達式測試 |
| Input Domain | 6 | 輸入域測試 |
| Mutation Testing | 5 | 變異測試 |
| Equivalence Partition | 6 | 等價分割測試 |
| Boundary Value | 7 | 邊界值測試 |
| **總計** | **59** | **所有測試案例** |

### 覆蓋率目標

- **行覆蓋率**: 100%
- **分支覆蓋率**: 100%
- **方法覆蓋率**: 100%
- **類別覆蓋率**: 100%

## 🎉 成功指標

### 測試通過指標

```
✓ 所有測試通過 (59/59)
✓ 無失敗測試 (0 failures)
✓ 無錯誤測試 (0 errors)
✓ 無跳過測試 (0 skipped)
```

### 報告生成指標

```
✓ JaCoCo 覆蓋率報告已生成
✓ PIT 變異測試報告已生成
✓ Maven 測試報告已生成
```

## 🚨 故障排除

### 常見問題

1. **權限問題**
   ```bash
   chmod +x run-tests.sh
   ```

2. **Maven 未找到**
   ```bash
   # 檢查 Maven 安裝
   mvn --version
   ```

3. **Java 版本問題**
   ```bash
   # 檢查 Java 版本
   java --version
   ```

### 除錯模式

```bash
# 詳細輸出
mvn -X test

# 檢查編譯錯誤
mvn compile
```

---

**提示**: 建議在開發過程中定期執行 `./run-tests.sh test` 來確保程式碼品質！
