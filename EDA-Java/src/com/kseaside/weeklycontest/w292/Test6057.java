package com.kseaside.weeklycontest.w292;

import com.kseaside.binarytree.TreeNode;

public class Test6057 {
    int count = 0;
    public int averageOfSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traverse(root);
        return count;
    }

    public int[] traverse(TreeNode root) {

        int cur = root.val;
        int arr[] = new int[2];
        arr[0] = 1;
        arr[1] = root.val;
        if (root.left != null) {
            int[] temp = traverse(root.left);
            arr[1] += temp[1];
            arr[0] += temp[0];
        }
        if (root.right != null) {
            int[] temp = traverse(root.right);
            arr[1] += temp[1];
            arr[0] += temp[0];

        }
        int avg = arr[1] / arr[0];
        if (avg == cur) {
            count += 1;
        }
        return arr;
    }

    public static void main(String[] args) {
        Test6057 test6057 = new Test6057();
        test6057.averageOfSubtree(new TreeNode(1));
        System.out.println(test6057.count);
    }
}
