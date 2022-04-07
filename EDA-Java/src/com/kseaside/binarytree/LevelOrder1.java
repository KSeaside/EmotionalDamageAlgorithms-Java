package com.kseaside.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 */
public class LevelOrder1 {

    //1 特例处理： 当根节点为空，则返回空列表 [] ；
    //2 初始化： 打印结果列表 res = [] ，包含根节点的队列 queue = [root] ；
    //3 BFS 循环： 当队列 queue 为空时跳出；
    //     3.1新建一个临时列表 tmp ，用于存储当前层打印结果；
    //     3.2当前层打印循环： 循环次数为当前层节点数（即队列 queue 长度）；
    //          1)出队： 队首元素出队，记为 node；
    //          2)打印： 将 node.val 添加至 tmp 尾部；
    //          3)添加子节点： 若 node 的左（右）子节点不为空，则将左（右）子节点加入队列 queue ；
    //     3.3将当前层结果 tmp 添加入 res 。

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
