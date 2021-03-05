class Oper {

    public Node mergeSort(Node head) {

        if(head == null || head.next == null) {
            return head;
        }

        Node mid = getMid(head);
        Node midToNext = mid.next;
        mid.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(midToNext);

        return sorted(left,right);
    }

    private Node getMid(Node head) {

        if(head == null) {
            return null;
        }
        Node slow = head,fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node sorted(Node left,Node right) {
        Node result = null;

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        if (left.data <= right.data) {
            result = left;
            result.next = sorted(left.next,right);
        } else {
            result = right;
            result.next = sorted(left,right.next);
        }
        return result;
    }


}





public class MergeSort {

    public static void main(String[] args) {
        Oper op = new Oper();
        Linkedlist list = new Linkedlist();

        list.insertAtFront(3);
        list.insertAtFront(12);
        list.insertAtFront(1);
        list.insertAtFront(-4);
        list.insertAtFront(0);

        list.printList(list.head);

        Node head = op.mergeSort(list.head);

        list.printList(head);


    }




}
