import java.util.Scanner;
import java.math.BigInteger;

// Base class for shared functionality like the scanner object
class BaseMenu {
  public static Scanner scanner = new Scanner(System.in);

  // Helper method to read float input (avoids repetition)
  public static float getFloatInput(String prompt) {
    System.out.println(prompt);
    return scanner.nextFloat();
  }

  // Helper method to read int input (avoids repetition)
  public static int getIntInput(String prompt) {
    System.out.println(prompt);
    return scanner.nextInt();
  }
  
  // Helper method to handle continuation logic
  public static boolean shouldContinue() {
    System.out.println("Do you want to quit (y), continue (n), or return to the menu (m)?");
    String choice = scanner.next().toLowerCase();
    switch (choice) {
      case "y":
        System.out.println("Goodbye!");
        System.exit(0);
        return false;
      case "n":
        return true;
      case "m":
        CalculatorMenu.displayMainMenu();
        return false;
      default:
        System.out.println("Invalid input. Returning to menu.");
        CalculatorMenu.displayMainMenu();
        return false;
    }
  }
}

// Main menu that directs the user to the appropriate operation
class CalculatorMenu extends BaseMenu {
  public static void main(String[] args) {
    displayMainMenu();
  }

  public static void displayMainMenu() {
    System.out.println("Let's do some calculations!");
    System.out.println("What do you want to do?");
    System.out.println("0 - Exit");
    System.out.println("1 - Addition");
    System.out.println("2 - Subtraction");
    System.out.println("3 - Division");
    System.out.println("4 - Multiplication");
    System.out.println("5 - Check Even or Odd");
    System.out.println("6 - Calculate Factorial");
    System.out.println("Enter a number listed above to continue:");

    String userChoice = scanner.next();

    // Redirect to the appropriate operation
    switch (userChoice) {
      case "0":
        System.out.println("Goodbye!");
        System.exit(0);
        break;
      case "1":
        performAddition();
        break;
      case "2":
        performSubtraction();
        break;
      case "3":
        performDivision();
        break;
      case "4":
        performMultiplication();
        break;
      case "5":
        checkEvenOdd();
        break;
      case "6":
        calculateFactorial();
        break;
      default:
        System.out.println("Invalid input. Please try again:");
        displayMainMenu();
        break;
    }
  }

  // Perform addition
  public static void performAddition() {
    float num1 = getFloatInput("Enter the first number:");
    float num2 = getFloatInput("Enter the second number:");
    System.out.println("The sum of " + num1 + " and " + num2 + " is: " + (num1 + num2));
    if (!shouldContinue()) return;
  }

  // Perform subtraction
  public static void performSubtraction() {
    float num1 = getFloatInput("Enter the number to subtract from:");
    float num2 = getFloatInput("Enter the number to subtract:");
    System.out.println("The difference between " + num1 + " and " + num2 + " is: " + (num1 - num2));
    if (!shouldContinue()) return;
  }

  // Perform division
  public static void performDivision() {
    float num1 = getFloatInput("Enter the dividend:");
    float num2 = getFloatInput("Enter the divisor:");
    if (num2 == 0) {
      System.out.println("Division by zero is not allowed.");
      performDivision();  // Retry division
      return;
    }
    System.out.println("The quotient is: " + (num1 / num2));
    if (!shouldContinue()) return;
  }

  // Perform multiplication
  public static void performMultiplication() {
    float num1 = getFloatInput("Enter the first number:");
    float num2 = getFloatInput("Enter the second number:");
    System.out.println("The product of " + num1 + " and " + num2 + " is: " + (num1 * num2));
    if (!shouldContinue()) return;
  }

  // Check if a number is even or odd
  public static void checkEvenOdd() {
    int number = getIntInput("Enter a number to check if it's even or odd:");
    System.out.println(number + (number % 2 == 0 ? " is even." : " is odd."));
    if (!shouldContinue()) return;
  }

  // Calculate factorial
  public static void calculateFactorial() {
    long number = scanner.nextLong();
    BigInteger factorial = BigInteger.ONE;
    for (long i = 1; i <= number; i++) {
      factorial = factorial.multiply(BigInteger.valueOf(i));
    }
    System.out.println("The factorial of " + number + " is: " + factorial);
    if (!shouldContinue()) return;
  }
}
