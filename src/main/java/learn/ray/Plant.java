package learn.ray;

/**
 * Created by ray on 14.12.2014.
 */
public abstract class Plant {
    public static final int MINIMAL_PLANT_SIZE = 2;
    private int timesWatered = 0;


    public int getTimesWatered() {
        return timesWatered;
    }

    public boolean water() {
        timesWatered++;
        return (timesWatered >= getTimesWateredBeforeHarvest());
    }

    public abstract int getTimesWateredBeforeHarvest();

    public abstract int getHarvest();

    public abstract int getSize();


}
