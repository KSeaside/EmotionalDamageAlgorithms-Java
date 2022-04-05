package com.kseaside.linkedlist;

public class GetMiddleNode {

    /**
     * 对链表进行两次遍历。第一次遍历时，我们统计链表中的元素个数
     * N；第二次遍历时，我们遍历到第 N/2 个元素（链表的首节点为第 0 个元素）时，将该元素返回即可
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        int n = 0;
        ListNode cur = head;

        while (cur != null) {
            ++n;
            cur = cur.next;
        }

        int k = 0;
        cur = head;
        while (k < n / 2) {
            ++k;
            cur = cur.next;
        }
        return cur;
    }

}
