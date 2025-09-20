#!/bin/bash

# 軟體測試工具執行腳本
# 用於執行各種測試和生成報告

set -e  # 遇到錯誤時停止執行

# 顏色定義
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
PURPLE='\033[0;35m'
CYAN='\033[0;36m'
NC='\033[0m' # No Color

# 顯示標題
show_title() {
    echo -e "${CYAN}========================================${NC}"
    echo -e "${CYAN}    軟體測試工具執行腳本${NC}"
    echo -e "${CYAN}    Software Testing Script${NC}"
    echo -e "${CYAN}========================================${NC}"
    echo
}

# 顯示幫助信息
show_help() {
    echo -e "${YELLOW}使用方法:${NC}"
    echo "  $0 [選項]"
    echo
    echo -e "${YELLOW}選項:${NC}"
    echo "  all          執行所有測試並生成所有報告"
    echo "  test         僅執行測試"
    echo "  coverage     執行測試並生成覆蓋率報告"
    echo "  mutation     執行變異測試"
    echo "  clean        清理建置檔案"
    echo "  compile      編譯專案"
    echo "  line         執行 Line Coverage 測試"
    echo "  graph        執行 Graph Coverage 測試"
    echo "  stress       執行 Stress Testing 測試"
    echo "  logical      執行 Logical Expressions 測試"
    echo "  input        執行 Input Domain 測試"
    echo "  mutation-test 執行 Mutation Testing 測試"
    echo "  equivalence  執行 Equivalence Partition 測試"
    echo "  boundary     執行 Boundary Value 測試"
    echo "  report       生成測試報告"
    echo "  help         顯示此幫助信息"
    echo
    echo -e "${YELLOW}範例:${NC}"
    echo "  $0 all        # 執行所有測試和報告"
    echo "  $0 coverage   # 執行測試並生成覆蓋率報告"
    echo "  $0 line       # 僅執行 Line Coverage 測試"
    echo
}

# 執行命令並顯示結果
run_command() {
    local cmd="$1"
    local description="$2"
    
    echo -e "${BLUE}正在執行: ${description}${NC}"
    echo -e "${PURPLE}命令: ${cmd}${NC}"
    echo
    
    if eval "$cmd"; then
        echo -e "${GREEN}✓ ${description} 執行成功${NC}"
    else
        echo -e "${RED}✗ ${description} 執行失敗${NC}"
        return 1
    fi
    echo
}

# 清理建置檔案
clean_project() {
    run_command "mvn clean" "清理專案建置檔案"
}

# 編譯專案
compile_project() {
    run_command "mvn compile test-compile" "編譯專案和測試程式碼"
}

# 執行所有測試
run_all_tests() {
    run_command "mvn test" "執行所有測試"
}

# 執行測試並生成覆蓋率報告
run_coverage() {
    run_command "mvn test jacoco:report" "執行測試並生成覆蓋率報告"
}

# 執行變異測試
run_mutation_testing() {
    run_command "mvn test-compile org.pitest:pitest-maven:mutationCoverage" "執行變異測試"
}

# 執行特定測試類別
run_specific_test() {
    local test_class="$1"
    local description="$2"
    run_command "mvn test -Dtest=${test_class}" "執行 ${description} 測試"
}

# 生成測試報告
generate_reports() {
    echo -e "${BLUE}正在生成測試報告...${NC}"
    echo
    
    # 生成 JaCoCo 報告
    if [ -f "report/jacoco/index.html" ]; then
        echo -e "${GREEN}✓ JaCoCo 覆蓋率報告已生成${NC}"
        echo -e "   位置: ${CYAN}report/jacoco/index.html${NC}"
    else
        echo -e "${YELLOW}⚠ JaCoCo 報告不存在，請先執行覆蓋率測試${NC}"
    fi
    
    # 檢查 PIT 報告
    if [ -d "report/pit" ]; then
        local latest_report=$(find report/pit -name "index.html" -type f | head -1)
        if [ -n "$latest_report" ]; then
            echo -e "${GREEN}✓ PIT 變異測試報告已生成${NC}"
            echo -e "   位置: ${CYAN}${latest_report}${NC}"
        fi
    else
        echo -e "${YELLOW}⚠ PIT 報告不存在，請先執行變異測試${NC}"
    fi
    
    # 檢查 Surefire 報告
    if [ -d "report/surefire" ]; then
        echo -e "${GREEN}✓ Maven Surefire 測試報告已生成${NC}"
        echo -e "   位置: ${CYAN}report/surefire/${NC}"
    fi
    
    echo
}

# 顯示測試統計
show_test_stats() {
    echo -e "${BLUE}測試統計信息:${NC}"
    
    if [ -d "report/surefire" ]; then
        local test_files=$(find report/surefire -name "*.xml" -type f | wc -l)
        echo -e "測試檔案數量: ${GREEN}${test_files}${NC}"
        
        # 提取測試統計信息
        local total_tests=0
        local failed_tests=0
        local errors=0
        local skipped=0
        
        for file in report/surefire/*.xml; do
            if [ -f "$file" ]; then
                local tests=$(grep -o 'tests="[0-9]*"' "$file" | grep -o '[0-9]*' | head -1)
                local failures=$(grep -o 'failures="[0-9]*"' "$file" | grep -o '[0-9]*' | head -1)
                local err=$(grep -o 'errors="[0-9]*"' "$file" | grep -o '[0-9]*' | head -1)
                local skip=$(grep -o 'skipped="[0-9]*"' "$file" | grep -o '[0-9]*' | head -1)
                
                if [ -n "$tests" ]; then total_tests=$((total_tests + tests)); fi
                if [ -n "$failures" ]; then failed_tests=$((failed_tests + failures)); fi
                if [ -n "$err" ]; then errors=$((errors + err)); fi
                if [ -n "$skip" ]; then skipped=$((skipped + skip)); fi
            fi
        done
        
        echo -e "總測試數: ${GREEN}${total_tests}${NC}"
        echo -e "失敗測試: ${RED}${failed_tests}${NC}"
        echo -e "錯誤測試: ${RED}${errors}${NC}"
        echo -e "跳過測試: ${YELLOW}${skipped}${NC}"
        
        if [ $failed_tests -eq 0 ] && [ $errors -eq 0 ]; then
            echo -e "測試狀態: ${GREEN}全部通過 ✓${NC}"
        else
            echo -e "測試狀態: ${RED}有失敗或錯誤 ✗${NC}"
        fi
    else
        echo -e "測試報告不存在，請先執行測試"
    fi
    
    echo
}

# 顯示報告位置
show_report_locations() {
    echo -e "${BLUE}報告位置:${NC}"
    echo -e "JaCoCo 覆蓋率報告: ${CYAN}report/jacoco/index.html${NC}"
    echo -e "Maven 測試報告: ${CYAN}report/surefire/${NC}"
    echo
}

# 主函數
main() {
    show_title
    
    case "${1:-help}" in
        "all")
            clean_project
            compile_project
            run_all_tests
            run_coverage
            run_mutation_testing
            show_test_stats
            show_report_locations
            ;;
        "test")
            run_all_tests
            show_test_stats
            ;;
        "coverage")
            run_coverage
            show_test_stats
            show_report_locations
            ;;
        "mutation")
            run_mutation_testing
            show_report_locations
            ;;
        "clean")
            clean_project
            ;;
        "compile")
            compile_project
            ;;
        "line")
            run_specific_test "*LineCoverageTest" "Line Coverage"
            ;;
        "graph")
            run_specific_test "GraphCoverageTest" "Graph Coverage"
            ;;
        "stress")
            run_specific_test "StressTestingCoverageTest" "Stress Testing"
            ;;
        "logical")
            run_specific_test "LogicalExpressionsCoverageTest" "Logical Expressions"
            ;;
        "input")
            run_specific_test "InputDomainCharacterizationTest" "Input Domain"
            ;;
        "mutation-test")
            run_specific_test "MutationTestingCoverageTest" "Mutation Testing"
            ;;
        "equivalence")
            run_specific_test "EquivalencePartitionTestingTest" "Equivalence Partition"
            ;;
        "boundary")
            run_specific_test "BoundaryValueTestingTest" "Boundary Value"
            ;;
        "report")
            generate_reports
            show_test_stats
            show_report_locations
            ;;
        "help"|"-h"|"--help")
            show_help
            ;;
        *)
            echo -e "${RED}錯誤: 未知的選項 '${1}'${NC}"
            echo
            show_help
            exit 1
            ;;
    esac
}

# 執行主函數
main "$@"
