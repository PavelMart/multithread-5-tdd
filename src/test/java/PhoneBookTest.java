import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PhoneBookTest {
    static PhoneBook phoneBook;
    @BeforeEach
    public void initializePhoneBook() {phoneBook = new PhoneBook();}
    @Test
    public void addTest_Simple() {
        final String name = "name";
        final String phoneNumber = "77777777777";
        final int expected = 1;
        final int result = phoneBook.add(name, phoneNumber);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void addTest_DifferentNames() {
        String name1 = "name1";
        String name2 = "name2";
        final String phoneNumber = "77777777777";
        final int expected = 2;
        phoneBook.add(name1, phoneNumber);
        final int result = phoneBook.add(name2, phoneNumber);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void addTest_SameName() {
        String name1 = "name1";
        String name2 = "name1";
        final String phoneNumber = "12345";
        final int expected = 1;
        phoneBook.add(name1, phoneNumber);
        final int result = phoneBook.add(name2, phoneNumber);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testFindByNumber_ExistingNumber_ReturnsCorrectName() {
        phoneBook.add("Bob", "0987654321");
        phoneBook.add("Alice", "1234567890");
        phoneBook.add("Aalice", "1234567890");

        List<String> expected = new ArrayList<>();
        expected.add("Bob");
        List<String> names = phoneBook.findByNumber("0987654321");

        Assertions.assertEquals(expected, names);
    }

    @Test
    public void testFindByNumber_NonExistingNumber_ReturnsNull() {
        phoneBook.add("Bob", "0987654321");
        phoneBook.add("Alice", "1234567890");
        phoneBook.add("Aalice", "1234567890");


        List<String> names = phoneBook.findByNumber("0000000000");

        Assertions.assertNull(names);
    }

    @Test
    public void testFindByNumber_DuplicateNumber_ReturnsAllMatchingName() {
        phoneBook.add("John", "0987654321");
        phoneBook.add("Bob", "0987654321");
        phoneBook.add("Alice", "1234567890");
        phoneBook.add("Aalice", "1234567890");

        List<String> expected = new ArrayList<>();
        expected.add("Bob");
        expected.add("John");

        List<String> names = phoneBook.findByNumber("0987654321");

        Assertions.assertEquals(expected, names);
    }
}
