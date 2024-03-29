package com.dp2;
/*
    动态规划的原理
动态规划与分治法类似，都是把大问题拆分成小问题，通过寻找大问题与小问题的递推关系，解决一个个小问题，最终达到解决原问题的效果。但不同的是，分治法在子问题和子子问题等上被重复计算了很多次，而动态规划则具有记忆性，通过填写表把所有已经解决的子问题答案纪录下来，在新问题里需要用到的子问题可以直接提取，避免了重复计算，从而节约了时间，所以在问题满足最优性原理之后，用动态规划解决问题的核心就在于填表，表填写完毕，最优解也就找到。

最优性原理是动态规划的基础，最优性原理是指“多阶段决策过程的最优决策序列具有这样的性质：不论初始状态和初始决策如何，对于前面决策所造成的某一状态而言，其后各阶段的决策序列必须构成最优策略”。

 */

/* 用动态规划问题去解决数塔问题
   输入：二维数组a[n][n]
   输出：数塔的最大数值和其所经过的路径
   1. 初始化数值maxAdd的最后一行为数塔的底层数据：
      for(j=0;j<n;j++)
         maxAdd[n-1][j]=a[n-1][j];
   2. 从第n-1层开始直到第一层对下三角元素maxAdd[i][j]执行下述操作：
      2.1 maxAdd[i][j]=a[i][j]+max{maxAdd[i+1][j],maxAdd[i+1][j+1]};
      2.2 如果选择下标j的元素，则path[i][j]=j,否则path[i][j]=j+1;
   3. 输出最大数值和maxAdd[0][0];
   4.根据path数组确定每一层决策的列下标，输出路径信息。
 */
/*
这里面path数组二维的二维数组记录
path数组定义为二维数组，path[i] [j]，其值表示i层第j个元素的i+1层走向，
也就是说path数组记录下了所有可能的路径，到时候根据顶层的path记录的值向下递推就可以求出路径（顶层的值是代表下一层的走向）。
一维的
根据利用数组索引和值的配合，也可以通过一维数组实现记录，索引代表当前的层，值代表当前层的第几个元素，每层决策完后的最大值就是确定的路径，把它记录下来即可
 */
import java.util.Scanner;

public class CountTower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数塔最后一层的个数：");
        int n = sc.nextInt();
        int a[][] = new int[n][n];
        System.out.println("请从上往下依次赋值：");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println("所得最大路径之和为：" + countTower(a, n));
    }

    public static int countTower(int a[][], int n) {
        int maxAdd[][] = new int[n][n];
        int path[][] = new int[n][n];               //用path这个数组是用来记每一层决策的列下标，输出路径信息
        for (int i = 0; i < n; i++) {                  //首先对最后倒数第二层进行初始化，将其值赋值给maxAdd这个用来保存最大值的数组
            maxAdd[n - 1][i] = a[n - 1][i];
        }
        for (int i = n - 2; i >= 0; i--) {           //外层循环控制从倒数第二，一直到第一层
            for (int j = 0; j <= i; j++) {         //内层循环控制每一行进行选择一个最大值进行相加
                if (maxAdd[i + 1][j] > maxAdd[i + 1][j + 1]) {
                    maxAdd[i][j] = a[i][j] + maxAdd[i + 1][j];
                    path[i][j] = j;                 //本次决策选择下标j的元素
                } else {
                    maxAdd[i][j] = a[i][j] + maxAdd[i + 1][j + 1];
                    path[i][j] = j + 1;                //本次决策选择下标j+1的元素
                }
            }
        }
        System.out.printf("路径为：" + a[0][0]);        //输出顶层数字
        int j = path[0][0];                             //顶层决策是选择下一层列下标为path[0][0]的元素
        for (int i = 1; i < n; i++) {
            System.out.printf("-->" + a[i][j]);
            j = path[i][j];                         //本层决策是选择下一层列下标为path[i][j]的元素
        }
        System.out.println("");
        return maxAdd[0][0];                        //返回最大数值和，即最终的决策结果
    }
}
