import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.markers.SeriesMarkers;

import java.io.IOException;

public class ChartGenerator {

    public static void generateChart(String title, int[] inputSizes, long[][] insertionResults, long[][] mergeResults, long[][] countingResults, String dataType) throws IOException {
        // Create Chart
        XYChart chart = new XYChartBuilder().width(800).height(600).title(title)
                .yAxisTitle("Time in Nanoseconds").xAxisTitle("Input Size").build();

        // Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);

        int index = 0;
        if (dataType.equals("Sorted")) {
            index = 1;
        } else if (dataType.equals("Reversed")) {
            index = 2;
        }

        // Add series for Insertion Sort
        XYSeries insertionSeries = chart.addSeries("Insertion Sort", inputSizes, getColumn(insertionResults, index));
        insertionSeries.setMarker(SeriesMarkers.CIRCLE);

        // Add series for Merge Sort
        XYSeries mergeSeries = chart.addSeries("Merge Sort", inputSizes, getColumn(mergeResults, index));
        mergeSeries.setMarker(SeriesMarkers.CIRCLE);

        // Add series for Counting Sort
        XYSeries countingSeries = chart.addSeries("Counting Sort", inputSizes, getColumn(countingResults, index));
        countingSeries.setMarker(SeriesMarkers.CIRCLE);

        // Save the chart as PNG
        BitmapEncoder.saveBitmap(chart, title + ".png", BitmapEncoder.BitmapFormat.PNG);
    }


    public static void generateSearchChart(String title, int[] inputSizes, long[][] linearResults, long[][] binaryResults) throws IOException {
        // Create Chart
        XYChart chart = new XYChartBuilder().width(800).height(600).title(title)
                .yAxisTitle("Time in Nanoseconds").xAxisTitle("Input Size").build();

        // Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);

        // Add series for Linear Search - Random Data
        XYSeries linearRandomSeries = chart.addSeries("Linear Search (Random Data)", inputSizes, getColumn(linearResults, 0));
        linearRandomSeries.setMarker(SeriesMarkers.CIRCLE);

        // Add series for Linear Search - Sorted Data
        XYSeries linearSortedSeries = chart.addSeries("Linear Search (Sorted Data)", inputSizes, getColumn(linearResults, 1));
        linearSortedSeries.setMarker(SeriesMarkers.CIRCLE);

        // Add series for Binary Search
        XYSeries binarySeries = chart.addSeries("Binary Search", inputSizes, getColumn(binaryResults, 0));
        binarySeries.setMarker(SeriesMarkers.CIRCLE);

        // Save the chart as PNG
        BitmapEncoder.saveBitmap(chart, title + ".png", BitmapEncoder.BitmapFormat.PNG);
    }

    private static int[] getColumn(long[][] array, int index) {
        int[] column = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            column[i] = (int) array[i][index];
        }
        return column;
    }
}

