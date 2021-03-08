class RevUtil {

    Node head;

    public Node reverseInGroup(Node head,int value) {

        if(head == null) {
            return null;
        }

        Node current = head;

        Node temp = null,prev = null;
        int count = 0;

        while(count < value && current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
            count++;
        }

        if (temp != null) {
            head.next = reverseInGroup(temp,value);
        }


        return prev;
    }

}




public class ReverseInGroup {

    public static void main(String[] args) {
        RevUtil rev = new RevUtil();
        Linkedlist list = new Linkedlist();

        for (int i = 1; i <= 7; i++) {
            list.insertAtFront(i);
        }

        list.printList(list.head);

        Node head = rev.reverseInGroup(list.head,6);

        list.printList(head);






    }










}
