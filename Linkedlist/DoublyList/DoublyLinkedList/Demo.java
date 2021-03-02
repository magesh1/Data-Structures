import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Node {
    int data;
    Node next,prev;
    public Node(int data) {
        this.data = data;
        next = prev = null;
    }
}

class LinkedList {

        Node head;

        public void insertAtFront(int data) {
            Node new_node = new Node(data);
            new_node.next = head;
            new_node.prev = null;

            if (head != null) {
                head.prev = new_node;
            }

            head = new_node;
        }

        public void printList(Node head) {
            while (head != null) {
                System.out.print(head.data + " ");
                head = head.next;
            }
        }
    
    
        public void insertAtMiddle(Node curr,int data) {
            if (head == null) {
                System.out.println("cannot add list empty");
                return;
            }

            Node new_node = new Node(data);

            new_node.next = curr.next;
            curr.next = new_node;
            new_node.prev = curr;

            if (new_node.next != null) {
                new_node.next.prev = curr;
            }
        }
    
         public void insertAtLast(int data) {
            Node new_node = new Node(data);
            new_node.next = null;

            if (head == null) {
                new_node.prev = null;
                head = new Node(data);
                return;
            }

            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = new_node;
            new_node.prev = temp;
        }
    
         public void deleteNode(Node dele) {
            if (head == null || dele == null) {
                return;
            }

            if (head == dele) {
                head = dele.next;
            }

            if (dele.next != null) {
                dele.next.prev = dele.prev;
            }

            if (dele.prev != null) {
                dele.prev.next = dele.next;
            }

        }
    
        public void reverseList() {
            Node current = head,temp = null;

            while (current != null) {
                temp = current.prev;
                current.prev = current.next;
                current.next = temp;
                current = current.prev;
            }

            if (temp != null) {
                head = temp.prev;
            }
            
        }
    
        /// reverse list using stack
        public void reverse() {
            Stack<Integer> stack = new Stack<>();
            Node temp = head;

            while (temp != null) {
                stack.add(temp.data);
                temp = temp.next;
            }

            temp = head;

            while (temp != null) {
                temp.data = stack.pop();
                temp = temp.next;
            }
        }
        ////
    
        /// sort the doubly linked list
           public Node insertElementAtSort(Node head,Node new_node) {
            Node temp = head;

            if (head == null) {
                head = new_node;
            } else if (head.data >= new_node.data){
                new_node.next = head;
                new_node.next.prev = new_node;
                head = new_node;
            } else {
                while (temp.next != null && temp.next.data < new_node.data) {
                    temp = temp.next;
                }
                new_node.next = temp.next;

                if (temp.next != null) {
                    new_node.next.prev = new_node;
                }

                temp.next = new_node;
                new_node.prev = temp;

            }
            return head;
        }
    
        ////get the element 
          public Node getNode(int data) {
            Node new_node = new Node(data);
            new_node.prev = new_node.next = null;
            return new_node;
        }
    
       ///
    
    ///main method for sorted list
        Node new_node = list.getNode(8);
        list.head = list.insertElementAtSort(list.head,new_node);
        new_node = list.getNode(5);
        list.head = list.insertElementAtSort(list.head,new_node);
        new_node = list.getNode(3);
        list.head = list.insertElementAtSort(list.head,new_node);
        new_node = list.getNode(12);
        list.head = list.insertElementAtSort(list.head,new_node);
        new_node = list.getNode(10);
        list.head = list.insertElementAtSort(list.head,new_node);
        new_node = list.getNode(9);
        list.head = list.insertElementAtSort(list.head,new_node);  
    /////
    ////// end of sorted list
    
    
    ////delete node at given position
        public void deleteNodeUsingPosition(int pos) {
            Node temp = head;

            if (head == null) {
                return;
            }

            for (int i = 1;temp.next != null && i < pos; i++) {
                temp = temp.next;
            }

            deleteNodeUlti(temp);

        }

       private Node deleteNodeUlti(Node del) {
        if (head == del) {
            head = del.next;
        }
        //deleted the node not in last position
        if (del.next != null) {
            del.next.prev = del.prev;
        }
        //deleted the node not in first position
        if (del.prev != null) {
            del.prev.next = del.next;
        }

        del = null;
        return head;
    }

    
    ////
    
    ///delete dup in sorted list
        public void deleteDupInSorted() {
            Node temp = head;

            while (temp.next != null) {
                if (temp.data == temp.next.data) {
                    deleteNodeSorted(head,temp.next);
                } else {
                    temp = temp.next;
                }
            }



        }

    private void deleteNodeSorted(Node head, Node del) {
            if (head == null) {
                return;
            }

            if (head == del) {
                head = del.next;
            }

            if (del.next != null) {
                del.next.prev = del.prev;
            }

            if (del.prev != null) {
                del.prev.next = del.next;
            }

    }
    
    ////
    
    ///delete all occurrence
        public Node deleteAllOccu(Node head,int x) {
            Node temp = head,next = null;

            while (temp != null) {
                if (temp.data == x) {
                    next = temp.next;
                    head = deleteCurrentElement(head,temp);
                    temp = next;
                } else {
                    temp = temp.next;
                }
            }

            return head;
        }

    private Node deleteCurrentElement(Node head, Node temp) {
        if (head == temp) {
            head = temp.next;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }


        return head;
    }
    
    ///
    
    ///delete dup in unsorted list
         public Node deleteDupInUnSortedList() {
            Set<Integer> set = new HashSet<>();
            Node curr = head,next = null;

            while (curr != null) {
                if (set.contains(curr.data)) {
                    next = curr.next;
                    head = deleteCurrentElement(head,curr);
                    curr = next;
                } else {
                    set.add(curr.data);
                    curr = curr.next;
                }

            }


            return head;
        }



    private Node deleteCurrentElement(Node head, Node temp) {
        if (head == temp) {
            head = temp.next;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }


        return head;
    }
    ////






} // end of linked list


public class Demo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        for (int i = 1; i <= 6; i++) {
            list.insertAtFront(i);
        }

        list.printList(list.head);







    }

}

