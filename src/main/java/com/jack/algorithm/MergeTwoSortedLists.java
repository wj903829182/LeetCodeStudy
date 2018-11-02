package com.jack.algorithm;

/**
 * create by jack 2018/11/1
 *
 * @author jack
 * @date: 2018/11/1 23:30
 * @Description:
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return null;
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
    public static void displayListNode(RemoveNthNodeFromEndOfList.ListNode nodes){
        RemoveNthNodeFromEndOfList.ListNode p = nodes;
        while (p != null) {
            int num = p.val;
            System.out.print(num+"->");
            p=p.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {

    }
}
