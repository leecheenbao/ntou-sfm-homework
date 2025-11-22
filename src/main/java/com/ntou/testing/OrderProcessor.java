package com.ntou.testing;

import java.util.Scanner;

/**
 * 點餐系統類別 - 處理主餐、配餐和飲料的選擇與結帳
 * 用於軟體正規方法期末報告項目
 */
public class OrderProcessor {
    
    /**
     * 處理點餐流程
     * 包含主餐、配餐和飲料的選擇，最後顯示訂單摘要和總金額
     */
    public static void processOrder() {
        Scanner scanner = new Scanner(System.in);
        int mainDishChoice = 0;  // 主餐選擇
        int sideDishChoice = 0;   // 配餐選擇
        int drinkChoice = 0;      // 飲料選擇
        double totalPrice = 0.0;  // 總金額
        String orderDetails = ""; // 訂單明細

        // 主餐選擇迴圈
        while (true) {
            label97:
            do {
                // 輸入驗證迴圈：確保輸入為 1-3
                while (mainDishChoice < 1 || mainDishChoice > 3) {
                    System.out.println("\n--- 請選擇主餐 ---");
                    System.out.println("1. 漢堡 (60元)");
                    System.out.println("2. 蛋餅 (40元)");
                    System.out.println("3. 吐司 (50元)");
                    System.out.print("請輸入選項數字 (1-3): ");
                    
                    if (scanner.hasNextInt()) {
                        mainDishChoice = scanner.nextInt();
                        continue label97;
                    }

                    System.out.println("❗ 輸入錯誤，請輸入數字。");
                    scanner.next();
                }

                // 根據選擇計算價格並記錄明細
                if (mainDishChoice == 1) {
                    totalPrice += 60.0;
                    orderDetails = orderDetails + "主餐: 漢堡 (60元)\n";
                } else if (mainDishChoice == 2) {
                    totalPrice += 40.0;
                    orderDetails = orderDetails + "主餐: 蛋餅 (40元)\n";
                } else {
                    totalPrice += 50.0;
                    orderDetails = orderDetails + "主餐: 吐司 (50元)\n";
                }

                // 配餐選擇迴圈
                while (true) {
                    label81:
                    do {
                        // 輸入驗證迴圈：確保輸入為 1-4
                        while (sideDishChoice < 1 || sideDishChoice > 4) {
                            System.out.println("\n--- 請選擇配餐 ---");
                            System.out.println("1. 薯條 (30元)");
                            System.out.println("2. 蘿蔔糕 (30元)");
                            System.out.println("3. 雞塊 (40元)");
                            System.out.println("4. 薯餅 (25元)");
                            System.out.print("請輸入選項數字 (1-4): ");
                            
                            if (scanner.hasNextInt()) {
                                sideDishChoice = scanner.nextInt();
                                continue label81;
                            }

                            System.out.println("❗ 輸入錯誤，請輸入數字。");
                            scanner.next();
                        }

                        // 根據選擇計算價格並記錄明細
                        switch (sideDishChoice) {
                            case 1:
                                totalPrice += 30.0;
                                orderDetails = orderDetails + "配餐: 薯條 (30元)\n";
                                break;
                            case 2:
                                totalPrice += 30.0;
                                orderDetails = orderDetails + "配餐: 蘿蔔糕 (30元)\n";
                                break;
                            case 3:
                                totalPrice += 40.0;
                                orderDetails = orderDetails + "配餐: 雞塊 (40元)\n";
                                break;
                            case 4:
                                totalPrice += 25.0;
                                orderDetails = orderDetails + "配餐: 薯餅 (25元)\n";
                        }

                        // 飲料選擇迴圈
                        while (true) {
                            label65:
                            do {
                                // 輸入驗證迴圈：確保輸入為 1-4
                                while (drinkChoice < 1 || drinkChoice > 4) {
                                    System.out.println("\n--- 請選擇飲料 ---");
                                    System.out.println("1. 紅茶 (25元)");
                                    System.out.println("2. 柳橙汁 (35元)");
                                    System.out.println("3. 豆漿 (30元)");
                                    System.out.println("4. 咖啡 (45元)");
                                    System.out.print("請輸入選項數字 (1-4): ");
                                    
                                    if (scanner.hasNextInt()) {
                                        drinkChoice = scanner.nextInt();
                                        continue label65;
                                    }

                                    System.out.println("❗ 輸入錯誤，請輸入數字。");
                                    scanner.next();
                                }

                                // 根據選擇計算價格並記錄明細
                                if (drinkChoice == 1) {
                                    totalPrice += 25.0;
                                    orderDetails = orderDetails + "飲料: 紅茶 (25元)\n";
                                } else if (drinkChoice == 2) {
                                    totalPrice += 35.0;
                                    orderDetails = orderDetails + "飲料: 柳橙汁 (35元)\n";
                                } else if (drinkChoice == 3) {
                                    totalPrice += 30.0;
                                    orderDetails = orderDetails + "飲料: 豆漿 (30元)\n";
                                } else {
                                    totalPrice += 45.0;
                                    orderDetails = orderDetails + "飲料: 咖啡 (45元)\n";
                                }

                                // 顯示訂單摘要並結束程式
                                System.out.println("\n==================================");
                                System.out.println("✅ 您的點餐已完成！");
                                System.out.println("--- 餐點內容 ---");
                                System.out.print(orderDetails);
                                System.out.println("--- 總金額 ---");
                                System.out.printf("💰 總共需要支付: %.1f 元\n", totalPrice);
                                System.out.println("==================================");
                                scanner.close();
                                return;
                            } while (drinkChoice >= 1 && drinkChoice <= 4);

                            System.out.println("❗ 輸入無效，請輸入 1 到 4 之間的數字。");
                        }
                    } while (sideDishChoice >= 1 && sideDishChoice <= 4);

                    System.out.println("❗ 輸入無效，請輸入 1 到 4 之間的數字。");
                }
            } while (mainDishChoice >= 1 && mainDishChoice <= 3);

            System.out.println("❗ 輸入無效，請輸入 1 到 3 之間的數字。");
        }
    }

    /**
     * 主程式進入點
     * 
     * @param args 命令列參數
     */
    public static void main(String[] args) {
        processOrder();
    }
}

