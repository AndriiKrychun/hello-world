package learn.ray;

import java.util.ArrayList;

public class MyArrayList<E> extends ArrayList<E> {
    private  int getCount;
    private  int setCount;

    public  int getGetCount(){
        return this.getCount;
    }

    public  int getSetCount(){
        return this.setCount;
    }

    @Override
    public E get(int i) {
        this.getCount++;
        return super.get(i);
    }

    @Override
    public E set(int i, E element){
        this.setCount++;
        return super.set(i, element);
    }


    public MyArrayList() {
        super();
        getCount=0;
        setCount=0;
    }




}
