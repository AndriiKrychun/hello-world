package learn.ray;


import java.util.Collection;
import java.util.Iterator;

public class LinkedCollection implements Collection {
    private Entry top;
    private Entry bottom;
    private int size;


    public static void main(String args[]){
        LinkedCollection list=new LinkedCollection();
//        System.out.println(list.getTop().getElement());
        list.add("First");
        list.add("Second");
        list.add("Third");
        list.add("Fourth");
        list.add("Fifth");



        for (Object s : list.toArray())  System.out.println(s);

        list.clear();
        System.out.println("--------------------------Via Iterator");
        Iterator it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("--------------------------Stop");


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
        Entry tempEntry = top;
        for (int i = 0; i < size; i++) {
            if (!(tempEntry.getElement().equals(o))) {
                tempEntry = tempEntry.getNext();
            } else {
                return true;
            }
        }
        return false;
    }


    @Override
    public Iterator iterator() {
        Iterator iterator = new Iterator() {
            int currentPos;
            int returnedPos;

            @Override
            public boolean hasNext() {
                if (currentPos != size)  return true;
                return false;
            }

            @Override
            public Object next() {
                Entry tempEntry = top;
                for (int i=0; i < currentPos; i++){
                    tempEntry = tempEntry.getNext();
                }
                currentPos++;
                return tempEntry.getElement();
            }

            @Override
            public void remove() {

            }
        };
        return iterator;
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
    public Object[] toArray(Object[] a) {
        return new Object[0];
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
        top=null;
        size=0;
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


    public class Entry {
        private Object element;
        private Entry next;

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
