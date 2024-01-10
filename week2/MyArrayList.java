package week2;

import java.util.Arrays;
import java.util.ListIterator;

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
        if (index < 0 || index >= INITIAL_CAPACITY) {
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

    public int indexOf(Integer number) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] == number)
                return i;
        }
        return -1;
    }


    // How to use MyLinkedList
    public static void main(String[] args) {

        System.out.println("################  APPLICATION STARTED ################");
        MyArrayList myArrayList = new MyArrayList();

        System.out.println("Size : " + myArrayList.size());

        myArrayList.add(5);
        myArrayList.add(15);
        myArrayList.add(1);
        myArrayList.add(40);

        System.out.println("Size : " + myArrayList.size());

        System.out.println("Index 3 value : " + myArrayList.get(3));
        System.out.println("Index 5 value : " + myArrayList.get(5));

        // Exception Handling
        try {
            Integer result = myArrayList.get(15);
            System.out.println("15. Index value : " + result);
        } catch (Exception exp) {
            System.err.println("A problem occurred : " + exp.getMessage());
        }

        try {
            int index = myArrayList.indexOf(40);
            System.out.println("Index of 40 : " + index);
        } catch (Exception exp) {
            System.err.println("A problem occurred : " + exp.getMessage());
        }

        System.out.println("Index of 40 : " + myArrayList.indexOf(20));
        System.out.println("################  APPLICATION STOPPED ################");

    }

}