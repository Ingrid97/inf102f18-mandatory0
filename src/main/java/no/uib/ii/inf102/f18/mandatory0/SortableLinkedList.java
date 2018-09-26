package no.uib.ii.inf102.f18.mandatory0;//Created by ingridjohansen on 26.09.2018.

import java.util.Iterator;

public class SortableLinkedList<E extends Comparable<E>> implements ISortableList<E>{

    private class Elem{
        E el;
        Elem next;
    }

    private Elem first;
    private Elem last;
    private int size = 0;

    public SortableLinkedList(){
        first = null;
    }

    public void add(E element) {
        Elem newLast = new Elem();
        newLast.el = element;

        if (size == 0){
            first = newLast;
            last = newLast;
        } else {
            Elem secondLast = last;
            last = newLast;
            secondLast.next = newLast;
        }
        size++;
    }

    public void add(int index, E element) {
        int count = 0;
        Elem countElem = first;

        while(true){
            if (count == index){
                Elem newNext = new Elem();
                newNext.el = element;
                newNext.next = countElem.next;
                countElem.next = newNext;
                break;
            }
            count++;
            countElem = countElem.next;
        }
        size++;
    }

    public void clear() {
        first = null;
        size = 0;
    }

    public E get(int index) {
        int count = 0;
        Elem countElem = first;

        while(true){
            if (count == index){
               return countElem.el;
            }
            count++;
            countElem = countElem.next;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public E remove(int index) {
        int count = 0;
        size--;
        Elem countElem = first;
        Elem previus = null;

        while(true){
            if (count == index){
                E elem = countElem.el;
                previus.next = countElem.next;
                return elem;
            }
            count++;
            previus = countElem;
            countElem = countElem.next;
        }

    }

    public int size() {
        return size;
    }

    public void sort() {
        first = mergeSort(first);

    }

    Elem mergeSort(Elem h) {

        //if the length is 0 or one
        if (h == null || h.next == null) {
            return h;
        }

        Elem middle = getMiddle(h);
        Elem middlenext = middle.next;

        middle.next = null;

        Elem left = mergeSort(h);
        Elem right = mergeSort(middlenext);

        Elem sortedlist = merge(left, right);
        return sortedlist;
    }

    Elem merge(Elem a, Elem b) {
        Elem result = null;

        if (a == null)
            return b;
        if (b == null)
            return a;

        if ((a.el.compareTo(b.el)) <= 0){
            result = a;
            result.next = merge(a.next, b);
        } else {
            result = b;
            result.next = merge(a, b.next);
        }
        return result;

    }

    Elem getMiddle(Elem h)
    {
        if (h == null)
            return h;

        Elem lastPointer = h.next;
        Elem midlePointer = h;

        while (lastPointer != null) {
            lastPointer = lastPointer.next;
            if(lastPointer!=null) {
                midlePointer = midlePointer.next;
                lastPointer=lastPointer.next;
            }
        }
        return midlePointer;
    }

    public E[] toArray(E[] a) {
        int count = 0;
        Elem countElem = first;

        while(true){
            if (countElem == null)
                break;
            a[count] = countElem.el;
            countElem = countElem.next;
            count++;
        }
        return a;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {

            Elem here = first;

            @Override
            public boolean hasNext() {
                return here != null;
            }

            @Override
            public void remove() {

            }

            @Override
            public E next() {
                E newEl = here.el;
                here = here.next;
                return newEl;
            }
        };
    }

}
