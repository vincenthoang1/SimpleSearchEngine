import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        Set<String> dictionary = new HashSet<>();
        Set<String> query = new HashSet<>();

        ingestDictionary(dictionary, scanner);
        ingestQuery(query, scanner);

        query.stream()
                .filter(e -> !dictionary.contains(e))
                .forEach(System.out::println);
    }

    private static void ingestDictionary(Set<String> dictionary, Scanner scanner) {
        int d = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < d; i++) {
            dictionary.add(scanner.nextLine().toLowerCase());
        }
    }

    private static void ingestQuery(Set<String> query, Scanner scanner) {
        int l = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < l; i++) {
            query.addAll(
                    Arrays.stream(scanner.nextLine().split(" "))
                            .map(String::toLowerCase)
                            .collect(Collectors.toSet()));
        }
    }
}