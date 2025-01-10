import sys
import os
import math

class Calculator:
    @staticmethod
    def get_input(prompt=""):
        """Get user input with a prompt."""
        return input(prompt)

    @staticmethod
    def ask_to_continue():
        """Ask the user if they want to quit, continue or return to the menu."""
        print("Do you want to quit or go to the menu? (Enter 'y' to quit, 'n' to continue, 'm' for menu):")
        user_input = Calculator.get_input()
        if user_input == "y":
            print("Goodbye :)")
            sys.exit(0)
        elif user_input == "n":
            return True
        elif user_input == "m":
            option.show_menu()
            return False
        else:
            print("Invalid input. Please try again.")
            return False

class Sum(Calculator):
    @staticmethod
    def perform():
        """Perform the addition operation."""
        while True:
            print("Enter the numbers to add: ")
            a = float(Calculator.get_input())
            print("+")
            b = float(Calculator.get_input())
            result = a + b
            print(f"= {result}")
            if not Calculator.ask_to_continue():
                return

class Difference(Calculator):
    @staticmethod
    def perform():
        """Perform the subtraction operation."""
        while True:
            print("Enter the numbers to subtract: ")
            a = float(Calculator.get_input())
            print("-")
            b = float(Calculator.get_input())
            result = a - b
            print(f"= {result}")
            if not Calculator.ask_to_continue():
                return

class Division(Calculator):
    @staticmethod
    def perform():
        """Perform the division operation."""
        while True:
            print("Enter the numbers to divide: ")
            a = float(Calculator.get_input())
            print("/")
            b = float(Calculator.get_input())
            if b == 0:
                print("Cannot divide by zero. Please try again.")
                continue
            result = a / b
            print(f"= {result}")
            if not Calculator.ask_to_continue():
                return

class Multiplication(Calculator):
    @staticmethod
    def perform():
        """Perform the multiplication operation."""
        while True:
            print("Enter the numbers to multiply: ")
            a = float(Calculator.get_input())
            print("x")
            b = float(Calculator.get_input())
            result = a * b
            print(f"= {result}")
            if not Calculator.ask_to_continue():
                return

class EvenOdd(Calculator):
    @staticmethod
    def perform():
        """Check if a number is even or odd."""
        while True:
            print("Enter the number to check:")
            number = int(Calculator.get_input())
            result = "even" if number % 2 == 0 else "odd"
            print(f"{number} is {result}.")
            if not Calculator.ask_to_continue():
                return

class Factorial(Calculator):
    @staticmethod
    def perform():
        """Calculate the factorial of a number."""
        while True:
            print("Enter the number to calculate its factorial:")
            number = int(Calculator.get_input())
            result = math.factorial(number)
            print(f"Factorial of {number} = {result}")
            if not Calculator.ask_to_continue():
                return

class Option:
    @staticmethod
    def show_menu():
        """Display the main menu and handle user choices."""
        print("Let's do some calculations!")
        print("What do you want to do?")
        print("Here are your options:")
        print("0 - Exit")
        print("1 - Sum")
        print("2 - Difference")
        print("3 - Divide")
        print("4 - Multiply")
        print("5 - Check even or odd")
        print("6 - Calculate factorial")
        print("Enter any number listed above to continue:")

        choice = Calculator.get_input()

        if choice == "0":
            print("Goodbye! :)")
            sys.exit(0)
        elif choice == "1":
            Sum.perform()
        elif choice == "2":
            Difference.perform()
        elif choice == "3":
            Division.perform()
        elif choice == "4":
            Multiplication.perform()
        elif choice == "5":
            EvenOdd.perform()
        elif choice == "6":
            Factorial.perform()
        else:
            print("Invalid input. Please try again.")
            Option.show_menu()

# Start the program
Option.show_menu()
