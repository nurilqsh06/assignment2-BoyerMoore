public class BoyerMooreMajorityVote {
    public static void main(String[] args){
        int[] array = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        System.out.println("Majority Element: " + findMajorityElement(array));
        System.out.println(PerformanceTracker.report());
    }

    public static int findMajorityElement(int[] arr) {
        PerformanceTracker.reset();

        if (arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        int candidate = arr[0];
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            PerformanceTracker.arrayAccess++; 
            PerformanceTracker.comparisons++;

            if (arr[i] == candidate) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                candidate = arr[i];
                count = 1;
            }
        }
        return candidate;
    }
}