import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();

        while (scanner.hasNext()) {
            list.add(scanner.nextInt());
        }

        int value = list.remove(list.size() - 1);

        findNearestNumber(list, value);
    }

    private static boolean checkContains(ArrayList<Integer> intList, int x) {
        StringBuffer sb = new StringBuffer();

        if (intList.contains(x)) {
            int xFreq = Collections.frequency(intList, x);

            for (int i = 0; i < xFreq; i++) {
                sb.append(x).append(" ");
            }

            System.out.println(sb);
            return true;
        }

        return false;
    }

    private static boolean checkOutOfBounds(ArrayList<Integer> intList, int x) {
        int min = intList.get(0);
        int max = intList.get(intList.size() - 1);

        StringBuffer sb = new StringBuffer();

        if (x < min) {
            int minFreq = Collections.frequency(intList, min);

            for (int i = 0; i < minFreq; i++) {
                sb.append(min).append(" ");
            }

            System.out.println(sb);
            return true;
        }

        if (x > max) {
            int maxFreq = Collections.frequency(intList, max);

            for (int i = 0; i < maxFreq; i++) {
                sb.append(max).append(" ");
            }

            System.out.println(sb);
            return true;
        }

        return false;
    }

    private static void checkDistances(ArrayList<Integer> intList, int x) {
        StringBuffer sb = new StringBuffer();

        int lower = 0;
        int upper;
        int index = 0;

        while (intList.get(index) < x) {
            lower = intList.get(index);
            index++;
        }

        upper = intList.get(index);

        int diffToLower = x - lower;
        int diffToUpper = upper - x;

        if (diffToLower == diffToUpper) {
            int lowerCount = Collections.frequency(intList, lower);
            int upperCount = Collections.frequency(intList, upper);

            for (int i = 0; i < lowerCount; i++) {
                sb.append(lower).append(" ");
            }

            for (int i = 0; i < upperCount; i++) {
                sb.append(upper).append(" ");
            }

            System.out.println(sb);
            return;
        }

        if (diffToLower < diffToUpper) {
            int lowerCount = Collections.frequency(intList, lower);

            for (int i = 0; i < lowerCount; i++) {
                sb.append(lower).append(" ");
            }

            System.out.println(sb);
            return;
        }

        int upperCount = Collections.frequency(intList, upper);

        for (int i = 0; i < upperCount; i++) {
            sb.append(upper).append(" ");
        }

        System.out.println(sb);
    }

    private static void findNearestNumber(ArrayList<Integer> intList, int x) {
        Collections.sort(intList);

        if (intList.isEmpty()) {
            return;
        }

        if (checkContains(intList, x)) {
            return;
        }

        if (checkOutOfBounds(intList, x)) {
            return;
        }

        checkDistances(intList, x);
    }
}