package no.uib.ii.inf102.f18.mandatory0;//Created by ingridjohansen on 26.09.2018.

public class test {
    public static void main(String[] args) {
        SortableLinkedList<Integer> list =  new SortableLinkedList<>();

        list.add(1);
        list.add(8);
        list.add(5);
        list.add(2);
        list.add(10);
        list.add(88);
        list.add(55);
        list.add(23);

        list.remove(2);
        int size = list.size();
        System.out.println("Size = " + size);


        for(int i = 0; i < size; i++){
            System.out.println(list.get(i));
        }

        list.sort();
        size = list.size();
        System.out.println("Size Test = " + size);


        for(int i = 0; i < size; i++){
            System.out.println(list.get(i));
        }
    }
}
