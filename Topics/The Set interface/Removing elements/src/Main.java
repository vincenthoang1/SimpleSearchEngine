import java.util.*;
import java.util.stream.Collectors;

class SetUtils {

    public static Set<Integer> getSetFromString(String str) {
        return Arrays
                .stream(str.split(" "))
                .map(Integer::valueOf)
                .collect(Collectors.toSet());
    }

    public static void removeAllNumbersGreaterThan10(Set<Integer> set) {
        final int number = 10;
        set.removeAll(set.stream()
                        .filter(e -> e > number)
                        .collect(Collectors.toSet()));
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        Set<Integer> set = SetUtils.getSetFromString(numbers);
        SetUtils.removeAllNumbersGreaterThan10(set);
        set.forEach(e -> System.out.print(e + " "));
    }
}