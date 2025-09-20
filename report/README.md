# 測試報告目錄

本目錄包含所有測試相關的報告文件。

## 📁 目錄結構

```
report/
├── jacoco/          # JaCoCo 覆蓋率報告
│   ├── index.html   # 主要覆蓋率報告 (在瀏覽器中開啟)
│   ├── jacoco.csv   # CSV 格式覆蓋率數據
│   ├── jacoco.xml   # XML 格式覆蓋率數據
│   └── com.ntou.testing/  # 詳細的類別覆蓋率報告
├── pit/             # PIT 變異測試報告
│   └── [timestamp]/ # 時間戳記目錄
│       └── index.html  # 變異測試報告 (在瀏覽器中開啟)
└── surefire/        # Maven Surefire 測試報告
    ├── *.txt        # 文字格式測試結果
    └── *.xml        # XML 格式測試結果
```

## 📊 報告說明

### JaCoCo 覆蓋率報告
- **位置**: `report/jacoco/index.html`
- **內容**: 程式碼覆蓋率統計
- **指標**: 指令覆蓋率、分支覆蓋率、行覆蓋率、方法覆蓋率、類別覆蓋率
- **開啟方式**: 在瀏覽器中開啟 `index.html`

### PIT 變異測試報告
- **位置**: `report/pit/[timestamp]/index.html`
- **內容**: 變異測試結果和殺死率統計
- **指標**: 變異體生成數量、殺死率、存活變異體
- **開啟方式**: 在瀏覽器中開啟 `index.html`

### Maven Surefire 測試報告
- **位置**: `report/surefire/`
- **內容**: 測試執行結果
- **格式**: TXT 和 XML 格式
- **用途**: 詳細的測試執行日誌和結果

## 🚀 快速查看報告

### 在瀏覽器中開啟報告
```bash
# 開啟覆蓋率報告
open report/jacoco/index.html

# 開啟變異測試報告 (需要先執行變異測試)
open report/pit/*/index.html
```

### 使用測試腳本
```bash
# 執行所有測試並生成報告
./run-tests.sh all

# 僅生成覆蓋率報告
./run-tests.sh coverage

# 僅執行變異測試
./run-tests.sh mutation
```

## 📈 當前覆蓋率狀況

- **指令覆蓋率**: 100% ✅
- **分支覆蓋率**: 99% (107/108 覆蓋)
- **行覆蓋率**: 100% ✅
- **方法覆蓋率**: 100% ✅
- **類別覆蓋率**: 100% ✅

## 🔧 報告生成

報告會在執行以下命令時自動生成：
- `mvn test` - 生成 Surefire 測試報告
- `mvn test jacoco:report` - 生成 JaCoCo 覆蓋率報告
- `mvn test-compile org.pitest:pitest-maven:mutationCoverage` - 生成 PIT 變異測試報告

---

**注意**: 請確保在查看報告前已執行相應的測試命令。
