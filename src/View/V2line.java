package View;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class V2line extends JFrame {

    public V2line() {

        initUI();
    }

    private void initUI() {
        XYDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);
        pack();
        setTitle("Line chart");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private XYDataset createDataset() {
        XYSeries series1 = new XYSeries("2022");
        series1.add(1, 3);
        series1.add(2, 2);
        series1.add(3, 1);
        series1.add(4, 1);
        series1.add(7, 1);
        series1.add(8, 2);
        series1.add(9, 2);
        series1.add(12,0);

        XYSeries series2 = new XYSeries("2023");
        series2.add(1,0);
        series2.add(3, 2);
        series2.add(4, 2);
        series2.add(7, 1);
        series2.add(8, 1);
        series2.add(9, 4);
        series2.add(10, 7);
        series2.add(11, 7);
        series2.add(12, 4);
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        return dataset;
    }

    private JFreeChart createChart(final XYDataset dataset) {
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Average borrow records per month",
                "month",
                "borrow records",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesStroke(1, new BasicStroke(2.0f));
        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);
        plot.setRangeGridlinesVisible(false);
        plot.setDomainGridlinesVisible(false);
        chart.getLegend().setFrame(BlockBorder.NONE);
        chart.setTitle(new TextTitle("Average borrow records per month",
                        new Font("Serif", Font.BOLD, 18)
                )
        );
        return chart;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            V2line ex = new V2line();
            ex.setVisible(true);
        });
    }
}


