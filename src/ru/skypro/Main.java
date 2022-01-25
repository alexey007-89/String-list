package ru.skypro;

import ru.skypro.impl.StringListImpl;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        StringList stringList = new StringListImpl();
        stringList.add("Darya");
        stringList.add("Darya");
        stringList.add("Darya");
        stringList.add("Darya");
        stringList.add("Darya");
        stringList.add("Darya");
        stringList.add("Darya");
        stringList.add("Darya");
        stringList.add("Darya");
        stringList.add("Darya");
        stringList.add("Darya");
        stringList.add("Darya");
        stringList.add("Darya");
        stringList.add("Darya");
        stringList.add("Darya");
        stringList.add("Darya");
        stringList.add("Darya");
        stringList.add("Darya");
        stringList.add("Darya");
        stringList.add("Darya");
        stringList.add(0, "Alex");
        stringList.set(10, "DARYA");
        System.out.println(stringList);
        stringList.remove(5);
        stringList.remove(5);
        stringList.remove(5);
        stringList.remove("DARYA");
        System.out.println(stringList);
        stringList.remove(5);
        stringList.remove(5);
        stringList.remove(5);
        stringList.remove(5);
        stringList.remove(5);
        stringList.remove(5);
        stringList.remove(5);
        System.out.println(stringList);
        System.out.println(stringList.indexOf("Alex"));
        System.out.println(stringList.lastIndexOf("Alex"));
        System.out.println(stringList.lastIndexOf("DARYA"));
        System.out.println(stringList.indexOf("DARYA"));
        System.out.println(stringList.get(0));
        System.out.println(stringList.get(3));
        StringList stringList2 = new StringListImpl();
        stringList2.add("Alex");
        stringList2.add("Darya");
        stringList2.add("Darya");
        stringList2.add("Darya");
        stringList2.add("Darya");
        stringList2.add("Darya");
        stringList2.add("Darya");
        stringList2.add("Darya");
        stringList2.add("Darya");
        stringList2.add("Darya");
        System.out.println(stringList2);
        System.out.println(stringList.equals(stringList2));
        stringList2.add("Maxim");
        System.out.println(stringList.equals(stringList2));
        System.out.println(stringList.size());
        System.out.println(Arrays.toString(stringList.toArray()));
        stringList.remove(0);
        stringList.remove(0);
        stringList.remove(0);
        stringList.remove(0);
        stringList.remove(0);
        stringList.remove(0);
        stringList.remove(0);
        stringList.remove(0);
        stringList.remove(0);
        stringList.remove(0);
        System.out.println(stringList.size());
        System.out.println(stringList.isEmpty());
        stringList2.clear();
        System.out.println(stringList2.isEmpty());
    }
}
