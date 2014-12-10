package learn.ray;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class LeapYear {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            System.out.print("Enter year: ");
            int year = scanner.nextInt();
            leapYearFromJava(year);
            leapYear(year);
        }
    }

    public static void leapYearFromJava(int year)
    {
        GregorianCalendar calendar = new GregorianCalendar();
        String isLeap = (calendar.isLeapYear(year)) ? "leap" : "not leap";
        System.out.println("Year " + Integer.toString(year) + " is " + isLeap + ", says Java method");
    }

    public static void leapYear(int year)
    {
        String isLeap = ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) ? "leap" : "not leap";
        System.out.println("Year " + Integer.toString(year) + " is " + isLeap);
    }

}
