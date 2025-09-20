# 軟體測試專案 - 測試腳本使用說明

## 🎯 專案概覽

本專案是一個完整的軟體測試範例，展示了各種測試覆蓋率技術的實現，包括：

- **Line Coverage** - 行覆蓋率測試
- **Graph Coverage** - 圖覆蓋率測試 (Edge, Edge-Pair, Path Coverage)
- **Stress Testing** - 壓力測試覆蓋率
- **Logical Expressions Coverage** - 邏輯表達式覆蓋率 (Predicate, Clause, Combinatorial)
- **Input Domain Characterization** - 輸入域特徵化測試
- **Mutation Testing** - 變異測試覆蓋率
- **Equivalence Partition Testing** - 等價分割測試
- **Boundary Value Testing** - 邊界值測試

### 📊 當前測試成果

- **總測試數**: 59 個測試案例
- **測試通過率**: 100% ✅
- **指令覆蓋率**: 100% ✅
- **分支覆蓋率**: 99% (107/108 覆蓋)
- **行覆蓋率**: 100% ✅
- **方法覆蓋率**: 100% ✅
- **類別覆蓋率**: 100% ✅

## 📋 腳本概述

本專案提供了兩個測試執行腳本，讓您可以輕鬆執行各種測試和生成報告：

- **`run-tests.sh`** - Linux/macOS 版本 (Bash 腳本)
- **`run-tests.bat`** - Windows 版本 (批次檔)

## 🚀 快速開始

### Linux/macOS 用戶

```bash
# 給腳本添加執行權限 (僅需執行一次)
chmod +x run-tests.sh

# 查看幫助信息
./run-tests.sh help

# 執行所有測試和報告
./run-tests.sh all
```

### Windows 用戶

```cmd
REM 查看幫助信息
run-tests.bat help

REM 執行所有測試和報告
run-tests.bat all
```

## 📖 詳細使用說明

### 可用選項

| 選項 | 說明 | 範例 |
|------|------|------|
| `all` | 執行所有測試並生成所有報告 | `./run-tests.sh all` |
| `test` | 僅執行測試 | `./run-tests.sh test` |
| `coverage` | 執行測試並生成覆蓋率報告 | `./run-tests.sh coverage` |
| `mutation` | 執行變異測試 | `./run-tests.sh mutation` |
| `clean` | 清理建置檔案 | `./run-tests.sh clean` |
| `compile` | 編譯專案 | `./run-tests.sh compile` |
| `line` | 執行 Line Coverage 測試 | `./run-tests.sh line` |
| `graph` | 執行 Graph Coverage 測試 | `./run-tests.sh graph` |
| `stress` | 執行 Stress Testing 測試 | `./run-tests.sh stress` |
| `logical` | 執行 Logical Expressions 測試 | `./run-tests.sh logical` |
| `input` | 執行 Input Domain 測試 | `./run-tests.sh input` |
| `mutation-test` | 執行 Mutation Testing 測試 | `./run-tests.sh mutation-test` |
| `equivalence` | 執行 Equivalence Partition 測試 | `./run-tests.sh equivalence` |
| `boundary` | 執行 Boundary Value 測試 | `./run-tests.sh boundary` |
| `report` | 生成測試報告 | `./run-tests.sh report` |
| `help` | 顯示幫助信息 | `./run-tests.sh help` |

## 🎯 常用工作流程

### 1. 首次使用或完整測試

```bash
# Linux/macOS
./run-tests.sh all

# Windows
run-tests.bat all
```

這會執行以下步驟：
1. 清理專案建置檔案
2. 編譯專案和測試程式碼
3. 執行所有測試
4. 生成覆蓋率報告
5. 執行變異測試
6. 顯示測試統計信息

### 2. 快速測試

```bash
# 僅執行測試
./run-tests.sh test

# 執行測試並生成覆蓋率報告
./run-tests.sh coverage
```

### 3. 特定測試類型

```bash
# 執行 Line Coverage 測試
./run-tests.sh line

# 執行 Graph Coverage 測試
./run-tests.sh graph

# 執行 Boundary Value 測試
./run-tests.sh boundary
```

### 4. 生成報告

```bash
# 生成所有可用報告
./run-tests.sh report
```

## 📊 報告位置

執行測試後，報告會生成在以下位置：

### JaCoCo 覆蓋率報告
- **位置**: `report/jacoco/index.html`
- **內容**: 行覆蓋率、分支覆蓋率、方法覆蓋率等詳細資訊
- **開啟方式**: 在瀏覽器中開啟 HTML 檔案

#### 覆蓋率報告截圖

![JaCoCo 覆蓋率報告 - 套件總覽](image-1.png)

**說明:**
此截圖顯示了 `com.ntou.testing` 套件的 JaCoCo 程式碼覆蓋率報告總覽。主要資訊如下：

- **NumberProcessor**: 指令覆蓋率 100%，分支覆蓋率 100%
- **Calculator**: 指令覆蓋率 100%，分支覆蓋率 97% (有 1 個分支未覆蓋)
- **總計**: 指令覆蓋率 100%，分支覆蓋率 99% (108 個分支中有 1 個未覆蓋)，行覆蓋率 100%，方法覆蓋率 100%，類別覆蓋率 100%

![JaCoCo 覆蓋率報告 - 詳細類別](image-2.png)

**說明:**
此截圖顯示了 `com.ntou.testing` 套件的詳細覆蓋率報告。可以看到：

- **NumberProcessor**: 完全達到 100% 覆蓋率 (指令、分支、行、方法、類別)
- **Calculator**: 指令覆蓋率 100%，但分支覆蓋率為 97%，表示還有一個分支未被測試覆蓋
- 整體專案已達到非常高的覆蓋率水準，僅差最後 1% 即可達到完美的 100% 覆蓋率

### PIT 變異測試報告
- **位置**: `report/pit/[timestamp]/index.html`
- **內容**: 變異測試結果、殺死率統計等
- **開啟方式**: 在瀏覽器中開啟 HTML 檔案

### Maven 測試報告
- **位置**: `report/surefire/`
- **內容**: 測試執行結果、失敗測試詳情等
- **格式**: XML 和 TXT 檔案

## 🔧 故障排除

### 常見問題

1. **權限問題 (Linux/macOS)**
   ```bash
   chmod +x run-tests.sh
   ```

2. **Maven 未安裝**
   - 確保系統已安裝 Maven
   - 檢查 `mvn` 命令是否可用

3. **Java 版本問題**
   - 確保使用 Java 11 或更高版本
   - 檢查 `JAVA_HOME` 環境變數

4. **測試失敗**
   - 檢查控制台輸出中的錯誤信息
   - 查看 `report/surefire/` 中的詳細報告

### 除錯模式

如果需要更詳細的輸出，可以修改腳本中的 Maven 命令：

```bash
# 添加 -X 參數獲取詳細輸出
mvn -X test
```

## 🎨 腳本特色

### Linux/macOS 版本 (`run-tests.sh`)
- ✅ 彩色輸出，易於閱讀
- ✅ 錯誤處理和狀態顯示
- ✅ 自動統計測試結果
- ✅ 智能報告位置檢測

### Windows 版本 (`run-tests.bat`)
- ✅ 相容 Windows 命令提示字元
- ✅ 錯誤處理和狀態顯示
- ✅ 暫停功能，便於查看結果
- ✅ 自動報告位置檢測

## 📝 自訂腳本

您可以根據需要修改腳本：

1. **添加新的測試類型**
2. **修改 Maven 參數**
3. **自訂報告生成邏輯**
4. **添加額外的檢查步驟**

## 🤝 支援

如果您遇到問題或需要幫助：

1. 檢查本說明文件
2. 查看腳本中的錯誤信息
3. 確認 Maven 和 Java 環境設定
4. 檢查專案結構是否完整

---

**注意**: 請確保在執行腳本前，專案目錄結構完整，且所有必要的測試檔案都存在。


