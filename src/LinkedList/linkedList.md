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

###### 2、链表中倒数第k个节点
>[题目](https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/)
>
>[练习](https://github.com/sunnnydaydev/CodingInterviews/blob/master/src/LinkedList/KthNodeInLinkedList.java)

```java
     /**
       * 定义两个指针：
       * 第一个指针先遍历链表，从链表头开始到k-1 位置。
       * 第二个指针指向链表头部
       * <p>
       * 当第一个指针遍历到k位置时，第二个指针开始走，第一个指针走完，遍历完链表，第二个指针正好走到 n-k+1 位置。也即倒数第k个节点（n为节点总数）
       */
      public ListNode getKth(ListNode head, int k) {
          if (head == null || k == 0) { // 不存在情况
              return null;
          }

          ListNode pFast = head;//走的较快的指针
          ListNode pSlow = head;// 走的较慢的指针

          for (int i = 0; i < k - 1; i++) {
              if (pFast.next != null) {
                  pFast = pFast.next;
              } else { // 后续无元素。链表节点总数 n < k  (k 指定的数字较大) 这里的else 容易忽略。
                  return null;
              }
          }

          while (pFast.next != null) { // pFast 走到链表的结尾时，pSlow正好走到 n-k+1 处。正好为链表的倒数第k个节点。
              pFast = pFast.next;
              pSlow = pSlow.next;
          }
          return pSlow;
      }

```