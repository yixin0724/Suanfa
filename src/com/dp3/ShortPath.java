package com.dp3;
/*
    最短路径问题(有向图，动态规划)
    输入：一个n阶矩阵来表示有向图的顶点，边数和权值。
    输出：将源点到最终点的路径和路径大小输出。
    1.首先初始化一个n阶矩阵，将他们的值都初始化为正无穷，然后利用循环依次将顶点之间的关系和权值赋值进去
    2.开始设计算法，可以用动态规划法，首先定义两个一维数组，一个path[]用来存路径，表示从哪个顶点到索引位置最短，一个minpath[]表示从源点到下标的距离
    3.最后输出结果，用回溯方法输出最短所要经过的路径,即：while(path[i]>=0){sout path[i];i=path[i];}    输出完一个后，继续输出下一个path[path[i]]
 */
import java.util.ArrayList;
import java.util.Scanner;

public class ShortPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入有向图的顶点个数：");
        int len = sc.nextInt();
        System.out.println("请输入边长的个数：");
        int side = sc.nextInt();
        int arr[][]=new int[len][len];
        for (int i = 0; i < len; i++) {     //对arr数组进行初始化
            for (int j = 0; j < len; j++) {
                arr[i][j] = 9999;       //表示为无穷大
            }
        }
            System.out.println("请依次输入两个顶点和边的权值：");
        for (int k = 0; k < side; k++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int weight = sc.nextInt();
            arr[i][j] = weight;
        }
        System.out.println("所得最短路径和为：" + shortPath(arr,len));
    }
    public static int shortPath(int[][] arr, int len){
        ArrayList<String> list = new ArrayList<String>();		//创建一个list集合方便正序输出路径

        int path[] = new int[len];          //用于存路径
        int minpath[] = new int[len];       //用于存源点到该下标的最短距离
        for (int i = 0; i < len; i++) {
            minpath[i] = 9999;      //对minpath数组进行初始化
            path[i] = -1;           //对path数组进行初始化
        }
        minpath[0] = 0;         //将0设置为源点
        for (int j = 1; j < len; j++) {                 //进行填表工作，这里的j代表入边，所以从1开始
            for (int i = j-1; i >=0; i--) {             //考察所以入边，找到一个最小的路径长度，并把路径存入path
                if (arr[i][j] + minpath[i] <minpath[j]){
                    minpath[j] = arr[i][j] + minpath[i];
                    path[j] = i;
                }
            }
        }
//        System.out.print("所得路径为：" + (len-1));
        int i = len-1;
        String k = Integer.toString(i);					//对len-1进行类型转换，然后存入list集合
        list.add(k);
        while (path[i]>=0){                         //对path用回溯的方法进行输出路径
//            System.out.print("-" + path[i]);
            list.add(Integer.toString(path[i]));
            i = path[i];
        }
//        System.out.println(list);
        System.out.print("求得最短路径为：");
        for(int l=list.size()-1;l>=0;l--) {					//对list集合倒序进行遍历，依次输出
            if (l == 0) {
                System.out.print(list.get(l) + "]");
            }else if(l == list.size()-1){
                System.out.print("[" + list.get(l) + "-");
            }else {
                System.out.print(list.get(l) + "-");
            }
        }
        System.out.println("");
        return minpath[len-1];
    }
}
