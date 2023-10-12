class Solution {

    private static ArrayList<Character> originalOps = new ArrayList<>();
    private static ArrayList<String> splitedExpr = new ArrayList<>();
    private static HashMap<Character, Integer> opsMap = new HashMap<>();
    private static long maximum = -1;
    public long solution(String expression) {
        long answer = 0;
        setting(expression);
        ArrayList<Character> ops = new ArrayList<>(opsMap.keySet());
        ArrayList<Integer> orders = new ArrayList<>();
        orderDfs(0, ops, orders);
        answer = maximum;
        return answer;
    }
    private static void setting(String expr) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<expr.length();i++) {
            char curr = expr.charAt(i);
            if(curr-'0' >= 0 && curr-'0' <= 9) sb.append(curr);
            else {
                originalOps.add(curr);
                splitedExpr.add(sb.toString());
                splitedExpr.add(String.valueOf(curr));
                sb = new StringBuilder();
                opsMap.putIfAbsent(curr, 0);
            }
        }
        splitedExpr.add(sb.toString());
    }
    private static void orderDfs(
            int idx,
            ArrayList<Character> ops,
            ArrayList<Integer> orders
    ) {
        if (idx == ops.size()) {
            calculator(ops, orders);
            return;
        }
        for(int i=0;i<ops.size();i++) {
            if (orders.contains(i)) continue;
            orders.add(i);
            orderDfs(idx+1, ops, orders);
            orders.remove(Integer.valueOf(i));
        }
    }
    private static void calculator(
            ArrayList<Character> ops,
            ArrayList<Integer> orders
    ) {
        for(int i=0;i<ops.size();i++) {
            opsMap.put(ops.get(i), orders.get(i));
        }
        ArrayDeque<String> queue1 = new ArrayDeque<>(splitedExpr);
        ArrayDeque<String> queue2 = new ArrayDeque<>();
        String num1 = "0", op, num2;
        for(int i=0;i<ops.size();i++) {
            num1 = queue1.pollFirst();
            while(!queue1.isEmpty()) {
                op = queue1.pollFirst();
                num2 = queue1.pollFirst();
                if(i == opsMap.get(op.charAt(0))) {
                    long n1 = Long.parseLong(num1);
                    long n2 = Long.parseLong(num2);
                    if (op.equals("*")) {
                        num1 = String.valueOf(n1*n2);
                    } else if (op.equals("+")) {
                        num1 = String.valueOf(n1+n2);
                    } else {
                        num1 = String.valueOf(n1-n2);
                    }
                } else {
                    queue2.offerLast(num1);
                    queue2.offerLast(op);
                    num1 = new String(num2);
                }
            }
            String last = queue2.peekLast();
            if (last != null && (last.equals("*") || last.equals("-") || last.equals("+"))) queue2.offerLast(num1);
            queue1 = queue2;
            queue2 = new ArrayDeque<>();
        }
        long result = Math.abs(Long.parseLong(num1));
        maximum = maximum < result ? result : maximum;
    }

}