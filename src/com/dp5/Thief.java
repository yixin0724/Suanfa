package com.dp5;

/**
 * 题⽬四：打家劫舍
 * 描述
 * 你是⼀个专业的⼩偷，计划偷窃沿街的房屋。每间房内都藏有⼀定的现⾦，影响你偷窃的唯⼀制约
 * 因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同⼀晚上被⼩偷闯⼊，系统会⾃
 * 动报警。
 * 输⼊⼀个数字代表数组的⻓度，⼀个代表每个房屋存放⾦额的⾮负整数数组nums，分两⾏输⼊。计算
 * 你 不触动警报装置的情况下 ，⼀夜之内能够偷窃到的最⾼⾦额。
 * 解析
 * 动态规划问题，分析出递推⽅程dp，当我们来到第n个房屋nums[n]时，可以选择偷或不偷，有两种
 * 选择
 * 1. 偷：也会偷第n-2个房屋 dp[i - 2] + nums[i]
 * 2. 不偷：上次偷的就是第n-1个房屋 dp[i - 1]
 * 求这两种情况的最⼤值即可 -> dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
 * 时间复杂度O(n)
 * 空间复杂度O(n)
 */

import java.util.Scanner;

public class Thief {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入有多少个屋子：");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("输入每个屋子的金钱数目：");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        // 当只有⼀个房屋时，我们需要单独处理
        if (nums.length == 1) {
            System.out.println(nums[0]);
        } else {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            }
            System.out.println("所偷得最大金钱数目为：" + dp[nums.length - 1]);
        }
    }
}
