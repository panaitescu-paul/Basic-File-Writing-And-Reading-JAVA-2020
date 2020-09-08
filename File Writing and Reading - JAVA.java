import java.io.*;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) throws IOException {
//        Declarations
        Scanner scanner = new Scanner(System.in);
        String name = "";
        String email = "";
        String phone = "";
        String previousContent = "";
        FileWriter fWriter = null;
        BufferedWriter writer = null;
        String answer = "y";

        while(answer.equals("y") )
        {
            // Enter multiple Keyboard Inputs
            System.out.print("Enter Name: ");
            name = scanner.nextLine();

            System.out.print("Enter Email Address: ");
            email = scanner.nextLine();

            System.out.print("Enter Phone Number: ");
            phone = scanner.nextLine();

            previousContent = previousContent + name + "\n" + email + "\n" + phone + "\n";

            try {
                fWriter = new FileWriter("text.txt");
                writer = new BufferedWriter(fWriter);

                // Write data to the file
                writer.write(String.valueOf(previousContent));

                // Close the file
                writer.close();

            } catch (Exception e) {
                System.out.println("Error!");
            }

            // Read data from the file
            readFile();
            System.out.print("Do you wanna add another person? y/n: ");
            answer = scanner.nextLine();

            // Exiting
            if(answer.equals("n"))
            {
                System.out.println("Exiting!");
                break;
            }
        }
    }
    public static void readFile() {
        try {
            File myObj = new File("text.txt");
            Scanner myReader = new Scanner(myObj);

            // Read every line of the file
            while(myReader.hasNext() ) {
                String name = myReader.nextLine();
                System.out.println("Name: " +  name);

                String email = myReader.nextLine();
                System.out.println("Email: " +  email);

                String phone = myReader.nextLine();
                System.out.println("Phone number is: " +  phone);
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
