import java.util.*;

class MapUtils {

    public static SortedMap<String, Integer> wordCount(String[] strings) {
        // write your code here
        SortedMap<String, Integer> map = new TreeMap<>();

        Arrays.stream(strings)
                .distinct()
                .forEach(k -> map.put(k, (int) Arrays.stream(strings)
                        .filter(e -> e.equals(k))
                        .count()));

        return map;
    }

    public static void printMap(Map<String, Integer> map) {
        // write your code here
        map.forEach((k, v) -> System.out.println(k + " : " + v));
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        MapUtils.printMap(MapUtils.wordCount(words));
    }
}