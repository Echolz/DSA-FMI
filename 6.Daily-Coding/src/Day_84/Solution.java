package Day_84;

import java.util.Stack;

public class Solution {
  public static void main(String[] args) {

  }

  public boolean backspaceCompare(String S, String T) {
    Stack<Character> fWord = stackFromWord(S);
    Stack<Character> sWord = stackFromWord(T);

    if (fWord.size() != sWord.size()) {
      return false;
    }

    while (!fWord.isEmpty()) {
      if (fWord.pop() != sWord.pop()) {
        return false;
      }
    }

    return true;
  }

  private Stack<Character> stackFromWord(String s) {
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char currentChar = s.charAt(i);

      if (currentChar != '#') {
        stack.add(currentChar);
        continue;
      }

      if (stack.size() == 0) {
        continue;
      }

      stack.pop();
    }

    return stack;
  }
}