import javax.swing.*;
import java.awt.*;

public class FitnessTracker {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Health & Fitness Tracker");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        JLabel burnLabel = new JLabel("Calories Burned:");
        JTextField burnField = new JTextField();
        JLabel intakeLabel = new JLabel("Calories Consumed:");
        JTextField intakeField = new JTextField();

        JButton calcBtn = new JButton("Calculate");
        JTextArea result = new JTextArea();
        result.setEditable(false);

        calcBtn.addActionListener(e -> {
            int burned = Integer.parseInt(burnField.getText());
            int consumed = Integer.parseInt(intakeField.getText());
            int net = consumed - burned;

            result.setText(
                "Calories Burned: " + burned +
                "\nCalories Consumed: " + consumed +
                "\nNet Calories: " + net +
                (net < 2000 ? "\n✅ In deficit, good progress!" : "\n⚠ Surplus, watch diet!")
            );
        });

        panel.add(burnLabel);
        panel.add(burnField);
        panel.add(intakeLabel);
        panel.add(intakeField);
        panel.add(calcBtn);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(result), BorderLayout.CENTER);
        frame.setVisible(true);
}
}