package learn.ray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyArrayList<E> extends ArrayList<E> {



    @Override
    public E get(int i) {
        System.out.println("Overrided " + i);
        return super.get(i);


    }

    public MyArrayList(int initialCapacity) {
        super();

    }

    public MyArrayList() {
        super();
    }




}
