package learn.ray;

import java.util.*;

public class Farmer {
    private static List<Plant> plants = null;

    public static void main(String[] args) {
        Farm farm = new Farm(20);
        plants = new ArrayList<Plant>();
        fillFarm(farm);
        waterFarm(farm);
        harvest();
    }

    public static void fillFarm(Farm farm) {
        while (farm.getFreePlace() >= Plant.MINIMAL_PLANT_SIZE) {
            Plant plant = Market.buyPlant(farm.getFreePlace());
            System.out.println(plant.getClass().getSimpleName());
            plants.add(plant);
            farm.decreaseFreePlace(plant.getSize());
        }
    }

    private static void waterFarm(Farm farm) {
        while (!farm.isAllHarvested()) {
            for (Plant plant : plants) {
                if (plant.getTimesWatered() < plant.getTimesWateredBeforeHarvest()) {
                    farm.setAllHarvested(plant.water());
                }
            }
        }
    }

    private static void harvest() {
        Map<String, Integer> farmHarvest = new HashMap<String, Integer>();
        for (Plant plant : plants) {
            int harvest = plant.getHarvest();
            String plantName = plant.getClass().getSimpleName();
            Integer plantHarvest = farmHarvest.get(plantName);
            int newPlantHarvest = harvest;
            if (plantHarvest != null) {
                newPlantHarvest = plantHarvest + harvest;
            }
            farmHarvest.put(plantName, newPlantHarvest);
        }
        for (Map.Entry<String, Integer> entry : farmHarvest.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

}
