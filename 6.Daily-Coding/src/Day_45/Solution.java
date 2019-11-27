package Day_45;

public class Solution {
    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
        //5f3z-2e9w

    }

    public static String licenseKeyFormatting(String S, int K) {
        String s = S.replaceAll("-", "").toUpperCase();

        StringBuilder answer = new StringBuilder();

        int firstGroup = s.length() % K;
        int group = K;
        boolean firstGrpFlag = firstGroup != 0;


        int currentWindow = 0;
        for (int i = 0; i < s.length(); i++) {
            if (firstGrpFlag) {
                answer.append(s.charAt(i));
                currentWindow++;
                if (currentWindow == firstGroup) {
                    firstGrpFlag = false;
                    currentWindow = 0;
                    answer.append("-");
                }
                continue;
            }

            answer.append(s.charAt(i));
            currentWindow++;
            if (currentWindow == group) {
                currentWindow = 0;

                if (i != s.length() - 1) {
                    answer.append("-");
                }
            }
        }

        return answer.toString();
    }
}
