package Day_5;

import util.TextWriter;

import java.util.ArrayList;
import java.util.List;

public class GenerateCustomExpression {
    private static List<Character> parenth;

    public static String getExpression() {
        StringBuilder expression = new StringBuilder();
        init();
        for (int i = 0; i < 900000; i++) {
            expression.append(parenth.get(TextWriter.getRandomNumberInRange(0, 5)));
        }
        return expression.toString();
    }

    private static void init() {
        parenth = new ArrayList<>();
        parenth.add('(');
        parenth.add('{');
        parenth.add('[');
        parenth.add(')');
        parenth.add(']');
        parenth.add('}');
    }
}
