import java.util.Arrays;
import java.util.Random;

public class RandomNumbers {
    public static void main(String[] args) {
        // Create an array to store the random numbers
        int[] randomNumbers = new int[10];

        // Generate and display 10 random numbers and store them in the array
        System.out.println("Random numbers:");
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            randomNumbers[i] = rand.nextInt(100); // Generates random numbers between 0 and 99
            System.out.println(randomNumbers[i]);
        }

        // Sort the array
        Arrays.sort(randomNumbers);

        // Display the sorted numbers
        System.out.println("\nSorted numbers:");
        for (int i = 0; i < 10; i++) {
            System.out.println(randomNumbers[i]);
        }
    }
}
