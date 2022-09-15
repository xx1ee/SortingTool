package sorting;

import java.io.*;
import java.util.*;
interface sorting{
     void sort();
}
class insertionWords implements sorting {
    public LinkedList<String> words;
    public boolean bool;
    public insertionWords(LinkedList<String> words, boolean bool) {
        this.words = words;
        this.bool = bool;
    }
    @Override
    public void sort() {
        for (int i = 1; i < words.size(); i++) {
            String value = words.get(i);
            int j = i - 1;
            while (j >= 0) {
                if (value.compareTo(words.get(j)) < 0) {
                    words.set(j + 1, words.get(j));
                    j--;
                } else break;
            }
            words.set(j + 1, value);
        }
        System.out.println("Total words:" + words.size());
        System.out.print("Sorted data:");
        if (bool == true) {
            for (int i = 0;i < words.size(); i++) {
                System.out.print(words.get(i) + " ");
            }
        } else {
            for (int i = 0;i < words.size(); i++) {
                System.out.println(words.get(i) + " ");
            }
        }
    }
}
class insertionIntegers implements sorting {

    public LinkedList<Long> numbers;
    public insertionIntegers(LinkedList<Long> numbers){
        this.numbers = numbers;
    }
    @Override
    public void sort() {
        for (int i = 1; i < numbers.size(); i++) {
            long value = numbers.get(i);
            int j = i - 1;
            while (j >= 0) {
                if (value < numbers.get(j)) {
                    numbers.set(j + 1, numbers.get(j));
                    j--;
                } else break;
            }
            numbers.set(j + 1, value);
        }
        System.out.println("Total numbers:" + numbers.size());
        System.out.print("Sorted data:");
        for (int i = 0;i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
    }

}
public class Main {
    public static String fileNameOut = "";
    public static void byCount(LinkedList<Long> numbers) throws FileNotFoundException {
        TreeMap<Long, Integer> map = new TreeMap<>();
        for (int i = 0; i < numbers.size(); i++) {
            Long value = numbers.get(i);
            if (map.containsKey(value)) {
                map.put(value, map.get(value) + 1);
            } else {
                map.put(value, 1);
            }
        }
        for (int i = 1; i < numbers.size(); i++) {
            Long value = numbers.get(i);
            int j = i - 1;
            while (j >= 0) {
                if (map.get(value) < map.get(numbers.get(j))) {
                    numbers.set(j + 1, numbers.get(j));
                    j--;
                } else break;
            }
            numbers.set(j + 1, value);
        }
        System.out.println("Total numbers:" + numbers.size());
        LinkedList<Long> numbers1 = new LinkedList<>(numbers);
        TreeMap<Long, Integer> map1 = new TreeMap<>(map);
        for (int i = 0; i < numbers1.size() ; i++) {
            Long val = numbers1.get(i);
            if (map.get(val) > 1) {
                for (int j = i; j < i + map.get(val) - 1; j++) {
                    numbers.remove(val);
                    map.put(val, map.get(val) - 1);
                }
            }
        }
        for (int i = 1; i < numbers.size();i++) {
            Long val = numbers.get(i);
            int j = i - 1;
            while (j >= 0) {
                if (map1.get(val).equals(map1.get(numbers.get(j)))) {
                    if (val < numbers.get(j)) {
                        numbers.set(j + 1, numbers.get(j));
                        j--;
                    } else break;
                } else break;
            }
            numbers.set(j + 1, val);
        }
        if (fileNameOut != "") {
            PrintStream out = new PrintStream(
                    new FileOutputStream(fileNameOut, true), true);
            System.setOut(out);
        }
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i) + ": (" + map1.get(numbers.get(i))+ " time(s), " + Math.round((map1.get(numbers.get(i)) * 100 / numbers1.size())) + "%)");
        }
    }
    public static void byCountStr(LinkedList<String> numbers) throws FileNotFoundException {
        TreeMap<String, Integer> map = new TreeMap();
        for (int i = 0; i < numbers.size(); i++) {
            String value = numbers.get(i);
            if (map.containsKey(value)) {
                map.put(value, map.get(value) + 1);
            } else {
                map.put(value, 1);
            }
        }
        for (int i = 1; i < numbers.size(); i++) {
            String value = numbers.get(i);
            int j = i - 1;
            while (j >= 0) {
                if (map.get(value) < map.get(numbers.get(j))) {
                    numbers.set(j + 1, numbers.get(j));
                    j--;
                } else break;
            }
            numbers.set(j + 1, value);
        }
        System.out.println("Total words:" + numbers.size());
        LinkedList<String> numbers1 = new LinkedList<>(numbers);
        TreeMap<String, Integer> map1 = new TreeMap<>(map);
        for (int i = 0; i < numbers1.size() ; i++) {
            String val = numbers1.get(i);
            if (map.get(val) > 1) {
                for (int j = i; j < i + map.get(val) - 1; j++) {
                    numbers.remove(val);
                    map.put(val, map.get(val) - 1);
                }
            }
        }
        for (int i = 1; i < numbers.size();i++) {
            String val = numbers.get(i);
            int j = i - 1;
            while (j >= 0) {
                if (map1.get(val).equals(map1.get(numbers.get(j)))) {
                    if (val.compareTo(numbers.get(j)) < 0) {
                        numbers.set(j + 1, numbers.get(j));
                        j--;
                    } else break;
                } else break;
            }
            numbers.set(j + 1, val);
        }
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i) + ": (" + map1.get(numbers.get(i))+ " time(s), " + Math.round((map1.get(numbers.get(i)) * 100 / numbers1.size())) + "%)");
        }
        if (fileNameOut != "") {
            PrintStream out = new PrintStream(
                    new FileOutputStream(fileNameOut, true), true);
            System.setOut(out);
        }
    }
    public static void main(final String[] args) throws IOException {
        List<String> arg = Arrays.asList(args);
        if (arg.contains("-sortingType") && (!arg.contains("natural") && (!arg.contains("byCount")))) {
            System.out.println("No sorting type defined!");
            return;
        }
        if (arg.contains("-dataType") && (!arg.contains("long") && !arg.contains("line") && !arg.contains("word"))) {
            System.out.println("No data type defined!");
            return;
        }
        String fileName = "";
        for (int i = 0; i < arg.size(); i++) {
            if (arg.get(i).equals("-inputFile")) {
                fileName = arg.get(i + 1);
            }
            if (arg.get(i).equals("-outputFile")) {
                fileNameOut = arg.get(i + 1);
                File file = new File(fileNameOut);
                file.createNewFile();
            }
        }
        if (arg.contains("byCount")) {
            if (arg.contains("long")) {
                if (fileName != "") {
                    Scanner scanner = new Scanner(fileName);
                    LinkedList<Long> numbers = new LinkedList<>();
                    while (scanner.hasNextLong()) {
                        long string = scanner.nextLong();
                        numbers.add(string);
                    }
                    byCount(numbers);
                    scanner.close();
                } else {
                    Scanner scanner = new Scanner(System.in);
                    LinkedList<Long> numbers = new LinkedList<>();
                    while (scanner.hasNextLong()) {
                        long string = scanner.nextLong();
                        numbers.add(string);
                    }
                    byCount(numbers);
                }
            }
            if (arg.contains("line")) {
                if (fileName != "") {
                    Scanner scanner = new Scanner(fileName);
                    LinkedList<String> lines = new LinkedList<>();
                    while (scanner.hasNextLine()) {
                        lines.add(scanner.nextLine());
                    }
                    byCountStr(lines);
                    scanner.close();
                } else {
                    Scanner scanner = new Scanner(System.in);
                    LinkedList<String> lines = new LinkedList<>();
                    while (scanner.hasNextLine()) {
                        lines.add(scanner.nextLine());
                    }
                    byCountStr(lines);
                }
            }
            if (arg.contains("word")) {
                if (fileName != "") {
                    Scanner scanner = new Scanner(fileName);
                    LinkedList<String> lines = new LinkedList<>();
                    while (scanner.hasNext()) {
                        lines.add(scanner.next());
                    }
                    byCountStr(lines);
                    scanner.close();
                } else {
                    Scanner scanner = new Scanner(System.in);
                    LinkedList<String> lines = new LinkedList<>();
                    while (scanner.hasNext()) {
                        lines.add(scanner.next());
                    }
                    byCountStr(lines);
                }
            }
        } else {
            if (arg.contains("long")) {
                if (fileName != "") {
                    Scanner scanner = new Scanner(fileName);
                    LinkedList<Long> numbers = new LinkedList<>();
                    while (scanner.hasNextLong()) {
                        long string = scanner.nextLong();
                        numbers.add(string);
                    }
                    scanner.close();
                    insertionIntegers insertion = new insertionIntegers(numbers);
                    insertion.sort();
                } else {
                    Scanner scanner = new Scanner(System.in);
                    LinkedList<Long> numbers = new LinkedList<>();
                    while (scanner.hasNextLong()) {
                        long string = scanner.nextLong();
                        numbers.add(string);
                    }
                    insertionIntegers insertion = new insertionIntegers(numbers);
                    insertion.sort();
                }
            }
            if (arg.contains("word")) {
                if (fileName != "") {
                    Scanner scanner = new Scanner(fileName);
                    LinkedList<String> words = new LinkedList<>();
                    while (scanner.hasNext()) {
                        words.add(scanner.next());
                    }
                    insertionWords insertionWords = new insertionWords(words, true);
                    insertionWords.sort();
                } else {
                    Scanner scanner = new Scanner(System.in);
                    LinkedList<String> words = new LinkedList<>();
                    while (scanner.hasNext()) {
                        words.add(scanner.next());
                    }
                    insertionWords insertionWords = new insertionWords(words, true);
                    insertionWords.sort();
                }
            }
            if (arg.contains("line")) {
                if (fileName != "") {
                    Scanner scanner = new Scanner(fileName);
                    LinkedList<String> lines = new LinkedList<>();
                    while (scanner.hasNextLine()) {
                        lines.add(scanner.nextLine());
                    }
                    insertionWords insertionWords = new insertionWords(lines, false);
                    insertionWords.sort();
                } else {
                    Scanner scanner = new Scanner(System.in);
                    LinkedList<String> lines = new LinkedList<>();
                    while (scanner.hasNextLine()) {
                        lines.add(scanner.nextLine());
                    }
                    insertionWords insertionWords = new insertionWords(lines, false);
                    insertionWords.sort();
                }
            }

        }
    }
}
