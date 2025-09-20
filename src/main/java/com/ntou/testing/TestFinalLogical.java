package com.ntou.testing;

public class TestFinalLogical {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        NumberProcessor processor = new NumberProcessor();
        
        // 測試失敗的案例
        System.out.println("complexLogic(false, false, true) = " + 
                          calculator.complexLogic(false, false, true));
        System.out.println("complexBooleanLogic(true, false, false, true) = " + 
                          processor.complexBooleanLogic(true, false, false, true));
    }
}
