package applications;

import utils.GenericLinkedList;

public class SampleGenericLinkedList {
    public static void main(String[] args) {
        GenericLinkedList<String> newList = new GenericLinkedList<>();

        newList.add("Hello there");
        newList.add("Byebye");
        for (int i = 0; i < newList.size(); i++) {
            System.out.println(i + ") " + newList.get(i));
        }

        GenericLinkedList<Integer> list2 = new GenericLinkedList<>();

        list2.add(15);
        list2.add(45);
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(i + ") " + list2.get(i));
        }
    }
}
