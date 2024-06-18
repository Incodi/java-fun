import java.util.Arrays;
import java.util.List;
import java.util.Collections;

/**
 * A class showcasing useful statements.
 *
 * @author Incodi
 * @version A
 */

public class CheatSheet {

    public static int[] arrayDoctor(int[] array) {

        int[] oldArray = array;
        int[] oldArray2 = Arrays.copyOf(oldArray, 20); // a better way to copy and increase size of arrays.

        System.out.println("oldArray = array? " + Arrays.equals(array, oldArray)); // true

        System.out.println("oldArray = oldArray2? " + Arrays.equals(oldArray, oldArray2)); // false

        for (int num : array) { // for-each loop
            System.out.println(num);
        }

        String[] filledArray = new String[5];
        Arrays.fill(filledArray, "cool"); // fill array
        System.out.println("Filled array: " + Arrays.toString(filledArray)); // toString

        int index = linearSearch(array, 7); // linear search (doesn't need sorted array)
        System.out.println("Index of 7 (before sort): " + index);

        Arrays.sort(array); // sort array
        System.out.println("Sorted numbers: " + Arrays.toString(array));

        int index1 = Arrays.binarySearch(array, 7); // binary search (needs sorted array)
        System.out.println("Index of 7: " + index1);

        Arrays.parallelSort(oldArray); // sort Array (better for big arrays)
        System.out.println("Sorted numbers (parallel sort): " + Arrays.toString(array));

        // 2D array
        int[][] array2D = new int[3][4];

        // Fill each row of the 2D array
        for (int i = 0; i < array2D.length; i++) {
            Arrays.fill(array2D[i], 1); // Fill row i with value 1
        }

        // Print the filled 2D array
        System.out.println("Filled 2D array:");
        System.out.println(Arrays.deepToString(array2D)); // Using .deepToString()

        List<String> worcestershire = Arrays.asList("sauce", "pronounciation", "sauce recipe", "sauce uses", "sauce Walmart"); // convert to List
        long count = worcestershire.stream()
                .filter(name -> name.startsWith("sauce")) //only sauce entries
                .map(String::toUpperCase) //convert all string to uppercase
                .count(); //4 sauce entries

        System.out.printf("%d Worcestershire sauce entries found%n", count); //no String.format needed here

        return oldArray2;
    }

    public static int linearSearch(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i; // Return index of the key if found
            }
        }
        return -1; // Return -1 if key is not found
    }

    public static Integer[] reverseArray(Integer[] array) {
        return Arrays.stream(array) //array to stream
                     .sorted(Collections.reverseOrder())
                     .toArray(Integer[]::new); //stream to array
    }

    public static void main(String[] args) {
        int[] array1 = { 1, 2, 3, 7, 4, 5, 3 };
        Integer[] array2 = { 1, 2, 3, 7, 4, 5, 3 };
        array2 = reverseArray(array2);
        System.out.println("Reversed array: " + Arrays.toString(array2));
        System.out.println(Arrays.toString(arrayDoctor(array1)));
    }

}
