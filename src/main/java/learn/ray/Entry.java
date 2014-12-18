package learn.ray;


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
