import java.util.ArrayList;
import java.util.Scanner;

class Contact            {
    String name, phone; 

    Contact(String name, String phone){
        this.name = name;
        this.phone = phone;
    }

    public String toString(){
        return "Name: " + name + ", Phone: " + phone;
    }
}

public class ContactManager {
    static ArrayList<Contact> contacts = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Contact\n2. View Contacts\n3. Search Contact\n4. Delete Contact\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addContact();
                case 2 -> viewContacts();
                case 3 -> searchContact();
                case 4 -> deleteContact();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default ->System.out.println("Invalid choice! Try again.");
            }
        }
    }

    static void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();

        contacts.add(new Contact(name, phone));
        System.out.println("Contact added successfully!");
    }

    static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available!");
            return;
        }
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }

    static void searchContact() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        for (Contact c : contacts) {
            if (c.name.equalsIgnoreCase(name)) {
                System.out.println("Contact Found: " + c);
                return;
            }
        }
        System.out.println("Contact not found!");
    }

    static void deleteContact() {
        System.out.print("Enter name to delete: ");
        String name = scanner.nextLine();
        contacts.removeIf(c -> c.name.equalsIgnoreCase(name));
        System.out.println("Contact deleted (if found)!");
    }
}
