import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {
        boolean quit = false;
        printInstructions();

        while (!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;

                case 1:
                    mobilePhone.printContactList();
                    break;

                case 2:
                    addNewContact();
                    break;

                case 3:
                    removeContact();
                    break;

                case 4:
                    updateContact();
                    break;

                case 5:
                    queryContact();
                    break;
            }
        }
    }

    public static void printInstructions() {
        System.out.println("My Contacts:\n" +
                           "0 - Print the Instructions.\n" +
                           "1 - Print Contact List.\n" +
                           "2 - ADD a new Contact.\n" +
                           "3 - REMOVE a Contact.\n" +
                           "4 - UPDATE a Contact.\n" +
                           "5 - QUERY for a Contact.");

        System.out.println("Choose your action:");
    }

    public static void addNewContact() {
        System.out.println("New Contact name :");
        String name = scanner.nextLine();

        System.out.println("New Contact Phone Number: ");
        String phoneNumber = scanner.nextLine();

        Contact newContact = Contact.createContact(name, phoneNumber);

        if (mobilePhone.addContact(newContact)) {
            System.out.println("New Contact Added: " + name + " -> " + phoneNumber);
        } else {
            System.out.println("Can not add, " + name + " already exists.");
        }
    }

    public static void removeContact() {
        System.out.println("Enter Contact name: ");
        String name = scanner.nextLine();

        Contact existingContact = mobilePhone.queryContact(name);

        if (existingContact == null) {
            System.out.println("Contact was not found");
            return;
        }

        if (mobilePhone.removeContact(existingContact)) {
            System.out.println("Contact was Deleted.");
        } else {
            System.out.println("ERROR Deleting Contact");
        }
    }

    public static void updateContact() {
        System.out.println("Enter contact name: ");
        String name = scanner.nextLine();

        Contact oldContact = mobilePhone.queryContact(name);

        if (oldContact == null) {
            System.out.println("The contact " + name + " does not exist.");
            return;
        }

        System.out.println("Enter new Contact name: ");
        String newName = scanner.nextLine();

        System.out.println("Enter new Contact Phone Number: ");
        String newPhoneNumber = scanner.nextLine();

        Contact newContact = Contact.createContact(newName, newPhoneNumber);

        if (mobilePhone.updateContact(oldContact, newContact)) {
            System.out.println("Contact updated.");
        } else {
            System.out.println("ERROR updating Contact");
        }
    }

    public static void queryContact() {
        System.out.println("Enter Contact name:");
        String name = scanner.nextLine();

        Contact existingContact = mobilePhone.queryContact(name);

        if (existingContact == null) {
            System.out.println("Contact not Found.");
            return;
        }

        System.out.println("Name: " + existingContact.getName() + "  Phone number: " + existingContact.getPhoneNumber());
    }
}
