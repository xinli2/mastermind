import java.util.Scanner;
import controller.MastermindController;
import model.MastermindModel;
/**
 * 
 * @author Xin Li
 *
 */
public class Mastermind {

	public static void main(String[] args) {
		// This class represents the view, it should be how uses play the game
		System.out.println("Welcome to Mastermind!");
		System.out.print("Would you like to play? ");
        Scanner scanner = new Scanner(System.in);
        while (true){
            String ans=scanner.nextLine();
            if (ans.equals("yes")) {
                break;
            }
            if (ans.equals("no")){
                System.exit(0);
            }
            else {

                System.out.print("Would you like to play? ");
            }
        }
        System.out.println();
        System.out.println();
        MastermindModel mastermindModel = new MastermindModel();
        MastermindController mastermindController = new MastermindController(mastermindModel);
        String guess;
        int times = 1;
        do {
            System.out.print("Enter guess number " + times + ": ");
            guess = scanner.next();
            if (guess.length() != 4) {
                continue;
            }
            System.out.println("Colors in the correct place: " + mastermindController.getRightColorRightPlace(guess));
            System.out.println("Colors correct but in wrong place: " + mastermindController.getRightColorWrongPlace(guess));
            System.out.println();
            times++;
            if (times == 11) {
                System.out.println("you lost");
                System.exit(0);
            }
        } while (!mastermindController.isCorrect(guess));
        System.out.println("you win in " + times + " times");
	}

}
