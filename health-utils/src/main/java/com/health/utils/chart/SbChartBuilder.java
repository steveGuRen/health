package com.health.utils.chart;

import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.internal.ChartBuilder;

/**
 * @author timmolter
 */
public class SbChartBuilder extends ChartBuilder<SbChartBuilder, SbChart> {

  String xAxisTitle = "";
  String yAxisTitle = "";

  public SbChartBuilder() {

  }

  public SbChartBuilder xAxisTitle(String xAxisTitle) {

    this.xAxisTitle = xAxisTitle;
    return this;
  }

  public SbChartBuilder yAxisTitle(String yAxisTitle) {

    this.yAxisTitle = yAxisTitle;
    return this;
  }

  /**
   * return fully built XYChart
   *
   * @return a XYChart
   */
  @Override
  public SbChart build() {
    return new SbChart(this);
  }
}