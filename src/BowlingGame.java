import java.util.Scanner;

public class BowlingGame {

    private int roll = 0;
    private int[] rolls = new int[21]; // worst case of number of rolls can be 21 because of no strikes and a last spare

    public void roll(int pinsDown) {
        rolls[roll++] = pinsDown;
    }


    public void roll(int... rolls) {
        for (int pinsDown : rolls) {
            roll(pinsDown);
        }
    }

    public int getScore() {
        int score = 0;

        int cursor = 0; // to know where we are in the game

        //we will iterate on number of frames that is max 10.
        for (int frame = 0; frame < 10; frame++) {

            if (isStrike(cursor)) { //to check the strike case
                score += 10 + rolls[cursor + 1] + rolls[cursor + 2];
                cursor++;
            } else if (isSpare(cursor)) { //to check the spare case
                score += 10 + rolls[cursor + 2];
                cursor += 2;
            } else {
                score += rolls[cursor] + rolls[cursor + 1];
                cursor += 2;
            }
        }
        return score; //score value is added by the number of pins down
    }

    private boolean isSpare(int cursor) {
        return rolls[cursor] + rolls[cursor + 1] == 10;
    }

    private boolean isStrike(int cursor) {
        return rolls[cursor] == 10;
    }

    public static void main(String args[]) {
        BowlingGame game = new BowlingGame();
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Bowling Rolls: ");
        int rolls = input.nextInt();
        System.out.print("Enter Bowling Pins: ");
        int[] rollsValues = new int[12];
        for (int i = 0; i < rolls; i++) {
            rollsValues[i] = input.nextInt();
        }

        game.roll(rollsValues);
        System.out.println("game score is :" + game.getScore());
    }
}