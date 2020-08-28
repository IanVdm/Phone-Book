import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contact> myContacts;

    public MobilePhone() {
        this.myContacts = new ArrayList<Contact>();
    }

    public boolean addContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println(contact.getName() + " already exists.");
            return false;
        }

        myContacts.add(contact);
        System.out.println(contact.getName() + " was added.");
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int position = findContact(oldContact);

        if (position < 0) {
            System.out.println(oldContact.getName() + " was not found.");
            return false;
        }

        this.myContacts.set(position, newContact);
        System.out.println(oldContact.getName() + " was replaced by " + newContact.getName());
        return true;
    }

    public boolean removeContact(Contact contact) {
        if (findContact(contact.getName()) < 0) {
            System.out.println(contact.getName() + " does not exist.");
            return false;
        }

        this.myContacts.remove(contact);
        return true;
    }

    public void printContactList() {
        System.out.println("You have " + this.myContacts.size() + " contacts:");

        for (int i = 0; i < this.myContacts.size(); i++) {
            System.out.println((i + 1) + ". " + this.myContacts.get(i).getName() + " -> " + this.myContacts.get(i).getPhoneNumber());
        }
    }

    public String queryContact(Contact contact) {
        if (findContact(contact) >= 0) {
            return contact.getName();
        }

        System.out.println(contact.getName() + " does not exist.");
        return null;
    }

    public Contact queryContact(String name) {
        int position = findContact(name);

        if (position >= 0) {
            return this.myContacts.get(position);
        }

        return null;
    }

    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    private int findContact(String name) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);

            if (contact.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
