package learn.ray;


import java.util.Collection;
import java.util.Iterator;

public class LinkedCollection implements Collection {
    private Entry top;
    private Entry bottom;
    private int size;

    public LinkedCollection() {
        top = null;
        bottom = null;
        size = 0;
    }


    public static void main(String args[]){
        LinkedCollection list=new LinkedCollection();
//        System.out.println(list.getTop().getElement());
        list.add("First");
        list.add("Second");
        list.add("Third");
        list.add("Fourth");
        list.add("Fifth");



        for (Object s : list.toArray())  System.out.println(s);


//        System.out.println(list.size());
//        System.out.println(list.getTop().getElement());
        list.remove("Fourth");
//        System.out.println(list.size());
//        System.out.println(list.getTop().getElement());
//        list.remove("Fifth");
        System.out.println(list.size());
//        System.out.println(list.getTop().getElement());
        list.remove("First");
        System.out.println(list.size());
//        System.out.println(list.getTop().getElement());
        System.out.println("-------------");
        for (Object ss : list.toArray())  System.out.println(ss);


    }


    public int size() {
        return size;
    }


    public boolean isEmpty() {
        if (top == null)
            return true;
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
//        Iterator iterator = new Iterator() {
//            @Override
//            public boolean hasNext() {
//                return false;
//            }
//
//            @Override
//            public Object next() {
//                return null;
//            }
//
//            @Override
//            public void remove() {
//
//            }
//        }
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Entry tempEntry = top;

        for (int i = 0; i < size; i++) {
            array[i] = tempEntry.getElement();
            tempEntry = tempEntry.getNext();
        }
        return array;
    }

    @Override
    public boolean add(Object o) {
        if (null == top) {
            bottom = new Entry();
            bottom.setElement(o);
            top = bottom;
        } else {
            Entry newEntry = new Entry();
            newEntry.setElement(o);
            newEntry.setNext(top);
            top = newEntry;
        }
        size++;
        return true;
    }


    @Override
    public boolean remove(Object o) {
        Entry tempEntry = top;
        Entry previousEntry = top;
        for (int i = 0; i < size; i++) {
            if (!(tempEntry.getElement().equals(o))) {
                tempEntry = tempEntry.getNext();
            } else {
                if (tempEntry == top) {
                    top = tempEntry.getNext();
                } else {
                    if (tempEntry != bottom) {
                        previousEntry.setNext(tempEntry.getNext());
                    } else {
                        tempEntry.setNext(null);
                    }
                }
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {


        return new Object[0];
    }


//    public Object top(){
//        if(isEmpty()){
//            System.out.println("List is empty");
//            System.exit(0);
//        }
//        return top.getElement();
//    }
//
//    public Object pop(){
//        if(isEmpty()){
//            System.out.println("Stack is empty");
//            System.exit(0);
//        }
//        Object obj=top.getElement();
//        this.top=top.getNext();
//        size--;
//        return obj;
//    }

    public class Entry {
        private Object element;
        private Entry next;

        public Entry(){

        }

        public Object getElement(){
            return element;
        }
        public Entry getNext(){
            return next;
        }

        public void setElement(Object element){
            this.element=element;
        }
        public void setNext(Entry next){
            this.next=next;
        }
    }
}
