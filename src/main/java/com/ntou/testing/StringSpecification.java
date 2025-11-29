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
 * 
 * 用於軟體正規方法期末報告項目 - Equivalence Partition Testing
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

