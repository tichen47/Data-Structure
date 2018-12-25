package linkedList;

public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        @SuppressWarnings("unused")
        public Node(E e) {
            this(e, null);
        }

        @SuppressWarnings("unused")
        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // add element by index (0 - based)
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        prev.next = new Node(e, prev.next);
        size ++;
    }
    
    // add element at the beginning
    public void addFirst(E e) {
        add(0, e);
    }
    
    // add element at the last
    public void addLast(E e) {
        add(size, e);
    }
    
    // get the element by index
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Illegal index");
        }
        Node cur = dummyHead.next;
        for(int i = 0 ; i < index ; i++) {
            cur = cur.next;
        }
        return cur.e;
    }
    
    // get the first element
    public E getFirst() {
        return get(0);
    }
    
    // get the last element
    public E getLast() {
        return get(size - 1);
    }
    
    // set by index
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed. Illegal index");
        }
        
        Node cur = dummyHead.next;
        for(int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }
    
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while(cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    
    // delete by index, return the deleted element
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed. Illegal index");
        }
        Node prev = dummyHead;
        for(int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;
        return retNode.e;
    }
    
    // delete the first element
    public E removeFirst() {
        return remove(0);
    }
    
    // delete the last element
    public E removeLast() {
        return remove(size - 1);
    }
    
    @Override
    public String toString() {
        StringBuilder reStringBuilder = new StringBuilder();
        /**
        Node cur = dummyHead.next;
        while(cur != null) {
            reStringBuilder.append(cur + "->");
            cur = cur.next;
        }
        **/
        for(Node cur = dummyHead.next ; cur != null; cur = cur.next) {
            reStringBuilder.append(cur + "->");
        }
        reStringBuilder.append("NULL");
        return reStringBuilder.toString();
    }
}
