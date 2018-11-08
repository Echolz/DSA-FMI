package Day_5;

import util.TextWriter;

import java.io.IOException;
import java.util.*;

public class Solution {
    private static Set<Character> opening = new HashSet<>();
    private static Map<Character, Character> parenthesis = new HashMap<>();

    public static void main(String[] args) throws IOException {
        init();

        TextWriter textWriter = new TextWriter();
        Scanner scanner = new Scanner(System.in);
        String expression = GenerateCustomExpression.getExpression();
        textWriter.printIn(expression);
        if (isValidExpression(expression)) {
            System.out.println("true");
            System.out.println(expression.length() / 2);
        } else {
            textWriter.printOut("false");
            textWriter.printOut(generateCorrectExpression(expression));
        }

        textWriter.closeWriter();
    }

    private static String generateCorrectExpression(String expression) {
        Stack<Character> stack = new Stack<>();
        LinkedList<Character> linkedList = new LinkedList<>();

        for (int i = 0; i < expression.length(); i++) {
            Character currentBracket = expression.charAt(i);
            if (isOpening(currentBracket)) {
                stack.push(currentBracket);
                continue;
            }

            if (stack.isEmpty()) {
                linkedList.addLast(parenthesis.get(currentBracket));
                linkedList.addLast(currentBracket);
                continue;
            }

            boolean foundOpposite = false;

            while (!stack.isEmpty()) {
                Character lastOpening = stack.pop();

                if (currentBracket == parenthesis.get(lastOpening)) {
                    linkedList.addFirst(lastOpening);
                    linkedList.addLast(currentBracket);
                    foundOpposite = true;
                    break;
                }

                linkedList.addFirst(lastOpening);
                linkedList.addLast(parenthesis.get(lastOpening));
            }

            if (stack.isEmpty() && foundOpposite) {
                continue;
            }

            linkedList.addLast(parenthesis.get(currentBracket));
            linkedList.addLast(currentBracket);
        }

        StringBuilder sb = new StringBuilder();

        for (Character bracket : linkedList) {
            sb.append(bracket);
        }

        return sb.toString();
    }

    private static boolean isValidExpression(String expression) {
        Stack<Character> stack = new Stack<>();
        boolean isValid = true;
        for (int i = 0; i < expression.length(); i++) {
            if (isOpening(expression.charAt(i))) {
                stack.push(expression.charAt(i));
                continue;
            }

            if (stack.isEmpty()) {
                isValid = false;
                break;
            }

            Character openingCounterPart = stack.pop();
            if (expression.charAt(i) == parenthesis.get(openingCounterPart)) {
                continue;
            }

            isValid = false;
            break;
        }

        isValid = isValid && stack.isEmpty();

        return isValid;
    }

    private static boolean isOpening(Character parenth) {
        return opening.contains(parenth);
    }

    private static void init() {
        opening.add('(');
        opening.add('{');
        opening.add('[');
        parenthesis.put('{', '}');
        parenthesis.put('[', ']');
        parenthesis.put('(', ')');
        parenthesis.put('}', '{');
        parenthesis.put(')', '(');
        parenthesis.put(']', '[');
    }
}
