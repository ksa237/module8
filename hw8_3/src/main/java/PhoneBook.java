import java.util.TreeMap;

public class PhoneBook {

    private TreeMap<String, String> contacts = new TreeMap<>();

    private TreeMap<String, String> numbers = new TreeMap<>();

    public int add(String name, String phoneNumber) {
        contacts.put(name, phoneNumber);
        numbers.put(phoneNumber, name);
        return contacts.size();
    }

    public String findByNumber(String phonenumber) {
        return numbers.get(phonenumber);
    }


    public String findByName(String name) {
        return contacts.get(name);
    }

    boolean printAllNames() {

        boolean isPrinted = false;
        for (String name : contacts.values()) {
            System.out.println(name);
            isPrinted = true;
        }
        return isPrinted;

    }


}
