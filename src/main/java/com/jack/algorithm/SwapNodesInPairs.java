package com.jack.algorithm;

import com.jack.entity.ListNode;
import com.jack.util.ListUtil;

/**
 * create by jack 2018/11/4
 *
 * @author jack
 * @date: 2018/11/4 11:58
 * @Description:
 * 链表的每两个节点做一次交换
 */
public class SwapNodesInPairs {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 题目描述：
     * https://leetcode.com/problems/swap-nodes-in-pairs/
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        ListNode rs = null;
        ListNode p = null;
        int num ;
        ListNode node = null;
        while (head != null) {
            if (head.next != null) {
                num = head.next.val;
                node = new ListNode(num);
                if (rs == null) {
                    rs = node;
                    p = rs;
                } else {
                    p.next = node;
                    p=p.next;
                }
                num = head.val;
                node = new ListNode(num);
                p.next = node;
                p = p.next;
                head=head.next.next;
            } else {
                num = head.val;
                node = new ListNode(num);
                if (rs == null) {
                    rs = node;
                    p = rs;
                } else {
                    p.next = node;
                    p=p.next;
                }
                head = head.next;
            }

        }
        return rs;
    }



    /**
     * 创建链表
     *
     * @param nums
     * @return
     */
    public static ListNode createListNode(int[] nums) {
        ListNode head = null;
        ListNode p = head;
        for (int i = 0; i < nums.length; i++) {
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
     *
     * @param nodes
     */
    public static void displayListNode(ListNode nodes) {
        ListNode p = nodes;
        while (p != null) {
            int num = p.val;
            System.out.print(num + "->");
            p = p.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        ListNode node=createListNode(nums);
        displayListNode(node);
        node =swapPairs(node);
        displayListNode(node);
    }
}
