package tree;

public class TreeNode<E extends Comparable<E>> {
    public E e;
    public TreeNode<E> left, right;

    public TreeNode(E e) {
        this.e = e;
        left = null;
        right = null;
    }
}
