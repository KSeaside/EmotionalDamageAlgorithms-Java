package com.kseaside.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: https://leetcode.cn/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
 * @author: kray
 * @date: 2024/7/22 17:18
 **/
public class LC88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list1.add(nums1[i]);
        }
        for (int i = 0; i < n; i++) {
            list2.add(nums2[i]);
        }
        list1.addAll(list2);
        list1.sort(Integer::compareTo);
        int[] res = new int[m + n];
        for (int i = 0; i < m + n; i++) {
            res[i] = list1.get(i);
            System.out.println(i + "-----" +res[i]);
        }
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        new LC88().merge(nums1, 3, nums2, 3);
    }
}
