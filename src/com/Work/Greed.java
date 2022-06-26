package com.Work;
/**
 * @author YiXin
 * @create 2022/5/23  12:46
 * 贪心法
 */
import java.util.*;
//思路：从头开始遍历求和，假设遍历到G(k)时，假设G(k-1)小于0 ，不对G(k)做改动，假设G(k-1)大于0，则更新G(k)的值为G(k)+G(k-1)
//上面的操作和动态规划类似，假设G(k-1)小于0,遍舍弃k前面的数，从k开始计数。

public class Greed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("你要输入几个数呢：");
        int n = sc.nextInt();
        int[] arr =new int[n];
        System.out.println("请依次为数组赋值：");
        for(int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println("最大子序列和为：" + solution(arr));
    }

    public static int solution(int[] nums) {
        if (nums == null || nums.length == 0) {			//当数组为空的时候退出
            return 0;
        }
        int pre = nums[0];								//初始化pre
        for (int i = 1; i <nums.length ; i++) {			//进行1到长度减一次循环
            if(pre>0){
                nums[i] = pre = pre+nums[i];			//当pre大于0的时候将pre赋值为pre+nums[i]
            }else {
                pre = nums[i];							//如果不大于0则还是原来的
            }
        }
        int max = Arrays.stream(nums).max().getAsInt();		//将最大子序列和存入max
        return max;
    }
}



