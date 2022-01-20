import java.util.*;

public class Main {

    private static final int OMEGA_VAL = 24;
    private static final int ALPHA_VAL = 1;
    private static final int GAMMA_VAL = 3;

    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        map.putIfAbsent("Omega", OMEGA_VAL);
        map.putIfAbsent("Alpha", ALPHA_VAL);
        map.putIfAbsent("Gamma", GAMMA_VAL);

        // write your code here
        System.out.println(map);
    }
}