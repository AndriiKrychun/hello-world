package learn.ray;


import java.util.Collection;
import java.util.Iterator;


public class LinkedCollection implements Collection {
    private ListElement firstElement;



    private int size;

    public LinkedCollection() {
        this.firstElement = null;
        this.size = 0;

    }

    public ListElement getFirstElement() {
        return firstElement;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(firstElement==null){
            return true;
        }
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
       ListElement tempElement = new ListElement();
        tempElement.setElement(o);
        tempElement.setNext(firstElement);
        firstElement=tempElement;
        size++;
        return false;
    }

    public Object get(){
        if (isEmpty()){
            return null;
        }
        return firstElement.getElement();

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

    public class ListElement {
        private Object element;
        private ListElement next;

        public ListElement(){

        }
        public ListElement(Object element, ListElement next){
            this.next=next;
            this.element=element;
        }

        public Object getElement(){
            return element;
        }
        public ListElement getNext(){
            return next;
        }

        public void setElement(Object element){
            this.element=element;
        }
        public void setNext(ListElement next){
            this.next=next;
        }

    }
}
