package com.ntou.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * OrderProcessor 測試類別
 * 測試點餐系統的各種情境和選擇組合
 */
public class OrderProcessorTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    void setUp() {
        // 重定向 System.out 來捕獲輸出
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        // 恢復原始的 System.out 和 System.in
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    @DisplayName("測試案例 1: 完整點餐流程 - 漢堡、薯條、紅茶")
    void testProcessOrder_CompleteOrder_Burger_Fries_BlackTea() {
        // 準備測試輸入：主餐=1(漢堡), 配餐=1(薯條), 飲料=1(紅茶)
        String input = "1\n1\n1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // 執行測試
        OrderProcessor.processOrder();

        // 驗證輸出包含預期的內容
        String output = outputStream.toString();
        assertThat(output).contains("主餐: 漢堡 (60元)");
        assertThat(output).contains("配餐: 薯條 (30元)");
        assertThat(output).contains("飲料: 紅茶 (25元)");
        assertThat(output).contains("總共需要支付: 115.0 元");
        assertThat(output).contains("✅ 您的點餐已完成！");
    }

    @Test
    @DisplayName("測試案例 2: 完整點餐流程 - 蛋餅、蘿蔔糕、柳橙汁")
    void testProcessOrder_CompleteOrder_EggPancake_RadishCake_OrangeJuice() {
        // 準備測試輸入：主餐=2(蛋餅), 配餐=2(蘿蔔糕), 飲料=2(柳橙汁)
        String input = "2\n2\n2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // 執行測試
        OrderProcessor.processOrder();

        // 驗證輸出
        String output = outputStream.toString();
        assertThat(output).contains("主餐: 蛋餅 (40元)");
        assertThat(output).contains("配餐: 蘿蔔糕 (30元)");
        assertThat(output).contains("飲料: 柳橙汁 (35元)");
        assertThat(output).contains("總共需要支付: 105.0 元");
    }

    @Test
    @DisplayName("測試案例 3: 完整點餐流程 - 吐司、雞塊、豆漿")
    void testProcessOrder_CompleteOrder_Toast_ChickenNuggets_SoyMilk() {
        // 準備測試輸入：主餐=3(吐司), 配餐=3(雞塊), 飲料=3(豆漿)
        String input = "3\n3\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // 執行測試
        OrderProcessor.processOrder();

        // 驗證輸出
        String output = outputStream.toString();
        assertThat(output).contains("主餐: 吐司 (50元)");
        assertThat(output).contains("配餐: 雞塊 (40元)");
        assertThat(output).contains("飲料: 豆漿 (30元)");
        assertThat(output).contains("總共需要支付: 120.0 元");
    }

    @Test
    @DisplayName("測試案例 4: 完整點餐流程 - 漢堡、薯餅、咖啡")
    void testProcessOrder_CompleteOrder_Burger_HashBrown_Coffee() {
        // 準備測試輸入：主餐=1(漢堡), 配餐=4(薯餅), 飲料=4(咖啡)
        String input = "1\n4\n4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // 執行測試
        OrderProcessor.processOrder();

        // 驗證輸出
        String output = outputStream.toString();
        assertThat(output).contains("主餐: 漢堡 (60元)");
        assertThat(output).contains("配餐: 薯餅 (25元)");
        assertThat(output).contains("飲料: 咖啡 (45元)");
        assertThat(output).contains("總共需要支付: 130.0 元");
    }

    @Test
    @DisplayName("測試案例 5: 測試錯誤輸入處理 - 非數字輸入後正確輸入")
    void testProcessOrder_InvalidInput_NonNumericThenValid() {
        // 準備測試輸入：非數字輸入，然後正確的主餐、配餐、飲料
        String input = "abc\n1\nxyz\n2\n123\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // 執行測試
        OrderProcessor.processOrder();

        // 驗證輸出包含錯誤訊息和最終正確結果
        String output = outputStream.toString();
        assertThat(output).contains("❗ 輸入錯誤，請輸入數字。");
        assertThat(output).contains("主餐: 漢堡 (60元)");
        assertThat(output).contains("配餐: 蘿蔔糕 (30元)");
        assertThat(output).contains("飲料: 豆漿 (30元)");
        assertThat(output).contains("總共需要支付: 120.0 元");
    }

    @Test
    @DisplayName("測試案例 6: 測試邊界值 - 最小有效值")
    void testProcessOrder_BoundaryValues_Minimum() {
        // 準備測試輸入：最小有效值 (1, 1, 1)
        String input = "1\n1\n1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // 執行測試
        OrderProcessor.processOrder();

        // 驗證輸出
        String output = outputStream.toString();
        assertThat(output).contains("總共需要支付: 115.0 元");
    }

    @Test
    @DisplayName("測試案例 7: 測試邊界值 - 最大有效值")
    void testProcessOrder_BoundaryValues_Maximum() {
        // 準備測試輸入：最大有效值 (3, 4, 4)
        String input = "3\n4\n4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // 執行測試
        OrderProcessor.processOrder();

        // 驗證輸出
        String output = outputStream.toString();
        assertThat(output).contains("主餐: 吐司 (50元)");
        assertThat(output).contains("配餐: 薯餅 (25元)");
        assertThat(output).contains("飲料: 咖啡 (45元)");
        assertThat(output).contains("總共需要支付: 120.0 元");
    }

    @Test
    @DisplayName("測試案例 8: 測試價格計算 - 最貴組合")
    void testProcessOrder_PriceCalculation_MostExpensive() {
        // 準備測試輸入：最貴組合 (漢堡=60, 雞塊=40, 咖啡=45)
        String input = "1\n3\n4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // 執行測試
        OrderProcessor.processOrder();

        // 驗證價格計算正確
        String output = outputStream.toString();
        assertThat(output).contains("總共需要支付: 145.0 元");
    }

    @Test
    @DisplayName("測試案例 9: 測試價格計算 - 最便宜組合")
    void testProcessOrder_PriceCalculation_Cheapest() {
        // 準備測試輸入：最便宜組合 (蛋餅=40, 薯餅=25, 紅茶=25)
        String input = "2\n4\n1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // 執行測試
        OrderProcessor.processOrder();

        // 驗證價格計算正確
        String output = outputStream.toString();
        assertThat(output).contains("總共需要支付: 90.0 元");
    }

    @Test
    @DisplayName("測試案例 10: 測試所有菜單選項都有顯示")
    void testProcessOrder_MenuDisplay_AllOptions() {
        // 準備測試輸入
        String input = "1\n1\n1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // 執行測試
        OrderProcessor.processOrder();

        // 驗證所有菜單選項都有顯示
        String output = outputStream.toString();
        // 主餐選項
        assertThat(output).contains("1. 漢堡 (60元)");
        assertThat(output).contains("2. 蛋餅 (40元)");
        assertThat(output).contains("3. 吐司 (50元)");
        // 配餐選項
        assertThat(output).contains("1. 薯條 (30元)");
        assertThat(output).contains("2. 蘿蔔糕 (30元)");
        assertThat(output).contains("3. 雞塊 (40元)");
        assertThat(output).contains("4. 薯餅 (25元)");
        // 飲料選項
        assertThat(output).contains("1. 紅茶 (25元)");
        assertThat(output).contains("2. 柳橙汁 (35元)");
        assertThat(output).contains("3. 豆漿 (30元)");
        assertThat(output).contains("4. 咖啡 (45元)");
    }
}

