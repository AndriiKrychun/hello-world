package learn.ray;

public class Apple extends Plant {
    public static final int SIZE = 3;
    public static final int TIMES_WATERED_BEFORE_HARVEST = 10;
    public static final int HARVEST = 50;

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
