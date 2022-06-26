package com.tanxin1;

/**
 * 贪心算法
 * 原理简单介绍：
 * 1.输入：一个加权连通图，其中顶点集合为V，边集合为E；
 * 2.初始化：Vnew = {x}，其中x为集合V中的任一节点（起始点），Enew = {},为空；
 * 3.重复下列操作，直到Vnew = V：
 * a.在集合E中选取权值最小的边<u, v>，其中u为集合Vnew中的元素，而v不在Vnew集合当中，
 * 并且v∈V（如果存在有多条满足前述条件即具有相同权值的边，则可任意选取其中之一）；
 * b.将v加入集合Vnew中，将<u, v>边加入集合Enew中；
 * 4.输出：使用集合Vnew和Enew来描述所得到的最小生成树。
 */


import java.util.ArrayList;
import java.util.Scanner;

public class Prim {
    /*
     * 参数G：给定的图，其顶点分别为0~G.length-1，相应权值为具体元素的值
     * 函数功能：返回构造生成的最小生成树，以二维数组形式表示，其中元素为0表示最小生成树的边
     */
    public void getMinTree(int[][] G) {
        int count = 0;
        int[][] result = G;
        int[] vertix = new int[G.length];   //记录顶点是否被访问，如果已被访问，则置相应顶点的元素值为-2
        for (int i = 0; i < G.length; i++)
            vertix[i] = i;
        ArrayList<Integer> listV = new ArrayList<Integer>(); //保存已经遍历过的顶点
        listV.add(0);      //初始随意选择一个顶点作为起始点，此处选择顶点0
        vertix[0] = -2;    //表示顶点0被访问
        while (listV.size() < G.length) {  //当已被遍历的顶点数等于给定顶点数时，退出循环
            int minDistance = Integer.MAX_VALUE;    //用于寻找最小权值，初始化为int最大值，相当于无穷大的意思
            int minV = -1;   //用于存放未被遍历的顶点中与已被遍历顶点有最小权值的顶点
            int minI = -1;   //用于存放已被遍历的顶点与未被遍历顶点有最小权值的顶点  ；即G[minI][minV]在剩余的权值中最小
            for (int i = 0; i < listV.size(); i++) {   //i 表示已被访问的顶点
                int v1 = listV.get(i);
                for (int j = 0; j < G.length; j++) {
                    if (vertix[j] != -2) {    //满足此条件的表示，顶点j未被访问
                        if (G[v1][j] != -1 && G[v1][j] < minDistance) {//G[v1][j]值为-1表示v1和j是非相邻顶点
                            minDistance = G[v1][j];
                            minV = j;
                            minI = v1;
                        }
                    }
                }
            }
            count = count + minDistance;             //把每次选出的最小路径保存
            vertix[minV] = -2;                      //表示minv这个点访问过了
            listV.add(minV);                        //加入到已访问的集合
            result[minI][minV] = 0;                 //表示最小生成树的边
            result[minV][minI] = 0;
        }
        System.out.print("使用Prim算法，对于给定图中的顶点访问顺序为：");
        System.out.println(listV);
        System.out.println("最短路径为：" + count);
//        System.out.println("使用Prim算法，构造的最小生成树的二维数组表示如下（PS：元素为0表示生成树的边）：");
//        for (int i = 0; i < result.length; i++) {
//            for (int j = 0; j < result[0].length; j++) {
//                System.out.print(result[i][j] + "\t");
//            }
//            System.out.println();
//        }
    }

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            Prim test = new Prim();
            //用一个二阶矩阵来表示无向连通网
            System.out.println("请输入顶点的个数：");
            int n = sc.nextInt();
            int[][] G = new int[n][n];
            //初始化矩阵
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    G[i][j] = -1;
                }
            }
            System.out.println("请输入边的个数：");
            int edge = sc.nextInt();
            System.out.println("请依次输入各个顶点和权值：");
            for (int i = 0; i < edge; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                int weight = sc.nextInt();
                G[start][end] = weight;
                G[end][start] = weight;
            }
            test.getMinTree(G);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("条件不足，无法找到最小的。");
        }
    }
}


/**
 * 0 1 34
 * 0 5 19
 * 0 2 46
 * 1 4 12
 * 4 5 26
 * 4 3 38
 * 5 2 25
 * 5 3 25
 * 2 3 17
 */

//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Prim {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        //用一个二阶矩阵来表示无向连通网
//        System.out.println("请输入顶点的个数：");
//        int n = sc.nextInt();
//        int[][] arr = new int[n][n];
//        //初始化矩阵
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                arr[i][j] = 999;
//            }
//        }
//        System.out.println("请输入边的个数：");
//        int edge = sc.nextInt();
//        System.out.println("请依次输入各个顶点和权值：");
//        for (int i = 0; i < edge; i++) {
//            int start = sc.nextInt();
//            int end = sc.nextInt();
//            int weight = sc.nextInt();
//            arr[start][end] = weight;
//            arr[end][start] = weight;
//        }
//        System.out.println(Prim_m(arr, n));
//    }
//
//    public static int Prim_m(int[][] arr, int n) {
//        //创建一个lowcost数组进行保存每一个顶点到生成树中所有顶点的最短权值
//        int[] lowcost = new int[n];
//        //创建一个adjvex数组保存最短边的顶点
//        int[] adjvex = new int[n];
//        //初始化lowcost
//        //接下来进行为lowcost数组贺adjvex数组赋值
//        for (int i = 0; i < n; i++) {
//            int min = 999;
//            for (int j = 0; j < n; j++) {
//                if (arr[i][j] < min ) {
//                    min = arr[i][j];
//                    adjvex[i] = j;
//                    arr[j][i] = 999;
//                }
//            }
//            lowcost[i] = min;
//        }
////        System.out.println(Arrays.toString(lowcost));
////        System.out.println(Arrays.toString(adjvex));
//        return 1;
//    }
//
//}
