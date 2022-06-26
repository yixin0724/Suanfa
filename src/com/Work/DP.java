package com.Work;

/**
 * @author YiXin
 * @create 2022/5/23  12:46
 * 动态规划法
 */

import java.util.Scanner;

public class DP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("你要输入几个数呢：");
        int n = sc.nextInt();
        int[] arr =new int[n];
        System.out.println("请依次为数组赋值：");
        for(int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println("最大子段和和为：" + maxSubArray(arr));
    }

    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) {					//当长度为0的时候返回0
            return 0;
        }
        int[] dp = new int[len];		//定义一个一维数组，用来存最优解
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if (dp[i - 1] >= 0) {			//当dp数组的和大于0的时候才继续加
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }
        //接下来求最大值
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, dp[i]);		//将最大子序列的数存入res中
        }
        return res;
    }
}


