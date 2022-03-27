package cn.lemon.march;

public class ReverseLink {

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

    public static void main(String[] args) {
        Node node5 = new Node(5, null);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
//        Node newHead = iterateReverse(node1);
        Node newHead = recursionReverse(node1);
    }

    /**
     * 使用递归的方式实现链表的反转
     * @param head
     * @return
     */
    public static Node recursionReverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = recursionReverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 使用迭代的方式实现链表的反转
     * @param head
     * @return
     */
    public static Node iterateReverse(Node head) {
        Node curr = head;
        Node prev = null, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
