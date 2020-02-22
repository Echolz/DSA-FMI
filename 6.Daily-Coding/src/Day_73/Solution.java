package Day_73;

import java.util.ArrayList;
import java.util.List;

public abstract class Solution {
  public static void main(String[] args) {
    maxSubstring("aa");

  }

  public static String maxSubstring(String s) {
    List<String> subStrings = new ArrayList<>();


    for (int i = 0; i < s.length(); i++) {
      for (int j = i + 1; j < s.length() + 1; j++) {
        subStrings.add(s.substring(i, j));
      }
    }

    String answer = "";

    for (String subString : subStrings) {
      if (answer.compareTo(subString) < 0) {
        answer = subString;
      }
    }

    return answer;
  }
}
