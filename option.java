import java.util.Scanner;
import java.math.BigInteger;

/**
 * Base class for shared functionality like the scanner object.
 */
class MainMenu {
  public static final Scanner scanner = new Scanner(System.in);

  /**
   * Handles continuation options for the user.
   *
   * @return true if the user wants to continue, false otherwise.
   */
  public static boolean handleContinuation() {
    System.out.println("Do you want to quit (y), continue (n), or return to the menu (m)?");
    String input = scanner.next();

    switch (input.toLowerCase()) {
      case "y":
        System.out.println("Goodbye!");
        System.exit(0);
        return false;
      case "n":
        return true;
      case "m":
        CalculatorMenu.displayMenu();
        return false;
      default:
        System.out.println("Invalid input. Returning to menu.");
        CalculatorMenu.displayMenu();
        return false;
    }
  }
}

/**
 * Class to handle the main calculator menu and user interactions.
 */
class CalculatorMenu extends MainMenu {
  public static void main(String[] args) {
    displayMenu();
  }

  /**
   * Displays the main menu and handles user input.
   */
  public static void displayMenu() {
    System.out.println("Let's do some calculations!");
    System.out.println("What do you want to do?");
    System.out.println("Here are your options:");
    System.out.println("0 - Exit");
    System.out.println("1 - Addition");
    System.out.println("2 - Subtraction");
    System.out.println("3 - Division");
    System.out.println("4 - Multiplication");
    System.out.println("5 - Check Even or Odd");
    System.out.println("6 - Calculate Factorial");
    System.out.print("Enter any number listed above to continue: ");
    String choice = scanner.next();

    // Handle user input using switch statement
    switch (choice) {
      case "0":
        System.out.println("Goodbye!");
        System.exit(0);
        break;
      case "1":
        Addition.performOperation();
        break;
      case "2":
        Subtraction.performOperation();
        break;
      case "3":
        Division.performOperation();
        break;
      case "4":
        Multiplication.performOperation();
        break;
      case "5":
        EvenOddChecker.checkEvenOdd();
        break;
      case "6":
        FactorialCalculator.calculateFactorial();
        break;
      default:
        System.out.println("Invalid input. Please try again.");
        displayMenu();
        break;
    }
  }
}

/**
 * Abstract class for operations that involve two numbers.
 */
abstract class Operation extends MainMenu {
  /**
   * Performs an operation that involves two numbers.
   *
   * @param operationName the name of the operation to perform.
   * @return true if the operation was successful, false otherwise.
   */
  public static boolean performOperation(String operationName) {
    System.out.println("Enter the first number:");
    float num1 = scanner.nextFloat();
    System.out.println("Enter the second number:");
    float num2 = scanner.nextFloat();

    switch (operationName) {
      case "Addition":
        System.out.println("The sum is: " + (num1 + num2));
        break;
      case "Subtraction":
        System.out.println("The difference is: " + (num1 - num2));
        break;
      case "Multiplication":
        System.out.println("The product is: " + (num1 * num2));
        break;
      case "Division":
        if (num2 == 0) {
          System.out.println("Division by zero is not allowed.");
          return false;
        } else {
          System.out.println("The quotient is: " + (num1 / num2));
          break;
        }
      default:
        return false;
    }
    return handleContinuation();
  }
}

/**
 * Class to perform addition operations.
 */
class Addition extends Operation {
  public static void performOperation() {
    performOperation("Addition");
  }
}

/**
 * Class to perform subtraction operations.
 */
class Subtraction extends Operation {
  public static void performOperation() {
    performOperation("Subtraction");
  }
}

/**
 * Class to perform division operations.
 */
class Division extends Operation {
  public static void performOperation() {
    performOperation("Division");
  }
}

/**
 * Class to perform multiplication operations.
 */
class Multiplication extends Operation {
  public static void performOperation() {
    performOperation("Multiplication");
  }
}

/**
 * Class to check whether a number is even or odd.
 */
class EvenOddChecker extends MainMenu {
  /**
   * Checks whether a number is even or odd.
   */
  public static void checkEvenOdd() {
    System.out.println("Enter a number to check if it's even or odd:");
    int number = scanner.nextInt();

    if (number % 2 == 0) {
      System.out.println(number + " is even.");
    } else {
      System.out.println(number + " is odd.");
    }

    handleContinuation();
  }
}

/**
 * Class to calculate the factorial of a number.
 */
class FactorialCalculator extends MainMenu {
  /**
   * Calculates the factorial of a number.
   */
  public static void calculateFactorial() {
    System.out.println("Enter a number to calculate its factorial:");
    long number = scanner.nextLong();

    // Calculate factorial using BigInteger for large numbers
    BigInteger factorial = BigInteger.ONE;
    for (long i = 1; i <= number; i++) {
      factorial = factorial.multiply(BigInteger.valueOf(i));
    }

    System.out.println("The factorial of " + number + " is: " + factorial);
    handleContinuation();
  }
}
