import java.io.IOException;
import java.util.Random;
import org.example.metrics.CSVExporter;

public class BenchmarkRunner {
    public static void main(String[] args) throws IOException {
        int[] sizes = {100, 1000, 10000, 100000};
        CSVExporter exporter = new CSVExporter("docs/performanceResults.csv");

        for (int size : sizes) {
            int[] arr = generateRandomArray(size);

            PerformanceTracker.reset();

            long startTime = System.nanoTime();
            int majorityElement = BoyerMooreMajorityVote.findMajorityElement(arr);
            long endTime = System.nanoTime();

            long duration = endTime - startTime;

            System.out.println("Array size: " + size);
            System.out.println("Majority Element: " + majorityElement);
            System.out.println("Execution time " + duration);
            System.out.println(PerformanceTracker.report());
            System.out.println("------------------");

            exporter.writeRow(size, duration, PerformanceTracker.comparisons, PerformanceTracker.arrayAccess, PerformanceTracker.swaps, 0);
        }

        exporter.close();
    }

    private static int[] generateRandomArray(int n) {
        Random random = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(2001) - 1000;
        }
        return arr;
    }
}
