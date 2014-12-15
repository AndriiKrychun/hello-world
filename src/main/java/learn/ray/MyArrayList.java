package learn.ray;

import java.util.ArrayList;

public class MyArrayList<E> extends ArrayList<E> {
    private static int getCount;
    private static int setCount;

    public static void setGetCount(int getCount) {
        MyArrayList.getCount = getCount;
    }

    public static void setSetCount(int setCount) {
        MyArrayList.setCount = setCount;
    }

    public static int getGetCount(){
        return getCount;
    }

    public static int getSetCount(){
        return setCount;
    }

    @Override
    public E get(int i) {
        getCount++;
        return super.get(i);
    }

    @Override
    public E set(int i, E element){
        setCount++;
        return super.set(i, element);
    }


    public MyArrayList() {
        super();
    }




}
