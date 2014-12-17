package learn.ray;

import tasks.LeapYearAlgorithm;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class LeapYear implements LeapYearAlgorithm {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LeapYear leapYear = new LeapYear();
        while (true) {
            System.out.print("Enter year: ");
            int year = scanner.nextInt();
            leapYear.leapYearFromJava(year);
            leapYear.isLeapYear(year);
        }
    }

    public void leapYearFromJava(int year) {
        GregorianCalendar calendar = new GregorianCalendar();
        String isLeapString = (calendar.isLeapYear(year)) ? "leap" : "not leap";
        System.out.println("Year " + Integer.toString(year) + " is " + isLeapString + ", says Java method");
    }

    @Override
    public boolean isLeapYear(int year) {
        boolean isLeap = ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
        String isLeapString = isLeap ? "leap" : "not leap";
        System.out.println("Year " + Integer.toString(year) + " is " + isLeapString);
        return isLeap;
    }
}
