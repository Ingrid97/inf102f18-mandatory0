package no.uib.ii.inf102.f18.mandatory0;//Created by ingridjohansen on 26.09.2018.

import java.util.Iterator;

/**
 *@author ijo031
 */

 class Words implements Comparable<Words>{
    int n;
    String word;

    public Words(int n, String word){
        this.n = n;
        this.word = word;
    }


    @Override
    public int compareTo(Words o) {
        return (this.n - o.n);

    }
}

public class trollBook {

    public static void main(String[] args) {

        Kattio scn = new Kattio(System.in, System.out);

        SortableLinkedList<Words> linkedlist = new SortableLinkedList<>();

        int N = scn.getInt();
        for(int i = 0; i < N; i++){
            String word = scn.getWord();
            int index = scn.getInt();

            Words a = new Words(index, word);
            linkedlist.add(a);
        }

        linkedlist.sort();
        StringBuilder s = new StringBuilder();
        Iterator<Words> it = linkedlist.iterator();
        while(it.hasNext()){
            s.append(it.next().word);
            s.append(" ");
        }

        System.out.println(s);
    }
}
