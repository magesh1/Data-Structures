class Dll {
    int data;
    Dll next,prev;

    public Dll(int data) {
        this.data = data;
        prev = next = null;
    }

}

class StackCreate {
    Dll head, mid;
    int count;

    public void push(StackCreate stack,int data) {
        Dll new_node = new Dll(data);

        new_node.prev = null;
        new_node.next = stack.head;
        /* Increment count of items in stack */
        stack.count += 1;

        /* Change mid pointer in two cases
           1) Linked List is empty
           2) Number of nodes in linked list is odd */
        if (stack.count == 1) {
            stack.mid = new_node;
        } else {
            stack.head.prev = new_node;
            if(stack.count % 2 != 0) {       // Update mid if stack->count is odd
                stack.mid = stack.mid.prev;
            }
        }

        stack.head = new_node;
        System.out.println(data+" is pushed into stack");
    }

    public int pop(StackCreate stack) {
        if (stack.count == 0) {
            System.out.println("stack underflow");
            return -1;
        }

        Dll head = stack.head;
        int item = head.data;
        stack.head = head.next;
        
         // If linked list doesn't become empty, update prev
        // of new head as NULL
        if (stack.head != null) {
            stack.head.prev = null;
        }

        stack.count -= 1;
        
        // update the mid pointer when we have even number of
        // elements in the stack, i,e move down the mid pointer.
        if(stack.count % 2 == 0) {
            stack.mid = stack.mid.next;
        }

        return item;
    }


    public int findMid(StackCreate stack) {
        if (stack.count == 0) {
            System.out.println("stack is empty");
            return -1;
        }
        return stack.mid.data;
    }

}


public class StackFindMid {

    public static void main(String[] args) {
        StackCreate stack = new StackCreate();
        stack.push(stack,12);
        stack.push(stack,13);
        stack.push(stack,14);
        stack.push(stack,15);
        stack.push(stack,16);
        stack.push(stack,17);

        System.out.println(stack.pop(stack)+" is popped from stack");
        System.out.println(stack.pop(stack)+" is popped from stack");

        System.out.println(stack.findMid(stack)+" is the middle element");

    }


}
