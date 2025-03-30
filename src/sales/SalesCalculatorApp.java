package sales;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalesCalculatorApp extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField phonePriceField, phoneQuantityField, repairPriceField, repairHoursField;
    private JLabel phoneTotalLabel, repairTotalLabel;

    public SalesCalculatorApp() {
        setTitle("Sales Calculator");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setLayout(new BorderLayout(10, 10));

        // Panel for input fields
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Padding

        // Phone Inputs
        inputPanel.add(new JLabel("Phone Price:"));
        phonePriceField = new JTextField();
        inputPanel.add(phonePriceField);

        inputPanel.add(new JLabel("Quantity Sold:"));
        phoneQuantityField = new JTextField();
        inputPanel.add(phoneQuantityField);

        // Repair Inputs
        inputPanel.add(new JLabel("Repair Price per Hour:"));
        repairPriceField = new JTextField();
        inputPanel.add(repairPriceField);

        inputPanel.add(new JLabel("Hours Worked:"));
        repairHoursField = new JTextField();
        inputPanel.add(repairHoursField);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        JButton calculateButton = new JButton("Calculate Sales");
        calculateButton.setFont(new Font("Arial", Font.BOLD, 14));
        calculateButton.setBackground(new Color(50, 150, 250)); // Blue button
        calculateButton.setForeground(Color.WHITE); // White text
        calculateButton.setFocusPainted(false);
        calculateButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        buttonPanel.add(calculateButton);

        // Results Panel
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(2, 1));
        resultPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        phoneTotalLabel = new JLabel("Phone Total Sales: ₱0.0", JLabel.CENTER);
        phoneTotalLabel.setFont(new Font("Arial", Font.BOLD, 14));
        resultPanel.add(phoneTotalLabel);

        repairTotalLabel = new JLabel("Repair Total Sales: ₱0.0", JLabel.CENTER);
        repairTotalLabel.setFont(new Font("Arial", Font.BOLD, 14));
        resultPanel.add(repairTotalLabel);

        // Button Action
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get input values
                double phonePrice = Double.parseDouble(phonePriceField.getText());
                int phoneQuantity = Integer.parseInt(phoneQuantityField.getText());

                double repairPrice = Double.parseDouble(repairPriceField.getText());
                int repairHours = Integer.parseInt(repairHoursField.getText());

                // Create objects
                PhoneSale phoneSale = new PhoneSale(phonePrice, phoneQuantity);
                RepairService repairService = new RepairService(repairPrice, repairHours);

                // Display results
                phoneTotalLabel.setText("Phone Total Sales: ₱" + phoneSale.calculateTotal());
                repairTotalLabel.setText("Repair Total Sales: ₱" + repairService.calculateTotal());
            }
        });

        // Add Panels to Frame
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(resultPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new SalesCalculatorApp();
    }
}
