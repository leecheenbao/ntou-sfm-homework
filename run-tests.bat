@echo off
setlocal enabledelayedexpansion

REM 軟體測試工具執行腳本 (Windows 版本)
REM 用於執行各種測試和生成報告

title 軟體測試工具執行腳本

REM 顯示標題
echo ========================================
echo     軟體測試工具執行腳本
echo     Software Testing Script
echo ========================================
echo.

REM 檢查參數
if "%1"=="" goto :show_help
if "%1"=="help" goto :show_help
if "%1"=="-h" goto :show_help
if "%1"=="--help" goto :show_help

REM 執行對應的選項
if "%1"=="all" goto :run_all
if "%1"=="test" goto :run_tests
if "%1"=="coverage" goto :run_coverage
if "%1"=="mutation" goto :run_mutation
if "%1"=="clean" goto :clean_project
if "%1"=="compile" goto :compile_project
if "%1"=="line" goto :run_line_tests
if "%1"=="graph" goto :run_graph_tests
if "%1"=="stress" goto :run_stress_tests
if "%1"=="logical" goto :run_logical_tests
if "%1"=="input" goto :run_input_tests
if "%1"=="mutation-test" goto :run_mutation_tests
if "%1"=="equivalence" goto :run_equivalence_tests
if "%1"=="boundary" goto :run_boundary_tests
if "%1"=="report" goto :show_reports

echo 錯誤: 未知的選項 '%1'
echo.
goto :show_help

:show_help
echo 使用方法:
echo   %~nx0 [選項]
echo.
echo 選項:
echo   all          執行所有測試並生成所有報告
echo   test         僅執行測試
echo   coverage     執行測試並生成覆蓋率報告
echo   mutation     執行變異測試
echo   clean        清理建置檔案
echo   compile      編譯專案
echo   line         執行 Line Coverage 測試
echo   graph        執行 Graph Coverage 測試
echo   stress       執行 Stress Testing 測試
echo   logical      執行 Logical Expressions 測試
echo   input        執行 Input Domain 測試
echo   mutation-test 執行 Mutation Testing 測試
echo   equivalence  執行 Equivalence Partition 測試
echo   boundary     執行 Boundary Value 測試
echo   report       生成測試報告
echo   help         顯示此幫助信息
echo.
echo 範例:
echo   %~nx0 all        # 執行所有測試和報告
echo   %~nx0 coverage   # 執行測試並生成覆蓋率報告
echo   %~nx0 line       # 僅執行 Line Coverage 測試
echo.
pause
exit /b 0

:run_all
echo 正在執行: 清理專案建置檔案
mvn clean
if !errorlevel! neq 0 (
    echo ✗ 清理專案失敗
    pause
    exit /b 1
)
echo ✓ 清理專案成功
echo.

echo 正在執行: 編譯專案和測試程式碼
mvn compile test-compile
if !errorlevel! neq 0 (
    echo ✗ 編譯專案失敗
    pause
    exit /b 1
)
echo ✓ 編譯專案成功
echo.

echo 正在執行: 執行所有測試
mvn test
if !errorlevel! neq 0 (
    echo ✗ 執行測試失敗
    pause
    exit /b 1
)
echo ✓ 執行測試成功
echo.

echo 正在執行: 執行測試並生成覆蓋率報告
mvn test jacoco:report
if !errorlevel! neq 0 (
    echo ✗ 生成覆蓋率報告失敗
    pause
    exit /b 1
)
echo ✓ 生成覆蓋率報告成功
echo.

echo 正在執行: 執行變異測試
mvn test-compile org.pitest:pitest-maven:mutationCoverage
if !errorlevel! neq 0 (
    echo ✗ 執行變異測試失敗
    pause
    exit /b 1
)
echo ✓ 執行變異測試成功
echo.

goto :show_test_stats

:run_tests
echo 正在執行: 執行所有測試
mvn test
if !errorlevel! neq 0 (
    echo ✗ 執行測試失敗
    pause
    exit /b 1
)
echo ✓ 執行測試成功
echo.
goto :show_test_stats

:run_coverage
echo 正在執行: 執行測試並生成覆蓋率報告
mvn test jacoco:report
if !errorlevel! neq 0 (
    echo ✗ 生成覆蓋率報告失敗
    pause
    exit /b 1
)
echo ✓ 生成覆蓋率報告成功
echo.
goto :show_test_stats

:run_mutation
echo 正在執行: 執行變異測試
mvn test-compile org.pitest:pitest-maven:mutationCoverage
if !errorlevel! neq 0 (
    echo ✗ 執行變異測試失敗
    pause
    exit /b 1
)
echo ✓ 執行變異測試成功
echo.
goto :show_report_locations

:clean_project
echo 正在執行: 清理專案建置檔案
mvn clean
if !errorlevel! neq 0 (
    echo ✗ 清理專案失敗
    pause
    exit /b 1
)
echo ✓ 清理專案成功
echo.
goto :end

:compile_project
echo 正在執行: 編譯專案和測試程式碼
mvn compile test-compile
if !errorlevel! neq 0 (
    echo ✗ 編譯專案失敗
    pause
    exit /b 1
)
echo ✓ 編譯專案成功
echo.
goto :end

:run_line_tests
echo 正在執行: 執行 Line Coverage 測試
mvn test -Dtest=*LineCoverageTest
if !errorlevel! neq 0 (
    echo ✗ 執行 Line Coverage 測試失敗
    pause
    exit /b 1
)
echo ✓ 執行 Line Coverage 測試成功
echo.
goto :end

:run_graph_tests
echo 正在執行: 執行 Graph Coverage 測試
mvn test -Dtest=GraphCoverageTest
if !errorlevel! neq 0 (
    echo ✗ 執行 Graph Coverage 測試失敗
    pause
    exit /b 1
)
echo ✓ 執行 Graph Coverage 測試成功
echo.
goto :end

:run_stress_tests
echo 正在執行: 執行 Stress Testing 測試
mvn test -Dtest=StressTestingCoverageTest
if !errorlevel! neq 0 (
    echo ✗ 執行 Stress Testing 測試失敗
    pause
    exit /b 1
)
echo ✓ 執行 Stress Testing 測試成功
echo.
goto :end

:run_logical_tests
echo 正在執行: 執行 Logical Expressions 測試
mvn test -Dtest=LogicalExpressionsCoverageTest
if !errorlevel! neq 0 (
    echo ✗ 執行 Logical Expressions 測試失敗
    pause
    exit /b 1
)
echo ✓ 執行 Logical Expressions 測試成功
echo.
goto :end

:run_input_tests
echo 正在執行: 執行 Input Domain 測試
mvn test -Dtest=InputDomainCharacterizationTest
if !errorlevel! neq 0 (
    echo ✗ 執行 Input Domain 測試失敗
    pause
    exit /b 1
)
echo ✓ 執行 Input Domain 測試成功
echo.
goto :end

:run_mutation_tests
echo 正在執行: 執行 Mutation Testing 測試
mvn test -Dtest=MutationTestingCoverageTest
if !errorlevel! neq 0 (
    echo ✗ 執行 Mutation Testing 測試失敗
    pause
    exit /b 1
)
echo ✓ 執行 Mutation Testing 測試成功
echo.
goto :end

:run_equivalence_tests
echo 正在執行: 執行 Equivalence Partition 測試
mvn test -Dtest=EquivalencePartitionTestingTest
if !errorlevel! neq 0 (
    echo ✗ 執行 Equivalence Partition 測試失敗
    pause
    exit /b 1
)
echo ✓ 執行 Equivalence Partition 測試成功
echo.
goto :end

:run_boundary_tests
echo 正在執行: 執行 Boundary Value 測試
mvn test -Dtest=BoundaryValueTestingTest
if !errorlevel! neq 0 (
    echo ✗ 執行 Boundary Value 測試失敗
    pause
    exit /b 1
)
echo ✓ 執行 Boundary Value 測試成功
echo.
goto :end

:show_reports
echo 正在生成測試報告...
echo.

if exist "report\jacoco\index.html" (
    echo ✓ JaCoCo 覆蓋率報告已生成
    echo    位置: report\jacoco\index.html
) else (
    echo ⚠ JaCoCo 報告不存在，請先執行覆蓋率測試
)

if exist "report\pit" (
    echo ✓ PIT 變異測試報告已生成
    echo    位置: report\pit\[timestamp]\index.html
) else (
    echo ⚠ PIT 報告不存在，請先執行變異測試
)

if exist "report\surefire" (
    echo ✓ Maven Surefire 測試報告已生成
    echo    位置: report\surefire\
) else (
    echo ⚠ Surefire 報告不存在，請先執行測試
)

echo.
goto :show_report_locations

:show_test_stats
echo 測試統計信息:
echo.

if exist "target\surefire-reports" (
    set /a test_files=0
    for %%f in (target\surefire-reports\*.xml) do set /a test_files+=1
    echo 測試檔案數量: !test_files!
    
    REM 這裡可以添加更詳細的統計信息解析
    echo 詳細統計信息請查看 target\surefire-reports\ 目錄
) else (
    echo 測試報告不存在，請先執行測試
)

echo.
goto :show_report_locations

:show_report_locations
echo 報告位置:
echo JaCoCo 覆蓋率報告: report\jacoco\index.html
echo Maven 測試報告: report\surefire\
echo.

:end
pause
exit /b 0
