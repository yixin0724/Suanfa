package com.bingchaji;

import java.util.Scanner;

/**
 * @author YiXin
 * @create 2022/5/21
 * 这一道题可以用并查集的方法做
 * 思路：输入两个村庄后就把它们连起来，输入完毕后用i从1循环到n，
 * 所以如果i的父亲为它本身的话（它是祖先，它没有父亲），ans-1。答案要减1，因为三个点中只需用两条线连接，无需用三条线连接。
 * 并查集
 * 并查集是一种树型的数据结构，用于处理一些不交集的合并及查询问题（不交集的意思是两个集合中没有相同的元素）。
 * 并查集分两个主要步骤——合并，查找
 * 1.find：确定元素属于哪一个子集。它可以被用来确定两个元素是否属于同一子集。
 * 2.unity：将两个子集合并成同一个集合。
 */
public class CunCunTong {
    public static void main(String[] args) {
        int fa[] = new int[1000001];
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入有几个村庄和几条路：");
            int ans = 0;                        //ans要在循环中定义为0
            int n = sc.nextInt();
            if (n == 0) {
                System.exit(0);
            }
            int m = sc.nextInt();
            for (int i = 1; i <= n; i++) {
                fa[i] = i;                      //初始化自己的父亲是自己
            }
            System.out.println("请输入路所连接的村庄");
            for (int i = 1; i <= m; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                unity(x, y, fa);//合并x和y
            }
            for (int i = 1; i <= n; i++) {
                if (find(i, fa) == i)           //自己的父亲等于自己本身
                {
                    ans++;
                }
            }
            System.out.println("还需要建设" + String.valueOf(ans-1) + "条路");  //答案减一
        }
    }

    public static int find(int x, int fa[]){    //查找，并查集(路径压缩)

        if (x != fa[x])                         //当x不等于它的爸爸时(当它是祖先时，它没有爸爸)
        {
            fa[x] = find(fa[x], fa);            //继续找他的爸爸的爸爸
        }
        return fa[x];                            //返回祖先
    }

    public static void unity(int x, int y, int[] fa) {      //合并
        int r1 = find(x, fa);           //找到x的祖先
        int r2 = find(y, fa);           //找到y的祖先
        fa[r1] = r2;                    //祖先和祖先结为父子(谁是父亲谁是儿子都可以)
    }
}
