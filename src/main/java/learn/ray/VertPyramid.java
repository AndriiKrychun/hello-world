package learn.ray;

import java.util.Scanner;

public class VertPyramid {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter height: ");
        int height = scanner.nextInt();
        for (int i=1; i<=height; i++)
        {
            for (int j=1;j<=i;j++)
            {
                System.out.print("*");
            }
            System.out.println("");
        }
        for (int i=height-1; i>0; i--)
        {
            for (int j=i;j>0;j--)
            {
                System.out.print("*");
            }
            System.out.println("");
        }


    }

}
