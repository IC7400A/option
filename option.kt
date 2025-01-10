import java.math.BigInteger
import java.util.*

internal object index {
    val sc = Scanner(System.`in`)
}

fun main() {
    option.main()
}

internal object option {
    @JvmStatic
    fun main(args: Array<String>) {
        showMainMenu()
    }

    // Function to display the main menu and handle user input
    private fun showMainMenu() {
        println("Let's do some calculations!")
        println("What do you want to do?")
        println("Here are your options:")
        println("0 - Exit")
        println("1 - Sum")
        println("2 - Difference")
        println("3 - Divide")
        println("4 - Multiply")
        println("5 - Check even or odd")
        println("6 - Calculate factorial")
        println("Enter a number listed above to continue:")

        val choice = sc.next()

        when (choice) {
            "0" -> exitProgram()
            "1" -> performOperation("add")
            "2" -> performOperation("subtract")
            "3" -> performOperation("divide")
            "4" -> performOperation("multiply")
            "5" -> checkEvenOdd()
            "6" -> calculateFactorial()
            else -> {
                println("Invalid input. Please try again.")
                showMainMenu()
            }
        }
    }

    // Exit the program
    private fun exitProgram() {
        println("Goodbye! :)")
        System.exit(0)
    }

    // Ask if the user wants to continue, return to the menu, or exit
    private fun shouldContinue(): Boolean {
        println("Do you want to quit (y), continue (n), or return to the menu (m)?")
        val choice = sc.next().lowercase()
        return when (choice) {
            "y" -> {
                println("Goodbye! :)")
                System.exit(0)
                false
            }
            "n" -> true
            "m" -> {
                showMainMenu()
                false
            }
            else -> {
                println("Invalid input, returning to menu.")
                showMainMenu()
                false
            }
        }
    }

    // Perform addition, subtraction, multiplication, and division
    private fun performOperation(operation: String) {
        val num1 = getUserInput("Enter the first number:")
        val num2 = getUserInput("Enter the second number:")
        val result = when (operation) {
            "add" -> num1 + num2
            "subtract" -> num1 - num2
            "multiply" -> num1 * num2
            "divide" -> {
                if (num2 == 0f) {
                    println("Division by zero is not allowed.")
                    performOperation("divide") // Retry division
                    return
                }
                num1 / num2
            }
            else -> 0f
        }

        println("The result is: $result")
        if (!shouldContinue()) return
    }

    // Check if a number is even or odd
    private fun checkEvenOdd() {
        println("Enter a number to check:")
        val number = sc.nextInt()
        println("$number is ${if (number % 2 == 0) "even" else "odd"}.")
        if (!shouldContinue()) return
    }

    // Calculate factorial
    private fun calculateFactorial() {
        println("Enter a number to calculate its factorial:")
        val number = sc.nextLong()
        var factorial = BigInteger.ONE
        for (i in 1..number) {
            factorial = factorial.multiply(BigInteger.valueOf(i))
        }
        println("The factorial of $number is: $factorial")
        if (!shouldContinue()) return
    }

    // Helper function to get user input for numbers
    private fun getUserInput(prompt: String): Float {
        println(prompt)
        return sc.nextFloat()
    }
}
