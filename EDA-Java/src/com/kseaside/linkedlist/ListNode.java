package com.kseaside.linkedlist;

public class ListNode {
    public int val;
    public ListNode next;
    ListNode() {

    }
    public ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode listNode) {
        this.val = val;
        this.next = listNode;
    }

}
