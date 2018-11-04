package com.jack.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * create by jack 2018/11/4
 *
 * @author jack
 * @date: 2018/11/4 21:01
 * @Description:
 *
 * 把一个链表按指定长度分组倒序
 *
 */
public class ReverseNodesInKgroup {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 题目描述：
     * https://leetcode.com/problems/reverse-nodes-in-k-group/
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k ==1) {
            return head;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            int num = head.val;
            list.add(num);
            head = head.next;
        }
        int length = list.size();
        int n=1;
        ListNode rs = null;
        ListNode p = null;
        int num =0;
        int n1 = length/k;
        int n2= length%k;
        for (int i=1;i<=n1;i++) {
            List<Integer> list1 =list.subList(i*k-k, i * k);
            int length1 = list1.size();
            for (int j=length1-1;j>=0;j--) {
                num = list1.get(j);
                ListNode node = new ListNode(num);
                if (rs == null) {
                    rs = node;
                    p = rs;
                } else {
                    p.next = node;
                    p = p.next;
                }
            }
        }
        if (n2 != 0) {
            for (int i=n1*k;i<length;i++) {
                num = list.get(i);
                ListNode node = new ListNode(num);
                if (rs == null) {
                    rs = node;
                    p = rs;
                } else {
                    p.next = node;
                    p = p.next;
                }
            }
        }
        return rs;
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
        //int[] nums = new int[]{1,2,3,4,5};
        int[] nums = new int[]{1,2,3,4,5,6};
        ListNode node = createListNode(nums);
        displayListNode(node);
        //int k=3;
        //int k=1;
        int k=2;
        ListNode node2 = reverseKGroup(node,k);
        displayListNode(node2);
    }
}
