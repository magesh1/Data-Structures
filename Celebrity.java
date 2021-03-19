import java.util.Stack;

public class Celebrity {

    static int[][] matrix = {
            {0,0,1,0},
            {0,0,1,0},
            {0,0,0,0},
            {0,0,1,0}
    };

    public static void main(String[] args) {
        int num = 4;
        int res = findCelebrity(num);
        if (res == -1) {
            System.out.println("no celebrity");
        } else {
            System.out.println("celebrity = " + res);
        }
    }

    private static int findCelebrity(int num) {
        Stack<Integer> stack = new Stack<Integer>();
        int c = 0;

        for (int i = 0; i < num; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();

            if (knowsCelebrity(a,b)) {
                stack.push(b);
            } else {
                stack.push(a);
            }

        }

        if (stack.isEmpty()) {
            return -1;
        }

        c = stack.pop();

        for (int i = 0; i < num; i++) {
            if (i != c && (knowsCelebrity(c,i) || (!knowsCelebrity(i,c)))) {
                return -1;
            }
        }

        return c;
    }

    private static boolean knowsCelebrity(int a, int b) {
        return matrix[a][b] == 1;
    }


}
