package ru.skypro;

import ru.skypro.impl.IntegerListImpl;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        Testing of all methods of our IntegerList

        IntegerList integerList = new IntegerListImpl();
        for (int i = 0; i < 20; i++) {
            integerList.add(1);
        }
        integerList.add(0, 2);
        integerList.set(10, 3);
        System.out.println(integerList);
        for (int i = 0; i < 3; i++) {
            integerList.remove(5);
        }
        integerList.remove(3);
        System.out.println(integerList);
        for (int i = 0; i < 7; i++) {
            integerList.remove(5);
        }
        System.out.println(integerList);
        System.out.println(integerList.indexOf(2));
        System.out.println(integerList.lastIndexOf(2));
        System.out.println(integerList.lastIndexOf(3));
        System.out.println(integerList.indexOf(3));
        System.out.println(integerList.get(0));
        System.out.println(integerList.get(3));
        IntegerList integerList2 = new IntegerListImpl();
        integerList2.add(2);
        for (int i = 0; i < 9; i++) {
            integerList2.add(1);
        }
        System.out.println(integerList2);
        System.out.println(integerList.equals(integerList2));
        integerList2.add(3);
        System.out.println(integerList2);
        System.out.println(integerList.equals(integerList2));
        System.out.println(integerList.size());
        System.out.println(Arrays.toString(integerList.toArray()));
        for (int i = 0; i < 10; i++) {
            integerList.remove(0);
        }
        System.out.println(integerList.size());
        System.out.println(integerList.isEmpty());
        integerList2.clear();
        System.out.println(integerList2.isEmpty());
        System.out.println(integerList);
        System.out.println(integerList2);
        for (int i = 0; i < 12; i++) {
            integerList.add(1);
        }
        integerList.set(2, 3);
        integerList.set(4, 6);
        integerList.set(8, 9);
        System.out.println(integerList);
        System.out.println(integerList.contains(3));
        System.out.println(integerList.contains(2));
        System.out.println(integerList);

//        Testing sorting

//        IntegerList list1 = new IntegerListImpl();
//        list1.add(10);
//        list1.add(3);
//        list1.add(5);
//        list1.add(7);
//        list1.add(8);
//        IntegerList list2 = new IntegerListImpl();
//        list2.add(10);
//        list2.add(3);
//        list2.add(5);
//        list2.add(7);
//        list2.add(8);
//        IntegerList list3 = new IntegerListImpl();
//        list3.add(10);
//        list3.add(3);
//        list3.add(5);
//        list3.add(7);
//        list3.add(8);
//        System.out.println(list1);
//        list1.sortBubble();
//        list2.sortSelection();
//        list3.sortInsertion();
//        System.out.println(list1);
//        System.out.println(list2);
//        System.out.println(list3);

//        Checking time of sorting

//        for (int i = 0; i < 5; i++) {
//            IntegerList list1 = generateRandomArray();
//            long start = System.currentTimeMillis();
//            list1.sortBubble();
//            System.out.println(System.currentTimeMillis() - start);
//        }
//        System.out.println("---------------------");
//        for (int i = 0; i < 5; i++) {
//            IntegerList list1 = generateRandomArray();
//            long start = System.currentTimeMillis();
//            list1.sortSelection();
//            System.out.println(System.currentTimeMillis() - start);
//        }
//        System.out.println("---------------------");
//        for (int i = 0; i < 5; i++) {
//            IntegerList list1 = generateRandomArray();
//            long start = System.currentTimeMillis();
//            list1.sortInsertion();
//            System.out.println(System.currentTimeMillis() - start);
//        }



    }
    public static IntegerList generateRandomArray() {
        java.util.Random random = new java.util.Random();
        IntegerList arr = new IntegerListImpl();
        for (int i = 0; i < 100_000; i++) {
            arr.add(random.nextInt(100_000) + 100_000);
        }
        return arr;
    }
}
