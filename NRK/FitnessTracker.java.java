import javax.swing.*;
import java.awt.*;

public class FinanceDashboard {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Personal Finance Dashboard");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        JLabel incomeLabel = new JLabel("Monthly Income:");
        JTextField incomeField = new JTextField();
        JLabel expenseLabel = new JLabel("Monthly Expenses:");
        JTextField expenseField = new JTextField();
        JLabel investLabel = new JLabel("Monthly Investments:");
        JTextField investField = new JTextField();

        JButton calculateBtn = new JButton("Calculate");
        JTextArea result = new JTextArea();
        result.setEditable(false);

        calculateBtn.addActionListener(e -> {
            double income = Double.parseDouble(incomeField.getText());
            double expenses = Double.parseDouble(expenseField.getText());
            double invest = Double.parseDouble(investField.getText());
            double savings = income - (expenses + invest);

            result.setText(
                "Income: " + income +
                "\nExpenses: " + expenses +
                "\nInvestments: " + invest +
                "\nNet Savings: " + savings +
                (savings < 0 ? "\n⚠ Overspending!" : "\n✅ Saving well!")
            );
        });

        panel.add(incomeLabel);
        panel.add(incomeField);
        panel.add(expenseLabel);
        panel.add(expenseField);
        panel.add(investLabel);
        panel.add(investField);
        panel.add(calculateBtn);
        panel.add(new JLabel());

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(result), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}