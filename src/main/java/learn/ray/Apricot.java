package learn.ray;

public class Apricot extends Plant {
    public static final int SIZE = 2;
    public static final int TIMES_WATERED_BEFORE_HARVEST = 15;
    public static final int HARVEST = 70;

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
