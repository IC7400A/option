#import <Foundation/Foundation.h>

#define SUCCESS 0
#define ERROR_INVALID_INPUT -1
#define ERROR_DIVIDE_BY_ZERO -2
#define EXIT_CODE 0
#define ADD_CODE 1
#define SUBTRACT_CODE 2
#define DIVIDE_CODE 3
#define MULTIPLY_CODE 4
#define EVENODD_CODE 5
#define FACTORIAL_CODE 6

/* Function Prototypes */
float GetNumberFromUser(void);
char AskToContinue(void);
void PrintError(void);
int Add(void);
int Subtract(void);
int Divide(void);
int Multiply(void);
void CheckEvenOrOdd(void);
void CalculateFactorial(void);
int ShowMenu(void);
void ProcessOperation(int choice);

/* Function to get a valid float input from the user */
float GetNumberFromUser(void) {
    float num = 0.0;
    scanf("%f", &num);
    if (num == 0.0) {
        PrintError();
        return -1.0;  /* Return an invalid value on error */
    }
    return num;
}

/* Function to ask for a user response to continue, exit, or return to the menu */
char AskToContinue(void) {
    char choice = '\0';
    printf("Do you want to continue?\n");
    printf("---- ---- ---- ---- \n");
    printf("y = Yes\n");
    printf("n = Exit\n");
    printf("m = Return to Menu\n");
    printf("---- ---- ---- ---- \n");
    scanf(" %c", &choice);
    return choice;
}

/* Function to handle invalid inputs */
void PrintError(void) {
    printf("Wrong Input :(\nTry again :) \n");
}

/* Function to perform addition */
int Add(void) {
    printf("Enter two numbers you want to add: \n");
    float a = GetNumberFromUser();
    if (a == -1.0) return ERROR_INVALID_INPUT;

    printf("+ \n");
    float b = GetNumberFromUser();
    if (b == -1.0) return ERROR_INVALID_INPUT;

    printf("Answer: %.2f \n", a + b);
    return SUCCESS;
}

/* Function to perform subtraction */
int Subtract(void) {
    printf("Enter two numbers you want to subtract: \n");
    float a = GetNumberFromUser();
    if (a == -1.0) return ERROR_INVALID_INPUT;

    printf("- \n");
    float b = GetNumberFromUser();
    if (b == -1.0) return ERROR_INVALID_INPUT;

    printf("Answer: %.2f \n", a - b);
    return SUCCESS;
}

/* Function to perform division */
int Divide(void) {
    printf("Enter two numbers you want to divide: \n");
    float a = GetNumberFromUser();
    if (a == -1.0) return ERROR_INVALID_INPUT;

    printf("/ \n");
    float b = GetNumberFromUser();
    if (b == -1.0) return ERROR_INVALID_INPUT;

    if (b == 0.0) {
        printf("Error! Division by zero.\n");
        return ERROR_DIVIDE_BY_ZERO;
    }

    printf("Answer: %.2f \n", a / b);
    return SUCCESS;
}

/* Function to perform multiplication */
int Multiply(void) {
    printf("Enter two numbers you want to multiply: \n");
    float a = GetNumberFromUser();
    if (a == -1.0) return ERROR_INVALID_INPUT;

    printf("x \n");
    float b = GetNumberFromUser();
    if (b == -1.0) return ERROR_INVALID_INPUT;

    printf("Answer: %.2f \n", a * b);
    return SUCCESS;
}

/* Function to check if a number is even or odd */
void CheckEvenOrOdd(void) {
    printf("Enter an integer: ");
    int n = 0;
    if (scanf("%d", &n) != 1) {
        PrintError();
        return;
    }

    if (n % 2 == 0) {
        printf("%d is even.\n", n);
    } else {
        printf("%d is odd.\n", n);
    }
}

/* Function to calculate the factorial of a number */
void CalculateFactorial(void) {
    int n = 0;
    unsigned long long fact = 1;
    printf("Enter an integer: ");
    if (scanf("%d", &n) != 1) {
        PrintError();
        return;
    }

    if (n < 0) {
        printf("Error! Factorial of a negative number doesn't exist.\n");
        return;
    } else {
        for (int i = 1; i <= n; ++i) {
            fact *= i;
        }
        printf("Factorial of %d = %llu \n", n, fact);
    }
}

/* Function to display the menu and get user's choice */
int ShowMenu(void) {
    printf("Let's do some calculations.\n");
    printf("What do you want to do?\n");
    printf("Here are your options:\n");
    printf("0 - Exit\n");
    printf("1 - Sum\n");
    printf("2 - Difference\n");
    printf("3 - Divide\n");
    printf("4 - Multiply\n");
    printf("5 - Check even or odd\n");
    printf("6 - To calculate factorial\n");
    printf("Enter the number listed above to continue: \n");

    int choice = 0;
    scanf("%d", &choice);
    return choice;
}

/* Function to process the chosen operation */
void ProcessOperation(int choice) {
    int status = SUCCESS;
    switch (choice) {
        case ADD_CODE:  // Add
            status = Add();
            break;
        case SUBTRACT_CODE:  // Subtract
            status = Subtract();
            break;
        case DIVIDE_CODE:  // Divide
            status = Divide();
            break;
        case MULTIPLY_CODE:  // Multiply
            status = Multiply();
            break;
        case EVENODD_CODE:  // Check Even or Odd
            CheckEvenOrOdd();
            return;
        case FACTORIAL_CODE:  // Factorial
            CalculateFactorial();
            return;
        default:  // Invalid choice
            PrintError();
            return;
    }

    if (status == ERROR_INVALID_INPUT) {
        PrintError();
    }
}

/* Main function to control the program flow */
int main(int argc, const char * argv[]) {
    @autoreleasepool {
        int choice = ShowMenu();  // Get the user's choice from the menu
        while (choice != EXIT_CODE) {
            ProcessOperation(choice);  // Perform the operation based on the choice

            char continueChoice = AskToContinue();  // Ask if the user wants to continue
            if (continueChoice == 'y') {
                choice = ShowMenu();  // Show the menu again if the user wants to continue
            } else if (continueChoice == 'n') {
                printf("Goodbye! :)\n");
                break;  // Exit the program
            } else if (continueChoice == 'm') {
                choice = ShowMenu();  // Return to the menu
            } else {
                PrintError();  // Invalid choice
                choice = ShowMenu();  // Show menu again for retry
            }
        }
    }
    return 0;
}
