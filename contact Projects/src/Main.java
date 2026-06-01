import java.util.Scanner;

public class Main {

    // Email Validation Regex
    public static boolean isValidEmail(String email) {

        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    // Phone Validation
    public static boolean isValidPhone(String phone) {

        return phone.matches("\\d{10}");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ContactManager manager = new ContactManager();

        int choice;

        do {

            System.out.println("\n**** Welcome to Contact Management System ****");

            System.out.println("\nMAIN MENU");
            System.out.println("====================");
            System.out.println("[1] Add a new Contact");
            System.out.println("[2] List all Contacts");
            System.out.println("[3] Search for Contact");
            System.out.println("[4] Edit a Contact");
            System.out.println("[5] Delete a Contact");
            System.out.println("[0] Exit");
            System.out.println("====================");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phone = sc.nextLine();

                    if (!isValidPhone(phone)) {
                        System.out.println("Invalid phone number!");
                        break;
                    }

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    if (!isValidEmail(email)) {
                        System.out.println("Invalid email!");
                        break;
                    }

                    Contact contact = new Contact(name, phone, email);

                    manager.addContact(contact);

                    break;

                case 2:

                    manager.viewContacts();

                    break;

                case 3:

                    System.out.print("Enter Name to Search: ");
                    String searchName = sc.nextLine();

                    Contact found = manager.searchContact(searchName);

                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("Contact not found.");
                    }

                    break;

                case 4:

                    System.out.print("Enter Contact Name to Edit: ");
                    String oldName = sc.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Phone: ");
                    String newPhone = sc.nextLine();

                    if (!isValidPhone(newPhone)) {
                        System.out.println("Invalid phone number!");
                        break;
                    }

                    System.out.print("Enter New Email: ");
                    String newEmail = sc.nextLine();

                    if (!isValidEmail(newEmail)) {
                        System.out.println("Invalid email!");
                        break;
                    }

                    boolean updated = manager.updateContact(
                            oldName,
                            newName,
                            newPhone,
                            newEmail
                    );

                    if (updated) {
                        System.out.println("Contact updated successfully!");
                    } else {
                        System.out.println("Contact not found.");
                    }

                    break;

                case 5:

                    System.out.print("Enter Contact Name to Delete: ");
                    String deleteName = sc.nextLine();

                    boolean deleted = manager.deleteContact(deleteName);

                    if (deleted) {
                        System.out.println("Contact deleted successfully!");
                    } else {
                        System.out.println("Contact not found.");
                    }

                    break;

                case 0:

                    System.out.println("Exiting Program...");
                    break;

                default:

                    System.out.println("Invalid Choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}