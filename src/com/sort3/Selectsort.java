package com.sort3;

import java.util.Scanner;

public class Selectsort {
    public static void main(String[] args) {
        Selectsort sls = new Selectsort();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组的长度：");
        int length = sc.nextInt();
        int a[] = new int[length];
        System.out.println("请依次为数组赋值：");
        for (int i=0;i<a.length;i++){      //为数组赋值
            a[i] = sc.nextInt();
        }
        sls.selectSort(a);
    }

    public void selectSort(int a[]){
        int flag = 0;
        for (int i=0;i<a.length-1;i++){             //进行n-1次的选择
            int temp = 0;
            int index = i;
            for (int j=i+1;j<a.length;j++){       //对没有顺序的进行比较大小
                if (a[j]<a[index]){
                    index = j;
                }
            }
            if (index != i){
                temp = a[i];a[i] = a[index]; a[index] = temp;       //将a[i]和a[index]值的一个交换
            }
            System.out.println("经过第" + ++flag + "躺排序后的数组为：");
            for (int x=0;x<a.length;x++){
                if (x == a.length-1){                   //对每一趟最后一个数组元素输出进行一个换行
                    System.out.print(a[x] + "\n");
                }else {
                    System.out.print(a[x] + ",");
                }
            }
        }
    }
}
