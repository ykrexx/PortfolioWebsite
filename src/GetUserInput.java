import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * The GetUserInput class presents a simple menu to the user and
 * dispatches to either ViewCustomers or ModifyCustomers.
 * 
 * Replaces GetInputFromUser with direct input reading method.
 * 
 * @author BLP
 * @version 04/22/2025
 */
public class GetUserInput {

    /**
     * Entry point: prompts for an action and invokes the corresponding class.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Prompt the user for choice using custom input method
        int choice = ReadIntegerFromUser(
            "Select an option:\n" +
            "1 - View Customers\n" +
            "2 - Create Modified Customers File\n" +
            "Enter your choice: "
        );

        // Dispatch based on user selection
        switch (choice) {
            case 1:
                // Display the customers report
                ViewCustomers view = new ViewCustomers();
                view.displayCustomers();
                break;
            case 2:
                // Generate the modified customers XML
                ModifyCustomers modifier = new ModifyCustomers();
                modifier.modifyCustomers();
                break;
            default:
                System.out.println("Invalid option. Exiting.");
        }
    }

    /**
     * Reads an integer from user input with a prompt and validation.
     * Recursively re-prompts on invalid input.
     * 
     * @param prompt The message to display before input.
     * @return A valid integer entered by the user.
     */
    public static int ReadIntegerFromUser(String prompt) {
        int intValue = 0;
        try {
            System.out.print(prompt);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();
            intValue = Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
            return ReadIntegerFromUser(prompt); // Recursively prompt again
        }
        return intValue;
    }
}
