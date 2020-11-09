package LinkedList;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Create by SunnyDay on 2020/11/09 20:43
 * 题目：从尾到头打印链表
 * 介绍：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class ReversePrint {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //leetcode 题目
    public int[] reversePrint(ListNode head) {
        int[] arr;
        int size = 0;

        ListNode node = head;
        while (null != node) {
            size++;
            node = node.next;
        }

        arr = new int[size];//次数数组元素默认都是0
        int index = size - 1;
        while (null != head) {
            arr[index--] = head.val; // 动态修改数组元素值
            head = head.next;
            //index--; // 优化
        }
        return arr;
    }

    // 牛客题目：https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tqId=11156&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking
    // 二者类似
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (null != listNode) {//遍历
            list.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(list);//反转 （内部复杂度不高）
        return list;
    }
}
