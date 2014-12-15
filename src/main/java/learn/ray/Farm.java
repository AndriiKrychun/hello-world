package learn.ray;

/**
 * Created by ray on 14.12.2014.
 */
public class Farm {
    private int freePlace;
    private boolean allHarvested = false;

    public Farm(int size) {
        this.freePlace = size;
    }

    public boolean isAllHarvested() {
        return allHarvested;
    }

    public void setAllHarvested(boolean allHarvested) {
        this.allHarvested = allHarvested;
    }


    public int getFreePlace() {
        return freePlace;
    }


    public void decreaseFreePlace(int size) {
        freePlace -= size;
    }
}
