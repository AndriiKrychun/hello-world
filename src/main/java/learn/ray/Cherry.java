package learn.ray;

public class Cherry extends Plant {
    public static final int SIZE = 4;
    public static final int TIMES_WATERED_BEFORE_HARVEST = 5;
    public static final int HARVEST = 20;

    public int getSize() {
        return SIZE;
    }

    public int getTimesWateredBeforeHarvest() {
        return TIMES_WATERED_BEFORE_HARVEST;
    }

    public int getHarvest() {
        return HARVEST;
    }
}
