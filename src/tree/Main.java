package tree;

public class Main {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] test = { 5, 3, 6, 8, 4, 2 };
        for (int i = 0; i < test.length; i++) {
            bst.add(test[i]);
        }

        bst.preOrder();
        System.out.println();

        bst.preOrderNR();

        bst.inOrder();
        System.out.println();

        bst.postOrder();
        System.out.println();

        System.out.println(bst);

    }

}
