###### 1、从尾到头打印链表
>[题目](https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/)
>
>[练习](https://github.com/sunnnydaydev/CodingInterviews/blob/master/src/LinkedList/ReversePrint.java)

```java
    public int[] reversePrint(ListNode head) {
        int[] arr;
        int size = 0;

        ListNode node = head;
        while (null != node) {
            size++;
            node = node.next;
        }

        arr = new int[size];//此时数组元素默认都是0
        int index = size - 1;
        while (null != head) {
            arr[index--] = head.val; // 动态修改数组元素值
            head = head.next;
            //index--; // 优化
        }
        return arr;
    }

```