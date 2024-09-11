package studio2;
import java.util.Scanner;

public class Ruin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("\nStarting Amount: $");
        double startAmount = in.nextDouble();

        System.out.print("Win Chance: ");
        double winChance = in.nextDouble();

        System.out.print("Win Limit: $");
        double winLimit = in.nextDouble();

        System.out.print("Simulated Days: ");
        int totalSimulations = in.nextInt();

        int ruins = 0;
        double expectedRuin = 0;

        for (int days = 0; days < totalSimulations; days++) {
            double money = startAmount;
            int plays = 0;
            System.out.println("\nDay " + days);

            while (money <= winLimit && money >= 0) {
                if (Math.random() < winChance) {
                    money++;
                } else {
                    money--;
                }
                plays++;
            }

            System.out.println("Plays: " + plays);

            if (money <= 0) {
                System.out.println("Ruin");
                ruins++;
            } else if (money >= winLimit ) {
                System.out.println("Success");
            }


        }

        double ruinRate = ((double)ruins)/totalSimulations;
        System.out.println("\nctual Ruin Rate: " + ruinRate);

        if (winChance == 0.5) {
            expectedRuin = 1 - (startAmount/winLimit);
        } else {
            expectedRuin = (Math.pow(((1 - winChance)/winChance), startAmount) - Math.pow(((1 - winChance)/winChance), winLimit)) / (1 - Math.pow(((1 - winChance)/winChance), winLimit)); 
        }

        System.out.println("Expected Ruin Rate " + expectedRuin);
    }

}
