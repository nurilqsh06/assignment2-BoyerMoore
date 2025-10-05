# Boyer-Moore Majority Vote Algorithm

This repository contains my implementation of the **Boyer-Moore Majority Vote Algorithm**, which efficiently finds the majority element (the element that appears more than `n/2` times) in an array. The algorithm works in a single pass and includes tracking performance metrics such as comparisons and array accesses (swaps and memory allocations are not used in this algorithm). The project also includes benchmarking, testing, and performance analysis.

## GitHub Workflow

The repository follows the following branch structure:

- **main** — contains stable releases of the Boyer-Moore Majority Vote algorithm.
- **feature/algorithm** — implements the Boyer-Moore algorithm, including output formatting.
- **feature/metrics** — includes `PerformanceTracker` and `CSVExporter` classes for collecting and exporting performance metrics.
- **feature/testing** — contains unit tests and their results in CSV format, with charts generated from this data.
- **feature/cli** — a Benchmark Runner to execute performance tests on different input sizes.

## Implementation

### Boyer-Moore Majority Vote Algorithm

The Boyer-Moore Majority Vote algorithm works as follows:

1. **Candidate** — the element that is suspected to be the majority element.
2. **Counter** — a counter that tracks the occurrences of the current candidate element.
3. For each element in the array:
   - If the element matches the candidate, increment the counter.
   - If the element does not match the candidate, decrement the counter.
   - When the counter reaches zero, the current element becomes the new candidate.

The algorithm makes a single pass through the array and identifies the potential majority element. A second phase is used to verify that the candidate is indeed the majority element, but this phase is omitted in this implementation.

## Testing

Unit tests cover various edge cases, including:

- Single-element arrays.
- Arrays containing only negative values.
- Arrays containing only positive values.
- Arrays with a mix of negative and positive values.

## Validation

- **Correctness check**: The implementation was validated against a brute-force method to find the majority element.
- **Benchmarking**: Performance tests were executed for input sizes of 100, 1,000, 10,000, and 100,000. Results were exported to CSV and visualized in graphs.

## Complexity

- **Time Complexity**: Θ(n)
- **Space Complexity**: O(1) — constant additional memory

The Boyer-Moore algorithm runs in linear time because it only scans the array once, updating counters. The space complexity is constant since only a few additional variables are used to store results.

## Sample Benchmark Output

Here is a sample output from `performanceResults.csv`:

| **Array Size** | **Execution Time (ns)** | **Comparisons** | **Array Access** | **Swaps** | **Memory Allocations** |
|----------------|-------------------------|-----------------|------------------|-----------|------------------------|
| 100            | 168,875                 | 99              | 99               | 0         | 0                      |
| 1,000          | 27,458                  | 999             | 999              | 0         | 0                      |
| 10,000         | 568,500                 | 9,999           | 9,999            | 0         | 0                      |
| 100,000        | 2,124,542               | 99,999          | 99,999           | 0         | 0                      |

### Benchmark Analysis

- As shown, **comparisons** and **array accesses** grow linearly with input size:
  - For `n = 100`: ~2 comparisons/array accesses (99).
  - For `n = 1,000`: ~2n comparisons/array accesses (999).
  - For `n = 10,000`: ~2n comparisons/array accesses (9,999).
  - For `n = 100,000`: ~2n comparisons/array accesses (99,999).
- **Swaps** and **memory allocations** remain zero since the algorithm does not perform any swaps or memory allocations.

## Summary

- **Theoretical Complexity**: The CSV data confirms the theoretical time complexity of Θ(n) and space complexity of O(1).
- **Benchmark Results**: Benchmark results demonstrate linear scaling with increasing input sizes.
- **Efficiency**: The algorithm does not use additional memory or perform unnecessary operations.
- **Empirical Validation**: The implementation has been fully tested and validated through unit tests and benchmarking.
