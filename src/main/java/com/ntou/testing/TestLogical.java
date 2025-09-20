package com.ntou.testing;

public class TestLogical {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        NumberProcessor processor = new NumberProcessor();
        
        // 測試 complexLogic
        System.out.println("complexLogic(false, true, false) = " + 
                          calculator.complexLogic(false, true, false));
        
        // 測試 complexBooleanLogic
        System.out.println("complexBooleanLogic(false, true, false, true) = " + 
                          processor.complexBooleanLogic(false, true, false, true));
    }
}
