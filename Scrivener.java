import java.util.LinkedList;
import java.util.Scanner;

/**
 * Linking bits of a story with a Linked List.
 *
 * @author Incodi
 * @version A
 */

public class Scrivener {
    private LinkedList<String> story;

    public Scrivener (){
        this.story = new LinkedList<>();
    }

    public void writeStory() {
        System.out.println("With this simple program you can write a quick story.");
        System.out.println("Type 'THE END' to end the story");
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the first event of your story?");
        String entry = scanner.nextLine();
        story.add(entry);
        while (!entry.equals("THE END")) {
            System.out.println("What happens next?");
            entry = scanner.nextLine();
            story.add(entry);
        }
        scanner.close();
    }

    public void display() { //Displays the story.
        for (String element : story) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        Scrivener practice = new Scrivener();
        practice.writeStory();
        System.out.println();
        practice.display();
        System.out.println();
    }


}