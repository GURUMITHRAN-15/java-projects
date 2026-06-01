import java.util.ArrayList;

public class ContactManager {

    private ArrayList<Contact> contacts = new ArrayList<>();

    // Add Contact
    public void addContact(Contact contact) {

        // Duplicate phone check
        for (Contact c : contacts) {
            if (c.getPhone().equals(contact.getPhone())) {
                System.out.println("Contact with this phone number already exists!");
                return;
            }
        }

        contacts.add(contact);
        System.out.println("Contact Added Successfully!");
    }

    // View All Contacts
    public void viewContacts() {

        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        for (Contact c : contacts) {
            System.out.println(c);
            System.out.println("-------------------");
        }
    }

    // Search Contact
    public Contact searchContact(String name) {

        for (Contact c : contacts) {

            // Case-insensitive search
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }

        return null;
    }

    // Delete Contact
    public boolean deleteContact(String name) {

        Contact contact = searchContact(name);

        if (contact != null) {
            contacts.remove(contact);
            return true;
        }

        return false;
    }

    // Update Contact
    public boolean updateContact(String name,
                                 String newName,
                                 String newPhone,
                                 String newEmail) {

        Contact contact = searchContact(name);

        if (contact != null) {

            contact.setName(newName);
            contact.setPhone(newPhone);
            contact.setEmail(newEmail);

            return true;
        }

        return false;
    }
}