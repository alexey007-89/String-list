package ru.skypro.impl;

import ru.skypro.IntegerList;
import ru.skypro.exceptions.ElementDoNotExistException;
import ru.skypro.exceptions.IndexOutOfBoundsException;
import ru.skypro.exceptions.InputNullException;

import java.util.Arrays;
import java.util.Objects;

public class IntegerListImpl implements IntegerList {
    private static final int DEFAULT_CAPACITY = 10;
    private Integer[] arr;
    private int size;

    public IntegerListImpl() {
        this.arr = new Integer[DEFAULT_CAPACITY];
    }

    @Override
    public Integer add(Integer item) {
        checkNotNull(item);
        if (size == arr.length) {
            arr = grow();
        }
        arr[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        checkIndexIsInsideSize(index);
        checkNotNull(item);
        if (size  == arr.length) {
            arr = grow();
        }
        for (int i = size - 1; i >= index; i--) {
            Integer temp = arr[i];
            arr[i + 1] = temp;
        }
        arr[index] = item;
        size++;
        return item;

    }

    @Override
    public Integer set(int index, Integer item) {
        checkIndexIsInsideSize(index);
        checkNotNull(item);
        arr[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        int i = indexOf(item);
        if (i == -1) {
            throw new ElementDoNotExistException("Element don't exist in this StringList");
        }
        checkNotNull(item);
        return remove(i);
    }

    @Override
    public Integer remove(int index) {
        checkPositiveIndex(index);
        checkIndexIsInsideSize(index);
        Integer removedElement = arr[index];
        for (int j = index + 1; j < size; j++) {
            Integer temp = arr[j];
            arr[j - 1] = temp;
        }
        arr[--size] = null;
        if (arr.length >= DEFAULT_CAPACITY * 2 && size <= arr.length / 2) {
            arr = trim();
        }
        return removedElement;
    }

    @Override
    public Integer contains(Integer item) {
        checkNotNull(item);
        sort();
        return binarySearch(item);
    }

    @Override
    public int indexOf(Integer item) {
        checkNotNull(item);
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        checkNotNull(item);
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        checkPositiveIndex(index);
        checkIndexIsInsideSize(index);
        return arr[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList == null) {
            throw new NullPointerException();
        }
        if (size != otherList.size()) {
            return false;
        }
        for (int i = 0; i < size - 1; i++) {
            if (!get(i).equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
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
        arr = new Integer[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(arr,size);
    }

    @Override
    public String toString() {
        return "IntegerListImpl{" +
                "arr=" + Arrays.toString(arr) +
                ", size=" + size +
                '}';
    }

    public void sortBubble() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    public void sortSelection() {
        for (int i = 0; i < size - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    public void sortInsertion() {
        for (int i = 1; i < size; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                swapElements(arr, i, j);
            }
        }
        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private void checkNotNull(Integer item) {
        if (item == null) {
            throw new InputNullException("Input String is null");
        }
    }

    private void checkPositiveIndex(int index) {
        if (index < 0) {
            throw new ElementDoNotExistException("Element don't exist in this StringList");
        }
    }

    private void checkIndexIsInsideSize(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("Index out of current capacity of StringList");
        }
    }

    private Integer[] grow() {
        int newCapacity = arr.length * 2;
        return arr = Arrays.copyOf(arr, newCapacity);
    }

    private Integer[] trim() {
        int newCapacity = arr.length / 2;
        return arr = Arrays.copyOf(arr, newCapacity);
    }

    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        Integer tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    private void sort() {
        quickSort(arr,0,size-1);
    }

    private Integer binarySearch(Integer element) {
        int min = 0;
        int max = size - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (Objects.equals(element, arr[mid])) {
                return mid;
            }

            if (element < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return - 1;
    }

}

