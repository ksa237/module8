import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneBookTest {


    @Test
    void testAddMethod() {
        PhoneBook phoneBook = new PhoneBook();

        int result1 = phoneBook.add("Andrey", "89025523412");
        assertEquals(1, result1, "Количество абонентов после добавления невеное");

        int result2 = phoneBook.add("Marina", "89245556123");
        assertEquals(2, result2, "Количество абонентов после добавления невеное");

    }


}
