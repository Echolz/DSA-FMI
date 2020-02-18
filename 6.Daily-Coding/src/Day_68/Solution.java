package Day_68;

public class Solution {
  public static void main(String[] args) {
    //True
    System.out.println(checkRecord("PPALLP"));

    //False
    System.out.println(checkRecord("PPALLL"));
  }

  public static boolean checkRecord(String s) {
    int absent = 0;
    int late = 0;


    for (int i = 0; i < s.length(); i++) {
      char currentChar = s.charAt(i);

      if (currentChar == 'L') {
        late++;
        if (late >= 3) {
          return false;
        }
        continue;
      }

      if (currentChar == 'A') {
        absent++;

        if (absent >= 2) {
          return false;
        }
      }
      late = 0;

    }

    return true;
  }
}
