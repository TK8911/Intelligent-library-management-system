package View;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class V1pie extends JFrame {

    public V1pie() {

        initUI();
    }

    private void initUI() {

        DefaultPieDataset dataset = createDataset();

        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("Pie chart");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private DefaultPieDataset createDataset() {

        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("science fiction", 8);
        dataset.setValue("history", 3);
        dataset.setValue("literacy", 3);
        dataset.setValue("Math", 3);
        dataset.setValue("psychology", 2);
        dataset.setValue("physics", 3);
        dataset.setValue("computer", 3);
        dataset.setValue("novel",2);//27
        dataset.setValue("finance",2);
        dataset.setValue("philosophy",2);
        dataset.setValue("Others",3 );

        return dataset;
    }

    private JFreeChart createChart(DefaultPieDataset dataset) {

        JFreeChart barChart = ChartFactory.createPieChart(
                "Book Types Proportion",
                dataset,
                false, true, false);

        return barChart;
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            V1pie ex = new V1pie();
            ex.setVisible(true);
        });
    }
}


