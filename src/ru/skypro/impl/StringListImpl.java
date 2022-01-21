package ru.skypro.impl;

import ru.skypro.StringList;
import ru.skypro.exceptions.ElementDoNotExistException;
import ru.skypro.exceptions.IndexOutOfBoundsException;

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
        if (checkNotNullParameter(item)) {
            if (size == arr.length) {
                arr = grow();
            }
            arr[size++] = item;
            return item;
        } else {
            throw new NullPointerException();
        }
    }

    private String[] grow() {
        int newCapacity = arr.length * 2;
        return arr = Arrays.copyOf(arr, newCapacity);
    }

    private String[] trim() {
        int newCapacity = arr.length / 2;
        return arr = Arrays.copyOf(arr, newCapacity);
    }

    private boolean checkNotNullParameter(Object o) {
        return o != null;
    }

    @Override
    public String add(int index, String item) {
        if (checkNotNullParameter(item)) {
            if (index > size - 1) {
                throw new IndexOutOfBoundsException("Index out of current capacity of StringList");
            } else {
                if (size  == arr.length) {
                    arr = grow();
                }
                System.arraycopy(arr, index, arr, index + 1, size - index );
                arr[index] = item;
                size++;
                return item;
            }
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public String set(int index, String item) {
        if (checkNotNullParameter(item)) {
            if (index > size - 1) {
                throw new IndexOutOfBoundsException("Index out of current capacity of StringList");
            } else {
                arr[index] = item;
                return item;
            }
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public String remove(String item) {
        if (checkNotNullParameter(item)) {
            int i = indexOf(item);
            if (i == -1) {
                throw new ElementDoNotExistException("Element don't exist in this StringList");
            } else {
                String removedElement = arr[i];
                int newSize = size - 1;
                System.arraycopy(arr, i + 1, arr, i, newSize - i);
                size = newSize;
                if (size > DEFAULT_CAPACITY * 2 || size <= arr.length / 2) {
                    arr = trim();
                }
                return removedElement;
            }
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public String remove(int index) {
        if (index == -1) {
            throw new ElementDoNotExistException("Element don't exist in this StringList");
        } else {
            String removedElement = arr[index];
            int newSize = size - 1;
            System.arraycopy(arr, index + 1, arr, index, newSize - index);
            size = newSize;
            if (size > DEFAULT_CAPACITY * 2 || size <= arr.length / 2) {
                arr = trim();
            }
            return removedElement;
        }
    }

    @Override
    public boolean contains(String item) {
        if (checkNotNullParameter(item)) {
            return indexOf(item) > -1;
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public int indexOf(String item) {
        if (checkNotNullParameter(item)) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].equals(item)) {
                    return i;
                }
            }
            return -1;
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public int lastIndexOf(String item) {
        if (checkNotNullParameter(item)) {
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i].equals(item)) {
                    return i;
                }
            }
            return -1;
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public String get(int index) {
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

