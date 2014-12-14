package learn.ray;

/**
 * Created by ray on 14.12.2014.
 */
public class Farm {
    private int size;
    private int freePlace;


    public Farm(int size) {
        this.size = size;
        this.freePlace=size;
    }

    public int getFreePlace() {
        return freePlace;
    }

    public void decreaseFreePlace(int size) {
        freePlace -= size;
    }

    public int getSize() {
        return size;
    }

}
