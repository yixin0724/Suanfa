package com.sort2;

import java.util.Scanner;

public class BubbleSort {           //冒泡排序
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组的长度");
        int length = sc.nextInt();
        int array[] = new int[length];
        System.out.println("请依次为数组赋值：");
        for (int i=0;i<array.length;i++){      //为数组赋值
            array[i] = sc.nextInt();
        }
        bubbleSort.sort(array);
        System.out.println("经过冒泡之后的数组为：");
        for (int i=0;i<array.length;i++){
            System.out.print(array[i] + ",");
        }
    }

    public  void sort(int array[]) {
        int number = 0;
        //i表示第几轮“冒泡”，j 表示“走访”到的元素索引。
        // 每一轮“冒泡”中，j 需要从列表开头“走访”到 array.length - 1 的位置。
        for (int i = 0; i < array.length - 1; i++) {
            int flag = 0;
            number++;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j]; array[j] = array[j + 1]; array[j + 1] = temp; flag++;
                }
            }
            if (flag == 0){
                System.out.println("进行了" + number + "次排序");
                break;
            }
        }
    }
}
