package com.feizhi1;
import java.util.Scanner;

public class MergeSort {            //归并排序
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数组的长度：");
        int length = sc.nextInt();
        int[] arr = new int[length];
        System.out.println("请依次为数组赋值：");
        for (int i=0;i<length;i++) {
            arr[i] = sc.nextInt();
        }
        mergeSort.Merge_Sort(arr,0,length-1);
        System.out.println("排序后的数组为：");
        for (int i=0;i<arr.length;i++) {
            if (i == length - 1) {
                System.out.println(arr[i]);
            } else{
                System.out.print(arr[i] + ",");
            }
        }
    }

    public  void Merge_Sort(int[] arr, int start, int end) {    //该方法里面包含了归并排序里面的分和合
        //当start==end时，此时分组里只有一个元素，所以这是临界点
        if (start < end) {
            //分成左右两个分组，再进行递归
            int mid = (start + end) / 2;
            //左半边分组
            Merge_Sort(arr, start, mid);
            //右半边分组
            Merge_Sort(arr, mid + 1, end);
            //递归之后再归并归并一个大组
            Merge(arr, start, mid, end);
        }
    }

    public  void Merge(int[] arr, int start, int mid, int end) {
        //左边分组的起点i_start，终点i_end，也就是第一个有序序列
        int i_start = start;
        int i_end = mid;
        //右边分组的起点j_start，终点j_end，也就是第二个有序序列
        int j_start = mid + 1;
        int j_end = end;
        //额外空间初始化，数组长度为end-start+1
        int[] temp=new int[end-start+1];
        int len = 0;
        //合并两个有序序列
        while (i_start <= i_end && j_start <= j_end) {
            //当arr[i_start]<arr[j_start]值时，将较小元素放入额外空间，反之一样
            if (arr[i_start] < arr[j_start]) {
                temp[len] = arr[i_start];
                len++;
                i_start++;
            } else {
                temp[len] = arr[j_start];
                len++;
                j_start++;
            }
            //temp[len++]=arr[i_start]<arr[j_start]?arr[i_start++]:arr[j_start++];
        }

        //i这个序列还有剩余元素
        while(i_start<=i_end){
            temp[len] = arr[i_start];
            len++;
            i_start++;
        }
        //j这个序列还有剩余元素
        while(j_start<=j_end){
            temp[len] = arr[j_start];
            len++;
            j_start++;
        }
        //辅助空间数据覆盖到原空间
        for(int i=0;i<temp.length;i++){
            arr[start+i]=temp[i];
        }
    }
}
