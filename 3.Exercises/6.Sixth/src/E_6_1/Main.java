package E_6_1;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        System.out.println(bst.insert(0));
        System.out.println(bst.insert(5));
        System.out.println(bst.insert(3));

        System.out.println(bst.getSorted().toString());
        System.out.println(bst.size());


        bst.remove(0);
        System.out.println(bst.getMaxValue());
        System.out.println(bst.getSorted().toString());

        bst.remove(3);
        System.out.println(bst.getSorted().toString());


        bst.remove(5);
        System.out.println(bst.getSorted().toString());

    }
}
