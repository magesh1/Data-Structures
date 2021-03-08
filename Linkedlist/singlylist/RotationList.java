class RotationUtil {

    Node head;

    public Node rotateList(Node head,int k) {

        if(k <= 0) {
            return null;
        }

        Node curr = head;

        for(int count = 1;count < k && curr != null;count++) {
            curr = curr.next;
        }

        if(curr == null) {
            return null;
        }

        Node kthNode = curr;

        while(curr.next != null) {
            curr = curr.next;
        }

        curr.next = head;
        head = kthNode.next;
        kthNode.next = null;


        return head;
    }


}



public class RotationList {

    public static void main(String[] args) {
        RotationUtil rotation = new RotationUtil();
        Linkedlist list = new Linkedlist();

        for (int i = 1; i <= 6; i++) {
            list.insertAtFront(i);
        }

        list.printList(list.head);

        Node head = rotation.rotateList(list.head,2);

        list.printList(head);

    }


}
