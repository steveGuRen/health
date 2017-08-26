package com.health;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import org.knowm.xchart.style.Styler.LegendPosition;

import com.health.utils.chart.SbBitmapEncoder;
import com.health.utils.chart.SbBitmapEncoder.BitmapFormat;
import com.health.utils.chart.SbChart;
import com.health.utils.chart.SbChartBuilder;

public class ChartTest {
	
	public static void main(String[] args) throws Exception {
		    // Create Chart
			SbChart chart = new SbChartBuilder().width(800).height(600).build();
		    chart.setTitle("Sample Chart");
		    chart.setXAxisTitle("X");
		    chart.setYAxisTitle("Y");
		    
		    // Customize Chart
		    chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Scatter);
		    chart.getStyler().setChartTitleVisible(false);
		    chart.getStyler().setLegendPosition(LegendPosition.InsideSW);
		    chart.getStyler().setMarkerSize(16);
		    chart.getStyler().setChartBackgroundColor(new Color(222, 222, 222));
		    // Series
		    List<Double> xData = new LinkedList<Double>();
		    List<Double> yData = new LinkedList<Double>();
		    Random random = new Random();
		    
		    int size = 100;
		    
		    xData.add(5d);
		    yData.add(5d);
		    
		    xData.add(20d);
		    yData.add(20d);
		    
		    xData.add(21d);
		    yData.add(21d);
		    
		    xData.add(22d);
		    yData.add(22d);
		    
		    xData.add(23d);
		    yData.add(23d);
		    
		    xData.add(20d);
		    yData.add(30d);		    
		    
		    xData.add(40d);
		    yData.add(40d);
		    
		    xData.add(60d);
		    yData.add(60d);
		    
		    xData.add(100d);
		    yData.add(100d);
		    
		    chart.addSeries("Gaussian Blob", xData, yData);
		    
		    
//		    SbBitmapEncoder.saveBitmap(chart, "D:/data/imp1.png", BitmapFormat.PNG);
//		    SbBitmapEncoder.saveBitmap(chart, "D:/data/imp2.jpg", BitmapFormat.JPG);
//		    SbBitmapEncoder.saveJPGWithQuality(chart, "D:/data/imp3.jpg", 0.95f);
//		    SbBitmapEncoder.saveBitmap(chart, "D:/data/imp4.bmp", BitmapFormat.BMP);
//		    SbBitmapEncoder.saveBitmap(chart, "D:/data/imp5.gif", BitmapFormat.GIF);
		    SbBitmapEncoder.saveBitmapWithDPI(chart, "D:/data/imp6.png", BitmapFormat.PNG, 300);
//		    SbBitmapEncoder.saveBitmapWithDPI(chart, "D:/data/imp7.jpg", BitmapFormat.JPG, 300);
//		    SbBitmapEncoder.saveBitmapWithDPI(chart, "D:/data/imp8.gif", BitmapFormat.GIF, 300);
//		    VectorGraphicsEncoder.saveVectorGraphic(chart, "D:/data/imp9.eps", VectorGraphicsFormat.EPS);
//		    VectorGraphicsEncoder.saveVectorGraphic(chart, "D:/data/imp10.pdf", VectorGraphicsFormat.PDF);
//		    VectorGraphicsEncoder.saveVectorGraphic(chart, "D:/data/imp11.svg", VectorGraphicsFormat.SVG);
	}
	
	
}
