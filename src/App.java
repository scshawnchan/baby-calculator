import javax.sound.midi.SysexMessage;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class App {

    private static final Scanner keyboard = new Scanner(System.in);
    private static final int ADDITION = 1;
    private static final int SUBTRACTION = 2;
    private static final int MULTIPLICATION = 3;
    private static final int DIVISION = 4;

    private static final int EXIT = 0;
    private static int mainMenuSelection = 0;

    private static boolean isCalculatorAvailable = true;

    public static void main(String[] args) {
        App app = new App();
        App.run();
    }

    private static void run() {
        // Basic Description
        System.out.println("Welcome to my calculator app. " +
                "This app can be used to perform basic arithmetic calculations such as addition, subtraction, multiplication and division.");
        while (isCalculatorAvailable) {
            mainMenuSelection = promptForMainMenu();
            if (mainMenuSelection == ADDITION) {
                BigDecimal firstNumber = promptForFirstNumber();
                BigDecimal secondNumber = promptForNextNumber();
                BigDecimal result = promptForAdditionOperation(firstNumber, secondNumber);
                System.out.println("The addition between " + firstNumber.toString() + " & "
                        + secondNumber.toString() + " is equal to " + result.toString() + ".");

            } else if (mainMenuSelection == SUBTRACTION) {
                BigDecimal firstNumber = promptForFirstNumber();
                BigDecimal secondNumber = promptForNextNumber();
                BigDecimal result = promptForSubtractionOperation(firstNumber, secondNumber);
                System.out.println(firstNumber.toString() + " subtracts "
                        + secondNumber.toString() + " is equal to " + result.toString() + ".");

            } else if (mainMenuSelection == MULTIPLICATION) {
                BigDecimal firstNumber = promptForFirstNumber();
                BigDecimal secondNumber = promptForNextNumber();
                BigDecimal result = promptForMultiplicationOperation(firstNumber, secondNumber);
                System.out.println("The multiplication between " + firstNumber.toString() + " & "
                        + secondNumber.toString() + " is equal to " + result.toString() + ".");

            } else if (mainMenuSelection == DIVISION) {
                BigDecimal firstNumber = promptForFirstNumber();
                BigDecimal secondNumber = promptForNextNumber();
                BigDecimal result = promptForMultiplicationOperation(firstNumber, secondNumber);
                System.out.println(firstNumber.toString() + " divides "
                        + secondNumber.toString() + " is equal to " + result.toString() + ".");

            } else if (mainMenuSelection == EXIT) {
                System.out.println("Thanks for using the app!");
                break;
            }
        }

    }

    private static BigDecimal promptForUserNumber() {
        BigDecimal output = null;
        try {
            String input = keyboard.next();
            output = new BigDecimal(input);
            return output;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format! Please only provide numbers/decimals only");
            System.out.println("Please provide a valid number:");
            promptForUserNumber();
        }
        return null;
    }
    private static int promptForMainMenu() {
        System.out.println("Choose an option to proceed:");
        System.out.println("1: Addition");
        System.out.println("2: Subtraction");
        System.out.println("3: Multiplication");
        System.out.println("4: Division");
        System.out.println("0: Exit");
        int output = 0;
        try {
            String input = keyboard.next();
            output = Integer.parseInt(input);
            if (output < 1 || output > 4) {
                System.out.println("Invalid input format! Please only provide numbers/decimals only");
                System.out.println("Please provide a valid number:");
                System.out.println(" ");
                promptForMainMenu();
            }
            return output;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format! Please only provide numbers/decimals only");
            System.out.println("Please provide a valid number:");
            System.out.println(" ");
            promptForMainMenu();
        }
        return output;
    }

    private static BigDecimal promptForAdditionOperation(BigDecimal firstNumber, BigDecimal secondNumber) {
        return firstNumber.add(secondNumber);
    }
    private static BigDecimal promptForSubtractionOperation(BigDecimal firstNumber, BigDecimal secondNumber) {
        return firstNumber.subtract(secondNumber);
    }
    private static BigDecimal promptForMultiplicationOperation(BigDecimal firstNumber, BigDecimal secondNumber) {
        return firstNumber.multiply(secondNumber);
    }
    private static BigDecimal promptForDivisionOperation(BigDecimal firstNumber, BigDecimal secondNumber) {
        return (firstNumber.divide(secondNumber)).setScale(2, RoundingMode.HALF_UP);
    }
    private static void promptForReturn() {
        System.out.println("Press RETURN to continue.");
        keyboard.nextLine();
    }

    private static BigDecimal promptForFirstNumber() {
        System.out.println("Please provide the initial number for this calculation:");
        return promptForUserNumber();
    }

    private static BigDecimal promptForNextNumber() {
        System.out.println("Please provide the next number for this calculation:");
        return promptForUserNumber();
    }

}