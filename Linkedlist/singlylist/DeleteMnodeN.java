//references
//https://www.geeksforgeeks.org/delete-n-nodes-after-m-nodes-of-a-linked-list/



class DeleteutilOpe {

    Node head;

    public void deleteMandN(Node head,int m,int n) {
        Node curr = head,store = null;
        int count = 0;

        while(curr != null) {

            for (count = 1;count < m && curr != null;count++) {
                curr = curr.next;
            }

            if (curr == null) {
                return;
            }

            store = curr.next;

            for (count = 1;count <= n && store != null;count++) {
                store = store.next;
            }

            curr.next = store;
            curr = store;
        }



    }



}


public class DeleteMnodeN {

    public static void main(String[] args) {
        Linkedlist list = new Linkedlist();
        DeleteutilOpe delete = new DeleteutilOpe();

        for (int i = 1; i <= 8; i++) {
            list.insertAtFront(i);
        }

        list.printList(list.head);

        delete.deleteMandN(list.head,2,3);

        list.printList(list.head);


    }


}
