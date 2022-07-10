package com.kseaside.weeklycontest.w300;

import com.kseaside.linkedlist.ListNode;
//给你两个整数：m 和 n ，表示矩阵的维数。
//
//另给你一个整数链表的头节点 head 。
//
//请你生成一个大小为 m x n 的螺旋矩阵，矩阵包含链表中的所有整数。
// 链表中的整数从矩阵 左上角 开始、顺时针 按 螺旋 顺序填充。如果还存在剩余的空格，则用 -1 填充。
//
//返回生成的矩阵。
//
//输入：m = 3, n = 5, head = [3,0,2,6,8,1,7,9,4,2,5,5,0]
// 输出：[[3,0,2,6,8],
//      [5,0,-1,-1,1],
//      [5,2,4,9,7]]
//解释：上图展示了链表中的整数在矩阵中是如何排布的。
// 注意，矩阵中剩下的空格用 -1 填充。
//

public class Test6109 {


    public static void main(String[] args) {
        Test6109 test6109 = new Test6109();
        test6109.spiralMatrix(5, 3, new ListNode(2));
    }


    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        int start = 1;
        int tmp = m;
        int tep = m * n;
        int i = 0;
        int val = -1;
        if (head != null) {
            val = head.val;
        }

        while (start < tep) {
            circle(start, tmp, res, i++, val);
            start = (n - 1) * 4 + start;
            n = n - 2;
            if (head != null && head.next != null) {
                val = head.next.val;
            } else {
                val = -1;
            }

        }
        return res;
    }


    public void circle(int start, int n, int[][] res, int line, int val) {

        for (int i = line; i < n - line - 1; i++)
            res[line][i] = val;
        for (int i = line; i < n - line - 1; i++)
            res[i][n - line - 1] = val;
        for (int i = n - line - 1; i > line; i--)
            res[n - line - 1][i] = val;
        for (int i = n - line - 1; i > line; i--)
            res[i][line] = val;

    }



    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int start = 1;
        int tmp = n;
        int tep = n * n;
        int i = 0;
        while (start < tep) {
            circle(start, tmp, res, i++);
            start = (n - 1) * 4 + start;
            n = n - 2;
        }
        if (tmp % 2 != 0)
            res[res.length / 2][res.length / 2] = tep;
        return res;
    }


    public void circle(int start, int n, int[][] res, int line) {

        for (int i = line; i < n - line - 1; i++)
            res[line][i] = start++;
        for (int i = line; i < n - line - 1; i++)
            res[i][n - line - 1] = start++;
        for (int i = n - line - 1; i > line; i--)
            res[n - line - 1][i] = start++;
        for (int i = n - line - 1; i > line; i--)
            res[i][line] = start++;

    }

}
