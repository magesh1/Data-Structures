class Stackarr {

    private int[] arr;
    private int[] top;
    private int[] next;
    private int n,k,free;

    public Stackarr(int k1,int n1) {
        k = k1;
        n = n1;

        arr = new int[n];
        top = new int[k];
        next = new int[n];
        
        // Initialize all stacks as empty 
        for (int i = 0; i < k; i++) {
            top[i] = -1;
        }

        // Initialize all spaces as free 
        free = 0;

        for (int i = 0; i < n-1; i++) {
            next[i] = i+1;
        }

        next[n-1] = -1; // -1 is used to indicate end of free list

    }

    public boolean isFull() {
        return free == -1;
    }

    public void push(int item,int stacknum) {
        if (isFull()) {
            System.out.println("stack is overflow");
            System.exit(1);
        }

        int i = free; // Store index of first free slot
        free = next[i];  // Update index of free slot to index of next slot in free list
        next[i] = top[stacknum]; // Update next of top and then top for stack number 'stacknumber'
        top[stacknum] = i;

        // Put the item in array 
        arr[i] = item;
    }

    public int pop(int stacknum) {
        if (isEmpty(stacknum)) {
            System.out.println("stack underflow");
            System.exit(1);
        }
        
        // Find index of top item in stack number 'sn'
        int i = top[stacknum];
        // Change top to store next of previous top
        top[stacknum] = next[i];     
        // Attach the previous top to the beginning of free list 
        next[i] = free;
        free = i;

        return arr[i]; // Return the previous top item
    }

    public boolean isEmpty(int stacknum) {
        return top[stacknum] == -1;
    }


}




public class Kstack {

    public static void main(String[] args) {
        
        //create 3 stack with 10 numbers
        int k = 3,n = 10;
 
        Stackarr arr = new Stackarr(k,n);
        
        arr.push(11,0);
        arr.push(9,0);
        arr.push(12,0);

        arr.push(21,1);
        arr.push(22,1);
        arr.push(23,1);

        arr.push(31,2);
        arr.push(34,2);
        arr.push(36,2);
        arr.push(38,2);

        System.out.println(arr.pop(0)+" is popped from stack0");
        System.out.println(arr.pop(1)+" is popped from stack1");
        System.out.println(arr.pop(2)+" is popped from stack2");





    }



}
