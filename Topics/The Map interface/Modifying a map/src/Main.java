import java.util.*;

class MapUtils {

    public static void mapShare(Map<String, String> map) {
        // write your code here
        map.remove("c");

        if (map.get("a") != null) {
            String value = map.get("a");
            map.put("b", value);
        }
    }
}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] pair = s.split(":");
            map.put(pair[0], pair[1]);
        }
        MapUtils.mapShare(map);
        map.forEach((key, value) -> System.out.println(key + ":" + value));
    }
}