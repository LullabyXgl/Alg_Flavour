package cn.lemon.march;

public class DelNode {

    public static void main(String[] args) {
        Node head = new Node(4);
        Node node1 = new Node(5);
        Node node2 = new Node(1);
        Node node3 = new Node(9);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        System.out.println("======删除指定节点======");
        deleteNode(node2);
        Node ListHead = new Node(1);
        Node ListNode1 = new Node(1);
        Node ListNode2 = new Node(2);
        Node ListNode3 = new Node(3);
        Node ListNode4 = new Node(3);
        Node ListNode5 = new Node(5);
        ListHead.next = ListNode1;
        ListNode1.next = ListNode2;
        ListNode2.next = ListNode3;
        ListNode3.next = ListNode4;
        ListNode4.next = ListNode5;
        Node ListHeadNew = deleteDuplicates(ListHead);
        System.out.println("======删除重复节点======");
    }

    /**
     * 编写一个函数，用于删除单链表中某个特定节点 。
     * 在设计函数时需要注意，你无法访问链表的头节点head，只能直接访问要被删除的节点
     * 需要删除的节点**不是末尾节点**
     */
    public static void deleteNode(Node node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 给定一个**已排序**的链表的头head，删除所有重复的元素，使每个元素只出现一次。
     * 返回已排序的链表
     */
    public static Node deleteDuplicates(Node head) {
        Node cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static class Node {
        int val;
        Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
