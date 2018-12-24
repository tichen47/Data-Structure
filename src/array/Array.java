package array;

public class Array<E> {

    private E[] data;
    private int size;

    // Constructor with input capacity
    @SuppressWarnings("unchecked")
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    // constructor with default capacity 10
    public Array() {
        this(10);
    }

    // return size of array
    public int getSize() {
        return size;
    }

    // return capacity of array
    public int getCapacity() {
        return data.length;
    }

    // return if the array is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // add by index
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index > 0 and < size");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // add to last index
    public void addLast(E e) {
        add(size, e);
    }

    // add at index 0
    public void addFirst(E e) {
        add(0, e);
    }

    // get the data by index
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    // get the first data
    public E getLast() {
        return get(size - 1);
    }
    
    // get the last data 
    public E getFirst() {
        return get(0);
    }
    
    // set the data by index
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal");
        }
        data[index] = e;

    }

    // find if e is in the array
    public boolean isContain(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    // find the index in the array, -1 if not exist
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    // remove by index, return the removed element
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal");
        }
        E ret = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null; // loitering objects != memory leak
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    // remove the first element
    public E removeFirst() {
        return remove(0);
    }

    // remove the last element
    public E removeLast() {
        return remove(size - 1);
    }

    // remove element e
    public boolean removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    // print out the array
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

    private void resize(int newCapacity) {
        @SuppressWarnings("unchecked")
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
