class Dlll {
    int data;
    Dlll next,prev;

    public Dlll(int data) {
        this.data = data;
        next = prev = null;
    }

}

class Stackss {

    Dlll head,tail;

    public Stackss() {
        head = null;
        tail = null;
    }

    public void push(int data) {
        Dlll new_node = new Dlll(data);

        if(head == null) {
            head = new_node;
            head.prev = null;
            head.next = null;
            tail = new_node;
        } else {
            new_node.prev = tail;
            tail.next = new_node;
            tail = new_node;
        }

//        System.out.println(data+" is pushed into stack");
    }

    public void pop() {
        if(head == null) {
            System.out.println("stack underflow");
            System.exit(1);
        }

        if(head == tail) {
            head = null;
            tail = null;
        } else {
            Dlll node = tail;
            tail = tail.prev;
            node.next = null;
            node.prev = null;
//            System.out.println(node.data+" is popped from stack");
        }


    }

    public void merge(Stackss s) {
        head.prev = s.tail;
        s.tail.next = head;
        head = s.head;
        s.head = null;
        s.tail = null;
    }

    public void display() {
        if(tail != null) {
            Dlll curr = tail;

            while(curr != null) {
                System.out.print(curr.data+" ");
                curr = curr.prev;
            }

        } else {
            System.out.println("stack underflow");
            System.exit(1);
        }
    }


}



public class MergeableStack {

    public static void main(String[] args) {
        Stackss stack1 = new Stackss();
        Stackss stack2 = new Stackss();
        stack1.push(6);
        stack1.push(5);
        stack1.push(4);
        stack2.push(9);
        stack2.push(8);
        stack2.push(7);

        stack1.merge(stack2);
        stack1.display();




    }



}
