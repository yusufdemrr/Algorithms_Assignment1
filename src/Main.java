import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String FILE_PATH = args[0];
        int[] inputSizes = {500, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000, 250000};

        ExperimentRunner experiments = new ExperimentRunner();
        DataReader data = new DataReader();

        long[][] DataResultsInsertion = experiments.runExperimentsInsertionSort(inputSizes, data, FILE_PATH);
        long[][] DataResultsMerge = experiments.runExperimentsMergeSort(inputSizes, data, FILE_PATH);
        long[][] DataResultsCounting = experiments.runExperimentsCountingSort(inputSizes, data, FILE_PATH);
        long[][] DataResultsLinear = experiments.runExperimentsLinearSearch(inputSizes, data, FILE_PATH);
        long[][] DataResultsBinary = experiments.runExperimentsBinarySearch(inputSizes, data, FILE_PATH);

        experiments.printResults("InsertionSort Data Results", inputSizes, DataResultsInsertion);
        experiments.printResults("MergeSort Data Results", inputSizes, DataResultsMerge);
        experiments.printResults("Counting Data Results", inputSizes, DataResultsCounting);
        experiments.printResultsLinearSearch("LinearSearch Data Results", inputSizes, DataResultsLinear);
        experiments.printResultsBinarySearch("BinarySearch Data Results", inputSizes, DataResultsBinary);

        // Generate and save charts
        ChartGenerator.generateChart("Random Data - Insertion, Merge, Counting", inputSizes, DataResultsInsertion, DataResultsMerge, DataResultsCounting, "Random");
        ChartGenerator.generateChart("Sorted Data - Insertion, Merge, Counting", inputSizes, DataResultsInsertion, DataResultsMerge, DataResultsCounting, "Sorted");
        ChartGenerator.generateChart("Reversed Data - Insertion, Merge, Counting", inputSizes, DataResultsInsertion, DataResultsMerge, DataResultsCounting, "Reversed");
        ChartGenerator.generateSearchChart("Search Algorithms - Linear vs Binary", inputSizes, DataResultsLinear, DataResultsBinary);
    }
}