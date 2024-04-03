import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {
    private final Map<String, String> phoneBook = new TreeMap<>();
    public int add(String name, String phoneNumber) {
        phoneBook.putIfAbsent(name, phoneNumber);
        return phoneBook.size();
    }

    public List<String> findByNumber(String phoneNumber) {
        List<String> result = phoneBook
                .entrySet()
                .stream()
                .filter(entry -> phoneNumber.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .toList();

        return result.isEmpty() ? null : result;
    }

    public String findByName(String name) {
        return phoneBook.get(name);
    }
}
