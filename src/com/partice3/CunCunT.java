package com.partice3;

import java.util.Scanner;

/**
 * @author YiXin
 * @create 2022/5/21
 */

public class CunCunT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入路的个数：");
            int n = sc.nextInt();
            if (n==0){
                System.exit(0);
            }
            System.out.println("请输入村庄的个数：");
            int m = sc.nextInt();
            System.out.println("请输入路连接的村庄编号和成本：");
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();           //输入村庄编号
                int y = sc.nextInt();           //村庄编号
                int cost = sc.nextInt();        //所需要的成本
            }
        }
    }

}
