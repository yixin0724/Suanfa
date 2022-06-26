package com.fenzhi2;
/**
 * 题⽬五：数组中的逆序对
 * 描述
 *    在数组中的两个数字，如果前⾯⼀个数字⼤于后⾯的数字，则这两个数字组成⼀个逆序对。输⼊⼀
 * 个数组，求出这个数组中的逆序对的总数。
 * 解析
 *    有两种解法，⼀种时间复杂度较⾼O(n^2)，这种解法 只能通过⼀部分的测试数据，我们需要把时间
 * 复杂度优化至O(nlogN)，采⽤分治法。
 * 直接思路双重循环可以解决，此时只是部分正确
 */

import java.util.Scanner;

public class InversionPair {
    static int[] tmp, nums;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入数组的长度：");
        int n = scan.nextInt();
        nums = new int[n];
        tmp = new int[n];
        System.out.println("请为数组赋值：");
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        System.out.println("所得到的逆序对的个数为：" + mergeSort(0, nums.length - 1));
    }

    static int mergeSort(int l, int r) {
        // 终⽌条件
        if (l >= r) {
            return 0;
        }
        // 递归划分
        int m = (l + r) / 2;
        int res = mergeSort(l, m) + mergeSort(m + 1, r);
        // 合并阶段
        int i = l, j = m + 1;
        for (int k = l; k <= r; k++) {
            tmp[k] = nums[k];
        }
        for (int k = l; k <= r; k++) {
            if (i > m) {
                nums[k] = tmp[j++];
            } else if (j > r) {
                nums[k] = tmp[i++];
            } else if (tmp[i] <= tmp[j]) {
                nums[k] = tmp[i++];
            } else {
                nums[k] = tmp[j++];
                // 4 5 6 合并 2 3 4
                res += m - i + 1; // 统计逆序对
            }
        }
        return res;
    }
}

/**
 * 这是两个for循环解答，时间复杂度为O(n平方)
 */

//class Main {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = scan.nextInt();
//        }
//        int res = 0;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] > nums[j]) {
//                    res++;
//                }
//            }
//        }
//        System.out.println(res);
//    }
//}
