public class StockSpan {

    public static void main(String[] args) {
        int[] price = {10,4,5,90,120,80};
        findStockSpan(price);
    }

    private static void findStockSpan(int[] prices) {
        StacksInternal<Integer> stack = new StacksInternal<Integer>(5);
        int[] res = new int[prices.length];
        stack.push(0);
        res[0] = 1;

        for (int i = 1; i < prices.length; i++) {

            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            res[i] = (stack.isEmpty()) ? (i+1) : (i-stack.peek());

            stack.push(i);
        }

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }

    }


}
