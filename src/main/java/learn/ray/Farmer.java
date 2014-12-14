package learn.ray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ray on 14.12.2014.
 */
public class Farmer {
    public static List<Plant> plants = null;

    public static void main(String[] args) {

//        for (int i=0; i<20; i++){
//            int num = (int) (Math.random() * 3);
//            System.out.println(num);
//        }

        Farm farm = new Farm(20);
        plants = new ArrayList<Plant>();
        fillFarm(farm);
        System.out.println("hey!");
    }

    public static void fillFarm(Farm farm){
        while (farm.getFreePlace()>=Plant.MINIMAL_PLANT_SIZE){
            Plant plant = Market.buyPlant(farm.getFreePlace());
            plants.add(plant);
            farm.decreaseFreePlace(plant.getSize());
           // System.out.println(plant.getClass().toString());
        }
    }


}
