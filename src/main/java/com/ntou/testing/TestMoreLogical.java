package com.ntou.testing;

public class TestMoreLogical {
    public static void main(String[] args) {
        NumberProcessor processor = new NumberProcessor();
        
        // 測試失敗的案例
        System.out.println("complexBooleanLogic(true, false, true, false) = " + 
                          processor.complexBooleanLogic(true, false, true, false));
        System.out.println("complexBooleanLogic(false, true, false, true) = " + 
                          processor.complexBooleanLogic(false, true, false, true));
    }
}
