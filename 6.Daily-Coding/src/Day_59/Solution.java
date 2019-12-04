package Day_59;

public class Solution {
    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{1, 2, 1}));
        System.out.println(totalFruit(new int[]{1, 2, 3, 2, 2}));
        System.out.println(totalFruit(new int[]{0, 1, 2, 2}));
        System.out.println(totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
    }

    public static int totalFruit(int[] tree) {
        if (tree.length == 0) {
            return 1;
        }

        int max = 1;
        Basket firstBasket = null;
        Basket secondBasket = null;

        for (int i = 0; i < tree.length; i++) {
            int currentType = tree[i];

            if (firstBasket == null) {
                firstBasket = new Basket(1, currentType, -1);
                continue;
            }

            if (secondBasket == null) {
                if (currentType == firstBasket.type) {
                    firstBasket.fruits++;
                    continue;
                }
                secondBasket = new Basket(1, currentType, 1);
                continue;
            }


            if (currentType == firstBasket.type) {
                Basket temp = firstBasket;
                temp.fruits++;
                temp.sequence = 1;
                firstBasket = secondBasket;
                secondBasket = temp;
                continue;
            }

            if (currentType == secondBasket.type) {
                secondBasket.fruits++;
                secondBasket.sequence++;
                continue;
            }

            max = Integer.max(max, firstBasket.fruits + secondBasket.fruits);

            //currentFruit is not the type of the first and second basket;
            firstBasket = secondBasket;
            firstBasket.fruits = firstBasket.sequence;
            secondBasket = new Basket(1, currentType, 1);
        }

        if (secondBasket == null) {
            return firstBasket.fruits;
        }

        max = Integer.max(max, firstBasket.fruits + secondBasket.fruits);

        return max;
    }
}

class Basket {
    int fruits;
    int type;
    int sequence;

    public Basket(int fruits, int type, int sequence) {
        this.fruits = fruits;
        this.type = type;
        this.sequence = sequence;
    }
}
