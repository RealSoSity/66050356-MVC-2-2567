import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {

    //Component declaration
    private JTextField textField;
    private JButton ansButton;
    private DefaultTableModel tableModel;
    
    public View(){
        //Set-up Frame
        this.setTitle("Magic Pets Management");
        this.setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        //Set-up Component
        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        JTextField idField = new JTextField();
        JComboBox<String> typeBox = new JComboBox<>(new String[]{"Phoenix", "Dragon", "Owl"});
        JTextField dateField = new JTextField();
        JTextField vaccineField = new JTextField();
        JCheckBox fireProofBox = new JCheckBox("Fire Proof Certificate (Phoenix)");
        JTextField pollutionField = new JTextField("Pollution Level (Dragon)");
        JTextField flightField = new JTextField("Flight Distance (Owl)");
        JButton addButton = new JButton("Add Pet");

        inputPanel.add(new JLabel("ID:")); inputPanel.add(idField);
        inputPanel.add(new JLabel("Type:")); inputPanel.add(typeBox);
        inputPanel.add(new JLabel("Health Check Date:")); inputPanel.add(dateField);
        inputPanel.add(new JLabel("Vaccines:")); inputPanel.add(vaccineField);
        inputPanel.add(fireProofBox);
        inputPanel.add(pollutionField);
        inputPanel.add(flightField);
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.NORTH);

        // Table for displaying pets
        tableModel = new DefaultTableModel(new Object[]{"ID", "Type", "Health Check Date", "Vaccines", "Accepted"}, 0);
        JTable table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Button to show report
        JButton reportButton = new JButton("Show Report");
        add(reportButton, BorderLayout.SOUTH);
    }

    //Get Input(String) from textField
    public String getTextField(){
        return textField.getText();
    }

    //AddActionListener to Button for make it can perform process
    public void addActionListener(ActionListener ae){
        ansButton.addActionListener(ae);
    }

    public void showMessage(String e){
        JOptionPane.showMessageDialog(rootPane, e);
    }

    
}
