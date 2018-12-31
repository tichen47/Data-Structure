package tree;

public class BST<E extends Comparable<E>> {

    private TreeNode<E> root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Does not include same value
    public void add(E e) {
        root = add(root, e);
    }

    // Insert e in BST with root "node"
    // Return the new root
    private TreeNode<E> add(TreeNode<E> node, E e) {
        if (node == null) {
            size++;
            return new TreeNode<E>(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }

        return node;
    }

    // Check if the BST contains e
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(TreeNode<E> node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    // Pre-order traverse
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(TreeNode<E> node) {
        if (node == null) {
            return;
        }

        System.out.print(node.e + " ");
        preOrder(node.left);
        preOrder(node.right);

//        // Another style
//        if(node != null) {
//            System.out.println(node.e);
//            preOrder(node.left);
//            preOrder(node.right);
//        }

    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(TreeNode<E> node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder reStringBuilder = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            reStringBuilder.append("--");
        }
        return reStringBuilder.toString();
    }
}
