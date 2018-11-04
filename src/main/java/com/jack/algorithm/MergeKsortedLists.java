package com.jack.algorithm;

/**
 * create by jack 2018/11/4
 *
 * @author jack
 * @date: 2018/11/4 11:00
 * @Description:
 * 合并n个有序列表
 */
public class MergeKsortedLists {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 题目描述：
     *https://leetcode.com/problems/merge-k-sorted-lists/
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        ListNode head = null;
        for (int i=0;i<lists.length;i++) {
            ListNode node = lists[i];
            head = mergeTwoLists(head, node);
        }
        return head;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p = null;
        while (p1 != null || p2 != null) {
            if (head == null) {
                if (p1.val <= p2.val) {
                    head = p1;
                    p1 = p1.next;
                    p = head;
                } else if (p1.val > p2.val) {
                    head = p2;
                    p2 = p2.next;
                    p = head;
                }
            }else {
                if (p1 != null && p2 != null) {
                    if (p1.val <= p2.val) {
                        p.next = p1;
                        p = p.next;
                        p1 = p1.next;
                    } else {
                        p.next = p2;
                        p = p.next;
                        p2 = p2.next;
                    }
                } else if (p1 != null && p2 == null) {
                    p.next = p1;
                    p = p.next;
                    p1 = p1.next;
                } else if (p1 == null && p2 != null) {
                    p.next = p2;
                    p = p.next;
                    p2 = p2.next;
                }
            }

            p.next = null;
        }
        return head;
    }

    /**
     * 创建链表
     * @param nums
     * @return
     */
    public static ListNode createListNode(int[] nums){
        ListNode head=null;
        ListNode p = head;
        for (int i=0;i<nums.length;i++) {
            int num = nums[i];
            ListNode node = new ListNode(num);
            if (head == null) {
                head = node;
                p = head;
            } else {
                p.next = node;
                p = node;
            }
        }
        return head;
    }

    /**
     * 打印链表
     * @param nodes
     */
    public static void displayListNode(ListNode nodes){
        ListNode p = nodes;
        while (p != null) {
            int num = p.val;
            System.out.print(num+"->");
            p=p.next;
        }
        System.out.println("");
    }


    public static void main(String[] args) {
        int[] num1 = new int[]{1,4,5};
        int[] num2 = new int[]{1,3,4};
        int[] num3 = new int[]{2,6};


        ListNode node1 = createListNode(num1);
        ListNode node2 = createListNode(num2);
        ListNode node3 = createListNode(num3);

        ListNode [] nodes = new ListNode[]{node1,node2,node3};

        ListNode node = mergeKLists(nodes);
        displayListNode(node);
    }
}
