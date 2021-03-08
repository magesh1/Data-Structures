class DeleteUtil {

    Node head;

    public void deleteLastOcc(Node head,int x) {
        Node temp = head,ptr = null;

        while(temp != null) {
            if (temp.data == x) {
                ptr = temp;
            }
            temp = temp.next;
        }

        if(ptr != null && ptr.next == null) {
            temp = head;

            while(temp.next != ptr) {
                temp = temp.next;
            }

            temp.next = null;
        }

        if(ptr != null && ptr.next != null) {
            ptr.data = ptr.next.data;
//            temp = ptr.next;
            ptr.next = ptr.next.next;

        }


    }



}







public class DeletelastOcc {

    public static void main(String[] args) {
        Linkedlist list = new Linkedlist();
        DeleteUtil delete = new DeleteUtil();

        list.insertAtFront(1);
        list.insertAtFront(2);
        list.insertAtFront(-2);
        list.insertAtFront(2);
        list.insertAtFront(3);
        list.insertAtFront(4);
        list.insertAtFront(-2);



        list.printList(list.head);

        delete.deleteLastOcc(list.head,-2);

        list.printList(list.head);


    }




}
