package E_5_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ExpressionsParser {
    private static Map<String, Integer> operationToPriority = initMap();

    public static void main(String[] args) {
        System.out.println(infixToPostfix("(120 + 130 / 140  * (150 + 5) - 2)"));
    }

    public static String infixToPostfix(String infixExpression) {
        Stack<String> stack = new Stack<>();
        StringBuilder postFix = new StringBuilder();

        for (int i = 0; i < infixExpression.length(); i++) {
            if (infixExpression.charAt(i) == ' ') {
                continue;
            }

            String currentChar = String.valueOf(infixExpression.charAt(i));

            // this means the char is not an operation
            if (!operationToPriority.containsKey(currentChar)) {
                int index = i;

                while (index < infixExpression.length() && !operationToPriority.containsKey(String.valueOf(infixExpression.charAt(index))) && !String.valueOf(infixExpression.charAt(index)).equals(" ")) {
                    postFix.append(infixExpression.charAt(index));
                    index ++;
                }

                postFix.append(" ");

                i = index - 1;

                continue;
            }

            int operationPriority = operationToPriority.get(currentChar);

            if (operationPriority == -1) {
                stack.add(currentChar);
                continue;
            }

            if (operationPriority == -2) {
                while (operationToPriority.get(stack.peek()) != -1) {
                    postFix.append(stack.pop()).append(" ");
                }

                stack.pop();
                continue;
            }

            while (!stack.isEmpty() && operationToPriority.get(stack.peek()) >= operationPriority) {
                postFix.append(stack.pop()).append(" ");
            }

            stack.add(currentChar);

        }

        while (!stack.isEmpty()) {
            postFix.append(stack.pop()).append(" ");
        }

        postFix.setLength(postFix.length() - 1);

        return postFix.toString();
    }

    private static Map<String, Integer> initMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("+", 1);
        map.put("-", 1);
        map.put("*", 2);
        map.put("/", 2);
        map.put("(", -1);
        map.put(")", -2);
        return map;
    }
}
