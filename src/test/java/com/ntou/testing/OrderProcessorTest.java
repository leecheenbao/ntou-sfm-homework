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
 * 包含 Categorization (分類測試) 和 Combinatorial (組合測試)
 * 
 * 測試類別：
 * - 主餐：3個類別 (1=漢堡, 2=蛋餅, 3=吐司)
 * - 配餐：4個類別 (1=薯條, 2=蘿蔔糕, 3=雞塊, 4=薯餅)
 * - 飲料：4個類別 (1=紅茶, 2=柳橙汁, 3=豆漿, 4=咖啡)
 * 
 * 組合總數：3 × 4 × 4 = 48 種
 */
public class OrderProcessorTest {

    private ByteArrayOutputStream outputStream;
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @BeforeEach
    void setUp() {
        // 每次測試前重設輸出流
        outputStream = new ByteArrayOutputStream();
        // 重定向 System.out 來捕獲輸出
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        // 恢復原始的 System.out 和 System.in
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    // ==================== Categorization (分類測試) ====================
    // 目標：每個類別都要測試過

    @Test
    @DisplayName("Categorization - 測試主餐類別 1: 漢堡")
    void testCategorization_MainDish_1_Burger() {
        // 測試主餐類別 1 (漢堡)
        String input = "1\n1\n1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        OrderProcessor.processOrder();

        String output = outputStream.toString();
        assertThat(output).contains("主餐: 漢堡 (60元)");
    }

    @Test
    @DisplayName("Categorization - 測試主餐類別 2: 蛋餅")
    void testCategorization_MainDish_2_EggPancake() {
        // 測試主餐類別 2 (蛋餅)
        String input = "2\n1\n1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        OrderProcessor.processOrder();

        String output = outputStream.toString();
        assertThat(output).contains("主餐: 蛋餅 (40元)");
    }

    @Test
    @DisplayName("Categorization - 測試主餐類別 3: 吐司")
    void testCategorization_MainDish_3_Toast() {
        // 測試主餐類別 3 (吐司)
        String input = "3\n1\n1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        OrderProcessor.processOrder();

        String output = outputStream.toString();
        assertThat(output).contains("主餐: 吐司 (50元)");
    }

    @Test
    @DisplayName("Categorization - 測試配餐類別 1: 薯條")
    void testCategorization_SideDish_1_Fries() {
        // 測試配餐類別 1 (薯條)
        String input = "1\n1\n1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        OrderProcessor.processOrder();

        String output = outputStream.toString();
        assertThat(output).contains("配餐: 薯條 (30元)");
    }

    @Test
    @DisplayName("Categorization - 測試配餐類別 2: 蘿蔔糕")
    void testCategorization_SideDish_2_RadishCake() {
        // 測試配餐類別 2 (蘿蔔糕)
        String input = "1\n2\n1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        OrderProcessor.processOrder();

        String output = outputStream.toString();
        assertThat(output).contains("配餐: 蘿蔔糕 (30元)");
    }

    @Test
    @DisplayName("Categorization - 測試配餐類別 3: 雞塊")
    void testCategorization_SideDish_3_ChickenNuggets() {
        // 測試配餐類別 3 (雞塊)
        String input = "1\n3\n1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        OrderProcessor.processOrder();

        String output = outputStream.toString();
        assertThat(output).contains("配餐: 雞塊 (40元)");
    }

    @Test
    @DisplayName("Categorization - 測試配餐類別 4: 薯餅")
    void testCategorization_SideDish_4_HashBrown() {
        // 測試配餐類別 4 (薯餅)
        String input = "1\n4\n1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        OrderProcessor.processOrder();

        String output = outputStream.toString();
        assertThat(output).contains("配餐: 薯餅 (25元)");
    }

    @Test
    @DisplayName("Categorization - 測試飲料類別 1: 紅茶")
    void testCategorization_Drink_1_BlackTea() {
        // 測試飲料類別 1 (紅茶)
        String input = "1\n1\n1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        OrderProcessor.processOrder();

        String output = outputStream.toString();
        assertThat(output).contains("飲料: 紅茶 (25元)");
    }

    @Test
    @DisplayName("Categorization - 測試飲料類別 2: 柳橙汁")
    void testCategorization_Drink_2_OrangeJuice() {
        // 測試飲料類別 2 (柳橙汁)
        String input = "1\n1\n2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        OrderProcessor.processOrder();

        String output = outputStream.toString();
        assertThat(output).contains("飲料: 柳橙汁 (35元)");
    }

    @Test
    @DisplayName("Categorization - 測試飲料類別 3: 豆漿")
    void testCategorization_Drink_3_SoyMilk() {
        // 測試飲料類別 3 (豆漿)
        String input = "1\n1\n3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        OrderProcessor.processOrder();

        String output = outputStream.toString();
        assertThat(output).contains("飲料: 豆漿 (30元)");
    }

    @Test
    @DisplayName("Categorization - 測試飲料類別 4: 咖啡")
    void testCategorization_Drink_4_Coffee() {
        // 測試飲料類別 4 (咖啡)
        String input = "1\n1\n4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        OrderProcessor.processOrder();

        String output = outputStream.toString();
        assertThat(output).contains("飲料: 咖啡 (45元)");
    }

    // ==================== Combinatorial (組合測試) ====================
    // 目標：各種類別的全部排列組合都要測試過
    // 組合總數：3 (主餐) × 4 (配餐) × 4 (飲料) = 48 種

    // 輔助方法：生成所有組合並執行測試
    private void testCombinatorial(int mainDish, int sideDish, int drink, 
                                    String expectedMainDish, double expectedMainPrice,
                                    String expectedSideDish, double expectedSidePrice,
                                    String expectedDrink, double expectedDrinkPrice) {
        String input = mainDish + "\n" + sideDish + "\n" + drink + "\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        OrderProcessor.processOrder();

        String output = outputStream.toString();
        double expectedTotal = expectedMainPrice + expectedSidePrice + expectedDrinkPrice;
        
        assertThat(output).contains("主餐: " + expectedMainDish);
        assertThat(output).contains("配餐: " + expectedSideDish);
        assertThat(output).contains("飲料: " + expectedDrink);
        assertThat(output).contains(String.format("總共需要支付: %.1f 元", expectedTotal));
        assertThat(output).contains("✅ 您的點餐已完成！");
    }

    // 主餐類別 1 (漢堡, 60元) × 配餐類別 1-4 × 飲料類別 1-4 = 16 種組合
    @Test
    @DisplayName("Combinatorial TC1: 漢堡 + 薯條 + 紅茶 = 115元")
    void testCombinatorial_TC01_Burger_Fries_BlackTea() {
        testCombinatorial(1, 1, 1, "漢堡 (60元)", 60.0, "薯條 (30元)", 30.0, "紅茶 (25元)", 25.0);
    }

    @Test
    @DisplayName("Combinatorial TC2: 漢堡 + 薯條 + 柳橙汁 = 125元")
    void testCombinatorial_TC02_Burger_Fries_OrangeJuice() {
        testCombinatorial(1, 1, 2, "漢堡 (60元)", 60.0, "薯條 (30元)", 30.0, "柳橙汁 (35元)", 35.0);
    }

    @Test
    @DisplayName("Combinatorial TC3: 漢堡 + 薯條 + 豆漿 = 120元")
    void testCombinatorial_TC03_Burger_Fries_SoyMilk() {
        testCombinatorial(1, 1, 3, "漢堡 (60元)", 60.0, "薯條 (30元)", 30.0, "豆漿 (30元)", 30.0);
    }

    @Test
    @DisplayName("Combinatorial TC4: 漢堡 + 薯條 + 咖啡 = 135元")
    void testCombinatorial_TC04_Burger_Fries_Coffee() {
        testCombinatorial(1, 1, 4, "漢堡 (60元)", 60.0, "薯條 (30元)", 30.0, "咖啡 (45元)", 45.0);
    }

    @Test
    @DisplayName("Combinatorial TC5: 漢堡 + 蘿蔔糕 + 紅茶 = 115元")
    void testCombinatorial_TC05_Burger_RadishCake_BlackTea() {
        testCombinatorial(1, 2, 1, "漢堡 (60元)", 60.0, "蘿蔔糕 (30元)", 30.0, "紅茶 (25元)", 25.0);
    }

    @Test
    @DisplayName("Combinatorial TC6: 漢堡 + 蘿蔔糕 + 柳橙汁 = 125元")
    void testCombinatorial_TC06_Burger_RadishCake_OrangeJuice() {
        testCombinatorial(1, 2, 2, "漢堡 (60元)", 60.0, "蘿蔔糕 (30元)", 30.0, "柳橙汁 (35元)", 35.0);
    }

    @Test
    @DisplayName("Combinatorial TC7: 漢堡 + 蘿蔔糕 + 豆漿 = 120元")
    void testCombinatorial_TC07_Burger_RadishCake_SoyMilk() {
        testCombinatorial(1, 2, 3, "漢堡 (60元)", 60.0, "蘿蔔糕 (30元)", 30.0, "豆漿 (30元)", 30.0);
    }

    @Test
    @DisplayName("Combinatorial TC8: 漢堡 + 蘿蔔糕 + 咖啡 = 135元")
    void testCombinatorial_TC08_Burger_RadishCake_Coffee() {
        testCombinatorial(1, 2, 4, "漢堡 (60元)", 60.0, "蘿蔔糕 (30元)", 30.0, "咖啡 (45元)", 45.0);
    }

    @Test
    @DisplayName("Combinatorial TC9: 漢堡 + 雞塊 + 紅茶 = 125元")
    void testCombinatorial_TC09_Burger_ChickenNuggets_BlackTea() {
        testCombinatorial(1, 3, 1, "漢堡 (60元)", 60.0, "雞塊 (40元)", 40.0, "紅茶 (25元)", 25.0);
    }

    @Test
    @DisplayName("Combinatorial TC10: 漢堡 + 雞塊 + 柳橙汁 = 135元")
    void testCombinatorial_TC10_Burger_ChickenNuggets_OrangeJuice() {
        testCombinatorial(1, 3, 2, "漢堡 (60元)", 60.0, "雞塊 (40元)", 40.0, "柳橙汁 (35元)", 35.0);
    }

    @Test
    @DisplayName("Combinatorial TC11: 漢堡 + 雞塊 + 豆漿 = 130元")
    void testCombinatorial_TC11_Burger_ChickenNuggets_SoyMilk() {
        testCombinatorial(1, 3, 3, "漢堡 (60元)", 60.0, "雞塊 (40元)", 40.0, "豆漿 (30元)", 30.0);
    }

    @Test
    @DisplayName("Combinatorial TC12: 漢堡 + 雞塊 + 咖啡 = 145元")
    void testCombinatorial_TC12_Burger_ChickenNuggets_Coffee() {
        testCombinatorial(1, 3, 4, "漢堡 (60元)", 60.0, "雞塊 (40元)", 40.0, "咖啡 (45元)", 45.0);
    }

    @Test
    @DisplayName("Combinatorial TC13: 漢堡 + 薯餅 + 紅茶 = 110元")
    void testCombinatorial_TC13_Burger_HashBrown_BlackTea() {
        testCombinatorial(1, 4, 1, "漢堡 (60元)", 60.0, "薯餅 (25元)", 25.0, "紅茶 (25元)", 25.0);
    }

    @Test
    @DisplayName("Combinatorial TC14: 漢堡 + 薯餅 + 柳橙汁 = 120元")
    void testCombinatorial_TC14_Burger_HashBrown_OrangeJuice() {
        testCombinatorial(1, 4, 2, "漢堡 (60元)", 60.0, "薯餅 (25元)", 25.0, "柳橙汁 (35元)", 35.0);
    }

    @Test
    @DisplayName("Combinatorial TC15: 漢堡 + 薯餅 + 豆漿 = 115元")
    void testCombinatorial_TC15_Burger_HashBrown_SoyMilk() {
        testCombinatorial(1, 4, 3, "漢堡 (60元)", 60.0, "薯餅 (25元)", 25.0, "豆漿 (30元)", 30.0);
    }

    @Test
    @DisplayName("Combinatorial TC16: 漢堡 + 薯餅 + 咖啡 = 130元")
    void testCombinatorial_TC16_Burger_HashBrown_Coffee() {
        testCombinatorial(1, 4, 4, "漢堡 (60元)", 60.0, "薯餅 (25元)", 25.0, "咖啡 (45元)", 45.0);
    }

    // 主餐類別 2 (蛋餅, 40元) × 配餐類別 1-4 × 飲料類別 1-4 = 16 種組合
    @Test
    @DisplayName("Combinatorial TC17: 蛋餅 + 薯條 + 紅茶 = 95元")
    void testCombinatorial_TC17_EggPancake_Fries_BlackTea() {
        testCombinatorial(2, 1, 1, "蛋餅 (40元)", 40.0, "薯條 (30元)", 30.0, "紅茶 (25元)", 25.0);
    }

    @Test
    @DisplayName("Combinatorial TC18: 蛋餅 + 薯條 + 柳橙汁 = 105元")
    void testCombinatorial_TC18_EggPancake_Fries_OrangeJuice() {
        testCombinatorial(2, 1, 2, "蛋餅 (40元)", 40.0, "薯條 (30元)", 30.0, "柳橙汁 (35元)", 35.0);
    }

    @Test
    @DisplayName("Combinatorial TC19: 蛋餅 + 薯條 + 豆漿 = 100元")
    void testCombinatorial_TC19_EggPancake_Fries_SoyMilk() {
        testCombinatorial(2, 1, 3, "蛋餅 (40元)", 40.0, "薯條 (30元)", 30.0, "豆漿 (30元)", 30.0);
    }

    @Test
    @DisplayName("Combinatorial TC20: 蛋餅 + 薯條 + 咖啡 = 115元")
    void testCombinatorial_TC20_EggPancake_Fries_Coffee() {
        testCombinatorial(2, 1, 4, "蛋餅 (40元)", 40.0, "薯條 (30元)", 30.0, "咖啡 (45元)", 45.0);
    }

    @Test
    @DisplayName("Combinatorial TC21: 蛋餅 + 蘿蔔糕 + 紅茶 = 95元")
    void testCombinatorial_TC21_EggPancake_RadishCake_BlackTea() {
        testCombinatorial(2, 2, 1, "蛋餅 (40元)", 40.0, "蘿蔔糕 (30元)", 30.0, "紅茶 (25元)", 25.0);
    }

    @Test
    @DisplayName("Combinatorial TC22: 蛋餅 + 蘿蔔糕 + 柳橙汁 = 105元")
    void testCombinatorial_TC22_EggPancake_RadishCake_OrangeJuice() {
        testCombinatorial(2, 2, 2, "蛋餅 (40元)", 40.0, "蘿蔔糕 (30元)", 30.0, "柳橙汁 (35元)", 35.0);
    }

    @Test
    @DisplayName("Combinatorial TC23: 蛋餅 + 蘿蔔糕 + 豆漿 = 100元")
    void testCombinatorial_TC23_EggPancake_RadishCake_SoyMilk() {
        testCombinatorial(2, 2, 3, "蛋餅 (40元)", 40.0, "蘿蔔糕 (30元)", 30.0, "豆漿 (30元)", 30.0);
    }

    @Test
    @DisplayName("Combinatorial TC24: 蛋餅 + 蘿蔔糕 + 咖啡 = 115元")
    void testCombinatorial_TC24_EggPancake_RadishCake_Coffee() {
        testCombinatorial(2, 2, 4, "蛋餅 (40元)", 40.0, "蘿蔔糕 (30元)", 30.0, "咖啡 (45元)", 45.0);
    }

    @Test
    @DisplayName("Combinatorial TC25: 蛋餅 + 雞塊 + 紅茶 = 105元")
    void testCombinatorial_TC25_EggPancake_ChickenNuggets_BlackTea() {
        testCombinatorial(2, 3, 1, "蛋餅 (40元)", 40.0, "雞塊 (40元)", 40.0, "紅茶 (25元)", 25.0);
    }

    @Test
    @DisplayName("Combinatorial TC26: 蛋餅 + 雞塊 + 柳橙汁 = 115元")
    void testCombinatorial_TC26_EggPancake_ChickenNuggets_OrangeJuice() {
        testCombinatorial(2, 3, 2, "蛋餅 (40元)", 40.0, "雞塊 (40元)", 40.0, "柳橙汁 (35元)", 35.0);
    }

    @Test
    @DisplayName("Combinatorial TC27: 蛋餅 + 雞塊 + 豆漿 = 110元")
    void testCombinatorial_TC27_EggPancake_ChickenNuggets_SoyMilk() {
        testCombinatorial(2, 3, 3, "蛋餅 (40元)", 40.0, "雞塊 (40元)", 40.0, "豆漿 (30元)", 30.0);
    }

    @Test
    @DisplayName("Combinatorial TC28: 蛋餅 + 雞塊 + 咖啡 = 125元")
    void testCombinatorial_TC28_EggPancake_ChickenNuggets_Coffee() {
        testCombinatorial(2, 3, 4, "蛋餅 (40元)", 40.0, "雞塊 (40元)", 40.0, "咖啡 (45元)", 45.0);
    }

    @Test
    @DisplayName("Combinatorial TC29: 蛋餅 + 薯餅 + 紅茶 = 90元")
    void testCombinatorial_TC29_EggPancake_HashBrown_BlackTea() {
        testCombinatorial(2, 4, 1, "蛋餅 (40元)", 40.0, "薯餅 (25元)", 25.0, "紅茶 (25元)", 25.0);
    }

    @Test
    @DisplayName("Combinatorial TC30: 蛋餅 + 薯餅 + 柳橙汁 = 100元")
    void testCombinatorial_TC30_EggPancake_HashBrown_OrangeJuice() {
        testCombinatorial(2, 4, 2, "蛋餅 (40元)", 40.0, "薯餅 (25元)", 25.0, "柳橙汁 (35元)", 35.0);
    }

    @Test
    @DisplayName("Combinatorial TC31: 蛋餅 + 薯餅 + 豆漿 = 95元")
    void testCombinatorial_TC31_EggPancake_HashBrown_SoyMilk() {
        testCombinatorial(2, 4, 3, "蛋餅 (40元)", 40.0, "薯餅 (25元)", 25.0, "豆漿 (30元)", 30.0);
    }

    @Test
    @DisplayName("Combinatorial TC32: 蛋餅 + 薯餅 + 咖啡 = 110元")
    void testCombinatorial_TC32_EggPancake_HashBrown_Coffee() {
        testCombinatorial(2, 4, 4, "蛋餅 (40元)", 40.0, "薯餅 (25元)", 25.0, "咖啡 (45元)", 45.0);
    }

    // 主餐類別 3 (吐司, 50元) × 配餐類別 1-4 × 飲料類別 1-4 = 16 種組合
    @Test
    @DisplayName("Combinatorial TC33: 吐司 + 薯條 + 紅茶 = 105元")
    void testCombinatorial_TC33_Toast_Fries_BlackTea() {
        testCombinatorial(3, 1, 1, "吐司 (50元)", 50.0, "薯條 (30元)", 30.0, "紅茶 (25元)", 25.0);
    }

    @Test
    @DisplayName("Combinatorial TC34: 吐司 + 薯條 + 柳橙汁 = 115元")
    void testCombinatorial_TC34_Toast_Fries_OrangeJuice() {
        testCombinatorial(3, 1, 2, "吐司 (50元)", 50.0, "薯條 (30元)", 30.0, "柳橙汁 (35元)", 35.0);
    }

    @Test
    @DisplayName("Combinatorial TC35: 吐司 + 薯條 + 豆漿 = 110元")
    void testCombinatorial_TC35_Toast_Fries_SoyMilk() {
        testCombinatorial(3, 1, 3, "吐司 (50元)", 50.0, "薯條 (30元)", 30.0, "豆漿 (30元)", 30.0);
    }

    @Test
    @DisplayName("Combinatorial TC36: 吐司 + 薯條 + 咖啡 = 125元")
    void testCombinatorial_TC36_Toast_Fries_Coffee() {
        testCombinatorial(3, 1, 4, "吐司 (50元)", 50.0, "薯條 (30元)", 30.0, "咖啡 (45元)", 45.0);
    }

    @Test
    @DisplayName("Combinatorial TC37: 吐司 + 蘿蔔糕 + 紅茶 = 105元")
    void testCombinatorial_TC37_Toast_RadishCake_BlackTea() {
        testCombinatorial(3, 2, 1, "吐司 (50元)", 50.0, "蘿蔔糕 (30元)", 30.0, "紅茶 (25元)", 25.0);
    }

    @Test
    @DisplayName("Combinatorial TC38: 吐司 + 蘿蔔糕 + 柳橙汁 = 115元")
    void testCombinatorial_TC38_Toast_RadishCake_OrangeJuice() {
        testCombinatorial(3, 2, 2, "吐司 (50元)", 50.0, "蘿蔔糕 (30元)", 30.0, "柳橙汁 (35元)", 35.0);
    }

    @Test
    @DisplayName("Combinatorial TC39: 吐司 + 蘿蔔糕 + 豆漿 = 110元")
    void testCombinatorial_TC39_Toast_RadishCake_SoyMilk() {
        testCombinatorial(3, 2, 3, "吐司 (50元)", 50.0, "蘿蔔糕 (30元)", 30.0, "豆漿 (30元)", 30.0);
    }

    @Test
    @DisplayName("Combinatorial TC40: 吐司 + 蘿蔔糕 + 咖啡 = 125元")
    void testCombinatorial_TC40_Toast_RadishCake_Coffee() {
        testCombinatorial(3, 2, 4, "吐司 (50元)", 50.0, "蘿蔔糕 (30元)", 30.0, "咖啡 (45元)", 45.0);
    }

    @Test
    @DisplayName("Combinatorial TC41: 吐司 + 雞塊 + 紅茶 = 115元")
    void testCombinatorial_TC41_Toast_ChickenNuggets_BlackTea() {
        testCombinatorial(3, 3, 1, "吐司 (50元)", 50.0, "雞塊 (40元)", 40.0, "紅茶 (25元)", 25.0);
    }

    @Test
    @DisplayName("Combinatorial TC42: 吐司 + 雞塊 + 柳橙汁 = 125元")
    void testCombinatorial_TC42_Toast_ChickenNuggets_OrangeJuice() {
        testCombinatorial(3, 3, 2, "吐司 (50元)", 50.0, "雞塊 (40元)", 40.0, "柳橙汁 (35元)", 35.0);
    }

    @Test
    @DisplayName("Combinatorial TC43: 吐司 + 雞塊 + 豆漿 = 120元")
    void testCombinatorial_TC43_Toast_ChickenNuggets_SoyMilk() {
        testCombinatorial(3, 3, 3, "吐司 (50元)", 50.0, "雞塊 (40元)", 40.0, "豆漿 (30元)", 30.0);
    }

    @Test
    @DisplayName("Combinatorial TC44: 吐司 + 雞塊 + 咖啡 = 135元")
    void testCombinatorial_TC44_Toast_ChickenNuggets_Coffee() {
        testCombinatorial(3, 3, 4, "吐司 (50元)", 50.0, "雞塊 (40元)", 40.0, "咖啡 (45元)", 45.0);
    }

    @Test
    @DisplayName("Combinatorial TC45: 吐司 + 薯餅 + 紅茶 = 100元")
    void testCombinatorial_TC45_Toast_HashBrown_BlackTea() {
        testCombinatorial(3, 4, 1, "吐司 (50元)", 50.0, "薯餅 (25元)", 25.0, "紅茶 (25元)", 25.0);
    }

    @Test
    @DisplayName("Combinatorial TC46: 吐司 + 薯餅 + 柳橙汁 = 110元")
    void testCombinatorial_TC46_Toast_HashBrown_OrangeJuice() {
        testCombinatorial(3, 4, 2, "吐司 (50元)", 50.0, "薯餅 (25元)", 25.0, "柳橙汁 (35元)", 35.0);
    }

    @Test
    @DisplayName("Combinatorial TC47: 吐司 + 薯餅 + 豆漿 = 105元")
    void testCombinatorial_TC47_Toast_HashBrown_SoyMilk() {
        testCombinatorial(3, 4, 3, "吐司 (50元)", 50.0, "薯餅 (25元)", 25.0, "豆漿 (30元)", 30.0);
    }

    @Test
    @DisplayName("Combinatorial TC48: 吐司 + 薯餅 + 咖啡 = 120元")
    void testCombinatorial_TC48_Toast_HashBrown_Coffee() {
        testCombinatorial(3, 4, 4, "吐司 (50元)", 50.0, "薯餅 (25元)", 25.0, "咖啡 (45元)", 45.0);
    }
}
