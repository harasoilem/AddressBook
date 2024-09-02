package addressbook;

import addressbook.AddressBook;
import addressbook.Contact;

import java.util.Scanner;

public class Main {
    private static AddressBook addressBook = new AddressBook();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("Address Book Menu:");
            System.out.println("1. Show all contacts");
            System.out.println("2. Add new contact");
            System.out.println("3. Search contact by name");
            System.out.println("4. Search contact by phone");
            System.out.println("5. Edit contact by name");
            System.out.println("6. Delete contact by name");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    showAllContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    searchByName();
                    break;
                case 4:
                    searchByPhone();
                    break;
                case 5:
                    editByName();
                    break;
                case 6:
                    deleteByName();
                    break;
                case 7:
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);
    }

    private static void showAllContacts() {
        System.out.println("All Contacts:");
        for (Contact contact : addressBook.getAllContacts()) {
            System.out.println(contact);
        }
    }

    private static void addNewContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        Contact contact = new Contact(name, phone, email, address);
        addressBook.addContact(contact);
        System.out.println("Contact added successfully.");
    }

    private static void searchByName() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        Contact contact = addressBook.searchByName(name);
        if (contact != null) {
            System.out.println("Found: " + contact);
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void searchByPhone() {
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        Contact contact = addressBook.searchByPhone(phone);
        if (contact != null) {
            System.out.println("Found: " + contact);
        } else {
            System.out.println("Contact not found.");
        }
    }

//    private static void editByName() {
//        System.out.print("Enter name of contact to edit: ");
//        String name = scanner.nextLine();
//        Contact oldContact = addressBook.searchByName(name);
//        if (oldContact != null) {
//            System.out.println("Editing contact: " + oldContact);
//            addNewContact(); // You can modify this to directly edit fields.
//        } else {
//            System.out.println("Contact not found.");
//        }
private static void editByName() {
    System.out.print("Enter name of contact to edit: ");
    String name = scanner.nextLine();
    Contact oldContact = addressBook.searchByName(name);

    if (oldContact != null) {
        System.out.println("Editing contact: " + oldContact);

        // Edit each field based on user input
        System.out.print("Enter new name (leave blank to keep current name): ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            oldContact.setName(newName);
        }

        System.out.print("Enter new phone (leave blank to keep current phone): ");
        String newPhone = scanner.nextLine();
        if (!newPhone.isEmpty()) {
            oldContact.setPhone(newPhone);
        }

        System.out.print("Enter new email (leave blank to keep current email): ");
        String newEmail = scanner.nextLine();
        if (!newEmail.isEmpty()) {
            oldContact.setEmail(newEmail);
        }

        System.out.print("Enter new address (leave blank to keep current address): ");
        String newAddress = scanner.nextLine();
        if (!newAddress.isEmpty()) {
            oldContact.setAddress(newAddress);
        }

        System.out.println("Contact updated successfully: " + oldContact);

    } else {
        System.out.println("Contact not found.");
    }
}



    private static void deleteByName() {
        System.out.print("Enter name of contact to delete: ");
        String name = scanner.nextLine();
        if (addressBook.deleteByName(name)) {
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }
}
