package learn.ray;

/**
 * Created by ray on 14.12.2014.
 */
public class Apple extends Plant {
    public static final int SIZE=3;
    public static final int TIMES_WATERED_BEFORE_HARVEST=10;
    public static final int HARVEST=50;

    public Apple() {
        this.size=SIZE;
        this.harvest=0;
        this.timesWatered=0;

    }
}
