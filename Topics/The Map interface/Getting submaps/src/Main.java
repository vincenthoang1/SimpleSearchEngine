import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        Integer[] range = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Map<Integer, String> map = new TreeMap<>();

        while (scanner.hasNextLine()) {
            String ingest = scanner.nextLine();

            int key;
            String value = "";

            if (ingest.contains(" ")) {
                key = Integer.parseInt(ingest.split(" ")[0]);
                value = ingest.split(" ")[1];
            } else {
                key = Integer.parseInt(ingest);
            }

            map.put(key, value);
        }

        map.forEach((k, v) -> {
            if (k >= range[0] && k <= range[1]) {
                System.out.println(k + " " + v);
            }
        });
    }
}