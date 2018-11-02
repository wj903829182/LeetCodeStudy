package com.jack.algorithm;

/**
 * create by jack 2018/11/1
 *
 * @author jack
 * @date: 2018/11/1 23:30
 * @Description:
 * 合并链表
 */
public class MergeTwoSortedLists {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 题目描述：
     * https://leetcode.com/problems/merge-two-sorted-lists/
     * @param l1
     * @param l2
     * @return
     */
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
        int [] nums1 = new int[]{1,2,4};
        int [] nums2 = new int[]{1,3,4};
        ListNode node1 = createListNode(nums1);
        displayListNode(node1);
        ListNode node2 = createListNode(nums2);
        displayListNode(node2);
        ListNode node3 = mergeTwoLists(node1,node2);
        displayListNode(node3);
    }
}
