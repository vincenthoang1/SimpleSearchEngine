package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    static List<String> peopleList;
    static Map<String, List<Integer>> peopleMap;
    static final String ALL = "ALL";
    static final String ANY = "ANY";
    static final String NONE = "NONE";

    public static void main(String[] args) {
        if (args[0].equals("--data")) {
            if (args[1] != null) {
                //readFile(args[1]);
                readFile("names.txt");
                peopleMap = mapData(peopleList);
                startMenuMap();
            }
        }
    }

    private static void readFile(String fileName) {
        peopleList = new ArrayList<>();
        Scanner reader = new Scanner(System.in);
        reader.close();
        try {
            File file = new File(fileName);
            reader = new Scanner(file);
            while (reader.hasNextLine()) {
                peopleList.add(reader.nextLine());
            }

            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

    private static void startMenuMap() {
        System.out.println("\n=== Menu ===");
        System.out.println("1. Search information.\n2. Print all data.\n0. Exit.");

        Scanner reader = new Scanner(System.in);
        int input = Integer.parseInt(reader.nextLine());

        reader.close();

        switch (input) {
            case 2:
                printPeopleMap(0, peopleList.size());
                break;
            case 1:
                searchFilter();
                break;
            case 0:
                end();
                break;
            default:
                incorrectOptionMap();
                break;
        }
    }

    private static void searchFilter() {
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
        Scanner reader = new Scanner(System.in);

        String s = reader.nextLine();

        switch (s) {
            case ALL:
                startSearchMap(ALL);
                break;
            case ANY:
                startSearchMap(ANY);
                break;
            case NONE:
                startSearchMap(NONE);
                break;
            default:
                strategyVoid();
                break;
        }
    }

    private static void strategyVoid() {

    }

    private static void incorrectOptionMap() {
        System.out.println("Incorrect option! Try again.");
        startMenuMap();
    }

    private static void end() {
        System.out.println("\nBye!");
        return;
    }

    private static void printPeopleMap(int start, int end) {
        System.out.println("\n=== List of people ===");
        for (int i = start; i < end; i++) {
            System.out.println(peopleList.get(i));
        }

        startMenuMap();
    }

    private static void startSearchMap(String searchType) {
        Scanner reader = new Scanner(System.in);
        System.out.println("\nEnter a name or email to search all suitable people.");

        String query = reader.nextLine();

        List<String> result = searchMap(peopleMap, query, searchType);

        if (result.size() == 0) {
            System.out.println("No matching people found.");
            startMenuMap();
        } else {
            System.out.println(String.format("%s person(s) found:", result.size()));
            for (String s : result) {
                System.out.println(s);
            }

            startMenuMap();
        }
    }

    private static List<String> searchMap(Map<String, List<Integer>> nameMap, String query, String searchType) {
        List<String> tempList = new ArrayList<>();

        if (searchType.equals(ALL)) {
            if (nameMap.containsKey(query)) {
                List<Integer> list = nameMap.get(query);

                for (Integer i : list) {
                    tempList.add(peopleList.get(i));
                }
            }
        } else if (searchType.equals(ANY)) {
            String[] splitString = query.split(" ");
            for (String s : splitString) {
                if (nameMap.containsKey(s)) {
                    List<Integer> list = nameMap.get(s);

                    for (Integer i : list) {
                        tempList.add(peopleList.get(i));
                    }
                }
            }
        } else if (searchType.equals(NONE)) {
            String[] splitString = query.split(" ");
            List<String> copyList = new ArrayList<>(peopleList);

            for (String s : splitString) {

                if (nameMap.containsKey(s)) {
                    List<Integer> list = nameMap.get(s);

                    for (Integer i : list) {

                        if (copyList.contains(copyList.get(copyList.indexOf(peopleList.get(i))))) {
                            copyList.remove(copyList.indexOf(peopleList.get(i)));
                        }
                    }
                }
            }
            tempList = copyList;
        }

        return tempList;
    }

    private static Map<String, List<Integer>> mapData(List<String> nameList) {
        Map<String, List<Integer>> tempMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

        for (int i = 0; i < nameList.size(); i++) {
            String[] split = nameList.get(i).split(" ");

            for (String t : split) {
                if (!tempMap.containsKey(t)) {
                    List<Integer> intArray = new ArrayList<>();
                    intArray.add(i);
                    tempMap.put(t, intArray);
                }

                if (tempMap.containsKey(t)) {
                    List<Integer> existingList = tempMap.get(t);

                    if (!existingList.contains(i)) {
                        existingList.add(i);
                    }
                }
            }
        }

        return tempMap;
    }
}
