#include <iostream>
#include <limits>
#include <cstdlib>

// Function to get a valid float input from the user
float GetNumberFromUser() {
    float num;
    std::cin >> num;
    return num;
}

// Function to ask for a user response to continue, exit, or return to the menu
char AskToContinue() {
    char choice;
    std::cout << "Do you want to continue?\n";
    std::cout << "---- ---- ---- ---- \n";
    std::cout << "y = Yes\n";
    std::cout << "n = Exit\n";
    std::cout << "m = Return to Menu\n";
    std::cout << "---- ---- ---- ---- \n";
    std::cin >> choice;
    return choice;
}

// Function to handle invalid inputs
void PrintError() {
    std::cout << "Wrong Input :(\nTry again :) \n";
}

// Function to ask user to repeat the operation or return to menu
bool AskToRepeatOrReturnToMenu() {
    char user_choice = AskToContinue();
    if (user_choice == 'y') {
        return true;
    } else if (user_choice == 'n') {
        std::cout << "Bye :)\n";
        exit(0);  // Exit program immediately
    } else if (user_choice == 'm') {
        return false;  // Return to menu
    } else {
        PrintError();
        return true;  // Repeat the operation
    }
}

// Function to perform addition
float Add() {
    std::cout << "Enter two numbers you want to add: \n";
    float a = GetNumberFromUser();
    std::cout << "+ \n";
    float b = GetNumberFromUser();
    float result = a + b;
    std::cout << "Answer: " << result << "\n";
    return result;
}

// Function to perform subtraction
float Subtract() {
    std::cout << "Enter two numbers you want to subtract: \n";
    float a = GetNumberFromUser();
    std::cout << "- \n";
    float b = GetNumberFromUser();
    float result = a - b;
    std::cout << "Answer: " << result << "\n";
    return result;
}

// Function to perform division
float Divide() {
    std::cout << "Enter two numbers you want to divide: \n";
    float a = GetNumberFromUser();
    std::cout << "/ \n";
    float b = GetNumberFromUser();
    if (b == 0) {
        std::cout << "Error! Division by zero.\n";
        return 0;  // Return a default value to avoid division by zero
    }
    float result = a / b;
    std::cout << "Answer: " << result << "\n";
    return result;
}

// Function to perform multiplication
float Multiply() {
    std::cout << "Enter two numbers you want to multiply: \n";
    float a = GetNumberFromUser();
    std::cout << "x \n";
    float b = GetNumberFromUser();
    float result = a * b;
    std::cout << "Answer: " << result << "\n";
    return result;
}

// Function to check if a number is even or odd
void CheckEvenOrOdd() {
    std::cout << "Enter an integer: ";
    int n;
    std::cin >> n;
    if (n % 2 == 0) {
        std::cout << n << " is even.\n";
    } else {
        std::cout << n << " is odd.\n";
    }
}

// Function to calculate the factorial of a number
void CalculateFactorial() {
    int n;
    unsigned long long fact = 1;
    std::cout << "Enter an integer: ";
    std::cin >> n;
    if (n < 0) {
        std::cout << "Error! Factorial of a negative number doesn't exist.\n";
        return;
    } else {
        for (int i = 1; i <= n; ++i) {
            fact *= i;
        }
        std::cout << "Factorial of " << n << " = " << fact << "\n";
    }
}

// Function to display the menu and get user's choice
int ShowMenu() {
    std::cout << "Let's do some calculations.\n";
    std::cout << "What do you want to do?\n";
    std::cout << "Here are your options:\n";
    std::cout << "0 - Exit\n";
    std::cout << "1 - Sum\n";
    std::cout << "2 - Difference\n";
    std::cout << "3 - Divide\n";
    std::cout << "4 - Multiply\n";
    std::cout << "5 - Check even or odd\n";
    std::cout << "6 - To calculate factorial\n";
    std::cout << "Enter the number listed above to continue: \n";

    int choice;
    std::cin >> choice;
    return choice;
}

// Function to process the chosen operation
void ProcessOperation(int choice) {
    switch (choice) {
        case 1:  // Add
            Add();
            break;
        case 2:  // Subtract
            Subtract();
            break;
        case 3:  // Divide
            Divide();
            break;
        case 4:  // Multiply
            Multiply();
            break;
        case 5:  // Check Even or Odd
            CheckEvenOrOdd();
            break;
        case 6:  // Factorial
            CalculateFactorial();
            break;
        default:  // Invalid choice
            PrintError();
            return;
    }
}

// Main function to control the program flow
int main() {
    while (true) {
        int choice = ShowMenu();  // Get the user's choice from the menu
        ProcessOperation(choice); // Perform the operation based on the choice

        if (!AskToRepeatOrReturnToMenu()) {
            continue;  // If 'm' (menu), return to menu
        }
    }
}
