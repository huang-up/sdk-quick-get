package data.structure.collection;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by h on 2017/12/16.
 */
public class ArrayListX<E> {

    // mark <= position <= limit <= capacity

    // default capacity
    private static final int DEFAULT_CAPACITY = 10;
    // 空元素数组
    private static final Object[] EMPTY_ELEMENTDATA = {};
    // 默认容量的空元素数组
    private static final Object[] DEFAULT_CAPACITY_EMPTY_ELEMENTDATA = {};
    // 包内可见
    transient Object[] elemetData;
    transient int modCount;
    // position
    private int size;

    public ArrayListX() {
        elemetData = DEFAULT_CAPACITY_EMPTY_ELEMENTDATA;
    }

    public ArrayListX(int initialCapacity) {
        if (initialCapacity > 0) {
            elemetData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            elemetData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    public ArrayListX(Collection<? extends E> collection) {
        elemetData = collection.toArray();
        if (elemetData.length != 0) {
            if (elemetData.getClass() != Object[].class) {
                elemetData = Arrays.copyOf(elemetData, elemetData.length, Object[].class);
            }
        } else {
            elemetData = EMPTY_ELEMENTDATA;
        }
    }

    public boolean add(E e) {
        ensureCapacityInternal(size + 1);
        elemetData[size++] = e;
        return true;
    }

    private void ensureCapacityInternal(int minCapacity) {
        if (elemetData == DEFAULT_CAPACITY_EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(minCapacity, DEFAULT_CAPACITY);
        }
        ensureExplicitCapacity(minCapacity);
    }

    public void ensureExplicitCapacity(int minCapacity) {

    }
}
