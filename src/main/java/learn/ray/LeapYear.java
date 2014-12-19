package learn.ray;

import tasks.LeapYearAlgorithm;

public class LeapYear implements LeapYearAlgorithm {


    @Override
    public boolean isLeapYear(int year) {
        boolean isLeap = ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
//        String isLeapString = isLeap ? "leap" : "not leap";
//        System.out.println("Year " + Integer.toString(year) + " is " + isLeapString);
        return isLeap;
    }
}
