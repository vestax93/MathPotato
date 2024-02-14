import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // ovde ce nam biti deca
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();

        // uzimamo imena dece iz skenera, tj. ono sto je korisnik uneo
        String[] names = scanner.nextLine().split("\\s+");
        // dodajemo names u queue
        Collections.addAll(priorityQueue, names);

        // broj rotacija/toss
        int numOfRotations = Integer.parseInt(scanner.nextLine());

        int startCycle = 1;
        while (priorityQueue.size() > 1) {

            // simuliramo dodavanje krompira
            for (int i = 1; i < numOfRotations; i++) {
                priorityQueue.offer(priorityQueue.poll());
            }

            // ukoliko jeste ispisujemo Prime i ime deteta
            if (comp(startCycle)) {
                System.out.println("Prime " + priorityQueue.peek());
            }
            // ukoliko nije onda ispisujemo Removed i ime deteta
            else {
                System.out.println("Removed " + priorityQueue.poll());
            }
            startCycle++;
        }
        System.out.println("Last is " + priorityQueue.poll());
    }

    // metod koji proverava da li je broj prost ili slozen
    public static boolean comp(int startCycle) {
        int count = 0;
        for (int i = 2; i <= startCycle; i++) {
            if (startCycle % i == 0) {
                count++;
            }
        }
        return count == 1;
    }
}
