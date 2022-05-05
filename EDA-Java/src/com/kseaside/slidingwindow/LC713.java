package com.kseaside.slidingwindow;

public class LC713 {

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length, ret = 0;
        int prod = 1, i = 0;
        for (int j = 0; j < n; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }
            ret += j - i + 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        numSubarrayProductLessThanK(new int[]{2, 10, 5, 4}, 100);
    }
}
