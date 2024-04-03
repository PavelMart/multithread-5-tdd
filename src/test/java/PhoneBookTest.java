import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PhoneBookTest {
    static PhoneBook phoneBook;
    @BeforeEach
    public void initializePhoneBook() {phoneBook = new PhoneBook();}
    @Test
    public void addNameTest() {
        final String name = "name";
        final String phoneNumber = "77777777777";
        final int expected = 1;
        final int result = phoneBook.add(name, phoneNumber);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void addDifferentNamesTest() {
        String name1 = "name1";
        String name2 = "name2";
        final String phoneNumber = "77777777777";
        final int expected = 2;
        phoneBook.add(name1, phoneNumber);
        final int result = phoneBook.add(name2, phoneNumber);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void addSameNameTest() {
        String name1 = "name1";
        String name2 = "name1";
        final String phoneNumber = "77777777777";
        final int expected = 1;
        phoneBook.add(name1, phoneNumber);
        final int result = phoneBook.add(name2, phoneNumber);
        Assertions.assertEquals(expected, result);
    }
}
