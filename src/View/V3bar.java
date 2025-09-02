package View;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class V3bar extends JFrame {
    public V3bar() {
        initUI();
    }
    private void initUI() {
        CategoryDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("Bar chart");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private CategoryDataset createDataset() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(1, "registers number", "2020");
        dataset.setValue(2, "registers number", "2021");
        dataset.setValue(2, "registers number", "2022");
        dataset.setValue(4, "registers number", "2023");
        dataset.setValue(3, "registers number", "2024");
        return dataset;
    }
    private JFreeChart createChart(CategoryDataset dataset) {
        JFreeChart barChart = ChartFactory.createBarChart(
                "Year registers",
                "",
                "registers number",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);
        return barChart;
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            V3bar ex = new V3bar();
            ex.setVisible(true);
        });
    }
}


