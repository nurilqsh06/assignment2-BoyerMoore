public class BoyerMooreMajorityVoteTest {

    @Test
    void testFindMajorityElement() {
        int[] array1 = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        int result1 = BoyerMooreMajorityVote.findMajorityElement(array1);
        System.out.println("Test 1: Expected: 4, Result: " + result1);

        int[] array2 = {7};
        int result2 = BoyerMooreMajorityVote.findMajorityElement(array2);
        System.out.println("Test 2: Expected: 7, Result: " + result2);

        int[] array3 = {};
        try {
            int result3 = BoyerMooreMajorityVote.findMajorityElement(array3);
            System.out.println("Test 3: Expected exception, but got result: " + result3);
        } catch (IllegalArgumentException e) {
            System.out.println("Test 3: Caught expected exception: " + e);
        }

        int[] array4 = {1, 2, 3, 4, 5};
        int result4 = BoyerMooreMajorityVote.findMajorityElement(array4);
        System.out.println("Test 4: Expected: 1 (based on algorithm), Result: " + result4);
    }

    @Test
    void testPerformanceTracker() {
        PerformanceTracker.reset();
        int[] array = {1, 2, 3, 4, 5};
        BoyerMooreMajorityVote.findMajorityElement(array);

        int comparisons = PerformanceTracker.comparisons;
        int arrayAccess = PerformanceTracker.arrayAccess;
        System.out.println("Performance Test: Comparisons: " + comparisons + ", Array Accesses: " + arrayAccess);
    }
}
