import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NGE1 {

    public static void main(String[] args) {
        int[] n1 = {2,4,1};
        int[] n2 = {1,2,3,4};
        findGreaterElements(n1, n2);
    }

    private static void findGreaterElements(int[] n1,int[] n2) {
        Stack<Integer> stack = new Stack<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] res = new int[n1.length];

        for(int num : n2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(),num);
            }
            stack.push(num);
        }

        int i = 0;

        for(int n : n1) {
            res[i++] = map.getOrDefault(n,-1);
        }

        printList(res);

    }

    private static void printList(int[] res) {
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }


}
