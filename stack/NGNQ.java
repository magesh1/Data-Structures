import java.util.Stack;

public class NGNQ {

    public static void main(String[] args) {
        int[] arr = {3,4,2,7,5,8,10,6};
        int[] query = {3,6,1};
        int[] res = findQuery(arr, query);

        printAns(res,query);


    }

    private static void printAns(int[] res,int[] query) {
        for (int i = 0; i < query.length; i++) {
            System.out.print(res[query[i]]+" ");
        }
    }

    private static int[] findQuery(int[] arr, int[] query) {
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(arr[0]);

        int j = 0;

        for (int i = 1; i < arr.length; i++) {
            int next = arr[i];

            if (!stack.isEmpty()) {
                int element = stack.pop();

                while(next > element) {
                    res[j] = next;
                    j++;
                    if (stack.isEmpty()) {
                        break;
                    }
                    element = stack.pop();
                }

                if (element > next) {
                    stack.push(element);
                }

            }
                stack.push(next);
        }

        while(!stack.isEmpty()) {
            stack.pop();
            res[j] = -1;
            j++;
        }

        return res;
    }


}
