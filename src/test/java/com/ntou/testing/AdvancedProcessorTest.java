package com.ntou.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdvancedProcessorTest {

    private AdvancedProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new AdvancedProcessor();
    }

    @Test
    void testProcessArrayContainsNegativeOne() {
       /**
        * Test case 1: Array contains special value -1 (should return -1 immediately)
		* 有效範圍值除input number -1 return -1 ，0 reset 外，加總臨界值以外number    	
		* Input values(測試時候需要控制資料的值) : int[] number {1, 10, -1, 20, 30}、int threshold = 5
		* expected result(正確的結果) : true
		* test program's result(程式執行後的結果) : true 
		* criteria analysis(測試目標的分析)
		* line coverage : 16~17、19、23~24、26~30、33、34
        */
    	
        int[] numbers = {1, 10, -1, 20, 30};
        int threshold = 5;
        assertEquals(-1, processor.processArray(numbers, threshold));
    }

    @Test
    void testProcessArrayContainsOtherNegativeNumberResets() {
       /**
    	* Test case 2: Array contains other negative numbers (should reset accumulation)
	    * 有效範圍值除input number -1 return -1 ，0 reset 外，加總臨界值以外number    	
    	* Input values(測試時候需要控制資料的值) : numbers2 = {10, -2, 20, 30}、int threshold = 5
    	* expected result(正確的結果) : true
    	* test program's result(程式執行後的結果) : true 
    	* criteria analysis(測試目標的分析)
		* line coverage : 16~19、23~26、28~34、39  
		**/	
    	
        int[] numbers2 = {10, -2, 20, 30};
        assertEquals(50, processor.processArray(numbers2, 5)); // 10 reset, then 20+30
    }
    
  @Test
  void testProcessArrayThresholdZero() {
	  /**
	   * Test case 3: Threshold is zero
	   * 有效範圍值除input number -1 return -1 ，0 reset 外，加總臨界值以外number    	
	   * Input values(測試時候需要控制資料的值) : int[] numbers = {-2, -1, 0, 1, 2, 3};、int threshold = 5
	   * expected result(正確的結果) : true
	   * test program's result(程式執行後的結果) : false 
	   * criteria analysis(測試目標的分析)
	   * line coverage : 17~18、25~28、28~34、39
	   **/	
    
      int[] numbers = {-2, -1, 0, 1, 2, 3};
      int threshold = 0;
      assertEquals(-1, processor.processArray(numbers, threshold));
  }
    
    @Test
    void testProcessArrayEmpty() {
    	/**
    	 * Test case 4: Empty array
    	 * 有效範圍值除input number -1 return -1 ，0 reset 外，加總臨界值以外number    	
    	 * Input values(測試時候需要控制資料的值) : int[] numbers = {}、int threshold = 5
    	 * expected result(正確的結果) : true
    	 * test program's result(程式執行後的結果) : true 
    	 * criteria analysis(測試目標的分析)
    	 * line coverage : 16~20 	
    	 **/	
        int[] numbers = {};
        int threshold = 5;
        assertEquals(0, processor.processArray(numbers, threshold));
    }
    
  @Test
  void testProcessArrayAllBelowThreshold() {
	 /**
 	  * Test case 5: All numbers are below or equal to the threshold
	  * 有效範圍值除input number -1 return -1 ，0 reset 外，加總臨界值以外number    	
	  * Input values(測試時候需要控制資料的值) : int[] numbers = {1, 2, 3, 4, 5};、int threshold = 5
	  * expected result(正確的結果) : true
	  * test program's result(程式執行後的結果) : true 
	  * criteria analysis(測試目標的分析)
	  * line coverage : 17~20、24~27、29、32、40	
	  **/ 
	  
	  int[] numbers = {1, 2, 3, 4, 5};
      int threshold = 5;
      assertEquals(0, processor.processArray(numbers, threshold));
  }
    
  @Test
  void testProcessArraySomeAboveThresholdWithinLimit() {
	  /**
	   * Test case 6: Some numbers are above the threshold, within the 3-element limit
	   * 有效範圍值除input number -1 return -1 ，0 reset 外，加總臨界值以外number    	
	   * Input values(測試時候需要控制資料的值) : int[] numbers = {1, 6, 2, 7, 3, 8};、int threshold = 5
	   * expected result(正確的結果) : true
	   * test program's result(程式執行後的結果) : true 
	   * criteria analysis(測試目標的分析)
	   * line coverage : 17~20、24~27、29、32~35	
	   **/ 
	  
      int[] numbers = {1, 6, 2, 7, 3, 8};
      int threshold = 5;
      // Expected: 6 + 7 + 8 = 21
      assertEquals(21, processor.processArray(numbers, threshold));
  }
    
@Test
  void testProcessArraySomeAboveThresholdExceedLimit() {
	 /**
	  * Test case 7: Numbers above the threshold exceed the 3-element limit
	  * 有效範圍值除input number -1 return -1 ，0 reset 外，加總臨界值以外number    	
	  * Input values(測試時候需要控制資料的值) : int[] numbers = {10, 20, 30, 40, 50};、int threshold = 5
	  * expected result(正確的結果) : true
	  * test program's result(程式執行後的結果) : true 
	  *  criteria analysis(測試目標的分析)
	  * line coverage : 16~17、23~24、32~34、39
	  **/ 
      int[] numbers = {10, 20, 30, 40, 50};
      int threshold = 5;
      // Expected: 10 + 20 + 30 = 60 (only first 3 counted)
      assertEquals(60, processor.processArray(numbers, threshold));
  }

@Test
  void testProcessArrayNull() {
	/**
	 * Test case 8: Null array
	 * 有效範圍值除input number -1 return -1 ，0 reset 外，加總臨界值以外number    	
	 * Input values(測試時候需要控制資料的值) : int[] numbers = null;、int threshold = 5
	 * expected result(正確的結果) : true
	 *  test program's result(程式執行後的結果) : true 
	 * criteria analysis(測試目標的分析)
	 * line coverage : 16~17、19~20	
	 **/ 
    int[] numbers = null;
    int threshold = 5;
    assertEquals(0, processor.processArray(numbers, threshold));
  }

}

