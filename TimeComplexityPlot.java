/*
 Group Members:
 Bhuwan Bhandari
 Shishir Ghorasainee*/



package com.example.demo;

import javafx.application.Application;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;

public class TimeComplexityPlot extends Application {
    @Override
    public void start(Stage stage) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        stage.setTitle("Sorting Algorithms Time Complexity");

        // Define the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("List Size");
        yAxis.setLabel("Time (ns)");

        // Create the line chart
        final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Sorting Algorithms Time Complexity Analysis");

        // Create series for each sorting algorithm
        XYChart.Series<Number, Number> bubbleSortSeries = new XYChart.Series<>();
        bubbleSortSeries.setName("Bubble Sort");

        XYChart.Series<Number, Number> insertionSortSeries = new XYChart.Series<>();
        insertionSortSeries.setName("Insertion Sort");

        XYChart.Series<Number, Number> selectionSortSeries = new XYChart.Series<>();
        selectionSortSeries.setName("Selection Sort");

        XYChart.Series<Number, Number> mergeSortSeries = new XYChart.Series<>();
        mergeSortSeries.setName("Merge Sort");

        XYChart.Series<Number, Number> quickSortSeries = new XYChart.Series<>();
        quickSortSeries.setName("Quick Sort");

        int iterations = 100;
        //Using plot series method to add series to the chart
        plotSeries(BubbleSort.class, iterations, bubbleSortSeries);
        plotSeries(InsertionSort.class, iterations, insertionSortSeries);
        plotSeries(SelectionSort.class, iterations, selectionSortSeries);
        plotSeries(MergeSort.class, iterations, mergeSortSeries);
        plotSeries(QuickSort.class, iterations, quickSortSeries);

        // Smooth the curves using moving average with window size 5
        bubbleSortSeries = smoothSeries(bubbleSortSeries, 5);
        insertionSortSeries = smoothSeries(insertionSortSeries, 5);
        selectionSortSeries = smoothSeries(selectionSortSeries, 5);
        mergeSortSeries = smoothSeries(mergeSortSeries, 5);
        quickSortSeries = smoothSeries(quickSortSeries, 5);

        // Add series to the chart
        lineChart.getData().addAll(bubbleSortSeries, insertionSortSeries, selectionSortSeries, mergeSortSeries, quickSortSeries);

        // Create a scene and add the chart
        Scene scene = new Scene(lineChart, 800, 600);
        stage.setScene(scene);

        // Show the chart
        stage.show();

        // Add legend
        lineChart.setCreateSymbols(false); // Hide default symbols
        lineChart.setLegendVisible(true);
    }
    //Method that calculates the average time of each sorting algorithm and adds the respective series to the chart.
    public void plotSeries(Class<?> sortingClass,int iterations, XYChart.Series series) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        for (int size = 1; size <= 1000; size++) {
            // Initialize arr with random data or any data you prefer for testing
            int[] arr = generateRandomArray(size);

            long totalTime = 0;
            for (int i = 0; i < iterations; i++){
                long startTime = System.nanoTime();
                sortingClass.getDeclaredMethod("sort", int[].class).invoke(null, arr);// Using the class to sort the array
                long endTime = System.nanoTime();
                long elapsedTimeNanos = endTime - startTime; // Elapsed time in nanoseconds
                totalTime = totalTime+elapsedTimeNanos;

            }

            long avgElapsedTimeNanos = totalTime/iterations;


            series.getData().add(new XYChart.Data<>(size, avgElapsedTimeNanos));
        }
    }
    private int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000);
        }

        return arr;
    }
    //Smoothing the curves using moving average with window size 5.
    private XYChart.Series<Number, Number> smoothSeries(XYChart.Series<Number, Number> series, int windowSize) {
        XYChart.Series<Number, Number> smoothedSeries = new XYChart.Series<>();
        smoothedSeries.setName(series.getName());

        for (int i = 0; i < series.getData().size(); i++) {
            double sum = 0;
            int count = 0;
            for (int j = Math.max(0, i - windowSize / 2); j <= Math.min(i + windowSize / 2, series.getData().size() - 1); j++) {
                sum += series.getData().get(j).getYValue().doubleValue();
                count++;
            }
            double average = sum / count;
            smoothedSeries.getData().add(new XYChart.Data<>(series.getData().get(i).getXValue(), average));
        }

        return smoothedSeries;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

