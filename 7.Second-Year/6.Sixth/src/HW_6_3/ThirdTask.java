package HW_6_3;

public class ThirdTask {
    public static void main(String[] args) {

        int firstNumber = 1;
        int secondNumber = 4;

        System.out.println(hammingDistance(1, 4));
    }

    public static int hammingDistance(int x, int y) {
        int answer = 0;

        int num = x ^ y;

        String binary = Integer.toBinaryString(num);

        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                answer++;
            }
        }

        return answer;
    }
}
