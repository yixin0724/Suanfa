package com.dp1;

import java.util.Scanner;
/**
    0/1背包问题(动态规划)
    总体思路：根据动态规划解题步骤（问题抽象化、建立模型、寻找约束条件、判断是否满足最优性原理、找大问题与小问题的递推关系式、填表、寻找解组成）找出01背包问题的最优解以及解组成，然后编写代码实现。
    输入：value[]代表物品价值,weight[]物品重量
    输出：最具有价值的放法
    1.首先创建两个一维数组分别代表物品的重量和价值，用Xi表示0或1代表放与不放。用Wi表示编号为i的重量，用Vi表示编号为i的价值，
    2.其次建立模型。用max(V1X1一直加到ViXi)即V[][]来代表价值最大化，横左边代表重量，纵坐标代表前几个物品，然后寻找约束条件，得到W1X1+W2X2一直到WiXi
    3.然后寻找递推关系，发现有两种情况，①包的容量比该商品体积小，装不下，此时的价值与前i-1个的价值是一样的，即V(i,j)=V(i-1,j)；
    ②还有足够的容量可以装该商品，但装了也不一定达到当前最优价值，所以在装与不装之间选择最优的一个，即V(i,j)=max｛V(i-1,j)，V(i-1,j-w(i))+v(i)｝。
    其中V(i-1,j)表示不装，V(i-1,j-w(i))+v(i) 表示装了第i个商品，背包容量减少w(i)，但价值增加了v(i)；
    由此可以得出递推关系式：
    j<w(i)      V(i,j)=V(i-1,j)
    j>=w(i)     V(i,j)=max｛V(i-1,j)，V(i-1,j-w(i))+v(i)｝
    v[i][j]表示前i个物品中容量为j所能放的最大值
*/
public class PackSack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入物品的数量：");
        int n = sc.nextInt();
        int weight[] = new int[n];
        int value[] = new int[n];
        System.out.println("请依次为物品赋值重量：");
        for (int i = 0; i < n; i++) {       //依次为重量赋值
            weight[i] = sc.nextInt();
        }
        System.out.println("请依次为物品赋值价值：");
        for (int j = 0; j < n; j++) {
            value[j] = sc.nextInt();
        }
        System.out.println("请输入最大容量：");
        int capacity = sc.nextInt();
        System.out.println("最大价值为：" + KnapSack(weight,value,n,capacity));
    }
    public static int KnapSack(int weight[], int value[], int n, int capacity) {

        //创建二维数组，V[i][j]表示前i个物品中能够装入容量为j的背包中的最大价值
        int[][] V = new int[n + 1][capacity + 1];
        int[][] path = new int[n + 1][capacity + 1];//记录放入商品的情况
        for (int i = 1; i < V.length; i++) {
            for (int j = 1; j < V[0].length; j++) {
                //如果当前物品的重量大于背包的容量，则不能放置，表格中价值不变
                if (weight[i - 1] > j) {
                    V[i][j] = V[i - 1][j];
                } else {
                    //否则V[i][j]=max(V[i-1][j],value[i-1]+V[i-1][j-weight[i-1]])
                    if (V[i - 1][j] < value[i - 1] + V[i - 1][j - weight[i - 1]]) {
                        V[i][j] = value[i - 1] + V[i - 1][j - weight[i - 1]];
                        //记录当前的装载情况
                        path[i][j] = 1;
                    } else {
                        V[i][j] = V[i - 1][j];
                    }
                }
            }
        }

        //查看表格V的情况
        for (int i = 0; i < V.length; i++) {
            for (int j = 0; j < V[i].length; j++) {
                System.out.print(V[i][j] + " ");
            }
            System.out.println();
        }

        //输出放入的商品
        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.println("第" + i + "个商品放入背包");
                j = j - weight[i - 1];
            }
            i--;
        }
        return V[n][capacity];
    }
}
