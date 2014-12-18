package learn.ray;


public class LinkedCollectionEngine {

    public static void main(String args[]){
        LinkedCollection list=new LinkedCollection();
//        System.out.println(list.getTop().getElement());
        list.add("First");
        list.add("Second");
        list.add("Third");
        list.add("Fourth");
        list.add("Fifth");



        for (Object s : list.toArray())  System.out.println(s);


//        System.out.println(list.size());
//        System.out.println(list.getTop().getElement());
        list.remove("Fourth");
//        System.out.println(list.size());
//        System.out.println(list.getTop().getElement());
//        list.remove("Fifth");
        System.out.println(list.size());
//        System.out.println(list.getTop().getElement());
        list.remove("First");
        System.out.println(list.size());
//        System.out.println(list.getTop().getElement());
        System.out.println("-------------");
        for (Object ss : list.toArray())  System.out.println(ss);


    }

}
