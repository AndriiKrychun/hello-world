package learn.ray;

/**
 * Created by ray on 14.12.2014.
 */
public class Market {
    public static Plant buyPlant(int maxSize) {
        int num = 0;
        Plant plant = null;
        boolean bought = false;
        while (!bought) {

            num = (int) (Math.random() * 3);
            switch (num) {
                case 0: {
                    if (Apple.SIZE <= maxSize) {
                        //plant = new Plant();
                        plant = new Apple();
                        bought = true;
                    }
                    break;
                }
                case 1: {
                    if (Cherry.SIZE <= maxSize) {
                        plant = new Cherry();
                        bought = true;
                    }
                    break;
                }
                case 2: {
                    if (Apricot.SIZE <= maxSize) {
                        plant = new Apricot();
                        bought = true;
                    }
                    break;
                }
            }
        }

        return plant;
    }
}
