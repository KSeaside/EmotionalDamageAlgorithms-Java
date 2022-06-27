package com.kseaside.weeklycontest.w299;

//如果一个正方形矩阵满足下述 全部 条件，则称之为一个 X 矩阵 ：
//
//矩阵对角线上的所有元素都 不是 0
//矩阵中所有其他元素都是 0
//给你一个大小为 n x n 的二维整数数组 grid ，表示一个正方形矩阵。如果 grid 是一个 X 矩阵 ，返回 true ；否则，返回 false
public class Test6101 {

    public boolean checkXMatrix(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        boolean flag = false;
        for (int i = 0; i < h; i++) {

            for (int j = 0; j < w; j++) {
                if (i == j || (j == (h - i - 1))) {
                    if (grid[i][j] != 0) {
                        flag = true;
                    } else {
                        return false;
                    }
                } else {
                    if (grid[i][j] == 0) {
                        flag = true;
                    } else {
                        return false;
                    }
                }

            }
        }
        return flag;
    }
}
