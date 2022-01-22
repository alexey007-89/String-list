package ru.skypro.impl;

import ru.skypro.StringList;
import ru.skypro.exceptions.ElementDoNotExistException;
import ru.skypro.exceptions.IndexOutOfBoundsException;
import ru.skypro.exceptions.InputNullException;

import java.util.Arrays;

public class StringListImpl implements StringList {
    private static final int DEFAULT_CAPACITY = 10;
    private String[] arr;
    private int size;

    public StringListImpl() {
        this.arr = new String[DEFAULT_CAPACITY];
    }

    @Override
    public String add(String item) {
        if (item == null) {
            throw new InputNullException("Input String is null");
        }
        if (size == arr.length) {
            arr = grow();
        }
        arr[size++] = item;
        return item;
    }

    private String[] grow() {
        int newCapacity = arr.length * 2;
        return arr = Arrays.copyOf(arr, newCapacity);
    }

    private String[] trim() {
        int newCapacity = arr.length / 2;
        return arr = Arrays.copyOf(arr, newCapacity);
    }

    @Override
    public String add(int index, String item) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("Index out of current capacity of StringList");
        }
        if (item == null) {
            throw new InputNullException("Input String is null");
        }
        if (size  == arr.length) {
            arr = grow();
        }
        for (int i = size - 1; i >= index; i--) {
            String temp = arr[i];
            arr[i + 1] = temp;
        }
        arr[index] = item;
        size++;
        return item;

    }

    @Override
    public String set(int index, String item) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("Index out of current capacity of StringList");
        }
        if (item == null) {
            throw new InputNullException("Input String is null");
        }
        arr[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        int i = indexOf(item);
        if (i == -1) {
            throw new ElementDoNotExistException("Element don't exist in this StringList");
        }
        if (item == null) {
            throw new InputNullException("Input String is null");
        }
        String removedElement = arr[i];
        for (int j = i + 1; j < size; j++) {
            String temp = arr[j];
            arr[j - 1] = temp;
        }
        size--;
        if (size > DEFAULT_CAPACITY * 2 || size <= arr.length / 2) {
            arr = trim();
        }
        return removedElement;
    }

    @Override
    public String remove(int index) {
        if (index < 0) {
            throw new ElementDoNotExistException("Element don't exist in this StringList");
        }
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("Index out of current capacity of StringList");
        }
        String removedElement = arr[index];
        for (int j = index + 1; j < size; j++) {
            String temp = arr[j];
            arr[j - 1] = temp;
        }
        size--;
        if (size > DEFAULT_CAPACITY * 2 || size <= arr.length / 2) {
            arr = trim();
        }
        return removedElement;
    }

    @Override
    public boolean contains(String item) {
        if (item == null) {
            throw new InputNullException("Input String is null");
        }
        return indexOf(item) > -1;
    }

    @Override
    public int indexOf(String item) {
        if (item == null) {
            throw new InputNullException("Input String is null");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        if (item == null) {
            throw new InputNullException("Input String is null");
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index < 0) {
            throw new ElementDoNotExistException("Element don't exist in this StringList");
        }
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("Index out of current capacity of StringList");
        } else {
            return arr[index];
        }
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new NullPointerException();
        } else if (this.size != otherList.size()) {
            return false;
        } else {
            for (int i = 0; i < size - 1; i++) {
                if (!this.get(i).equals(otherList.get(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        arr = new String[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(arr,size);
    }

    @Override
    public String toString() {
        return "StringListImpl{" +
                "arr=" + Arrays.toString(arr) +
                ", size=" + size +
                '}';
    }
}

