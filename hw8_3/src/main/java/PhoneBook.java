import java.util.TreeMap;

public class PhoneBook {

    private TreeMap<String, String> contacts = new TreeMap<>();

    public int add(String name, String phoneNumber) {
        contacts.put(name, phoneNumber);
        return contacts.size();
    }

}
