import java.util.*;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        next = null;
    }
}


class Linkedlist {

    Node head;
    
    Node tail = null;

//     using tail method like insert at last
    public void insertAtFront(int data) {
        Node new_node = new Node(data);


        if(head == null) {
            head = new_node;
            tail = new_node;
        } else {
            tail.next = new_node;
            tail = new_node;
        }

    }
    
    ////////////

    public void insertAtFront(int data) {
        Node new_node = new Node(data);

        new_node.next = head;
        head = new_node;
    }


    public void printList(Node temp) {
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }


    public void insertInMiddle(Node temp, int data) {
        if (temp == null) {
            System.out.println("can't add");
            return;
        }

        Node new_node = new Node(data);
        new_node.next = temp.next;
        temp.next = new_node;

    }


    public void insertAtEnd(int data) {
        Node temp = head;

        Node new_node = new Node(data);
        new_node.next = null;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new_node;
    }

    public void deleteNode(int key) {
        Node temp = head, link = null;

        if (head != null && head.data == key) {
            head = head.next;
        }

        while (temp != null && temp.data != key) {
            link = temp;
            temp = temp.next;
        }

        link.next = temp.next;


    }
    
    ////insert element at middle
    public void insertAtMiddle(Node temp,int data) {
        Node new_node = new Node(data);

        if (head == null) {
            head = new Node(data);
            return;
        }

        Node slow = head,fast = head.next;


        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        new_node.next = slow.next;
        slow.next = new_node;
    }
    
    ////
    
    
    //////get Nth node from last
        public void findLastNthNode(Node head,int pos) {
        Node temp = head;
        int len = 0;

        while (temp != null) {
            temp = temp.next;
            len++;
        }

        if (len < pos) {
            return;
        }

        temp = head;

        for (int i = 1; i < len-pos+1; i++) {
            temp = temp.next;
        }

        System.out.println("the position of "+pos+" from the last is "+temp.data);

    }
    
    ///more optimal///
    public void lastNthnodeOpt(Node head,int pos) {
//      
        Node slow = head,fast = head;

        for (int i = 0; i < pos; i++) {
            if(slow == null) {
                return;
            }
            slow = slow.next;
        }

        while(slow != null) {
            slow = slow.next;
            fast = fast.next;
        }

        System.out.println("the last node "+pos+" is : "+fast.data);
    }

    
    ///////
    
    
    ///////////////
    
    ////rotate Node
        public Node rotateNode(Node head,int k) {
        Node temp = head;

        if (head == null || head.next == null) {
            return head;
        }

        int count = 1;

        while (temp.next != null) {
            temp = temp.next;
            count++;
        }

        temp.next = head;
        temp = head;


        k = k%count;

        for (int i = 0; i < count-k-1; i++) {
            temp = temp.next;
        }

        head = temp.next;
        temp.next = null;

        return head;
    }

    
    
    ///////
    
    
    
    
    
    
    
    //////sorted list merge
        public Node mergeTwoSortedList(Node first,Node second) {
        if (first == null) {
            return second;
        }

        if (second == null) {
            return first;
        }

        if (first.data < second.data) {
            first.next = mergeTwoSortedList(first.next,second);
            return first;
        } else {
            second.next = mergeTwoSortedList(first,second.next);
            return second;
        }
        
    }
    
    ////////
    
    
    


    public void deleteKeyUsingPosition(int pos) {
        Node temp = head;

        if (pos == 0) {
            temp = temp.next;
            return;
        }

        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }

        if (temp == null && temp.next == null) {
            return;
        }

        temp.next = temp.next.next;


    }
    
    //delete node 
    
    public void deleteNodeElement() {

        if (head == null) {
            System.out.println("list empty");
            return;
        } else {

            if (head != tail) {
                head = head.next;
            } else {
                head = tail = null;
            }
        }
    }
    
    
    ///

    public void deleteNode() {
        head = null;
    }

    public int findLength(Node temp) {
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    public int findLengthRec(Node temp) {
        if (temp == null) {
            return 0;
        }

        return findLengthRec(temp.next) + 1;
    }

    /////////////
     public Node addTwoSum(Node first,Node second) {
        Node res = null,prev = null,temp = null;
        int sum = 0,carry = 0;

        while (first != null || second != null) {

            sum = carry+(first != null ? first.data : 0)+(second != null ? second.data : 0);
            carry = (sum >= 10) ? 1 : 0;
            sum %= 10;

            temp = new Node(sum);

            if (res == null) {
                res = temp;
            } else {
                prev.next = temp;
            }

            prev = temp;

            if (first != null) {
                first = first.next;
            }

            if (second != null) {
                second = second.next;
            }


        }

        if (carry > 0) {
            temp.next = new Node(carry);
        }

        return res;
    }
    /////////////
    
    public Node removeNodeFromLast(Node head,int key) {
        Node slow = head,fast = head;

        while (fast != null) {
            if (key-- < 0) {
                slow = slow.next;
            }
            fast = fast.next;
        }

        if (key < 0) {
            slow.next = slow.next.next;
        } else {
            head = head.next;
        }


        return head;
    }
    
    
    
    public void search(int key) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == key) {
                System.out.println("key found");
                return;
            }
            temp = temp.next;
        }
    }

    public boolean searchUsingRec(Node head, int key) {
        if (head == null) {
            return false;
        }

        if (head.data == key) {
            return true;
        }

        return searchUsingRec(head.next, key);
    }


    public void findIndex(Node temp, int key) {
        int pos = 0;

        while (temp != null) {
            if (pos == key) {
                System.out.println("the node at index " + key + " is " + temp.data);
                return;
            }
            pos++;
            temp = temp.next;
        }
    }


    public int findIndexRec(Node temp, int key) {
        if (temp == null) {
            return -1;
        }

        int count = 0;

        if (count == key) {
            return temp.data;

        }

        return findIndexRec(temp.next, key - 1);
    }

    public void findMiddleList(Node temp) {
        Node slow = head;
        Node fast = head;

        if (head != null) {
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            System.out.println("the middle of the linked list is " + slow.data);
        }
    }
    
    //////delete middle element
        public Node removeMiddleElement(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node slow = head,fast = head,prev = null;

        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;

        }

            if (prev != null) {
                prev.next = slow.next;
            }
        
            return head;
    }    
    ///////
    
    
    
    
    
    
    ///////

    public void countOccu(int key) {
        int count = 0;

        while (head != null) {
            if (head.data == key) {
                count++;

            }

            head = head.next;
        }

        System.out.println("the " + key + " is repeated " + count);
    }

    public boolean findCycle(Node head) {
        Node slow = head;
        Node fast = head;


        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }


        }
        return false;
    }


    public int findLengthOfTheLoop(Node head) {
        Node slow = head, fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;


            if (slow == fast) {
                return countLength(slow);
            }


        }


        return 0;
    }

    public int countLength(Node slow) {
        int res = 1;
        Node temp = slow;

        while (temp.next != slow) {
            res++;
            temp = temp.next;
        }

        return res;
    }

    public void removeLoop(Node temp) {
        if (temp == null || temp.next == null) {
            return;
        }

        Node slow = temp;
        Node fast = temp;

        slow = slow.next;
        fast = fast.next.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                break;
            }

            slow = slow.next;
            fast = fast.next.next;

        }

        if (slow == fast) {
            slow = temp;

            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }

            fast.next = null;
        }


    }


    public boolean checkPalindrome(Node head) {
        Stack<Integer> stack = new Stack<>();
        boolean flag = true;
        Node slow = head;

        while (slow != null) {
            stack.push(slow.data);
            slow = slow.next;
        }

        while (head != null) {
            int i = stack.pop();

            if (head.data == i) {
                flag = true;
            } else {
                flag = false;
                break;

            }
            head = head.next;

        }


        return flag;

    }

    public Node reverseKNode(Node head,int k) {
        return reverseKNodeUlti(head,k,true);
    }

    private Node reverseKNodeUlti(Node head, int k, boolean b) {
        if (head == null) {
            return null;
        }

        int count = 1;
        Node prev = null,next = null,current = head;

        while (current != null && count <= k) {
            next = current.next;


            if (b == true) {
                current.next = prev;
            }

            prev = current;
            current = next;
            count++;
        }

        if (b == true) {
            head.next = reverseKNodeUlti(current,k,!b);
            return prev;
        }

        prev.next = reverseKNodeUlti(current,k,!b);

            return head;

    }

    public void removeDupInSorted(Node head) {

        while (head != null) {
            Node temp = head;

            while (temp != null && temp.data == head.data) {
                temp = temp.next;
            }

            head.next = temp;
            head = head.next;

        }
    }

    public void removeDupInUnSorted(Node head) {
        HashSet<Integer> set = new HashSet<>();

        Node curr = head,prev = null;

        while (curr != null) {
            int val = curr.data;

            if (set.contains(val)) {
                prev.next = curr.next;
            } else {
                set.add(val);
                prev = curr;
            }

            curr = curr.next;
        }
    }

     //remove duplicate using two iteration
     public void removeDupLI(Node head) {
        Node temp = head,prev;

        while (temp != null && temp.next != null) {
            prev = temp;

            while (prev.next != null) {
                if (temp.data == prev.next.data) {

                    prev.next = prev.next.next;

                } else {
                    prev = prev.next;
                }
            }
            temp = temp.next;
        }
    }

    ///////////

    public void swapNode(Node head,int x,int y) {

        Node temp = head;
        Node a = null,b = null;

        while (temp.next != null) {
            if (temp.next.data == x) {
                a = temp;
            } else if (temp.next.data == y) {
                b = temp;
            }
            temp = temp.next;
        }
        

        if (a != null && b != null) {
            Node cur = a.next;
            a.next = b.next;
            b.next = cur;

            cur = a.next.next;
            a.next.next = b.next.next;
            b.next.next = cur;

        }

    }


    public void pairWiseSwap(Node head) {
        Node temp = head;

        while (temp != null && temp.next != null) {
            int k = temp.data;

            temp.data = temp.next.data;
            temp.next.data = k;
            temp = temp.next.next;


        }




    }


    public void lastFront() {
        Node current = head;
        Node swap = null;

        while (current.next != null) {
            swap = current;
            current = current.next;
        }

        swap.next = null;
        current.next = head;
        head = current;
    }

    public Node intersectionList(Node head,Node head1) {
        int a_length = getLength(head);
        int b_length = getLength(head1);
        int d = b_length - a_length;

        Node A = head;
        Node B = head1;

        if(a_length > b_length) {
            Node temp = A;
            A = B;
            B = temp;
            d = a_length - b_length;
        }

        for(int i=0; i<d; i++) {
            B = B.next;
        }

        while(A != null && B != null) {
            if(A == B) {
                return A;
            }
            A = A.next;
            B = B.next;
        }

        return null;
        }

    public int getLength(Node a) {
        int count = 0;
        Node b = a;

        while(b != null) {
            count++;
            b = b.next;
        }

        return count;
    }
    
    public Node removeElementUsingKey(Node head,int key) {

        while (head != null && head.data == key) {
            head = head.next;
        }

        Node temp = head;

        while (temp != null && temp.next != null) {
            if (temp.next.data == key) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return head;
    }
    
     ////// using stack
     public Node addTwoSum(Node first,Node second) {
        Node prev = null,res = null,new_node = null;
        int carry = 0;

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (first != null) {
            s1.push(first.data);
            first = first.next;
        }

        while (second != null) {
            s2.push(second.data);
            second = second.next;
        }

        while (!s1.isEmpty() || !s2.isEmpty()) {

            int a = 0,b = 0;

            if (!s1.isEmpty()) {
                a = s1.pop();
            }

            if (!s2.isEmpty()) {
                b = s2.pop();
            }

            int total = a+b+carry;

            new_node = new Node(total%10);
            carry = total/10;

            if (res == null) {
                res = new_node;
            } else {
                new_node.next = res;
                res = new_node;
            }

        }

        if (carry != 0) {
            new_node = new Node(carry);
            new_node.next = res;
            res = new_node;
        }

        return res;
    }
    
    
    
    /// delete all occ using rec
     public ListNode removeElements(ListNode head, int val) {
        
        if(head == null) {
            return head;
        }
        
        head.next = removeElements(head.next,val);
        
        return head.val == val ? head.next : head;
  
  
       
    }
    
    //////
    
    ////delete all occc using itr 
      public void deleteAllOccu(int key) {
        while (head != null && head.data == key) {
            head = head.next;
        }

        Node temp = head;

        while (temp != null && temp.next != null) {
            if (temp.next.data == key) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

    }
    
    ////
    
    
    // delete all occurrence
    public LLNode solve(LLNode node, int target) {
        LLNode dummy = new LLNode();
        dummy.next = node;
        LLNode temp = dummy;
        while (temp.next != null) {
            if (temp.next.val == target) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummy.next;
    }
    
    
    ////
    
    
    
    
    


} // end of linkedlist


public class Demo {
    public static void main(String[] args) {
        Linkedlist link = new Linkedlist();
//        Linkedlist link2 = new Linkedlist();
        link.insertAtFront(5);
        link.insertAtFront(4);
        link.insertAtFront(3);
        link.insertAtFront(2);
        link.insertAtFront(1);
//        link2.insertAtFront(2);
//        link2.insertAtFront(3);
//        link2.insertAtFront(4);
//        link2.insertAtFront(5);

//        link.insertAtEnd(6);
//        link.deleteNode(2);
//        System.out.println("length of the node = "+link.findLength(link.head));
//        System.out.println("length of the node = "+link.findLengthRec(link.head));
//        link.search(10);
//        if (link.searchUsingRec(link.head,1)) {
//            System.out.println("key found");
//        } else {
//            System.out.println("not found key");
//        }

//            link.findIndex(link.head,3);
//        System.out.println("index 1 as the value = "+link.findIndexRec(link.head, 1));
//            link.findMiddleList(link.head);

//        link.countOccu(3);

//        if(link.findCycle(link.head.next = link.head)) {
//            System.out.println("cycle detected");
//        } else {
//            System.out.println("no cycle detected");
//        }

//        System.out.println("the length of the loop = "+link.findLengthOfTheLoop(link.head.next.next = link.head));
//        link.head.next.next.next.next.next = link.head.next;
//            link.removeLoop(link.head);

//        boolean check = link.checkPalindrome(link.head);
//        System.out.println(check);

//           link.head = link.reverseKNode(link.head,3);
//            link.removeDupInSorted(link.head);
//        link.removeDupInUnSorted(link.head);

//        link.swapNode(link.head,3,5);

//        link.pairWiseSwap(link.head);

//        link.lastFront();

//            Node inter = link.intersectionList(link.head,link2.head);
        
        
        /// deleteNode list by loop
         while (list.head != null) {
            list.deleteNodeElement();

            System.out.println("modified list");

            list.printList();
        }
        
        
        ////
        
        



        link.printList(link.head);


    }


}
