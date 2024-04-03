import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private final Map<String, String> phoneBook = new HashMap<>();
    public int add(String name, String phoneNumber) {
        phoneBook.putIfAbsent(name, phoneNumber);
        return phoneBook.size();
    }
}
