import java.util.List;
import java.util.Scanner;

/**
 * PatientManagerApp:
 * Contains the main method.
 * Handles all I/O operations using Scanner for input and System.out for output.
 * Interacts with the PatientManager class.
 */
public class PatientManagerApp {
    private static PatientManager patientManager = new PatientManager();

    /**
     * Main method, controls the input and output of the program
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int patientChoice2;

        do {
            System.out.println("Hello! Welcome to Patient Management System! \n Please select an option: \n1. Add a new patient \n2. Remove a patient \n3. View Patient Details \n4. Update patient information \n5. Search for patients \n6. Exit (1-6): ");
            patientChoice2 = in.nextInt();

            switch (patientChoice2) {
                case 1:
                    choice1();
                    break;
                case 2:
                    choice2();
                    break;
                case 3:
                    choice3();
                    break;
                case 4:
                    choice4();
                    break;
                case 5:
                    choice5();
                    break;
                case 6:
                    System.out.println("Thank you for using Patient Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please re-run the patient management system.");
                    break;
            }
        } while (patientChoice2 != 6);
    }

    /**
     * static void choice1() method that helps to add a new patient.
     * user enters patient details, name, age, and conditions and the program adds that patient into an ArrayList
     */
    public static void choice1() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter patient details \n Patient ID: ");
        int patientID = in.nextInt();
        in.nextLine(); // Consume the newline character left by nextInt()

        System.out.println("Patient Name: ");
        String patientName = in.nextLine();

        System.out.println("Patient Age");
        int patientAge = in.nextInt();
        in.nextLine(); // Consume the newline character left by nextInt()

        System.out.println("Patient Medical Condition: ");
        String patientCondition = in.nextLine();

        Patient patient = new Patient(patientID, patientName, patientAge, patientCondition);
        patientManager.addPatient(patient);
        System.out.println("Patient added successfully");
    }

    /**
     * static void choice2() method that removes a patient
     * user inputs the patientID and the program searches for the patient and removes him/her
     */
    public static void choice2() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter patient ID: ");
        int patientID = in.nextInt();
        in.nextLine(); // Consume the newline character left by nextInt()

        if (patientManager.removePatient(patientID)) {
            System.out.println("Patient removed successfully");
        } else {
            System.out.println("Patient not found");
        }
    }

    /**
     * static void choice3() method that views patient information
     * user inputs patientID, method searches it, and prints the information into the program
     */
    public static void choice3() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter patient ID: ");
        int patientID = in.nextInt();
        in.nextLine(); // Consume the newline character left by nextInt()

        Patient patient = patientManager.retrievePatient(patientID);

        if (patient != null) {
            System.out.println(patient);
        } else {
            System.out.println("Patient not found");
        }
    }

    /**
     * static void choice4() method that udpates patient details
     * user inputs patientID, method searches for the patient, and the user repeats the choice1() method to update information
     */
    public static void choice4() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter patient ID: ");
        int patientID = in.nextInt();
        in.nextLine(); // Consume the newline character left by nextInt()

        Patient patient = patientManager.retrievePatient(patientID);

        if (patient != null) {
            System.out.println("Enter new patient name: ");
            String newName = in.nextLine(); // Read the entire line including spaces
            System.out.println("Enter new patient age: ");

            while (!in.hasNextInt()) {
                System.out.println("Invalid age. Please enter a valid integer.");
                in.nextLine(); // Consume the invalid input
            }

            int newAge = in.nextInt();
            in.nextLine(); // Consume the newline character left by nextInt()

            System.out.println("Enter new medical condition: ");
            String newCondition = in.nextLine();

            patient.setName(newName);
            patient.setAge(newAge);
            patient.setMedicalCondition(newCondition);

            System.out.println("Patient information updated successfully");
        } else {
            System.out.println("Patient not found");
        }
    }

    /**
     * static void choice5() to search for patient information
     */
    public static void choice5() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter search term (patient name or ID): ");
        String searchTerm = in.next();

        List<Patient> searchResult = patientManager.searchPatients(searchTerm);

        if (!searchResult.isEmpty()) {
            for (Patient patient : searchResult) {
                System.out.println(patient);
            }
        } else {
            System.out.println("There were no patients that were found with that name/ID. please try again. ");
        }
    }
}
