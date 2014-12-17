package learn.ray;


import java.util.Collection;
import java.util.Iterator;

public class LinkedCollection implements Collection {
    private Entry top;
    private Entry bottom;
    private int size;
    public LinkedCollection(){
        top=null;
        bottom=null;
        size=0;
    }

    public int size(){
        return size;
    }


    public Entry getTop(){
        return top;
    }

    public boolean isEmpty(){
        if(top==null)
            return true;
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        if (top==null){
            this.bottom = new Entry();
            this.bottom.setElement(o);
            this.top = this.bottom;
            this.bottom.setNext(null);
            this.size++;
        } else {
            Entry newEntry = new Entry();
            this.top.setNext(newEntry);
            this.top = newEntry;
            this.top.setElement(o);
            this.top.setNext(null);

        }

        Entry newEntry = new Entry();
        newEntry.setElement(o);
        newEntry.setNext(top);
        top=newEntry;
        size++;

        return false;
    }


    @Override
    public boolean remove(Object o) {

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



    public Object top(){
        if(isEmpty()){
            System.out.println("List is empty");
            System.exit(0);
        }
        return top.getElement();
    }

    public Object pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            System.exit(0);
        }
        Object obj=top.getElement();
        top=top.getNext();
        size--;
        return obj;
    }



    public static void main(String args[]){
        LinkedCollection list=new LinkedCollection();
        list.add("SSSSSSSS");
        list.add("AAAAAAAAA");
        list.add("wwwwwwwww");
        System.out.println(list.getTop().getElement());
        System.out.println(list.size);
        list.pop();
        System.out.println(list.getTop().getElement());
    }

    public class Entry {
        private Object element;
        private Entry next;

        public Entry(){

        }
        public Entry(Object element, Entry next){
            this.next=next;
            this.element=element;
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
