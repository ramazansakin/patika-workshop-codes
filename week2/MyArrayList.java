package week2;

import java.util.*;

public class MyArrayList {
    private static final int INITIAL_CAPACITY = 10;
    private Integer[] array;
    private int size;

    public MyArrayList() {
        size = 0;
        array = new Integer[INITIAL_CAPACITY];
    }

    public void add(Integer element) {
        if (size == array.length) {
            increaseCapacity();
        }
        array[size++] = element;
    }

    @SuppressWarnings("unchecked")
    public Integer get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return array[index];
    }

    public int size() {
        return size;
    }

    private void increaseCapacity() {
        int newCapacity = array.length * 2;
        array = Arrays.copyOf(array, newCapacity);
    }

    public int indexOf(Object o) {
        ListIterator<Integer> it = (ListIterator<Integer>) Arrays.stream(array).toList().iterator();
        while (it.hasNext()){
            if(it.next().equals(o))
                return it.nextIndex();
        }
        return -1;
    }


    // How to use MyLinkedList
    public static void main(String[] args) {

        System.out.println("################  APPLICATION START ");
        MyArrayList myArrayList = new MyArrayList();



    }

}
