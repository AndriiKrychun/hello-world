package learn.ray;


import java.util.Scanner;

public class HorizPyramid {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter height: ");
        int height = scanner.nextInt();
        for (int i=height; i>0; i--)
        {
            for (int j=1;j<=height*2-1;j++)
            {
                if (j>=i && j<height*2-i+1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }



    }

}