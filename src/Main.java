import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();

        int round = 0;
        int sum = 0;
        int point = 0;
        int dice1 = 0;
        int dice2 = 0;
        String choice = "";

        boolean gDone = false;
        boolean cDone = false;
        boolean done = false;
        do {
            done = false;
            gDone = false;
            cDone = false;
            round = 0;
            do {
                round++;
                dice1 = rnd.nextInt(6) + 1;
                dice2 = rnd.nextInt(6) + 1;
                sum = dice1 + dice2;
                System.out.println("Round: " + round + " Dice 1: " + dice1 + " Dice 2: " + dice2 + " Sum: " + sum);
                if (round == 1){
                    if (sum == 2 || sum == 3){
                        System.out.println("You crapped out! You lose!");
                        gDone = true;
                    }
                    else if (sum == 7 || sum == 11){
                        System.out.println("You rolled a natural! You win!");
                        gDone = true;
                    }
                    else {
                        point = sum;
                        System.out.println("Your point is: " + point + ". roll again!");
                    }
                }
                else {
                    System.out.println(" Point: " + point);
                    if (sum == 7){
                        System.out.println("You rolled 7! You lose!");
                        gDone = true;
                    } else if (sum == point) {
                        System.out.println("You hit the point! You win!");
                        gDone = true;
                    }
                    else {
                        System.out.println("You missed the point! roll again!");
                    }
                }
            }while (!gDone);

            do {
                System.out.println("Would you like to play again? [Y/N]");
                choice = in.nextLine();
                if (choice.equalsIgnoreCase("Y")) {
                    done = false;
                    cDone = true;
                } else if (choice.equalsIgnoreCase("N")) {
                    done = true;
                    cDone = true;
                }
                else {
                    System.out.println(choice + " is not a valid input.");
                }
            }while (!cDone);
        } while (!done);
    }
}