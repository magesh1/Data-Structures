class QueueOpe {
    private int[] arr;
    private int capacity;
    private int front,rear,size;

    public QueueOpe(int capacity) {
        this.capacity = capacity;
        front = size = 0;
        arr = new int[capacity];
        rear = capacity - 1;

    }

    public boolean isEmpty(QueueOpe queue) {
        return queue.size == 0;
    }

    public boolean isFull(QueueOpe queue) {
        return queue.size == queue.capacity;
    }

    public void enQueue(int item) {
        if(isFull(this)) {
            System.out.println("queue is full");
            return;
        }

        rear = (rear+1)%capacity;
        arr[rear] = item;
        size = size+1;

        System.out.println(item+" is pushed into queue");

    }

    public void deQueue() {
        if (isEmpty(this)) {
            System.out.println("queue is empty");
            return;
        }

        int item = arr[front];
        front = (front+1)%capacity;
        size = size-1;
        System.out.println(item+" is popped from queue");
    }

    public void isFront() {
        if(isEmpty(this)) {
            System.out.println("queue is empty");
            return;
        }
        System.out.println(arr[front]);
    }

    public void isBack() {
        if (isEmpty(this)) {
            System.out.println("queue is empty");
            return;
        }
        System.out.println(arr[rear]);
    }





}



public class Queuee {

    public static void main(String[] args) {
        QueueOpe queue = new QueueOpe(5);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.deQueue();
        queue.deQueue();
        queue.isFront();
        queue.isBack();





    }


}
