package com.Partice1;

import java.util.Scanner;

public class SelectMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组的长度：");
        int length = sc.nextInt();
        int[] arr = new int[length];
        System.out.println("请依次为数组赋值：");
        for (int i=0;i<length;i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("请输入你要选择第几个最小的数：");
        int k = sc.nextInt();
        System.out.println("你要查找的数为：" + selectMin(arr,k));
    }

    public static int selectMin(int[] arr,int k){
        int flag=0;
        int min =0;
        int index = 0;
        while (flag != k){                              //循环k次，找第k个最小的
            min =999;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j]<min){                        //判断，把最小的存到min里面
                    min=arr[j];
                    index=j;                            //用index来记录索引，表示哪个元素是最小的
                }
            }
            arr[index]=9999;            //每次找到最小的如果不是要他的话把他赋值为9999，方便后面继续找最小
            flag++;                     //用于记录要找第几个最小的
        }
        return min;                        //将第k个最小的返回
    }
}
