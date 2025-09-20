# 軟體測試報告流程圖

## 🏗️ 整體架構流程圖

```mermaid
graph TB
    A[開始] --> B[執行測試腳本]
    B --> C{選擇測試類型}
    
    C -->|all| D[完整測試流程]
    C -->|test| E[基本測試]
    C -->|coverage| F[覆蓋率測試]
    C -->|clean| G[清理建置檔案]
    C -->|compile| H[編譯專案]
    
    D --> I[清理建置檔案]
    I --> J[編譯專案和測試程式碼]
    J --> K[執行所有測試]
    K --> L[生成覆蓋率報告]
    L --> M[執行變異測試]
    M --> N[顯示測試統計]
    
    E --> K
    F --> K
    F --> L
    
    N --> O[測試報告生成]
    O --> P[報告位置顯示]
    P --> Q[結束]
    
    G --> R[清理完成]
    R --> Q
    H --> S[編譯完成]
    S --> Q
```

## 🧪 測試技術流程圖

```mermaid
graph LR
    A[NumberProcessor 類別] --> B[Line Coverage 測試]
    A --> C[Graph Coverage 測試]
    A --> D[Stress Testing 測試]
    A --> E[Logical Expressions 測試]
    A --> F[Input Domain 測試]
    A --> G[Equivalence Partition 測試]
    A --> H[Boundary Value 測試]
    
    B --> I[classifyNumber 方法]
    B --> J[sumArray 方法]
    B --> K[findMax 方法]
    B --> L[complexBooleanLogic 方法]
    B --> M[countPrimes 方法]
    
    C --> N[Edge Coverage]
    C --> O[Edge-Pair Coverage]
    C --> P[Path Coverage]
    
    D --> Q[極值測試]
    D --> R[邊界值測試]
    
    E --> S[Predicate Coverage]
    E --> T[Clause Coverage]
    E --> U[Combinatorial Coverage]
    
    F --> V[Categorization]
    F --> W[Combinatorial]
    
    G --> X[等價類測試]
    H --> Y[邊界值測試]
```

## 📊 報告生成流程圖

```mermaid
graph TD
    A[測試執行完成] --> B[JaCoCo 覆蓋率分析]
    A --> C[Maven Surefire 報告]
    A --> D[PIT 變異測試報告]
    
    B --> E[JaCoCo HTML 報告]
    B --> F[JaCoCo CSV 報告]
    B --> G[JaCoCo XML 報告]
    
    C --> H[Surefire TXT 報告]
    C --> I[Surefire XML 報告]
    
    D --> J[PIT HTML 報告]
    D --> K[PIT XML 報告]
    
    E --> L[report/jacoco/index.html]
    F --> M[report/jacoco/jacoco.csv]
    G --> N[report/jacoco/jacoco.xml]
    
    H --> O[report/surefire/*.txt]
    I --> P[report/surefire/*.xml]
    
    J --> Q[report/pit/[timestamp]/index.html]
    K --> R[report/pit/[timestamp]/pit.xml]
    
    L --> S[瀏覽器開啟報告]
    Q --> S
```

## 🔧 測試腳本執行流程圖

```mermaid
graph TB
    A[./run-tests.sh] --> B{參數選擇}
    
    B -->|all| C[完整流程]
    B -->|test| D[基本測試]
    B -->|coverage| E[覆蓋率測試]
    B -->|clean| F[清理]
    B -->|compile| G[編譯]
    B -->|line| H[Line Coverage]
    B -->|graph| I[Graph Coverage]
    B -->|stress| J[Stress Testing]
    B -->|logical| K[Logical Expressions]
    B -->|input| L[Input Domain]
    B -->|equivalence| M[Equivalence Partition]
    B -->|boundary| N[Boundary Value]
    B -->|report| O[生成報告]
    B -->|help| P[顯示幫助]
    
    C --> Q[mvn clean compile test-compile test jacoco:report]
    D --> R[mvn test]
    E --> S[mvn test jacoco:report]
    F --> T[mvn clean]
    G --> U[mvn compile test-compile]
    H --> V[mvn test -Dtest=NumberProcessorLineCoverageTest]
    I --> W[mvn test -Dtest=GraphCoverageTest]
    J --> X[mvn test -Dtest=StressTestingCoverageTest]
    K --> Y[mvn test -Dtest=LogicalExpressionsCoverageTest]
    L --> Z[mvn test -Dtest=InputDomainCharacterizationTest]
    M --> AA[mvn test -Dtest=EquivalencePartitionTestingTest]
    N --> BB[mvn test -Dtest=BoundaryValueTestingTest]
    O --> CC[檢查並顯示報告位置]
    
    Q --> DD[顯示測試統計]
    R --> DD
    S --> DD
    T --> EE[清理完成]
    U --> FF[編譯完成]
    V --> DD
    W --> DD
    X --> DD
    Y --> DD
    Z --> DD
    AA --> DD
    BB --> DD
    CC --> GG[報告位置資訊]
    
    P --> HH[顯示使用說明]
```

## 📈 測試覆蓋率流程圖

```mermaid
graph LR
    A[測試執行] --> B[JaCoCo 代理收集數據]
    B --> C[執行數據分析]
    C --> D[生成覆蓋率報告]
    
    D --> E[指令覆蓋率 100%]
    D --> F[分支覆蓋率 100%]
    D --> G[行覆蓋率 100%]
    D --> H[方法覆蓋率 100%]
    D --> I[類別覆蓋率 100%]
    
    E --> J[HTML 報告]
    F --> J
    G --> J
    H --> J
    I --> J
    
    J --> K[report/jacoco/index.html]
    K --> L[瀏覽器查看]
```

## 🎯 當前測試方法分布

```mermaid
pie title 測試方法分布 (22個測試案例)
    "Line Coverage" : 5
    "Graph Coverage" : 3
    "Stress Testing" : 3
    "Logical Expressions" : 3
    "Input Domain" : 2
    "Equivalence Partition" : 1
    "Boundary Value" : 1
    "Mutation Testing" : 4
```

## 📋 測試報告目錄結構

```
report/
├── jacoco/                    # JaCoCo 覆蓋率報告
│   ├── index.html            # 主要 HTML 報告入口
│   ├── jacoco.csv            # 覆蓋率數據 CSV 格式
│   ├── jacoco.xml            # 覆蓋率數據 XML 格式
│   └── com.ntou.testing/     # 詳細類別覆蓋率報告
│       ├── NumberProcessor.html
│       └── index.html
├── pit/                       # PIT 變異測試報告
│   └── [timestamp]/          # 帶時間戳記的報告目錄
│       ├── index.html        # 變異測試 HTML 報告
│       └── pit.xml           # 變異測試 XML 報告
└── surefire/                  # Maven Surefire 測試報告
    ├── *.txt                 # 文字格式測試結果
    └── *.xml                 # XML 格式測試結果
```

## 🚀 快速執行指南

### 基本測試流程
1. **執行所有測試**: `./run-tests.sh all`
2. **查看報告**: `./run-tests.sh report`
3. **開啟 HTML 報告**: `open report/jacoco/index.html`

### 特定測試類型
- **Line Coverage**: `./run-tests.sh line`
- **Graph Coverage**: `./run-tests.sh graph`
- **Stress Testing**: `./run-tests.sh stress`
- **Logical Expressions**: `./run-tests.sh logical`

### 報告查看
- **JaCoCo 報告**: `report/jacoco/index.html`
- **PIT 報告**: `report/pit/[timestamp]/index.html`
- **Surefire 報告**: `report/surefire/`

---

**注意**: 此流程圖展示了當前專案的完整測試架構，包含 8 種測試技術和 22 個測試案例，達到 100% 的完美覆蓋率。
