package com.dp4;

import java.util.Scanner;

/**
 * 最长公共子序列问题(动态规划)
 * 给定两个序列，一个X={x1,x2,......,xm}和Y={y1,y2,.......,yn}，求他俩最长公共子序列Z={z1,z2,.....,zk}
 * 思路：我们使用动态规划思想，首先考虑怎么设计表，我们在这里使用两个二维表，一个是L(i,j)代表X序列和Y序列的最长公共子序列的长度
 * 在这里L(i,j)所能得到的有两种①当xi=yj时，L(i-1,j-1)+1；②当xi!=yj时，max{L(i,j-1),L(i-1,j)}；
 * 当不相等的时候，我们要考虑是让X序列往后移动，还是让Y序列往后移动，考虑依据是，谁可以使最长公共子序列变长，
 * 因此有两种情况，当X序列往后移动的时候，即行数增加一行，Y序列移动的时候，列数增加一行，这个我们用S状态矩阵来存储决策。
 * 然后用S(i,j)代表状态矩阵，这里S的表示为{1  xi=yj,i>=1,j>=1; 2  xi!=yj  且L(i,j-1)>=L(i-1,j);  3  xi!=yj  且L(i,j-1)<(i-1,j)}
 * 在这里1所代表的就是他俩相等，2所代表的意思是xi=yj不相等，并且是Y序列移动，默认也是Y移动因为他序列长，3所代表的是不相等，且X序列移动了
 * 最后我们根据状态矩阵从最后一个数开始状态分析进行回溯输出
 * X={a.b.c.b.d.b},Y={a,c,b,b,a,b,d,b,b}
 */
public class MaxSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请直接输入序列X：");
        char[] str1 = sc.nextLine().toCharArray();
        System.out.println("请直接输入序列Y：");
        char[] str2 = sc.nextLine().toCharArray();

//        System.out.println("请输入X序列的长度：");
//        int len1 = sc.nextInt();
//        String[] x = new String[len1];
//        System.out.println("请为X序列赋值：");
//        for (int i=0;i<len1;i++){
//            x[i]=sc.next();
//        }
//        System.out.println("请输入Y序列的长度：");
//        int len2 = sc.nextInt();
//        String[] y = new String[len2];
//        System.out.println("请为Y序列赋值：");
//        for (int i=0;i<len2-1;i++){
//            y[i]=sc.next();
//        }
        System.out.println("最长的公共子序列长度为：" + CommonOrder(str1,str1.length,str2, str2.length));
    }

    public static int CommonOrder(char[] X,int n,char[] Y,int m){
        int[][] L = new int[n+1][m+1];
        int[][] S = new int[n+1][m+1];
        //初始化二维数组
        for (int i=0;i<m+1;i++){
            L[0][i]=0;
        }
        for (int i=0;i<n+1;i++){
            L[i][0]=0;
        }
        //接下来进行填表工作,在java中没有赋值的数组默认值为0，因此特意为第一行和第一列赋值为0了
        for (int i=1;i<n+1;i++){
            for (int j=1;j<m+1;j++){
                if (X[i-1] == Y[j-1]){                  //当xi=yj的时候，直接根据上面分析的为为L[i][j]赋值
                    L[i][j] = L[i-1][j-1]+1;
                    S[i][j] = 1;
                }else if (L[i][j-1] >= L[i-1][j]){  //当xi!=yj的时候，且L[i][j-1] >= L[i-1][j]，为他们赋值
                    L[i][j] = L[i][j-1];
                    S[i][j] = 2;
                }else {                             //当xi!=yj的时候，且L[i][j-1] < L[i-1][j]
                    L[i][j] = L[i-1][j];
                    S[i][j] = 3;
                }
            }
        }

//        System.out.println("得到的S矩阵为：");
//        for(int i=0;i<n+1;i++) {
//        	for(int j=0;j<m+1;j++) {
//        		System.out.print(S[i][j]);
//        	}
//        	System.out.println("");
//        }

        //接下来进行为z数组赋值，z数组是用来保存公共子序列的
        int i = n;
        int j=m;
        int k=L[n][m];    //k代表的公共子序列的长度
        char[] z = new char[k+1];
        //接下来根据状态矩阵S来为z[]赋值
        while (i>0 && j>0){
            if (S[i][j] ==1){          //状态为1时xi=yj，直接赋值，并且两个序列都减一
                z[k-1] = X[i-1];
                k--;
                i--;
                j--;
            }else if (S[i][j] == 2){
                j--;                    //状态为2的时候代表当时是列增加了,因此再回减回去
            }else {
                i--;                    //状态为3代表是行
            }
        }
        System.out.print("得到的公共子序列为：");
        for (k=0;k<L[n][m];k++){
            if (k<L[n][m]-1) {
                System.out.print(z[k] + ",");
            }else {
                System.out.println(z[k]);
            }
        }
        return L[n][m];
    }
}

