package com.kseaside.sort;

import java.util.Arrays;

public class MergeSort {
    //分和治(合)的方法
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //向左递归分解
            mergeSort(arr, left, mid, temp);
            //向右递归分界
            mergeSort(arr, mid + 1, right, temp);
            //合并
            merge(arr, left, mid, right, temp);
        }
    }


    /**
     * @param arr   待排序数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  临时数组，做中转使用
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left; //左边有序序列的初始索引
        int j = mid + 1; //右边有序序列的初始索引
        int t = 0; //指向temp数组的当前索引
        while (i <= mid && j <= right) {
            if (arr[i] > arr[j]) {
                temp[t++] = arr[j++];
            } else {
                temp[t++] = arr[i++];
            }
        }
        //把有剩余数据的一边的数据全部依次填充到temp中
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        //将temp数组中的数据拷贝到arr数组中去
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[t++];
        }
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, -1, 3, 12, 2};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

}
