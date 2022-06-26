package com.sort1;
import java.util.Random;
import java.util.Scanner;

public class QucikSrot {            //快速排序
        public static void main(String[] args) {
            QucikSrot qucikSrot = new QucikSrot();
            Random r = new Random();
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入数组的长度：");
            int length = sc.nextInt();
            int[] a=new int[length];
            System.out.println("得到的随机数组为：");
            for(int i=0;i<a.length;i++) {
                a[i] = r.nextInt(20);
            }
            for (int i=0;i<a.length;i++){
                System.out.print(a[i] + ",");
            }
            System.out.println("\n");
            System.out.println("经过快速排序过后的数组为：");
            qucikSrot.QuickSort(a,0,length-1);
            for(int i=0;i<length;i++) {
                System.out.print(a[i] + ",");
            }
        }
        public void QuickSort(int[] a,int i,int j) {
            if(i>=j) {		//先判断区间是否是1个以上
                return;
            }
            int low = i;
            int high = j;
            int key = i;
            int temp=0;		//值的辅助交换
            while(i<j) {
                //利用while循环进行左边序列的选择
                while(i<j && a[j]>=a[key]) {
                    j--;
                }
                while(i<j && a[i]<=a[key]) {
                    i++;
                }
                //此时i=j，即基准位置已经确定，进行a[i]和a[j]的值交换
                temp=a[i]; a[i]=a[j]; a[j]=temp;
            }
            //确定基准位置
            temp=a[key]; a[key]=a[j]; a[j]=temp;
            key=j;
            //交换完基准的值和位置以后，进行其他子序列的选择
            QuickSort(a, low, key-1);
            QuickSort(a, key+1, high);
        }

    }
