package com.dp2;

import java.util.Scanner;
public class CountTowerYouhua {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[][] dp = new int[len][len];
        int[][] arr = new int[len][len];
        int[] path = new int[len];
        //自顶向下输入
        for(int i=0;i<len;i++) {
            for(int j=0;j<=i;j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        //dp数组赋值
        for(int i=0;i<len;i++) {
            dp[len-1][i] = arr[len-1][i];
        }
        //求最大路径和and最大路径
        for(int i=len-2;i>=0;i--) {
            for(int j=0;j<=i;j++) {
                dp[i][j] = arr[i][j]+Math.max(dp[i+1][j],dp[i+1][j+1]);
            }
            //求当前层的路径
            int max = 0;
            for(int j=0;j<=i+1;j++) {	//0到len-1层 所以是i+1
                if(dp[i+1][j]>max) {	//当前层的最大值就是需要走的路径
                    max=dp[i+1][j];
                    path[i+1]=j;	//记录路径坐标
                }
            }
        }
        System.out.println("最大路径和："+dp[0][0]);
        /*for(int i=0;i<len;i++) {	//输出路径的坐标
        	System.out.println(i+" "+path[i]);
        }*/
        //输出路径上的值
        for(int i=0;i<len;i++) {
            System.out.println("第"+i+"层:"+arr[i][path[i]]);
        }
    }
}

