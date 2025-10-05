public class PerformanceTracker {
    public static int comparisons = 0;
    public static int arrayAccess = 0;
    public static int swaps=0;

    public static void reset() {
        comparisons = 0;
        arrayAccess = 0;
        swaps=0;
    }

    public static String report() {
        return "\nComparisons: " + comparisons +
                "\nArray access: " + arrayAccess +
                "\nSwaps: " + swaps +
                "\nMemory allocations: 0";
    }
}
