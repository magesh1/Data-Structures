import java.util.LinkedList;
import java.util.Queue;

class BtOp {

    Node root;

    public void insert(Node temp,int key) {

        if(temp == null) {
            temp = new Node(key);
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(temp);

        while (!queue.isEmpty()) {
            temp = queue.poll();

            if (temp.left == null) {
                temp.left = new Node(key);
                break;
            } else {
                queue.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = new Node(key);
                break;
            } else {
                queue.add(temp.right);
            }

        }

    }

    public void printTree(Node tree) {
        if (tree == null) {
            return;
        }

        printTree(tree.left);
        System.out.print(tree.key+" ");
        printTree(tree.right);

    }


}



public class BinaryTree {


    public static void main(String[] args) {
        BtOp bt = new BtOp();
        bt.root = new Node(10);
        bt.root.left = new Node(11);
        bt.root.right = new Node(9);
        bt.root.left.left = new Node(7);
        bt.root.right.left = new Node(15);
        bt.root.right.right = new Node(18);
        int item = 12;
        bt.insert(bt.root,item);
        bt.printTree(bt.root);
    }


}
