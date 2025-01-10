#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// Function to scan float values
float scan() {
    float num;
    scanf("%f", &num);
    return num;
}

// Function to scan char values
char scanc() {
    char choice;
    printf("Do you want to continue?\n");
    printf("---- ---- ---- ---- \n");
    printf("y = Yes \n");
    printf("n = Exit \n");
    printf("m = Return to Menu \n");
    printf("---- ---- ---- ---- \n");
    scanf(" %c", &choice); // Note the space before %c to consume any trailing whitespace
    return choice;
}

// Error handling function for invalid inputs
void err() {
    printf("Wrong Input :()\nTry again :) \n");
}

// Function to perform addition
float add() {
    float a, b;
    printf("Enter Number you want to add: \n");
    a = scan();
    printf("+ \n");
    b = scan();
    float result = a + b;
    printf("Answer: %g \n", result);
    return result;
}

// Function to perform subtraction
float subtract() {
    float a, b;
    printf("Enter Number you want to subtract: \n");
    a = scan();
    printf("- \n");
    b = scan();
    float result = a - b;
    printf("Answer: %g \n", result);
    return result;
}

// Function to perform division
float divide() {
    float a, b;
    printf("Enter Number you want to divide: \n");
    a = scan();
    printf("/ \n");
    b = scan();
    if (b == 0) {
        printf("Error! Division by zero is not allowed.\n");
        return 0;
    }
    float result = a / b;
    printf("Answer: %g \n", result);
    return result;
}

// Function to perform multiplication
float multiply() {
    float a, b;
    printf("Enter Number you want to multiply: \n");
    a = scan();
    printf("x \n");
    b = scan();
    float result = a * b;
    printf("Answer: %g \n", result);
    return result;
}

// Function to check even or odd
void check_even_odd() {
    int n;
    printf("Enter an integer: ");
    scanf("%d", &n);
    (n % 2 == 0) ? printf("%d is even. \n", n) : printf("%d is odd. \n", n);
}

// Function to calculate factorial
void factorial() {
    int n;
    unsigned long long fact = 1;
    printf("Enter an integer: ");
    scanf("%d", &n);
    if (n < 0) {
        printf("Error! Factorial of a negative number doesn't exist. \n");
    } else {
        for (int i = 1; i <= n; ++i) {
            fact *= i;
        }
        printf("Factorial of %d = %llu \n", n, fact);
    }
}

// Function to display the menu and get the user's choice
int show_menu() {
    printf("Let's do some calculations\n");
    printf("What do you want to do?\n");
    printf("Here are your options:\n");
    printf("0 - Exit\n");
    printf("1 - Sum\n");
    printf("2 - Difference\n");
    printf("3 - Divide\n");
    printf("4 - Multiply\n");
    printf("5 - Check even or odd\n");
    printf("6 - To calculate factorial\n");
    printf("Enter any number listed above to continue: \n");

    return (int)scan();
}

// Function to ask the user whether they want to continue, exit, or return to the menu
char ask_to_continue() {
    return scanc();
}

int main() {
    int choice;

    while (1) {
        choice = show_menu();
        
        switch(choice) {
            case 0:
                printf("Bye :)\n");
                exit(0);

            case 1:
                add();
                break;

            case 2:
                subtract();
                break;

            case 3:
                divide();
                break;

            case 4:
                multiply();
                break;

            case 5:
                check_even_odd();
                break;

            case 6:
                factorial();
                break;

            default:
                err();
                break;
        }

        char continue_choice = ask_to_continue();
        
        if (continue_choice == 'n') {
            printf("Bye :)\n");
            exit(0);
        } else if (continue_choice == 'm') {
            continue; // Go back to the menu
        } else if (continue_choice != 'y') {
            err();
        }
    }

    return 0;
}
