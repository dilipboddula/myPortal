package com.awards;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.data.general.DefaultPieDataset;
import java.io.File;
public class PieChartExample {
public static void main(String[] args) {
// Create a simple pie chart
	int a=5000;
	String name="rammmm";
	
DefaultPieDataset pieDataset = new DefaultPieDataset();
pieDataset.setValue(name, new Integer(a));
pieDataset.setValue("ram", new Integer(600));
pieDataset.setValue("raju", new Integer(1000));
pieDataset.setValue("killu", new Integer(5000));
JFreeChart chart = ChartFactory.createPieChart
("CSC408 Mark Distribution", // Title
pieDataset, // Dataset
true, // Show legend
true, // Use tooltips
false // Configure chart to generate URLs?
);
try {
ChartUtilities.saveChartAsJPEG(new File("C:\\Users\\dboddu\\JEE\\Sapient\\WebContent\\graphs\\"+name+".jpg"), chart, 500, 300);
} catch (Exception e) {
System.out.println("Problem occurred creating chart.");
}
}
}
