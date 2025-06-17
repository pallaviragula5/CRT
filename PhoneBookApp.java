import java.util.*;

class Contact {
    String name;
    String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber;
    }
}

public class PhoneBookApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Phone Book Menu ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Update Contact");
            System.out.println("6. Exit");
            System.out.print("Choose an option (1-6): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addContact();
                case 2 -> viewContacts();
                case 3 -> searchContact();
                case 4 -> deleteContact();
                case 5 -> updateContact();
                case 6 -> {
                    System.out.println("Exiting Phone Book. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addContact() {
        System.out.print("Enter contact name: ");
        String name = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        contacts.add(new Contact(name, phoneNumber));
        System.out.println("Contact added successfully.");
    }

    private static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Phone book is empty.");
        } else {
            System.out.println("Contacts List:");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    private static void searchContact() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();

        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.name.equalsIgnoreCase(name)) {
                System.out.println("Found: " + contact);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No contact found with that name.");
        }
    }

    private static void deleteContact() {
        System.out.print("Enter name to delete: ");
        String name = scanner.nextLine();

        Iterator<Contact> iterator = contacts.iterator();
        boolean deleted = false;

        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.name.equalsIgnoreCase(name)) {
                iterator.remove();
                System.out.println("Contact deleted successfully.");
                deleted = true;
                break;
            }
        }

        if (!deleted) {
            System.out.println("Contact not found.");
        }
    }

    private static void updateContact() {
        System.out.print("Enter name to update: ");
        String name = scanner.nextLine();

        for (Contact contact : contacts) {
            if (contact.name.equalsIgnoreCase(name)) {
                System.out.print("Enter new name: ");
                contact.name = scanner.nextLine();

                System.out.print("Enter new phone number: ");
                contact.phoneNumber = scanner.nextLine();

                System.out.println("Contact updated successfully.");
                return;
            }
        }

        System.out.println("Contact not found.");
    }
}
