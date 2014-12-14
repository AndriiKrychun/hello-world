package learn.ray;

/**
 * Created by ray on 14.12.2014.
 */
public class Apricot extends Plant {
    public static final int SIZE=2;
    public static final int TIMES_WATERED_BEFORE_HARVEST=15;
    public static final int HARVEST=70;

    public Apricot() {
        this.size=SIZE;
        this.harvest=0;
        this.timesWatered=0;
    }
}
