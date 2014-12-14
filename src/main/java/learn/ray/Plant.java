package learn.ray;

/**
 * Created by ray on 14.12.2014.
 */
public class Plant {
    public static final int MINIMAL_PLANT_SIZE=2;
    public int TIMES_WATERED_BEFORE_HARVEST;
    int size;
    int timesWatered=0;
    int harvest;

    public int getSize() {
        return size;
    }
}
