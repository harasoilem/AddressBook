package addressbook;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
        // Add some predefined contacts (hardcoded)
        contacts.add(new Contact("Χαρά Σοϊλεμέζη", "6981475027", "hara.soilem@yahoocom", "Φραγκοπούλου 6"));
        contacts.add(new Contact("Στράτος Γκάτζιος", "6981477090", "sgat.gkatz@yahoo.com", "Αμαλιάδος 10"));
        contacts.add(new Contact("Νίκος Παππάς", "6979981090", "nik.pap@yahoo.com", "Δερβενακίων 10"));

    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public List<Contact> getAllContacts() {
        return contacts;
    }

    public Contact searchByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    public Contact searchByPhone(String phone) {
        for (Contact contact : contacts) {
            if (contact.getPhone().equals(phone)) {
                return contact;
            }
        }
        return null;
    }

    public boolean deleteByName(String name) {
        return contacts.removeIf(contact -> contact.getName().equalsIgnoreCase(name));
    }

//    public boolean editByName(String name, Contact newContact) {
//        for (int i = 0; i < contacts.size(); i++) {
//            if (contacts.get(i).getName().equalsIgnoreCase(name)) {
//                contacts.set(i, newContact);
//                return true;
//            }
//        }
//        return false;
//    }
}
