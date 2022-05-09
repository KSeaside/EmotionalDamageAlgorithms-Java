package com.kseaside.daily;

import java.util.ArrayList;
import java.util.List;

public class LC442 {

    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        List<Integer> list = new ArrayList();
        for (int i = 0; i < n; i++) {
            res[nums[i]]++;
        }

        for (int i = 0; i < n; i++) {
            if (res[i] == 2) {
                list.add(i);
            }
        }
        return list;
    }
}
