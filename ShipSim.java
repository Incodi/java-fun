import java.util.ArrayList;
import java.util.Scanner;

/**
 * A ship simulator using the switch and do statements.
 *
 * @author Incodi
 * @version 1
 */
public class ShipSim {
    private ArrayList<String> history;
    Integer[][] treasureMap;
    int param1, param2;

    public ShipSim(int param1, int param2) {
        this.history = new ArrayList<>();
        this.treasureMap = new Integer[param1][param2];
        this.param1 = param1;
        this.param2 = param2;
    }

    public void task() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        fillMap(treasureMap);
        treasureMap[0][0] = 1;
        history.add("Start");

        // Location variables:
        int x = 0;
        int y = 0;

        do {
            System.out.println("Ship simulator");
            System.out.println("1: Go North");
            System.out.println("2: Go North East");
            System.out.println("3: Go East");
            System.out.println("4: Go South East");
            System.out.println("5: Go South");
            System.out.println("6: Go South West");
            System.out.println("7: Go West");
            System.out.println("8: Go North West");
            System.out.println("9: Exit");

            System.out.println(String.format("Choice #%d", history.size()));
            print2D(treasureMap);
            System.out.println("Enter your choice");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1: // North
                    if (y - 1 == -1) {
                        System.out.println("Invalid Choice!");
                        break;
                    } else {
                        treasureFound(x, y - 1);
                        treasureMap[y][x] = 0;
                        y = y - 1;
                        treasureMap[y][x] = 1;
                        history.add("North");
                    }
                    break;

                case 2: // North East
                    if (y - 1 == -1 || x + 1 == param2) {
                        System.out.println("Invalid Choice!");
                        break;
                    } else {
                        treasureFound(x + 1, y - 1);
                        treasureMap[y][x] = 0;
                        y = y - 1; // North
                        x = x + 1; // East
                        treasureMap[y][x] = 1;
                        history.add("North East");
                    }
                    break;

                case 3: // East
                    if (x + 1 == param2) { // If the spot east of the current location does not exist it is invalid.
                        System.out.println("Invalid Choice!");
                        break;
                    } else {
                        treasureFound(x + 1, y);
                        treasureMap[y][x] = 0;
                        x = x + 1;
                        treasureMap[y][x] = 1;
                        history.add("East");
                    }
                    break;

                case 4: // South East
                    if (y + 1 == param1 || x + 1 == param2) {
                        System.out.println("Invalid Choice!");
                        break;
                    } else {
                        treasureFound(x + 1, y + 1);
                        treasureMap[y][x] = 0;
                        y = y + 1; // South
                        x = x + 1; // East
                        treasureMap[y][x] = 1;
                        history.add("South East");
                    }
                    break;

                case 5: // South
                    if (y + 1 == param1) {
                        System.out.println("Invalid Choice!");
                        break;
                    } else {
                        treasureFound(x, y + 1);
                        treasureMap[y][x] = 0;
                        y = y + 1;
                        treasureMap[y][x] = 1;
                        history.add("South");
                    }
                    break;

                case 6: // South West
                    if (y + 1 == param1 || x - 1 == -1) {
                        System.out.println("Invalid Choice!");
                        break;
                    } else {
                        treasureFound(x - 1, y + 1);
                        treasureMap[y][x] = 0;
                        y = y + 1; // South
                        x = x - 1; // West
                        treasureMap[y][x] = 1;
                        history.add("South West");
                    }
                    break;

                case 7: // West
                    if (x - 1 == -1) {
                        System.out.println("Invalid Choice!");
                        break;
                    } else {
                        treasureFound(x - 1, y);
                        treasureMap[y][x] = 0;
                        x = x - 1;
                        treasureMap[y][x] = 1;
                        history.add("West");
                    }
                    break;

                case 8: // North West
                    if (y - 1 == -1 || x - 1 == -1) {
                        System.out.println("Invalid Choice!");
                        break;
                    } else {
                        treasureFound(x - 1, y - 1);
                        treasureMap[y][x] = 0;
                        y = y - 1; // North
                        x = x - 1; // West
                        treasureMap[y][x] = 1;
                        history.add("North West");
                    }
                    break;

                case 9: // Exit.
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 9);

        scanner.close();

    }

    public void fillMap(Integer[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) { //This can be more efficient with Arrays.fill()
                arr[i][j] = 0;
            }
        }

        int treasureCoord1 = (int) (Math.random() * (3 + 1)) + 3;
        int treasureCoord2 = (int) (Math.random() * (3 + 1)) + 3;
        arr[treasureCoord1][treasureCoord2] = 2;

    }

    public void treasureFound(int x, int y) {
        if (treasureMap[y][x] == 2) {
            System.out.println("You found the treasure!");
            System.out.println(String.format("The treasure was found during choice #%d!", history.size()));
        }

    }

    public void print2D(Object[][] arr) { // Use Object for a versatile print2D method.
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " "); // Use print instead of println to print elements in the same line
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ShipSim Switch = new ShipSim(10, 10);
        Switch.task();
    }

}
