import java.util.Random;

public class ExperimentRunner {

    public long[][] runExperimentsInsertionSort(int[] inputSizes, DataReader fullData, String FILE_PATH) {
        long[][] results = new long[inputSizes.length][3]; // Rows: input sizes, Columns: random, sorted, reversed
        int averageOfN = 10;

        for (int i = 0; i < inputSizes.length; i++) {
            int size = inputSizes[i];
            int[] data = fullData.getFlowDurations(size, FILE_PATH);

            long[][] tempResults = new long[10][3]; // Temporary array to store results of each iteration

            for (int k = 0; k < 10; k++) {
                // Random data
                int[] randomData = data.clone();
                InsertionSort insertionSortRandom = new InsertionSort();
                long startTime = System.currentTimeMillis();
                insertionSortRandom.sort(randomData);
                long endTime = System.currentTimeMillis();
                tempResults[k][0] = endTime - startTime;

                // Sorted data
                int[] sortedData = randomData.clone();
                InsertionSort insertionSortSorted = new InsertionSort();
                startTime = System.currentTimeMillis();
                insertionSortSorted.sort(sortedData);
                endTime = System.currentTimeMillis();
                tempResults[k][1] = endTime - startTime;

                // Reversed data
                int[] reversedData = randomData.clone();
                reverseArray(reversedData);
                InsertionSort insertionSortReversed = new InsertionSort();
                startTime = System.currentTimeMillis();
                insertionSortReversed.sort(reversedData);
                endTime = System.currentTimeMillis();
                tempResults[k][2] = endTime - startTime;
            }

            // Calculate average of 10 iterations and store in results array
            for (int j = 0; j < 3; j++) {
                long sum = 0;
                for (int k = 0; k < averageOfN; k++) {
                    sum += tempResults[k][j];
                }
                results[i][j] = sum / averageOfN; // Average of 10 iterations
            }
        }

        return results;
    }

    public long[][] runExperimentsMergeSort(int[] inputSizes, DataReader fullData, String FILE_PATH) {
        long[][] results = new long[inputSizes.length][3]; // Rows: input sizes, Columns: random, sorted, reversed
        int averageOfN = 10;

        for (int i = 0; i < inputSizes.length; i++) {
            int size = inputSizes[i];
            int[] data = fullData.getFlowDurations(size, FILE_PATH);

            long[][] tempResults = new long[10][3]; // Temporary array to store results of each iteration

            for (int k = 0; k < 10; k++) {
                // Random data
                int[] randomData = data.clone();
                MergeSort mergeSortRandom = new MergeSort();
                long startTime = System.currentTimeMillis();
                int[] tempSortedData = mergeSortRandom.sort(randomData);
                long endTime = System.currentTimeMillis();
                tempResults[k][0] = endTime - startTime;

                // Sorted data
                int[] sortedData = tempSortedData.clone();
                MergeSort mergeSortSorted = new MergeSort();
                startTime = System.currentTimeMillis();
                mergeSortSorted.sort(sortedData);
                endTime = System.currentTimeMillis();
                tempResults[k][1] = endTime - startTime;

                // Reversed data
                int[] reversedData = tempSortedData.clone();
                reverseArray(reversedData);
                MergeSort mergeSortReversed = new MergeSort();
                startTime = System.currentTimeMillis();
                mergeSortReversed.sort(reversedData);
                endTime = System.currentTimeMillis();
                tempResults[k][2] = endTime - startTime;
            }

            // Calculate average of 10 iterations and store in results array
            for (int j = 0; j < 3; j++) {
                long sum = 0;
                for (int k = 0; k < averageOfN; k++) {
                    sum += tempResults[k][j];
                }
                results[i][j] = sum / averageOfN; // Average of 10 iterations
            }
        }

        return results;
    }

    public long[][] runExperimentsCountingSort(int[] inputSizes, DataReader fullData, String FILE_PATH) {
        long[][] results = new long[inputSizes.length][3]; // Rows: input sizes, Columns: random, sorted, reversed
        int averageOfN = 10;

        for (int i = 0; i < inputSizes.length; i++) {
            int size = inputSizes[i];
            int[] data = fullData.getFlowDurations(size, FILE_PATH);

            long[][] tempResults = new long[10][3]; // Temporary array to store results of each iteration

            for (int k = 0; k < 10; k++) {
                // Random data
                int[] randomData = data.clone();
                CountingSort countingSortRandom = new CountingSort();
                long startTime = System.currentTimeMillis();
                int[] tempSortedData = countingSortRandom.sort(randomData);
                long endTime = System.currentTimeMillis();
                tempResults[k][0] = endTime - startTime;

                // Sorted data
                int[] sortedData = tempSortedData.clone();
                CountingSort countingSortSorted = new CountingSort();
                startTime = System.currentTimeMillis();
                countingSortSorted.sort(sortedData);
                endTime = System.currentTimeMillis();
                tempResults[k][1] = endTime - startTime;

                // Reversed data
                int[] reversedData = tempSortedData.clone();
                reverseArray(reversedData);
                CountingSort countingSortReversed = new CountingSort();
                startTime = System.currentTimeMillis();
                countingSortReversed.sort(reversedData);
                endTime = System.currentTimeMillis();
                tempResults[k][2] = endTime - startTime;
            }

            // Calculate average of 10 iterations and store in results array
            for (int j = 0; j < 3; j++) {
                long sum = 0;
                for (int k = 0; k < averageOfN; k++) {
                    sum += tempResults[k][j];
                }
                results[i][j] = sum / averageOfN; // Average of 10 iterations
            }
        }

        return results;
    }

    public long[][] runExperimentsLinearSearch(int[] inputSizes, DataReader fullData, String FILE_PATH) {
        long[][] results = new long[inputSizes.length][2]; // Rows: input sizes, Columns: random, sorted
        int averageOfN = 1000;

        for (int i = 0; i < inputSizes.length; i++) {
            int size = inputSizes[i];
            int[] data = fullData.getFlowDurations(size, FILE_PATH);

            long[][] tempResults = new long[1000][2]; // Temporary array to store results of each iteration

            for (int k = 0; k < 1000; k++) {
                // Random data
                int[] randomData = data.clone();
                LinearSearch linearSearchRandom = new LinearSearch();
                int randomNumber = randomData[new Random().nextInt(randomData.length)];
                long startTime = System.nanoTime();
                linearSearchRandom.search(randomData, randomNumber);
                long endTime = System.nanoTime();
                tempResults[k][0] = endTime - startTime;

                // Sorted data
                int[] tempSortedData = randomData.clone();
                MergeSort mergeSort = new MergeSort();
                int[] sortedData = mergeSort.sort(tempSortedData);
                LinearSearch linearSearchSorted = new LinearSearch();
                int randomNumber2 = randomData[new Random().nextInt(randomData.length)];
                startTime = System.nanoTime();
                linearSearchSorted.search(sortedData, randomNumber2);
                endTime = System.nanoTime();
                tempResults[k][1] = endTime - startTime;
            }

            // Calculate average of 1000 iterations and store in results array
            for (int j = 0; j < 2; j++) {
                long sum = 0;
                for (int k = 0; k < averageOfN; k++) {
                    sum += tempResults[k][j];
                }
                results[i][j] = sum / averageOfN; // Average of 1000 iterations
            }
        }

        return results;
    }

    public long[][] runExperimentsBinarySearch(int[] inputSizes, DataReader fullData, String FILE_PATH) {
        long[][] results = new long[inputSizes.length][1]; // Rows: input sizes, Column: sorted
        int averageOfN = 1000;

        for (int i = 0; i < inputSizes.length; i++) {
            int size = inputSizes[i];
            int[] data = fullData.getFlowDurations(size, FILE_PATH);

            long[][] tempResults = new long[1000][1]; // Temporary array to store results of each iteration

            for (int k = 0; k < 1000; k++) {
                // Sorted data
                int[] tempSortedData = data.clone();
                MergeSort mergeSort = new MergeSort();
                int[] sortedData = mergeSort.sort(tempSortedData);
                BinarySearch binarySearchSorted = new BinarySearch();
                long startTime = System.nanoTime();
                binarySearchSorted.search(sortedData, sortedData[new Random().nextInt(sortedData.length)]);
                long endTime = System.nanoTime();
                tempResults[k][0] = endTime - startTime;
            }

            // Calculate average of 1000 iterations and store in results array
            for (int j = 0; j < 1; j++) {
                long sum = 0;
                for (int k = 0; k < averageOfN; k++) {
                    sum += tempResults[k][j];
                }
                results[i][j] = sum / averageOfN; // Average of 1000 iterations
            }
        }

        return results;
    }

    private static void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public void printResults(String title, int[] inputSizes, long[][] results) {
        System.out.println(title);
        System.out.printf("%-10s %-15s %-15s %-15s\n", "Input Size", "Random", "Sorted", "Reversed");
        for (int i = 0; i < inputSizes.length; i++) {
            System.out.printf("%-10d %-15d %-15d %-15d\n", inputSizes[i], results[i][0], results[i][1], results[i][2]);
        }
        System.out.println();
    }

    public void printResultsLinearSearch(String title, int[] inputSizes, long[][] results) {
        System.out.println(title);
        System.out.printf("%-10s %-15s %-15s\n", "Input Size", "Random", "Sorted");
        for (int i = 0; i < inputSizes.length; i++) {
            System.out.printf("%-10d %-15d %-15d\n", inputSizes[i], results[i][0], results[i][1]);
        }
        System.out.println();
    }

    public void printResultsBinarySearch(String title, int[] inputSizes, long[][] results) {
        System.out.println(title);
        System.out.printf("%-10s %-15s\n", "Input Size", "Sorted");
        for (int i = 0; i < inputSizes.length; i++) {
            System.out.printf("%-10d %-15d\n", inputSizes[i], results[i][0]);
        }
        System.out.println();
    }

}
