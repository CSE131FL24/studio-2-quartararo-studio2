package studio2;

import java.util.Scanner;

public class Pi {

    static double distanceFromCenter(double x1, double y1) {
        return Math.sqrt(Math.pow((0 - x1), 2) + Math.pow((0 - y1), 2));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Throws: ");
        int totalDarts = in.nextInt();

        int insideCircle = 0;

        for (int darts = 0; darts < totalDarts; darts++) {
            double x1 = (Math.random() * 2) - 1;
            double y1 = (Math.random() * 2) - 1;

            if (distanceFromCenter(x1, y1) <= 1) {
                insideCircle++;
            }
        }

        double pi = ((double)(insideCircle)/totalDarts) * 4;

        System.out.println("π = " + pi);
    }
}
