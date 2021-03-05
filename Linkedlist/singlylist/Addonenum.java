class AddOp {
    Node head;

    public Node addOne(Node head) {
        head = reverse(head);

        head = addOneUtil(head);

        return reverse(head);

    }


    public Node reverse(Node head) {
        Node curr = head,prev = null;

        while(curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    public Node addOneUtil(Node head) {
        int carry = 1,sum = 0;
        Node res = head,temp = null,prev = null;

        while(head != null) {
            sum = carry+head.data;

//            System.out.println("sum = "+sum);

            carry = (sum >= 10) ? 1 : 0;

//            System.out.println("carry = "+carry);

            sum = sum % 10;

//            System.out.println("sum after mod = "+sum);

            head.data = sum;

//            System.out.println("head data after sum = "+head.data);

            temp = head;
            head = head.next;
        }

        if(carry > 0) {
            temp.next = new Node(carry);
        }


        return res;
    }






}



public class Addonenum {

    public static void main(String[] args) {
        AddOp op = new AddOp();
        Linkedlist list = new Linkedlist();

        list.insertAtFront(1);
        list.insertAtFront(0);
        list.insertAtFront(9);
        list.insertAtFront(9);

        list.printList(list.head);

        Node head = op.addOne(list.head);

        list.printList(head);

    }





}
