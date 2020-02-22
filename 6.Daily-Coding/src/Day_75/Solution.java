package Day_75;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  public static void main(String[] args) {

  }

  public List<Integer> partitionLabels(String str) {
    Map<Character, Integer> charToLastIndex = new HashMap<>();
    for (int i = 0; i < str.length(); i++) {
      charToLastIndex.put(str.charAt(i), i);
    }

    List<Integer> answers = new ArrayList<>();
    int partitionStartIndex = 0;
    int partitionEndIndex = 0;

    for (int i = 0; i < str.length(); i++) {
      Character currentChar = str.charAt(i);

      partitionEndIndex = Math.max(partitionEndIndex, charToLastIndex.get(currentChar));

      if (i == partitionEndIndex) {
        answers.add(partitionEndIndex - partitionStartIndex + 1);
        partitionStartIndex = i + 1;
        partitionEndIndex = i + 1;
      }
    }

    return answers;
  }

}
